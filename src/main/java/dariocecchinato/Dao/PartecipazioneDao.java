package dariocecchinato.Dao;

import dariocecchinato.entities.Evento;
import dariocecchinato.exeptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDao {

    private final EntityManager em;

    public PartecipazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento partecipazione) {
        //1.
        EntityTransaction transaction = em.getTransaction();
        //2.
        transaction.begin();
        //3.
        em.persist(partecipazione);
        //4.
        transaction.commit();

        System.out.println("la partecipazione " + partecipazione.getDescrizione() + " è stata creata");
    }

    public Evento getById(UUID idPartecipazione) {
        Evento found = em.find(Evento.class, idPartecipazione);
        if (found == null) {
            throw new NotFoundException(idPartecipazione);
        } else {
            return found;
        }
    }
}
