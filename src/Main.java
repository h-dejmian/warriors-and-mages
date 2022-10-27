import Characters.ClassName;
import Characters.Hero;
import Characters.HeroFactory;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Hero> heroesSemiFinals = new ArrayList<>();
        List<Hero> heroesfiNal = new ArrayList<>();

        //One duel test
        /*
        List<Hero> heroesTest = new ArrayList<>();
        heroesTest.add(HeroFactory.create(ClassName.WARRIOR));
        heroesTest.add(HeroFactory.create(ClassName.MAGE));

        Game game = new Game(heroesTest);
        Hero hero = game.startGameFinal();
        */


        for(int i=0; i<4; i++) {
            Game game = new Game();
            Hero hero = game.startGameRound();
            heroesSemiFinals.add(hero);
        }

        System.out.println("SEMIFINALS");
        for(Hero h : heroesSemiFinals) {
            System.out.println(h);
            System.out.println();
        }

        for(int i=0; i<2; i++) {
            Game game = new Game(heroesSemiFinals);
            Hero hero = game.startGameFinal();
            heroesfiNal.add(hero);
        }

        System.out.println("FINAL");
        for(Hero h : heroesfiNal) {
            System.out.println(h);
            System.out.println();
        }

        Game game = new Game(heroesfiNal);
        Hero hero = game.startGameFinal();



        Game.stats.showWinner();
        Game.stats.showAlliedCreatures(hero);

        Game.stats.showWinnersOnArenas();

     //   Game.stats.showAllHeroes();
    }
}
