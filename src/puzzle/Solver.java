package puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Solver {

    public Solver(){

    }

    public String[] solve(){
        //int validStart = 0;
        String start = new String();
        String end = new String();


        start = "1348627_5"; //easy


        //start = "281_43765"; //medium

        //start = "281463_75"; //hard


        end = "1238_4765";

        NodeSet availableNodes = new NodeSet();
        NodeSet visitedNodes = new NodeSet();

        Node root_node = new Node(start, null);

        availableNodes.enqueueNode(root_node);


        long start_time = System.nanoTime();
        List<String> path = new ArrayList<>();
        System.out.println("Finding combinations...");
        int counter = 0;
        while(availableNodes.getSize() > 0){
            counter++;
            Node currentNode = availableNodes.dequeueNode();
            if(currentNode.toString().matches(end)){
                System.out.println("Found end node!");

                while(currentNode.getParent() != null){
                    path.add(currentNode.toString());

                    currentNode = currentNode.getParent();
                }
                break;
            }
            visitedNodes.enqueueNode(currentNode);
            //System.out.println(">> Expanding node: " + currentNode.toString());
            ArrayList<String> children = currentNode.getChildren();
            for(int i = 0; i < children.size(); i++){
                Node child_node = new Node(children.get(i), currentNode);
                if(!visitedNodes.has(child_node) && !availableNodes.has(child_node)){
                    //System.out.println("Found new node: " + child_node.toString());
                    availableNodes.enqueueNode(child_node);
                }
            }
        }

        Collections.reverse(path);

        String[] pathStrings = new String[path.size()];
        System.out.println("Path: ");
        for(int i = 0; i < pathStrings.length; i++){
            pathStrings[i] = path.get(i);
            System.out.println("> " + pathStrings[i]);
        }

        System.out.println("Found " + String.valueOf(counter)+ "combinations.");
        System.out.println("Total time: " + String.valueOf((System.nanoTime() - start_time) / 1000000000.0) + "s.");
        //System.out.println("Node " + node.toString() + " has parent " + node.getParent());

        return pathStrings;
    }
}
