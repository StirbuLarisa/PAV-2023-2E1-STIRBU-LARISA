import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
        return currentPlayer;
    }

    // castiga primul care a facut trinunghi
    public int checkWin(Player player) {
        Dot dot1=null,dot2=null;
        ArrayList<Line> playerLines = new ArrayList<>();
        for (Line line : board.getLines()) {
            if (line.getColor() == player.getColor()) {
                playerLines.add(line);
            }
        }
        for (int i = 0; i < playerLines.size(); i++) {
            Line line1 = playerLines.get(i);
            for (int j = i + 1; j < playerLines.size(); j++) {
                Line line2 = playerLines.get(j);
                Dot sharedDot = line1.getSharedDot(line2);
                if (sharedDot != null) {
                    for (Line line3 : playerLines) {
                        if (line3 != line1 && line3 != line2) {
                            if (line3.hasDot(line1.getOtherDot(sharedDot)) &&
                                    line3.hasDot(line2.getOtherDot(sharedDot))) {
                                // We have a winner!
                                return 1;
                            }
                        }
                    }
                }
            }
        }
        if (board.isFull()) {
            JOptionPane.showMessageDialog(null, "It's a tie!");
            return 2;
        }
        return 0;
    }
}