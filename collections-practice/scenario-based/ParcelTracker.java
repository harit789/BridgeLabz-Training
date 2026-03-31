
public class ParcelTracker {
	 
    class Node {
        String stageName;
        Node next;

        public Node(String stageName) {
            this.stageName = stageName;
            this.next = null;
        }
    }

    private Node head;

    public void initialize() {
        head = new Node("Packed");
        head.next = new Node("Shipped");
        head.next.next = new Node("In Transit");
        head.next.next.next = new Node("Delivered");
    }


    public void trackParcel() {
        Node curr = head;

        if (curr == null) {
            System.out.println("No parcel data available");
            return;
        }

        while (curr != null) {
            System.out.println(curr.stageName);
            curr = curr.next;
        }
    }

    
    public void addCheckPoints(String afterStage, String newStage) {
        Node curr = head;

        if (curr == null) {
            System.out.println("Parcel missing");
            return;
        }

        while (curr != null) {
            if (curr.stageName.equals(afterStage)) {

                Node newNode = new Node(newStage);

                newNode.next = curr.next;
                curr.next = newNode;

                System.out.println("Checkpoint added: " + newStage);
                return;
            }
            curr = curr.next;
        }

        System.out.println("Stage not found: " + afterStage);
    }

    public void detectLoss() {
        Node curr = head;

        if (curr == null) {
            System.out.println("Parcel completely missing");
            return;
        }

        while (curr != null) {
            if (curr.next == null && !curr.stageName.equals("Delivered")) {
                System.out.println("Parcel lost after: " + curr.stageName);
                return;
            }
            curr = curr.next;
        }

        System.out.println("Parcel delivered successfully");
    }
}
