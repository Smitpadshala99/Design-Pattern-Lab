import java.util.ArrayList;
import java.util.List;

// Abstract class that defines the basic structure of a component
abstract class Component{
    // Property to store the name of the component
    protected String name;

    // Constructor that takes in the name of the component
    public Component(String n){
        name = n;
    }

    // Abstract method that needs to be implemented by the concrete classes
    public abstract void describeComponent();
    public abstract int getPrice();
}

// Concrete class for a leaf component
class leaf extends Component{
    int price;
    // Constructor that takes in the name of the leaf component
    public leaf(String n, int price) {
        super(n);
        this.price=price;
    }

    // Implementation of the describeComponent() method
    @Override
    public void describeComponent() {
        // Prints the name of the leaf component
        System.out.println("Leaf: "+name);
    }

    @Override
    public int getPrice() {
        System.out.println("Leaf: "+name+"\tPrice: "+price);
        return price;       
    }
}

// Concrete class for a composite component
class Composite extends Component{
    // List to store the child components (either leaf or composite)
    List<Component> ls = new ArrayList<Component>();

    // Constructor that takes in the name of the composite component
    public Composite(String n) {
        super(n);
    }

    // Method to add a child component to the composite component
    public void addComponent(Component c){
        ls.add(c);
    }
    
    // Method to remove a child component from the composite component
    public void removeComponent(Component c){
        ls.remove(c);
    }

    // Method to get the list of child components
    public List componenList(){return ls;}

    // Implementation of the describeComponent() method

    @Override
    public void describeComponent() {
        // Prints the name of the composite component
        System.out.println("Component: "+name);
        // Loops through the list of child components and describes each component
        for(Component c: ls){
            c.describeComponent();
        }
    }

    @Override
    public int getPrice() {
        int p=0;
        for(Component c:ls){
            p += c.getPrice();
        }
        System.out.println("price: "+p);
        return p;       
    }
}

// Client class to use the composite pattern
public class composite_pattern {

    public static void main(String[] args) {
        Component HDD = new leaf("HDD",5000);
        Component RAM = new leaf("RAM",3000);
        Component CPU = new leaf("CPU",49000);
        Component Mouse = new leaf("Mouse",999);
        Component keyboard = new leaf("Keyboard",1499);

        Composite Computer = new Composite("Computer");
        Composite Cabinat = new Composite("Cabinat");
        Composite Peripheral = new Composite("Paripheral");
        Composite Motherboard = new Composite("Motherboard");
        
        Computer.addComponent(Cabinat);
        Computer.addComponent(Peripheral);

        Cabinat.addComponent(HDD);
        Cabinat.addComponent(Motherboard);

        Peripheral.addComponent(Mouse);
        Peripheral.addComponent(keyboard);
    
        Motherboard.addComponent(CPU);
        Motherboard.addComponent(RAM);
        
        Computer.describeComponent();
        Computer.getPrice();
       

    
    }
}
