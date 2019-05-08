package com.elementary.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberToWordsTest {

    @ParameterizedTest
    @CsvSource({
            "0, ноль",
            "-1, минус один",
            "10, десять",
            "12, двенадцать",
            "28, двадцать восемь",
            "145, сто сорок пять",
            "1111, одна тысяча сто одиннадцать",
            "7812, семь тысяч восемьсот двенадцать",
            "10765, десять тысяч семьсот шестьдесят пять",
            "563981, пятьсот шестьдесят три тысячи девятьсот восемьдесят один",
            "1000000, один миллион",
            "10000001, десять миллионов один",
            "435654321, четыреста тридцать пять миллионов шестьсот пятьдесят четыре тысячи триста двадцать один",
            "1000000000, один миллиард",
            "2000000000000, два триллиона",
            "987654567321686, девятьсот восемьдесят семь триллионов шестьсот пятьдесят четыре миллиарда пятьсот" +
                    " шестьдесят семь миллионов триста двадцать одна тысяча шестьсот восемьдесят шесть",
            "1111111111111111, значение превышает максимально допустимое!"
    })
    void convert(ArgumentsAccessor arguments) {
        String expected = arguments.getString(1);

        String actual = NumberToWords.convert(arguments.getLong(0));
        System.out.println(actual);

        assertEquals(expected, actual);
    }
}