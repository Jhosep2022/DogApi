package com.example.demo.dto;
import java.io.Serializable;

public class DogDto implements Serializable {

    private Long id_dogs;
    private String message;
    private String status;

    public DogDto() {
    }

    public DogDto(Long id_dogs, String message, String status) {
        this.id_dogs = id_dogs;
        this.message = message;
        this.status = status;
    }

    public Long getIdMascotas() {
        return id_dogs;
    }

    public void setIdMascotas(Long idMascotas) {
        this.id_dogs = idMascotas;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DogDto{" +
                "id_dogs=" + id_dogs +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
