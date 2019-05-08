package com.elementary.task;

public final class NumberToWords {

    private NumberToWords() {
    }

    private static final String[][] nums =
            {
                    {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
                    {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"}
            };

    private static final String[] nums10 =
            {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
                    "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

    private static final String[] tens =
            {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят",
                    "восемьдесят", "девяносто"};

    private static final String[] hundreds =
            {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
                    "восемьсот", "девятьсот"};

    private static final String[][] thousands =
            {
                    {"", "", "", "0"},
                    {"тысяча", "тысячи", "тысяч", "1"},
                    {"миллион", "миллиона", "миллионов", "0"},
                    {"миллиард", "миллиарда", "миллиардов", "0"},
                    {"триллион", "триллиона", "триллионов", "0"}
            };

    private static final long MAX_VALUE = 999999999999999L;

    public static String convert(long number) {
        return convert(number, 0, false);
    }

    private static String convert(long number, int level, boolean isNegative) {
        if (number > MAX_VALUE) {
            return "значение превышает максимально допустимое!";
        }
        StringBuilder words = new StringBuilder();
        if (number < 0) {
            isNegative = true;
            number = Math.abs(number);
        }
        if (number == 0) {
            words.append("ноль");
        }
        int gender = Integer.parseInt(thousands[level][3]);
        int numberSegment = (int) (number % 1000);
        int hundred = numberSegment / 100;
        int ten = (numberSegment / 10) % 10;
        int one = numberSegment % 10;
        long nextNumber = number / 1000;
        // add minus if negative number and last iteration
        if (nextNumber <= 0) {
            if (isNegative) {
                words.append("минус ");
            }
        }
        if (hundred > 0) {
            words.append(hundreds[hundred]).append(" ");
        }
        if (ten > 0) {
            if (ten == 1 && one > 0) {
                words.append(nums10[one]).append(" ");
                one = 0;
            } else {
                words.append(tens[ten]).append(" ");

            }
        }
        if (one > 0) {
            words.append(nums[gender][one]).append(" ");
        }
        if (one > 0 || ten > 0 || hundred > 0) {
            if (one == 1) {
                words.append(thousands[level][0]).append(" ");
            } else if (one >= 2 && one <= 4) {
                words.append(thousands[level][1]).append(" ");
            } else {
                words.append(thousands[level][2]).append(" ");
            }
        }
        if (nextNumber > 0) {
            level++;
            return (convert(nextNumber, level, isNegative) + " " + words.toString()).trim();
        } else {
            return words.toString().trim();
        }
    }
}
