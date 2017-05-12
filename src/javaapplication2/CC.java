package javaapplication2;

public class CC {
    private boolean[] marcado;  // el vertice v ha sido marcado?
    private int[] id;           // id[v] = id del componente conectado conteniendo v
    private int[] tamanno;      // tamanno[id] = numero de vertices en un componente dado
    private int conteo;         // numero de componentes conectados

    /**
     * Calcula los componentes conectados de un grafo no dirigido <tt>G</tt>.
     * @param G el grefo
     */
    public CC(Grafo G) {
        marcado = new boolean[G.V()];
        id = new int[G.V()];
        tamanno = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marcado[v]) {
                dfs(G, v);
                conteo++;
            }
        }
    }

    // busqueda dfs
    private void dfs(Grafo G, int v) {
        marcado[v] = true;
        id[v] = conteo;
        tamanno[conteo]++;
        for (int w : G.ady(v)) {
            if (!marcado[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * Devuelve el id del componente que continene el vertice <tt>v</tt>.
     * @param v el vertice
     * @return el id del componente que contiene el vertice <tt>v</tt>
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * Devuelve el numero de vertices en el componente conectado conteniendo el vertice <tt>v</tt>.
     * @param v el vertice
     * @return el numero de vertices en el componente conectado conteniendo el vertice <tt>v</tt>
     */
    public int tamanno(int v) {
        return tamanno[id[v]];
    }

    /**
     * Devuelve el numero de componentes conectados.
     * @return el numero de componentes conectados
     */
    public int conteo() {
        return conteo;
    }

    /**
     * Estan los vertices <tt>v</tt> y <tt>w</tt> en el mismo componente conectado?
     * @param v un vertice
     * @param w el otro vertice
     * @return <tt>true</tt> si los vertices <tt>v</tt> y <tt>w</tt> estan en
     * el mismo componente conectado, y <tt>false</tt> de otra forma
     */
    public boolean conectado(int v, int w) {
        return id(v) == id(w);
    }
}

