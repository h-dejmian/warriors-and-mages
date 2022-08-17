package Characters;

public class HeroFactory {

    public static Hero create(ClassName type){
          if(type.equals(ClassName.WARRIOR)) return new Warrior();
          if(type.equals(ClassName.MAGE)) return new Mage();
          if(type.equals(ClassName.NECROMANCER)) return new Necromancer();
          else return null;
      }

}
