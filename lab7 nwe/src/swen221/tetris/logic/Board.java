package swen221.tetris.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A Board instance represent a board configuration for a game of Tetris.
 * It is represented as a list of row 20, where every row is a list of column 10.
 * Each column element is a Color, and each color provides
 * both an awt.Color and String representation.
 * */
public class Board {
 
  private final ArrayList<ArrayList<Color>> inner= 
    new ArrayList<>(rangeY().map(i-> newRow()).toList());  
  
  private ArrayList<Color> newRow() {
    return new ArrayList<>(Collections.nCopies(10, Color.EMPTY));
  }
  
  /** Checks if an index is in the valid range for x coordinates
   * */
  public static boolean xOk(int x) { return x >= 0 && x < 10; }

  /** Checks if an index is in the valid range for y coordinates
   * */
  public static boolean yOk(int y) { return y >= 0 && y < 20; }

  /** Streams on the valid x coordinates
   * */
  public static Stream<Integer> rangeX() { 
    return IntStream.range(0, 10).boxed();
  }
  
  /** Streams on the valid y coordinates
   * */
  public static Stream<Integer> rangeY() { 
    return IntStream.range(0, 20).boxed();
  }

  /** Streams on the valid y coordinates, in reverse order
   * */
  public static Stream<Integer> reverseRangeY() { 
    return IntStream.range(0, 20).mapToObj(y-> 19 - y);
  }
  /** Streams on the 4 tetramino sqare indexes: 0,1,2,3
   * */
  public static Stream<Integer> rangeT() {
    return Stream.of(0, 1, 2, 3);
  }


  /**
   * Write the Color c in the cell inside row y and column x.
   * @param x must be between 0-9
   * @param y must be between 0-19
   * @param c can not be null or Color.Empty
   * To insert Color.Empty, see {@link Board#clearRow(int)}
   * */
  public void write(int x, int y, Color c) {
    assert c != null && c != Color.EMPTY : "Need an actual color";
    assert xOk(x) : "column " + x + "not in 0-9";
    assert yOk(y) : "row " + y + "not in 0-19";
    assert inner.get(y).get(x) == Color.EMPTY : "cell " + x + ", " + y + " already used";
    inner.get(y).set(x, c);
  }

  /**
   * Delete the row y and add a new fully empty row at the top (row 19)
   * @param y must be between 0-19
   * */
  public void clearRow(int y) {
    assert yOk(y) : "row " + y + "not in 0-19";
    inner.remove(y);
    inner.add(newRow());
  }

  /**
   * Read the color in column x and row y
   * @return is Optional.empty() if x and/or y points out of the board.
   * */
  public Optional<Color> read(int x, int y) {
    if(!xOk(x) || !yOk(y)){ return Optional.empty(); }
    return Optional.of(inner.get(y).get(x));
  }

  /**
   * Is the row y fully filled?
   * @param y must be between 0-19
   * */  
  @SuppressWarnings("unused")
  private boolean isRowFull(int y) {
	  assert yOk(y) : "row " + y + "not in 0-19";
	     //TODO: completing this method may help you to complete clearFullRows!
	     
	  return Board.rangeX()
		.map(i->inner.get(y).get(i))
	    .noneMatch(color -> color.equals(Color.EMPTY));
   }
   
  /**
   * Removes all the full rows. Full rows are identified using isRowFull.
   * */
  public void clearFullRows() {
	  Board.rangeY()
		.filter(y-> isRowFull(y) == true)
		.forEach(y-> clearRow(y));
  }

  /** Generate a string representation of the board.
  The reverseRangeY() method is expected to return a stream of Y-coordinates in
  reverse order.
  For each Y-coordinate, the printLine method is called to generate a string
  representation of that line on the board.
  The resulting strings are then joined together with newline characters ("\n")
  between each line and at the start and end of the entire string. */
  public String toString() {
	return reverseRangeY()
			.map(x -> printLine(x))
			.collect(Collectors.joining("\n", "", "\n"));
  }

/** Generate a string representation of a single line on the board.
  The rangeX() method is expected to return a stream of X-coordinates.
  For each X-coordinate, the inner list is accessed to get the color at that
  position.
  The color's string representation is then extracted and joined together with
  "|" characters between each color and at the start and end of the entire
  string. */
  private String printLine(int y) {
	  return rangeX()
			  .map(x -> inner.get(y).get(x).s)
			  .collect(Collectors.joining("|", "|", "|"));
  }
}