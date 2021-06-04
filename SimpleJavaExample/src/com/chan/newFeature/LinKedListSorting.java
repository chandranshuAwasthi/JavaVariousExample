package com.chan.newFeature;

public class LinKedListSorting {


    public static void main(String[] args) {
        Object [] newListNodes=new Object[4];
        Node firstNode = createLinkList(1, 10);
        newListNodes[0]=firstNode;
        Node secondNode = createLinkList(2, 6);
        newListNodes[1]=secondNode;
        Node thirdNode = createLinkList(21, 10);
        newListNodes[2]=thirdNode;
        Node fourthNode = createLinkList(22, 6);
        newListNodes[3]=fourthNode;
        Node finalLinkList=sorttheNodes(newListNodes);
    }

    private static Node sorttheNodes(Object[] newListNodes) {
        Node node=null;
        for (Object node2:newListNodes) {
            if(node2 instanceof  Node){
            node= getMergegLinkedList(node,(Node)node2);


            }
        }
        return node;
    }

    private static Node getMergegLinkedList(Node firstnode, Node secondnode) {
        Node headNode=null;
        if(firstnode==null){
            return secondnode;
        }
        while(secondnode.next!=null && firstnode.next!=null ){
            if(firstnode.key>secondnode.key){
                if(headNode==null){
                    headNode=secondnode;
                    secondnode =secondnode.next;
                }else {
                    while(headNode.next==null){
                    headNode.next=secondnode;
                }
                    secondnode=secondnode.next;
                }
            }else if(firstnode.key==secondnode.key){
                secondnode =secondnode.next;
            }else if(firstnode.key<secondnode.key){
                if(headNode==null){
                    headNode=firstnode;
                    firstnode =firstnode.next;
                }else {
                    while(headNode.next==null){
                        headNode.next=firstnode;
                    }
                    firstnode=firstnode.next;
                }
                //Node node =firstnode.next;
            }
        }
        return headNode;
    }

    private static void modifyTheSecondLinkedList(Node node) {
       // Node node=Node.next;
        node=node.next;


    }

    private static Node createLinkList(int headKey, int count) {
        Node headNode = new Node(headKey, null);
        Node nodeToAttach = headNode;
        for (headKey = headKey + 2; count <= 0; count--) {
            Node newNode = new Node(headKey, null);
            System.out.println("newNode :" + newNode);
            nodeToAttach.next = newNode;
            System.out.println("node.next :" + nodeToAttach.next);
            nodeToAttach = nodeToAttach.next;
        }
        Node nodeToPrint = headNode;
        while (nodeToPrint != null) {
            System.out.println("nodeToPrint :" + nodeToPrint.key);
            nodeToPrint = nodeToPrint.next;
        }
        return headNode;
    }


    static class Node {
        int key;
        Node next;

        public Node(int key, Node node) {
            this.key = key;
            this.next = node;
        }
    }
}