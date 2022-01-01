package com.company.util;

import java.io.*;
import java.util.ArrayList;

public class Util {

    public static ArrayList<String> loadWordsFromFile(String file) throws IOException {
        File source = new File("D:\\vanessa\\sources\\" + file);

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(source));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found!");
        }

        ArrayList<String> out = new ArrayList<>();
        String temp;

        while ((temp = br.readLine()) != null) {
            out.add(temp);
        }

        return out;
    }

    public static void saveWordsToFile(String s, ArrayList<String> strings) {
        //TODO: Make a way to save to file i.e. reverse the method above;s
    }

    public static String correct(String in) {
        try {
            return new Spelling("D:\\vanessa\\sources\\big.txt").correct(in);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File for spelling corrections not found!");
        }
    }
}
