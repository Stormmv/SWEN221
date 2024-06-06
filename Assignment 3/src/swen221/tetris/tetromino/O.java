package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

public class O extends Tetromino{
  public O(int x, int y, Color color) {
	super(x, y, color);/*TODO: complete this code*/
    
  }

  @Override
  public int x(int i) {/*TODO: complete this code*/
	// The x-coordinate for O tetromino is a simple pattern
      if (i == 0 || i == 3) {
          return centerX() + 0;
      } else {
          return centerX() + 1;
      }    
  }

  @Override
  public int y(int i) {/*TODO: complete this code*/
	// The y-coordinate for O tetromino is a simple pattern
      if (i == 0 || i == 1) {
          return centerY() + 0;
      } else {
          return centerY() + 1;
      }
  }

  @Override
  public void rotateRight() {/*TODO: complete this code*/
	  
  }
  //TODO: add more methods if needed
}
