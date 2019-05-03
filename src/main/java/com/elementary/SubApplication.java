package com.elementary;

import com.elementary.starter.*;

public enum SubApplication {

    CHESSBOARD(ChessBoardStarter.getInstance()),
    ENVELOPE(EnvelopeStarter.getInstance()),
    TRIANGLE(TriangleStarter.getInstance()),
    FILE_PARSER(FileParserStarter.getInstance());

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
