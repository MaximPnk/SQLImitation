import io.RandomWriter;
import models.FinalDataLine;
import models.StartDataLine;
import commands.InnerJoin;
import io.MakeListFromFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        if (checkArgsLength(args)) {

            /*
             * Закинет рандомные данные в аргументы
             * (Перепишет исходные файлы)
             */
            //RandomWriter.writer(args[0], args[1], 10000);

            MakeListFromFile dataA = new MakeListFromFile();
            dataA.readData(args[0]);
            MakeListFromFile dataB = new MakeListFromFile();
            dataB.readData(args[1]);

            //ArrayList
            ArrayList<StartDataLine> arrayListA = dataA.getArrayList();
            ArrayList<StartDataLine> arrayListB = dataB.getArrayList();
            long arrayStart = System.currentTimeMillis();
            ArrayList<FinalDataLine> arrayJoin = InnerJoin.arrayJoin(arrayListA, arrayListB);
            long arrayFinish = System.currentTimeMillis();
            for (FinalDataLine data : arrayJoin) {
                System.out.println(data);
            }
            System.out.println();

            //LinkedList
            LinkedList<StartDataLine> linkedListA = dataA.getLinkedList();
            LinkedList<StartDataLine> linkedListB = dataB.getLinkedList();
            long linkedStart = System.currentTimeMillis();
            ArrayList<FinalDataLine> linkedJoin = InnerJoin.linkedJoin(linkedListA, linkedListB);
            long linkedFinish = System.currentTimeMillis();
            for (FinalDataLine data : linkedJoin) {
                System.out.println(data);
            }
            System.out.println();

            //HashMap
            HashMap<StartDataLine, String> mapA = dataA.getHashMap();
            HashMap<StartDataLine, String> mapB = dataB.getHashMap();
            long mapStart = System.currentTimeMillis();
            ArrayList<FinalDataLine> mapJoin = InnerJoin.mapJoin(mapA, mapB);
            long mapFinish = System.currentTimeMillis();
            for (FinalDataLine data : mapJoin) {
                System.out.println(data);
            }
            System.out.println();

            System.out.println("Перебор ArrayList: " + (arrayFinish - arrayStart) + " миллисекунд. Кол-во джоинов = " + arrayJoin.size());
            System.out.println("Логика с listIterator и отсортированного LinkedList: " + (linkedFinish - linkedStart) + " миллисекунд. Кол-во джоинов = " + linkedJoin.size());
            System.out.println("Мапа: " + (mapFinish - mapStart) + " миллисекунд. Кол-во джоинов = " + mapJoin.size());
        }
    }

    public static boolean checkArgsLength(String[] args) {
        if (args.length != 2) {
            System.out.println("Запуск программы происходит со следующими параметрами: \"ИМЯ_ФАЙЛА_1\" \"ИМЯ_ФАЙЛА_2\"");
            return false;
        }
        return true;
    }
}
