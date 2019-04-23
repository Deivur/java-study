package com.elementary.task.chessboard;


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
        StringBuilder lineBuilder = new StringBuilder();
        char blackSquare = '\u25A0';
        char whiteSquare = '\u25A1';
        for (int i = 0; i < width; i++) {
            if (NumberUtil.isEven(i)) {
                lineBuilder.append(blackSquare);
            } else {
                lineBuilder.append(whiteSquare);
            }
        }
        String line = lineBuilder.toString();
        String reversedLine;
        if (NumberUtil.isOdd(width)) {
            reversedLine = whiteSquare + lineBuilder.substring(0, lineBuilder.length() -1);
        } else {
            reversedLine = lineBuilder.reverse().toString();
        }

        for (int i = 0; i < height; i++) {
            if (NumberUtil.isEven(i)) {
                board.append(line);
            } else {
                board.append(reversedLine);
            }
            // prevent last iteration
            if ((i + 1) < height) {
                board.append("\n");
            }
        }
        return board.toString();
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
