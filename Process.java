// This is the thread class
public class Process extends Thread {
    private Node left;
    private Node right;

    public Process(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    /*
    Send and receive operations are simulated in each object of the thread
     */
    public void run() {
        //Send functions basically get the references to the respective mini nodes
        MiniNode leftMini = left.sendRightNode();
        MiniNode rightMini = right.sendLeftNode();
        int leftValue = leftMini.getValue();
        boolean leftUnique = leftMini.getUnique();
        int rightValue = rightMini.getValue();
        boolean rightUnique = rightMini.getUnique();

        if(leftValue > rightValue) { // left > right (bird's view)
            left.receiveRightNode(rightValue, rightUnique);// This is right mini node of the left node
            right.receiveLeftNode(leftValue, leftUnique);
        }
        else {
            left.receiveRightNode(leftValue, leftUnique);// This is right mini node of the left node
            right.receiveLeftNode(rightValue, rightUnique);
        }
    }
}
