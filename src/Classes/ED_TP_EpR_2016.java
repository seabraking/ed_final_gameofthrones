/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import ED_11_Parte1_Ex3.ElementNotFoundException;
import ED_11_Parte1_Ex3.EmptyCollectionException;
import ED_12_Parte1_Ex2.ArrayIterator;
import Ficheiros.DataManagement;
import InterfaceGrafica.NewJFrame;
import Interfaces.DataManagementADT;
import java.io.IOException;

/**
 *
 * @author Vitor
 */
public class ED_TP_EpR_2016 {
static NetworkCidades network;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ElementNotFoundException, EmptyCollectionException, ED_12_Parte1_Ex2.EmptyCollectionException {

    NewJFrame frame = new NewJFrame();
    frame.setVisible(true);

        DataManagementADT dataManagementADT = new DataManagement();
        network = new NetworkCidades();

        network =  dataManagementADT.obterNetwork("./Ficheiros/dadosT.csv");

        ArrayIterator iterator = network.iteratorBFS(0);
        
        while (iterator.hasNext()) {
            Cidade cidade = (Cidade) iterator.next();
            System.out.println("Nome: \t" + cidade.getNome() + "\n\tDefesas: " + cidade.getDefesa());
        }
        System.out.println("\n Numero de cidades de Game of <T>hrones - " + network.size());
    
        
        
        
        Cidade Vaes_Dothrak = new Cidade("Vaes Dothrak ", 73);
        Cidade Lhazareen_Village = new Cidade("Lhazareen Village ", 64);
        Cidade Qohor = new Cidade("Qohor ", 19);
        Cidade Pentos = new Cidade("Pentos ", 84);
        Cidade Kings_Landing = new Cidade("King's Landing ", 60);
        Cidade Crossroads_Inn = new Cidade("Crossroads Inn ", 0);
        Cidade The_eyrie = new Cidade("The eyrie ", 54);
        Cidade Winterfell = new Cidade("Winterfell ", 64);
        Cidade Castle_Black = new Cidade("Castle Black ", 50);
        
        Vaes_Dothrak.adicionar_trajeto(Castle_Black, 800.0, 10.0, 2.2);
        Vaes_Dothrak.adicionar_trajeto(Lhazareen_Village, 180.0, 2.3, 1.7);
        Vaes_Dothrak.adicionar_trajeto(Qohor, 400.0, 4.5, 0.2);
        Vaes_Dothrak.adicionar_trajeto(Castle_Black, 1040.0, 13.0, 1.5);
        Vaes_Dothrak.adicionar_trajeto(Lhazareen_Village, 198.0, 3.0, 0.3);
        Vaes_Dothrak.adicionar_trajeto(Qohor, 520.0, 5.9, 1.2);
        
        
        Lhazareen_Village.adicionar_trajeto(Qohor, 300.0, 2.5, 0.4);
        Lhazareen_Village.adicionar_trajeto(Pentos, 500.0, 6.3, 0.3);
        Lhazareen_Village.adicionar_trajeto(Qohor, 390.0, 3.3, 2.7);
        Lhazareen_Village.adicionar_trajeto(Pentos, 650.0, 8.2, 2.8);
        
        Qohor.adicionar_trajeto(Pentos, 180.0, 3.7, 1.7);
        Qohor.adicionar_trajeto(Pentos, 126.0, 4.8, 0.6);
        
        Pentos.adicionar_trajeto(Kings_Landing, 160.0, 3.5, 2.4);
        Pentos.adicionar_trajeto(Crossroads_Inn, 200.0, 3.5, 1.2);
        Pentos.adicionar_trajeto(The_eyrie, 180.0, 4.9, 2.5);
        Pentos.adicionar_trajeto(Kings_Landing, 208.0, 4.6, 0.2);
        Pentos.adicionar_trajeto(Crossroads_Inn, 140.0, 4.6, 2.5);
        Pentos.adicionar_trajeto(The_eyrie, 234.0, 6.4, 3.0);
        
        Kings_Landing.adicionar_trajeto(Crossroads_Inn, 100.0, 1.2, 2.0);
        Kings_Landing.adicionar_trajeto(Crossroads_Inn, 110.0, 1.6, 1.4);
        
        Crossroads_Inn.adicionar_trajeto(The_eyrie, 50.0, 1.1, 0.7);
        Crossroads_Inn.adicionar_trajeto(Winterfell, 250.0, 5.5, 1.2);
        Crossroads_Inn.adicionar_trajeto(The_eyrie, 65.0, 1.4, 2.2);
        Crossroads_Inn.adicionar_trajeto(Winterfell, 275.0, 7.2, 0.4);
        
        The_eyrie.adicionar_trajeto(Winterfell, 210.0, 2.8, 2.6);
        The_eyrie.adicionar_trajeto(Winterfell, 231.0, 3.6, 2.1);
        
        Winterfell.adicionar_trajeto(Castle_Black, 120.0, 1.9, 0.9);
        Winterfell.adicionar_trajeto(Castle_Black, 108.0, 2.5, 3.0);


//    //adicionar trajetos as cidades
//        setAdjacencias(Vaes_Dothrak);
//        setAdjacencias(Lhazareen_Village);
//        setAdjacencias(Qohor);
//        setAdjacencias(Pentos);
//        setAdjacencias(Kings_Landing);
//       setAdjacencias(Crossroads_Inn);
//       setAdjacencias(The_eyrie);
//       setAdjacencias(Winterfell);
//        setAdjacencias(Castle_Black);
        
        
        Dijkstra mp = new Dijkstra();
        
       /*mp.apresenta_caminho_barato(Pentos, Crossroads_Inn);*/
     //   mp.apresenta_caminho_curto(Vaes_Dothrak, The_eyrie);
     //   mp.apresenta_segundo_caminho_curto(Vaes_Dothrak, The_eyrie);

    }
    public static void setAdjacencias(Cidade cidade) throws EmptyCollectionException{
        
       
        
        for (int i = 0; i < network.getVertices().length; i++) {
           if(network.getAdjMatrix()[network.getIndex(cidade)][i]){
               for (int j = 0; j <= network.ajdListWeight[network.getIndex(cidade)][i].size(); j++) {
                   DadosTrajeto dT = (DadosTrajeto) network.ajdListWeight[network.getIndex(cidade)][i].removeMin();
            
                   cidade.adicionar_trajeto(dT.getCidadeDestino(), dT.getKms(), dT.getDur(), dT.getCusto());
               
               }
               
           }
        }
     
    }
}
