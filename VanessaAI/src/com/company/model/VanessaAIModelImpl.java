package com.company.model;

import com.company.util.MyDictionary;
import com.company.util.Util;

import java.util.ArrayList;
import java.util.Arrays;

public class VanessaAIModelImpl implements IVanessaAIModel {

    //private History history;

    private MyDictionary dictionary;

    public void init() {
        this.dictionary = new MyDictionary();
        this.dictionary.loadAll();
    }

    @Override
    public void loadHistory(String storageFile) {

    }

    @Override
    public String talk(String in) {
        String inCorrected = Util.correct(in);
        Sentence sentence = this.StringToSentence(inCorrected);



        return "";
    }

    private Sentence StringToSentence(String inCorrected) {
        ArrayList<String> sources = new ArrayList<>(Arrays.asList(inCorrected.split(" ")));

        Sentence sentence = new Sentence();
        sentence.setAuthor("player");
        sentence.setOrig(inCorrected);

        for (String source : sources) {
            if (source.indexOf(',') != -1) {
                source = source.substring(0, source.indexOf(','));
            } else if (source.indexOf('.') != -1) {
                source = source.substring(0, source.indexOf('.'));
            } else if (source.indexOf('?') != -1) {
                source = source.substring(0, source.indexOf('?'));
                sources.add("?");
            }

            sentence.addWord(source, this.getWordType(source));

        }

        return sentence;

    }

    private WordType getWordType(String source) {
        for (WordType wordType : WordType.values()) {
            if (dictionary.isWordType(wordType, source)) {
                return wordType;
            }
        }

        return null;
    }

//    public History getHistory() {
//        return history;
//    }
//
//    public void setHistory(History history) {
//        this.history = history;
//    }

    public void setDictionary(MyDictionary dictionary) {
        this.dictionary = dictionary;
    }
}
