package org.example;
import java.lang.Runnable;
import java.util.Random;
import java.util.concurrent.locks.Lock;


public class RobotExplorer implements Runnable{

    private String name;
    private int[][] map;
    private int n;
    private int[] tokens;
    private boolean[][] visited;
    private Lock lock;

    public RobotExplorer(String name, int[][] map, int[] tokens, boolean[][] visited, Lock lock) {
        this.name = name;
        this.map = map;
        this.n = map.length;
        this.tokens = tokens;
        this.visited = visited;
        this.lock = lock;
    }

    public void run() {
        Random rand = new Random();
        int x = rand.nextInt(n);
        int y = rand.nextInt(n);
        while (!allVisited()) {
            if (!isVisited(x,y)) {
                visitCell(x, y);
                int[] extractedTokens = extractTokens();
                storeTokens(x, y, extractedTokens);
            }
            x = (x + rand.nextInt(3) - 1 + n) % n;
            y = (y + rand.nextInt(3) - 1 + n) % n;
        }
        System.out.println(name + " a terminat explorarea.");
    }

    private boolean allVisited() {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        } finally {
            lock.unlock();
        }
    }
    private boolean isVisited(int x, int y) {
        lock.lock();
        try {
            return visited[x][y];
        } finally {
            lock.unlock();
        }
    }


    private void visitCell(int x, int y) {

        lock.lock();
        try {
            visited[x][y] = true;
            System.out.println(name + " a vizitat casuta (" + x + "," + y + ").");
        } finally {
            lock.unlock();
        }
    }

    private int[] extractTokens() {
        int[] extractedTokens = new int[n];
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                extractedTokens[i] = tokens[i];
            }
            shuffleTokens();
        } finally {
            lock.unlock();
        }
        return extractedTokens;
    }

    private void shuffleTokens() {
        Random rand = new Random();
        for (int i = tokens.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = tokens[i];
            tokens[i] = tokens[j];
            tokens[j] = temp;
        }
    }

    private void storeTokens(int x, int y, int[] extractedTokens) {
        for (int i = 0; i < n; i++) {
            map[x][y] += extractedTokens[i];
        }
    }

}
