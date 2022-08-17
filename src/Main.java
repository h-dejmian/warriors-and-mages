import Characters.Hero;
import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Hero> semiFinals = new ArrayList<>();
        List<Hero> fiNal = new ArrayList<>();

        for(int i=0; i<4; i++) {
            Game game = new Game();
            Hero hero = game.call();
            semiFinals.add(hero);
        }

        for(Hero h : semiFinals) {
            System.out.println(h);
            System.out.println();
        }


        Hero hero1;
        Hero hero2;

        for(int i=0; i<4; i+=2) {
            hero1 = semiFinals.get(i);
            hero2 = semiFinals.get(i + 1);
            Arena arena = new Arena();

            arena.addHero(hero1);
            arena.addHero(hero2);

            Duel duel = new Duel(hero1, hero2, arena);
            duel.battle();
            fiNal.add(duel.getArena().getWinner());
        }

        for(Hero h : fiNal) System.out.println(h);
        System.out.println();

        hero1 = fiNal.get(0);
        hero2 = fiNal.get(1);

        Arena arena = new Arena();

        arena.addHero(hero1);
        arena.addHero(hero2);

        Duel duel = new Duel(hero1, hero2, arena);
        duel.battle();
        fiNal.add(duel.getArena().getWinner());


        System.out.println("FUCKING ALL TIME WINNER IS:");
        System.out.println(duel.getArena().getWinner());
        Statistics stats = new Statistics(arena);
        stats.showAlliedCreatures(duel.getArena().getWinner());
        stats.showAllHeroes();



    }
}
