package com.pad.note.service;

import com.pad.note.entity.Clients;

import java.util.List;
import java.util.Optional;

public interface IClientService {

        Optional<Clients> getById(String clientsId);

        Optional<Clients> getByName(String name);

        List<Clients> getAll();

        Clients add(Clients clients);

}

