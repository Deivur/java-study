package com.elementary.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileParser {

    private final Path path;
    private String file;

    public FileParser(String filePath) throws IOException {
        this.path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            this.file = reader.lines()
                    .collect(Collectors.joining());
        }
    }

    public int countOccurrencesOfSubstring(String substring) {
        int count = 0;
        int index = 0;
        while ((index = file.indexOf(substring, index)) != -1) {
            count++;
            index++;
        }
        return count;
    }

    public void replaceFileSubstring(String searching, String replace) throws IOException {
        file = file.replace(searching, replace);
        Files.write(path, file.getBytes());
    }
}
