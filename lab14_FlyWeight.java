import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class TreeFlyWeight{
    String type;
    String color;

    public TreeFlyWeight(String t, String c){
        type = t;
        color = c;
    }
}

class Tree{
    // String type;
    // String color;
    TreeFlyWeight tf;
    int x;
    int y;
    // public Tree(String t, String c, int x, int y){
    public Tree(TreeFlyWeight t, int x, int y){
        System.out.println("Tree Object created!!!");
        // type = t;
        // color = c;
        tf = t;
        this.x = x;
        this.y = y;
    }

    public void plantTree(int x, int y){
        this.x = x;
        this.y = y;
        System.out.println("Tree type - "+tf.type+" planted at (x, y) : ("+x+", "+y+")");
    }

}

class TreeFactory{
    Map<String, TreeFlyWeight> mp = new HashMap<String, TreeFlyWeight>();
    TreeFlyWeight tf = null;
    public TreeFlyWeight createTree(String type){
        if(mp.containsKey(type))
            tf = mp.get(type);
        else{
            if(type.equalsIgnoreCase("Neem-Tree")){
                tf = new TreeFlyWeight("Neem-Tree", "Green");
            } else if(type.equalsIgnoreCase("Oak-Tree")){
                tf = new TreeFlyWeight("Oak-Tree", "Orange");
            } else{
                System.out.println("Tree-type not available");
            }
            mp.put(type, tf);
        }
        return tf;
    }
}

public class lab14_FlyWeight {
    public static void main(String[] args) {
        // for loop for N times
        TreeFactory factory = new TreeFactory();
        List<Tree> forest = new ArrayList<Tree>();
        String[] treelist = new String[] {"Neem-tree", "Oak-tree"};
        Random random = new Random();
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter number of Tree you want");
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            TreeFlyWeight tfw = factory.createTree(treelist[random.nextInt(treelist.length)]);
            int a =random.nextInt(5);
            int b =random.nextInt(5);
            Tree tree = new Tree(tfw, a, b);
            tree.plantTree(a, b);
            forest.add(tree);

        }
    }
}
