import Characters.*;

import java.util.List;
import java.util.concurrent.Callable;

public class Game implements Callable {

    public Hero call() {
        Arena arena = new Arena();

        arena.addNewHeroes(2);

        List<LifeForm> heroes = arena.getHeroes();

        while (true) {
            if (arena.getHeroes().size() == 1) arena.addNewHeroes(1);
            if (arena.getHeroes().size() == 0) arena.addNewHeroes(2);

            Hero hero1 = (Hero) heroes.get(0);
            Hero hero2 = (Hero) heroes.get(1);

            Duel duel = new Duel(hero1, hero2, arena);
            duel.battle();

            if (hero1.getLevel() == 5 || hero2.getLevel() == 5) break;
        }

        return arena.getWinner();

    /*    Statistics stats = new Statistics(arena);
        stats.showWinner();
        stats.showAlliedCreatures(arena.getWinner());
        stats.showAllHeroes(); */
    }


}
