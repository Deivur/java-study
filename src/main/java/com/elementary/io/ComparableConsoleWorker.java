package com.elementary.io;

public abstract class ComparableConsoleWorker<T extends Comparable, K extends ComparableConsoleWorker<T, K>>
        extends ConsoleWorker<T, K> {

    private T minValue;
    private T maxValue;

    @SuppressWarnings("unchecked")
    public K setMinValue(T minValue) {
        this.minValue = minValue;
        return (K) this;
    }

    @SuppressWarnings("unchecked")
    public K setMaxValue(T maxValue) {
        this.maxValue = maxValue;
        return (K) this;
    }

    @SuppressWarnings("unchecked")
    private boolean isInRange(T value) {
        return (minValue == null || minValue.compareTo(value) <= 0) &&
                (maxValue == null || maxValue.compareTo(value) >= 0);
    }

    @Override
    public boolean checkConditions(T value) {
        boolean isValidPreviousChecks = super.checkConditions(value);
        boolean isValid = isInRange(value);
        if (!isValid) {
            String message = "Expected a " + value.getClass().getSimpleName().toLowerCase();
            if(minValue != null && maxValue != null) {
                message += " value between " + minValue + " and " + maxValue + ".";
            }
            if(minValue != null && maxValue == null) {
                message += " value greater than or equal to " + minValue + ".";
            }
            if(maxValue != null &&  minValue == null) {
                message += " value less than or equal to " + maxValue + ".";
            }
            print(message);
        }
        return isValid & isValidPreviousChecks;
    }
}
