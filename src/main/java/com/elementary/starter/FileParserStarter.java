package com.elementary.starter;

import com.elementary.io.StringConsoleWorker;
import com.elementary.task.FileParser;
import com.elementary.task.FileParserException;

import java.io.IOException;

public class FileParserStarter implements Starter {

    private static final String RUN_INSTRUCTION = "To run FileParser app you need " +
            " specify arguments:" +
            " 1 - <file path> <counting string>" +
            " 2 - <file path> <searching string> <replacement stringe>";

    private static FileParserStarter FILE_PARSER_STARTER = new FileParserStarter();

    private FileParserStarter() {
    }

    @Override
    public void start(String[] args) {
        try (StringConsoleWorker consoleWorker = new StringConsoleWorker()) {
            int argsLength = args.length;
            String path = args[0];
            try {
                FileParser parser = new FileParser(path);
                if (argsLength == 2) {
                    String counting = args[1];
                    consoleWorker.print(parser.countOccurrencesOfSubstring(counting));

                } else if (argsLength == 3) {
                    String searching = args[1];
                    String replace = args[2];
                    parser.replaceFileSubstring(searching, replace);

                } else {
                    consoleWorker.print(RUN_INSTRUCTION);
                }
            } catch (FileParserException fpe) {
                consoleWorker.print(fpe.getMessage());
            }
        }
    }

    public static FileParserStarter getInstance() {
        return FileParserStarter.FILE_PARSER_STARTER;
    }
}
