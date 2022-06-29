package Library;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        String cardValue = "" + this.value;
        switch (this.value) {
            case 11:
                cardValue = "J";
                break;
            case 12:
                cardValue = "Q";
                break;
            case 13:
                cardValue = "K";
                break;
            case 14:
                cardValue = "A";
                break;
            default:
                break;
        }
        return this.suit + " " + cardValue;
    }

    public int getValue() {
        return this.value;
    }

    public Suit getSuit() {
        return this.suit;
    }
    
    @Override
    public int compareTo(Card card){
        if(!(this.value == card.getValue())){
            return this.value - card.getValue();
        }else{
            return this.getSuit().ordinal() - card.getSuit().ordinal();
        }
    }
    
    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }else if(!(object instanceof Card)){
            return false;
        }else{
            Card compared = (Card) object;
            return this.value == compared.getValue() && this.suit == compared.getSuit();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.value;
        hash = 43 * hash + Objects.hashCode(this.suit);
        return hash;
    }

}
