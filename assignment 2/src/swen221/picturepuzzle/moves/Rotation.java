// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.moves;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.model.Operation;
import swen221.picturepuzzle.model.Cell;

/**
 * Responsible for rotating the image data in a given cell in a clockwise
 * direction.
 *
 * @author betty
 *
 */
public class Rotation implements Operation {
	/**
	 * Location of cell which is to be rotated.
	 */
	private final Location location;
	/**
	 * Number of steps to rotate (in a clockwise direction) where each step is a
	 * 90degree rotation.
	 */
	private final int steps;

	/**
	 * Construction a rotation for the cell at a given location, rotating a given
	 * number of steps.
	 *
	 * @param loc   Location of cell to be rotated.
	 * @param steps Number of rotations to apply.
	 */
	public Rotation(Location loc, int steps) {
		this.location = loc;
		this.steps = steps;
	}

	/**
	 * Apply rotation to the selected cell.
	 *
	 * @param board Board where rotation is being applied.
	 */
	@Override
	public void apply(Board board) {
		// Get the cell at the location
		Cell cell = board.getCellAt(location);
		// check to see if the cell is null
		// if cell is null, return
		if (cell == null)
			return;
		// Get the width of the cell
		int cellWidth = cell.getWidth();
		// Create a temporary array to store the rotated pixel data
		for (int s = 0; s < steps; s++) {
			int[] temp = new int[cellWidth * cellWidth];
			// Rotate the pixel data in the cell
			for (int y = 0; y < cellWidth; y++) {
				for (int x = 0; x < cellWidth; x++) {
					temp[(cellWidth - 1 - y) * cellWidth + x] = cell.getRGB(x, y);
				}
			}
			// Put the rotated pixel data back into the cell
			for (int x = 0; x < cellWidth; x++) {
				for (int y = 0; y < cellWidth; y++) {
					cell.setRGB(x, y, temp[x * cellWidth + y]);
				}
			}
		}
	}
}
