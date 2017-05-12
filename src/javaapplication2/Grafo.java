package javaapplication2;


import javaapplication2.In;
import javaapplication2.Pila;

public class Grafo {
    private final int V;
    private int E;
    private Bolsa<Integer>[] ady;
    
    public Grafo(int V){
        if(V<0) throw new IllegalArgumentException(
                "El numero de vertices no debe ser negativo");
        this.V = V;
        this.E = 0;
        ady = (Bolsa<Integer>[]) new Bolsa[V];
        for (int v=0; v < V; v++){
            ady[v] = new Bolsa<Integer>();
        }
    }
    public Grafo(In in){
        this(in.readInt());
        try {
            E = in.readInt();
            for (int i = 0; i< E; i++){
                int v = in.readInt();
                int w = in.readInt();
                agregarArista(v,w);
            }
        }
        catch(Exception e){
        }
    }
    public Grafo(Grafo G){
        this(G.V());
        this.E = G.E();
        for(int v = 0; v<G.V();v++){
            Pila<Integer> reversa = new Pila<Integer>();
            for (int w : G.ady[v]){
                reversa.push(w);
            }
            for (int w : reversa){
                ady[v].agregar(w);
            }
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void agregarArista(int v, int w){
        if(v < 0 || v >= V)
            throw new IndexOutOfBoundsException();
        if(w < 0 || w >= V)
            throw new IndexOutOfBoundsException();
        E++;
        ady[v].agregar(w);
        ady[w].agregar(v);
    }
    public Iterable<Integer> ady(int v){
        if(v < 0 || v >= V)
            throw new IndexOutOfBoundsException();
        return ady[v];
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        String NUEVALINEA = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " aristas " + NUEVALINEA);
        for(int v = 0; v < V; v ++){
            s.append(v + ": ");
            for (int w : ady[v]){
                s.append(w + " ");
            }
            s.append(NUEVALINEA);
        }
        return s.toString();
    }





}
