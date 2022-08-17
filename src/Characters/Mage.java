package Characters;

import java.util.Iterator;

public class Mage extends Hero implements Sorcerer, Cloneable {

    private int force = 10;

    public Mage() {
        this.heroId = ++Hero.idCount;
        this.health = 100;
        this.energy = 130;
    }

    @Override
    public void attack(LifeForm opponent) {
        String opponentName = opponent.getClass().getSimpleName();

        System.out.println("Mage attacking!");
        if(castFireball(opponent)) {
            System.out.println("Mage casts fireball on " + opponent.getClass().getSimpleName() + "!");
            System.out.println(opponent.getClass().getSimpleName() + "'s health: " + opponent.health);
        }
        if(createClone()) {
            System.out.println("Mage created Clone!");
        }

        if(!opponent.defend()) {
            opponent.health -= 10 + force;
            this.energy -= 30;
            System.out.println(opponentName + "'s health: " + opponent.health);
            if(opponent.isDead()) {
                System.out.println(opponentName + " died!");
                System.out.println();
            }
        }
        else System.out.println("Attack failed!");
    }

    @Override
    public boolean defend() {
        int number = (int) (Math.random() * 10) + 1;
        if(number > 7) return true;
        else return false;
    }
    @Override
    public void levelUp() {
        level += 1;
        force += 10;

        health = 100;
        health += 10 * level;

        energy = 130;
        energy += 10 * level;
        System.out.println("Mage level up!");
        System.out.println();
    }

    //TODO REMOVE CLONE AFTER BATTLE
    @Override
    public void afterBattle() {
        alliedCreatures.removeIf(LifeForm::isEliminated);

        this.health = 100;
        this.energy = 130;

        if(level != 1) {
            this.energy += 10 * level;
            this.health += 5 * level;
        }

        if(currentLvlExperience >= 50) {
            levelUp();
            currentLvlExperience = 0;
        }
    }

    @Override
    public boolean castFireball(LifeForm form) {
        if(this.energy < 30) return false;
        int number = (int) (Math.random() * 10) + 1;
        if(number > 7) {
            form.health -= 40;
            this.energy -= 30;
            return true;
        }
        else return false;
    }

    @Override
    public boolean createClone() {
        try {
            int number = (int) (Math.random() * 10) + 1;
            if(this.energy < 50) return false;
            if(number > 5) {
                this.energy -= 50;
                Mage mage = (Mage) this.clone();
                alliedCreatures.add(mage);
                return true;
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return false;
    }

    //TODO
    @Override
    public boolean paralyze(LifeForm form) {return false;}
}
