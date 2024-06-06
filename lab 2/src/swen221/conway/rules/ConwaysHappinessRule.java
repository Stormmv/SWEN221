// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.conway.rules;

import swen221.conway.model.*;
import swen221.conway.util.abstractDecayRule;

public class ConwaysHappinessRule extends abstractDecayRule {
	
	/**
	 * if there are exactly 3 neighbours, make the cell younger.
	 */
	
	@Override
	public int apply(int x, int y, int neighbours, int cellState) {
		if (neighbours == 3) {
			// This rule was applied in this case
			if (cellState > 0) {
				return (cellState - 1);
			}
			else {
				return Rule.NOT_APPLICABLE;
			}
		} else {
			// This rule was not applied in this case
			return Rule.NOT_APPLICABLE;
		}
	}
}