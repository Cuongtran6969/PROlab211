/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import exceptions.InvalidSizeMatrixException;
import util.Validate;
import constant.Iconstant;
/**
 *
 * @author HP
 */
public class Matrix {
    private int row, col, matrix[][];

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
     * input the number row, column for the 2-dimensions matrix and input value
     * of matrix
     * @param ID the order of matrix
     */
    public void inputMatrix(int ID) {
        this.row = Validate.getInt(
                "Enter Row Matrix1: ",
                "Not empty input",
                "The value out of range!",
                "Invalid value",
                1, Integer.MAX_VALUE
        );
        this.col = Validate.getInt(
                "Enter Col Matrix1: ",
                "Not empty input",
                "The value out of range!",
                "Invalid value",
                1, Integer.MAX_VALUE
        );
        this.matrix = new int[row][col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < col; j++) {
                this.matrix[i][j] = Validate.getInt(
                        "Enter matrix" + ID + "[" + i + "]" + "[" + j + "]:",
                        "Not empty input",
                        "The value out of range!",
                        "Invalid value",
                        1, Integer.MAX_VALUE
                );
            }
        }
    }
    
    /**
     * Input the number row, column for the 2-dimensions second matrix and check
     * is a valid size to calculate follow TYPE_CALCULATE and input value for
     * matrix
     * 
     * @param ID             the order matrix
     * @param firstMatrix    the first matrix to check valid size with second
     *                       matrix
     * @param TYPE_CALCULATE the type calculate addition or subtraction or 
     *                       multipcation
     * @throws InvalidSizeMatrixException if invalid matrix size for operator
     */
    public void inputMatrix(
            int ID, Matrix firstMatrix,
            final String TYPE_CALCULATE
    ) throws InvalidSizeMatrixException {
        boolean validateSize;
        do {
            this.row = Validate.getInt(
                    "Enter Row Matrix" + ID + ": ",
                    "Not empty input",
                    "The value out of range!",
                    "Invalid value",
                    0, Integer.MAX_VALUE
            );
            this.col = Validate.getInt(
                    "Enter Col Matrix" + ID + ": ",
                    "Not empty input",
                    "The value out of range!",
                    "Invalid value",
                    0, Integer.MAX_VALUE
            );
            validateSize = checkValidateCalculate(
                    firstMatrix.row, firstMatrix.col,
                    this.row, this.col,
                    TYPE_CALCULATE
            );
            if (!validateSize) {
                throw new InvalidSizeMatrixException(
                        "Invalid matrix size for operator! Please re-enter!"
                );
            }
        } while (!validateSize);
        this.matrix = new int[row][col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < col; j++) {
                this.matrix[i][j] = Validate.getInt(
                        "Enter matrix" + ID + "[" + i + "]" + "[" + j + "]:",
                        "Not empty input",
                        "The value out of range!",
                        "Invalid value",
                        0, Integer.MAX_VALUE
                );
            }
        }
    }
    
    /**
     * Display value of matrix
     */
    public void displayMatrix() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.print("[" + this.matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
    
    /**
     * Sum of two 2-dimensional integer arrays
     * 
     * @param matrix2 the second two-dimensional matrix want to addition
     * @return a 2-dimensional integer arrays after sum
     */
    public Matrix addition(Matrix matrix2) {
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = matrix[i][j] + matrix2.matrix[i][j];
            }
        }
        Matrix result = new Matrix(row, col, temp);
        return result;
    }
    
    /**
     * Subtraction of two 2-dimensional integer arrays 
     * 
     * @param matrix2 the second two-dimensional matrix want to subtraction
     * @return a 2-dimensional integer arrays after subtraction
     */
    public Matrix subtraction(Matrix matrix2) {
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = matrix[i][j] - matrix2.matrix[i][j];
            }
        }
        Matrix result = new Matrix(row, col, temp);
        return result;
    }
    
    /**
     * Multipcation two 2-dimensional integer arrays
     * 
     * @param matrix2 the second two-dimensional matrix want to multipcation
     * @return a 2-dimensional integer arrays after multipcation
     */
    public Matrix multiplication(Matrix matrix2) {
        int[][] temp = new int[row][matrix2.col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < matrix2.col; j++) {
                for (int k = 0; k < col; k++) {
                    temp[i][j] += matrix[i][k]
                            * matrix2.matrix[k][j];
                }
            }
        }
        Matrix result = new Matrix(row, matrix2.col, temp);
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
    public boolean checkValidateCalculate(
            int row1, int col1,
            int row2, int col2,
            final String TYPE_CALCULATE
    ) {
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
