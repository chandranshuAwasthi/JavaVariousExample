package com.chan.newFeature;

public class BinarySearchTreeSecond {
    Node node;

    static  class Node{
        int key;
        Node leftNode ;
        Node rightNode;

        public Node(int key) {
            this.key = key;
        }
    }

    Node insertRecord(int key) {
        if(node==null){
            node=new Node(key);
            return node;
        }
        Node node2=node;
        Node nodeToAppend=null;
     //  String value=null;
        while (node2 != null) {
            if (node2.key > key) {
                nodeToAppend=node2;
                node2=node2.leftNode;

            } else if (node2.key < key) {
                nodeToAppend=node2;
                node2=node2.rightNode;
            }
        }
        if(nodeToAppend.key>key){
            nodeToAppend.leftNode=new Node(key);
        }else{
            nodeToAppend.rightNode=new Node(key);
        }

        return node;
    }


    public static void main(String[] args) {
        BinarySearchTreeSecond binarySearchTree=new BinarySearchTreeSecond();
        binarySearchTree.insertRecord(50);
        binarySearchTree.insertRecord(30);
        //binarySearchTree.insert(30);
        binarySearchTree.insertRecord(20);
         binarySearchTree.insertRecord(40);
        binarySearchTree.insertRecord(70);
        binarySearchTree.insertRecord(60);
        binarySearchTree.insertRecord(80);
        int value=binarySearchTree.node.rightNode.rightNode.key;
         System.out.println(binarySearchTree.node.key);


    }
}









