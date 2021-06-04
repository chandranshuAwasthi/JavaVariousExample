package com.chan.newFeature;
public class BinarySearchTree {
    public  static  int count=1;

    class Node {
        int key;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }

        Node left, right;
        public Node(int item) {
            this.key = item;
            left = right = null;
        }
    }

    //Root of BST
    Node root;

    BinarySearchTree() {

    }

// root for BST

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root=new Node(key);
         return  root;
        }
        if (key < root.key) {
         //   System.out.println(root);
            System.out.println(root.left);
           // if(count==1)
            if(root.left==insertRec1(root.left,key)){
                System.out.println("Reassigniable");
            }else{
                root.left=insertRec1(root.left,key);
            }
           // if(count==2)
          //  root.left=insertRec1(root.left,key);
          //  count++;
            //System.out.println(root.left);
          //return  root.left;
        } else if (key > root.key) {
            root.right=insertRec(root.right,key);
           //return  root.right;
        }
        return  root;
    }


    Node insertRec1(Node root, int key) {
        if (root == null) {
            root=new Node(key);
            return  root;
        }
        if (key < root.key) {
            //   System.out.println(root);
            System.out.println(root.left);

            root.left=insertRec2(root.left,key);
            //System.out.println(root.left);
            //return  root.left;
        } else if (key > root.key) {
            root.right=insertRec(root.right,key);
            //return  root.right;
        }
        return  root;
    }

    Node insertRec2(Node root, int key) {
        if (root == null) {
            root=new Node(key);
            return  root;
        }
        if (key < root.key) {
            //   System.out.println(root);
            System.out.println(root.left);

            root.left=insertRec3(root.left,key);
            //System.out.println(root.left);
            //return  root.left;
        } else if (key > root.key) {
            root.right=insertRec(root.right,key);
            //return  root.right;
        }
        return  root;
    }
    Node insertRec3(Node root, int key) {
        if (root == null) {
            root=new Node(key);
            return  root;
        }
       /* if (key < root.key) {
            //   System.out.println(root);
            System.out.println(root.left);

            root.left=insertRec3(root.left,key);
            //System.out.println(root.left);
            //return  root.left;
        } else if (key > root.key) {
            root.right=insertRec(root.right,key);
            //return  root.right;
        }*/
        return  root;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        //binarySearchTree.insert(30);
        binarySearchTree.insert(20);
       // binarySearchTree.insert(40);
        //binarySearchTree.insert(70);
        //binarySearchTree.insert(60);
        //binarySearchTree.insert(80);
        //int value=binarySearchTree.root.right.right.key;
       // System.out.println(binarySearchTree.root.key);


    }
}