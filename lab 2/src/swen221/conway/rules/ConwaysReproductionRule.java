// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.conway.rules;

import swen221.conway.model.*;
import swen221.conway.util.ConwayAbstractRule;

/**
 * This should implement Conway's rule for reproduction:
 * 
 * "Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction"
 * 
 * @author David J. Pearce
 *
 */
public class ConwaysReproductionRule extends ConwayAbstractRule {
	
	/**
	 * if there are exactly 3 neighbours, make the cell alive.
	 */
	
	@Override
	public int apply(int x, int y, int neighbours) {
		if (neighbours == 3) {
			return ConwayAbstractRule.ALIVE;
		}
		else {
			return Rule.NOT_APPLICABLE;
		}
	}
}
