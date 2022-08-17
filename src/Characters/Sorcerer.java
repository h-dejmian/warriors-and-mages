package Characters;

public interface Sorcerer {
    boolean castFireball(LifeForm form);
    boolean createClone() throws CloneNotSupportedException;
    boolean paralyze(LifeForm form);
}
