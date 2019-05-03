package com.elementary.task;

import java.text.DecimalFormat;

public final class NumberToWords {

    private NumberToWords() {
    }

    private static final String[] tens = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};

    private static final String[] nums = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь",
            "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

    private static final String[] hundreds = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот",
            "семьсот", "восемьсот", "девятьсот"};

    private static String convertLessThanOneThousand(int number) {
        String remainder;
        if (number % 100 < 20) {
            remainder = nums[number % 100];
            number /= 100;
        } else {
            remainder = nums[number % 10];
            number /= 10;

            remainder = tens[number % 10] + " " + remainder;
            number /= 10;
        }
        if (number == 0) {
            return remainder;
        }
        return hundreds[number] + " " + remainder;
    }


    public static String convert(long number) {
        if (number == 0) {
            return "ноль";
        }
        String mask = "000000000000";
        DecimalFormat format = new DecimalFormat(mask);
        String stringNumber = format.format(number);
        // XXXnnnnnnnnn
        int billions = Integer.parseInt(stringNumber.substring(0, 3));
        // nnnXXXnnnnnn
        int millions = Integer.parseInt(stringNumber.substring(3, 6));
        // nnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(stringNumber.substring(6, 9));
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(stringNumber.substring(9, 12));

        String result = billions == 0 ? "" : convertLessThanOneThousand(billions) + " миллиард ";

        result = result + (millions == 0 ? "" : convertLessThanOneThousand(millions) + " миллион ");

        result = result + (hundredThousands == 0 ? "" : convertLessThanOneThousand(hundredThousands) + " тысяча ");

        result = result + convertLessThanOneThousand(thousands);

        return result;
    }
}
