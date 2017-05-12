package javaapplication2;

public class DFS {
    private boolean[] marcado;
    private int cont; //numero de vertices conectados a s
    
    public DFS(Grafo G, int s){
        marcado = new boolean[G.V()];
        dfs(G,s);
    }
    
    private void dfs(Grafo G, int v){
        cont++;
        marcado[v] = true;
        for (int w : G.ady(v)){
            if(!marcado[w]){
                dfs(G,w);
            }
        }
    }
    public boolean marcado(int v){
        return marcado[v];
    }
    public int conteo(){
        return cont;
    }
}

