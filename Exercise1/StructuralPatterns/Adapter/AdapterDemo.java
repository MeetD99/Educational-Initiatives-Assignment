package Exercise1.StructuralPatterns.Adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        TemperatureAdapter a1 = new TemperatureAdapter(new FahrenheitSensor());

        a1.getTemperatureC();
    }
}
