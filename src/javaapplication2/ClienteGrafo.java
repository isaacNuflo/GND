package javaapplication2;


import javaapplication2.Grafo;

public class ClienteGrafo {
    public static int grado(Grafo G, int v) { 
        int grado = 0;
        for (int w : G.ady(v)) grado++;
        return grado;
    }

    public static int gradoMax(Grafo G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++)
            if (grado(G, v) > max)
                max = grado(G, v);
        return max;
    }
        public static int gradoMin(Grafo G) {
        Integer min = Integer.MAX_VALUE;
        for (int v = 0; v < G.V(); v++)
            if (grado(G, v) < min)
                min = grado(G, v);
        return min;
    }

    public static int gradoProm(Grafo G) {
        // each edge incident on two vertices
        return 2 * G.E() / G.V();
    }

    // number of self-loops
    public static int numeroDeLazos(Grafo G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++)
            for (int w : G.ady(v))
                if (v == w) count++;
        return count/2;   // self loop appears in adjacency list twice
    } 
}
