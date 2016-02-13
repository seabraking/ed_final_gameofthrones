/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import ED_12_Parte1_Ex2.UnorderedListADT;
import Interfaces.JogadorADT;

/**
 *
 * @author Vitor
 */
public class Jogador implements JogadorADT{
    private String nome;
    private int exercito;
    private UnorderedListADT<Cidade> cidadesConquistadas;

    public Jogador(String nome, int exercito, UnorderedListADT<Cidade> cidades) {
        this.nome = nome;
        this.exercito = exercito;
        this.cidadesConquistadas = cidades;
    }

    public UnorderedListADT<Cidade> getCidades() {
        return cidadesConquistadas;
    }

    public void setCidades(UnorderedListADT<Cidade> cidades) {
        this.cidadesConquistadas = cidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getExercito() {
        return exercito;
    }

    public void setExercito(int exercito) {
        this.exercito = exercito;
    }

    @Override
    public void conquistarCidade(Cidade cidade) {
     cidadesConquistadas.addToRear(cidade);
    }

    @Override
    public void efetuarPerdaExercito(int perda) {
     this.exercito = exercito - perda;
    }
    
    
    
          
}
