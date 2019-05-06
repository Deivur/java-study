package com.elementary.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {

    private static final String TEST_FILE_PATH = "src/test/resources/test_text.txt";

    private FileParser fileParser;

    @BeforeEach
    void init() {
        fileParser = new FileParser(TEST_FILE_PATH);
    }

    @Test
    void countOccurrencesOfSubstring() {
        int expected = 2;

        int actual = fileParser.countOccurrencesOfSubstring("it ");

        assertEquals(expected, actual);
    }
}