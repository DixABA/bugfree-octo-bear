/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dixaba;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author DirectoriX
 */
public class JImagePanel extends javax.swing.JPanel {

    private Image img;

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    /**
     * @param img the img to set
     */
    public void setImg(Image img) {
        this.img = img;
    }

}
