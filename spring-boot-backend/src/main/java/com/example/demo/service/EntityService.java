package com.example.demo.service;

import com.example.demo.model.BaseEntity;
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

    public List<BaseEntity> getAllEntities() {
        return entityRepository.findAll();
    }

    public BaseEntity getEntityById(Long id) {
        return entityRepository.findById(id).orElse(null);
    }

    public BaseEntity createEntity(BaseEntity entity) {
        return entityRepository.save(entity);
    }

    public BaseEntity updateEntity(Long id, BaseEntity entity) {
        return entityRepository.findById(id)
            .map(existingEntity -> {
                entity.setId(id);
                return entityRepository.save(entity);
            })
            .orElse(null);
    }

    public boolean deleteEntity(Long id) {
        if (entityRepository.existsById(id)) {
            entityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}