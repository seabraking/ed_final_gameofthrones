/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import ED_12_Parte1_Ex2.ArrayIterator;
import ED_12_Parte1_Ex2.Network;
import ED_12_Parte1_Ex2.NetworkADT;
import Ficheiros.DataManagement;
import InterfaceGrafica.NewJFrame;
import Interfaces.DataManagementADT;
import java.io.IOException;

/**
 *
 * @author Vitor
 */
public class ED_TP_EpR_2016 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

    NewJFrame frame = new NewJFrame();
    frame.setVisible(true);

        DataManagementADT dataManagementADT = new DataManagement();
        NetworkADT networkADT = new Network();

        networkADT = dataManagementADT.obterNetwork("./Ficheiros/dadosT.csv");

        ArrayIterator iterator = networkADT.iteratorBFS(0);
        
        while (iterator.hasNext()) {
            Cidade cidade = (Cidade) iterator.next();
            System.out.println("Nome: \t" + cidade.getNome() + "\n\tDefesas: " + cidade.getDefesas());
        }
        System.out.println("\n Numero de cidades de Game of <T>hrones - " + networkADT.size());
    }

}
