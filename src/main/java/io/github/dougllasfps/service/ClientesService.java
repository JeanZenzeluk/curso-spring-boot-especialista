package io.github.dougllasfps.service;

import io.github.dougllasfps.model.ClienteModel;
import io.github.dougllasfps.repository.ClientesRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository repository;

    public ClientesService( ClientesRepository repository ){
        this.repository = repository;
    }

    public void salvarCliente(ClienteModel cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(ClienteModel cliente){
        //aplica validações
    }
}
