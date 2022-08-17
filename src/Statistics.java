import Characters.Hero;
import Characters.LifeForm;

public class Statistics {
    private final Arena arena;

    public Statistics(Arena arena) {
        this.arena = arena;
    }

    public void showWinner() {
        System.out.println("Game winner:");
        System.out.println(arena.getWinner());
        System.out.println();
    }

    public void showAllHeroes() {
        System.out.println("Other contestants:");

        for(LifeForm h : arena.getDeadHeroes()) {
            if (!h.equals(arena.getWinner())) System.out.println(h);
            System.out.println();
        }
    }

    public void showAlliedCreatures(Hero hero) {
          System.out.println("Allied creatures: ");
          for(LifeForm lf : hero.getAlliedCreatures()) System.out.println(lf);
          System.out.println();
    }
}
