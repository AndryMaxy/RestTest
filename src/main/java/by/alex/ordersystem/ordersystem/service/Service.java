package by.alex.ordersystem.ordersystem.service;

import java.util.List;
import java.util.Optional;

public interface Service<T, ID> {

    Optional<T> getById(ID id);

    List<T> getAll();

    void save(T t);

    void delete(ID id);
}
