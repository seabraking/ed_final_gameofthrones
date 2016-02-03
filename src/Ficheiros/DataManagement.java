/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ficheiros;

import Classes.Cidade;
import ED_12_Parte1_Ex2.Network;
import ED_12_Parte1_Ex2.NetworkADT;
import Exeptions.FicheiroNaoEnc;
import Interfaces.DataManagementADT;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.nio.charset.StandardCharsets.ISO_8859_1;

/**
 *
 * @author Vitor
 */
public class DataManagement implements DataManagementADT {

    public DataManagement() {
    }

    @Override
    public NetworkADT obterNetwork(String ficheiro) throws IOException {
        try {

            //Instanciar FileReader's
            FileReader data = new FileReader(ficheiro);
            //Instanciar BufferedReader's
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(ficheiro), ISO_8859_1));

            //instanciar variaveis necessarias
            NetworkADT networkADT = (NetworkADT) new Network();

            //instanciar string para armazenar a linha completa
            String linhaCompleta;
            String[] dadosArray;
            String linhaCompletaCont;
            String[] dadosArrayCont;
            int idDadosViagem = 0;
            int idCidade = 0;
            while ((linhaCompleta = br.readLine()) != null) {
                // linhaCompletaEco dividida por ;
                String linhaCompletaReplace = linhaCompleta.replace(',', '.');
                dadosArray = linhaCompletaReplace.split(";");

                Cidade cidadeOrigem = new Cidade(dadosArray[0], Integer.parseInt(dadosArray[1]));
                Cidade cidadeDestino = new Cidade(dadosArray[0], Integer.parseInt(dadosArray[1]));

                //adicionar cidades
                networkADT.addVertex(cidadeOrigem);
                networkADT.addVertex(cidadeDestino);

            }
            return networkADT;
        } catch (Exception e) {
            EscreverErrosFicheiro eef = new EscreverErrosFicheiro();
            eef.escreverEmficheiro(e, "DataManager");
            new FicheiroNaoEnc(e + "");
            return null;
        }

    }

}
