//mengimport java util scanner untuk user dapat menginput data secara dinamis
import java.util.Scanner;
//membuat class node yang berisi variabel dan constructor
class Node2 {
    //variabel judul bertipe string dan posisi bertipe int
    //membuat pointer double linkedlist yang terdiri dari next untuk menunjuk setalah dari
    //posisi node sekarang dan prev untuk menunjuk sebelum
    String judul;
    int posisi;
    Node2 next, prev;
    //membuat constructor dengan parameter judul dan posis kemudian
    //akan ditampung ke variabel sebelumnya yang memiliki nama variaber yang sama 
    //dengan kata kunci this 
    Node2 (String judul, int posisi){
        this.judul = judul;
        this.posisi = posisi;
    }   
}
//membuat class jurnal_nomor2 untuk menampung fungsi-fungsi dalam double linked list 
//termasuk fungsi main untuk menjalankan program
public class jurnal_nomor2 {
    //membuat objek head dan tail 
    Node2 head, tail; 
    //membuat fungsi boolean bernama isEmpty untuk mengecek apakah head tidak 
    //terdapat data atau tidak yang akan mereturn true atau false
    public boolean isEmpty(){
        return (head == null);
    }

    //membuat fungsi count_DLL untuk menghitung jumlah node double linkedlist 
    //dimulai dari head (ditunjuk oleh current)
    int count_Dll (){
        //membaut object current yang disetting sama denga head
        Node2 current = head;
        //membuat variabel jumlah dengan setting awalan sama dengan 0
        int jumlah = 0;
        //membuat while looping selama current tidak bernilai null maka yang diddalamnya akan terus dijalankan
        while (current != null){
            //variabel jumlah akan terus ditambah satu selama kondisi while menenuhi
            jumlah++;
            //posisi current akan diubah ke posisi current selanjutnya (bergeser ke depan) selama kondisi while memenuhi
            current = current.next;
        }
        //mereturn nilai variabel count dari fungsi count_SLL
        return jumlah;
    }
    //membuat fungsi void (tanpa nilai kembali) addFirst_Judul dengan 
    //parameter judul dan posisi yang akan digunakan untuk pertama kali 
    //dalam membuat linkedlist
    void addFirst_Judul(String judul, int posisi){
        //objec head akan diisi dengan parameter yang 
        //akan menunjuk ke constructor pada class Node
        head = new Node2(judul, posisi);
        //karena ini kepalanya dan data pertama dari linkedlist 
        //maka prev dan next dari kepala akan diset null
        head.prev = null;
        head.next = null;
        //dan sebagai node awal dan satu satunya maka head 
        //juga merupakan tail dari linkedlist
        tail = head;
    }

    //membuat fungsi void (tanpa nilai kembali) addFirst_Judul dengan parameter 
    //judul dan posisi yang akan digunakan untuk menambah node 
    //dari belakang sehingga node yang terakhir dibuat akan menjadi tail
    void addLast_Judul (String judul, int posisi){
        //membuat kondisi jika kosong maka akan mengeprint "Novel Kosong"
        if (isEmpty()){
            System.out.println("Novel Kosong");
        }else {
            //objec newNode akan diisi dengan String judul dan int posisi
            // yang akan menunjuk ke constructor pada class Node1
            Node2 newNode = new Node2(judul, posisi);
            //karena ini akan menjadi tail maka prev dari newNode diset tail
            tail.next = newNode;
             //kemudian next dari tail akan diset newNode
            newNode.prev = tail;
            //dan tail akan diset newNode karena ini merupakan penambahan di tail (ujung terakhir linkedlist)
            tail = newNode;
        }
    }

    //membuat fungsi sequential search untuk mencari judul nover dengan parameter judulindput
    //bertipe string
    void sequentialSort(String judulInput){
        //membaut variabel status diset false untuk menentukan judul yang dicari ketumu atau tidak
        boolean status = false;
        //membuat object current diset head
        Node2 current = head;
        //melakukan perulangan selama current tidak sama dengan null
        while (current != null) {
            //maka juka judul input sama dengan current judul tanpa menghiraukan huruf besar atau kecil
            if (judulInput.equalsIgnoreCase(current.judul)){
                //maka akan dicetak judul ditemukan beserta posisinya 
                System.out.println("\nJudul ditemukan pada posisi : "+current.posisi+"\n");
                //set status jadi true dan return
                status = true;
                return;
            }
            current = current.next;
        }
        //jika status false maka print tidak ditemukan
        if (status == false){
            System.out.println("\nJudul tidak ditemukan\n");
        }
    }

