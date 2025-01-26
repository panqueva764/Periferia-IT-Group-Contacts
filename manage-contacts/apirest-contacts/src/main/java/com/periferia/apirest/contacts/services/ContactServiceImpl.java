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
     * Obtiene la lista de todos los contactos almacenados en la base de datos.
     * 
     * @return Lista de contactos almacenados.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Contact> list() {
        // Utiliza el repositorio para obtener todos los contactos
        return (List<Contact>) repository.findAll();
    }

    /**
     * Obtiene la lista ordenada por nombre o edad de todos los contactos almacenados en la base de datos.
     * 
     * @return Lista de contactos almacenados.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> listContactsByOrder(String order) {
        // Asegúrate de que repository.findAll() devuelve una lista de Contact
        List<Contact> contacts = (List<Contact>) repository.findAll();  // Convierte a List<Contact>

        List<Map<String, Object>> responseList = new ArrayList<>();  // Declara la lista de respuestas

        switch (order) {
            case "asc":
                contacts.sort(Comparator.comparing(Contact::getName));
                break;
            case "desc":
                contacts.sort(Comparator.comparing(Contact::getName).reversed());
                break;
            case "age-asc":
                contacts.sort(Comparator.comparing(contact -> calculateAge(contact.getBirthdate())));
                break;
            case "age-des":
                contacts.sort(Comparator.comparing(contact -> calculateAge(contact.getBirthdate())));
                Collections.reverse(contacts);  // Revertimos para orden descendente
                break;
            default:
                throw new IllegalArgumentException("Orden no válido. Use 'asc', 'desc', 'age-asc' o 'age-des'.");
        }

        // Transformar los contactos en mapas para modificar la respuesta
        for (Contact contact : contacts) {
            int age = calculateAge(contact.getBirthdate());  // Calculamos la edad
            Map<String, Object> contactResponse = new LinkedHashMap<>();  // Creamos un mapa para la respuesta

            contactResponse.put("id", contact.getId());
            contactResponse.put("name", contact.getName());
            contactResponse.put("document", contact.getDocument());
            contactResponse.put("email", contact.getEmail());
            contactResponse.put("age", age + " años");  // Reemplazamos 'birthdate' por 'age'

            // Agregar el mapa de contacto a la lista de respuestas
            responseList.add(contactResponse);
        }

        return responseList;  // Retorna la lista de respuestas
    }

    /**
     * Calcula y formatea la edad de lo clientes.
     * 
     * @return Lista de contactos almacenados.
     */
    private int calculateAge(String birthdate) {
        LocalDate birthDate = LocalDate.parse(birthdate);  // Convertimos el birthdate a LocalDate
        return Period.between(birthDate, LocalDate.now()).getYears();  // Calculamos la edad
    }
    /**
     * Busca un contacto por su identificador único.
     * 
     * @param id Identificador único del contacto a buscar.
     * @return Un objeto Optional que contiene el contacto si se encuentra,
     *         o un valor vacío si no se encuentra.
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<Contact> forId(Long id) {
        // Utiliza el repositorio para buscar el contacto por su ID
        return repository.findById(id);
    }

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
