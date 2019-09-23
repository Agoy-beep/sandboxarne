package rpg.spells;

public abstract class Spell {

    private String name;
    private int amountOfDamage;
    private int amountOfHealing;
    private int manaCost;

    public Spell(String name, int amountOfHealing, int manaCost) {
        this.name = name;
        this.amountOfHealing = amountOfHealing;
        this.manaCost = manaCost;
    }
    public Spell(int amountOfDamage, String name, int manaCost){
        this.name = name;
        this.amountOfDamage = amountOfDamage;
        this.manaCost = manaCost;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfDamage() {
        return amountOfDamage;
    }

    public int getAmountOfHealing() {
        return amountOfHealing;
    }

    public int getManaCost() {
        return manaCost;
    }
}
