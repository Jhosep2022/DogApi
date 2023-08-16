package com.example.demo.dto;

import java.io.Serializable;

public class PeopleDto implements Serializable {

    private Integer id_usuario;
    private String nombre;
    private String edad;
    private String telefono;


    public PeopleDto() {
    }

    public PeopleDto(Integer id_usuario, String nombre, String edad, String telefono) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "peopledto{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
