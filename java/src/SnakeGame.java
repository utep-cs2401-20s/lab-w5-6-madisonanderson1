public class SnakeGame {
    private boolean[][] game;
    int[] headPosition = new int[2];
    private static int exhaustiveChecks;
    private static int recursiveChecks;
    int lengthR = 0;
    public static void main(String[] args) {

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


    public void resetCounters(){
        recursiveChecks = 0;
        exhaustiveChecks = 0;
    }

    public static int getExhaustiveChecks() {
        return exhaustiveChecks;
    }

    public static int getRecursiveChecks() {
        return recursiveChecks;
    }

    public int[] findTailExhaustive() {
        resetCounters();
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
        if (row != headPosition[0] || col != headPosition[1]) {
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
        resetCounters();
        return findTailRecursive(headPosition, headPosition);
    }


    public int[] findNeighborPosition(int[] previousPosition, int[] currentPosition){
        int cRow = currentPosition[0];
        int cCol = currentPosition[1];
        int pRow = previousPosition[0];
        int pCol = previousPosition[1];
        int[] position = new int[2];
        if (cRow - 1 >= 0 && cRow - 1 < game.length) {
            if (game[cRow - 1][cCol] == true && (cRow - 1 != pRow || cCol != pCol)) {
                position[0] = cRow - 1;
                position[1] = cCol;
                return position;
            }
        }
        if (cRow + 1 >= 0 && cRow + 1 < game.length) {
            if (game[cRow + 1][cCol] == true && (cRow + 1 != pRow || cCol != pCol)) {
                position[0] = cRow + 1;
                position[1] = cCol;
                return position;
            }
        }
        if (cCol - 1 >= 0 && cCol - 1 < game.length) {
            if (game[cRow][cCol - 1] == true && (cRow != pRow || cCol - 1 != pCol)) {
                position[0] = cRow;
                position[1] = cCol - 1;
                return position;
            }
        }
        if (cCol + 1 >= 0 && cCol + 1 < game.length) {
            if (game[cRow][cCol + 1] == true && (cRow != pRow || cCol + 1 != pCol)) {
                position[0] = cRow;
                position[1] = cCol + 1;
                return position;
            }
        }
        return position;
    }


    public int[] findTailRecursive(int[] previousPosition, int[] currentPosition) {
        int[] tail = new int[3];
        if(currentPosition[0] == headPosition[0] && currentPosition[1] == headPosition[1]){
            lengthR = 1;
            int[] position = findNeighborPosition(previousPosition, currentPosition);
            recursiveChecks ++;
            return findTailRecursive(currentPosition, position);
        }else if(neighbors(currentPosition[0],currentPosition[1])>=2){
            lengthR++;
            int[] position = findNeighborPosition(previousPosition, currentPosition);
            recursiveChecks++;
            return findTailRecursive(currentPosition, position);
        } else if(neighbors(currentPosition[0],currentPosition[1]) < 2){
            recursiveChecks++;
            lengthR++;
            tail[0] = currentPosition[0];
            tail[1] = currentPosition[1];
            tail[2] = lengthR;
            return tail;
        }
        return tail;
    }


}
