package com.example.demo.dao;
import com.example.demo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogsDao {
    @Autowired
    private DogRepository DogsRepository;


}
