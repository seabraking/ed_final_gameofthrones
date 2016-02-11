/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import ED_12_Parte1_Ex2.UnorderedListADT;

/**
 *
 * @author Vitor
 */
public class Jogador {
    private String nome;
    private int exercito;
    private UnorderedListADT<Cidade> cidades;

    public Jogador(String nome, int exercito, UnorderedListADT<Cidade> cidades) {
        this.nome = nome;
        this.exercito = exercito;
        this.cidades = cidades;
    }

    public UnorderedListADT<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(UnorderedListADT<Cidade> cidades) {
        this.cidades = cidades;
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
    
    
    
          
}
