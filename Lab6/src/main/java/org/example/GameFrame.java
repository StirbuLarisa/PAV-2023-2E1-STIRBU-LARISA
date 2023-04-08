package org.example;
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private JPanel configPanel;
    private JPanel canvasPanel;
    private JPanel controlPanel;

    public GameFrame() {

        setTitle("Positional Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        configPanel = new JPanel();
        JLabel numDotsLabel = new JLabel("Number of Dots:");
        JLabel probLinesLabel = new JLabel("Probability of Line:");
        JButton newGameButton = new JButton("New Game");

        JSpinner numDotsField = new JSpinner(new SpinnerNumberModel(5,3,10,1));
        JComboBox<Double> linesCombo = new JComboBox<>(new Double[]{1.0, 1.1, 1.2, 1.3, 1.4});


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
                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int radius = Math.min(getWidth(), getHeight()) / 3;
                // Draw dot
                int x = (int) (centerX + radius * Math.cos(0 ));
                int y = (int) (centerY + radius * Math.sin(0 ));
                g.setColor(Color.BLACK);
                g.fillOval(x - 5, y - 5, 10, 10);
            }
        };
        add(canvasPanel, BorderLayout.CENTER);


        controlPanel = new JPanel();
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");
        controlPanel.add(loadButton);
        controlPanel.add(saveButton);
        controlPanel.add(exitButton);
        add(controlPanel, BorderLayout.SOUTH);

        // Show the frame
        setVisible(true);
    }
}
