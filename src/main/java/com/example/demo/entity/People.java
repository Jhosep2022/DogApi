package com.example.demo.entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "usuario", catalog = "arquidogs", schema = "public")
public class People implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "edad")
    private String edad;

    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;


    public People() {
    }

    public People(Integer idUsuario, String nombre, String edad, String telefono) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
        return "People{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
