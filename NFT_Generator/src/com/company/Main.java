package com.company;

import com.company.controller.INFTGeneratorController;
import com.company.controller.INFTGeneratorControllerImpl;
import com.company.model.INFTGeneratorModel;
import com.company.model.NFTGeneratorModelImpl;

public class Main {

    public static void main(String[] args) {
        INFTGeneratorController controller = new INFTGeneratorControllerImpl();
        INFTGeneratorModel model = new NFTGeneratorModelImpl();

        controller.setModel(model);

        controller.init();

        controller.run();
    }
}
