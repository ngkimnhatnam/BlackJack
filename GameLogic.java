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
public class GameLogic {
    private HostHand host;
    private PlayerHand playhand;
    private Player player;
    
    public GameLogic(HostHand host, PlayerHand playhand) {
        this.host= new HostHand();
        this.playhand= new PlayerHand();
        
    }
    public boolean compareHands(int host, int player) {
              
        if (host<player&&player<22||host>=22&&player<22) {
            return false;
        }            
        if (host>=player&&host<22||player>22&&host<22) {
            return true;
        }
        return true;
    }
    public boolean isHostSmaller(int host, int player) {
        if (host>=player) {
            return false;
        }
        return true;
    }
    public boolean isHostBigger(int host, int player) {
        if (host<player) {
            return false;
        }
        return true;
    }
    
    public void results(boolean compared) {
        if (compared==true) {
            System.out.println("You lost!");
        }
        else if (compared==false) {
            System.out.println("You won!");
        }
    }
    
}
