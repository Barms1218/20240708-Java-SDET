package Java.Day2.DesignPatterns.Factory;

public class Factory {
    /*
     * FACTORY -> You don't instantiate - the factory does it for you You have one
     * general clas or interface with a bunch of child objects and rather than your
     * main class depending on ALL the child objects, it only depends on your
     * factory
     * 
     * This is a direct correlation to the idea of coupling and cohesion
     * 
     * COUPLING vs COHESION
     * 
     * -> Cohesion - Relationships within your classes
     * 
     * -> Coupling - Relationships between classes.
     * 
     * We want low coupling and high cohesion
     */

    public static void main(String[] args) {
        Superhero hero = SuperheroFactory.createSuperhero("Captain America");
        hero.activateSuperpower();
        hero.sayName();
    }

    static class SuperheroFactory {
        public static Superhero createSuperhero(String type) {
            if (type.equals("Captain America")) {
                return new CaptainAmerica();
            } else if (type.equals("Superman")) {
                return new SuperMan();
            } else if (type.equals("BlackPanther")) {
                return new BlackPanther();
            } else if (type.equals("BatMan")) {
                return new BatMan();
            } else {
                throw new IllegalArgumentException("Invalid Superhero" + type);
            }
        }
    }
}
