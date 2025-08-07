package com.piwnicastudio.uno.card;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    private String id;
    private int number;
    private boolean isWildCard;
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

    public static Card createRandom() {
        Random random = new Random();
        return Card.builder()
                .id(UUID.randomUUID().toString())
                .number(random.nextInt(1,10))
                .isWildCard(random.nextBoolean())
                .color(COLOR.random())
                .build();
    }
}
