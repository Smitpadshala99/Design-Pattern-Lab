import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

// MobileShop interface
interface MobileShop {
    public void modelNo();
    public void price();
    public ImageIcon photo(); // new method to return phone photo as an ImageIcon
}

// Iphone class implementing MobileShop interface
class Iphone implements MobileShop {

    // implementation of existing methods omitted for brevity

    @Override
    public ImageIcon photo() {
        return new ImageIcon("iphone_photo.jpg"); // replace with actual photo filename
    }
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

    // implementation of existing methods omitted for brevity

    @Override
    public ImageIcon photo() {
        return new ImageIcon("samsung_photo.jpg"); // replace with actual photo filename
    }
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

    // implementation of existing methods omitted for brevity

    @Override
    public ImageIcon photo() {
        return new ImageIcon("oneplus_photo.jpg"); // replace with actual photo filename
    }
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
    private MobileShop oneplus;

    public Shopkeeper() {
        iphone = new Iphone();
        samsung = new Samsung();
        oneplus = new Oneplus();
    }

    public void iphoneSale() {
        iphone.modelNo();
        iphone.price();
        displayPhoto(iphone.photo());
    }

    public void samsungSale() {
        samsung.modelNo();
        samsung.price();
        displayPhoto(samsung.photo());
    }

    public void oneplusSale() {
        oneplus.modelNo();
        oneplus.price();
        displayPhoto(oneplus.photo());
    }

    private void displayPhoto(ImageIcon photo) {
        // create a window to display the photo
        JFrame frame = new JFrame();
        JLabel label = new JLabel(photo);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
    }
}

// Facade pattern client
public class Facadepatternmobileimage {
    public static void main(String[] args) {
        Shopkeeper shopkeeper = new Shopkeeper();

        System.out.println("Welcome to our mobile shop!");
        System.out.println("Here are our available mobile phones:");
        System.out.println("------------------------------------");
        shopkeeper.iphoneSale();
        shopkeeper.samsungSale();
        shopkeeper.oneplusSale();
        System.out.println("------------------------------------");
        System.out.println("Thank you for visiting our shop!");
    }
}
