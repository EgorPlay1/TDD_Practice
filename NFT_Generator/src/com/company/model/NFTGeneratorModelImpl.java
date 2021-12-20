package com.company.model;

import com.company.util.Category;
import com.company.util.ImageUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class NFTGeneratorModelImpl implements INFTGeneratorModel{

    private LinkedHashMap<Integer, NFT> NFTs;

    private LinkedHashMap<Category, List<String>> sourceFeatures;

    private ImageUtils imageUtils = new ImageUtils();

    @Override
    public void generateNFTs(int n) {
        Random rand = new Random();

        if (NFTs == null) {
            NFTs = new LinkedHashMap<>();
        }

       while (NFTs.keySet().size() < n) {
            LinkedHashMap<Category, String> nft = new LinkedHashMap<Category, String>();
            for (Category attr : sourceFeatures.keySet()) {
                nft.put(attr, sourceFeatures.get(attr).get(rand.nextInt(sourceFeatures.get(attr).size())));
            }
            try {
                generateNFT(nft);
            } catch (Exception e) {
                // this NFT already exists but this is extremely unlikely
            }
       }
        System.out.println("Generated NFT objects");
    }

    @Override
    public void generateNFT(LinkedHashMap<Category, String> layout) {

        if (NFTs == null) {
            NFTs = new LinkedHashMap<>();
        }

        NFT newNFT = new NFT();
        newNFT.setAttributes(layout);
        newNFT.generateID();
        if (NFTs.containsKey(newNFT.getId())) {
            throw new RuntimeException("This NFT already exists, try to generate a different one!");
        } else {
            this.NFTs.put(newNFT.getId(), newNFT);
        }
    }

    @Override
    public void generatePictures() {
        for (NFT nft : NFTs.values()) {
            nft.setPicture(imageUtils.generateFromNFT(nft));
        }
        System.out.println("Generated Images");
    }

    @Override
    public void generateXMLs() {

    }

    @Override
    public NFT getNFTByID(int id) {
        return NFTs.get(id);
    }

    @Override
    public NFT getNFTByLayout(LinkedHashMap<Category, String> layout) {
        NFT newNFT = new NFT();
        newNFT.setAttributes(layout);
        newNFT.generateID();
        return NFTs.get(newNFT.getId());
    }

    @Override
    public void loadSources(LinkedHashMap<Category, List<String>> sourceFeatures) {
        this.sourceFeatures = sourceFeatures;
    }

    @Override
    public void loadNFTs(LinkedHashMap<Integer, NFT> nfts) {
        this.NFTs = nfts;
    }

    @Override
    public void generateRarityList() {
        int banshee = 0;
        int maria = 0;
        int bee = 0;
        int zombie = 0;
        int nun = 0;
        int pin = 0;
        int demon = 0;
        int hypno = 0;

        for (NFT nft : NFTs.values()) {

        }
    }


}
