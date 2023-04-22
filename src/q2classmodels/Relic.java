/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;

import q2classmodels.Exceptions.*;

/**
 *
 * @author MUON
 */
public class Relic extends Item {
    private int[] buffs = {0,0,0,0,0,0};//poison, healing, power, weakness, hp%, hull%
    private boolean activated = false;
    public Relic (String name, int price, int worth, int staminaCost, Ship player){
        super(name, "relic", price, worth, staminaCost, player);
        int buffPoints = player.getInfluence()+2;
        this.staminaCost = staminaCost;
        System.out.println(buffPoints);
        while (buffPoints>0){        
            buffs[(int)Math.floor(Math.random()*(6))]++;
            buffPoints--;
            System.out.println(buffPoints);
        }
        System.out.println("poison "+buffs[0]);
        System.out.println("leech "+buffs[1]);
        System.out.println("power "+buffs[2]);
        System.out.println("weakness "+buffs[3]);
        System.out.println("hp% "+buffs[4]); //multiplies hp by a modifier (if hp% equals 10 then hp x 1.1)
        System.out.println("hull% "+buffs[5]); //multiplies hull by a modifier
    }

    public int[] getBuffs(){
        return buffs;
    }
    public boolean getActive(){
        return activated;
    }
    
    public void activate(Ship ship) throws NotEnoughStaminaException {
        activated = true;
    }
        
}

