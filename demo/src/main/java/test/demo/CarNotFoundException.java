package test.demo;

public class CarNotFoundException extends RuntimeException {

    CarNotFoundException(int id) {
        super("Could not find employee " + id);
      }
}
