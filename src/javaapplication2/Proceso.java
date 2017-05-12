/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;

/**
 *
 * @author LABORATORIO 6
 */
public class Proceso {
    public static void desarrollo(){
        In entrada = new In("medium.txt");
        In entrada1 = new In("tinyG.txt");
        Grafo G = new Grafo(entrada);
        Grafo G1 = new Grafo(entrada1);
        int max;
        int min;
        ArrayList<Integer> maximos=new ArrayList<Integer>();
        ArrayList<Integer> minimos=new ArrayList<Integer>();
        max=ClienteGrafo.gradoMax(G);
        min=ClienteGrafo.gradoMin(G);
        System.out.println("Numero de lazos: "+ClienteGrafo.numeroDeLazos(G));
        System.out.println("Grado Max : "+max);
        System.out.println("Grado Min: "+min);
        System.out.println("Grado Promedio: "+ClienteGrafo.gradoProm(G));
        
        for (int i = 0; i < G.V(); i++) {
            int grado=ClienteGrafo.grado(G, i);
            System.out.println("Grado del vertice ("+i+"): "+grado);
            if(grado==max){
                maximos.add(i);
            }
            if(grado==min){
                minimos.add(i);
            }
        }
        for(Integer id:maximos){
            System.out.println("vertice con grado maximo: "+id);
        }
        for(Integer id:minimos){
            System.out.println("vertice con grado minimo: "+id);
        }
        DFS dfs=new DFS(G,50);
        System.out.println("BFS desde el vertice 50:");
        for(int v = 0; v < G.V(); v++) {
            if (dfs.marcado(v)==true)
                StdOut.print(v+" ");
        }
        StdOut.println();
        if (dfs.conteo() != G.V())
            StdOut.println("No Conectado");
        else
            StdOut.println("Conectado");
        System.out.println("DFS desde el vertice 50:");
        BFS bfs=new BFS(G,50);
        for(int v = 0; v < G.V(); v++) {
            if (bfs.marcado(v)==true)
                StdOut.print(v+" ");
        }
        CC cc = new CC(G);

        // number of conectado components
        int M = cc.conteo();
        System.out.println("\nComponentes conectados:");
        StdOut.println(M + " componentes");

        // compute list of vertices in each conectado component
        Cola<Integer>[] componentes = (Cola<Integer>[]) new Cola[M];
        for (int i = 0; i < M; i++) {
            componentes[i] = new Cola<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            componentes[cc.id(v)].entrar(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : componentes[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
        
        StdOut.print("Arreglo: id[]");
        for(int i=0; i<G.V(); i++){
            StdOut.print(cc.id(i)+" ");
        }
        StdOut.println();
    }
}
