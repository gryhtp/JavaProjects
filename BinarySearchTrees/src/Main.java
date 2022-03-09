public class Main {
    public static void main(String[] args) {
        Tree myTree = new Tree();

        myTree.insert(25);
        myTree.insert(20);
        myTree.insert(15);
        myTree.insert(17);
        myTree.insert(27);
        myTree.insert(30);
        myTree.insert(29);
        myTree.insert(26);
        myTree.insert(22);
        myTree.insert(32);

        myTree.traverseInOrder();
        System.out.println();
        System.out.println("Data = " + myTree.get(30).getData());
        System.out.println("Data = " + myTree.get(333));

        System.out.println(myTree.min());
        System.out.println(myTree.max());

        myTree.delete(22);
        myTree.delete(30);
        myTree.traverseInOrder();
        System.out.println();
        myTree.traversePreOrder();
        System.out.println();
        myTree.traversePostOrder();
    }
}
