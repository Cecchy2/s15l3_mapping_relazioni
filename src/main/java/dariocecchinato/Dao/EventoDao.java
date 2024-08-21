package dariocecchinato.Dao;

import dariocecchinato.entities.Evento;
import dariocecchinato.exeptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDao {

    private final EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        //1.
        EntityTransaction transaction = em.getTransaction();
        //2.
        transaction.begin();
        //3.
        em.persist(evento);
        //4.
        transaction.commit();

        System.out.println("l' evento " + evento.getDescrizione() + " è stato salvato");
    }

    public Evento getById(long idEvento) {
        Evento found = em.find(Evento.class, idEvento);
        if (found == null) {
            throw new NotFoundException(idEvento);
        } else {
            return found;
        }
    }

    public void delete(long idEvento) {
        Evento found = this.getById(idEvento);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("L'Evento " + found.getDescrizione() + " è stato rimosso");

    }
}
