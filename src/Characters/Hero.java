package Characters;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero extends LifeForm {

    protected static int idCount;
    protected int heroId;
    protected int experience = 0;
    protected int currentLvlExperience = 0;
    protected int energy;
    protected int level = 1;
    protected int wins;
    protected List<LifeForm> alliedCreatures = new ArrayList<>();

    public abstract void levelUp();

    public abstract void afterBattle();

    public void setWins(int wins) {
        this.wins = this.wins + wins;
    }

    public List<LifeForm> getAlliedCreatures() {
        return alliedCreatures;
    }

    public void removeAlliedCreature(LifeForm form) {
        alliedCreatures.remove(form);
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getCurrentLvlExperience() {
        return currentLvlExperience;
    }

    public void setCurrentLvlExperience(int currentLvlExperience) {
        this.currentLvlExperience = currentLvlExperience;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + heroId + ")" + "\n"
                + "level: " + level + "\n"
                + "experience: " + experience + "\n"
                + "health: " + health + "\n"
                + "battles won: " + wins;
    }


}
