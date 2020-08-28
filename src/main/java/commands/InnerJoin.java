package commands;

import models.FinalDataLine;
import models.StartDataLine;

import java.util.*;

public class InnerJoin {

    public static ArrayList<FinalDataLine> arrayJoin(List<StartDataLine> dataA, List<StartDataLine> dataB) {
        ArrayList<FinalDataLine> list = new ArrayList<>();
        for (int i = 0; i < dataA.size(); i++) {
            for (int j = 0; j < dataB.size(); j++) {
                if (dataA.get(i).getNumber() == dataB.get(j).getNumber()) {
                    list.add(new FinalDataLine(dataA.get(i).getNumber(), dataA.get(i).getValue(), dataB.get(j).getValue()));
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

    public static ArrayList<FinalDataLine> mapJoin(HashMap<StartDataLine, String> dataA, HashMap<StartDataLine, String> dataB) {
        ArrayList<FinalDataLine> list = new ArrayList<>();
        for (StartDataLine a : dataA.keySet()) {
            for (StartDataLine b : dataB.keySet()) {
                if (a.getNumber() == b.getNumber()) {
                    list.add(new FinalDataLine(a.getNumber(), a.getValue(), b.getValue()));
                }
            }
        }
        return list;
    }
}
