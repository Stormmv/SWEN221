package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

public class O extends Tetromino{
  public O(int x, int y, Color color) {
	  super(x, y, color);
    
  }

  @Override
  public int x(int i) {/*TODO: complete this code*/
  //HINT you may want to use some paper and
  //make diagrams like those for all the tetrominos
    if (i % 2 == 1) {
		  return centerX();
	  }
	  else {
		  return centerX() + 1;
	  }
 /* x y
  0 0 0
  1 1 0
  2 0 1
  3 1 1*/        
  }

  @Override
  public int y(int i) {/*TODO: complete this code*/
	  if (i >= 2) {
		  return centerY() + 1;
	  } else {
		  return centerY();
	  }
  }

  @Override
  public void rotateRight() {/*TODO: complete this code*/
	  return;
  }
  //TODO: add more methods if needed
}
