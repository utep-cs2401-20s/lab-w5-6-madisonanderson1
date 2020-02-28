public class SnakeGame {
    private boolean[][] game;
    int[] headPosition = new int[2];
    private static int exhaustiveChecks;
    private static int recursiveChecks;


    public static void main(String[] args) {
        boolean[][] test = {{true, true, true, false},
                {true, false, true, false},
                {true, false, true, false},
                {true, false, true, false}
        };

        SnakeGame snake = new SnakeGame(test, 3, 0);
        // System.out.println(snake.findTailExhaustive());
        for (int i = 0; i < snake.findTailExhaustive().length; i++) {
            System.out.println(snake.findTailExhaustive()[i]);
        }
    }

    public SnakeGame() {
        game = new boolean[][]{{false}};
    }

    public SnakeGame(boolean[][] array, int x, int y) {
        int colSize = array.length;
        int rowSize = array[0].length;

        this.game = new boolean[colSize][rowSize];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                game[i][j] = array[i][j];
            }
        }
        this.headPosition = new int[2];
        headPosition[0] = x;
        headPosition[1] = y;
    }

    public int[] findTailExhaustive() {
        // reset counter
        int length = 0;
        int tailRow = -1;
        int tailCol = -1;
        int[] tail = new int[3];
        for (int row = 0; row < game.length; row++) {
            for (int col = 0; col < game[0].length; col++) {
                exhaustiveChecks += 1;
                if (game[row][col] == true) {
                    length += 1;
                    if (neighbors(row, col) == 1 && headPosition[0] != row || headPosition[1] != col) {
                        tailRow = row;
                        tailCol = col;
                    }
                }
            }
        }
        tail[0] = tailRow;
        tail[1] = tailCol;
        tail[2] = length;
        return tail;
    }

    public int neighbors(int row, int col) {
        int neighbors = 0;
        if (row != headPosition[0] && col != headPosition[1]) {
            if (row - 1 >= 0 && row - 1 < game.length) {
                if (game[row - 1][col] == true) {
                    neighbors += 1;
                }
            }
            if (col - 1 >= 0 && col - 1 < game.length) {
                if (game[row][col - 1] == true) {
                    neighbors += 1;
                }
            }
            if (col + 1 >= 0 && col + 1 < game.length) {
                if (game[row][col + 1] == true) {
                    neighbors += 1;
                }
            }
            if (row + 1 >= 0 && row + 1 < game.length) {
                if (game[row + 1][col] == true) {
                    neighbors += 1;
                }
            }
        }
        return neighbors;
    }


    public int[] findTailRecursive() {
        return findTailRecursive(headPosition, headPosition);
    }

    public int[] findTailRecursive(int[] previousPosition, int[] currentPosition) {
        int length = 0;
        int row = previousPosition[0];
        int col = previousPosition[1];
        int[] cp = new int[2];
        int tailRow = -1;
        int tailCol = -1;
        int[] tail = new int[3];
        if (row - 1 >= 0 && row - 1 < game.length) {
            if (game[row - 1][col] == true) {
                length = length + 1;
                if ((neighbors(row-1, col) < 2) && (row - 1) != headPosition[0] || col != headPosition[1]) {
                    tail[0] = row - 1;
                    tail[1] = col;
                    tail[2] = length;
                    return tail;
                }
                cp[0] = row - 1;
                cp[1] = col;
                findTailRecursive(currentPosition, cp);
            }
        }
        if (col - 1 >= 0 && col - 1 < game.length) {
            if (game[row][col - 1] == true) {
                if (row != previousPosition[0] || (col -1) != previousPosition[1]) {
                    length = length + 1;
                    if ((neighbors(row,col-1) <2) && (row) != headPosition[0] || col - 1 != headPosition[1]) {
                        tail[0] = row;
                        tail[1] = col - 1;
                        tail[2] = length;
                        return tail;
                    }
                    cp[0] = row;
                    cp[1] = col - 1;
                    findTailRecursive(currentPosition, cp);
                }
            }
        }
        if (col + 1 >= 0 && col + 1 < game.length) {
            if (game[row][col + 1] == true) {
                if (row != previousPosition[0] || (col +1) != previousPosition[1]) {
                    length = length + 1;
                    if ((neighbors(row, col+1)<2) && (row != headPosition[0] || (col + 1) != headPosition[1])) {
                        tail[0] = row;
                        tail[1] = col + 1;
                        tail[2] = length;
                        return tail;
                    }
                    cp[0] = row;
                    cp[1] = col + 1;
                    findTailRecursive(currentPosition, cp);
                }
            }
        }
        if (row + 1 >= 0 && row + 1 < game.length) {
            if (game[row + 1][col] == true) {
                if ((row + 1) != previousPosition[0] || col != previousPosition[1]) {
                    length = length + 1;
                    if ((neighbors(row+1, col)<2) && ((row + 1) != headPosition[0] || col != headPosition[1])) {
                        tail[0] = row + 1;
                        tail[1] = col;
                        tail[2] = length;
                        return tail;
                    }
                    cp[0] = row + 1;
                    cp[1] = col;
                    findTailRecursive(currentPosition, cp);
                }
            }
        }
        return tail;
    }


}
