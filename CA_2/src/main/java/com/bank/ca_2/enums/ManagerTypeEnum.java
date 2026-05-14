package com.bank.ca_2.enums;

/**
 * Enum representing all manager typesv available in the organisation system.
 * 
 * Each manager type contains:
 * - Numeric menu option
 * - Display label
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

    /**
     * Numeric option displayed in the menu.
     */
    private final int option;

    /**
     * User-friendly manager type label.
     */
    private final String label;

    /**
     * Enum constructor.
     * 
     * @param option numeric menu option
     * @param label display label
     */
    ManagerTypeEnum(int option, String label) {

        this.option = option;
        this.label = label;
    }

    /**
     * Returns manager menu option.
     * 
     * @return numeric option
     */
    public int getOption() {
        return option;
    }

    /**
     * Returns manager display label.
     * 
     * @return manager label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Finds a manager type based on numeric option.
     * 
     * @param value menu option
     * @return matching manager type or null
     */
    public static ManagerTypeEnum getByValue(int value) {

        for (ManagerTypeEnum type : values()) {

            if (type.option == value) {
                return type;
            }
        }

        return null;
    }

    /**
     * Converts a String value into ManagerTypeEnum.
     * Used when reading manager values from file.
     * 
     * @param value manager type from file
     * @return matching manager type or UNKNOWN
     */
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