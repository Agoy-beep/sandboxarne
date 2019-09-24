package rpg.spells;

public abstract class Spell {

    private String name;
    private int amountOfDamage;
    private int amountOfHealing;
    private int manaCost;
    private boolean isEquipped =  false;
    private boolean isKnown = false;

    public Spell(String name, int amountOfHealing, int amountOfDamage, int manaCost, boolean isEquipped, boolean isKnown) {
        this.name = name;
        this.amountOfHealing = amountOfHealing;
        this.amountOfDamage = amountOfDamage;
        this.manaCost = manaCost;
        this.isEquipped = isEquipped;
        this.isKnown = isKnown;
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

    public void setEquipped(boolean equipped) {
        isEquipped = equipped;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public void setKnown(boolean known) {
        isKnown = known;
    }

    public boolean isKnown() {
        return isKnown;
    }
}
