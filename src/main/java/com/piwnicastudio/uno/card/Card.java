package com.piwnicastudio.uno.card;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private boolean isWildCard;

    @Enumerated(EnumType.STRING)
    private COLOR color;

    public enum COLOR {
        RED, BLUE, GREEN, YELLOW
    }
}
