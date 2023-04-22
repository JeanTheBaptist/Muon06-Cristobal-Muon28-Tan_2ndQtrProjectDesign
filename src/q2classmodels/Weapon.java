/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;
/**
 *
 * @author MUON
 */
public class Weapon extends Item{
    private int ammo, ammoMax, baseDamage;
    private boolean isAoe;
    private String damageType;
    public Weapon(String name, int price, int worth, int staminaCost, Ship owner){
        super(name, "weapon", price, worth, staminaCost, owner);
        String[] damageTypes = {"physical", "explosive", "magic"};
        damageType = damageTypes[(int)Math.floor(Math.random()*(3))];
        baseDamage = (int)Math.floor(Math.random()*((owner.getInfluence()+11)- staminaCost+3)+staminaCost+2);
        ammoMax = (int)Math.floor((Math.random()*(10+staminaCost+1)+staminaCost)*(1+owner.getInfluence()/10));
        ammo =ammoMax;
        if(Math.random()>0.5){
            isAoe = true;
        }
        else{
            isAoe =false;
        }
    }
    public Weapon(String name, int price, int worth, int staminaCost, Ship owner, int ammoMax, int baseDamage){
        super(name, "weapon", price, worth, staminaCost, owner);
        this.price = price;
        this.worth = worth;
        this.baseDamage = baseDamage;
        this.ammoMax = ammoMax;
        this.isAoe = false;
    }
    
    public int getAmmo(){
        return ammo;
    }
    public int getAmmoMax(){
        return ammoMax;
    }
    public int getBaseDamage(){
        return baseDamage;
    }
    public String getDamageType(){
        return damageType;
    }
    public int getUpgradeCost(){
        return upgradeCost;
    }
    public boolean getAoe(){
        return isAoe;
    }

}
