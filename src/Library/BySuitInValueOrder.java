package Library;

import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card>{
    @Override
    public int compare(Card cardOne, Card cardTwo){
        if(!(cardOne.getSuit() == cardTwo.getSuit())){
            return cardOne.getSuit().ordinal() - cardTwo.getSuit().ordinal();
        }else{
            return cardOne.getValue() - cardTwo.getValue();
        }
    }
}
