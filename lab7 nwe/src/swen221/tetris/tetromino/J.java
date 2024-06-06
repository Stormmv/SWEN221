package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

public class J extends Tetromino{
	boolean horizontal= true;
  public J(int x, int y, Color color) {
	  super(x, y, color);/*TODO: complete this code*/
  }

  @Override
  public int x(int i) {/*TODO: complete this code*/
	  if (horizontal) {
          return centerX() + xOffset(i);
      }
      return centerX() + yOffset(i) * -1;
  }

  @Override
  public int y(int i) {/*TODO: complete this code*/
	  if (horizontal) {
          return centerY() - yOffset(i);
      }
      return centerY() + xOffset(i);
  }

  public int xOffset(int i) {
	  if (i < 3) {
          return i - 1;
      }
      return 1;
          
  }
  
  public int yOffset(int i) {
	  if (i < 3) {
          return 0;
      }
      return i - 2;
  }

  @Override
  public void rotateRight() {/*TODO: complete this code*/
	  horizontal =! horizontal;
  }
  
  //TODO: add more methods if needed
}