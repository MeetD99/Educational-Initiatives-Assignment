package Exercise1.StructuralPatterns.Decorator;

// Concrete Decorator
public class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", topped with Whipped Cream";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1.00;
    }
}