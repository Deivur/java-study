package com.elementary.starter;

import com.elementary.io.IntegerConsoleWorker;
import com.elementary.task.NumberToWords;

public class NumberToWordsStarter implements Starter {

    private static NumberToWordsStarter NUMBER_TO_WORDS_STARTER = new NumberToWordsStarter();

    private NumberToWordsStarter() {
    }

    @Override
    public void start(String[] args) {
        try (IntegerConsoleWorker consoleWorker = new IntegerConsoleWorker()) {
            do {
                int number = consoleWorker.read("Enter integer number:");
                String numberInWords = NumberToWords.convert(number);
                consoleWorker.print(numberInWords);
            } while (consoleWorker.continueInput());
        }
    }

    public static NumberToWordsStarter getInstance() {
        return NumberToWordsStarter.NUMBER_TO_WORDS_STARTER;
    }
}
