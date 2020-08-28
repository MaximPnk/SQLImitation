package io;

import models.StartDataLine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MakeListFromFile {
    private ArrayList<StartDataLine> arrayList = new ArrayList<>();
    private LinkedList<StartDataLine> linkedList = new LinkedList<>();
    private HashMap<StartDataLine, Integer> hashMap = new HashMap<>();
    private HashMap<Integer, String> equalsHashMap = new HashMap<>();

    public void readData(String fileName) {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                line = reader.readLine();
                addDataLineIfPossible(line);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        copy(arrayList);
    }

    private void addDataLineIfPossible(String line) throws NumberFormatException {
        if (line.isEmpty() || !line.matches("^\\d+,[a-zA-Zа-яА-Я]+$")) {
            return;
        }
        arrayList.add(new StartDataLine(Integer.parseInt(line.split(",")[0]), line.split(",")[1]));
    }

    private void copy(ArrayList<StartDataLine> arrayList) {
        linkedList = new LinkedList<>(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            hashMap.put(arrayList.get(i), arrayList.get(i).getNumber());
            int finalI = i;
            equalsHashMap.computeIfPresent(arrayList.get(i).getNumber(), (key, value) -> value + "#" + arrayList.get(finalI).getValue());
            equalsHashMap.putIfAbsent(arrayList.get(i).getNumber(), arrayList.get(i).getValue());
        }
    }

    public ArrayList<StartDataLine> getArrayList() {
        return arrayList;
    }

    public LinkedList<StartDataLine> getLinkedList() {
        return linkedList;
    }

    public HashMap<StartDataLine, Integer> getHashMap() {
        return hashMap;
    }

    public HashMap<Integer, String> getEqualsHashMap() {
        return equalsHashMap;
    }
}
