package com.elementary.starter;

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
    public static final int REQUIRED_ATTRIBUTE_NUMBER = 4;

    private TriangleStarter() {
    }

    @Override
    public void start(String[] args) {
        try (StringConsoleWorker consoleWorker = new StringConsoleWorker()) {
            consoleWorker.print(RUN_INSTRUCTION);
            List<Triangle> triangles = new ArrayList<>();
            do {
                String input = consoleWorker.read("Input triangle: <name>, <side length>, <side length>, <side length>");
                String[] params = input.split(",");
                for (int i = 0; i < params.length; i++) {
                    params[i] = params[i].trim().toLowerCase();
                }
                if (params.length < REQUIRED_ATTRIBUTE_NUMBER) {
                    String warningMessage = "Required " + REQUIRED_ATTRIBUTE_NUMBER + " attributes, passed "
                            + params.length;
                    consoleWorker.print(warningMessage);
                } else {
                    try {
                        Triangle triangle = Triangle.from(params);
                        triangles.add(triangle);
                    } catch (IllegalArgumentException iae) {
                        consoleWorker.print(iae.getMessage());
                    }
                }
            } while (consoleWorker.continueInput());
            triangles.sort(Comparator.comparing(Triangle::getSquare));
            triangles.forEach(t -> consoleWorker.print(t.toString()));
        }
    }

    public static TriangleStarter getInstance() {
        return TriangleStarter.TRIANGLE_STARTER;
    }
}
