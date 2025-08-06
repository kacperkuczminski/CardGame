package com.piwnicastudio.uno.card;

import com.piwnicastudio.uno.player.Player;
import com.piwnicastudio.uno.player.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/cards")
@AllArgsConstructor
public class CardController {

    CardService cardService;
    PlayerService playerService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @PostMapping("/{playerId}/getCard")
    public void takeNewCard(
            @PathVariable Long playerId) {
        Optional<Player> p = playerService.findPlayerById(playerId);
        p.ifPresent(player -> {
            Card card = new Card();
            Random random = new Random();
            card.setNumber(random.nextInt(1, 9));
            card.setWildCard(random.nextBoolean());
            card.setColor(Card.COLOR.random());
            player.addCard(card);
        });
    }
}
