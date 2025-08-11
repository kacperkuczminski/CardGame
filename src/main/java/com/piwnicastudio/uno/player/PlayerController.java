package com.piwnicastudio.uno.player;

import com.piwnicastudio.uno.card.Card;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

// Without 'RestController' this annotation Swagger don't show all endpoints
@RestController
@Controller
@RequestMapping("/api/players")
@AllArgsConstructor
public class PlayerController {
    PlayerService playerService;

    @ResponseBody
    @PostMapping("/registerPlayer")
    public ResponseEntity<String> createPlayer(
            HttpServletRequest request,
            @RequestParam String playerName) throws IOException {
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
        HttpSession session = request.getSession(true);
        session.setAttribute("player", player);
        return ResponseEntity.ok("Player created");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginPlayer(HttpServletRequest request, @RequestParam String playerName) throws IOException {
        if(request.getAttribute("player") != null) {
            return ResponseEntity.ok("Player logged in");
        }
        Optional<Player> player = playerService.getPlayerByName(playerName);
        if(player.isPresent())
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("player",player);
            return ResponseEntity.ok("Player logged in");
        }
        return ResponseEntity.ok("Player not logged in");
    }

    @GetMapping("/getPlayer")
    public Optional<Player> getPlayerFromCookie(@CookieValue("JSESSIONID") String sessionId,
                                                HttpServletRequest request) {
        // ID sesji z cookie
        System.out.println("Session ID: " + sessionId);
        HttpSession session = request.getSession(false); // false = nie twórz nowej
        if (session == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Session not exists");
        }

        Optional<Player> player = ((Optional<Player>)session.getAttribute("player"));
        if (player.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Player data not found!");
        }
        System.out.println("Player: " + player.get().getName());
        return player;
    }

}
