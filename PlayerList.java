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
public class PlayerList {
    private Player player;
    private ArrayList<Player> playerlist;
    
    public PlayerList() {
        this.playerlist = new ArrayList<Player>();
    }
    public void addPlayer(Player player) {
        this.playerlist.add(player);
    }
    
    public ArrayList<Player> returnPlayerList() {
        return this.playerlist;
    }
    public void printScore(){
        for (Player player: this.playerlist) {
            System.out.println("Player "+player.getName()+": "+player.getMoney());
        }
        
    }
}
    
    

