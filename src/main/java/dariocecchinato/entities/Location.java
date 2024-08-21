package dariocecchinato.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String citta;

    @OneToOne
    @JoinColumn(name = "id_location", nullable = false, unique = true)
    private Evento evento;

    public Location(String nome, String citta, Evento evento) {
        this.nome = nome;
        this.citta = citta;
        this.evento = evento;
    }

    //---------------costruttore vuoto-----------------
    public Location() {
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
