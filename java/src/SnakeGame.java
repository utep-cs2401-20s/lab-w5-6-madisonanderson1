public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame (){
        game = new boolean[][]{{false}};
    }

    public SnakeGame(boolean[][] array, int x, int y){
        for (int i = 0; i<array.length; i++){
            for (int j = 0; j<array[0].length; j++){
                game[i][j] = array[i][j];
            }
        }
        int[] headPosition = {x,y};
    }

    public int[] findTailExhaustive(){
        int length=0;
        int tailRow,tailCol;
        int[] tail = new int[3];
        for (int row = 0; row<game.length; row++){
            for (int col = 0; col<game[0].length; col++){
                exhaustiveChecks += 1;
                if(game[row][col] == true){
                    length += 1;
                    if (row != headPosition[0] && col != headPosition[1]) {
                        int neighbors = 0;
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
                        if (neighbors == 1) {
                            tail[0] = row;
                            tail[1] = col;
                        }
                    }
                }
            }
        }
        tail[3] = length;
        return tail;
    }



}
