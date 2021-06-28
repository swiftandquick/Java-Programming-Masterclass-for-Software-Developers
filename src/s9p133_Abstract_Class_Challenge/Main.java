package s9p133_Abstract_Class_Challenge;

public class Main {

    public static void main(String[] args) {

        /* Instantiate the list with no root.  */
        MyLinkedList list = new MyLinkedList(null);

        /* Get the root of the list by calling getRoot() method from MyLinkedList, get the root by calling the traverse
        method.  */
        list.traverse(list.getRoot());

        /* Canberra is a duplicate, will not be added later on.  */
        String stringData = "5 7 3 9 8 2 1 0 4 6";

        /* Split stringData into an array of String via space.  */
        String[] data = stringData.split(" ");

        /* Add each element (s) of data array into list.  */
        for (String s : data) {
            /* Create an unnamed Node object by passing in s as argument, then Node class calls its superclass
            * (ListItem) to set the value of value (Object type variable).  Then, use list to invoke the addItem()
            * method from MyLinkedList class to add the unnamed Object in the list.  */
            list.addItem(new Node(s));
        }

        /* Try to get the root of list again.  */
        list.traverse(list.getRoot());

        list.removeItem(new Node("3"));
        list.traverse(list.getRoot());

        list.removeItem(new Node("5"));
        list.traverse(list.getRoot());

        list.removeItem(new Node("0"));
        list.removeItem(new Node("4"));
        list.removeItem(new Node("2"));
        list.traverse(list.getRoot());

        list.removeItem(new Node("9"));
        list.traverse(list.getRoot());
        list.removeItem(new Node("8"));
        list.traverse(list.getRoot());
        list.removeItem(new Node("6"));
        list.traverse(list.getRoot());
        list.removeItem(list.getRoot()); // Root is 1, delete 1.
        list.traverse(list.getRoot());
        list.removeItem(list.getRoot()); // Root is 7, delete 7.
        list.traverse(list.getRoot());

        System.out.println("--------------------");

        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        String stringData2 = "5 7 3 9 8 2 1 0 4 6";

        String[] data2 = stringData2.split(" ");
        for(String s : data2) {
            tree.addItem(new Node(s));
        }

        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("3"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("5"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("0"));
        tree.removeItem(new Node("4"));
        tree.removeItem(new Node("2"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("9"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("8"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("6"));
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot());
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot());
        tree.traverse(tree.getRoot());

    }

}
