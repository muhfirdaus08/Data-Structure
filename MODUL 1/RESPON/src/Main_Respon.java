//package RESPON.src;
//respon modul 1g
class Node {
    //komponen
    String nama;
    int tinggi, power, temp;
    Node next, prev;

    Node (String nama, int tinggi, int power){
        this.nama = nama;
        this.tinggi = tinggi;
        this.power = power;
    }   
}

public class Main_Respon {

    static Node head, tail, current, newNode, del, after, index = new Node("", 0, 0);

    public static boolean isEmpty(){
        return (head == null);
    }

    //count dll
    static int count_Dll (){
        current = head;
        int jumlah = 0;
        while (current != null){
            jumlah++;
            current = current.next;
        }
        return jumlah;
    }

    //buat dll
    static void make_Dll(String nama, int tinggi, int power){
        head = new Node(nama, tinggi, power);
        head.prev = null;
        head.next = null;
        tail = head;
    }

    //add last dll
    static void add_LastDLL (String nama, int tinggi, int power){
        if (isEmpty()){
            System.out.println("Daftar Player Kosong");
        }else {
            newNode = new Node(nama, tinggi, power);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // add middle dll
    static void add_MiddleDll (String nama, int tinggi, int power, int posisi){
        if (isEmpty()){
            System.out.println("Daftar Player Kosong");
        }else {
            newNode = new Node(nama, tinggi, power);
            if (posisi < 1 || posisi >= count_Dll()){
                System.out.println("Posisi diluar jangkauan\n");
            }else if (posisi == 1){
                System.out.println("Posisi != 1\n");
            }else{
                current = head;
                int number = 1;
                while (number < posisi - 1){
                    current = current.next;
                    number++;
                }
                after = current.next;
                newNode.prev = current;
                newNode.next = after;
                current.next = newNode;
                after.prev = newNode;
            }
        }
    }

    //delete node berdasarkan nama
    static void delete_Player (String nama){
        if (isEmpty()){
            System.out.println("Daftar Player Kosong");
        }else {
            current = head;
            int number = 1;
            while (current.nama != nama){
                current = current.next;
                number++;
            }
            //menghitung kembali hingga mendapatkan number yang memiliki current.nama = nama
            current = head;
            int hitung = 2;
            while (hitung < number){
                current = current.next;
                hitung++;
            }
            del = current.next;
            after = del.next;
            current.next = after;
            after.prev = current;
            del = null;
        }   
    }
    
    //delete last
    static void delete_LastDLL (){
        if (isEmpty()){
            System.out.println("Double Linked List Kosong");
        }else {
            del = tail;
            tail = tail.prev;
            tail.next = null;
            del = null;
        }
    }

    //showround1 berdasarkan tinggi
    static void showround1 (){
        if (isEmpty()){
            System.out.println("Daftar Player Kosong");
        }else {
            current = head;
            while (current != null){
                System.out.print(current.nama+" ("+current.tinggi+") ");
                current = current.next;
                if (current != null){
                    System.out.print("-> ");
                }
            }          
        }
        System.out.println();
    }

    //showround2 berdasarkan power
    static void showround2 (){
        if (isEmpty()){
            System.out.println("Daftar Player Kosong");
        }else {
            current = head;
            while (current != null){
                System.out.print(current.nama+" ("+current.power+"p) ");
                current = current.next;
                if (current != null){
                    System.out.print("-> ");
                }
            }          
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\n--------------------");
        System.out.println("       Round 1      ");
        System.out.println("--------------------");
        System.out.println("Berdasarkan Tinggi\n");
        make_Dll("Kaka", 155, 33);
        add_LastDLL("Kiki", 158, 35);
        add_LastDLL("Joko", 162, 39);
        add_LastDLL("Faris", 167, 41);
        add_LastDLL("Anto", 176, 40);
        add_LastDLL("Dika", 179, 45);
        add_LastDLL("Mukhlis", 180, 50);
        add_LastDLL("Brian", 185, 20);
        Node Oka = new Node("Oka", 150, 57);
        Node Dimas = new Node("Dimas", 154, 42);
        showround1();
        System.out.println("\n--------------------");
        System.out.println("  Round 1 Selesai   ");
        System.out.println("--------------------");
        System.out.println("\nJoko Kram:");
        delete_Player("Joko");
        showround1();
        System.out.println("\n--------------------");
        System.out.println("       Round 2      ");
        System.out.println("--------------------");
        System.out.println("Berdasarkan Power");
        System.out.println("\nDimas masuk:");
        add_MiddleDll(Dimas.nama, Dimas.tinggi, Dimas.power, 4);
        showround2();
        System.out.println("\nBrian Keluar:");
        delete_LastDLL();
        showround2();
        System.out.println("\nOka Masuk:");
        add_LastDLL(Oka.nama, Oka.tinggi, Oka.power);
        showround2();
        System.out.println();
    }
}
