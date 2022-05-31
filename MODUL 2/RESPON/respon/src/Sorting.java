class NodeRespon {
    int data;
    NodeRespon next, prev;
    NodeRespon (int data){
        this.data = data;
    }
}
public class Sorting {
    NodeRespon head, tail;

    boolean isEmpty(){
        return (head == null);
    }

    void make_Dll (int dataIn){
        head = new NodeRespon (dataIn);
        head.prev = null;
        head.next = null;
        tail = head;
    }

    void addLast (int dataIn){
        NodeRespon newNode = new NodeRespon (dataIn);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    void Bubble_Sort (){
        inputData();
        NodeRespon current = head;
        if (isEmpty()){
            return;
        }else {
            while (current != null){
                NodeRespon index = current.next;
                while (index != null){
                    if (current.data > index.data){
                        int temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    void Selection_Sort (){
        inputData();
        NodeRespon current = head;
        int temp;
        if (isEmpty()){
            return;
        }       
        else {
            while (current != null){
                NodeRespon index_min = current;
                NodeRespon index_pointer = current.next;
                while (index_pointer != null){
                    if (index_pointer.data < index_min.data){
                        index_min = index_pointer;             
                    }
                    index_pointer = index_pointer.next;
                }
                temp = current.data;
                current.data = index_min.data;
                index_min.data = temp;

                current = current.next;
            }
        }
    }

    NodeRespon sortedInsert(NodeRespon head, NodeRespon newNode){
        NodeRespon current;
        if (head == null){
            head = newNode;
        }        
        else if ((head).data >= newNode.data){
            newNode.next = head;
            newNode.next.prev = newNode;
            head = newNode;
        }
        else{
            current = head;
            while (current.next != null && current.next.data < newNode.data){
                current = current.next;  
                newNode.next = current.next;
            }   
            if (current.next != null){
                newNode.next.prev = newNode;            
            }
            current.next = newNode;
            newNode.prev = current;               
        }
        return head;
    }

    void Insertion_Sort(){
        NodeRespon sorted = null;
        NodeRespon current = head;
        while (current != null){
            NodeRespon next = current.next;
            current.prev = current.next = null;  
            sorted = sortedInsert(sorted, current);  
            current = next;
        }
        head = sorted;
    }
 
    void print_DllUnsorted (){
        inputData();
        if (isEmpty()){
            System.out.println("Data Kosong");
        }else {
            NodeRespon current = head;
            System.out.println("\nUnsorted");
            while (current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    void print_DllBubble (){
        Bubble_Sort();
        if (isEmpty()){
            System.out.println("Data Kosong");
        }else {
            NodeRespon current = head;
            System.out.println("\n\nBubble Sort");
            while (current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    void print_DllSelection (){
        Selection_Sort();
        if (isEmpty()){
            System.out.println("Data Kosong");
        }else {
            NodeRespon current = head;
            System.out.println("\n\nSelection Sort");
            while (current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    void print_DllInsert (){
        Insertion_Sort();
        if (isEmpty()){
            System.out.println("Data Kosong");
        }else {
            NodeRespon current = head;
            System.out.println("\n\nInsertion Sort");
            while (current != null){          
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println("\n");
        }
    }

    void inputData (){
        make_Dll(5);
        addLast(1);
        addLast(4);
        addLast(2);
        addLast(7);
        addLast(6);
        addLast(8);
        addLast(3);
        addLast(9);
    }

    public static void main(String[] args) throws Exception {
        Sorting respon = new Sorting ();
        respon.print_DllUnsorted();
        respon.print_DllBubble();
        respon.print_DllSelection();
        respon.print_DllInsert();
    }
}
