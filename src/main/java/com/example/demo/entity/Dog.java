package com.example.demo.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "dogs", catalog = "ArquiDogs", schema = "public")
@NamedQueries({
        @NamedQuery(name = "dogs.findAll", query = "SELECT d FROM Dog d"),
})
public class Dog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mascotas")
    private Long idMascotas;

    @Basic(optional = false)
    @Column(name = "message")
    private String message;

    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public Dog() {
    }

    public Dog(Long idMascotas, String message, String status) {
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
        return "Dog{" +
                "idMascotas=" + idMascotas +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
