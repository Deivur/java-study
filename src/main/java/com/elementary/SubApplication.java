package com.elementary;

import com.elementary.starter.Starter;
import com.elementary.starter.starterimpl.ChessBoardStarter;
import com.elementary.starter.starterimpl.EnvelopeStarter;

import java.util.Arrays;

public enum SubApplication {

    CHESSBOARD(new ChessBoardStarter()),
    ENVELOPE(new EnvelopeStarter());

    private Starter starter;

    SubApplication(Starter starter) {
        this.starter = starter;
    }

    public Starter getStarter() {
        return starter;
    }

    public static SubApplication get(int id) {

        return Arrays.stream(SubApplication.values())
                .filter(subApplication -> id == subApplication.ordinal())
                .findFirst()
                .orElse(SubApplication.CHESSBOARD); // default app
    }
}
