import Characters.Hero;
import Characters.LifeForm;
import Characters.Necromancer;
import Characters.Skeleton;

import java.util.List;
import java.util.Random;

public class Duel {
    private final Hero hero1;
    private final Hero hero2;
    private final Arena arena;
    private int expPrice;

    public Duel(Hero hero1, Hero hero2, Arena arena) {
        this.hero1 = hero1;
        this.hero2 = hero2;
        this.arena = arena;
    }

    public Arena getArena() {
        return arena;
    }

    //Returns true if attacked creature died
    private boolean attack(Hero hero1, Hero hero2) {

        List<LifeForm> alliedCreatures = hero2.getAlliedCreatures();
        int attackedAlly = 0;
        if(!alliedCreatures.isEmpty()) attackedAlly = new Random().nextInt(alliedCreatures.size());


            hero1.attack(hero2);

            if (hero2.isDead()) {
                expPrice = hero2.getLevel() * 25;
                arena.addToDeadHeroes(hero2);
                arena.removeLifeForm(hero2);
                arena.removeLifeForms(hero2.getAlliedCreatures());
                arena.removeLifeForms(hero1.getAlliedCreatures());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            }

            if(!alliedCreatures.isEmpty()) {
                LifeForm lifeForm = alliedCreatures.get(attackedAlly);
                hero1.attack(lifeForm);
                if(lifeForm.isDead()) {
                    lifeForm.setEliminated(true);
                    hero2.removeAlliedCreature(lifeForm);
                    arena.removeLifeForm(lifeForm);
                }
            }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void battle() {

        System.out.println(hero1.getClass().getSimpleName() + " VS " + hero2.getClass().getSimpleName());
        System.out.println();

        addAlliedCreatures(hero1, hero2);

        do {
            if(attack(hero1, hero2)) break;
            if(attack(hero2, hero1)) break;

         } while (arena.getHeroes().size() > 1);

        Hero winner = (Hero) arena.getHeroes().get(0);
        winner.setExperience(winner.getExperience() + expPrice);
        winner.setCurrentLvlExperience(winner.getCurrentLvlExperience() + expPrice);
        winner.setWins(1);
        winner.afterBattle();

        arena.setWinner(winner);
    }

    private void addAlliedCreatures(Hero... heroes) {
        for (Hero h : heroes) {
            for (LifeForm lf : h.getAlliedCreatures()) arena.addLifeForm(lf);
        }
    }
}
