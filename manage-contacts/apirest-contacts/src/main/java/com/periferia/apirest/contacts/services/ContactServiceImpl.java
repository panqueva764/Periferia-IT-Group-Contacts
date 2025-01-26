package com.periferia.apirest.contacts.services;

import com.periferia.apirest.contacts.models.entity.Contact;
import com.periferia.apirest.contacts.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * Implementación del servicio ContactService.
 * Esta clase contiene la lógica de negocio para gestionar los contactos,
 * utilizando el repositorio ContactRepository para realizar operaciones
 * de persistencia en la base de datos.
 */
@Service
public class ContactServiceImpl implements ContactService {

    /**
     * Repositorio de contactos utilizado para acceder a la base de datos.
     */
    @Autowired
    private ContactRepository repository;

    /**
     * Guarda la cantidad de usuarios que se pasen por el body de la peticiòn.
     * 
     * @param contacts Contactos enviados desde la peticiòn.
     * @return Un objeto Optional que contiene el contacto si se encuentra,
     *         o un valor vacío si no se encuentra.
     */
    @Override
    @Transactional
    public List<Contact> saveAll(List<Contact> contacts) {
        return (List<Contact>) repository.saveAll(contacts);
    }

    /**
     * Guarda un nuevo contacto o actualiza uno existente en la base de datos.
     * 
     * @param contact El contacto a guardar.
     * @return El contacto guardado, que puede incluir un ID asignado si es nuevo.
     */
    @Override
    @Transactional
    public Contact save(Contact contact) {
        // Guarda o actualiza el contacto en la base de datos
        return repository.save(contact);
    }

}
