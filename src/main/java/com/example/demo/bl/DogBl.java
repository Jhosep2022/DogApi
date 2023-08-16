package com.example.demo.bl;

import com.example.demo.dao.DogsDao;
import com.example.demo.dto.DogDto;
import com.example.demo.entity.Dog;
import com.example.demo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogBl {

    @Autowired
    private DogRepository dogRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private DogsDao dogsDao;

    public Dog fetchAndSaveDog(){
        String apiUrl = "https://dog.ceo/api/breeds/image/random";
        ResponseEntity<Dog> response = restTemplate.getForEntity(apiUrl, Dog.class);

        if(response.getStatusCode() == HttpStatus.Ok){
            Dog dog = response.getBody();
            return dogRepository.save(dog);
        }

    }


}
