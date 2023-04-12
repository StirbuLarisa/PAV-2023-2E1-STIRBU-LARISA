package org.example;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        int n = 5;
        int[][] map = new int[n][n];
        int[] tokens = new int[n * n * n];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = i + 1;
        }
        shuffleTokens(tokens);
        boolean[][] visited = new boolean[n][n];
        Lock lock = new ReentrantLock();
        RobotExplorer[] robots = new RobotExplorer[4];
        for (int i = 0; i < robots.length; i++) {
            robots[i] = new RobotExplorer("Robot " + (i + 1), map, tokens, visited, lock);
            Thread thread = new Thread(robots[i]);
            thread.start();
        }
    }

    private static void shuffleTokens(int[] tokens) {
        Random rand = new Random();
        for (int i = tokens.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = tokens[i];
            tokens[i] = tokens[j];
            tokens[j] = temp;
        }
    }
}