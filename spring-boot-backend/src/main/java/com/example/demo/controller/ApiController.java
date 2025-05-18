package com.example.demo.controller;

import com.example.demo.model.BaseEntity;
import com.example.demo.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entities")
public class ApiController {

    @Autowired
    private EntityService entityService;

    @GetMapping
    public List<BaseEntity> getAllEntities() {
        return entityService.getAllEntities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseEntity> getEntityById(@PathVariable Long id) {
        BaseEntity entity = entityService.getEntityById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public BaseEntity createEntity(@RequestBody BaseEntity entity) {
        return entityService.createEntity(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseEntity> updateEntity(@PathVariable Long id, @RequestBody BaseEntity entity) {
        BaseEntity updatedEntity = entityService.updateEntity(id, entity);
        return updatedEntity != null ? ResponseEntity.ok(updatedEntity) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        return entityService.deleteEntity(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}