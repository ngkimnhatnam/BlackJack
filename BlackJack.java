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
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        PlayerList list = new PlayerList();
        Play play = new Play();  
        
       
        play.gameMenu();
        String input=reader.nextLine();
        int m=0;
        int n=0;
        int o=0;
        while (true) {
            if (input.equals("p")) {
                
                String nimi=play.askName();
                if (list.returnPlayerList().isEmpty()) {//Create 1st player in the list
                        Player player= new Player(reader.nextLine());
                        player.addName(nimi);
                        list.addPlayer(player);
                        m=list.returnPlayerList().indexOf(player);                                      
                        play.startGame(player);
                        play.playAgain(list.returnPlayerList().get(m));
                        }   
                else if (list.returnPlayerList().isEmpty()==false) {//List with at least 1 registered player
                    for (int i=0;i<list.returnPlayerList().size();i++) {
                        Player playerinsearch = list.returnPlayerList().get(i);
                        if (nimi.equals(playerinsearch.getName())) {//Player which already exists
                            n= list.returnPlayerList().indexOf(playerinsearch);
                            play.startGame(list.returnPlayerList().get(n));
                            play.playAgain(list.returnPlayerList().get(n));
                        }
                        else if (!nimi.equals(playerinsearch.getName())) {//Non-existing player will be created
                        Player anotherplayer= new Player(nimi);
                        list.addPlayer(anotherplayer);
                        o=list.returnPlayerList().indexOf(anotherplayer);
                        System.out.println("");
                        list.printScore();
                        play.startGame(list.returnPlayerList().get(o));  
                        }
                        
                    }
                }
                
            }
            if (input.equals("r")) {//Print rules
                play.gameRules();
                System.out.println("");
                System.out.println("Back to menu?(y/n)");
                input= reader.nextLine();
                if (input.equals("y")) {
                    play.gameMenu();
                    input=reader.nextLine();
                    continue;
                }
                if (input.equals("n")) {
                    break;
                }
            }
            if (input.equals("s")) {
                list.printScore();
            }
            if (input.equals("q")) {
                break; 
            }   
        }
        System.out.println("Thanks for playing!"); 
    }
}


