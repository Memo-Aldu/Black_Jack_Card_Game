import java.util.ArrayList;
import java.util.Collections;


public class Deck{
    private ArrayList<Integer> NbCards = new ArrayList<Integer>();
    private Card[] deckCard= new Card[52];
    private int number = 0;


    //constructeur de deck
    public Deck(){
        ResetDeck();
    }


    //creates a new deck of 52 card
    private void  ResetDeck(){
        for(int i = 0; i<52; i++){      //creates a the card of clubs and then the cards of diamond and so on
            if(i<13){
                deckCard[i] = new Card(i+1,0);
            }
            if(i>12 && i <26){
                deckCard[i] = new Card(i-12,1);

            }
            if(i>25 && i <39){
                deckCard[i] = new Card(i-25,2);

            }
            if(i>38){
                deckCard[i] = new Card(i-38,3);

            }
        }
        number = 0;
    }
    //shuffles the deck of card
    public void shuffle(){
        Card[] deckCard2= new Card[52];     //create a list with the number 0 to 51 and the shuffle the list
        for(int i =0; i<52; i++){
            NbCards.add(i);
        }
        Collections.shuffle(NbCards);
        ResetDeck();
        for(int i =0; i<52; i++){           //create a new deck of card with the card of the first deck in the position of the shuffle list
            deckCard2[NbCards.get(i)] = deckCard[i];

        }
        deckCard = deckCard2;


    }
        //return the number of card left in the deck
    public int numberLeft(){
        return 52-number;
    }


    //return the top card of the deck and then delete it from the deck
    public Card take(){
        try {
            System.out.println("number of cards left in deck = " + numberLeft());
            Card TopCard = deckCard[number];
            deckCard[number] = null;
            number++;
            return TopCard;
        }
        catch(IllegalStateException n){     //au cas qu'il a pu de carte dans le deck
            System.out.println("deck is empty");
        }

        return null;
    }
}
