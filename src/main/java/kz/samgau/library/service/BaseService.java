package kz.samgau.library.service;

import java.util.List;

public interface BaseService<E, T> {
    E saveOrUpdate(E entity);

    List<E> findAll();

    E findById(T id);

    void deleteById(T id);
}
