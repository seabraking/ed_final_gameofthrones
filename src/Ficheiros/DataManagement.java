/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ficheiros;

import Classes.Cidade;
import Classes.DadosTrajeto;
import Classes.NetworkCidades;
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
    public  NetworkCidades obterNetwork(String ficheiro) throws IOException {
        //instanciar variaveis necessarias
        NetworkCidades networkADT = new NetworkCidades();
//        try {

            //Instanciar FileReader's
            FileReader data = new FileReader(ficheiro);
            //Instanciar BufferedReader's
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(ficheiro), ISO_8859_1));

            //instanciar string para armazenar a linha completa
            String linhaCompleta;
            String[] dadosArray;
            String linhaCompletaCont;
            String[] dadosArrayCont;
            int idDadosViagem = 0;
            int idCidade = 0;
            Cidade cidadeOrigem = null;
            Cidade cidadeDestino = null;

            //adicionar todas as cidades de partida
            while ((linhaCompleta = br.readLine()) != null) {

                // linhaCompletaEco dividida por ;
                String linhaCompletaReplace = linhaCompleta.replace(',', '.');
                dadosArray = linhaCompletaReplace.split(";");
                if (dadosArray[0].compareTo("") != 0) {

                    cidadeOrigem = new Cidade(dadosArray[0], Integer.parseInt(dadosArray[1]));
                    cidadeDestino = new Cidade(dadosArray[2], 0);

                    //adicionar cidades
                    networkADT.addVertex(cidadeOrigem);

                }
            }

            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(ficheiro), ISO_8859_1));

            //adicionar todas a cidades destino nao adicionadas
            while ((linhaCompleta = br.readLine()) != null) {

                // linhaCompletaEco dividida por ;
                String linhaCompletaReplace = linhaCompleta.replace(',', '.');
                dadosArray = linhaCompletaReplace.split(";");
                if (dadosArray[0].compareTo("") != 0) {

                    cidadeDestino = new Cidade(dadosArray[2], 0);

                    //adicionar cidades
                    networkADT.addVertex(cidadeDestino);

                }
            }

            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(ficheiro), ISO_8859_1));

            //adicionar todas as ligacoes entre as cidades
            while ((linhaCompleta = br.readLine()) != null) {

                // linhaCompletaEco dividida por ;
                String linhaCompletaReplace = linhaCompleta.replace(',', '.');
                dadosArray = linhaCompletaReplace.split(";");
                if (dadosArray[0].compareTo("") != 0) {

                    cidadeOrigem = new Cidade(dadosArray[0], Integer.parseInt(dadosArray[1]));
                    cidadeDestino = new Cidade(dadosArray[2], 0);
                    
                    
                    DadosTrajeto dadosTrajetoAlternativa1 = new DadosTrajeto(Double.parseDouble(dadosArray[3]),
                            Double.parseDouble(dadosArray[4]), Double.parseDouble(dadosArray[5]),cidadeDestino);
                    DadosTrajeto dadosTrajetoAlternativa2 = new DadosTrajeto(Double.parseDouble(dadosArray[6]),
                            Double.parseDouble(dadosArray[7]), Double.parseDouble(dadosArray[8]),cidadeDestino);

                    networkADT.addEdge(cidadeOrigem, cidadeDestino, dadosTrajetoAlternativa1);
                    networkADT.addEdge(cidadeOrigem, cidadeDestino, dadosTrajetoAlternativa2);


                }else{
                      cidadeDestino = new Cidade(dadosArray[2], 0);
                     DadosTrajeto dadosTrajetoAlternativa1 = new DadosTrajeto(Double.parseDouble(dadosArray[3]),
                            Double.parseDouble(dadosArray[4]), Double.parseDouble(dadosArray[5]),cidadeDestino);
                    DadosTrajeto dadosTrajetoAlternativa2 = new DadosTrajeto(Double.parseDouble(dadosArray[6]),
                            Double.parseDouble(dadosArray[7]), Double.parseDouble(dadosArray[8]),cidadeDestino);
                     
                    
                    networkADT.addEdge(cidadeOrigem, cidadeDestino, dadosTrajetoAlternativa1);
                    networkADT.addEdge(cidadeOrigem, cidadeDestino, dadosTrajetoAlternativa2);
                    
                }
                
            }
            
            return networkADT;
//        } catch (Exception e) {
//            EscreverErrosFicheiro eef = new EscreverErrosFicheiro();
//            eef.escreverEmficheiro(e, "DataManager");
//            new FicheiroNaoEnc(e + "");
//            return networkADT;
//        }

    }

}
