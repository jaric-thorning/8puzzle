package puzzle;

import java.util.ArrayList;

public class NodeSet {

    private ArrayList<Node> nodes;

    public NodeSet(){
        nodes = new ArrayList<Node>();
    }

    public void enqueueNode(Node node){
        this.nodes.add(node);
    }

    public Node dequeueNode(){

        if(nodes.size() > 0){
            Node rtn_node = nodes.get(nodes.size() - 1 );
            nodes.remove(nodes.size() - 1);
            return rtn_node;
        } else {
            return null;
        }
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void printNodes(){
        for(int i = 0; i < this.nodes.size(); i++){
            System.out.println(nodes.get(i));
        }
    }

    public int getSize() {
        return nodes.size();
    }

    public boolean has (String node){
        if(this.nodes.contains(node)){
            return true;
        } else {
            return false;
        }
    }
}
