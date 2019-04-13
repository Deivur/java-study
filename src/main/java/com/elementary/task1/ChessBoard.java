package com.elementary.task1;

public class ChessBoard {

    private int width;
    private int height;

    ChessBoard(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String generateBoard(int width, int height) {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < height; i++) {
            if (i % 2 == 0) {
                board.append(" ");
            }
            for (int j = 0; j < width; j++) {
                if (j % 2 == 0) {
                    board.append("*");
                } else {
                    board.append(" ");
                }
            }
            board.append(System.lineSeparator());
        }
        return board.toString();
    }

    public void printBoard() {
        String generatedBoard = generateBoard(width, height);
        System.out.println(generatedBoard);
    }
}
