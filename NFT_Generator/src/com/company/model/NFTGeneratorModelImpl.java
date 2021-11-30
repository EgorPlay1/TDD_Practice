package com.company.model;

import java.util.LinkedHashMap;

public class NFTGeneratorModelImpl implements INFTGeneratorModel{

    LinkedHashMap<Integer, NFT> NFTs;

    LinkedHashMap<Integer, Integer> AttributesMap;

    @Override
    public void generateNFTs(int n) {

    }

    @Override
    public void generateNFT(LinkedHashMap<String, String> layout) {

    }

    @Override
    public void generatePictures() {

    }

    @Override
    public void generateXMLs() {

    }

    @Override
    public NFT getNFTByID(int id) {
        return null;
    }

    @Override
    public NFT getNFTByLayout(LinkedHashMap<String, String> layout) {
        return null;
    }

}
