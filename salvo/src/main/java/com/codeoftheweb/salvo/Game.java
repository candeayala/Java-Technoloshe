package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private Date creationDate;

    public Game() { }

    public Game(Date creationDate ) {
        this.setCreationDate(creationDate);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date userName) {
        this.creationDate= creationDate;
    }

    @OneToMany(mappedBy="game", fetch= FetchType.EAGER)
    private
    Set<GamePlayer> gamePlayers;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }
}
