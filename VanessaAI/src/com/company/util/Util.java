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

}
