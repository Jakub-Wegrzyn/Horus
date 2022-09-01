import java.util.*;

public class Wall implements Structure, CompositeBlock {
    private static List blocks = Arrays.asList("Square", "Rectangle", "Circle", "Triangle", "Pentagon");
    private static List colors = Arrays.asList("Red", "Blue");
    private static List materials = Arrays.asList("Wood", "Marble", "Iron", "Copper");
    private static ArrayList<Wall> list_of_objects = new ArrayList<>();
    private String block;
    private String color;
    private String material;

    Wall(String block, String color, String material){
        this.block = block;
        this.color = color;
        this.material = material;
    }
    Wall(ArrayList<Wall> list_of_objects){
        this.list_of_objects = list_of_objects;
    }

    public static void main(String[] args) {
        Wall object = new Wall(createAllObjects());
        System.out.println("Welcome");

        System.out.println("How many objects?: " + object.count() +"\n");

        System.out.println("------------------------------------------------------------------------");
        System.out.println("These are all objects: ");
        printresult(object.list_of_objects);

        System.out.println("------------------------------------------------------------------------");
        List<Wall> list;
        String materialtoserch;
        materialtoserch = "Wood";
        list = object.findBlocksByMaterial(materialtoserch);
        System.out.println("Material to search: " + materialtoserch);
        printresult(list);

        System.out.println("------------------------------------------------------------------------");
        List<Wall> anotherlist;
        String colortosearch;
        colortosearch = "Red";
        anotherlist = (List<Wall>) object.findBlockByColor(colortosearch).get();
        System.out.println("Color to search: " + colortosearch);
        printresult(anotherlist);

    }


    @Override
    public Optional findBlockByColor(String color) {
        List listresult = new ArrayList();
        for (Wall obj : list_of_objects) {
            if(obj.getColor().equals(color)) {
                listresult.add(obj);
                break;
            }
        }
        return Optional.ofNullable(listresult);
    }

    @Override
    public List findBlocksByMaterial(String material) {
        List listresult = new ArrayList<>();
        for (Wall obj : list_of_objects) {
            if(obj.getMaterial().equals(material)){
                listresult.add(obj);
                continue;
            }
        }
        return listresult;
    }

    @Override
    public int count() {
        int count = getBlocks().size();
        return count;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public List getBlocks() {
        return blocks;
    }

    public static ArrayList createAllObjects(){
        for(int i = 0; i< blocks.size();i++){
            int k = i;
            Random rand = new Random(); //color random
            if(i > 3){
                k = 0; // like conveyor belt
            }
            Wall object = new Wall((String) blocks.get(i), (String) colors.get(rand.nextInt(colors.size())), (String) materials.get(k));
            list_of_objects.add(object);
        }
        return list_of_objects;
    }

    public static void printresult(List<Wall> list){
        for(Wall w : list){
            System.out.println("Block: " + w.block);
            System.out.println("Color: " + w.color);
            System.out.println("Material: " + w.material);
            System.out.println("");
        }
    }

}

