package com.deg.productservice.service;

import com.deg.productservice.exception.ClientAlreadyExistsException;
import com.deg.productservice.model.Client;
import com.deg.productservice.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client newClient) throws ClientAlreadyExistsException {
        Optional<Client> clientOp = this.clientRepository.findById(newClient.getId());

        if (clientOp.isPresent()){
            log.info("El cliente que intenta agregar ya existe en la base de datos" + newClient);
            throw new ClientAlreadyExistsException("El cliente que intenta agregar ya existe en la base de datos");
        } else {
            return this.clientRepository.save(newClient);
        }
    }

    public List<Client> findAll(){
        return this.clientRepository.findAll();
    }
}
