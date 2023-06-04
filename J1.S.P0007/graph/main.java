/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211.graph;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph Graph = new Graph(6);
        Graph.addEdge(1, 4);
        Graph.addEdge(2, 4);
        Graph.addEdge(2, 5);
        Graph.addEdge(3, 5);
        Graph.addEdge(4, 5);
        int startPoint, endPoint;
        System.out.println("Enter the start point: ");
        startPoint = sc.nextInt();
        System.out.println("Enter the end point: ");
        endPoint = sc.nextInt();
        System.out.println("This is"+(Graph.isEdge(startPoint, endPoint)?"":" not")+ " an edge");
    }
    
    
}
