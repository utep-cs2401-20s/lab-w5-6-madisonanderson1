import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SnakeGameTester {
  @Test
  public void testRecursive1(){
    boolean[][] test =
            {{true, true, true, false},
            {true, false, true, false},
            {true, false, true, false},
            {true, false, true, false}
    };
    //inital test I want to see if there is any problems then go from there
    SnakeGame snake = new SnakeGame(test, 3, 0);
    int[] expected = {3,2,9};
    assertArrayEquals(expected, snake.findTailRecursive()); //test passed on first try
  }

    @Test
    public void testRecursive2(){
        boolean[][] test =
                {{true, true, true, false},
                        {true, false, true, false},
                        {true, false, true, false},
                        {true, false, true, false}
                };
        //want to try same array but with a different head position
        SnakeGame snake = new SnakeGame(test, 3, 2);
        int[] expected = {3,0,9};
        assertArrayEquals(expected, snake.findTailRecursive()); //test passed on first try
    }

    @Test
    public void testRecursive3(){
        boolean[][] test =
                {{true, true, true, false},
                        {false, false, false, false},
                        {false, false, false, false},
                        {false, false, false, false}
                };
        //Array of the same size but different size snake and head positiion
        SnakeGame snake = new SnakeGame(test, 0, 0);
        int[] expected = {0,2,3};
        assertArrayEquals(expected, snake.findTailRecursive()); //test passed on first try
    }

    @Test
    public void testRecursive4(){
        boolean[][] test =
                {{true, true, true},
                        {false, false, false},
                        {false, false, false}
                };
        //Array of the different size but same size snake and head positiion
        SnakeGame snake = new SnakeGame(test, 0, 0);
        int[] expected = {0,2,3};
        assertArrayEquals(expected, snake.findTailRecursive()); //test passed on first try
    }

    @Test
    public void testRecursive5(){
        boolean[][] test =
                {{true, true, true},
                        {false, false, true},
                        {false, false, false}
                };
        //new snake and different head position
        SnakeGame snake = new SnakeGame(test, 0, 0);
        int[] expected = {1,2,4};
        assertArrayEquals(expected, snake.findTailRecursive()); //test passed on first try
    }

    @Test
    public void testExhaustive1(){
        boolean[][] test =
                {{true, true, true},
                        {false, false, true},
                        {false, false, false}
                };
        //trying previous snake with different method and wanting the same result
        SnakeGame snake = new SnakeGame(test, 0, 0);
        int[] expected = {1,2,4};
        assertArrayEquals(expected, snake.findTailExhaustive()); //test passed on first try
    }

    @Test
    public void testExhaustive2(){
        boolean[][] test =
                {{false, true, true},
                        {false, false, true},
                        {false, false, false}
                };
        //trying different snake with different method and different head position
        SnakeGame snake = new SnakeGame(test, 1, 2);
        int[] expected = {0,1,3};
        assertArrayEquals(expected, snake.findTailExhaustive()); //test passed on first try
    }

    @Test
    public void testExhaustive3(){
        boolean[][] test =
                {{false, true, true, false},
                        {false, false, true, false},
                        {false, false, true, false},
                        {false, false, true, false}
                };
        //trying a larger array and new snake
        SnakeGame snake = new SnakeGame(test, 0, 1);
        int[] expected = {3,2,5};
        assertArrayEquals(expected, snake.findTailExhaustive()); //test passed on first try
    }

    @Test
    public void testExhaustive4(){
        boolean[][] test =
                {{false, true, true, false},
                        {false, false, true, false},
                        {false, false, true, false},
                        {false, false, true, false}
                };
        //trying a larger array and new head position
        SnakeGame snake = new SnakeGame(test, 3, 2);
        int[] expected = {0,1,5};
        assertArrayEquals(expected, snake.findTailExhaustive()); //test passed on first try
    }

    @Test
    public void testExhaustive5(){
        boolean[][] test =
                {{true, true, true, false},
                        {true, false, true, false},
                        {false, false, true, false},
                        {false, false, true, false}
                };
        //new snake shape and head position
        SnakeGame snake = new SnakeGame(test, 1, 0);
        int[] expected = {3,2,7};
        assertArrayEquals(expected, snake.findTailExhaustive()); //test passed on first try and recieved expected
    }

}
