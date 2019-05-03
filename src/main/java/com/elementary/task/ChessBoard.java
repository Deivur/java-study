package com.elementary.task;


import com.elementary.util.NumberUtil;

public class ChessBoard {

    private final int width;
    private final int height;
    private final String board;

    public ChessBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = generateBoard(width, height);
    }

    private String generateBoard(int width, int height) {
        StringBuilder board = new StringBuilder();
        String line = generateLine(width);
        String inverseLine = generateInverseLine(width);
        for (int i = 0; i < height; i++) {
            if (NumberUtil.isEven(i)) {
                board.append(line);
            } else {
                board.append(inverseLine);
            }
            board.append("\n");
        }
        return board.substring(0, board.length() - 1);
    }

    private String generateLine(int length) {
        return generateLine(length, false);
    }

    private String generateInverseLine(int length) {
        return generateLine(length, true);
    }

    private String generateLine(int length, boolean inverse) {
        StringBuilder lineBuilder = new StringBuilder();
        char firstCell = '■';
        char secondCell = '□';
        if (inverse) {
            char tmp = firstCell;
            firstCell = secondCell;
            secondCell = tmp;
        }
        for (int i = 0; i < length; i++) {
            if (NumberUtil.isEven(i)) {
                lineBuilder.append(firstCell);
            } else {
                lineBuilder.append(secondCell);
            }
        }
        return lineBuilder.toString();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "ChessBoard{" +
                "width=" + width +
                ", height=" + height +
                "}";
    }
}