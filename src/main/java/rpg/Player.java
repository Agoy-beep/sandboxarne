package rpg;

import rpg.items.Item;
import rpg.spells.Spell;

import java.util.Scanner;

public class Player implements Caster, Shooter, Melee, Target{

    private final String name;
    private int health;
    private int mana;
    private int stamina;
    private Item[] inventory;
    private Spell[] spellSlots = new Spell[3];
    private Scanner playerAnswersWhereToEquip = new Scanner(System.in);

    public Player(String name, int health, int mana, int stamina){
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.stamina = mana;
    }

    @Override
    public void equip(Spell spellType) {
        System.out.format("To which slot would you like to equip %s ?", spellType.getName());
        String inputEquip = playerAnswersWhereToEquip.nextLine();
        switch (inputEquip){
            case "1":
                spellSlots[0] = spellType;
                System.out.format("You've equipped %s to Spell Slot 1", spellType.getName());
                break;
            case "2":
                spellSlots[1] = spellType;
                System.out.format("You've equipped %s to Spell Slot 2", spellType.getName());
                break;
            case "3":
                spellSlots[2] = spellType;
                System.out.format("You've equipped %s to Spell Slot 3", spellType.getName());
                break;
        }
    }

    /**
     * Not taking into account  going below 0 or above 100, for now.
     */
    @Override
    public void cast(Spell spellType, Target target) {
        if(spellType.getAmountOfHealing() != 0){
            target.setHealth(target.getHealth() + spellType.getAmountOfHealing());
            this.setMana(this.getMana() - spellType.getManaCost());
        }
        else{
            target.setHealth(target.getHealth() - spellType.getAmountOfDamage());
            this.setMana(this.getMana() - spellType.getManaCost());
        }
    }



    @Override
    public void attackMelee() {

    }

    @Override
    public void shoot() {

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


}
