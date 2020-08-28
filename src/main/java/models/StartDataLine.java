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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartDataLine that = (StartDataLine) o;
        return number == that.number &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
