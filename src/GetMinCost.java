
class GetMinCost {

    static class Node {

        int key;
        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {

        int getCheapestCost(Node rootNode) {

            Integer min = Integer.MAX_VALUE;
            if(rootNode.children != null && rootNode.children.length > 0){
                for(int i = 0; i < rootNode.children.length; i++){
                    //System.out.println(rootNode.children[i].cost);
                    int temp = getCheapestCost(rootNode.children[i]);
                    //System.out.println("temp: " + temp);
                    if(temp < min) {
                        min = temp;
                    }
                    //min = Math.min(min, getCheapestCost(rootNode.children[i]));
                }
            } else {
                return rootNode.cost;
            }
            return min + rootNode.cost;
        }
    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        Node root = new Node(0);
        root.children = new Node[]{new Node(5), new Node(3), new Node(6)};
        root.children[0].children = new Node[] {new Node(4)};
        root.children[1].children = new Node[] {new Node(2), new Node(0)};
        root.children[1].children[0].children = new Node[] {new Node(1)};
        root.children[1].children[1].children = new Node[] {new Node(10)};
        root.children[2].children = new Node[] {new Node(1), new Node(5)};
        SalesPath minCost = new SalesPath();
        System.out.print(minCost.getCheapestCost(root));
    }
}

