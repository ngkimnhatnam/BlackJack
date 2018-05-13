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
public class HostHand {
    private ArrayList<Integer> realhand;
    private ArrayList<Integer> demohand;
    private Random random;
    private int drawn;
    private Deck deck;
    private String hostcards;
    
    
    public HostHand() {
        random= new Random();
        realhand= new ArrayList<Integer>();
        demohand= new ArrayList<Integer>();
        this.drawn=0;
        hostcards="";
        
        
    }
    
    public void dealFirstHand(Deck deck) {
        int n=deck.drawFromDeck();
        this.realhand.add(n);
        this.demohand.add(n);
        int m=deck.drawFromDeck();
        this.realhand.add(m);
        this.demohand.add(m);
        
        
    }
    public void dealOne(Deck deck) {
        System.out.println("");
        System.out.println("Host is calling 1 card:");
        System.out.println("");
        int n=deck.drawFromDeck();
        this.realhand.add(n);
        this.demohand.add(n);
        this.drawn++;
    }
    public int cardsDrawn() {
        return this.drawn;
    }
    public String showHand() {
        
        for (int x: this.demohand) {
            if (x==1) {
                hostcards+=" A";
                
            }
            else if (x==11) {
                hostcards+=" J";
                
            }
            else if (x==12) {
                hostcards+=" Q";
                
            }
            else if (x==13) {
                hostcards+=" K";
                
            }
            else {
                hostcards+=" "+x;
                
            }        
    }
        return hostcards;
    }
    
    public void getHostCards() {
        System.out.println("Your host hand is ");
        System.out.println(showHand());
    }
    
    public void emptyHostCards() {
        this.hostcards="";
    }
    
    public void equalizer(ArrayList<Integer> hand) {
        for (int n: hand) {
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
    public int sumHost() {
        int x=0;
        for (int n:this.realhand) {
            x+=n;            
        }
        return x;
    }
    public ArrayList<Integer> returnHostHand() {
        return this.realhand;
    }
    public void initialHand(Deck deck) {
        dealFirstHand(deck);
        getHostCards();
        System.out.println(" ");
        
    }
    public boolean hostWin() {
        return true;
    }
    
    
    
    
}
