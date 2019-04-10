public class BinaryTreeTestProgram2 {
    public static void main(String[] args) {
        BinaryTree 	tree1, tree2, tree3, tree4, tree5;

        tree1 = new BinaryTree("A",
                new BinaryTree("B",
                        new BinaryTree("C",
                                new BinaryTree("D"),
                                new BinaryTree("E",
                                        new BinaryTree("F",
                                                new BinaryTree("G"),
                                                new BinaryTree("I")),
                                        new BinaryTree("H"))),
                        new BinaryTree("J",
                                new BinaryTree("K",
                                        new BinaryTree(),
                                        new BinaryTree("L",
                                                new BinaryTree(),
                                                new BinaryTree("M"))),
                                new BinaryTree("N",
                                        new BinaryTree(),
                                        new BinaryTree("O")))),
                new BinaryTree("P",
                        new BinaryTree("Q"),
                        new BinaryTree("R",
                                new BinaryTree("S",
                                        new BinaryTree("T"),
                                        new BinaryTree()),
                                new BinaryTree("U"))));
        tree2 = new BinaryTree("A",
                new BinaryTree("B",
                        new BinaryTree("C",
                                new BinaryTree("D"),
                                new BinaryTree("E",
                                        new BinaryTree("F",
                                                new BinaryTree("Z"), //different letter here
                                                new BinaryTree("I")),
                                        new BinaryTree("H"))),
                        new BinaryTree("J",
                                new BinaryTree("K",
                                        new BinaryTree(),
                                        new BinaryTree("L",
                                                new BinaryTree(),
                                                new BinaryTree("M"))),
                                new BinaryTree("N",
                                        new BinaryTree(),
                                        new BinaryTree("O")))),
                new BinaryTree("P",
                        new BinaryTree("Q"),
                        new BinaryTree("R",
                                new BinaryTree("S",
                                        new BinaryTree("T"),
                                        new BinaryTree()),
                                new BinaryTree("U"))));
        tree3 = new BinaryTree("A",
                    new BinaryTree("B",
                        new BinaryTree("C",
                                new BinaryTree("D"),
                                new BinaryTree("E",
                                        new BinaryTree("F",
                                                new BinaryTree("G"),
                                                new BinaryTree("I")),
                                        new BinaryTree("H"))),
                        new BinaryTree()),  // "J" tree removed
                new BinaryTree("P",
                        new BinaryTree("Q"),
                        new BinaryTree("R",
                                new BinaryTree("S",
                                        new BinaryTree("T"),
                                        new BinaryTree()),
                                new BinaryTree("U"))));
        tree4 = new BinaryTree("A",
                new BinaryTree("B",
                        new BinaryTree("C",
                                new BinaryTree("D"),
                                new BinaryTree("E",
                                        new BinaryTree("F",
                                                new BinaryTree("G"),
                                                new BinaryTree("I")),
                                        new BinaryTree("H"))),
                        new BinaryTree("J",
                                new BinaryTree("K",
                                        new BinaryTree(),
                                        new BinaryTree("L",
                                                new BinaryTree(),
                                                new BinaryTree("M"))),
                                new BinaryTree("N",
                                        new BinaryTree(),
                                        new BinaryTree("O")))),
                new BinaryTree("P",
                        new BinaryTree("Q"),
                        new BinaryTree("R",
                                new BinaryTree("S",
                                        new BinaryTree("T"),
                                        new BinaryTree()),
                                new BinaryTree())));  // "U" tree removed
        tree5 = new BinaryTree("A", new BinaryTree(), new BinaryTree()); // only single node tree

        System.out.println("Tree 1 is the same as Tree 1 = " + tree1.isTheSameAs(tree1)); // true
        System.out.println("Tree 1 is the same as Tree 2 = " + tree1.isTheSameAs(tree2)); // false
        System.out.println("Tree 1 is the same as Tree 3 = " + tree1.isTheSameAs(tree3)); // false
        System.out.println("Tree 1 is the same as Tree 4 = " + tree1.isTheSameAs(tree4)); // false
        System.out.println("Tree 1 is the same as Tree 5 = " + tree1.isTheSameAs(tree5)); // false
        System.out.println("Tree 5 is the same as Tree 1 = " + tree5.isTheSameAs(tree1)); // false
        System.out.println("Tree 5 is the same as Tree 5 = " + tree5.isTheSameAs(tree5)); // true

    }
}
