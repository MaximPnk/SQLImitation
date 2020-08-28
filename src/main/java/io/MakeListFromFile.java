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
    }

    private void addDataLineIfPossible(String line) throws NumberFormatException {
        if (line.isEmpty() || !line.matches("^\\d+,[a-zA-Zа-яА-Я]+$")) {
            return;
        }
        arrayList.add(new StartDataLine(Integer.parseInt(line.split(",")[0]), line.split(",")[1]));
        linkedList.add(new StartDataLine(Integer.parseInt(line.split(",")[0]), line.split(",")[1]));
        hashMap.put(new StartDataLine(Integer.parseInt(line.split(",")[0]), line.split(",")[1]), Integer.parseInt(line.split(",")[0]));
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
}
