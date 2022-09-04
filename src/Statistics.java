import Characters.Hero;
import Characters.LifeForm;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private final List<Arena> arenas = new ArrayList<>();

    public List<Arena> getArenas() {
        return arenas;
    }

    public void showWinner() {
        System.out.println("Game winner:");
        System.out.println(arenas.get(arenas.size()-1).getWinner());
        System.out.println();
    }

    public void showAllHeroes() {
        System.out.println("Other contestants:");

        for(Arena a : arenas) {
            for(LifeForm h : a.getHeroes()) {
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

    public void addArena(Arena arena) {
        arenas.add(arena);
    }
}
