/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Juan David Salas Camargo
 */
public class PersonajePrincipal {
    private String name;
    private int life;
    private int strong;
    private int defense;
    private int agility;
    private int mana;
    private int wisdom;
    private int progress;
    


    public PersonajePrincipal() {
    this.name = "generic";
    this.life = 1000;
    this.strong = 10;
    this.defense = 20;
    this.agility = 10;
    this.mana = 100;
    this.wisdom = 0;
    this.progress = 0;
}
    
/**
 * Este contructor es tambien la manera en la que se inicia una nueva partida
 * 
 * @author Juan David Salas Camargo
 */
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLife() {
        return this.life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public int getStrong() {
        return this.strong;
    }
    public void setStrong(int strong) {
        this.strong = strong;
    }
    public int getDefense() {
        return this.defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getAgility() {
        return this.agility;
    }
    public void setAgility(int Agility) {
        this.agility = Agility;
    }
    public int getMana() {
        return this.mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getWisdom() {
        return this.wisdom;
    }
    public void setWisdom(int wisdom) {
        
        this.wisdom = wisdom;
    }
    public int getProgress() {
        return this.progress;
    }
    public void setProgress(int progress) {
        
        this.progress = progress;
    }

    @Override
    public String toString() {        
        return "name " + this.name + "\nlife " + this.life + "\nstrong " + this.strong + "\ndefense " + this.defense + "\nagility " + this.agility + "\nmana " + this.mana + "\nwisdom " + this.wisdom + "\nprogress " + this.progress;
    }
    
}
