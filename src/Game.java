import Characters.*;

import java.util.List;

public class Game  {
    private static int id;
    public static final Statistics stats = new Statistics();
    private List<Hero> contestants;

    public Game() {
        ++id;
        contestants = null;
    }

    public Game(List<Hero> heroes) {
        ++id;
        this.contestants = heroes;
    }

    public Hero startGameRound() {
        System.out.println("Game nr " + id);
        Arena arena = new Arena();
        stats.addArena(arena);

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
    }

    public Hero startGameFinal() {
        System.out.println("Game nr " + id);
        Arena arena = new Arena();
        stats.addArena(arena);

        arena.addHero(contestants.get(0));
        arena.addHero(contestants.get(1));

        Duel duel = new Duel((Hero)arena.getHeroes().get(0), (Hero)arena.getHeroes().get(1), arena);
        duel.battle();

        return arena.getWinner();
    }




}
