/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211.graph;

/**
 *
 * @author HP
 */
public class Graph {
    private int numberVertices;
    private boolean adjacencyMatrix[][];

    /**
     * create a Graph with number vertices with matrix contain boolean value
     * 
     * @param numberVertices the number of vertices to create matrix
     */
    public Graph(int numberVertices) {
        this.numberVertices = numberVertices;
        this.adjacencyMatrix = new boolean[numberVertices][numberVertices];
    }

    /**
     * add edges to the undirected graph represented by the adjacency matrix.
     * @param i first vertices of edge
     * @param j second vertices of edge
     */
    public void addEdge(int i, int j) {
       if(i>0 && i<=numberVertices && j>0 && j<=numberVertices ) {
         adjacencyMatrix[i][j] = true;
         adjacencyMatrix[j][i] = true;
       }
    }
    
    /**
     * checks two vertices i and j are edges of the graph.
     * 
     * @param i vertices
     * @param j vertices
     * @return true if i and j belong to a edge in graph
     */
    public boolean isEdge(int i, int j) {
      if(i>0 && i<=numberVertices && j>0 && j<=numberVertices ) {
         return adjacencyMatrix[i][j] || adjacencyMatrix[j][i];
       }
      return false;
    }
}
