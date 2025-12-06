package com.casa.repository;

import com.casa.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByLocationContainingIgnoreCase(String location);
    List<Property> findByOwnerId(Long ownerId);
    List<Property> findByRentBetween(Double min, Double max);
}
