package com.piwnicastudio.uno.player;

import com.piwnicastudio.uno.card.Card;
import com.piwnicastudio.uno.card.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PlayerService {
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;

    public Optional<Player> findPlayerById(Long id) {
        return this.playerRepository.findById(id);
    }

    public void addNewPlayer(Player player) {
        this.playerRepository.save(player);
    }
}
