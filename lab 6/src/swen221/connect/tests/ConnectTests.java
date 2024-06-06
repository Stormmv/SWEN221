// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.connect.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import swen221.connect.core.Board;
import swen221.connect.core.Game;
import swen221.connect.util.Position;

public class ConnectTests {

	@Test public void test_01() {
		String output = "|_|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n";

		Board board = new Board();

		assertEquals(output,board.toString());
	}
	@Test public void test_02() {
		String output = "|W|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n";
		
		Board board = new Board();
		
		board.setSquare(new Position(0,0), Board.Token.WHITE);
		
		assertEquals(output, board.toString());
	}

	@Test public void test_03() {
		String output = "|B|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n";
		
		Board board = new Board();
		
		board.setSquare(new Position(0,0), Board.Token.BLACK);
		
		assertEquals(output, board.toString());
	}
	//make test for the placeToken method
	@Test public void test_04() {
		String output = "|W|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n";
		
		Board board = new Board();
		Game game = new Game(board);
		
		game.placeToken(new Position(0,0), Board.Token.WHITE);
		
		assertEquals(output, board.toString());
	}
}
