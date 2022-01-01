package com.company.util;

import com.company.model.WordType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MyDictionary {

    private LinkedHashMap<WordType, ArrayList<String>> dictionary;

    public Boolean isWordType(WordType wordType, String word) {
        return this.dictionary.get(wordType).contains(word);
    }

    public void loadAll() {
        this.dictionary = new LinkedHashMap<WordType, ArrayList<String>>();
        for (WordType wordType : WordType.values()) {
            try {
                dictionary.put(wordType, Util.loadWordsFromFile(wordType.toString() + ".txt"));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error reading sources! Check file integrity");
            }
        }
    }

    public void saveAll() {
        for (WordType wordType : dictionary.keySet()) {
            Util.saveWordsToFile(wordType.toString() + ".txt", dictionary.get(wordType));
        }
    }
}
