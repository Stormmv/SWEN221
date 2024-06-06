package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

public class L extends J {
    public L(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public int x(int i) {
        if (i == 0 || i == 1 || i == 2) {
            return centerX() + 1; // Mirror the x-coordinate
        } else {
            return centerX();
        }
    }
}
