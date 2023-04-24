import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class GameFrame extends JFrame {

    private JPanel configPanel;
    private JPanel canvasPanel;
    private JPanel controlPanel;
    private Board board;
    private Game game;
    private Player currentPlayer;

    public GameFrame() {

        setTitle("Positional Game");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        configPanel = new JPanel();
        JLabel numDotsLabel = new JLabel("Number of Dots:");
        JLabel probLinesLabel = new JLabel("Probability of Line:");
        JButton newGameButton = new JButton("New Game");

        JSpinner numDotsField = new JSpinner(new SpinnerNumberModel(5, 3, 10, 1));
        JComboBox<Double> linesCombo = new JComboBox<>(new Double[]{1.0, 0.9, 0.8, 0.7, 0.5});

        configPanel.add(numDotsLabel);
        configPanel.add(numDotsField);
        configPanel.add(probLinesLabel);
        configPanel.add(linesCombo);
        configPanel.add(newGameButton);
        add(configPanel, BorderLayout.NORTH);

        canvasPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (board != null) {
                    board.draw(g);
                }
            }
        };
        canvasPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e);
            }
        });
        add(canvasPanel, BorderLayout.CENTER);

        controlPanel = new JPanel();
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");
        JButton pngButton = new JButton("ExportPng");
        controlPanel.add(loadButton);
        controlPanel.add(saveButton);
        controlPanel.add(exitButton);
        controlPanel.add(pngButton);
        add(controlPanel, BorderLayout.SOUTH);

        newGameButton.addActionListener(e -> {
            int numDots = (int) numDotsField.getValue();
            double probLines = (double) linesCombo.getSelectedItem();
            board = new Board(numDots, probLines);
            game = new Game(board, new Player("Red", LineColor.RED), new Player("Blue", LineColor.BLUE));
            currentPlayer = game.getCurrentPlayer();
            repaint();
        });

        loadButton.addActionListener(e -> {
            try {
                FileInputStream fileIn = new FileInputStream("game.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                game = (Game) in.readObject();
                board = game.getBoard();
                currentPlayer = game.getCurrentPlayer();
                repaint();
                JOptionPane.showMessageDialog(this, "Game loaded successfully!");
                in.close();
                fileIn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        saveButton.addActionListener(e -> {
            try {
                FileOutputStream fileOut = new FileOutputStream("game.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(game);
                JOptionPane.showMessageDialog(this, "Game saved successfully!");
                out.close();
                fileOut.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        pngButton.addActionListener(e -> {
            try {
                BufferedImage image = new BufferedImage(canvasPanel.getWidth(), canvasPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = image.createGraphics();
                canvasPanel.paint(g2d);
                g2d.dispose();
                File file = new File("board.png");
                ImageIO.write(image, "png", file);
                JOptionPane.showMessageDialog(this, "Board saved as board.png");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        setVisible(true);
    }

    private void handleMouseClick(MouseEvent e) {
        if (board != null && currentPlayer != null) {
            Line line = board.getLineAt(e.getX(), e.getY(),10);
            if (line != null && line.getColor() == LineColor.GRAY) {
                line.setColor(currentPlayer.getColor());
                int gameStatus=game.checkWin(currentPlayer);
                if (gameStatus==1) {
                    JOptionPane.showMessageDialog(this, currentPlayer.getName() + " wins!");
                    board.clear();
                    currentPlayer = null;
                } else if(gameStatus==0) {
                    currentPlayer = game.switchPlayer();
                }
                else if(gameStatus==2){
                    board.clear();
                    currentPlayer = null;
                }
                repaint();
            }
        }
    }
}