import java.util.Scanner;

// Component Interface
interface IceDish {
    public double cost();
    public String getDescription();
}

// Concrete Component
class BasicIceDish implements IceDish {
    public double cost() {
        return 50.0; // basic ice dish cost
    }

    public String getDescription() {
        return "Basic Ice Dish";
    }
}

// Decorator Class
abstract class IceDishDecorator implements IceDish {
    protected IceDish iceDish;

    public IceDishDecorator(IceDish iceDish) {
        this.iceDish = iceDish;
    }

    public double cost() {
        return iceDish.cost();
    }

    public String getDescription() {
        return iceDish.getDescription();
    }
}

// Concrete Decorator Classes
class Flavor extends IceDishDecorator {
    public Flavor(IceDish iceDish) {
        super(iceDish);
    }

    public double cost() {
        return iceDish.cost() + 10.0; // additional cost of flavor
    }

    public String getDescription() {
        return iceDish.getDescription() + ", with added flavor";
    }
}

class DryFruit extends IceDishDecorator {
    public DryFruit(IceDish iceDish) {
        super(iceDish);
    }

    public double cost() {
        return iceDish.cost() + 25.0; // additional cost of dry fruit
    }

    public String getDescription() {
        return iceDish.getDescription() + ", with added dry fruit";
    }
}

class MalaiCreame extends IceDishDecorator {
    public MalaiCreame(IceDish iceDish) {
        super(iceDish);
    }

    public double cost() {
        return iceDish.cost() + 25.0; // additional cost of malai creame
    }

    public String getDescription() {
        return iceDish.getDescription() + ", with added malai creame";
    }
}

class ChocolateSyrup extends IceDishDecorator {
    public ChocolateSyrup(IceDish iceDish) {
        super(iceDish);
    }

    public double cost() {
        return iceDish.cost() + 30.0; // additional cost of chocolate syrup
    }

    public String getDescription() {
        return iceDish.getDescription() + ", with added chocolate syrup";
    }
}

class CoconutGrinded extends IceDishDecorator {
    public CoconutGrinded(IceDish iceDish) {
        super(iceDish);
    }

    public double cost() {
        return iceDish.cost() + 15.0; // additional cost of grinded coconut
    }

    public String getDescription() {
        return iceDish.getDescription() + ", with added grinded coconut";
    }
}

public class lab15_Decorator_icedish {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            IceDish iceDish = new BasicIceDish();
            boolean done = false;
            
            while (!done) {
                System.out.println("What would you like to add to your ice dish?");
                System.out.println("1. Flavor (+10 Rs.)");
                System.out.println("2. Dry fruit (+25 Rs.)");
                System.out.println("3. Malai creame (+25 Rs.)");
                System.out.println("4. Chocolate syrup (+30 Rs.)");
                System.out.println("5. Grinded coconut (+15 Rs.)");
                System.out.println("6. Done");
        
                int choice = scanner.nextInt();
        
                switch (choice) {
                    case 1:
                        iceDish = new Flavor(iceDish);
                        break;
                    case 2:
                        iceDish = new DryFruit(iceDish);
                        break;
                    case 3:
                        iceDish = new MalaiCreame(iceDish);
                        break;
                    case 4:
                        iceDish = new ChocolateSyrup(iceDish);
                        break;
                    case 5:
                        iceDish = new CoconutGrinded(iceDish);
                        break;
                    case 6:
                        done = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                        break;
                }
            }
        
            System.out.println("Your ice dish has been created:");
            System.out.println(iceDish.getDescription());
            System.out.println("Total cost: " + iceDish.cost() + " Rs.");
        }
        
    }
