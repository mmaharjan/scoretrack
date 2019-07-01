package com.webservices.scoretrack.constants;

public enum AppConstants {
    GAMEID_SEPARATOR ("_");

    private final String value;

    AppConstants(String str) {
        value = str;
    }

    public String toString() {
        return this.value;
    }

    public boolean equalsValue(String otherValue) {
        return value.equals(otherValue);
    }
}
