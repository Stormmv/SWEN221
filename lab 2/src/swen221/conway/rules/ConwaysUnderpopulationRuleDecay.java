// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.conway.rules;

import swen221.conway.model.Rule;
import swen221.conway.util.abstractDecayRule;


public class ConwaysUnderpopulationRuleDecay extends abstractDecayRule {
	
	/**
	 * if there are less than two neighbors, decay the cell
	 */
	
	public int apply(int x, int y, int neighbours, int cellState) {
		if (neighbours < 2) {
			// This rule was applied in this case
			if (cellState < 9) {
				return (cellState + 1);
			}
			else {
				return abstractDecayRule.DEAD;
			}
		} else {
			// This rule was not applied in this case
			return Rule.NOT_APPLICABLE;
		}
	}
}