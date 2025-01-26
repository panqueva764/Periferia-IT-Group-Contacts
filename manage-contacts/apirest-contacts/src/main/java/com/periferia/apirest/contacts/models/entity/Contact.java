package com.periferia.apirest.contacts.models.entity;

import jakarta.persistence.*;
import javax.xml.crypto.Data;
import java.sql.Date;

/**
 * Representa la entidad Contacto en el sistema.
 * Esta clase está mapeada a la tabla "contacts" en la base de datos.
 * Define los atributos y métodos necesarios para la persistencia de los contactos.
 */
@Entity
@Table(name="contacts")
public class Contact {

    /**
     * Identificador único del contacto. 
     * Se genera automáticamente con la estrategia de generación de valores "IDENTITY".
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del contacto.
     */
    private String name;

    /**
     * Número de documento del contacto.
     */
    private Integer document;

    /**
     * Dirección de correo electrónico del contacto. 
     * Este campo es único en la base de datos, lo que garantiza que no existan dos contactos con el mismo correo electrónico.
     */
    @Column(unique = true)
    private String email;

    /**
     * Fecha de nacimiento del contacto.
     */
    private String birthdate;

    /**
     * Obtiene el identificador único del contacto.
     * 
     * @return id El identificador único del contacto.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del contacto.
     * 
     * @param id El identificador único del contacto.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del contacto.
     * 
     * @return name El nombre del contacto.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del contacto.
     * 
     * @param name El nombre del contacto.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el número de documento del contacto.
     * 
     * @return document El número de documento del contacto.
     */
    public Integer getDocument() {
        return document;
    }

    /**
     * Establece el número de documento del contacto.
     * 
     * @param document El número de documento del contacto.
     */
    public void setDocument(Integer document) {
        this.document = document;
    }

    /**
     * Obtiene la dirección de correo electrónico del contacto.
     * 
     * @return email La dirección de correo electrónico del contacto.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece la dirección de correo electrónico del contacto.
     * 
     * @param email La dirección de correo electrónico del contacto.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la fecha de nacimiento del contacto.
     *
     * @return birthdate La fecha de nacimiento del contacto.
     */
    public String getBirthdate() {
        return birthdate;
    }
    
    /**
     * Establece la fecha de nacimiento del contacto.
     * 
     * @param birthdate La fecha de nacimiento del contacto.
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

}
