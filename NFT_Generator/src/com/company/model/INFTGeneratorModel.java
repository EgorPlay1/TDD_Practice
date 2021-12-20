package com.company.model;

import com.company.util.Category;

import java.util.LinkedHashMap;
import java.util.List;

public interface INFTGeneratorModel {

    public void generateNFTs(int n);

    public void generateNFT(LinkedHashMap<Category, String> layout);

    public void generatePictures();

    public void generateXMLs();

    public NFT getNFTByID(int id);

    public NFT getNFTByLayout(LinkedHashMap<Category, String> layout);

    public void loadSources(LinkedHashMap<Category, List<String>> sourceFeatures);

    public void loadNFTs(LinkedHashMap<Integer, NFT> nfts);

    public void generateRarityList();
}
