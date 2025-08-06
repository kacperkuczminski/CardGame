package com.piwnicastudio.uno.card;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


@Getter
@Setter
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private boolean isWildCard;

    @Enumerated(EnumType.STRING)
    private COLOR color;

    public enum COLOR {
        RED, BLUE, GREEN, YELLOW;

        private static final List<COLOR> VALUES = List.of(values());
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static COLOR random() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }
}
