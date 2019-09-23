package rpg.enemies.creatures;

import rpg.Melee;
import rpg.Target;
import rpg.enemies.Enemy;

import java.util.UUID;

public class GoblinBrawler extends Enemy implements Melee, Target {

    public GoblinBrawler(String name, int health, int mana, int stamina) {
        super(name, health, mana, stamina);
    }

    @Override
    public void attackMelee() {
        // attacks for 5 - 12 damage
    }

}
