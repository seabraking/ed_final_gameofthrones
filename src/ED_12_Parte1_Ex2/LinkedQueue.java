/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_12_Parte1_Ex2;





/**
 *
 * @author Vitor
 * @param <T>
 */
public class LinkedQueue<T> implements QueueADT<T>{
   
    LinearNode<T> front;
    LinearNode<T> rear;
    private int count=0;

    public LinkedQueue(LinearNode<T> t) {
        this.front = t;
        this.rear = t;
        
        count++;
    }

    public LinkedQueue() {
         this.front = null;
        this.rear = null;
        
    }

    @Override
    public void enqueue(T element) {
             //adicionar a cauda
        LinearNode<T> x = new LinearNode(element);
        if (isEmpty()) {
            this.front = x;
            this.count++;
        } else {
            this.rear.setNext(x);
            this.count++;
        }
        this.rear = x;
    }

    @Override
    public T dequeue() {
     //remoiver ao cabeça
        if (this.front.getNext() != null) {
            LinearNode<T> x = this.front;
            this.front = this.front.getNext();
            this.count--;
            return (T) x.getElement();
        } else {
            LinearNode<T> x = this.front;
            this.front = null;
            this.count--;
            return (T) x.getElement();
        }
       
    }
    
    
   
    @Override
    public LinearNode<T> first() {
        if(isEmpty()){
            System.out.println("Vazio");
            return null;
        }
     return front;
    }

    @Override
    public boolean isEmpty() {
        return this.size()==0;
    }

    @Override
    public int size() {
    return count;
    }

   public void remove(T ob) {

        if (!isEmpty()) {
            LinearNode<T> x = this.front;
            if (this.front.equals(x)) {
                dequeue();
            } else {
                LinearNode<T> tpm = x.getNext();
                for (int i = 0; i < this.count; i++) {
                    if (tpm.getElement().equals(ob)) {
                        x.setNext(tpm.getNext());
                    }else{
                        x = x.getNext();
                        tpm = tpm.getNext();
                    }
                }
            }
        }
    }



    public LinkedStack inverteQueue(){
        if(!isEmpty()){
            LinkedStack new_q = new LinkedStack();
            do{
                new_q.push(dequeue());
            }while(!isEmpty());
            return new_q;
        }else{
            return null;
        }
    }
    
    /**
     * Lista queue
     * @throws Excepcoes.EmptyCollectionException
     */
    public LinkedQueue listar_queue_inversa() throws EmptyCollectionException{
        LinkedQueue a = new LinkedQueue();
        if (!isEmpty()){
            LinkedStack q = inverteQueue();
            do{
                Object no =  q.pop();
                System.out.print(no + " - ");
                a.enqueue(no);
            }while(!q.isEmpty());
            System.out.println("  ");
            return a;
        }else{
            return null;
        }
    }
    
    public LinearNode<T> getRear(){
        return rear;
    }
}
