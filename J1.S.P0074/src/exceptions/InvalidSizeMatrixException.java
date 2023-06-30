/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author HP
 */
public class InvalidSizeMatrixException extends Exception {
    public InvalidSizeMatrixException() {
        super();
    }

    public InvalidSizeMatrixException(String message) {
        super(message);
    }

    public InvalidSizeMatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSizeMatrixException(Throwable cause) {
        super(cause);
    }
}
