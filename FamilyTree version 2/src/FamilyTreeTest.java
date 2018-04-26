
public class FamilyTreeTest {

    public static void main(String[] args) {
        String name = Input.getString("input the ancestor's name: ");
         FamilyTree tree = new FamilyTree(name);
        Integer option;
        do {
            System.out.println("0: quit");
            System.out.println("1: add child");
            System.out.println("2: add partner");
            System.out.println("3 display Family Tree");
            System.out.println("3 display Family Tree");

            option = Input.getInteger("input option: ");
            switch (option) {
                case 1:
                    name = Input.getString("input the child's name: ");
                   try{
                        tree.addChild(name);
                    } catch(FamilyTree.ChildNameNotUniqueException e){
                        System.out.println("Child already exists ");
                    } 
                    break;
                case 2: 
                     System.out.println(tree);
                    Integer id = Input.getInteger("Identifier: ");
                      tree.addPartner(id);
                   
                    break;
                case 3:
                    System.out.println(tree);
                    break;
            }
        } while (option != 0);
    }

}
