package com.periferia.apirest.contacts.controllers;

import com.periferia.apirest.contacts.models.entity.Contact;
import com.periferia.apirest.contacts.services.ContactService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Controlador REST que gestiona las operaciones CRUD para los contactos.
 * Expone endpoints HTTP para realizar las operaciones de listado, 
 * detalles, creación, edición y eliminación de contactos.
 */
@RestController
public class ContactController {

    /**
     * Servicio que maneja la lógica de negocio relacionada con los contactos.
     */
    @Autowired
    private ContactService service;

    /**
     * Endpoint para obtener una lista de todos los contactos.
     * 
     * @return Lista de objetos Contact que representan todos los contactos almacenados.
     */
    @GetMapping("/contacts")
    public List<Contact> list() {
        return service.list();
    }

    /**
     * Endpoint para obtener una lista con order dinamico, sea por nombre o por edad.
     * 
     * @return Lista de objetos Contact que representan todos los contactos almacenados.
     */
    @GetMapping("/contacts/order")
    public ResponseEntity<?> listByOrder(@RequestParam("order") String order) {
        try {
            List<Map<String, Object>> orderedContacts = service.listContactsByOrder(order);
            return ResponseEntity.ok(orderedContacts);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Endpoint para obtener los detalles de un contacto específico por su identificador.
     * Si el contacto no existe, devuelve una respuesta 404 (No Encontrado).
     * 
     * @param id Identificador único del contacto a buscar.
     * @return Respuesta HTTP que contiene el contacto encontrado o un error 404 si no se encuentra.
     */
    @GetMapping("/contacts/{id}")
    public ResponseEntity<?> details(@PathVariable Long id) {

        Optional<Contact> contactOptional = service.forId(id);

        if(contactOptional.isPresent()) {
            return ResponseEntity.ok(contactOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Endpoint para crear uno o más contactos.
     * Si se proporciona un único contacto, lo guarda.
     * Si se proporciona una lista de contactos, guarda todos.
     *
     * @return Respuesta HTTP con los contactos creados y el código de estado 201 (Creado).
     */
    @PostMapping("/contacts")
    public ResponseEntity<?> create(@RequestBody Object input) {
        if (input instanceof List) {
            // Caso: Es una lista de contactos
            List<?> inputList = (List<?>) input;
            List<Contact> contacts = inputList.stream()
                    .map(obj -> {
                        // Mapeamos cada objeto al tipo Contact usando ObjectMapper
                        return new ObjectMapper().convertValue(obj, Contact.class);
                    })
                    .toList();

            // Guardamos todos los contactos
            List<Contact> savedContacts = service.saveAll(contacts);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedContacts);

        } else if (input instanceof LinkedHashMap<?,?>) {
            // Caso: Es un solo contacto
            Contact contact = new ObjectMapper().convertValue(input, Contact.class);
            Contact savedContact = service.save(contact);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
        }

        return ResponseEntity.badRequest().body("Formato no soportado");
    }

}
