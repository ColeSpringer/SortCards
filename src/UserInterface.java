import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class UserInterface {

    private Hand hand;
    private Scanner scanner;

    public UserInterface(Scanner scanner, Hand hand){

        this.scanner = scanner;
        this.hand = hand;
    }

    public void start(){

        System.out.println("Would you like to manually input cards or sort a random selection? (Enter 'manually' or 'random'):");
        String manOrRan;
        while(true){
            manOrRan = this.scanner.nextLine().toLowerCase();
            if(!(manOrRan.equals("manually")) && !(manOrRan.equals("random"))){
                System.out.println("Please enter 'manually' or 'random'");
            }else{
                break;
            }
        }
        switch(manOrRan){
            case "manually":
                System.out.println("Cards range in value from 2-14 and have suits of Club, Diamond, Heart, or Spade.");
                while(true){
                    System.out.println("Enter card or press enter to end (Type value,suit, i.e. 7,Spade)");
                    String input = this.scanner.nextLine();
                    if(input.equals("")){
                        break;
                    }
                    String[] valueSuit = input.split(",");
                    int value = Integer.valueOf(valueSuit[0]);
                    Suit suit = determineSuit(valueSuit[1]);
                    if(value < 2 || value > 14 || suit == null){
                        System.out.println("Please try again. Needs to be entered in the format of value,suit");
                    }else{
                        Card card = new Card(value, suit);
                        if(this.hand.getHand().contains(card)){
                            System.out.println("Enter new card. Card can not one you have already entered.");
                        }else{
                            hand.add(card);
                        }
                    }
                }
                break;
            case "random":
                System.out.println("Enter the number of cards you would like to sort in range 1-52:");
                int numCards;
                while(true){
                    numCards = Integer.valueOf(this.scanner.nextLine());
                    if(numCards < 1 || numCards > 52){
                        System.out.println("Please enter a positive integer in range 1-52");
                    }else{
                        break;
                    }
                }
                pickRandomCards(numCards);
        }

        System.out.println("Would you like to sort by value or by suit?");
        String sortBy;
        while(true){
            sortBy = scanner.nextLine().toLowerCase();
            if(!(sortBy.equals("value")) && !(sortBy.equals("suit"))){
                System.out.println("Type 'value' or 'suit'");
            }else{
                break;
            }
        }
        System.out.println("Here are the original cards:");
        this.hand.print();
        System.out.println("Here are the cards ordered by " + sortBy);
        switch(sortBy){
            case "value":
                this.hand.sort();
                break;
            case "suit":
                this.hand.sortBySuit();
                break;
        }
        this.hand.print();
    }

    public Suit determineSuit(String string){
        Suit suit;
        switch(string){
            case "spade":
                suit = Suit.SPADE;
                break;
            case "heart":
                suit = Suit.HEART;
                break;
            case "diamond":
                suit = Suit.DIAMOND;
                break;
            case "club":
                suit = Suit.CLUB;
                break;
            default:
                suit = null;
        }
        return suit;
    }

    public void pickRandomCards(int numCards){
        ArrayList<Integer> cardArray = new ArrayList<>();
        for(int i = 0; i < 52; i++){
            cardArray.add(i+1);
        }
        Collections.shuffle(cardArray);

        int value;
        Suit suit;
        for(int x = 0; x < numCards; x++){
            int randomCard = cardArray.get(x);
            value = randomCard % 13 + 2;
            if(randomCard <= 13){
                suit = Suit.CLUB;
            }else if(randomCard <= 26){
                suit = Suit.DIAMOND;
            }else if(randomCard <= 39){
                suit = Suit.HEART;
            }else{
                suit = Suit.SPADE;
            }
            this.hand.add(new Card(value, suit));
        }
    }
}
