package com.elementary.starter;

import com.elementary.io.StringConsoleWorker;
import com.elementary.task.LuckyTicketsCounter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LuckyTicketsStarter implements Starter {

    private static final String RUN_INSTRUCTION = "To run app you need specify algorithm name in file" +
            " resources/tickets_algorithm.txt or would be run default 'Moscow'";

    private static LuckyTicketsStarter LUCKY_TICKETS_STARTER = new LuckyTicketsStarter();
    private static IntStream TICKET_SOURCE = IntStream.rangeClosed(100001, 999999);

    private LuckyTicketsStarter() {
    }

    @Override
    public void start(String[] args) {
        try (StringConsoleWorker consoleWorker = new StringConsoleWorker()) {
            String algorithmName = null;
            try {
                URL fileURL = getClass().getClassLoader().getResource("tickets_algorithm.txt");
                if (fileURL != null) {
                    Path path = Paths.get(fileURL.toURI());
                    algorithmName = Files.lines(path).collect(Collectors.joining()).toUpperCase();
                }
            } catch (URISyntaxException | IOException exception) {
                consoleWorker.print(RUN_INSTRUCTION);
                consoleWorker.print("Start default, because exception was occurred during file reading: "
                        + exception.getMessage());
            }
            LuckyTicketsCounter luckyTicketsCounter;
            if (algorithmName != null) {
                luckyTicketsCounter = LuckyTicketsCounter.valueOf(algorithmName);
            } else {
                luckyTicketsCounter = LuckyTicketsCounter.MOSCOW;
            }
            int ticketsCount = luckyTicketsCounter.calculateLuckyTickets(TICKET_SOURCE);
            consoleWorker.print("Found lucky tickets: " + ticketsCount);
        }

    }

    public static LuckyTicketsStarter getInstance() {
        return LuckyTicketsStarter.LUCKY_TICKETS_STARTER;
    }
}
