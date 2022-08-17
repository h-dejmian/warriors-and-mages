package Characters;

public class Golem extends LifeForm {

    public Golem() {this.health = 75;}

    @Override
    public void attack(LifeForm opponent) {
        String opponentName = opponent.getClass().getSimpleName();

        System.out.println("Golem attacking!");
        if(!opponent.defend()) {
            opponent.health -= 30;
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
        else {
            if(health <= 0) eliminated = true;
            return false;
        }
    }
}
