// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.conway.rules;

import swen221.conway.model.*;
import swen221.conway.util.ConwayAbstractRule;


/**
 * This should implements Conway's rule for overproduction:
 * 
 * "Any live cell with more than three live neighbours dies, as if by over-population"
 * 
 * @author David J. Pearce
 *
 */
public class ConwaysOverpopulationRule extends ConwayAbstractRule {

	/**
	 * if there are more than 3 neighbours, kill the cell.
	 */
	
	@Override
	public int apply(int x, int y, int neighbours) {
		if(neighbours > 3) {
			return ConwayAbstractRule.DEAD;
		}
		else {
			return Rule.NOT_APPLICABLE;
		}
	}
}
