import javax.xml.stream.util.XMLEventAllocator;
import java.util.*;

public class Deck {

    int size;
    List<String> deck = new ArrayList<String>();

    public Deck(){
        for(Value val : Value.values()) {
            for(Suit suit : Suit.values()) {
                deck.add(val.getV_str() + suit.getS_str());
            }
        }
        this.size = 52;
        this.shuffle();
    }

    public void shuffle() {
        List<String> sub = new ArrayList<String>();
        for(int i = 0; i < this.size; i++) {
            sub.add(deck.remove(0));
        }

        int index;
        for(int i = this.size; i > 0; i--) {
            index = (int) (Math.random() * i);
            deck.add(sub.remove((index)));
        }

    }

    public String draw() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return "";
        }
        else {
            this.size--;
            return deck.remove(this.size);
        }
    }



}
