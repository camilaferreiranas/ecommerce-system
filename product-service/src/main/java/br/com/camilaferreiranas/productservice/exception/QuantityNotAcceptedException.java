package br.com.camilaferreiranas.productservice.exception;

public class QuantityNotAcceptedException extends RuntimeException {

    public QuantityNotAcceptedException() {
        super("Quantity was not accepted");
    }

    public QuantityNotAcceptedException(String message) {
        super(message);
    }
}
