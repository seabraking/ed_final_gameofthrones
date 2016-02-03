/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_12_Parte1_Ex2;

/**
 *
 * @author Vitor
 */
public class ArrayIterator<T> {
    private T[] lista;
    private int current;
    private int count;

    public ArrayIterator(T[] t, int count) {
        this.lista = t;
        this.count = count;
        this.current=0;
        
    }
    
   

    public boolean hasNext() {
    return current<count;
    }

    public T next() {
       
                return lista[current++];
  
    }
}
