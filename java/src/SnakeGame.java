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

    
}
