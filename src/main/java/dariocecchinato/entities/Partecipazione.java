package dariocecchinato.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private StatoPartecipazione statoPartecipazione;


    public Partecipazione(StatoPartecipazione statoPartecipazione, Evento evento) {
        this.statoPartecipazione = statoPartecipazione;
        this.evento = evento;
    }

    public Partecipazione() {
    }

    public UUID getId() {
        return id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoPartecipazione getStatoPartecipazione() {
        return statoPartecipazione;
    }

    public void setStatoPartecipazione(StatoPartecipazione statoPartecipazione) {
        this.statoPartecipazione = statoPartecipazione;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", evento=" + evento +
                ", statoPartecipazione=" + statoPartecipazione +
                '}';
    }
}
