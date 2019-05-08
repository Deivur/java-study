package com.elementary.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileParser {

    private final Path path;
    private String content;

    public FileParser(String filePath) {
        this.path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            this.content = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException ioe) {
            throw new FileParserException("Cant read content, path: " + path, ioe);
        }
    }

    public int countOccurrencesOfSubstring(String substring) {
        int count = 0;
        int index = 0;
        while ((index = content.indexOf(substring, index)) != -1) {
            count++;
            index++;
        }
        return count;
    }

    public void replaceFileSubstring(String searching, String replace) {
        content = content.replace(searching, replace);
        try {
            Files.write(path, content.getBytes());
        } catch (IOException ioe) {
            throw new FileParserException("Cant write content, path: " + path, ioe);
        }
    }

    public String getContent() {
        return content;
    }
}
