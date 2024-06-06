// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.adventure;

import java.util.*;

import swen221.adventure.model.*;
import swen221.adventure.util.GameFile;
import swen221.adventure.view.GraphicalUserInterface;

/**
 * Represents an Adventure Game, which consists of rooms with doors conecting
 * them, and items which are stored in them.
 * 
 * @author David J. Pearce
 *
 */
public class AdventureGame {
	/**
	 * Represents the player playing the game.
	 */
	private Player player;

	/**
	 * The set of objects making up the game (e.g. rooms, doors, etc)
	 */
	private Object[] objects;

	/**
	 * Construct an adventure game from a list of GameFile items. This
	 * constructor creates the game world according to this list. If the list
	 * contains an item which is not recognised then an exception will be
	 * thrown.
	 * 
	 * @param items
	 */
	public AdventureGame(GameFile.Item[] items) {
		objects = new Object[items.length];
		for (int i = 0; i != items.length; ++i) {
			objects[i] = createObject(items[i]);
		}
		Room startingLocation = (Room) objects[0];
		this.player = new Player(startingLocation);
	}

	/**
	 * Get the player associated with this game.
	 * 
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Convert a GameFile.Item into a real game world object. This reads the
	 * fields of the given GameFile.Item object and then constructs a new object
	 * to represent it in the game.
	 * 
	 * @param item
	 * @return
	 */
	private Object createObject(GameFile.Item item) {
		Item r;
		switch (item.name()) {
			case "Room":
				return createRoomObject(item);
			case "Door":
				return createDoorObject(item);
			case "Coin":
				return createCoinObject(item);
			case "Key":
				return createKeyObject(item);
			case "Obelisk":
				return createObeliskObject(item);
			case "Book":
				return createBookObject(item);
			case "LockedDoor":
				return createLockedDoorObject(item);
			case "SecretButton":
				return createSecretButtonObject(item);
			default:
				// If we get here, then we've encountered an object kind we don't
				// know
				// about. Therefore, through an exception to indicate this.
				throw new IllegalArgumentException("Unknown GameFile.Item name");
		}
	}

	/**
	 * Create a Book within the game.
	 * 
	 * @param item
	 * @return
	 */

	private Item createBookObject(GameFile.Item item) {
		String title = (String) item.field("title");
		Book b = new Book(title);
		return addItemToRoom((Integer) item.field("location"), b);
	}

	/**
	 * Create a Room within the game.
	 * 
	 * @param item
	 * @return
	 */
	private Room createRoomObject(GameFile.Item item) {
		String description = (String) item.field("description");
		return new Room(description);
	}

	/**
	 * Create a Door within the game. A door connects two rooms within the game.
	 * 
	 * @param item
	 * @return
	 */
	private Door createDoorObject(GameFile.Item item) {
		int from = (Integer) item.field("from");
		int to = (Integer) item.field("to");
		Room oneSide = (Room) objects[from];
		Room otherSide = (Room) objects[to];
		Door d = new Door(oneSide, otherSide);
		oneSide.addItem(d);
		otherSide.addItem(d);
		return d;
	}

	/**
	 * Create a LockedDoor within the game. A locked door connects two rooms
	 * within the game, and requires a key to unlock.
	 * 
	 * @param item
	 * @return
	 */
	private Item createLockedDoorObject(GameFile.Item item) {
		int from = (Integer) item.field("from");
		int to = (Integer) item.field("to");
		int code = (Integer) item.field("code");
		Room oneSide = (Room) objects[from];
		Room otherSide = (Room) objects[to];
		LockedDoor d = new LockedDoor(oneSide, otherSide, code);
		oneSide.addItem(d);
		otherSide.addItem(d);
		return d;
	}

	/**
	 * Create a Coin within the game.
	 * 
	 * @param item
	 * @return
	 */
	private Item createCoinObject(GameFile.Item item) {
		Coin c = new Coin();
		return addItemToRoom((Integer) item.field("location"), c);
	}

	/**
	 * Create a key within the game.
	 * 
	 * @param item
	 * @return
	 */
	private Item createKeyObject(GameFile.Item item) {
		int code = (Integer) item.field("code");
		Key k = new Key(code);
		return addItemToRoom((Integer) item.field("location"), k);
	}

	private Item createSecretButtonObject(GameFile.Item item) {
		int code = (Integer) item.field("code");
		Room location = (Room) objects[(Integer) item.field("location")];
		SecretButton sb = new SecretButton(code);
		return addItemToRoom((Integer) item.field("location"), sb);
	}

	/**
	 * Create a Coin within the game.
	 * 
	 * @param item
	 * @return
	 */
	private Item createObeliskObject(GameFile.Item item) {
		Obelisk c = new Obelisk();
		return addItemToRoom((Integer) item.field("location"), c);
	}

	/**
	 * Add a given item into a room.
	 * 
	 * @param room
	 * @param item
	 */
	private Item addItemToRoom(int room, Item item) {
		Room r = (Room) objects[room];
		r.addItem(item);
		return item;
	}

	/**
	 * Run a stand-alone version of the adventure game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// The set of items which constitute the default game. You can add more
		// items to this if you wish.
		String[] items = {
				"Room { description: \"The Great Hall\"}",
				"Room { description: \"The Dining Room\"}",
				"Door { from: 0, to: 1 }",
				"Coin { location: 0 }",
				"Obelisk { location: 0 }",
				"Key { location: 1, code: 123 }",
				"Book { location: 0, title: \"Great Expectations\" }"
		};
		// Create the game model
		AdventureGame game = new AdventureGame(GameFile.parseItems(items));
		// Create the window showing the game
		new GraphicalUserInterface(game);
	}
}
