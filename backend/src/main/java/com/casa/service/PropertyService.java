package com.casa.service;

import com.casa.model.Property;
import com.casa.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyRepository repo;

    public PropertyService(PropertyRepository repo) {
        this.repo = repo;
    }

    public Property add(Property p) {
        return repo.save(p);
    }

    public List<Property> getAll() {
        return repo.findAll();
    }

    public Property getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Property update(Long id, Property updated) {
        Property existing = repo.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setTitle(updated.getTitle());
        existing.setLocation(updated.getLocation());
        existing.setRent(updated.getRent());
        existing.setDescription(updated.getDescription());
        existing.setOwnerName(updated.getOwnerName());
        existing.setContact(updated.getContact());
        existing.setOwnerId(updated.getOwnerId());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Property> searchByLocation(String location) {
        return repo.findByLocationContainingIgnoreCase(location);
    }

    public List<Property> byOwner(Long ownerId) {
        return repo.findByOwnerId(ownerId);
    }

    public List<Property> byRent(Double min, Double max) {
        return repo.findByRentBetween(min, max);
    }
}
