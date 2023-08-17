package com.example.demo.repository;

import com.example.demo.entity.Dog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {

    @Override
    Page<Dog> findAll(Pageable pageable);

    // Si tienes otros métodos de consulta personalizados y quieres que también soporten paginación,
    // solo necesitas añadir un parámetro Pageable a la firma del método y devolver un tipo Page<T>.

    // Por ejemplo:
    // @Query("SELECT d FROM Dog d WHERE d.breed = ?1")
    // Page<Dog> findByBreed(String breed, Pageable pageable);
}