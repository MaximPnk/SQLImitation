package models;

public class FinalDataLine implements Comparable<FinalDataLine> {
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

    @Override
    public int compareTo(FinalDataLine o) {
        return this.number - o.number;
    }
}
