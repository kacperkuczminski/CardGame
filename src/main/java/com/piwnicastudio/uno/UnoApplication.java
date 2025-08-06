package com.piwnicastudio.uno;

import com.piwnicastudio.uno.player.Player;
import jakarta.persistence.Id;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UnoApplication {

    public static List<Player> playerList;
    
	public static void main(String[] args) {
		SpringApplication.run(UnoApplication.class, args);
	}

}
