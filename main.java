import java.util.Scanner;
public class main {

    public static void main(String[] args ) {
        int selection = 10000;
        Scanner sc = new Scanner(System.in);

        DSABinarySearchTree bSearchTree = new DSABinarySearchTree();

        while(selection != 0) {
            System.out.println("Select testing:");
            System.out.println("1. Add node\n2. Delete node\n3. Display tree\n4. Add node automatically");

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
                    autoadding(sc, bSearchTree);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong selection");
            }
        }
    
        sc.close();
    }

    public static void adding(Scanner sc, DSABinarySearchTree bSearchTree) {
        System.out.println("Add a node below. Format is <key,value>");
        String input;
        String regex = "[,\\.\\s]";
        input = sc.nextLine();
        String[] arr = input.split(regex);
        bSearchTree.insert(arr[0], arr[1]);
    }

    public static void deleting(Scanner sc, DSABinarySearchTree bSearchTree) {
        System.out.println("Remove a node below. Format is <key>");
        String input;
        input = sc.nextLine();
        bSearchTree.delete(input);
    }

    public static void displaying(Scanner sc, DSABinarySearchTree bSearchTree) {
        int sel = 10000;
        while(sel != 0) {
            System.out.println("1. In-order traversal\n2. Pre-order traversal\n3. Post-order traversal");

            sel = sc.nextInt();
            switch(sel) {
                case 1:
                    bSearchTree.inOrder();
                    break;
                case 2:
                    bSearchTree.preOrder();
                    break;
                case 3:
                    bSearchTree.postOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong selection");
            }
        }
    }

    public static void autoadding(Scanner sc, DSABinarySearchTree bSearchTree) {
        System.out.println("Put number of node: ");
        int input = sc.nextInt();
        for(int i = 0; i < input; i++) {
            bSearchTree.insert("node" + i+1, i+1);
        }
    }
}

