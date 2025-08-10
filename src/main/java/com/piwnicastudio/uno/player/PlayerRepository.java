package com.piwnicastudio.uno.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    public Optional<Player> findPlayerById(Long id);
    public Optional<Player> findPlayerByName(String name);
}
