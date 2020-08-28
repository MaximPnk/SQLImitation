package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RandomWriter {

    public static void writer(String fileName, String fileName2, int n) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < n; i++) {
                writer.write((int) (Math.random()*n + 1) + "," + ((char) (int) (Math.random()*26 + 65)) + ((char) (int) (Math.random()*26 + 65)) + ((char) (int) (Math.random()*26 + 65)) + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
            for (int i = 0; i < n/2; i++) {
                writer.write((int) (Math.random()*n + 1) + "," + ((char) (int) (Math.random()*26 + 65)) + ((char) (int) (Math.random()*26 + 65)) + ((char) (int) (Math.random()*26 + 65)) + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
