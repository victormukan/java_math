package com.sofia.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HistoryDateParser {
    public static LocalDateTime getMinSatisfyingDate(String period) {
        LocalDateTime now = LocalDateTime.now();

        String dateSuffix = period.substring(period.length() - 1);
        int periodValue = Integer.valueOf(period.substring(0, period.length() - 1));

        LocalDateTime minSatisfyingDate = null;

        switch (dateSuffix) {
            case "s":
                minSatisfyingDate = now.minusSeconds(periodValue);
                break;
            case "h":
                minSatisfyingDate = now.minusHours(periodValue);
                break;
            case "d":
                minSatisfyingDate = now.minusDays(periodValue);
                break;
            case "w":
                minSatisfyingDate = now.minusWeeks(periodValue);
                break;
            case "m":
                minSatisfyingDate = now.minusMonths(periodValue);
                break;
        }
        return minSatisfyingDate;
    }
}
