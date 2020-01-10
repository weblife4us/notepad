package com.pad.note.repository;

import com.pad.note.entity.Clients;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository

public abstract class ClientRepository implements CrudRepository<Clients,Integer> {

    public abstract Optional<Clients> findByName(String name);

    public abstract List<Clients> findAllByOrderByPersonId();

    public abstract Optional<Clients> findByPersonId(String customerId);
}
