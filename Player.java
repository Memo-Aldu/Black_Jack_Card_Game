import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private ArrayList<Card> hand; // The cards in the plyaer's hand.
    /*Constructor of the player creating a hand*/
    Player(){
        hand = new ArrayList<Card>();
    }
    /*Accessor for hand of player*/
    public ArrayList<Card> getHand() {
        sortByColor();
        return (hand);
    }
    /*** Remove all cards from the hand, leaving it empty. */
    public void clear() {
        //called the function clear from java array list
        this.hand.clear();
    }
    /*** Add a card to the hand. It is added at the end of the current hand.
     * @param card the non-null card to be added.
     * @throws NullPointerException if the parameter card is null.
     */

    public void add(Card card) {
        //try catch for the exeption "NullPointerException"
        try {
            //called function add from java array list
            this.hand.add(card);
        }
        catch(NullPointerException n){
            //catch prints simplified error
            System.out.println("Card is null");
        }
    }
    /** * Remove a card from the hand, if present.
     * @param card the card to be removed. If card is null or if the card is not in
     * the hand, then nothing is done.
     */
    public void remove(Card card) {
        // try catch for if card is null or card is not in the hand
        try{
            remove(card);
        }
        catch(Exception e){
            System.out.println("Card is null or is not in the deck.");
        }

    }
    /*** Remove the card in a specified position from the hand.
     * @param position the position of the card that is to be removed, where
     * positions are numbered starting from zero.
     * @throws IllegalArgumentException if the position does not exist in
     * the hand, that is if the position is less than 0 or greater than
     * or equal to the number of cards in the hand.
     */
    public void remove(int position) {
        //try catch for IllegalArgumentException.
        try{
            this.hand.remove(position);
        }
        catch(IllegalArgumentException m )
        {
            System.out.println("The position doesnt exist in the list of hand.");
        }
    }
    // Returns the number of cards in the hand.
    public int totalCards() {
        return this.hand.size();
    }
    /*** Gets the card in a specified position in the hand. (Note that this card
     * is not removed from the hand!)
     * @param position the position of the card that is to be returned
     * @throws IllegalArgumentException if position does not exist in the hand
     */
    public Card getCard(int position) {
        // creat a temp card IllegalArgumentException.
        Card i = new Card(0,0);
        // try catch for 
        try{
            i = hand.get(position);

        }
        catch(IllegalArgumentException a)
        {
            System.out.println("The position does not exist in the hand.");

        }

        return i;

    }
    /** * Computes and returns the total value of this hand in the game */
    public int getHandTotal () {
        // Ace found.
        boolean ace = false;
        //sonme of cards in the hand
        int sum = 0;
        //Browsing the list
        for(int i = 0; i < totalCards(); i++)
        {
            //getting the value of the card in the hand
            int val =getCard(i).getValue();
            if(val > 10){
                val = 10;
            }
            //checking for ace
            if (val == 1 && sum < 11 ){
                ace = true;
            }
            //adding the value to the somme.
            sum += val;
            //checking if ace should be 11 or 1
            if(sum <= 11 && ace){
                sum += 10;
    
            }
            //marking ace off
            if(sum > 21 && ace){
                sum -= 10;
                ace = false;
    
            }
        }
        return sum;
    }



    /** * Sorts the cards in the hand so that cards of the same color are
     * grouped together, and within a color the cards are sorted by value.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByColor() {
        //Brawos the list of cards in the hand.
        for (int i= 0; i < totalCards()-1; i++ )
        {
            // loop to comapre 22 diffrent cards in the list.
            for(int j = i+1; j > 0; j--)
            {
                //comparing value of colors.
                if (getCard(j).getColor() < getCard(j-1).getColor())
                {
                    //Swapping the the postion of the cards if the condition is true
                    Collections.swap(hand,j , j-1);
                }
                // if cards have the same color
                else if ((getCard(j).getColor() == getCard(j-1).getColor()))
                {
                    //them sort the cards by value.
                    if(getCard(j).getValue() < getCard(j-1).getValue())
                    {
                        //swaping the cards.
                        Collections.swap(hand,j , j-1);

                    }

                }
                else{
                    break;
                }

            }
        }
    }
    /*** Sorts the cards in the hand so that cards of the same value are
     * grouped together. Cards with the same value are sorted by color.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByValue() {
        //browsing the list of cards in the hand.
        for (int i= 0; i < totalCards()-1; i++ )
        {
            for(int j = i+1; j > 0; j--)
            {
                //comparing the values of the cards.
                if (getCard(j).getValue() < getCard(j-1).getValue())
                {
                    //Swaping the cards if the condition is true.
                    Collections.swap(hand,j , j-1);
                }
                // if the cards have the same value then sort them by color
                else if (getCard(j).getValue() == getCard(j-1).getValue())
                {
                    if((getCard(j).getColor() < getCard(j-1).getColor()))
                    {
                        Collections.swap(hand,j , j-1);

                    }

                }
                else{
                    break;
                }

            }
        }
    }
    // end class Player
    // Test sort algorithms.
/*public static void main(String[] args) {
     Player a= new Player();
     Card c = new Card(2, 0);
     Card c4 = new Card(10,3);
     Card c1 = new Card(3,0);
     Card c2 = new Card(2,1);
     Card c3 = new Card(10,2);
     Card c5 = new Card(16,5);

    a.add(c);
    a.add(c4);
    a.add(c1);
    a.add(c2);
    a.add(c3);
    a.add(c5);
    int j = a.totalCards();
    for(int i =0; i < j;i++)
    {
     System.out.println(a.getCard(i));

    }
    System.out.println();
    System.out.println("Sort by Color");
    a.sortByColor();
    for(int i =0; i < j;i++)
    {
     System.out.println(a.getCard(i).toString());

    }
    System.out.println();
    System.out.println("Sort by value");
    a.sortByValue();
    for(int i =0; i < j;i++)
    {
     System.out.println(a.getCard(i).toString());

    }


 }*/

}
