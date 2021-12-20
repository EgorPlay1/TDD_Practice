package com.company.model;

import com.company.util.Category;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class NFT {

    private int id;

    private LinkedHashMap<Category, String> attributes;

    private String picture;

    private String xml;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedHashMap<Category, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(LinkedHashMap<Category, String> attributes) {
        this.attributes = attributes;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public void generateID() {
        List<String> attrs = new ArrayList<>(attributes.values());
        StringBuilder toID = new StringBuilder();

        for (String atr : attrs) {
            toID.append(atr);
        }

        this.id = Math.abs(toID.toString().hashCode());
    }
}
