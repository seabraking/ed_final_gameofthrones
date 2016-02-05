/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Vitor
 */
class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public ImagePanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
     Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.red);
    g2.fillOval(80, 50, 10, 10);
    g2.drawString("Castle Black", 80, 75);
    g2.fillOval(450, 230, 10, 10);
    g2.drawString("Vaes Dothrak", 450, 230);
    g2.setColor(Color.green);
    g2.drawLine(80, 50, 450, 230);
      
  }

}