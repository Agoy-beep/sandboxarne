package rpg;

import rpg.enemies.creatures.GoblinBrawler;
import rpg.spells.DestructionSpell;
import rpg.spells.RestorationSpell;

public class Game {
    public static void main(String[] args) {
        Player player = new Player("Titus", 100, 50, 50, false);

        GoblinBrawler goblinBrawler1 = new GoblinBrawler("Gary", 35, 0, 15);

        Target[] npcs = {goblinBrawler1};

        RestorationSpell renewTier1 = new RestorationSpell("Renew",15 , 0, 7, false, false);

        DestructionSpell fireBall1 = new DestructionSpell("Fireball", 0, 25, 12, false, false);

        player.setPotentialTargets(npcs);
        player.learnSpell(renewTier1);
        player.learnSpell(fireBall1);
        player.equipSpell(renewTier1);
        player.equipSpell(fireBall1);
        player.setTarget("Gary");
        player.takeCombatAction();
        System.out.println(goblinBrawler1.getHealth());
    }
}
