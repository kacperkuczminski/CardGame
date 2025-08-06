package com.piwnicastudio.uno.card.dto;

import com.piwnicastudio.uno.card.Card;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CardDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Card.COLOR color;
    private boolean isWildCard;

    public static CardDTO fromCard(Card card) {
        return new CardDTO(card.getId(), card.getNumber(), card.getColor(), card.isWildCard());
    }

    public Card toCard() {
        Card card = new Card();
        card.setId(this.id);
        card.setNumber(this.number);
        card.setColor(this.color);
        card.setWildCard(this.isWildCard);
        return card;
    }
}
