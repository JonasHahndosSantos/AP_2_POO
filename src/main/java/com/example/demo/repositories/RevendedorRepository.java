package com.example.demo.repositories;

import com.example.demo.models.Revendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevendedorRepository extends JpaRepository<Revendedor, Integer> {
}
