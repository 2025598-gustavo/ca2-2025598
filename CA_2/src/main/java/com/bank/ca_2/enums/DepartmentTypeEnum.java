package com.bank.ca_2.enums;

/**
 * Enum representing all available departments in the organisation system.
 * 
 * Each department contains:
 * - Numeric menu option
 * - Display label
 * 
 * @author Gustavo
 */
public enum DepartmentTypeEnum {

    IT_DEVELOPMENT(1, "IT Development"),
    SALES(2, "Sales"),
    HR(3, "HR"),
    FINANCE(4, "Finance"),
    MARKETING(5, "Marketing"),
    ACCOUNTING(6, "Accounting"),
    OPERATIONS(7, "Operations"),
    TECHNICAL_SUPPORT(8, "Technical Support"),
    CUSTOMER_SERVICE(9, "Customer Service"),
    UNKNOWN(0, "Unknown");

    /**
     * Numeric option displayed in the menu.
     */
    private final int option;

    /**
     * User-friendly department label.
     */
    private final String label;

    /**
     * Enum constructor.
     * 
     * @param option numeric menu option
     * @param label display label
     */
    DepartmentTypeEnum(int option, String label) {
        this.option = option;
        this.label = label;
    }

    /**
     * Returns department menu option.
     * 
     * @return numeric option
     */
    public int getOption() {
        return option;
    }

    /**
     * Returns department display label.
     * 
     * @return department label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Finds a department enum based on numeric option.
     * 
     * @param value menu option
     * @return matching department or null if not found
     */
    public static DepartmentTypeEnum getByValue(int value) {

        for (DepartmentTypeEnum dept : values()) {

            if (dept.option == value) {
                return dept;
            }
        }

        return null;
    }

    /**
     * Converts a String value into DepartmentTypeEnum.
     * Used when reading department values from file.
     * 
     * @param value department name from file
     * @return matching department enum or UNKNOWN
     */
    public static DepartmentTypeEnum fromString(String value) {

        if (value == null || value.isBlank()) {
            return UNKNOWN;
        }

        return switch (value.toLowerCase()) {
            case "it development" -> IT_DEVELOPMENT;
            case "sales" -> SALES;
            case "hr" -> HR;
            case "finance" -> FINANCE;
            case "marketing" -> MARKETING;
            case "accounting" -> ACCOUNTING;
            case "operations" -> OPERATIONS;
            case "technical support" -> TECHNICAL_SUPPORT;
            case "customer service" -> CUSTOMER_SERVICE;
            default -> UNKNOWN;
        };
    }
}