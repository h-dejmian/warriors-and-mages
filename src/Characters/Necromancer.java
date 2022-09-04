package Characters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Necromancer extends Hero implements Summoner {

    private int force = 10;

    public Necromancer() {
        this.heroId = ++Hero.idCount;
        this.health = 100;
        this.energy = 130;
        this.alliedCreatures = new ArrayList<>();
        alliedCreatures.add(new Skeleton());
    }

    @Override
    public void attack(LifeForm opponent) {
        String opponentName = opponent.getClass().getSimpleName();

        if(summonSkeleton()) System.out.println("Necromancer summoning skeleton!");
        if(summonGolem()) System.out.println("Necromancer summoning golem!");
        if(alliedCreatures.size() > 0) {
            Iterator<LifeForm> it = alliedCreatures.iterator();
            while(it.hasNext()) {
                LifeForm lf =  it.next();
                if(lf.isEliminated()) it.remove();
                else lf.attack(opponent);
                if(opponent.isDead()) {
                    System.out.println(opponentName + " died!");
                    System.out.println();
                    break;
                }
            }
        }
    }

    @Override
    public boolean defend() {
        int number = (int) (Math.random() * 10) + 1;
        if(number > 7) return true;
        else return false;
    }

    public void levelUp() {
        level += 1;
        force += 10;

        health = 100;
        health += 10 * level;

        energy = 130;
        energy += 10 * level;
        System.out.println("Necromancer level up!");
        System.out.println();
    }

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

    public boolean summonSkeleton() {
        if(this.alliedCreatures.size() == 6) return false;
        int number = new Random().nextInt(4);
        if(energy >= 10 && number > 2 ) {
            alliedCreatures.add(new Skeleton());
            return true;
        }
        else return false;
    }

    public boolean summonGolem() {
        for(LifeForm lf : this.alliedCreatures) if(lf instanceof Golem) return false;
        int number = new Random().nextInt(4);
        if(energy >= 10 && number == 3 ) {
            alliedCreatures.add(new Golem());
            return true;
        }
        else return false;
    }
}
