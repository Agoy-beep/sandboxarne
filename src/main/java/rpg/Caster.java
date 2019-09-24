package rpg;

import rpg.spells.Spell;

public interface Caster {

    void learnSpell(Spell spellType);
    void equipSpell(Spell spellType);
    void castSpell(Spell spellType, Target target);

}
