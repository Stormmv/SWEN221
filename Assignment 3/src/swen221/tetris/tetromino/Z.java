package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

public class Z extends S {
    public Z(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public int x(int i) {
        // The x-coordinate for Z tetromino is a simple pattern
        if (horizontal) {
            if (i == 0 || i == 1) {
                return centerX() - 1;
            } else {
                return centerX();
            }
        } else {
            if (i == 1 || i == 2) {
                return centerX();
            } else {
                return centerX() + 1;
            }
        }
    }

    @Override
    public int y(int i) {
        // The y-coordinate for Z tetromino is a simple pattern
        if (horizontal) {
            if (i == 0 || i == 3) {
                return centerY();
            } else {
                return centerY() + 1;
            }
        } else {
            if (i == 0 || i == 2) {
                return centerY() - 1;
            } else {
                return centerY();
            }
        }
    }
}
