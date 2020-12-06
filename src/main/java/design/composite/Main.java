package design.composite;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("c 盘");
        BranchNode p1 = new BranchNode("章节 1");
        BranchNode p2 = new BranchNode("章节 2");
        root.add(p1);
        root.add(p2);

        Node q1 = new LeafNode("文章 1");
        Node q2 = new LeafNode("文章 2");
        Node q3 = new LeafNode("文章 3");
        Node q4 = new LeafNode("文章 4");

        p1.add(q1);
        p1.add(q2);
        p2.add(q3);
        p2.add(q4);

        printTree(root, 0);

    }

    private static void printTree(Node root, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        root.p();

        if (root instanceof BranchNode) {
            for (Node node : ((BranchNode) root).nodes) {
                printTree(node, level + 1);
            }
        }
    }
}


abstract class Node {
    abstract public void p();

    String name;

    public Node(String name) {
        this.name = name;
    }
}

class LeafNode extends Node {
    public LeafNode(String name) {
        super(name);
    }

    @Override
    public void p() {
        System.out.println(name);
    }
}

class BranchNode extends Node {

    List<Node> nodes = new ArrayList<>();

    public BranchNode(String name) {
        super(name);
    }

    @Override
    public void p() {
        System.out.println(name);
    }

    public void add(Node node) {
        this.nodes.add(node);
    }
}