package Exercise1.StructuralPatterns.Decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee c = new BasicCoffee();
        System.out.println(c.getDescription());
        System.out.println(c.getCost());

        MilkDecorator d1 = new MilkDecorator(c);
        System.out.println(d1.getDescription());
        System.out.println(d1.getCost());

        WhippedCreamDecorator d2 = new WhippedCreamDecorator(d1);
        System.out.println(d2.getDescription());
        System.out.println(d2.getCost());
    }
}
