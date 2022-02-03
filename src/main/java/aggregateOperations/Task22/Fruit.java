package aggregateOperations.Task22;

public class Fruit {
    private String name;
    private boolean citrus;
    Fruit(String name, boolean citrus) {
        this.name = name;
        this.citrus = citrus;
    }

    public boolean isCitrus() {
        return citrus;
    }

    public void display() {
        System.out.println(name + "\t, citrus: " + isCitrus());
    }
}
