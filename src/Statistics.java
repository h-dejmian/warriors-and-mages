import Characters.Hero;
import Characters.LifeForm;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private final List<Arena> arenas = new ArrayList<>();

    public void showWinner() {
        System.out.println("Game winner:");
        System.out.println(arenas.get(arenas.size()-1).getWinner());
        System.out.println();
    }

    //Shows heroes without winners on each of arenas
    public void showAllHeroes() {
        System.out.println("Other contestants:");

        for(Arena a : arenas) {
            for(LifeForm h : a.getDeadHeroes()) {
                if (!h.equals(a.getWinner())) System.out.println(h);
                System.out.println();
            }
        }
    }

    public void showAlliedCreatures(Hero hero) {
          System.out.println("Allied creatures: ");
          for(LifeForm lf : hero.getAlliedCreatures()) System.out.println(lf);
          System.out.println();
    }

    public void showWinnersOnArenas() {
        int number = 0;
        System.out.println("Winners on arenas: ");
        for(Arena a : arenas) {
            for(LifeForm h : a.getHeroes()) {
                if (h.equals(a.getWinner())) {
                    System.out.println("Arena #" + ++number);
                    System.out.println(h);
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    public void addArena(Arena arena) {
        arenas.add(arena);
    }
}
