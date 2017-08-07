package puzzle;

public class Node {

    String node;
    String parent;

    public Node(String node, String parent){
        this.node = node;
        this.parent = parent;
    }

    public String getParent(){
        return this.parent;
    }

    @Override
    public String toString() {
        return node.toString();
    }
}
