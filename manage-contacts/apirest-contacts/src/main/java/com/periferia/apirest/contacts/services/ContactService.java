package com.periferia.apirest.contacts.services;

import com.periferia.apirest.contacts.models.entity.Contact;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Interface que define los métodos relacionados con los servicios de contacto.
 * Esta interfaz será implementada por una clase de servicio para gestionar operaciones
 * CRUD sobre los contactos en el sistema.
 */
public interface ContactService {

   /**
     * Obtiene una lista de todos los contactos almacenados en el sistema.
     *
     * @return Lista de objetos Contact que representan todos los contactos.
     */
    List<Contact> list();

   /**
     * Obtiene una lista de todos los contactos almacenados en el sistema dependiendo el parametro enviado.
     *
     * @return Lista de objetos Contact que representan todos los contactos.
     */
    List<Map<String, Object>> listContactsByOrder(String order);

    /**
     * Busca un contacto por su identificador único.
     * 
     * @param id Identificador único del contacto a buscar.
     * @return Un objeto Optional que contiene el contacto si se encuentra,
     *         o un valor vacío si no se encuentra ningún contacto con el id proporcionado.
     */
    Optional<Contact> forId(Long id);

    /**
     * Guarda un nuevo contacto o actualiza uno existente en el sistema.
     *
     * @param contact Objeto Contact que contiene la información del contacto a guardar.
     * @return El contacto guardado, que puede incluir un id asignado si es nuevo.
     */
    Contact save(Contact contact);

   /**
    * Guarda múltiples contactos en el sistema.
    *
    * @param contacts Lista de contactos a guardar.
    * @return Lista de contactos guardados.
    */
   List<Contact> saveAll(List<Contact> contacts);

    /**
     * Elimina un contacto del sistema por su identificador único.
     * 
     * @param id Identificador único del contacto a eliminar.
     */
    void delete(Long id);
    
}
