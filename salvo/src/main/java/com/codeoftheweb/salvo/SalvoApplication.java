package com.codeoftheweb.salvo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository) {
		return (args) -> {
			// save a couple of customer

			Player player1= new Player("Cande");
			Player player2= new Player("Crash");
			Player player3= new Player("Bomberman");
			playerRepository.save(new Player("candela.Ayala116@Gmail.com"));
			playerRepository.save(new Player("Maria_Flores@Yahoo.com"));
			playerRepository.save(new Player("Sarita_y_Franco@Hotmail.com"));
			playerRepository.save(new Player("Daniel992@Gmail.com"));
			playerRepository.save(new Player("Michelle_Obama@Gmail.com"));
			playerRepository.save(player1);
			playerRepository.save(player2);
			playerRepository.save(player3);

			Date date = new Date();
			Date date2 = Date.from(date.toInstant().plusSeconds(3600));
			Date date3 = Date.from(date.toInstant().plusSeconds(7200));

			Game game1 = new Game(date);
			game1.setCreationDate(new Date());
			Game game2 = new Game(date2);
			game2.setCreationDate(new Date());
			Game game3 = new Game(date3);
			game3.setCreationDate(new Date());

			gameRepository.save(game1);
			gameRepository.save(game2);
			gameRepository.save(game3);

			GamePlayer gamePlayer1 = new GamePlayer(game1, player1, date);
			GamePlayer gamePlayer2 = new GamePlayer(game1, player2, date);
			GamePlayer gamePlayer3 = new GamePlayer(game1, player3, date);

			gamePlayerRepository.save(gamePlayer1);
			gamePlayerRepository.save(gamePlayer2);
			gamePlayerRepository.save(gamePlayer3);

			List<String> locations1 = new ArrayList<>();
			locations1.add("H1");
			locations1.add("H2");
			locations1.add("H3");
			locations1.add("H4");

			List<String> locations2 = new ArrayList<>();
			locations2.add("A2");
			locations2.add("A3");
			locations2.add("A4");

			List<String> locations3 = new ArrayList<>();
			locations3.add("C6");
			locations3.add("C7");

			Ship shipType1= new Ship("Destroyer", locations1, gamePlayer1);
			Ship shipType2= new Ship("Battleship", locations3, gamePlayer1);
			Ship shipType3= new Ship("Submarine", locations2, gamePlayer1);
			Ship shipType4= new Ship("Destroyer", locations1, gamePlayer2);
			Ship shipType5= new Ship("PatrolBoat", locations2, gamePlayer2);

			shipRepository.save(shipType1);
			shipRepository.save(shipType2);
			shipRepository.save(shipType3);
			shipRepository.save(shipType4);
			shipRepository.save(shipType5);

		};
	}

}

