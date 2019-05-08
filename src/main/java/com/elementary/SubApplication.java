package com.elementary;

import com.elementary.starter.*;

public enum SubApplication {

    CHESSBOARD(ChessBoardStarter.getInstance()),
    ENVELOPE(EnvelopeStarter.getInstance()),
    TRIANGLE(TriangleStarter.getInstance()),
    FILE_PARSER(FileParserStarter.getInstance()),
    NUMBER_TO_WORDS(NumberToWordsStarter.getInstance()),
    LUCKY_TICKETS(LuckyTicketsStarter.getInstance()),
    NUMBER_SEQUENCE(NumberSequenceStarter.getInstance()),
    FIBONACCI(FibonacciStarted.getInstance()),
    FAST_POW(FastPowStarter.getInstance());

    private Starter starter;

    SubApplication(Starter starter) {
        this.starter = starter;
    }

    public Starter getStarter() {
        return starter;
    }

    public static SubApplication getSubAppStarter(int id) {
        return SubApplication.values()[id];
    }
}
