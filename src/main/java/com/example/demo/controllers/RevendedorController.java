package com.example.demo.controllers;

import com.example.demo.dto.RevendedorDto;
import com.example.demo.services.RevendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/revendedores")
public class RevendedorController {

    private final RevendedorService revendedorService;

    public RevendedorController(RevendedorService revendedorService) {
        this.revendedorService = revendedorService;
    }

    @GetMapping
    public ResponseEntity<List<RevendedorDto>> getAll() {
        List<RevendedorDto> revendedores = revendedorService.getAll();
        return ResponseEntity.ok(revendedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevendedorDto> getById(@PathVariable int id) {
        RevendedorDto revendedor = revendedorService.getById(id);
        return ResponseEntity.ok(revendedor);
    }

    @PostMapping
    public ResponseEntity<RevendedorDto> create(@RequestBody RevendedorDto dto) {
        RevendedorDto created = revendedorService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevendedorDto> update(@PathVariable int id, @RequestBody RevendedorDto dto) {
        RevendedorDto updated = revendedorService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        revendedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
