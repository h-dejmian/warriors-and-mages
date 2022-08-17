package Characters;

public class Warrior extends Hero {

    private int strenght = 10;

    public Warrior() {
        this.heroId = ++Hero.idCount;
        this.health = 130;
        this.energy = 80;
    }

    @Override
    public void attack(LifeForm opponent) {
        String opponentName = opponent.getClass().getSimpleName();

        System.out.println("Warrior attacking!");
        if(!opponent.defend()) {
            opponent.health -= 10 + strenght;
            System.out.println(opponentName + "'s health: " + opponent.health);

            if(opponent.isDead()) {
                System.out.println(opponentName + " died!");
                System.out.println();
            }
        }
        else System.out.println("Attack failed!");
    }

    @Override
    public boolean defend() {
        int number = (int) (Math.random() * 10) + 1;
        if(number > 7) return true;
        else return false;
    }

    @Override
    public void levelUp() {
        level += 1;
        strenght += 10;

        health = 130;
        health += 10 * level;

        energy = 80;
        energy += 5;
        System.out.println("Warrior level up!");
        System.out.println();
    }

    @Override
    public void afterBattle() {
        this.health = 130;
        this.energy = 80;

        if(level != 1) {
            this.health += 10 * level;
            this.energy += 5 * level;
        }

        if(currentLvlExperience >= 50) {
            levelUp();
            currentLvlExperience = 0;
        }
    }
}
