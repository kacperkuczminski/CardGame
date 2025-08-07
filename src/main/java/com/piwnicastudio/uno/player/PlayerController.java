package com.piwnicastudio.uno.player;

import com.piwnicastudio.uno.card.Card;
import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("/api/players")
@AllArgsConstructor
public class PlayerController {
    PlayerService playerService;

    @ResponseBody
    @PostMapping("/{playerName}/create")
    public ResponseEntity<Long> createPlayer(
            @PathVariable String playerName) throws IOException {
        Random random = new Random();
        Player player = new Player(playerName);
        for (int i = 0; i < 5; i++) {
            Card card = new Card();
            card.setNumber(random.nextInt(1, 9));
            card.setWildCard(random.nextBoolean());
            card.setColor(Card.COLOR.random());
            player.addCard(card);
        }
        playerService.addNewPlayer(player);
        Cookie  cookie = new Cookie("id",String.valueOf(player.getId()));
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge(60*60*24);
        return ResponseEntity.ok(player.getId());
    }
}
