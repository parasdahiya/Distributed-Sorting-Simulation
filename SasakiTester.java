public class SasakiTester {
    public static void main(String[] args) {
        if(args.length == 0) {
            int num = 5;
        }
        else {
            int num = Integer.parseInt(args[0]);
        }
        SasakiSimulation sim = new SasakiSimulation(5);
        sim.runAlgo();
    }
}