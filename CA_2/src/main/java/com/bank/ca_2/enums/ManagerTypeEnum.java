package com.bank.ca_2.enums;

/**
 *
 * @author Gustavo
 */
public enum ManagerTypeEnum {

    SENIOR(1, "Senior"),
    MIDDLE(2, "Middle"),
    JUNIOR(3, "Junior"),
    INTERN(4, "Intern"),
    CONTRACT(5, "Contract"),
    UNKNOWN(0, "Unknown");

    private final int option;
    private final String label;

    ManagerTypeEnum(int option, String label) {
        this.option = option;
        this.label = label;
    }

    public int getOption() {
        return option;
    }

    public String getLabel() {
        return label;
    }

    public static ManagerTypeEnum getByValue(int value) {
        for (ManagerTypeEnum type : values()) {
            if (type.option == value) {
                return type;
            }
        }
        return null;
    }

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