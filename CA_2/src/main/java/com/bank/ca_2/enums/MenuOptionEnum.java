package com.bank.ca_2.enums;

/**
 * Enum representing all main menu options available in the application.
 * 
 * Each option contains:
 * - Numeric menu option
 * - Display label
 * 
 * @author Gustavo
 */
public enum MenuOptionEnum {

    SORT(1, "Sort Employee List"),
    SEARCH(2, "Search Employee"),
    ADD_RECORD(3, "Add New Employee"),
    BINARY_TREE(4, "Create Employee Hierarchy (Binary Tree)"),
    EXIT(5, "Exit");

    /**
     * Numeric option displayed in menu.
     */
    private final int option;

    /**
     * User menu label.
     */
    private final String label;

    /**
     * Enum constructor.
     * 
     * @param option numeric menu option
     * @param label menu label
     */
    MenuOptionEnum(int option, String label) {
        this.option = option;
        this.label = label;
    }

    /**
     * Returns menu numeric option.
     * 
     * @return menu option
     */
    public int getOption() {
        return option;
    }

    /**
     * Returns menu display label.
     * 
     * @return menu label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Finds menu option based on numeric value.
     * 
     * @param value selected menu option
     * @return matching enum option or null
     */
    public static MenuOptionEnum getByValue(int value) {
        for (MenuOptionEnum opt : values()) {
            if (opt.getOption() == value) {
                return opt;
            }
        }
        return null;
    }
}