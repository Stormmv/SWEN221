package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

public class J extends Tetromino {
	boolean horizontal= true;
    public J(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public int x(int i) {
        // The x-coordinate for J tetromino is a simple pattern
        if (i == 0 || i == 1 || i == 2) {
            return centerX() - 1;
        } else {
            return centerX();
        }
    }

    @Override
    public int y(int i) {
        // The y-coordinate for J tetromino is a simple pattern
        if (i == 0 || i == 1) {
            return centerY();
        } else {
            return centerY() + 1;
        }
    }

    @Override
    public void rotateRight() {
        // J tetromino has four orientations, so we need to implement the rotation logic
        horizontal = !horizontal;
    }
}