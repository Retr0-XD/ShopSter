package com.example.demo.service;

import com.example.demo.model.Entity;
import com.example.demo.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityService {

    private final EntityRepository entityRepository;

    @Autowired
    public EntityService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public List<Entity> findAll() {
        return entityRepository.findAll();
    }

    public Optional<Entity> findById(Long id) {
        return entityRepository.findById(id);
    }

    public Entity save(Entity entity) {
        return entityRepository.save(entity);
    }

    public void deleteById(Long id) {
        entityRepository.deleteById(id);
    }
}