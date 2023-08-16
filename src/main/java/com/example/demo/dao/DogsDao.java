package com.example.demo.dao;

import com.example.demo.entity.Dog;
import com.example.demo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogsDao {
    @Autowired
    private DogRepository DogsRepository;

    public List<Dog> getAllDogs(){
        return DogsRepository.findAllDogs();
    }

    public Dog getdogsBydogsId(Integer dogsId){
        return DogsRepository.finddogsBydogsId(dogsId);
    }

    public Dog getdogsBydogsName(String dogsName){
        return DogsRepository.finddogsBydogsName(dogsName);
    }
}
