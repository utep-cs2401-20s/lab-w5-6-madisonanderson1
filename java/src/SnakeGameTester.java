import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SnakeGameTester {
  @Test
  public void testRecursive(){
    boolean[][] test =
            {{true, true, true, false},
            {true, false, true, false},
            {true, false, true, false},
            {true, false, true, false}
    };
    SnakeGame snake = new SnakeGame(test, 3, 0);
    int[] expected = {3,2,9};
    assertArrayEquals(expected, snake.findTailRecursive());

  }


}
