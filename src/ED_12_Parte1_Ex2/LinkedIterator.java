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
public class LinkedIterator<T>  {

    private DoubleNode current;
    private int count;

    public LinkedIterator(DoubleNode current, int count) {
        this.current = current;
        this.count = count;

    }

   
    public boolean hasNext() {
        return current != null;
    }

  
    public T next() {

        if (hasNext()) {
            DoubleNode<T> elementReturn = current;
            current = current.getNext();
           
            return elementReturn.getElement();

        };
        return null;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    

}
