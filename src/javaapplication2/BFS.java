package javaapplication2;

public class BFS {
    private boolean[] marcado;
    private int[] aristaHacia;

    public BFS(Grafo G, int s){
        marcado = new boolean[G.V()];
        aristaHacia = new int[G.V()];
        bfs(G,s);
    }
    
    private void bfs(Grafo G, int s)
    {
        Cola<Integer> c = new Cola<Integer>();
        c.entrar(s);
        marcado[s] = true;
        while (!c.estaVacio())
        {
            int v = c.salir();
            for (int w : G.ady(v))
            {
                if (!marcado[w])
                {
                    c.entrar(w);
                    marcado[w] = true;
                    aristaHacia[w] = v;
                }
            }
        }
    }
    
    public boolean marcado(int v){
        return marcado[v];
    }
}
