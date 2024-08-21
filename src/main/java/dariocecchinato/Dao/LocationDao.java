package dariocecchinato.Dao;

import dariocecchinato.entities.Evento;
import dariocecchinato.exeptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDao {

    private final EntityManager em;

    public LocationDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento location) {
        //1.
        EntityTransaction transaction = em.getTransaction();
        //2.
        transaction.begin();
        //3.
        em.persist(location);
        //4.
        transaction.commit();

        System.out.println("la location " + location.getDescrizione() + " è stata salvata");
    }

    public Evento getById(UUID idLocation) {
        Evento found = em.find(Evento.class, idLocation);
        if (found == null) {
            throw new NotFoundException(idLocation);
        } else {
            return found;
        }
    }
}
