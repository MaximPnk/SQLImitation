import io.RandomWriter;
import models.FinalDataLine;
import commands.InnerJoin;
import io.MakeListFromFile;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        if (checkArgsLength(args)) {

            /*
             * Закинет рандомные данные в аргументы
             * (Перепишет исходные файлы)
             */
//            RandomWriter.writer(args[0], args[1], 10000);

            MakeListFromFile dataA = new MakeListFromFile();
            dataA.readData(args[0]);
            MakeListFromFile dataB = new MakeListFromFile();
            dataB.readData(args[1]);

            //ArrayList
            long arrayStart = System.currentTimeMillis();
            ArrayList<FinalDataLine> arrayJoin = InnerJoin.arrayJoin(dataA.getArrayList(), dataB.getArrayList());
            long arrayFinish = System.currentTimeMillis();
            Collections.sort(arrayJoin);

            //LinkedList
            long linkedStart = System.currentTimeMillis();
            ArrayList<FinalDataLine> linkedJoin = InnerJoin.linkedJoin(dataA.getLinkedList(), dataB.getLinkedList());
            long linkedFinish = System.currentTimeMillis();

            //HashMap
            long mapStart = System.currentTimeMillis();
            ArrayList<FinalDataLine> mapJoin = InnerJoin.mapJoin(dataA.getHashMap(), dataB.getHashMap());
            long mapFinish = System.currentTimeMillis();

            //HashMap с логикой equals
            long equalsMapStart = System.currentTimeMillis();
            ArrayList<FinalDataLine> equalsMapJoin = InnerJoin.equalsMapJoin(dataA.getMap(), dataB.getMap());
            long equalsMapFinish = System.currentTimeMillis();


            int min = Math.min(Math.min(Math.min(arrayJoin.size(), linkedJoin.size()), mapJoin.size()), equalsMapJoin.size()); //на случай ошибки в логике
            for (int i = 0; i < min; i++) {
                System.out.printf("%-25s%-25s%-25s%-25s\n", arrayJoin.get(i), linkedJoin.get(i), mapJoin.get(i), equalsMapJoin.get(i));
            }
            System.out.printf("%-25s%-25s%-25s%-25s\n", "ArrayList", "Sorted LinkedList", "HashMap", "HashMap with some logic");
            System.out.println();
            System.out.println("Перебор ArrayList: " + (arrayFinish - arrayStart) + " миллисекунд. Кол-во джоинов = " + arrayJoin.size());
            System.out.println("Логика с listIterator и отсортированного LinkedList: " + (linkedFinish - linkedStart) + " миллисекунд. Кол-во джоинов = " + linkedJoin.size());
            System.out.println("Мапа: " + (mapFinish - mapStart) + " миллисекунд. Кол-во джоинов = " + mapJoin.size());
            System.out.println("Мапа с логикой equals: " + (equalsMapFinish - equalsMapStart) + " миллисекунд. Кол-во джоинов = " + equalsMapJoin.size());
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
