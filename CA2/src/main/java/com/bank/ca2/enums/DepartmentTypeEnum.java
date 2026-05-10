package com.bank.ca2.enums;

/**
 *
 * @author Gustavo
 */
public enum DepartmentTypeEnum {

    IT_DEVELOPMENT,
    SALES,
    HR,
    FINANCE,
    MARKETING,
    ACCOUNTING,
    OPERATIONS,
    TECHNICAL_SUPPORT,
    CUSTOMER_SERVICE,
    UNKNOWN;

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