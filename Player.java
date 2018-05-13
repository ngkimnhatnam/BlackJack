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
public class Player {
    private String name;
    private int money;
    
    public Player(String name) {
        this.name=name;
        this.money=1000;
    }
    public void addName(String name) {
        this.name= name;
    }
    public int getMoney() {
        return this.money;
    }
    public void increaseMoney(int money) {
        this.money+=money;
    }
    public void decreaseMoney(int money) {
        this.money-=money;
             
    }
    
    
    
    
    
    
    
    
    
    public String getName() {
        return this.name;
    }
    
}
