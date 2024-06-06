package swen221.adventure.model;

import java.util.List;

public class LockedDoor extends Door {
    private int code;
    private boolean locked = true;

    public LockedDoor(Room from, Room to, int code) {
        super(from, to);
        this.code = code;
    }

    public void Unlock(Key key) {
        if (key.getCode() == code) {
            locked = false;
        }
    }
    
    public void UnlockInt(int key) {
        if (key == code) {
            locked = false;
        }
    }

    public void Lock(Key key) {
        if (key.getCode() == code) {
            locked = true;
        }
    }

    public boolean isLocked() {
        return locked;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        if (locked) {
            return "A locked door";
        } else {
            return "An unlocked door";
        }
    }

    @Override
    public String[] getActions() {
        return new String[] { "Unlock", "Lock" };
    }

    @Override
    public boolean performAction(String action, Player player) {
        if (action.equals("Unlock")) {
            List<Item> items = player.getInventory();
            Key key = null;
            for (Item item : items) {
                if (item instanceof Key) {
                    Key k = (Key) item;
                    if (k.getCode() == code) {
                        key = k;
                        break;
                    }
                }
            }
            if (key != null) {
                Unlock(key);
                return true;
            } else {
                return false;
            }
        } else if (action.equals("Lock")) {
            List<Item> items = player.getInventory();
            Key key = null;
            for (Item item : items) {
                if (item instanceof Key) {
                    Key k = (Key) item;
                    if (k.getCode() == code) {
                        key = k;
                        break;
                    }
                }
            }
            if (key != null) {
                Lock(key);
                return true;
            } else {
                return false;
            }
        } else if (action.equals("Enter")) {
            if (locked) {
                return false;
            } else {
                return super.performAction(action, player);
            }
        } else {
            return super.performAction(action, player);
        }
    }
}
