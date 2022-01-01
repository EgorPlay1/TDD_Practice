package com.company.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Sentence {

    private String orig;

    private ArrayList<WordType> structure;

    private LinkedHashMap<WordType, String> wordsByType;

    private Boolean question;

    private String author;


    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public ArrayList<WordType> getStructure() {
        return structure;
    }

    public void setStructure(ArrayList<WordType> structure) {
        this.structure = structure;
    }

    public LinkedHashMap<WordType, String> getWordsByType() {
        return wordsByType;
    }

    public void setWordsByType(LinkedHashMap<WordType, String> wordsByType) {
        this.wordsByType = wordsByType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getQuestion() {
        return question;
    }

    public void setQuestion(Boolean question) {
        this.question = question;
    }

    public void addWord(String source, WordType wordType) {
        if (this.getStructure() == null) {
            this.setStructure(new ArrayList<>());
        }

        this.getStructure().add(wordType);

        if (this.getWordsByType() == null) {
            this.setWordsByType(new LinkedHashMap<>());
        }

        this.getWordsByType().put(wordType, source);

        this.setQuestion(this.getQuestion() || WordType.getQuestions().contains(wordType));
    }
}
