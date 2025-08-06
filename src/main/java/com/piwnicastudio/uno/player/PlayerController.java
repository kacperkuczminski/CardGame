package com.piwnicastudio.uno.player;

import com.piwnicastudio.uno.card.CardService;
import com.piwnicastudio.uno.configuration.CacheConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/players")
@AllArgsConstructor
public class PlayerController {
    PlayerService playerService;
    CardService cardService;

    @PostMapping("/{playerName}/create")
    public void createPlayer(@PathVariable String playerName) {
        Player player = new Player(playerName);
        //todo: add some random generating cards for player
        playerService.addNewPlayer(player);
    }
}
