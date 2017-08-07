package puzzle;

import java.util.ArrayList;
import java.util.Scanner;

public class Solve {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Enter start position> ");
        String start = in.nextLine();
        System.out.print("Enter end position> ");
        String end = in.nextLine();


        NodeSet availableNodes = new NodeSet();
        NodeSet visitedNodes = new NodeSet();

        Node root_node = new Node(start, "root");

        availableNodes.enqueueNode(node);

        System.out.println("Node " + node.toString() + " has parent " + node.getParent());
        System.out.println("Has children: ");
        for(int i = 0; i < children.size(); i++){
            System.out.println(children.get(i));
        }

        while(availableNodes.getSize() > 0){
            Node currentNode = availableNodes.dequeueNode();
            ArrayList<String> children = currentNode.getChildren();
            for(int i = 0; i < children.size(); i++){
                if(!visitedNodes.has(children.get(i))){
                    availableNodes.enqueueNode(new Node(children.get(i), ));
                }

            }
        }

        //System.out.println("Node " + node.toString() + " has parent " + node.getParent());
    }




}
