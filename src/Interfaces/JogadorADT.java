/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Cidade;

/**
 *
 * @author Vitor
 */
public interface JogadorADT {
  public void conquistarCidade(Cidade cidade);
  public void efetuarPerdaExercito(int perda);
  
}
