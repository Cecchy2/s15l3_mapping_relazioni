package dariocecchinato;

import dariocecchinato.Dao.EventoDao;
import dariocecchinato.Dao.LocationDao;
import dariocecchinato.Dao.PersonaDao;
import dariocecchinato.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("s15l3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventoDao eventoDao = new EventoDao(em);
        LocationDao locationDao = new LocationDao(em);
        PersonaDao personaDao = new PersonaDao(em);

        Evento evento1 = new Evento("Evento1", LocalDateTime.of(2024, 8, 20, 10, 0), "Riunione", null, TipoEvento.PRIVATO, 20);
        Evento evento2 = new Evento("Evento2", LocalDateTime.of(2024, 10, 12, 9, 0), "Conferenza", null, TipoEvento.PUBBLICO, 300);
        Evento evento3 = new Evento("Evento3", LocalDateTime.of(2024, 11, 26, 15, 0), "Fiera", null, TipoEvento.PUBBLICO, 150);


        //eventoDao.save(evento1);
        //eventoDao.save(evento2);
        //eventoDao.save(evento3);


        Location location1 = new Location("Sala Conferenze A", "Roma", evento1);
        Location location2 = new Location("Centro Congressi B", "Milano", evento2);
        Location location3 = new Location("Piazza Fiera C", "Torino", evento3);


        //locationDao.save(location1);
        //locationDao.save(location2);
        //locationDao.save(location3);

        Persona persona1 = new Persona("Mario", "Rossi", "mario.rossi@example.com", LocalDate.of(1985, 5, 15), Sesso.M);
        Persona persona2 = new Persona("Luca", "Bianchi", "luca.bianchi@example.com", LocalDate.of(1990, 7, 22), Sesso.M);
        Persona persona3 = new Persona("Giulia", "Verdi", "giulia.verdi@example.com", LocalDate.of(1992, 3, 10), Sesso.D);

        personaDao.save(persona1);
        personaDao.save(persona2);
        personaDao.save(persona3);

        em.close();
        emf.close();
    }
}
