package PartIV;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private int val;
    private Image img;

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val = val;
        this.img = new ImageIcon(getImgName()).getImage();
        paint(getGraphics());
    }

    private String getImgName() {
        return String.format("die%d.png", val);
    }

    public ImagePanel(int val) {
        this(String.format("die%d.png", val));
        this.val = val;
    }

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        /*
         * setMinimumSize(size);
         * setMaximumSize(size);
         * setSize(size);
         */
        setLayout(new BorderLayout());
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 10, 0, null);
    }

}
