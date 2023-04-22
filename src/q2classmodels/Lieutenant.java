/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;

import java.util.HashSet;
import q2classmodels.Exceptions.AlreadyMaximumException;
import q2classmodels.Exceptions.BrokeException;

/**
 *
 * @author MUON
 */
public class Lieutenant extends NPC, Item {
    private boolean cleanse;
    private Ship ship;
    private int[] actionStats ={0,0,0,0,0}; //damage, healing, poison, weakness strength
    public Lieutenant(String name, String dialogue, int damage, int healing, int poison, int weakness, int strength, boolean cleanse, int staminaCost){
        super(name, dialogue, staminaCost);
        actionStats[0] = damage;
        actionStats[1] = healing;
        actionStats[2] = poison;
        actionStats[3] = weakness;
        actionStats[4] = strength;
        this.cleanse = cleanse;
        
    }
    public void setCaptain(Ship captain){
        this.ship = captain;
    }
    public void specialMove(Enemy enemy){
        enemy.setHp(enemy.getHp()-actionStats[0]);
        enemy.setPoison(enemy.getPoison()-actionStats[2]);
        enemy.setWeakness(enemy.getWeakness()-actionStats[3]);
        ship.setHp(ship.getHp()+actionStats[1]);
        if(ship.getHp() == ship.getMaxHp()){
            ship.setHp(ship.getMaxHp());
        }
        if (cleanse){
            ship.setPoison(0);
            ship.setWeakness(0);
            
        }
    }

    
}
