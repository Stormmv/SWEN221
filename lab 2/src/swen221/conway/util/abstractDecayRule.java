// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.conway.util;

import swen221.conway.model.*;

/**
 * new rules for the decay version. adds the cell state and range of decay from 0 being the youngest to 9 being dead.
 */
public abstract class abstractDecayRule implements Rule{
	public final static int ALIVE = 0;
	public final static int ALIVE1 = 1;
	public final static int ALIVE2 = 2;
	public final static int ALIVE3 = 3;
	public final static int ALIVE4 = 4;
	public final static int ALIVE5 = 5;
	public final static int ALIVE6 = 6;
	public final static int ALIVE7 = 7;
	public final static int ALIVE8 = 8;
	public final static int DEAD = 9;
	
	@Override
	public int apply(int x, int y, BoardView board) {
		int count = 0;
		
		// top row
		count += getNumAlive(x-1,y-1,board);
		count += getNumAlive(x,y-1,board);
		count += getNumAlive(x+1,y-1,board);
		// middle row
		count += getNumAlive(x-1,y,board);
		count += getNumAlive(x+1,y,board);
		// bottom row
		count += getNumAlive(x-1,y+1,board);
		count += getNumAlive(x,y+1,board);
		count += getNumAlive(x+1,y+1,board);
		//
		int cellState = board.getCellState(x, y);
		return apply(x,y,count,cellState);
	}
	
	/**
	 * Apply the actual rule having already calculated the number of alive
	 * neighbours
	 * 
	 * @param x
	 *            Horizontal position of cell on the board
	 * @param y
	 *            Vertical position of cell on the board
	 * @param neighbours
	 *            Number of alive neighbours on the board.
	 * @return
	 */
	public abstract int apply(int x, int y, int neighbours, int cellState);
	
	/**
	 * Check the state of an adjancent cell, taking into account the edges of
	 * the board.
	 * 
	 * @param x
	 * @param y
	 * @param board
	 * @return
	 */
	private int getNumAlive(int x, int y, BoardView board) {
		if (x < 0 || x >= board.getWidth()) {
			return 0;
		} else if (y < 0 || y >= board.getWidth()) {
			return 0;
		} else if (board.getCellState(x, y) == DEAD) {
			return 0;
		} else {
			return 1;
		}
	}
}
