import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand>{
    private ArrayList<Card> hand;
    
    public Hand(){
        this.hand = new ArrayList<>();
    }
    
    public ArrayList<Card> getHand(){
        return this.hand;
    }
    
    public void add(Card card){
        this.hand.add(card);
    }
    
    public void print(){
        for(Card card: this.hand){
            System.out.println(card);
        }
    }
    
    public void sort(){
        Collections.sort(this.hand);
    }
    
    public void sortBySuit(){
        Collections.sort(this.hand, new BySuitInValueOrder());
    }
    
    @Override
    public int compareTo(Hand hand){
        int thisValue = this.hand.stream()
                .map(card -> card.getValue())
                .reduce(0, (prevValue, value) -> prevValue + value);
        int handValue = hand.getHand().stream()
                .map(card -> card.getValue())
                .reduce(0, (prevValue, value) -> prevValue + value);
        return thisValue - handValue;
    }
}
