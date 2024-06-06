// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.connect.rules;

import swen221.connect.core.Board;
import swen221.connect.core.Game;
import swen221.connect.core.Rule;
import swen221.connect.core.Game.Status;

/**
 * Checks whether or not a stale mate has been reached.
 *
 * @author David J. Pearce
 *
 */
public class StaleMateRule implements Rule {

	@Override
	public Status apply(Game g) {
		if (g.tokensLeft(Board.Token.BLACK) == 8) {
			return Status.STALEMATE;
		}
		return Status.ONGOING;
	}
}
