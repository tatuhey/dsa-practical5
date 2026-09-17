import java.util.*;

public class main {

    public static void main(String[] args ) {
        int selection = 10000;
        Scanner sc = new Scanner(System.in);

        DSABinarySearchTree bSearchTree = new DSABinarySearchTree();

        while(selection != 0) {
            System.out.println("Select testing:");
            System.out.println("1. Add node\n2. Delete node\n3. Display tree\n4. Build fixed-tree\n5. Find node\n6. Min\n7. Max\n8. Tree height\n9. Balance percentage\n0. Exit");

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
                    case 5:
                        finding(sc, bSearchTree);
                        break;
                    case 6:
                        minimum(sc, bSearchTree);
                        break;
                    case 7:
                        maximum(sc, bSearchTree);
                        break;
                    case 8:
                        treeHeight(sc, bSearchTree);
                        break;
                    case 9:
                        balancing(sc, bSearchTree);
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
                
            } catch (NoSuchElementException e2) {
                System.out.println(e2);
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
        try {
            bSearchTree.insert(arr[0].trim(), arr[1].trim()); // trim() to remove whitespaces around
        } catch (IllegalArgumentException e) {
            System.out.println(e + ". Try again");
        }
        
    }

    public static void deleting(Scanner sc, DSABinarySearchTree bSearchTree) {
        sc.nextLine(); // to clear the leftover newline from the previous menu choice

        System.out.println("Remove a node below. Format is <key>");
        String input;
        input = sc.nextLine();
        // if(input == null) {
        //     System.out.println("Input is empty");
        //     return;
        // } else
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
        System.out.println("      40\n  20      60\n10  30  50  70\nkey format as follow: 40");
        bSearchTree.insert("40",40);
        bSearchTree.insert("20", 20);
        bSearchTree.insert("60", 60);
        bSearchTree.insert("10", 10);
        bSearchTree.insert("30", 30);
        bSearchTree.insert("50", 50);
        bSearchTree.insert("70", 70);

    }

    public static void finding(Scanner sc, DSABinarySearchTree bSearchTree) {
        sc.nextLine(); // to clear the leftover newline from the previous menu choice

        System.out.println("Find a node below. Format is <key>");
        String input;
        input = sc.nextLine();
        System.out.println(bSearchTree.find(input));
    }

    public static void minimum(Scanner sc, DSABinarySearchTree bSearchTree) {
        System.out.println(bSearchTree.min() + " is the smallest node");
    }

    public static void maximum(Scanner sc, DSABinarySearchTree bSearchTree) {
        System.out.println(bSearchTree.max() + " is the biggest node");
    }

    public static void treeHeight(Scanner sc, DSABinarySearchTree bSearchTree) {
        System.out.println("The height is: " + bSearchTree.height());
    }

    public static void balancing(Scanner sc, DSABinarySearchTree bSearchTree) {
        bSearchTree.balance();
    }
}


