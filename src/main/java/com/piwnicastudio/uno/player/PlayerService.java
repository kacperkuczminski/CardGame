package com.piwnicastudio.uno.player;

import com.piwnicastudio.uno.common.request.Request;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    public Optional<Player> findPlayerById(Long id) {
        return this.playerRepository.findById(id);
    }

    public void addNewPlayer(Player player) {
        this.playerRepository.save(player);
    }

    public void removePlayer(Player player) {
        this.playerRepository.delete(player);
    }

    public Optional<Player> getPlayerByName(String playerName) {
        return this.playerRepository.findPlayerByName(playerName);
    }


}
