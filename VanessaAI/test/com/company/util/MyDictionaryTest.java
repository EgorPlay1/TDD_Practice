package com.company.util;

import com.company.model.WordType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDictionaryTest {

    @Test
    void testIsWordType() {
    }

    @Test
    void testLoadAll() {
        MyDictionary dictionary = new MyDictionary();

        long startTime = System.currentTimeMillis();
        dictionary.loadAll();
        long endTime = System.currentTimeMillis();
        System.out.println("Loading took " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        // "A man was walking over a bridge"
        assertTrue(dictionary.isWordType(WordType.NOUN, "man"));
        assertTrue(dictionary.isWordType(WordType.VERB, "walk"));
        assertTrue(dictionary.isWordType(WordType.ADJECTIVE, "over"));
        assertTrue(dictionary.isWordType(WordType.NOUN, "bridge"));
        endTime = System.currentTimeMillis();
        System.out.println("searching 4 words took " + (endTime - startTime) + " milliseconds");
    }

    @Test
    void testSaveAll() {
    }
}