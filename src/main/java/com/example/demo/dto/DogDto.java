package com.example.demo.dto;
import java.io.Serializable;

public class DogDto implements Serializable {

    private Integer idMascotas;
    private String message;
    private Boolean status;

    public DogDto() {
    }

    public DogDto(Integer idMascotas, String message, Boolean status) {
        this.idMascotas = idMascotas;
        this.message = message;
        this.status = status;
    }

    public Integer getIdMascotas() {
        return idMascotas;
    }

    public void setIdMascotas(Integer idMascotas) {
        this.idMascotas = idMascotas;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "dogsdto{" +
                "idMascotas=" + idMascotas +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
