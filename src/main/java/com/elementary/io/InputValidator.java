package com.elementary.io;

import com.elementary.util.StringUtil;

public final class InputValidator {

    private InputValidator() {
    }

    public static boolean isValidNumberArgs(String[] args, int requiredNumberOfArguments) {
        boolean validArgs = false;
        if (hasRequiredNumberOfArgs(args, requiredNumberOfArguments)) {
            int validArgsCount = 0;
            for (String arg : args) {
                if (StringUtil.isNumeric(arg)) {
                    validArgsCount++;
                }
            }
            validArgs = (requiredNumberOfArguments == validArgsCount);
        }
        return  validArgs;
    }

    public static boolean hasRequiredNumberOfArgs(String[] args, int requiredNumberOfArguments) {
        return args.length >= requiredNumberOfArguments;
    }
}
