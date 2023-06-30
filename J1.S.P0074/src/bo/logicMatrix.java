/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Matrix;
import exceptions.InvalidSizeMatrixException;

/**
 *
 * @author HP
 */
public class logicMatrix {
    
    /**
     * create these matrix want to calculate
     * 
     * @param firstMatrix    the first matrix want to create
     * @param secondMatrix   the second matrix want to create
     * @param TYPE_CALCULATE the type of calculate will practice
     * @throws InvalidSizeMatrixException if invalid size of these matrix
     */
    public void createMatrix(
            Matrix firstMatrix, Matrix secondMatrix,
            final String TYPE_CALCULATE
    ) 
            throws InvalidSizeMatrixException 
    {
        firstMatrix.inputMatrix(1);
        secondMatrix.inputMatrix(2, firstMatrix, TYPE_CALCULATE);
    }
}
