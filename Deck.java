/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author MeoMoc
 */
import java.util.*;
public class Deck {
    private ArrayList<Integer> deck;
    private int n;
    private int lower;
    private Random random;
    private int m;
    
    
    public Deck() {
        this.deck= new ArrayList<Integer>();
        n=1;
        lower=1;
        random = new Random();
       
    }
    public void addToDeck() {                
        this.deck.add(n);
                            
    }
    public void createDeck() {
        
        while (lower<=52) {
            for (int m=1; m<5;m++) {
                addToDeck();
        }
            n++;
            lower+=4;
    }
    }
    public void printDeck() {
        for (int n:this.deck) {
            System.out.print(n);
        }
        System.out.println("");
        
    }
    public ArrayList<Integer> returnedDeck() {
        return this.deck;
    }
    public int drawFromDeck() {
        int x= random.nextInt(this.deck.size());
        int y=this.deck.get(x);
        this.deck.remove(x);
        //System.out.println(this.deck);
        //System.out.println(x);
    return y;
    } 
    
}
