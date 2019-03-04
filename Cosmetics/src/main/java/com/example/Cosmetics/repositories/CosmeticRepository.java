package com.example.Cosmetics.repositories;

import com.example.Cosmetics.entities.Cosmetic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CosmeticRepository extends JpaRepository<Cosmetic, String> {
}