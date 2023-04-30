import java.util.ArrayList;
import java.util.List;

// Originator Object class
class OriginatorArtical{
    private String content;
    private int font_size;
    private String font_type;

    public OriginatorArtical(String c, int fs, String ft){
        content = c;
        font_size = fs;
        font_type = ft;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setFont_size(int font_size) {
        this.font_size = font_size;
    }
    public void setFont_type(String font_type) {
        this.font_type = font_type;
    }
    public String getContent() {
        return content;
    }
    public int getFont_size() {
        return font_size;
    }
    public String getFont_type() {
        return font_type;
    }

    public MementoObjectArtical saveArtical(){
        return new MementoObjectArtical(content, font_size, font_type);
    }
    
    public void restoreArtical(MementoObjectArtical moa){
        content = moa.getContent();
        font_size = moa.getFont_size();
        font_type = moa.getFont_type();
    }

    public void printArticalDetails(){
        System.out.println("Artical content is "+content+" \tfont size: "+font_size+" \tfont type: "+font_type);
    }

}

// Memento Object Class
class MementoObjectArtical{
    private String content;
    private int font_size;
    private String font_type;

    public MementoObjectArtical(String c, int fs, String ft){
        content = c;
        font_size = fs;
        font_type = ft;
    }

    public String getContent() {
        return content;
    }
    public int getFont_size() {
        return font_size;
    }
    public String getFont_type() {
        return font_type;
    }
}

class CareTake_of_Artical{
    List<MementoObjectArtical> al = new ArrayList<MementoObjectArtical>();
    public void addMementoObjectArtical(MementoObjectArtical m){
        al.add(m);
    }

    public MementoObjectArtical getMementoObjectArtical(int i){
        return al.get(i);
    }
}

public class memento_dp_ArticalFormatting {
    public static void main(String[] args) {
        OriginatorArtical oa1 = new OriginatorArtical("Learning Memento Design Pattern", 14, "Times New Roman");
        CareTake_of_Artical coa1 = new CareTake_of_Artical();
        
        oa1.printArticalDetails();
        coa1.addMementoObjectArtical(oa1.saveArtical());


    }    
}
