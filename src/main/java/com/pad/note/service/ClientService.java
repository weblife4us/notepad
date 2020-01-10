package com.pad.note.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pad.note.entity.Clients;
import com.pad.note.repository.ClientRepository;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository_;

    @Override
    public Optional<Clients> getById(String customerId) {
        return clientRepository_.findByPersonId(customerId);
    }

    @Override
    public Optional<Clients> getByName(String name) {
        return clientRepository_.findByName(name);
    }

    @Override
    public List<Clients> getAll() {
        return clientRepository_.findAllByOrderByPersonId();
    }

    @Override
    public Clients add(Clients clients) {
        return clientRepository_.save(clients);
    }
}


