public class Node {
    private MiniNode leftNode;
    private MiniNode rightNode;
    private int area;
    private int numReceives;

    public Node(int value, boolean unique) {
        leftNode = new MiniNode(value, unique);
        rightNode = new MiniNode(value, unique);
    }

    public MiniNode getLeft() {
        return leftNode;
    }
    public MiniNode getRight() {
        return rightNode;
    }
    public int getArea() {
        return area;
    }
    public void setLeftNode(int value) {
        leftNode.setValue(value);
    }
    public void setRightNode(int value) {
        rightNode.setValue(value);
    }

    public void setArea(int area) {
        this.area = area;
    }

    public MiniNode sendLeftNode() {
        return leftNode;
    }
    public MiniNode sendRightNode() {
        return rightNode;
    }

    public void compareandSwap() {
        if(leftNode.getValue() > rightNode.getValue()) {
            MiniNode temp = leftNode;
            leftNode = rightNode;
            rightNode = temp;
        }
    }

    /*
    Node and receives and updates its value based on the conditions in Sasaki's algo
     */
    public void receiveLeftNode(int value, boolean unique) {
        numReceives+=1;

        if(leftNode.getValue() != value) {
            if(unique == true && leftNode.getUnique() == false) {
                area = area-1;
                leftNode.setUnique(unique);
                leftNode.setValue(value);
            }
            else if(unique == false && leftNode.getUnique() == true){
                area = area+1;
                leftNode.setUnique(unique);
                leftNode.setValue(value);
            }
            else {
                leftNode.setUnique(unique);
                leftNode.setValue(value);
            }
        }
        if(numReceives == 2) {
            numReceives = 0;
            compareandSwap();
        }

    }

    /*
    Node and receives and updates its value based on the conditions in Sasaki's algo
     */
    public void receiveRightNode(int value, boolean unique) {
        numReceives+=1;

        if(rightNode.getValue() != value) {
            rightNode.setUnique(unique);
            rightNode.setValue(value);
        }
        if(numReceives == 2) {
            numReceives = 0;
            compareandSwap();
        }
    }
}
