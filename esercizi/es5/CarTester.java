package es5;

public class CarTester {
    public static void main(String[] args) {
        Car ibiza = new Car(20);
        ibiza.addGas(20);
        ibiza.drive(500);
        if (ibiza.getGas() > 0) {
            System.out.println(ibiza.getGas());
        }
        System.out.println("CLASSPATH:"+System.getenv("CLASSPATH"));
    }
}
