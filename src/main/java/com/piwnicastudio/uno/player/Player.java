package com.piwnicastudio.uno.player;

import com.piwnicastudio.uno.card.Card;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private List<Card> cards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