    //membuat fungsi binary search untuk mencari judul novel yang dicari
    void binarySearch (String judulInput){
        //membuat object low yang diset ke head
        Node2 low = head;
        //membuat object high yang diset ke tail
        Node2 high = tail;
        //membuat object med yang akan menampung median dari hasil pembagian low dan high 
        Node2 med = new Node2 ("",0);
        //membaut variabel status diset false untuk menentukan judul yang dicari ketumu atau tidak
        boolean status = false;
        //selama low posisi kurang dari sama dengan high posisi mkaka
        while (low.posisi <= high.posisi){
            //lakukan perhitungan median posisi
            med.posisi = (low.posisi + high.posisi)/2;
            //jikan meduan judul sama dengan input judul maka print ditemukan
            if (judulInput.equalsIgnoreCase(med.judul)){
                System.out.println("\nJudul ditemukan pada posisi : "+med.posisi+"\n");
                status = true;
                break;
            }else {
                if (judulInput.compareTo(med.judul) > 0){
                    low.posisi = med.posisi + 1;
                }else {
                    high.posisi = med.posisi - 1;
                }
            }
        }
        if (status == false){
            System.out.println("\nJudul tidak ditemukan\n");
        }
    }

    void printJudul (){
        inputData();
        if (isEmpty()){
            System.out.println("Novel Kosong");
        }else {
            Node2 current = head;
            while (current != null){
                System.out.print(current.posisi+". "+current.judul);
                current = current.next;
                System.out.println();
            }          
        }
        System.out.println();
    }

    void inputData (){
        addFirst_Judul("Suratan si Tangan Kecil", 1);
        addLast_Judul("Dibalik Dua Hati",2);
        addLast_Judul("Air Mata Bahagia",3);
        addLast_Judul("Apakah Ia Mengerti?",4);
        addLast_Judul("Senyuman Pujaan",5);
        addLast_Judul("Seorang Bidadari",6);
        addLast_Judul("Cakrawala Petualang",7);
        addLast_Judul("Kodingan Cinta",8);
        addLast_Judul("Lihatlah yang di Bawah",9);
        addLast_Judul("Menyerah atau Kalah?",10);
        addLast_Judul("Berjuang Walau Tertebas Pedang",11);
        addLast_Judul("Teman Tak Tergantikan",12);
        addLast_Judul("Lawakan Pinggiran Kota",13);
        addLast_Judul("Samudera Perjuangan",14);
        addLast_Judul("Mahasiswa Kocak",15);
        addLast_Judul("Jangan Tersandung Kerikil",16);
        addLast_Judul("Butiran Semangat ",17);
        addLast_Judul("Embun Kemenangan",18);
    }

    void menu(){
        Scanner input = new Scanner (System.in);
        System.out.println("Pilihan Algoritma Pencarian");
        System.out.println("1. Sequential Search");
        System.out.println("2. Binary Search");
        System.out.println("3. Exit");
        System.out.print("Masukan pilihan : ");
        int pilihan = 0;
        pilihan = input.nextInt();
        
        switch (pilihan) {
            case 1 :
                Scanner input2 = new Scanner (System.in);
                System.out.print("Masukan judul buku yg dicari : ");
                String judulInputSequen = input2.nextLine();
                sequentialSort(judulInputSequen);
                menu();
                break;
            case 2 :
                Scanner input3 = new Scanner (System.in);
                System.out.print("Masukan judul buku yg dicari : ");
                String judulInputBinary = input3.nextLine();
                binarySearch(judulInputBinary);
                menu();
                break;
            case 3 :
                System.out.println("Bye");
                System.exit(0);
                break;
            default :
                System.out.println("\nPiih ulang\n");
                menu();
                break;
        }
    }
    public static void main(String[] args) {
        
        jurnal_nomor2 dua = new jurnal_nomor2();

        System.out.println("Daftar Novel");
        dua.printJudul();

        dua.menu();
    }
}
