package com.example.demo.repository;

import com.example.demo.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {
    @Query(value = "SELECT * FROM dogs WHERE status = true", nativeQuery = true)
    List<Dog> findAllDogs();

    Dog finddogsBydogsId(Integer dogsId);

    Dog finddogsBydogsName(String dogsName);
}
