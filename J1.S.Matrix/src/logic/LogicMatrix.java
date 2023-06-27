/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import util.Validate;
import constant.Iconstant;
/**
 *
 * @author HP
 */
public class LogicMatrix {
    Validate validate = new Validate();
    
    /**
     * create a two-dimensional matrix with the number of row and col
     * 
     * @param number the order of matrix
     * @return a two-dimensional integer arrays
     */
    public int[][] createMatrix(int number) {
        int row = validate.getInt(
                "Enter Row Matrix"+number+": ",
                "The value out of range!",
                "Invalid value",
                1, Integer.MAX_VALUE
        );
        int col = validate.getInt(
                "Enter Col Matrix"+number+": ",
                "The value out of range!",
                "Invalid value",
                1, Integer.MAX_VALUE
        );
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = validate.getInt(
                        "Enter matrix" + number + "[" + i + "]" + "[" + j + "]:"
                        ,"The value out of range!"
                        ,"Invalid value"
                        ,0, Integer.MAX_VALUE
                );
            }
        }
        return matrix;
    }
    
    /**
     * sum of two 2-dimensional integer arrays 
     * 
     * @param matrix1 the first two-dimensional matrix
     * @param matrix2 the second two-dimensional matrix
     * @return a 2-dimensional integer arrays
     */
    public int[][] additionMatrix(
            int[][] matrix1,
            int[][] matrix2
    ) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int[][] matrixResult = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrixResult;
    }
    
     /**
     * subtraction of two 2-dimensional integer arrays 
     * 
     * @param matrix1 the first two-dimensional matrix
     * @param matrix2 the second two-dimensional matrix
     * @return a 2-dimensional integer arrays
     */
    public int[][] subtractionMatrix(
            int[][] matrix1,
            int[][] matrix2
    ) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int[][] matrixResult = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrixResult[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrixResult;
    }
    
    /**
     * multipcation two 2-dimensional integer arrays
     * 
     * @param matrix1 the first two-dimensional matrix
     * @param matrix2 the second two-dimensional matrix
     * @return a 2-dimensional integer arrays
     */ 
    public int[][] multiplicationMatrix(
            int[][] matrix1,
            int[][] matrix2
    ) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixResult;
    }
    
    /**
     * displays the two-dimension matrix on screen
     * 
     * @param matrix the two-dimension matrix want to display
     */
    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
    
    /**
     * check valid calculation of two two-dimension matrix
     *
     * @param matrix1
     * @param matrix2
     * @param TYPE_CALCULATE the type of math operations
     * @return true if valid calculation and false if invalid calculation
     */
    public boolean checkValidateCalculate(
            int[][] matrix1,
            int[][] matrix2,
            final String TYPE_CALCULATE
    ) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        switch (TYPE_CALCULATE) {
            case Iconstant.ADDITION:
                if (row1 != row2 || col1 != col2) {
                    return false;
                }
                return true;
            case Iconstant.SUBTRACTION:
                if (row1 != row2 || col1 != col2) {
                    return false;
                }
                return true;
            case Iconstant.MULTIPLICATION:
                if (col1 != row2) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }
}
