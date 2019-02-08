package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class GamePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private long id;

    private Date joinDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id")
    private Player player;

    @OneToMany(mappedBy="gamePlayer", fetch= FetchType.EAGER)
    private
    Set<Ship> ships;

    public GamePlayer() { }

    public GamePlayer(Game game, Player player, Date joinDate) {
        this.setGame(game);
        this.setPlayer(player);
        this.setJoinDate(joinDate);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public Date getJoinDate() {

        return joinDate;
    }

    public void setJoinDate(Date joinDate) {

        this.joinDate = joinDate;
    }

    public Game getGame() {

        return game;
    }

    public void setGame(Game game) {

        this.game = game;
    }

    public Player getPlayers() {

        return player;
    }

    public void setPlayer(Player player) {

        this.player = player;
    }
    public Set<Ship> getShips(){
        return ships;
    }
    public void setShip(Set<Ship>ship){
        this.ships= ship;
    }
    public void addShip(Ship ship){
        ship.setGamePlayer(this);
        ships.add(ship);
    }


}
