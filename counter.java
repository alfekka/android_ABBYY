package com.abbyy.hw3;

import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class CCounter {
    public static void main(String[] args) {
        String TextPath = "./Hamlet.txt";
        String ResultPath = "./result.txt";
        Map<Character, Integer> amount = new HashMap<Character, Integer>();

        try (Reader fileReader = new FileReader(TextPath)) {
            Reader inputStream = new BufferedReader(fileReader);
            char[] input = new char[1];

            while (true) {
                int res = inputStream.read(input);
                char symbol = input[0];
                if (res == -1) {
                    break;
                }
                if (amount.containsKey(symbol)) {
                    Integer value = Integer.sum(amount.get(symbol), 1);
                    amount.put(symbol, value);
                } else {
                    amount.put(symbol, 0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        try (Writer fileWriter = new FileWriter(ResultPath)) {
            charCounts.forEach((key, value) -> {
                try {
                    fileWriter.write(key.toString() + ":" + value.toString()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(3);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        }
    }
}
    }
}