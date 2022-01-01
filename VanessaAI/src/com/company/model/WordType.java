package com.company.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum WordType {

    NOUN,
    VERB,
    ADJECTIVE,
    ADVERB,
    WHO,
    WHEN,
    WHERE,
    WHY,
    WHAT,
    QUESTION_MARK,
    CUSTOM_KNOWN_SUBJECT,
    CUSTOM_UNKNOWN_SUBJECT;

    //TODO: finish up after tech design


    public static List<WordType> getQuestions() {
        return new ArrayList<WordType>(Arrays.asList(QUESTION_MARK));
    }
}
