public class Fruit {
    String name;

    Fruit() {
        this.name = "unknown fruit";
    }

    Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void toString() {
        return "Fruit [name=" + this.name + "]";
    }
}

public class Apple extends Fruit {
    Apple() {
        System.out.println("the name of the fruit is " + this.getName());
        this.setName("Apple");
    }

    public void toString() {
        return "Apple [" + super.toString() + "]";
    }
}