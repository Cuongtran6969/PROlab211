/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import constant.Iconstant;
import entity.Matrix;
import exceptions.InvalidSizeMatrixException;

/**
 *
 * @author HP
 */
public class logicMatrix {
    
    /**
     * Input row, col and value of 2-dimension matrix want to calculate follow
     * type calculate is addition, subtraction or multipcation
     *
     * @param firstMatrix    the first matrix want to create
     * @param secondMatrix   the second matrix want to create
     * @param TYPE_CALCULATE the type of calculate will practice
     * @throws InvalidSizeMatrixException if invalid size of these matrix
     */
    public void inputMatrix(
            Matrix firstMatrix,
            Matrix secondMatrix,
            final String TYPE_CALCULATE
    )
            throws InvalidSizeMatrixException {
        firstMatrix.inputMatrix(Integer.MIN_VALUE, Integer.MAX_VALUE,
                TYPE_CALCULATE);
        secondMatrix.inputMatrix(firstMatrix.getRow(), firstMatrix.getCol(),
                TYPE_CALCULATE);
    }
    
    /**
     * Sum of two 2-dimensional integer arrays
     *
     * @param matrix1 the first two-dimensional matrix want to addition
     * @param matrix2 the second two-dimensional matrix want to addition
     * @return a 2-dimensional integer arrays after sum
     */
    public Matrix addition(Matrix matrix1, Matrix matrix2) {
        int[][] temp = new int[matrix1.getRow()][matrix1.getCol()];
        for (int i = 0; i < matrix1.getRow(); i++) {
            for (int j = 0; j < matrix1.getCol(); j++) {
                temp[i][j] = matrix1.getMatrix()[i][j] + 
                        matrix2.getMatrix()[i][j];
            }
        }
        Matrix result = new Matrix(matrix1.getRow(), matrix1.getCol(), temp);
        return result;
    }
    
    /**
     * Subtraction of two 2-dimensional integer arrays
     *
     * @param matrix1 the first two-dimensional matrix want to subtraction
     * @param matrix2 the second two-dimensional matrix want to subtraction
     * @return a 2-dimensional integer arrays after subtraction
     */
    public Matrix subtraction(Matrix matrix1, Matrix matrix2) {
        int[][] temp = new int[matrix1.getRow()][matrix1.getCol()];
        for (int i = 0; i < matrix1.getRow(); i++) {
            for (int j = 0; j < matrix1.getCol(); j++) {
                temp[i][j] = matrix1.getMatrix()[i][j]
                        - matrix2.getMatrix()[i][j];
            }
        }
        Matrix result = new Matrix(matrix1.getRow(), matrix1.getCol(), temp);
        return result;
    }
    
    /**
     * Multipcation two 2-dimensional integer arrays
     *
     * @param matrix1 the first two-dimensional matrix want to multipcation
     * @param matrix2 the second two-dimensional matrix want to multipcation
     * @return a 2-dimensional integer arrays after multipcation
     */
    public Matrix multiplication(Matrix matrix1, Matrix matrix2) {
        int[][] temp = new int[matrix1.getRow()][matrix2.getCol()];
        for (int i = 0; i < matrix1.getRow(); i++) {
            for (int j = 0; j < matrix2.getCol(); j++) {
                for (int k = 0; k < matrix1.getCol(); k++) {
                    temp[i][j] += matrix1.getMatrix()[i][k] *
                            matrix2.getMatrix()[k][j];
                }
            }
        }
        Matrix result = new Matrix(matrix1.getRow(), matrix2.getCol(), temp);
        return result;
    }
    
    /**
     * check valid calculation of two two-dimension matrix
     *
     * @param row1           the number row of first matrix
     * @param col1           the number col of first matrix
     * @param row2           the number row of second matrix
     * @param col2           the number col of second matrix
     * @param TYPE_CALCULATE the type of math operations
     * @return true if valid calculation and false if invalid calculation
     */
    public static boolean checkValidCalculate(
            int row1, int col1,
            int row2, int col2,
            final String TYPE_CALCULATE
    ) {
        switch (TYPE_CALCULATE) {
            case Iconstant.ADDITION:
            case Iconstant.SUBTRACTION:
                return row1 == row2 && col1 == col2;
            case Iconstant.MULTIPLICATION:
                return col1 == row2;
            default:
                return false;
        }
    }
}
