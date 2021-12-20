package com.company.controller;

import com.company.model.INFTGeneratorModel;

public interface INFTGeneratorController {
    public void init();

    public void setModel(INFTGeneratorModel model);

    void run();
}
