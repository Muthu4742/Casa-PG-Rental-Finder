package com.casa.controller;

import com.casa.model.Property;
import com.casa.service.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "http://localhost:3000")
public class PropertyController {

    private final PropertyService service;

    public PropertyController(PropertyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Property property) {
        return ResponseEntity.ok(service.add(property));
    }

    @GetMapping
    public List<Property> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Property p = service.getById(id);
        return p == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Property property) {
        Property updated = service.update(id, property);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/search")
    public List<Property> search(@RequestParam String location) {
        return service.searchByLocation(location);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Property> byOwner(@PathVariable Long ownerId) {
        return service.byOwner(ownerId);
    }

    @GetMapping("/filter/rent")
    public List<Property> byRent(@RequestParam Double min, @RequestParam Double max) {
        return service.byRent(min, max);
    }
}
