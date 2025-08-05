package com.piwnicastudio.uno.card.dto;

import com.piwnicastudio.uno.card.Card;

public class CardDTO {

    private Long id;
    private String number;
    private Card.COLOR color;
    private boolean isWildCard;

    public CardDTO() {

    }

    public CardDTO(Long id, String number, Card.COLOR color, boolean isWildCard) {
        this.id = id;
        this.number = number;
        this.color = color;
    }

    public static CardDTO fromCard(Card card) {
        return new CardDTO(card.getId(), card.getNumber(), card.getColor(), card.isWildCard());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Card.COLOR getColor() {
        return color;
    }

    public void setColor(Card.COLOR color) {
        this.color = color;
    }

    public boolean getIsWildCard() {
        return isWildCard;
    }

    public void setWildCard(boolean wildCard) {
        isWildCard = wildCard;
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
