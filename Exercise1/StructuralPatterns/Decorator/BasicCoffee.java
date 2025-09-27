package Exercise1.StructuralPatterns.Decorator;

// Concrete Component
public class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Black Coffee";
    }

    @Override
    public double getCost() {
        return 2.50;
    }
}
