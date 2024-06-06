package swen221.adventure.model;

import java.awt.Color;
import java.awt.Graphics;

public class SecretButton implements Item {
    private int code;
    private Room location;

    public SecretButton(int code) {
        this.code = code;
    }

    public void setLocation(Room location) {
        this.location = location;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return "A secret button";
    }

    @Override
    public String[] getActions() {
        return new String[] { "Press" };
    }

    @Override
    public boolean performAction(String action, Player player) {
        //if (action.equals("Press")) {
            //for (Room.Location l : Room.Location.values()) {
                //if (l != null) {
                    //for (Item i : l.getItems()) {
                        //if (i instanceof LockedDoor) {
                            //LockedDoor d = (LockedDoor) i;
                            //if (d.isLocked()) {
                                //d.UnlockInt(code);
                            //}
                        //}
                    //}
                //}
            //}
        //}
    	return false;
    }

    @Override
    public void draw(Graphics g) {
        int width = (int) g.getClipBounds().getWidth();
        int height = (int) g.getClipBounds().getHeight();
        int xStart = width / 4;
        int yStart = height / 4;
        int xEnd = (width * 3) / 4;
        int yEnd = (height * 3) / 4;
        g.setColor(Color.RED);
        g.fillRect(xStart, yStart, xEnd - xStart, yEnd - yStart);
        g.setColor(Color.BLACK);
        g.drawRect(xStart, yStart, xEnd - xStart, yEnd - yStart);
    }
}
