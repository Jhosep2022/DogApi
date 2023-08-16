package com.example.demo.dao;

import com.example.demo.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleDao {
    @Autowired
    private com.example.demo.repository.PeopleRepository PeopleRepository;

    public List<People> getAllPeople(){
        return PeopleRepository.findAllPeople();
    }

    public People getpeopleBypeopleId(Integer peopleId){
        return PeopleRepository.findpeopleBypeopleId(peopleId);
    }

    public People getpeopleBypeopleName(String peopleName){
        return PeopleRepository.findpeopleBypeopleName(peopleName);
    }

}
