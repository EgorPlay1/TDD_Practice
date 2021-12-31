package com.company.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilTest {

    @Test
    public void testLoadWordsFromFile() throws IOException {
        ArrayList<String> test_source = Util.loadWordsFromFile("english-nouns.txt");

        String test = "try";

        //assertTrue(Util.fastContains(test_source, test));

        long startTime = System.currentTimeMillis();
        Boolean exitst = test_source.contains(test);
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        if (exitst) {
            System.out.println("exists");
        }
    }
}