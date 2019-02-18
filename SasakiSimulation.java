import java.util.Random;

public class SasakiSimulation {
    private Node[] arr;
    private int nodes;

    /*
    Constructor: Initialises the line network of nodes
    num = no of nodes in the network
    */
    public SasakiSimulation(int num) {
        nodes = num;
        int i,n;
        Random rand = new Random();
        arr = new Node[num];
        for(i=0; i<num; i++) {
            n = rand.nextInt(num);
            if(i == 0) {
                arr[0] = new Node(n, true);
                arr[0].setArea(-1);
                arr[0].setLeftNode(Integer.MIN_VALUE);
            }
            else if(i == num-1) {
                arr[num-1] = new Node(n, true);
                arr[num-1].setRightNode(Integer.MAX_VALUE);
            }
            else {
                arr[i] = new Node(n, false);
            }
        }
    }

    /*
    Prints the node values along with their area after evaluating the area conditions
    */
    public void printNodes() {
        int i;
        for(i=0; i<nodes; i++) {
            if(arr[i].getArea() == -1) {
                System.out.print(arr[i].getRight().getValue() + "(" + arr[i].getArea() + ") ");
            }
            else {
                System.out.print(arr[i].getLeft().getValue() + "(" + arr[i].getArea() + ") ");
            }
        }
        System.out.println();
    }

    /*
    Prints both the left and right values at a node
     */
    public void printBothNodes() {
        for(int i=0; i<nodes; i++) {
            if(i==0){
                System.out.print(arr[i].getRight().getValue() + "(" + arr[i].getArea() + ") ");
            }
            else if(i==nodes-1) {
                System.out.print(arr[i].getLeft().getValue() + "(" + arr[i].getArea() + ") ");
            }
            else {
                System.out.print(arr[i].getLeft().getValue() + "-" + arr[i].getRight().getValue() + "(" + arr[i].getArea() + ") ");
            }
        }
        System.out.println();
    }

    /*
    Initializes and starts threads.
    Each thread is passed two nodes.
     */
    public void runAlgo() {
        int i;
        System.out.println("Initial Line Network: Value(Area):");
        printNodes();
        System.out.println("********************");

        Process[] threads = new Process[nodes-1];
        for(int j=0; j<nodes-1; j++) {
            for (i = 0; i < nodes - 1; i++) {
                threads[i] = new Process(arr[i], arr[i + 1]);
                threads[i].start();
            }

            /*
            This part of the code waits for all the threads to terminate
             */
            for (i = 0; i < nodes - 1; i++) {
                try {
                    threads[i].join();
                } catch (Exception ex) {
                    System.out.println("Exception in joining threads");
                }
            }
            System.out.println("Round " + (j+1) + ":");
            printBothNodes();
        }
        System.out.println("********************");
        System.out.println("Final answer: Node value(Area):");
        printNodes();
    }
}
