package com.example.demo.repository;

import com.example.demo.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long>{
}
