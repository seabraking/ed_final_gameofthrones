/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import Classes.Cidade;
import Classes.Dijkstra;
import Classes.Jogador;
import ED_12_Parte1_Ex2.ArrayIterator;
import ED_12_Parte1_Ex2.ArrayUnorderedList;
import ED_12_Parte1_Ex2.EmptyCollectionException;
import ED_12_Parte1_Ex2.LinkedQueue;
import java.awt.AlphaComposite;
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
class Mapa extends JPanel {

  private Image img;
  LinkedQueue path = new LinkedQueue();
    ArrayUnorderedList<String> pathList = new ArrayUnorderedList();
  private int newcity=0;
  private int x,y;
  private String cityName="";
  private double exercito=0.;
  private boolean existsPath=false;
  private boolean criterioNotFound= true;
  private double duracao;
  private String perdas;
  private Jogador jogador;
  private boolean jogadorSet=false;
  String strCidadesConquistadas= "";
  public Mapa(String img) {
    this(new ImageIcon(img).getImage());
  }

  public Mapa(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);


  }
  
  public void sendShorthestPath(LinkedQueue paths,double custo, Double duracao,String perdas){
      int count = 0;
    //  dj.setUltimaVisita("NONE");
    if(path.size()!=1){
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
      this.duracao =duracao;
      pathList = new ArrayUnorderedList<>();
    } else {
        criterioNotFound = true;
    }
    this.perdas = perdas;
  }

  public void paintComponent(Graphics g) {
      
    g.drawImage(img, 0, 0, null);
     Graphics2D g2 = (Graphics2D)g;
     g.setFont(new Font("default", Font.BOLD, 12));
    g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

    
    if(!path.isEmpty()){
        g2.setColor(Color.MAGENTA);
        g2.drawString("Shortest Path", 250, 20);
        g2.setColor(Color.DARK_GRAY);
        String s1="";
        int pathsize = path.size();
        while(!path.isEmpty()) {
            s1+= " => ";
            pathList.addToFront(path.dequeue().toString());
            try {

                   s1+=pathList.first(); 
         
                
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        if(pathList.size()>1){
        
        if(pathList.size()>5){
            g2.setComposite(AlphaComposite.SrcOver.derive(0.8f));
            g2.setColor(Color.white);
            g2.fillRect(30-5, 35-10, 550, 50);
            g2.setColor(Color.black);
            g2.drawString(s1, 40, 35);
        } else {
            
            g2.drawString(s1, 150, 30);
        }
        
        g2.setColor(Color.RED);
        g2.drawString("Perdas por batalha: " +perdas, 190, 50);
        g2.drawString("Perdas: " + Math.round(exercito), 190, 60);
         g2.drawString("Duraçao Jornada: " + Math.round(duracao) + " dias.", 190, 70);
         g2.setColor(Color.BLACK);
        
        }
    } else {
        g2.setColor(Color.blue);
        g2.drawString("Estado: Caminho nao encontrado, com os criterios desejados!", 200, 20);
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
    if(ai.hasNext()){
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
        if(x.contains("Qohor")){
            found += 1;
        }
        if(x.contains("Vaes")){
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
    if(jogadorSet){
    ArrayIterator<Cidade> tmp = jogador.getCidades().iterator();
    boolean found1=false;
    while(tmp.hasNext()){
         String cd = tmp.next().getNome();
         if(!strCidadesConquistadas.contains(cd)){
            strCidadesConquistadas += " - " + cd;
         }
         
        }
    }
    Color ourGreen = new Color(0,100,0);
    System.out.println(strCidadesConquistadas);
     if(strCidadesConquistadas.contains("Castle")){
        g2.setColor(ourGreen);
    } else {
        g2.setColor(Color.red);
    }
     
    g2.fillOval(80, 50, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Castle Black", 80, 75);
     
    System.out.println(jogadorSet);
    
    System.out.println(strCidadesConquistadas);
    
    if(strCidadesConquistadas.contains("Vaes")){
        g2.setColor(ourGreen);
    } else {
        g2.setColor(Color.red);
    }
    
  // if(jogador.getCidades().contains("Vaes")) g2.setColor(Color.CYAN);
   // g2.setColor(Color.red);
    g2.fillOval(450, 230, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Winterfell", 40, 95);
    g2.setColor(Color.red);
     if(strCidadesConquistadas.contains("Winter")){
        g2.setColor(ourGreen);
    } else {
        g2.setColor(Color.red);
    }
    g2.fillOval(40, 95, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Vaes Dothrak", 450, 230);
     if(strCidadesConquistadas.contains("The")){
        g2.setColor(ourGreen);
    } else {
        g2.setColor(Color.red);
    }
    g2.fillOval(105, 175, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("The eyrie", 60, 175);
     if(strCidadesConquistadas.contains("Cross")){
        g2.setColor(ourGreen);
    } else {
        g2.setColor(Color.red);
    }
    g2.fillOval(85, 195, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Crossroads Inn", 25, 212);
    if(strCidadesConquistadas.contains("King")){
        g2.setColor(ourGreen);
    } else {
        g2.setColor(Color.red);
    }
    g2.fillOval(92, 235, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("King's Landing", 32, 265);
    if(strCidadesConquistadas.contains("Pentos")){
        g2.setColor(ourGreen);
    } else {
        g2.setColor(Color.red);
    }
    g2.fillOval(172, 225, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Pentos", 162, 215);
    if(strCidadesConquistadas.contains("Qohor")){
        g2.setColor(ourGreen);
    } else {
        g2.setColor(Color.red);
    }
    g2.fillOval(250, 235, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Qohor", 250, 225);
    if(strCidadesConquistadas.contains("Lhaz")){
        g2.setColor(ourGreen);
    } else {
        g2.setColor(Color.red);
    }
    g2.fillOval(400, 285, 10, 10);
    g2.setColor(Color.black);
    g2.drawString("Lhazareen Village", 400, 305);
    if(newcity==1){
    g2.drawString(cityName + " : " + exercito, x, y-5);
    g2.setColor(Color.blue);
    g2.fillOval(x, y, 30, 30);
    }
        
       
  }

    void sendJogadorData(Jogador jogador) {
        this.jogador =  jogador;
        jogadorSet=true;
    }


   
}