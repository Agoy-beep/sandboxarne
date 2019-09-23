package rpg;

import rpg.spells.Spell;

public interface Caster {

    void equip(Spell spellType);
    void cast(Spell spellType, Target target);

}
