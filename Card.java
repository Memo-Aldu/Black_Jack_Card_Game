public class Card {
    private int value;
    private int color;

    //constructeur de carte
    public Card(int value, int color){
        if(value > 13 && value < 1){
            System.out.println("Value of card isn't in the expected range");
        }
        else {
            this.color = color;
            this.value = value;
        }

    }


    //return value of the card
    public int getValue(){
        return value;
    }


    //return the color of the card
    public int getColor(){
        return color;
    }


    //return a string of the value of the card
    public String ValueToString(){
        String str = String.valueOf(value);
        if(value == 1){
            str = "Ass";
        }
        if(value == 11){
            str = "Jack";
        }
        if(value == 12){
            str = "Queen";
        }
        if(value == 13){
            str = "King";
        }
        return str;
    }

    //return a string of the color of the card
    public String ColorToString(){
        if(color == 0) {
            return " of CLUBS";
        }
        else if(color == 1) {
            return " of DIAMONDS";
        }
        else if(color == 2) {
            return " of HEARTS";
        }
        else if(color == 3) {
            return " of SPADES";
        }
        else{
            return " error this isn't a card";
        }
    }
    public String toString(){
        return ValueToString() + ColorToString();
    }




}
