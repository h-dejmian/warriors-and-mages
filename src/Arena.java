import Characters.ClassName;
import Characters.Hero;
import Characters.HeroFactory;
import Characters.LifeForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private final List<LifeForm> heroes = new ArrayList<>();
    private final List<LifeForm> deadHeroes = new ArrayList<>();
    private Hero winner;

    public List<LifeForm> getHeroes() {
        return heroes;
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public void addLifeForm(LifeForm form) {
        heroes.add(form);
    }

    public void removeLifeForm(LifeForm form) {
        heroes.remove(form);
    }

    public void removeLifeForms(List<LifeForm> forms) {
        heroes.removeAll(forms);
    }

    public Hero getWinner() {
        return winner;
    }

    public void setWinner(Hero winner) {
        this.winner = winner;
    }

    public void addToDeadHeroes(Hero hero) {
        deadHeroes.add(hero);
    }

    public List<LifeForm> getDeadHeroes() {
        return deadHeroes;
    }

    public void addNewHeroes(int numberOfHeroes) {
        for(int i=0; i<numberOfHeroes ; i++) {
            int number = new Random().nextInt(3);
            this.addHero(HeroFactory.create(ClassName.values()[number]));
        }
    }
}
