package io.github.dougllasfps.impl;

import io.github.dougllasfps.domain.repository.Pedidos;
import io.github.dougllasfps.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos pedidos;

    public PedidoServiceImpl(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
}
