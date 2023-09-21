package com.example.demo.api;

import com.example.demo.bl.DogBl;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dogs")
public class Dogs_Api {

    private static final Logger logger = LoggerFactory.getLogger(Dogs_Api.class);

    @Autowired
    private DogBl dogBl;

    @GetMapping("/fetch")
    public ResponseEntity<ResponseDto<Dog>> fetchAndSaveDog() {
        try {
            logger.info("Iniciando el proceso para obtener y guardar un perro mediante el endpoint /fetch.");
            Dog dog = dogBl.fetchAndSaveDog();
            return new ResponseEntity<>(new ResponseDto<>(200, dog, "Perro guardado exitosamente"), HttpStatus.OK);

        } catch (RuntimeException e) {
            logger.error("Error al procesar la petición /fetch: ", e.getMessage());
            return new ResponseEntity<>(new ResponseDto<>(500, "Error Interno del Servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDto<Page<Dog>>> listDogs(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        try {
            logger.info("Iniciando el proceso para obtener una lista paginada de perros.");
            Page<Dog> dogs = dogBl.findAllDogs(page, size);
            return new ResponseEntity<>(new ResponseDto<>(200, dogs, "Lista de perros"), HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error al procesar la petición /list: ", e.getMessage());
            return new ResponseEntity<>(new ResponseDto<>(500, "Error Interno del Servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update
//    @GetMapping("/list/update")
//    public ResponseEntity<ResponseDto<Page<Dog>>> listDogsUpdate(
//            @RequestParam(value = "page", defaultValue = "0") int page,
//            @RequestParam(value = "size", defaultValue = "10") int size) {
//        try {
//            logger.info("Iniciando el proceso para obtener una lista paginada de perros.");
//            Page<Dog> dogs = dogBl.findAllDogs(page, size);
//            return new ResponseEntity<>(new ResponseDto<>(200, dogs, "Lista de perros"), HttpStatus.OK);
//
//        } catch (Exception e) {
//            logger.error("Error al procesar la petición /list: ", e.getMessage());
//            return new ResponseEntity<>(new ResponseDto<>(500, "Error Interno del Servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
