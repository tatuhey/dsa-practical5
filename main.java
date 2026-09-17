import java.util.InputMismatchException;
import java.util.Scanner;
public class main {

    public static void main(String[] args ) {
        int selection = 10000;
        Scanner sc = new Scanner(System.in);

        DSABinarySearchTree bSearchTree = new DSABinarySearchTree();

        while(selection != 0) {
            System.out.println("Select testing:");
            System.out.println("1. Add node\n2. Delete node\n3. Display tree\n4. Build fixed-tree\n0. Exit");

            try{
                selection = sc.nextInt();
                switch(selection) {
                    case 1:
                        adding(sc, bSearchTree);
                        break;
                    case 2:
                        deleting(sc, bSearchTree);
                        break;
                    case 3:
                        displaying(sc, bSearchTree);
                        break;
                    case 4:
                        build(sc, bSearchTree);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Wrong selection");
                }
            } catch (InputMismatchException e) {
                selection = 10000;
                sc.nextLine();
                System.out.println(e + ". Please input selection properly.");
                
            }
        }
    
        sc.close();
    }

    public static void adding(Scanner sc, DSABinarySearchTree bSearchTree) {
        sc.nextLine(); // to clear the leftover newline from the previous menu choice

        System.out.println("Add a node below. Format is <key,value>");
        String input = sc.nextLine();
        String[] arr = input.split(",");
        if(arr.length != 2) {
            System.out.println("Invalid format. Format is <key,value>");
            return;
        }
        bSearchTree.insert(arr[0].trim(), arr[1].trim()); // trim() to remove whitespaces around
    }

    public static void deleting(Scanner sc, DSABinarySearchTree bSearchTree) {
        sc.nextLine(); // to clear the leftover newline from the previous menu choice

        System.out.println("Remove a node below. Format is <key>");
        String input;
        input = sc.nextLine();
        bSearchTree.delete(input);
    }

    public static void displaying(Scanner sc, DSABinarySearchTree bSearchTree) {
        sc.nextLine(); // to clear the leftover newline from the previous menu choice

        int sel = 10000;
        while(sel != 0) {
            System.out.println("1. In-order traversal\n2. Pre-order traversal\n3. Post-order traversal\n0. exit");

            try{
                sel = sc.nextInt();
                switch(sel) {
                    case 1:
                        System.out.println("In-order selected");
                        bSearchTree.inOrder();
                        break;
                    case 2:
                        System.out.println("Pre-order selected");
                        bSearchTree.preOrder();
                        break;
                    case 3:
                        System.out.println("Post-order selected.");
                        bSearchTree.postOrder();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Wrong selection");
                }
            } catch (InputMismatchException e) {
                sel = 10000;
                sc.nextLine();
                System.out.println(e + ". Please input selection properly.");
            }
            
        }
    }

    public static void build(Scanner sc, DSABinarySearchTree bSearchTree) {
        System.out.println("The tree will look as below.");
        System.out.println("      70\n  30      50\n10  20  40  60");
        bSearchTree.buildFixedTree();
    }

}


