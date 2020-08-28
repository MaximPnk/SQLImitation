package models;

import java.util.Objects;

public class StartDataLine implements Comparable<StartDataLine> {
    private int number;
    private String value;

    public StartDataLine(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return number + " " + value;
    }

    @Override
    public int compareTo(StartDataLine o) {
        return this.number - o.number;
    }
}
