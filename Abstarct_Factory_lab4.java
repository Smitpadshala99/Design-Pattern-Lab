import java.util.Scanner;

interface AbstractFactory{
    Chair createChair();
    Sofa createSofa();
    Table createTable();
}

interface Chair{
    float Chairprice();
    String ChairType();
}

interface Table{
    float Tableprice();
    String TableType();
}

interface Sofa{
    float Sofaprice();
    String SofaType();
}

class OfficeChair implements Chair{

    @Override
    public float Chairprice() {
        return 899.99f;
    }

    @Override
    public String ChairType() {
        return "Office BMobileFactorys Chair\tOffice Employee Chair";
    }
    
}

class HomeChair implements Chair{

    @Override
    public float Chairprice() {
        return 999f;
    }

    @Override
    public String ChairType() {
        return "Guest Chair";
    }
}

class OfficeTable implements Table{

    @Override
    public float Tableprice() {
        return 1599f;
    }

    @Override
    public String TableType() {
        return "Plastic Table\tWood Table";
    }
}

class HomeTable implements Table{

    @Override
    public float Tableprice() {
        return 1999f;
    }

    @Override
    public String TableType() {
        return "Dining Table";
    }   
}

class OfficeSofa implements Sofa{

    @Override
    public float Sofaprice() {
        return 19999f;
    }

    @Override
    public String SofaType() {
        return "Office Sofa";
    }   
}

class HomeSofa implements Sofa{

    @Override
    public float Sofaprice() {
        return 24999f;
    }

    @Override
    public String SofaType() {
        return "Home Sofa";
    }
}


class Office implements AbstractFactory{

    @Override
    public Chair createChair() {
        return new OfficeChair();
    }

    @Override
    public Sofa createSofa() {
        return new OfficeSofa();
    }

    @Override
    public Table createTable() {
        return new OfficeTable();
    }   
}

class Home implements AbstractFactory{

    @Override
    public Chair createChair() {
        return new HomeChair();
    }

    @Override
    public Sofa createSofa() {
        return new HomeSofa();
    }

    @Override
    public Table createTable() {
        return new HomeTable();
    }
}

class FurnitureFactory{
    public AbstractFactory getFurniture(String f){
        Scanner sf = new Scanner(System.in);
        switch(f.toLowerCase()){
            case "office" :
            System.out.println("Enter your furniture type : [Table, Sofa, Chair]");
            String of = sf.nextLine();
            switch(of.toLowerCase()){
                case "table" :
                OfficeTable ot = new OfficeTable();
                System.out.println("Type of table is: "+ot.TableType());
                System.out.println("Price of table is: "+ot.Tableprice());
                break;
                case "chair" :
                OfficeChair oc = new OfficeChair();
                System.out.println("Type of chair is: "+oc.ChairType());
                System.out.println("Price of chair is: "+oc.Chairprice());
                break;
                case "sofa" :
                OfficeSofa os = new OfficeSofa();
                System.out.println("Type of sofa is: "+os.SofaType());
                System.out.println("Price of sofa is: "+os.Sofaprice());
                break;
                default :
                System.out.println("Enter valid furniture type!!");
                break;
            }
            break;
            case "home" :
            System.out.println("Enter your furniture type : [Table, Sofa, Chair]");
            String hf = sf.nextLine();
            switch(hf.toLowerCase()){
                case "table" :
                HomeTable ht = new HomeTable();
                System.out.println("Type of table is: "+ht.TableType());
                System.out.println("Price of table is: "+ht.Tableprice());
                break;
                case "chair" :
                HomeChair hc = new HomeChair();
                System.out.println("Type of chair is: "+hc.ChairType());
                System.out.println("Price of chair is: "+hc.Chairprice());
                break;
                case "sofa" :
                HomeSofa hs = new HomeSofa();
                System.out.println("Type of sofa is: "+hs.SofaType());
                System.out.println("Price of sofa is: "+hs.Sofaprice());
                break;
                default :
                System.out.println("Enter valid furniture type!!");
                break;
            }
            break;
            default :
            System.out.println("Enter valid choice [Office, Home]");
            break;
        }
        return null;

    }
}

public class Abstarct_Factory_lab4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice for furniture : [Office, Home]");
        String ch = sc.nextLine();
        FurnitureFactory ff = new FurnitureFactory();
        AbstractFactory af = ff.getFurniture(ch);
    }
}
