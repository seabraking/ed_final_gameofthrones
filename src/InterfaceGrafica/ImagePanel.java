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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Vitor
 */
class ImagePanel extends JPanel {

  private Image img;
  LinkedQueue path = new LinkedQueue();
    ArrayUnorderedList<String> pathList = new ArrayUnorderedList();
  private int newcity=0;
  private int x,y;
  private String cityName="";
  private double exercito=0.;
  private boolean existsPath=false;
  
  
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
  
  public void sendShorthestPath(LinkedQueue paths,double custo){
      int count = 0;
    //  dj.setUltimaVisita("NONE");
      while(!paths.isEmpty()){
          String c = (String) paths.dequeue().toString();
          this.path.enqueue(c);
          System.out.println(c);
          count++;
          if(count==2){
              Dijkstra.setUltimaVisita(c);
              System.out.println("Last: " +c);
          }

      }
      exercito=custo;
      pathList = new ArrayUnorderedList<>();
   
  }

  public void paintComponent(Graphics g) {
      
    g.drawImage(img, 0, 0, null);
     Graphics2D g2 = (Graphics2D)g;
     g.setFont(new Font("default", Font.BOLD, 12));
    g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

    if(!path.isEmpty()){
        g2.setColor(Color.MAGENTA);
        g2.drawString("Shortest Path", 300, 20);
        g2.setColor(Color.DARK_GRAY);
        String s1="";
        int pathsize = path.size();
        while(!path.isEmpty()) {
            s1+= " => ";
            pathList.addToFront(path.dequeue().toString());
            try {

                   s1+=pathList.first(); 
         
                
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        } 
        
        
        g2.drawString(s1, 150, 35);
        g2.setColor(Color.RED);
        
        g2.drawString("Perdas: " + Math.round(exercito), 190, 45);
         g2.setColor(Color.BLACK);
         
    } else {
        g2.drawString("", 300, 20);
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
    
    //Winterfell - CrossRoads
    ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Winterfell")){
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
    g2.drawLine(40, 100, 85, 200);
    g2.setColor(Color.green);
    //KingsLand - Crossroads
    ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Cross")){
            found += 1;
        }
        if(x.contains("King")){
            found += 1;
        }
    }
    if(found==2){
        g2.setColor(Color.red);
    } else {
        g2.setColor(Color.green);
    }
    g2.drawLine(85, 200, 92, 240);
    g2.setColor(Color.green);
    //Pentos -- Crossroads Inn
    ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Pentos")){
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
    g2.drawLine(172, 230, 85, 200);
     //Pentos -- King's Landing
     ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Pentos")){
            found += 1;
        }
        if(x.contains("King")){
            found += 1;
        }
    }
    if(found==2){
        g2.setColor(Color.red);
    } else {
        g2.setColor(Color.green);
    }
    g2.drawLine(172, 230, 92, 240);
    
    //Pentos -- The eyrie
    
    ai = pathList.iterator();
     found = 0;
    if(ai.hasNext()){
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
    ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Lhaz")){
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
    g2.drawLine(400, 290, 172, 230);     
    g2.setColor(Color.green);
        //Vaes- Lhazaren
        ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Vaes")){
            found += 1;
        }
        if(x.contains("Lhaz")){
            found += 1;
        }
    }
    if(found==2){
        g2.setColor(Color.red);
    } else {
        g2.setColor(Color.green);
    }
    g2.drawLine(400, 290, 450, 235);
    //Lazaren - Qohor
    ai = pathList.iterator();
     found = 0;
    while(ai.hasNext()){
         String x1 ="";
        String x = ai.next();
        if(x.contains("Lhaz")){
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
    g2.drawLine(400, 290, 250, 240);
    
    //Desenhar Ponto
    
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
    g2.drawString("Lhazareen Village", 400, 305);
    if(newcity==1){
    g2.drawString(cityName + " : " + exercito, x, y-5);
    g2.setColor(Color.blue);
    g2.fillOval(x, y, 30, 30);
    }
        
       
  }


   
}