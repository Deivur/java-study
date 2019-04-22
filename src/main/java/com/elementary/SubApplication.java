package com.elementary;

import com.elementary.starter.Starter;
import com.elementary.starter.starterimpl.ChessBoardStarter;
import com.elementary.starter.starterimpl.EnvelopeStarter;

import java.util.Arrays;

public enum SubApplication {

    CHESSBOARD(ChessBoardStarter.getInstance()),
    ENVELOPE(EnvelopeStarter.getInstance());

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
