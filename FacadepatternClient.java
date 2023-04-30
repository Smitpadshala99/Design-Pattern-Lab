// MobileShop interface
interface MobileShop {
    public void modelNo();
    public void price();
}

// Iphone class implementing MobileShop interface
class Iphone implements MobileShop {

    @Override
    public void modelNo() {
        System.out.println("Iphone Model Name: Iphone 14 pro");
    }

    @Override
    public void price() {
        System.out.println("Iphone 14 pro Price: 1,49,900 Rs.");
    }
}

// Samsung class implementing MobileShop interface
class Samsung implements MobileShop {

    @Override
    public void modelNo() {
        System.out.println("Samsung Model Name: Galaxy S23 Ultra");
    }

    @Override
    public void price() {
        System.out.println("Samsung Price: 1,34,999 Rs.");
    }
}

// Oneplus class implementing MobileShop interface
class Oneplus implements MobileShop {

    @Override
    public void modelNo() {
        System.out.println("Oneplus Model Name: OnePlus 10 Ultra 5G");
    }

    @Override
    public void price() {
        System.out.println("Oneplus Price: 69,999 Rs.");
    }
}

// Shopkeeper class as the Facade
class Shopkeeper {
    private MobileShop iphone;
    private MobileShop samsung;
    private MobileShop Oneplus;

    public Shopkeeper() {
        iphone = new Iphone();
        samsung = new Samsung();
        Oneplus = new Oneplus();
    }

    public void iphoneSale() {
        iphone.modelNo();
        iphone.price();
    }

    public void samsungSale() {
        samsung.modelNo();
        samsung.price();
    }

    public void OneplusSale() {
        Oneplus.modelNo();
        Oneplus.price();
    }
}

// Facade pattern client
public class FacadepatternClient {
    public static void main(String[] args) {
        Shopkeeper shopkeeper = new Shopkeeper();

        System.out.println("Welcome to our mobile shop!");
        System.out.println("Here are our available mobile phones:");
        System.out.println("------------------------------------");
        shopkeeper.iphoneSale();
        shopkeeper.samsungSale();
        shopkeeper.OneplusSale();
        System.out.println("------------------------------------");
        System.out.println("Thank you for visiting our shop!");
    }
}
