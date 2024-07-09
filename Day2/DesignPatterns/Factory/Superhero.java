package Java.Day2.DesignPatterns.Factory;

public interface Superhero {
    void activateSuperpower();

    void sayName();
}

class CaptainAmerica implements Superhero {
    @Override
    public void activateSuperpower() {
        System.out.println("I am a great fighter and leader.");
    }

    public void sayName() {
        System.out.println("I'm Steve Rogers.");
    }
}

class SuperMan implements Superhero {

    @Override
    public void activateSuperpower() {
        System.out.println("I can fly really high.");
    }

    public void sayName() {
        System.out.println("I'm Clark Kent.");
    }
}

class BlackPanther implements Superhero {

    @Override
    public void activateSuperpower() {
        System.out.println("I have vibranium armor and incredible reflexes.");
    }

    public void sayName() {
        System.out.println("I'm T'Challa.");
    }
}

class BatMan implements Superhero {

    @Override
    public void activateSuperpower() {
        System.out.println("I have a powerful detective mind and gadgets.");
    }

    public void sayName() {
        System.out.println("I'm Bruce Wayne.");
    }
}