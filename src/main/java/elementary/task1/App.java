package elementary.task1;

public class App {

    private static final String runInstruction = "To run app you need specify at least two number arguments:" +
            " width, height of ChessBoard.";

    public static void main(String[] args) {
        checkStartAppArgs(args);

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[0]);

        ChessBoard chessBoard = new ChessBoard(width, height);
        chessBoard.printBoard();
    }

    private static void checkStartAppArgs(String[] args) {
        int requiredNumberOfArguments = 2;
        if (args.length != requiredNumberOfArguments || isNotNumeric(args[0]) || isNotNumeric(args[1])) {
            System.out.println(App.runInstruction);
            System.exit(1);
        }
    }

    private static boolean isNotNumeric(String strNum) {
        return !strNum.matches("-?\\d+(\\.\\d+)?");
    }
}
