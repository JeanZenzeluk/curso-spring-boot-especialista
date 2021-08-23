package io.github.dougllasfps.exception;


public class PedidoNaoEcontradoException extends RuntimeException {

    public PedidoNaoEcontradoException() {
        super("Pedido não encontrado");
    }
}
