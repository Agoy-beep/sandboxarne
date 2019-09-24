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
    private Scanner playerAnswers = new Scanner(System.in);
    private Target[] potentialTargets;
    private Target currentTarget;
    private boolean inCombat;

    public Player(String name, int health, int mana, int stamina, boolean inCombat){
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.stamina = mana;
        this.inCombat = inCombat;
    }

    public void setTarget(String nameOfTarget){
        for(Target target: potentialTargets){
            if(target.getName().equals(nameOfTarget)){
                currentTarget = target;
            }
        }
    }

    public void takeCombatAction(){
        System.out.println("What is your next move? : ");
        String actionByPlayer = playerAnswers.nextLine();
        if(actionByPlayer.toLowerCase().contains("cast")){
            if(actionByPlayer.toLowerCase().contains(this.spellSlots[0].getName().toLowerCase())){
                if(actionByPlayer.toLowerCase().contains("self")){
                    this.castSpell(this.spellSlots[0], this);
                }
                else if(actionByPlayer.toLowerCase().contains(this.currentTarget.getName().toLowerCase())){
                    this.castSpell(this.spellSlots[0], this.currentTarget);
                }
            }
            else if(actionByPlayer.toLowerCase().contains(this.spellSlots[1].getName().toLowerCase())){
                if(actionByPlayer.toLowerCase().contains("self")){
                    this.castSpell(this.spellSlots[1], this);
                }
                else if(actionByPlayer.toLowerCase().contains(this.currentTarget.getName().toLowerCase())){
                    this.castSpell(this.spellSlots[1], this.currentTarget);
                }
            }
            else if(actionByPlayer.toLowerCase().contains(this.spellSlots[2].getName().toLowerCase())){
                if(actionByPlayer.toLowerCase().contains("self")){
                    this.castSpell(this.spellSlots[2], this);
                }
                else if(actionByPlayer.toLowerCase().contains(this.currentTarget.getName())){
                    this.castSpell(this.spellSlots[2], this.currentTarget);
                }
            }
        }
    }

    @Override
    public void learnSpell(Spell spellType) {
        spellType.setKnown(true);
    }

    @Override
    public void equipSpell(Spell spellType) {
        /**
         *TODO IF DIDN'T LEARN THE SPELL, YOU CANNOT EQUIP IT.
         */

        System.out.format("To which slot would you like to equip %s? : ", spellType.getName());
        String inputEquip = playerAnswers.nextLine();
        switch (inputEquip){
            case "1":
                spellSlots[0] = spellType;
                System.out.format("You've equipped %s to Spell Slot 1 \n", spellType.getName());
                break;
            case "2":
                spellSlots[1] = spellType;
                System.out.format("You've equipped %s to Spell Slot 2 \n", spellType.getName());
                break;
            case "3":
                spellSlots[2] = spellType;
                System.out.format("You've equipped %s to Spell Slot 3 \n", spellType.getName());
                break;
        }
        spellType.setEquipped(true);
    }

    /**
     * Not taking into account  going below 0 or above 100, for now.
     */
    @Override
    public void castSpell(Spell spellType, Target target) {
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

    @Override
    public String getName() {
        return name;
    }

    public void setPotentialTargets(Target[] potentialTargets) {
        this.potentialTargets = potentialTargets;
    }
}
