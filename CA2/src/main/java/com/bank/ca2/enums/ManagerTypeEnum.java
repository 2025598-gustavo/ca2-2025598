package com.bank.ca2.enums;

/**
 *
 * @author Gustavo
 */
public enum ManagerTypeEnum {

    SENIOR,
    MIDDLE,
    JUNIOR,
    INTERN,
    CONTRACT,
    UNKNOWN;

    public static ManagerTypeEnum fromString(String value) {

        if (value == null || value.isBlank()) {
            return UNKNOWN;
        }

        return switch (value.toLowerCase()) {

            case "senior" -> SENIOR;

            case "middle" -> MIDDLE;

            case "junior" -> JUNIOR;

            case "intern" -> INTERN;

            case "contract" -> CONTRACT;

            default -> UNKNOWN;
        };
    }
}