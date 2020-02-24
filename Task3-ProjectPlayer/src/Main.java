import attack.ArrowAttack;
import attack.SwordAttack;
import defend.ArmorDefend;
import defend.ShieldDefend;
import fly.*;
import sound.*;

public class Main {
    public static void main(String[] args) {
        Duck superDuck = new Duck(new RocketFly(), new ToaSound(), new SwordAttack(), new ShieldDefend());
        System.out.println("Super DUck Behaviour : ");
        superDuck.fly();
        superDuck.sound();
        superDuck.attack();
        superDuck.defend();

        System.out.println("");
        System.out.println("Noob Duck Behaviour : ");
        Duck noobDuck = new Duck(new WingsFly(), new NormalSound(), new ArrowAttack(), new ArmorDefend());
        noobDuck.fly();
        noobDuck.sound();
        noobDuck.attack();
        noobDuck.defend();

        System.out.println("");
        System.out.println("Super Duck Change Fly Behaviour");
        superDuck.setFlyBehaviour(new PlaneFly());
        superDuck.fly();
        superDuck.sound();
        superDuck.attack();
        superDuck.defend();


    }
}
