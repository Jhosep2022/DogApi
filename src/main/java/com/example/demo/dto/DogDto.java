package com.example.demo.dto;
import java.io.Serializable;

public class DogDto implements Serializable {

    private Long idMascotas;
    private String message;
    private String status;

    public DogDto() {
    }

    public DogDto(Long idMascotas, String message, String status) {
        this.idMascotas = idMascotas;
        this.message = message;
        this.status = status;
    }

    public Long getIdMascotas() {
        return idMascotas;
    }

    public void setIdMascotas(Long idMascotas) {
        this.idMascotas = idMascotas;
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
                "idMascotas=" + idMascotas +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
