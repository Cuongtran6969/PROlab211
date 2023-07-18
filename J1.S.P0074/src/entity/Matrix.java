/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import exceptions.InvalidSizeMatrixException;
import util.Validate;
import bo.logicMatrix;
/**
 *
 * @author HP
 */
public class Matrix {
    private int row, col, matrix[][];
    private static int indexMatrix = 1;

    public Matrix() {
    }

    public Matrix(int row, int col, int[][] matrix) {
        this.row = row;
        this.col = col;
        this.matrix = matrix;
    }

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    /**
     * Input the number row, column for the 2-dimensions matrix and check is a
     * valid size to calculate follow TYPE_CALCULATE
     * 
     * @param ruleRow        the row of other matrix use to check valid of the 
     *                       calculate with this matrix
     * @param ruleCol        the col of other matrix use to check valid of the 
     *                       calculate with this matrix
     * @param TYPE_CALCULATE the type calculate addition or subtraction or 
     *                       multipcation 
     * @throws InvalidSizeMatrixException if invalid matrix size for operator
     */
    public void inputMatrix(
            int ruleRow, 
            int ruleCol,
            final String TYPE_CALCULATE
    ) throws InvalidSizeMatrixException {
        boolean validateSize = true;
        do {
            this.row = Validate.getInt(
                    "Enter Row Matrix" + indexMatrix + ": ",
                    "Not empty input",
                    "The value out of range!",
                    "Invalid value",
                    1, Integer.MAX_VALUE
            );
            this.col = Validate.getInt(
                    "Enter Col Matrix" + indexMatrix + ": ",
                    "Not empty input",
                    "The value out of range!",
                    "Invalid value",
                    1, Integer.MAX_VALUE
            );
            if (indexMatrix != 1) {
                validateSize = logicMatrix.checkValidCalculate(
                        ruleRow, ruleCol,
                        this.row, this.col,
                        TYPE_CALCULATE
                );
                if (!validateSize) {
                    throw new InvalidSizeMatrixException(
                            "Invalid matrix size for operator! Please re-enter!"
                    );
                }
            }
        } while (!validateSize);
        this.matrix = new int[row][col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < col; j++) {
                this.matrix[i][j] = Validate.getInt(
                        "Enter matrix" + indexMatrix + 
                         "[" + i + "]" + "[" + j + "]:",
                        "Not empty input",
                        "The value out of range!",
                        "Invalid value",
                        Integer.MIN_VALUE, Integer.MAX_VALUE
                );
            }
        }
        indexMatrix++;
    }

    /**
     * Display value of matrix the 2-dimensions matrix
     */
    public void displayMatrix() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.print("[" + this.matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
