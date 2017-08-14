package puzzle;

import java.util.ArrayList;

public class Node {

    String node;
    Node parent;

    public Node(String node, Node parent){
        this.node = node;
        this.parent = parent;
    }

    public Node getParent(){
        return this.parent;
    }

    @Override
    public String toString() {
        return node.toString();
    }

    public ArrayList<String> getChildren() {
        int space_index = 0;

        ArrayList<String> children = new ArrayList<String>();

        char[] array = this.node.toCharArray();
        //System.out.println("Getting children for : " + new String(array));
        for(int i = 0; i < array.length; i++){
            if(array[i] == '_') {
                space_index = i;
            }
        }

        if(space_index - 3 >= 0){
            char[] child = new String(array).toCharArray();
            child[space_index - 3] = array[space_index];
            child[space_index] = array[space_index - 3];
            children.add(new String(child));
        }

        if(space_index + 3 <= 8){
            char[] child = new String(array).toCharArray();
            child[space_index + 3] = array[space_index];
            child[space_index] = array[space_index + 3];
            children.add(new String(child));
        }

        if(space_index == 0 || space_index == 3 || space_index == 6){ //left
            char[] child = new String(array).toCharArray();
            child[space_index + 1] = array[space_index];
            child[space_index] = array[space_index + 1];
            children.add(new String(child));
        }

        if(space_index == 1 || space_index == 4 || space_index == 7){ //middle
            char[] child = new String(array).toCharArray();
            child[space_index + 1] = array[space_index];
            child[space_index] = array[space_index + 1];
            children.add(new String(child));

            child = new String(array).toCharArray();
            child[space_index - 1] = array[space_index];
            child[space_index] = array[space_index - 1];
            children.add(new String(child));

        }

        if(space_index == 2 || space_index == 5 || space_index == 8){ //right
            char[] child = new String(array).toCharArray();
            child[space_index - 1] = array[space_index];
            child[space_index] = array[space_index - 1];
            children.add(new String(child));
        }

        //System.out.println("Found: " + children.toString());
        return children;

    }
}
