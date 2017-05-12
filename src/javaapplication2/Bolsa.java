package javaapplication2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bolsa<Item> implements Iterable<Item>
{
    private int N; //numero de elementos en la bolsa
    private Nodo<Item> primero;
    
    private class Nodo<Item>{
        private Item item;
        private Nodo<Item> prox;
    }
    public Bolsa(){
        primero=null;
        N=0;
    }
    public boolean estaVacia(){
        return (primero==null);
    }
    public int tamanno(){
        return N;
    }
    public void agregar(Item item){
        Nodo<Item> primeroAnterior = primero;
        primero = new Nodo<Item>();
        primero.item = item;
        primero.prox = primeroAnterior;
        N++;
    }
    public Iterator<Item> iterator(){
        return new IteradorDeLista<Item>(primero);
    }
    private class IteradorDeLista<Item> implements Iterator<Item>{
        private Nodo<Item> actual;
        public IteradorDeLista(Nodo<Item> primero){
            actual = primero;
        }
        public boolean hasNext(){
            return (actual != null);
        }
        public Item next(){
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = actual.item;
            actual=actual.prox;
            return item;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
