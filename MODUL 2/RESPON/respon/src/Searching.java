import java.util.Currency;

class NodeRespon2 {
    int data;
    NodeRespon2 next, prev;
    NodeRespon2 (int data){
        this.data = data;
    }
}
public class Searching {
    NodeRespon2 head, tail;

    boolean isEmpty(){
        return (head == null);
    }

    void make_Dll (int dataIn){
        head = new NodeRespon2 (dataIn);
        head.prev = null;
        head.next = null;
        tail = head;
    }

    void addLast (int dataIn){
        NodeRespon2 newNode = new NodeRespon2 (dataIn);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    void sequentialSort(int dataIn){
        boolean status = false;
        NodeRespon2 current = head;
        int posisi = 1;
        System.out.println("\nSequential Search");
        while (current != null) {
            if (dataIn == current.data){
                System.out.println("Data "+dataIn+" ditemukan pada posisi : "+posisi);
                status = true;
                return;
            }
            current = current.next;
            posisi++;
        }
        if (status == false){
            System.out.println("Data tidak ditemukan");
        }
    }

    void binarySearch (int dataIn){
        NodeRespon2 low = head;
        NodeRespon2 high = tail;
        NodeRespon2 med = new NodeRespon2 (0);
        boolean status = false;
        System.out.println("\nBinary Search");
        while (low.data <= high.data){
            med.data = (low.data + high.data)/2;
            if (dataIn == med.data){
                System.out.println("Data "+dataIn+" ditemukan");
                status = true;
                break;
            }else {
                if (dataIn > med.data){
                    low.data = med.data + 1;
                }else {
                    high.data = med.data - 1;
                }
            }
        }
        if (status == false){
            System.out.println("Data tidak ditemukan");
        }
    }
 
    void print_Dll (){
        inputData();
        if (isEmpty()){
            System.out.println("Data Kosong");
        }else {
            NodeRespon2 current = head;
            System.out.println("\nDaftar Data");
            while (current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
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
        Searching respon = new Searching ();
        respon.print_Dll();
        respon.binarySearch(8);
        respon.binarySearch(12);
        respon.sequentialSort(2);
        respon.sequentialSort(20);
    }
}