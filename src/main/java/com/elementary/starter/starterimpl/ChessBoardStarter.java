package com.elementary.starter.starterimpl;

import com.elementary.starter.Starter;

public final class ChessBoardStarter implements Starter {

    private static final String RUN_INSTRUCTION = "To run ChessBoard app you need specify at least two" +
            " integer arguments: width, height of ChessBoard.";

    private static final int REQUIRED_NUMBER_OF_ARGUMENTS = 2;

    private static ChessBoardStarter CHESS_BOARD_STARTER = new ChessBoardStarter();

    private ChessBoardStarter() {
    }

    @Override
    public void start(String[] args) {

        if (args.length >= REQUIRED_NUMBER_OF_ARGUMENTS) {
            int width;
            int height;
            try {
                width = Integer.parseInt(args[0]);
                if (width < 0) {
                    width = Math.abs(width);
                }
                height = Integer.parseInt(args[1]);
                if (height < 0) {
                    height = Math.abs(height);
                }
            } catch (NumberFormatException nfe) {

            }

//            ChessBoard chessBoard = new ChessBoard(width, height);
//            System.out.println(chessBoard);

        } else {
            System.out.println(ChessBoardStarter.RUN_INSTRUCTION);
        }
    }

    public static ChessBoardStarter getInstance() {
        return CHESS_BOARD_STARTER;
    }
}
