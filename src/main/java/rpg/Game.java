package rpg;

import rpg.enemies.creatures.GoblinBrawler;
import rpg.spells.RestorationSpell;

public class Game {
    public static void main(String[] args) {
        Player player = new Player("Titus", 100, 50, 50);

        GoblinBrawler goblinBrawler1 = new GoblinBrawler("Gary", 35, 0, 15);

        RestorationSpell renewTier1 = new RestorationSpell("Renew", 15, 20);

        player.cast(renewTier1, player);
        System.out.println(player.getHealth());
        System.out.println(player.getMana());
        player.cast(renewTier1, goblinBrawler1);
        System.out.println(goblinBrawler1.getHealth());
        System.out.println(player.getMana());

    }
}
