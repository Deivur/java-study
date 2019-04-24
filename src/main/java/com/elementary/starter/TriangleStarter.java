package com.elementary.starter;

import com.elementary.io.DoubleConsoleWorker;
import com.elementary.io.StringConsoleWorker;
import com.elementary.task.Triangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class TriangleStarter implements Starter {

    private static final String RUN_INSTRUCTION = "To run Triangle app you need enter triangles." +
            "Input type (delimiter - coma): \n" +
            "<name>, <side length>, <side length>, <side length>\n";

    private static TriangleStarter TRIANGLE_STARTER = new TriangleStarter();

    private TriangleStarter() {
    }

    @Override
    public void start(String[] args) {
        try (StringConsoleWorker consoleWorker = new StringConsoleWorker()) {
            consoleWorker.print(RUN_INSTRUCTION);
            List<Triangle> triangles = new ArrayList<>();
            String input;
            List<String> triangleParams;
            do {
                input = consoleWorker.read("Input triangle: <name>, <side length>, <side length>, <side length>");


            } while (consoleWorker.continueInput());
            triangles.sort(Comparator.comparing(Triangle::getSquare));
            consoleWorker.print(triangles.toString());
        }

    }

    public static TriangleStarter getInstance() {
        return TRIANGLE_STARTER;
    }
}
