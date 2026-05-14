package com.bank.ca_2.enums;

/**
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

    private final int option;
    private final String label;

    DepartmentTypeEnum(int option, String label) {

        this.option = option;
        this.label = label;
    }

    public int getOption() {
        return option;
    }

    public String getLabel() {
        return label;
    }

    public static DepartmentTypeEnum getByValue(int value) {

        for (DepartmentTypeEnum dept : values()) {

            if (dept.option == value) {
                return dept;
            }
        }

        return null;
    }

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