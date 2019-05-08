package com.elementary.task;


import com.elementary.util.NumberUtil;

public class ChessBoard {

    private final int width;
    private final int height;
    private final String board;

    public ChessBoard(int width, int height, boolean whiteFirst) {
        this.width = Math.abs(width);
        this.height = Math.abs(height);
        this.board = generateBoard(this.width, this.height, whiteFirst);
    }

    private String generateBoard(int width, int height, boolean whiteFirst) {
        StringBuilder board = new StringBuilder();
        String blackFirstLine = generateLine(width);
        String whiteFirstLine = generateInverseLine(width);
        for (int i = 0; i < height; i++) {
            if (NumberUtil.isEven(i)) {
                board.append(whiteFirst ? whiteFirstLine : blackFirstLine);
            } else {
                board.append(whiteFirst ? blackFirstLine : whiteFirstLine);
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