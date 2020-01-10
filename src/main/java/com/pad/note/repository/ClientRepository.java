package com.pad.note.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.pad.note.entity.Clients;

@org.springframework.stereotype.Repository
public interface ClientRepository extends CrudRepository<Clients, Integer> {

    Optional<Clients> findByName(String name);

    List<Clients> findAllByOrderByPersonId();

    Optional<Clients> findByPersonId(String customerId);
}
