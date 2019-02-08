package com.codeoftheweb.salvo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private long id;

    private String userName;

    @OneToMany(mappedBy="player", fetch= FetchType.EAGER)
    private
    Set<GamePlayer> gamePlayers;

    public Player() { }

    public Player(String userName ) {
   this.setUserName(userName);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void addGamePlayer(GamePlayer gamePlayer){
        gamePlayer.setPlayer(this);
        getGamePlayers().add(gamePlayer);
    }


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
