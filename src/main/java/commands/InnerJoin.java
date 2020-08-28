package commands;

import models.FinalDataLine;
import models.StartDataLine;

import java.util.*;

public class InnerJoin {

    public static ArrayList<FinalDataLine> arrayJoin(List<StartDataLine> dataA, List<StartDataLine> dataB) {
        ArrayList<FinalDataLine> list = new ArrayList<>();
        for (StartDataLine startDataLine : dataA) {
            for (StartDataLine dataLine : dataB) {
                if (startDataLine.getNumber() == dataLine.getNumber()) {
                    list.add(new FinalDataLine(startDataLine.getNumber(), startDataLine.getValue(), dataLine.getValue()));
                }
            }
        }
        return list;
    }

    public static ArrayList<FinalDataLine> linkedJoin(List<StartDataLine> dataA, List<StartDataLine> dataB) {
        Collections.sort(dataA);
        Collections.sort(dataB);
        ArrayList<FinalDataLine> list = new ArrayList<>();
        ListIterator<StartDataLine> listIteratorA = dataA.listIterator();
        ListIterator<StartDataLine> listIteratorB = dataB.listIterator();

        while (listIteratorA.hasNext()) {
            StartDataLine a = listIteratorA.next();
            while (listIteratorB.hasNext()) {
                StartDataLine b = listIteratorB.next();
                if (a.getNumber() == b.getNumber()) {
                    list.add(new FinalDataLine(a.getNumber(), a.getValue(), b.getValue()));
                    if (!listIteratorB.hasNext() && listIteratorA.hasNext() && a.getNumber() == listIteratorA.next().getNumber()) {
                        listIteratorA.previous();
                        while (listIteratorB.hasPrevious()) {
                            if (a.getNumber() > listIteratorB.previous().getNumber()) {
                                break;
                            }
                        }
                        break;
                    }
                } else if (listIteratorA.hasNext() && a.getNumber() < b.getNumber()) {
                    if (a.getNumber() == listIteratorA.next().getNumber()) {
                        listIteratorA.previous();
                        while (listIteratorB.hasPrevious()) {
                            if (a.getNumber() > listIteratorB.previous().getNumber()) {
                                break;
                            }
                        }
                    } else {
                        if (listIteratorB.hasPrevious()) {
                            listIteratorA.previous();
                            listIteratorB.previous();
                        }
                    }
                    break;
                }
            }
        }
        return list;
    }

    public static ArrayList<FinalDataLine> mapJoin(HashMap<StartDataLine, Integer> dataA, HashMap<StartDataLine, Integer> dataB) {
        ArrayList<FinalDataLine> list = new ArrayList<>();
        for (Map.Entry<StartDataLine, Integer> mapA : dataA.entrySet()) {
            for (Map.Entry<StartDataLine, Integer> mapB : dataB.entrySet()) {
                if (mapA.getValue().equals(mapB.getValue())) {
                    list.add(new FinalDataLine(mapA.getValue(), mapA.getKey().getValue(), mapA.getKey().getValue()));
                }
            }
        }
        return list;
    }
}
