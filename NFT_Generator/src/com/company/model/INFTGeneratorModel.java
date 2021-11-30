package com.company.model;

import java.util.LinkedHashMap;
import java.util.List;

public interface INFTGeneratorModel {

    public void generateNFTs(int n);

    public void generateNFT(LinkedHashMap<String, String> layout);

    public void generatePictures();

    public void generateXMLs();

    public NFT getNFTByID(int id);

    public NFT getNFTByLayout(LinkedHashMap<String, String> layout);
}
