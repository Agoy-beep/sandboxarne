package rpg.enemies;

import rpg.Target;

import java.util.UUID;

public abstract class Enemy implements Target {

    private final String name;
    private int health;
    private int mana;
    private int stamina;

    public Enemy(String name, int health, int mana, int stamina){
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.stamina = stamina;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth(){
        return health;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public int getStamina() {
        return stamina;
    }

    @Override
    public String getName(){
        return name;
    }
}
