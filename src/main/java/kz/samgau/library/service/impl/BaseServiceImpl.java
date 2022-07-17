package kz.samgau.library.service.impl;

import kz.samgau.library.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseServiceImpl<E, T> implements BaseService<E, T> {

    @Autowired
    protected JpaRepository<E, T> repository;

    @Override
    public E saveOrUpdate(E entity) {
        return repository.save(entity);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E findById(T id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(T id) {
        repository.deleteById(id);
    }
}
