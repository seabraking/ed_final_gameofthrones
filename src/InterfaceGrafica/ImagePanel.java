/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import Classes.Cidade;
import Classes.Dijkstra;
import ED_12_Parte1_Ex2.ArrayIterator;
import ED_12_Parte1_Ex2.ArrayUnorderedList;
import ED_12_Parte1_Ex2.EmptyCollectionException;
import ED_12_Parte1_Ex2.LinkedQueue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Vitor
 */
class ImagePanel extends JPanel {

  private Image img;
  LinkedQueue path = new LinkedQueue();
    ArrayUnorderedList<String> pathList = new ArrayUnorderedList();
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
  
  public void sendShorthestPath(LinkedQueue paths){
      while(!paths.isEmpty()){
          this.path.enqueue(paths.dequeue());
      }
      pathList = new ArrayUnorderedList<>();
  }

  public void paintComponent(Graphics g) {
      
    g.drawImage(img, 0, 0, null);
     Graphics2D g2 = (Graphics2D)g;
     g.setFont(new Font("default", Font.BOLD, 12));
    g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

    if(!path.isEmpty()){
        g2.setColor(Color.MAGENTA);
        g2.drawString("Shortest Path", 500, 20);
        g2.setColor(Color.DARK_GRAY);
        int count=35;
        while(!path.isEmpty()) {
            pathList.addToFront(path.dequeue().toString());
            try {
                g2.drawString(pathList.first(), 500, count);
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            count+=15;
        }
         
    }
    

    ArrayIterator<String> ai = pathList.iterator();
      int found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Vaes")){
            found += 1;
        }
        if(x.contains("Castle")){
            found += 1;
        }
    }
    if(found==2){
        g2.setColor(Color.red);
    } else {
        g2.setColor(Color.green);
    }
   
    //Voes Dar, - Castle Black
    g2.drawLine(80, 55, 450, 235);
    g2.setColor(Color.green);
    ai = pathList.iterator();
    found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Castle")){
            found += 1;
        }
        if(x.contains("Winterfell")){
            found += 1;
        }
    }
    if(found==2){
        g2.setColor(Color.red);
    } else {
        g2.setColor(Color.green);
    }
    //Castle Black - Winterfell
    g2.drawLine(80, 55, 40, 100);
    
    ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Winter")){
            found += 1;
        }
        if(x.contains("The")){
            found += 1;
        }
    }
    if(found==2){
        g2.setColor(Color.red);
    } else {
        g2.setColor(Color.green);
    }
    //Winterfell - the eeyrie
    g2.drawLine(40, 100, 105, 180);
    
    //The eyerie - Cross
    ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("The")){
            found += 1;
        }
        if(x.contains("Cross")){
            found += 1;
        }
    }
    if(found==2){
        g2.setColor(Color.red);
    } else {
        g2.setColor(Color.green);
    }
    g2.drawLine(105, 180, 85, 200);
    g2.setColor(Color.green);
    g2.drawLine(40, 100, 85, 200);
    g2.drawLine(85, 200, 92, 240);
    
    //Pentos -- Crossroads Inn
    g2.drawLine(172, 230, 85, 200);
     //Pentos -- King's Landing
    g2.drawLine(172, 230, 92, 240);
    
    //Pentos -- The eyrie
     //The eyerie - Cross
    ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Pentos")){
            found += 1;
        }
        if(x.contains("The")){
            found += 1;
        }
    }
    if(found==2){
        g2.setColor(Color.red);
    } else {
        g2.setColor(Color.green);
    }
    g2.drawLine(172, 230, 105, 180);
    g2.setColor(Color.green);
    // Qohor - Vaes
     ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Vaes")){
            found += 1;
        }
        if(x.contains("Qohor")){
            found += 1;
        }
    }
    if(found==2){
        g2.setColor(Color.red);
    } else {
        g2.setColor(Color.green);
    }
    g2.drawLine(250, 240, 450, 235);
    g2.setColor(Color.green);
    // Qohor - Pentos
     ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Qohor")){
            found += 1;
        }
        if(x.contains("Pentos")){
            found += 1;
        }
    }
    if(found==2){
        g2.setColor(Color.red);
    } else {
        g2.setColor(Color.green);
    }
    g2.drawLine(250, 240, 172, 230);
   g2.setColor(Color.green);
    //Lhazareen Village - Pentos
    g2.drawLine(400, 290, 172, 230);     
        //Vaes- Lhazaren
    g2.drawLine(400, 290, 450, 235);
    //Lazaren - Qohor
    g2.drawLine(400, 290, 250, 240);
    g2.setColor(Color.red);
    g2.fillOval(80, 50, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Castle Black", 80, 75);
    g2.setColor(Color.red);
    g2.fillOval(450, 230, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Winterfell", 40, 95);
    g2.setColor(Color.red);
    g2.fillOval(40, 95, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Vaes Dothrak", 450, 230);
    g2.setColor(Color.red);
    g2.fillOval(105, 175, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("The eyrie", 60, 175);
    g2.setColor(Color.red);
    g2.fillOval(85, 195, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Crossroads Inn", 25, 212);
    g2.setColor(Color.red);
    g2.fillOval(92, 235, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("King's Landing", 32, 265);
    g2.setColor(Color.red);
    g2.fillOval(172, 225, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Pentos", 162, 215);
    g2.setColor(Color.red);
    g2.fillOval(250, 235, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Qohor", 250, 225);
    g2.setColor(Color.red);
    g2.fillOval(400, 285, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Lhazareen Village", 400, 325);
    Dijkstra mp = new Dijkstra();
        
       
  }

}