package com.example.demo.bl;

import com.example.demo.dao.DogsDao;
import com.example.demo.entity.Dog;
import com.example.demo.repository.DogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;

@Service
public class DogBl {
    private static final Logger logger = LoggerFactory.getLogger(DogBl.class);

    @Autowired
    private DogRepository dogRepository;

    @Value("${dogApi.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private DogsDao dogsDao;

    public Dog fetchAndSaveDog() {
        logger.debug("Obteniendo datos del perro desde la URL: {}", apiUrl);
        ResponseEntity<Dog> response = restTemplate.getForEntity(apiUrl, Dog.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Dog dog = response.getBody();
            logger.debug("Datos del perro recibidos: {}", dog);

            dogRepository.save(dog);
            logger.info("Datos del perro guardados exitosamente en la base de datos.");

            return dog;
        } else {
            logger.warn("Fallo al recuperar datos del perro desde la API. Código de respuesta: {}", response.getStatusCodeValue());
            throw new RuntimeException("Error al consumir la API de perros");
        }
    }
}
