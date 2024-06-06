package swen221.adventure.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class Book extends PickupableItem {
    private String title;
    private boolean read = false;

    public Book(String title) {
        this.title = title;
    }

    public void Read() {
        this.read = true;
    }

    @Override
    public String getDescription() {
        if (read) {
            return "A book entitled \"" + title + "\"; it looks like it has been read";
        } else {
            return "A book entitled \"" + title + "\"";
        }
    }

    @Override
    public String[] getActions() {
        return new String[] { "Read", "Pickup", "Drop" };
    }

    @Override
    public boolean performAction(String action, Player player) {
        if (action.equals("Read")) {
            List<Item> inventory = player.getInventory();
            if (inventory.contains(this)) {
                Read();
                return true;
            } else {
                return false;
            }
        } else {
            return super.performAction(action, player);
        }
    }

    @Override
    public void draw(Graphics g) {
        int width = (int) g.getClipBounds().getWidth();
        int height = (int) g.getClipBounds().getHeight();
        int xStart = width / 4;
        int yStart = height / 4;
        int xEnd = (width * 3) / 4;
        int yEnd = (height * 3) / 4;
        g.setColor(Color.BLUE);
        g.fillRect(xStart, yStart, xEnd - xStart, yEnd - yStart);
        g.setColor(Color.BLACK);
        g.drawRect(xStart, yStart, xEnd - xStart, yEnd - yStart);
    }
}
