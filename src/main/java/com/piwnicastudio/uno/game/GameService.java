package com.piwnicastudio.uno.game;

import com.piwnicastudio.uno.card.Card;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {
    private final Map<Long, List<Card>> playerCards = new HashMap<>();

    public void giveCardToPlayer(Long playerId, Card card) {
        playerCards.computeIfAbsent(playerId, k -> new ArrayList<>()).add(card);
    }

    public List<Card> getCardsByPlayerId(Long playerId) {
        return playerCards.getOrDefault(playerId, Collections.emptyList());
    }

    public void removeCardFromPlayer(Long playerId, Card card) {
        List<Card> cards = playerCards.get(playerId);
        if (cards != null) {
            cards.remove(card);
        }
    }

    public void clearCardsForPlayer(Long playerId) {
        playerCards.remove(playerId);
    }
}
