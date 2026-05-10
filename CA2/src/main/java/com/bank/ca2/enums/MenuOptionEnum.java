package com.bank.ca2.enums;

/**
 *
 * @author Gustavo
 */
public enum MenuOptionEnum {
    
    SORT(1, "Sort Employee List"),
    SEARCH(2, "Search Employee"),
    ADD_RECORD(3, "Add New Employee"),
    BINARY_TREE(4, "Create Employee Hierarchy (Binary Tree)"),
    EXIT(5, "Exit");

    private final int option;
    private final String label;

    MenuOptionEnum(int option, String label) {
        this.option = option;
        this.label = label;
    }

    public int getOption() {
        return option;
    }

    public String getLabel() {
        return label;
    }

    public static MenuOptionEnum getByValue(int value) {
        for (MenuOptionEnum opt : values()) {
            if (opt.getOption() == value) {
                return opt;
            }
        }
        return null;
    }
}