package com.piwnicastudio.uno.game;

import com.piwnicastudio.uno.card.Card;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private static final String CARDS = "cards";

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/players/cards")
    public List<Card> getPlayerCards(HttpServletRequest request,@PathVariable Long playerId) {
        return gameService.getCardsByPlayerId(playerId);
    }

    @PostMapping("/players/cardCount")
    public ResponseEntity<Integer> getPlayerCardsCount(HttpServletRequest request, @PathVariable Long playeId) {
        return ResponseEntity.ok(this.gameService.getCardsByPlayerId(playeId).size());
    }

    @PostMapping("/players/addCard")
    public ResponseEntity<String> giveCard(HttpServletRequest request, @RequestParam Long playerId) {
        List<Card> playerCards = (List<Card>) request.getAttribute(CARDS);
        if(playerCards == null) {
            playerCards = new ArrayList<>();
        }
        playerCards.add(Card.createRandom());
        request.setAttribute(CARDS, playerCards);
        return ResponseEntity.ok("Card added");
    }

    @PostMapping("/players/clearCards")
    public void clearCards(HttpServletRequest request, @PathVariable Long playerId) {
        request.setAttribute(CARDS, null);
        gameService.clearCardsForPlayer(playerId);
        System.out.println(String.format("CLEAR CARD LIST FOR PLAYER %d FROM IP %s", playerId, request.getRemoteAddr()));
    }
}
