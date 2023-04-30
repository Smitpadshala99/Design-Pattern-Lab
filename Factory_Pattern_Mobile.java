import java.util.Scanner;

interface Mobile{
    String getMusic();
    String getSMS();

}

class Apple implements Mobile{

    @Override
    public String getMusic() {
        return "Playing Music in spotify";
    }

    @Override
    public String getSMS() {
        return "Sending Message from Instagram";
    }
    
}

class Nokia implements Mobile{

    @Override
    public String getMusic() {
        return "Playing Music in AmazonMusic";
    }

    @Override
    public String getSMS() {
        return "Sending Message from Telegram";
    }
    
}

class Samsung implements Mobile{

    @Override
    public String getMusic() {
        return "Playing Music in Youtube";
    }

    @Override
    public String getSMS() {
        return "Sending Message from Whatsapp";
    }
    
}

class MobileFactory{
    public Mobile getMobile(String m){
        Scanner sc = new Scanner(System.in);
        switch(m){
            case "I":
            return new Apple();
            case "A":
                System.out.println("Enter a number for Nokia(1) and Samsung(2)");
                String st = sc.nextLine();
                switch(st){
                    case "1":
                    return new Samsung();
                    case "2":
                    return new Nokia();
                    default:
                    System.out.println("Enter valid mobile");
                    return null;
                }
            default: 
                System.out.println("Enter valid MobileFactory ");
            return null;
        }
    }
}

public class Factory_Pattern_Mobile {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.println("Enter a Operating System you want from this IMobileFactory(I) and AndroidMobileFactory(A)");
        String str = sa.nextLine();
        MobileFactory MobileFactory = new MobileFactory();
        Mobile mo =  MobileFactory.getMobile(str);
        System.out.println(mo.getMusic()); 
        System.out.println(mo.getSMS());
    }
}

