package com.elementary;

import com.elementary.starter.Starter;
import com.elementary.starter.ChessBoardStarter;
import com.elementary.starter.EnvelopeStarter;
import com.elementary.starter.TriangleStarter;

public enum SubApplication {

    CHESSBOARD(ChessBoardStarter.getInstance()),
    ENVELOPE(EnvelopeStarter.getInstance()),
    TRIANGLE(TriangleStarter.getInstance());

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
