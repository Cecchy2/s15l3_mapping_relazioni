package dariocecchinato.Dao;

import dariocecchinato.entities.Evento;
import dariocecchinato.exeptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDao {

    private final EntityManager em;

    public PersonaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento persona) {
        //1.
        EntityTransaction transaction = em.getTransaction();
        //2.
        transaction.begin();
        //3.
        em.persist(persona);
        //4.
        transaction.commit();

        System.out.println("la persona " + persona.getDescrizione() + " è stata creata");
    }

    public Evento getById(UUID idPersona) {
        Evento found = em.find(Evento.class, idPersona);
        if (found == null) {
            throw new NotFoundException(idPersona);
        } else {
            return found;
        }
    }
}
