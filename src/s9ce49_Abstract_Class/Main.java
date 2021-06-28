package s9ce49_Abstract_Class;

import s9p133_Abstract_Class_Challenge.MyLinkedList;
import s9p133_Abstract_Class_Challenge.Node;
import s9p133_Abstract_Class_Challenge.SearchTree;

public class Main {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList(null);

        list.traverse(list.getRoot());

        String stringData = "5 7 3 9 8 2 1 0 4 6";

        String[] data = stringData.split(" ");

        for (String s : data) {
            list.addItem(new Node(s));
        }

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
