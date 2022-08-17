package Characters;

public abstract class LifeForm {
    protected int health;
    protected boolean eliminated = false;

    public abstract void attack(LifeForm opponent);
    public abstract boolean defend();

    public boolean isDead() {
        if(health <= 0) {
            this.health = 0;
            return true;
        }
        else return false;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ": health - " + health;
    }
}
