package models;

public class FinalDataLine {
    private Integer number;
    private String valueA;
    private String valueB;

    public FinalDataLine(int number, String valueA, String valueB) {
        this.number = number;
        this.valueA = valueA;
        this.valueB = valueB;
    }

    @Override
    public String toString() {
        return number + " " + valueA + " " + valueB;
    }
}
