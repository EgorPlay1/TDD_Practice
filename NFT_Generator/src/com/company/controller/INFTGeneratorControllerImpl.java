package com.company.controller;

import com.company.model.INFTGeneratorModel;
import com.company.util.Category;

import java.io.File;
import java.util.*;

public class INFTGeneratorControllerImpl implements INFTGeneratorController{

    private INFTGeneratorModel model;

    @Override
    public void init() {

        LinkedHashMap<Category, List<String>> sourceFeatures = new LinkedHashMap<>();

        //read available attributes

        File folder = new File("D:\\nft\\sources\\");

        File[] listOfFiles = folder.listFiles();

        System.out.println("Reading file sources");

        for (File listOfFile : Objects.requireNonNull(listOfFiles)) {
            if (listOfFile.isFile()) {
                switch (listOfFile.getName().charAt(1)) {
                    case 'E':
                        if (!sourceFeatures.containsKey(Category.EYES)) {
                            sourceFeatures.put(Category.EYES, new ArrayList<>());
                        }
                        sourceFeatures.get(Category.EYES).add(listOfFile.getName().substring(0, 2));
                        continue;
                    case 'M':
                        if (!sourceFeatures.containsKey(Category.MOUTH)) {
                            sourceFeatures.put(Category.MOUTH, new ArrayList<>());
                        }
                        sourceFeatures.get(Category.MOUTH).add(listOfFile.getName().substring(0, 2));
                        continue;
                    case 'N':
                        if (!sourceFeatures.containsKey(Category.NOSE)) {
                            sourceFeatures.put(Category.NOSE, new ArrayList<>());
                        }
                        sourceFeatures.get(Category.NOSE).add(listOfFile.getName().substring(0, 2));
                        continue;
                    case 'A':
                        if (!sourceFeatures.containsKey(Category.ATTRIBUTES)) {
                            sourceFeatures.put(Category.ATTRIBUTES, new ArrayList<>());
                        }
                        sourceFeatures.get(Category.ATTRIBUTES).add(listOfFile.getName().substring(0, 2));
                        continue;
                    case 'H':
                        if (!sourceFeatures.containsKey(Category.HAIR)) {
                            sourceFeatures.put(Category.HAIR, new ArrayList<>());
                        }
                        sourceFeatures.get(Category.HAIR).add(listOfFile.getName().substring(0, 2));
                        continue;
                    case 'B':
                        if (!sourceFeatures.containsKey(Category.BACKGROUND)) {
                            sourceFeatures.put(Category.BACKGROUND, new ArrayList<>());
                        }
                        sourceFeatures.get(Category.BACKGROUND).add(listOfFile.getName().substring(0, 2));
                        continue;
                    case 'C':
                        if (!sourceFeatures.containsKey(Category.SKIN)) {
                            sourceFeatures.put(Category.SKIN, new ArrayList<>());
                        }
                        sourceFeatures.get(Category.SKIN).add(listOfFile.getName().substring(0, 2));
                        continue;
                    case 'S':
                        if (!sourceFeatures.containsKey(Category.SYMBOL)) {
                            sourceFeatures.put(Category.SYMBOL, new ArrayList<>());
                        }
                        sourceFeatures.get(Category.SYMBOL).add(listOfFile.getName().substring(0, 2));
                        continue;
                }
            }
        }

        model.loadSources(sourceFeatures);

        System.out.println("File sources loaded");

        //(bonus) read existing nfts
    }

    @Override
    public void setModel(INFTGeneratorModel model) {
        this.model = model;
    }

    @Override
    public void run() {
        model.generateNFTs(666);

//        List<String> noses = new ArrayList<>(Arrays.asList("BN", "MN", "EN", "ZN", "NN", "PN", "DN", "HN"));
//
//        for (int ii = 0; ii < 8; ii++) {
//            LinkedHashMap<Category, String> test1 = new LinkedHashMap<>();
//
//            test1.put(Category.EYES, "NE");
//            test1.put(Category.MOUTH, "NM");
//            test1.put(Category.NOSE, noses.get(ii));
//            test1.put(Category.ATTRIBUTES, "DA");
//            test1.put(Category.HAIR, "BH");
//            test1.put(Category.BACKGROUND, "HB");
//            test1.put(Category.SYMBOL, "DS");
//            test1.put(Category.SKIN, "BC");
//
//            model.generateNFT(test1);
//        }

        model.generatePictures();

        model.generateRarityList();
    }
}
