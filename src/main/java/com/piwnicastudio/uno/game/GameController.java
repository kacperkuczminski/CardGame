package com.piwnicastudio.uno.game;

import com.piwnicastudio.uno.card.Card;
import jakarta.security.auth.message.callback.SecretKeyCallback;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/players/{playerId}/cards")
    public List<Card> getPlayerCards(@PathVariable Long playerId) {
        return gameService.getCardsByPlayerId(playerId);
    }

    @PostMapping("/players/{playeId}/cardCount")
    public int getPlayerCardsCount(@PathVariable Long playeId) {
        return gameService.getCardsByPlayerId(playeId).size();
    }

    @PostMapping("/players/{playerId}/addCard")
    public void giveCard(@PathVariable Long playerId) {
        gameService.giveCardToPlayer(playerId, Card.createRandom());
    }

    @PostMapping("/players/{playerId}/clearCards")
    public void clearCards(HttpServletRequest request, @PathVariable Long playerId) {
        System.out.println(String.format("CLEAR CARD LIST FOR PLAYER %d FROM IP %s", playerId, request.getRemoteAddr()));
        gameService.clearCardsForPlayer(playerId);
    }
}
