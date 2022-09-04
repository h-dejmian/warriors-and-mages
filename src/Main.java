import Characters.Hero;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Hero> semiFinals = new ArrayList<>();
        List<Hero> fiNal = new ArrayList<>();

        for(int i=0; i<4; i++) {
            Game game = new Game();
            Hero hero = game.startGameRound();
            semiFinals.add(hero);
        }

        System.out.println("SEMIFINALS");
        for(Hero h : semiFinals) {
            System.out.println(h);
            System.out.println();
        }

        for(int i=0; i<2; i++) {
            Game game = new Game(semiFinals);
            Hero hero = game.startGameFinal();
            fiNal.add(hero);
        }

        System.out.println("FINAL");
        for(Hero h : fiNal) {
            System.out.println(h);
            System.out.println();
        }

        Game game = new Game(fiNal);
        Hero hero = game.startGameFinal();
        //get winner to stats

        System.out.println("ALL TIME WINNER IS:");
        System.out.println(hero);

        Game.stats.showAlliedCreatures(hero);
        Game.stats.showAllHeroes();

        Game.stats.showWinner();


    }
}
