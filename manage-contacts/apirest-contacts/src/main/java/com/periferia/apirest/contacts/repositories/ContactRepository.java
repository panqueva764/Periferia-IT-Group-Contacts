package com.periferia.apirest.contacts.repositories;

import com.periferia.apirest.contacts.models.entity.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio que proporciona operaciones CRUD (crear, leer, actualizar y eliminar)
 * para la entidad Contact. Extiende de CrudRepository para ofrecer funcionalidad
 * básica de persistencia de datos en la base de datos.
 * 
 * La implementación del repositorio es proporcionada automáticamente por Spring Data JPA.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {
    // No es necesario implementar ningún método, ya que Spring Data JPA proporciona
    // implementaciones automáticas para las operaciones CRUD estándar.
}
