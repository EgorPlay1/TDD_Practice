package com.company.util;

import com.company.model.NFT;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.company.util.Category.*;

public class ImageUtils {

    int generatedImages = 0;

    public String generateFromNFT(NFT nft) {
        ArrayList<Category> layerNames = new ArrayList<>(Arrays.asList(BACKGROUND, SKIN, EYES, NOSE, MOUTH, HAIR, SKIN, SYMBOL, ATTRIBUTES));
        ArrayList<BufferedImage> layers = new ArrayList<>(9);

        File path = new File("D:\\nft\\sources\\");

        for (int ii = 0; ii < 9; ii++) {
            File imagePath;
            if (ii == 6) {
                String name = nft.getAttributes().get(layerNames.get(ii)).charAt(0) + "R";
                imagePath = new File(path, name + ".png");
            } else {
                imagePath = new File(path, nft.getAttributes().get(layerNames.get(ii)) + ".png");
            }
            BufferedImage image = null;
            try {
                image = ImageIO.read(imagePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            layers.add(image);
        }

        int w = layers.get(0).getWidth();
        int h = layers.get(0).getHeight();
        BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics g = result.getGraphics();

        for (BufferedImage layer : layers) {
            g.drawImage(layer, 0, 0, null);
        }

        g.dispose();

        path = new File("D:\\nft\\results\\");

        try {
            ImageIO.write(result, "PNG", new File(path, nft.getId() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.generatedImages++;

        if (generatedImages % 10 == 0) {
            System.out.println("Generated images " + generatedImages + "/666");
        }

        return path + Integer.toString(nft.getId()) + ".png";
    }
}
