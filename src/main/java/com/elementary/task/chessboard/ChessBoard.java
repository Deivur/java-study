package com.elementary.task.chessboard;

import com.elementary.task.figure.Rectangle;

public class ChessBoard extends Rectangle {

    private String boardView;

    public ChessBoard(int width, int height) {
        super(width, height);
        this.boardView = generateBoardView(width, height);
    }

    private String generateBoardView(int width, int height) {
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

    public void printBoardIntoConsole() {
        System.out.println(boardView);
    }
}
