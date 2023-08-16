package com.example.demo.api;

import com.example.demo.bl.DogBl;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
            ResponseDto<Dog> response = dogBl.fetchAndSaveDog();

            if (response != null && response.getCode() != null) {
                logger.info("Proceso completado con éxito. Devolviendo respuesta al cliente.");
                return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode().intValue()));
            } else {
                logger.error("La respuesta o el código de la respuesta es nulo. Devolviendo un error interno del servidor.");
                return new ResponseEntity<>(new ResponseDto<>(500, "Error Interno del Servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error("Error al procesar la petición /fetch: ", e);
            return new ResponseEntity<>(new ResponseDto<>(500, "Error Interno del Servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Aqui puedes agregar otros endpoints, por ejemplo, para obtener perros de la DB
}