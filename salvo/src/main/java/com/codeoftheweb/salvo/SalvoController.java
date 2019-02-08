package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoController {

        @Autowired
        private GameRepository gameRepository;

        @RequestMapping("/games")
        public List<Map<String, Object>> getGames() {
                { return gameRepository
                        .findAll()
                        .stream()
                        .map(game -> makeGameDTO(game))
                        .collect(Collectors.toList());
                }
        }

        private Map<String, Object> makeGameDTO(Game game) {
                Map<String, Object> dto = new LinkedHashMap<>();
                dto.put("id", game.getId());
                dto.put("creationDate", game.getCreationDate());
                dto.put("gamePlayers", getGamePlayerList(game.getGamePlayers()));
                return dto;
        }

        private List<Map<String, Object>> getGamePlayerList(Set<GamePlayer> gamePlayers) {
                { return gamePlayers
                        .stream()
                        .map(gamePlayer -> makeGamePlayerDTO(gamePlayer))
                        .collect(Collectors.toList());
                }
        }

        private Map<String, Object> makeGamePlayerDTO(GamePlayer gamePlayer) {
                Map<String, Object> dto = new LinkedHashMap<>();
                dto.put("id", gamePlayer.getId());
                dto.put("joinDate", gamePlayer.getJoinDate().getTime());
                dto.put("player", makePlayerDTO(gamePlayer.getPlayers()));
                return dto;
        }

        private Map<String, Object> makePlayerDTO(Player player) {
                Map<String, Object> dto = new LinkedHashMap<>();
                dto.put("id", player.getId());
                dto.put("userName", player.getUserName());
                return dto;
        }


}
