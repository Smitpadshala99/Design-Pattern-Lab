class ProductModelEntity {
    int id;
    int price;
    String name;

    public ProductModelEntity(int id, int price, String name){
        this.id=id;
        this.price=price;
        this.name=name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(int price) {
        this.price = price - 10;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class ViewEntity {
    public void printProductDetails(int id, String name, int price){
        System.out.println("Product Details: id: " + id + ", Name: " + name + " and Price: "+price);
    }
}

class ControllerEntity {
    ProductModelEntity pe;
    ViewEntity ve;

    public ControllerEntity(ProductModelEntity pe, ViewEntity ve){
        this.pe=pe;
        this.ve=ve;
    }

    public void setName(String name){
        pe.setName(name);
    }
    public void setPrice(int price){
        pe.setPrice(price);
    }
    public void  updateProductView(){
        ve.printProductDetails(pe.getId(), pe.getName(), pe.getPrice());
    }
}


// Model View Controllder Design Pattern
public class ArchitechturalPattern {
    public static void main(String[] args) {
        ProductModelEntity p1 = new ProductModelEntity(101, 300, "PS1");
        ViewEntity ve = new ViewEntity();
        ve.printProductDetails(p1.getId(), p1.getName(), p1.getPrice());
        
        ControllerEntity ce = new ControllerEntity(p1, ve);

        ce.setName("PS2");
        ce.setPrice(400);
        ce.updateProductView();

    }    
}
