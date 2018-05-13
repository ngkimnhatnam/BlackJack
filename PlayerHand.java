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
public class PlayerHand {
    private ArrayList<Integer> realhand;
    private ArrayList<Integer> demohand;
    private Random random;
    private int drawn;
    private Deck deck;
    private String playercards;
    
    public PlayerHand() {
        random= new Random();
        this.realhand = new ArrayList<Integer>();
        this.demohand= new ArrayList<Integer>();
        this.drawn=0;
        this.playercards="";
    }
    
    public void dealFirstHand(Deck deck) {
        int n=deck.drawFromDeck();
        this.realhand.add(n);
        this.demohand.add(n);
        int m=deck.drawFromDeck();
        this.realhand.add(m);
        this.demohand.add(m);
        
        
    }
    public String showHand() {
        
        for (int x: this.demohand) {
            if (x==1) {
                playercards+=" A";
            }
            else if (x==11) {
                playercards+=" J";
            }
            else if (x==12) {
                playercards+=" Q";
            }
            else if (x==13) {
                playercards+=" K";
            }
            else {
                playercards+=" "+x;
            }        
    }
        return playercards;
    }
    public void getPlayerCards() {
        System.out.println("Your hand is:");
        System.out.println(showHand());
    }
    public void emptyPlayerCards() {
        this.playercards="";
    }
    public void equalizer(ArrayList<Integer> hand) {
        for (int n:hand) {
            if (n==11) {
                hand.set(hand.indexOf(n),10);
            }
            else if (n==12) {
                hand.set(hand.indexOf(n),10);
            }
            else if (n==13) {
                hand.set(hand.indexOf(n),10);
            }
        }
    }
    public int sumPlayer() {
        int x=0;
        for (int m:this.realhand) {
            x+=m;
        }
        return x;
    }
    public void dealOne(Deck deck) {
        System.out.println("");
        System.out.println("You are drawing a new card:");
        System.out.println("");
        int n= deck.drawFromDeck();
        this.realhand.add(n);
        this.demohand.add(n);
        this.drawn++;
    }
    public int cardsDrawn() {
        return this.drawn;
    }
    public void initialHand(Deck deck) {
        dealFirstHand(deck);
        getPlayerCards();
        System.out.println("");
        
    }
    
    public boolean playerWin() {
        return true;
    }
    
    
    public ArrayList<Integer> returnPlayerHand() {
        return this.realhand;
    }
}
