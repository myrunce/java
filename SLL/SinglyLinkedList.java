public class SinglyLinkedList{
    public Node head;

    public SinglyLinkedList(){
        this.head = null;
    }

    public void add(int num){
        Node newNode = new Node(num);

        if (head == null){
            head = newNode;
        }
        else{
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public void remove() {
        Node runner = this.head;
        
        if (head == null) {
            System.out.println("There are no nodes in the SLL");
        } 
        else if(head.next == null) {
            head = null;
        } 
        else {
            while(runner.next.next != null) {
                runner = runner.next;
            }
            runner.next = null;
        }
    }

    public void printValues() {
        Node runner = this.head;

        if(runner == null) {
            System.out.println("There are no nodes in the SLL");
        } else {
            while(runner != null) {
                System.out.println(runner.value);
                runner = runner.next;
            }
        }
    }
}