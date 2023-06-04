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

    public Graph(int numberVertices) {
        this.numberVertices = numberVertices;
        this.adjacencyMatrix = new boolean[numberVertices][numberVertices];
    }

    public void addEdge(int i, int j) {
       if(i>0 && i<numberVertices && j>0 && j<numberVertices ) {
         adjacencyMatrix[i][j] = true;
         adjacencyMatrix[j][i] = true;
       }
    }
    
    public boolean isEdge(int i, int j) {
      if(i>0 && i<numberVertices && j>0 && j<numberVertices ) {
         return adjacencyMatrix[i][j] || adjacencyMatrix[j][i];
       }
      return false;
    }
    
    public int getNumberVertices() {
        return numberVertices;
    }

    public void setNumberVertices(int numberVertices) {
        this.numberVertices = numberVertices;
    }

    public boolean[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(boolean[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
    
    
    
    
}
