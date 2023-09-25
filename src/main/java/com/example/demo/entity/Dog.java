package com.example.demo.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "dogs", catalog = "arquidogs", schema = "public")
@NamedQueries({
        @NamedQuery(name = "dogs.findAll", query = "SELECT d FROM Dog d"),
})
public class Dog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mascotas")
    private Long id_dogs;

    @Basic(optional = false)
    @Column(name = "message")
    private String message;

    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public Dog() {
    }

    public Dog(Long id_dogs, String message, String status) {
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
        return "Dog{" +
                "id_dogs=" + id_dogs +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
