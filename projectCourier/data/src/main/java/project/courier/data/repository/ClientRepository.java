package project.courier.data.repository;

import project.courier.data.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository{
    void save(Client client);
    void update(Client client);
    void delete(Client client);
    Optional<Client> getById(long id);
    List<Client> getAll();
}
