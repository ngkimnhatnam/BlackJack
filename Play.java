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
public class Play {
    private Scanner reader;
    private Player player;
    private HostHand hosthand;
    private PlayerHand playhand;
    private GameLogic logic;
    private Deck deck;
    private String input;
    private int bet;
    
    
public Play() {
        //this.player= new Player();
    this.reader= new Scanner(System.in);
    this.bet=0;
        
}
public void gameMenu() {
    System.out.println("Welcome to the game!");
    System.out.println("------------");
    System.out.println("Play(P)");
    System.out.println("Scoreboard(S)");
    System.out.println("Game rules(R)");
    System.out.println("Quit(Q)");
    System.out.println("************");
    System.out.println("Your selection: ");
        
}
public void gameRules() {
    System.out.println("Game Rules:");
    System.out.println("Both the player and the host are dealt 2 cards in the beginning.");
    System.out.println("All the Jacks, Queens and Kings have the same numerical value of 10.");     
    System.out.println("The aim is to have higher score than your host. However, maximum score can only be under 22.");
    System.out.println("When either player exceeds that limit, the round ends automatically and the player with exceeding score loses.");
    System.out.println("The player can each turn decide to stay (not drawing 1 more card this turn) or call (draw 1 more card).");
    System.out.println("Maximum cards can be drawn is 3.");
    System.out.println("When the player's hand has 5 cards, he cannot draw anymore.");
    System.out.println("If neither player draws new cards, their score calculation begins and it determines the winner.");
}
    
public void startGame(Player player ) {
    Deck deck = new Deck();
    deck.createDeck();  
    HostHand hosthand= new HostHand();
    PlayerHand playhand= new PlayerHand();
    GameLogic logic = new GameLogic(hosthand,playhand);              
                
    System.out.println("Welcome "+player.getName()+ " to this BlackJack game!");
    System.out.println("Your current account balance is: "+player.getMoney());
    System.out.println("How much do you want to bet?");
    bet=Integer.parseInt(reader.nextLine());
        hosthand.initialHand(deck);
        playhand.initialHand(deck);                
        hosthand.equalizer(hosthand.returnHostHand());
        playhand.equalizer(playhand.returnPlayerHand());
                
        if (hosthand.showHand().contains("A")&&hosthand.showHand().contains("J")||hosthand.showHand().contains("A")&&hosthand.showHand().contains("K")||hosthand.showHand().contains("A")&&hosthand.showHand().contains("10")||hosthand.showHand().contains("A")&&hosthand.showHand().contains("Q")) { 
            System.out.println("You lost!");                                                        
        }
        else if (playhand.showHand().contains("A")&&playhand.showHand().contains("J")||playhand.showHand().contains("A")&&playhand.showHand().contains("Q")||playhand.showHand().contains("A")&&playhand.showHand().contains("K")||playhand.showHand().contains("A")&&playhand.showHand().contains("10")) {
            System.out.println("You win");
        }
        else {
            System.out.println("Do you call(C) or stay(S)?");
                while (hosthand.sumHost()<=21&&playhand.sumPlayer()<=21) {                        
                    String input= reader.nextLine();
                    if (input.equals("s")) {
                        if (logic.isHostSmaller(hosthand.sumHost(), playhand.sumPlayer())&&hosthand.cardsDrawn()<3) {
                            hosthand.dealOne(deck);
                            hosthand.equalizer(hosthand.returnHostHand());
                            hosthand.emptyHostCards();
                            hosthand.getHostCards();
                            System.out.println("");
                            playhand.emptyPlayerCards();
                            playhand.getPlayerCards();
                        }
                        else {                            
                            break;
                        }
                    }
                    else if (input.equals("c")) {
                        if (playhand.cardsDrawn()<3&&playhand.sumPlayer()<22) {
                            playhand.dealOne(deck); 
                            playhand.equalizer(playhand.returnPlayerHand());
                            hosthand.emptyHostCards();
                            hosthand.getHostCards();
                            System.out.println("");
                            playhand.emptyPlayerCards();
                            playhand.getPlayerCards();
                        }
                        else {
                            break;                            
                        }                                                                        
                    }
                    System.out.println("");    
                    System.out.println("Do you call(C) or stay(S)?");
                }
                         
            System.out.println("");    
            System.out.println("The result is: ");
            hosthand.equalizer(hosthand.returnHostHand());
            playhand.equalizer(playhand.returnPlayerHand());
            logic.results(logic.compareHands(hosthand.sumHost(), playhand.sumPlayer()));
            
            if (logic.compareHands(hosthand.sumHost(), playhand.sumPlayer())) {
                if (bet<=player.getMoney()) {
                    player.decreaseMoney(bet);
                    playAgain(player);
                }
                else {
                    System.out.println("You are wiped out miserably!");
                    System.out.println("Play again?(y/n)");
                    input=reader.nextLine();
                    if (input.equals("y")){
                        String newname=askName();
                        Player newplayer= new Player(newname);
                        startGame(newplayer);
                    }
                    else if (input.equals("n")) {
                        System.out.println("Thanks for playing!");
                        System.exit(1);
                    }
                }                
            }
            else {
                player.increaseMoney(bet);
                playAgain(player);
            }
                }
        
}
          

public void playAgain(Player player) {
        System.out.println("Play again?(y/n)");
            
            input=reader.nextLine();
            if (input.equals("y")) { 
                startGame(player);
            }
            if (input.equals("n")) {
                //gameMenu();
                System.out.println("Thanks for playing!");
                System.exit(1);
                //input=reader.nextLine();                
            }
    }
public String askName() {
    System.out.println("What's your name?");
    String nimi=reader.nextLine(); 
    return nimi;
}
    
}
