package puzzle;

import java.util.ArrayList;
import java.util.Scanner;

public class Solve {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Enter 8puzzle> ");
        String s = in.nextLine();
        System.out.println(s);

        NodeSet nodes = new NodeSet();

        Node node = new Node("12345678_", "1234567_8");

        nodes.enqueueNode(node);

        nodes.printNodes();;

        //System.out.println("Node " + node.toString() + " has parent " + node.getParent());


    }


}
