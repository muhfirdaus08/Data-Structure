//membuat class node yang berisi variabel dan constructor
class Node {
    //variabel nama bertipe string sedangkan variabel tinggi dan power bertipe int
    //membuat pointer double linkedlist yang terdiri dari next untuk menunjuk setalah dari
    //posisi node sekarang dan prev untuk menunjuk sebelum
    String nama;
    int tinggi, power;
    Node next, prev;
    //membuat constructor dengan parameter nama, tinggi dan power kemudian
    //akan ditampung ke variabel sebelumnya yang memiliki nama variaber yang sama 
    //dengan kata kunci this 
    Node (String nama, int tinggi, int power){
        this.nama = nama;
        this.tinggi = tinggi;
        this.power = power;
    }   
}

//membuat class jurnal_nomor1 untuk menampung fungsi-fungsi dalam double linked list 
//termasuk fungsi main untuk menjalankan program
public class jurnal_nomor1 {
    //membuat objek head dan tail 
    Node head, tail;

    //membuat fungsi boolean bernama isEmpty untuk mengecek apakah head tidak 
    //terdapat data atau tidak yang akan mereturn true atau false
    boolean isEmpty(){
        return (head == null);
    }
    
    //membuat fungsi void (tanpa nilai kembali) addFirst_Pemain dengan 
    //parameter nama, tinggi dan power yang akan digunakan untuk pertama kali 
    //dalam membuat linkedlist
    void addFirst_Pemain(String nama, int tinggi, int power){
        //objec head akan diisi dengan parameter yang 
        //akan menunjuk ke constructor pada class Node
        head = new Node(nama, tinggi, power);
        //karena ini kepalanya dan data pertama dari linkedlist 
        //maka prev dan next dari kepala akan diset null
        head.prev = null;
        head.next = null;
        //dan sebagai node awal dan satu satunya maka head 
        //juga merupakan tail dari linkedlist
        tail = head;
    }

    //membuat fungsi void (tanpa nilai kembali) addLast_Pemain dengan parameter 
    //nama, tinggi dan power yang akan digunakan untuk menambah node 
    //dari belakang sehingga node yang terakhir dibuat akan menjadi tail
    void addLast_Pemain (String nama, int tinggi, int power){
        //membuat kondisi jika kosong maka akan mengeprint "Daftar Player Kosong"
        if (isEmpty()){
            System.out.println("Daftar Player Kosong");
        //membaut kondisi lain jika kondisi diatas tidak terpenuhi maka akan dieksekusi kondisi ini
        }else {
            //objec newNode akan diisi dengan nama, tinggi dan power yang akan menunjuk ke constructor pada class Node1
            Node newNode = new Node(nama, tinggi, power);
            //karena ini akan menjadi tail maka prev dari newNode diset tail
            tail.next = newNode;
            //kemudian next dari tail akan diset newNode
            newNode.prev = tail;
            //dan tail akan diset newNode karena ini merupakan penambahan di tail (ujung terakhir linkedlist)
            tail = newNode;
        }
    }

    //membuat fungsi bubble sort untuk mengurutkan nama berdasarkan abjad (sesuai urutan absen)
    //dilakukan secara acending
    void bubbleSort (){
        //memanggil fungsi inputData
        inputData();
        //membuat objec current yang diset sama dengan head
        Node current = head;
        //membuat variabel tampungan untuk membantu proses pertukaran nilai pada saat
        //melakukan peungurutan
        String tempNama;
        int tempTinggi, tempPower;
        //mengecek jika linkedlist kosong maka akan return/keluar dari fungsi bubblesort
        if (isEmpty()){
            return;
        }
        //jika linkedlist tidak kosong maka
        else {
            //akan dilakukan perulangan dengan menggunakan while
            //dimana selama current tidak sama dengan null
            while(current != null){
                //membuat objec index_min yang diset sama dengan current.next sebagai pointer
                //saat membandingkan dua data
                Node index_min = current.next;
                //selama index_min tidak sama dengan null maka
                while (index_min != null){
                    //jika huruf pertama pada current nama lebih besar dari huruf
                    //pertama pada index nama maka
                    if (current.nama.charAt(0) > index_min.nama.charAt(0)){
                        //akan dilakukan penukaran posisi nama sesuai dengan urutan huruf pertama pada nama
                        tempNama = current.nama;
                        current.nama = index_min.nama;
                        index_min.nama = tempNama;

                        //karena terjadi penukaran nama maka tinggi pemain juga
                        //harus ditukar agar mengikuti pergantian nama
                        tempTinggi = current.tinggi;
                        current.tinggi = index_min.tinggi;
                        index_min.tinggi = tempTinggi;

                        //kemudian karena terjadi penukaran nama maka power pemain juga
                        //harus ditukar agar mengikuti pergantian nama
                        tempPower = current.power;
                        current.power = index_min.power;
                        index_min.power = tempPower;
                    }
                    //index_min diset ke index_min selanjutnya agar terjadi perpindahan node
                    index_min = index_min.next;
                }          
                //current diset ke current selanjutnya agar terjadi perpindahan node    
                current = current.next;
            }
        }
    }

    //membuat fungsi selection sort untuk mengurutkan tinggi dari pemain (pemaint tertinggi berada di belakangn)
    //dilakukan secara ascending
    void selectionSort (){
        //memanggil fungsi inputData
        inputData();
        //membuat objec current yang diset sama dengan head
        Node current = head;
        //membuat variabel tampungan untuk membantu proses pertukaran nilai pada saat
        //melakukan peungurutan
        String tempNama;
        int tempTinggi, tempPower;     
        //mengecek jika linkedlist kosong maka akan return/keluar dari fungsi bubblesort
        if (isEmpty()){
            return;
        }       
        //jika linkedlist tidak kosong maka
        else {
            //akan dilakukan perulangan dengan menggunakan while
            //dimana selama current tidak sama dengan null
            while (current != null){
                //membuat objec index_min yang diset sama dengan current sebagai pointer
                //saat membandingkan dua data
                Node index_min = current;
                //membuat objec index_pointer yang diset sama dengan current.next sebagai pointer
                //saat membandingkan dua data
                Node index_pointer = current.next;
                //akan dilakukan perulangan dengan menggunakan while
                //dimana selama index_pointer tidak sama dengan null
                while (index_pointer != null){
                    //jika index pointer tinggi lebih kecil dari index min tinggi 
                    if (index_pointer.tinggi < index_min.tinggi){
                        //maka index min diset sama dengan index pointer
                        index_min = index_pointer;             
                    }
                    //index_pointer diset ke selanjutnya agar terjadi perpindahan node  
                    index_pointer = index_pointer.next;
                }
                //setalah didapatkan data dengan tinggi paling kecil nilainya maka akan dilakukan penukaran
                //pada posisi nama sesuai dengan urutan huruf pertama pada nama
                tempTinggi = current.tinggi;
                current.tinggi = index_min.tinggi;
                index_min.tinggi = tempTinggi;

                //karena terjadi penukaran tinggi maka nama pemain juga
                //harus ditukar agar mengikuti pergantian nama
                tempNama = current.nama;
                current.nama = index_min.nama;
                index_min.nama = tempNama;

                //karena terjadi penukaran tinggi maka power pemain juga
                //harus ditukar agar mengikuti pergantian nama
                tempPower = current.power;
                current.power = index_min.power;
                index_min.power = tempPower;
                //current diset ke current selanjutnya agar terjadi perpindahan node   
                current = current.next;
            }
        }
    }
    
    //membuat fungsi sortedInser untuk mengurutkan head dan newnode yang dimasukan ke 
    //dalam parameter
    Node sortedInsert(Node head, Node newNode){
        //mendeklarasi objec current
        Node current;
        //jika head kosong maka akan diisi node baru
        if (head == null){
            head = newNode;
        }        
        //jika head terdapat data maka apabila power pada head lebih besar 
        //sama dengan power pada newnode
        else if ((head).power >= newNode.power){
            //maka akan next dari newnode diset head
            newNode.next = head;
            //sebelum dan sesudah newnode diset newnode
            newNode.next.prev = newNode;
            //dan head diset newnode
            head = newNode;
        }
        //jika dua kemungkinan diatas tidak tepenuhi maka
        else{
            ///current diset head
            current = head;
            // selamaa current next tidan null dan curent next power kurang dari power newnode
            while (current.next != null && current.next.power < newNode.power){
                //makan akan dilakukan perpindahan node
                current = current.next;  
                //kemudian next dari newnode diset current next  
                newNode.next = current.next;
            }   
            //jika current next tidak null
            if (current.next != null){
                //maka newnode nex prev diset newnode
                newNode.next.prev = newNode;            
            }
            //kemudian next current diset newnode
            current.next = newNode;
            //dan prev newnode diset current
            newNode.prev = current;               
        }
        //nilai head dikembalikan
        return head;
    }
    //membaut fungsi inserstionsort 
    void insertionSort(){
        //inisialisasi sorted sama dengan null dan current sama dengan head
        Node sorted = null;
        Node current = head;
        //selama current tidak sama dengan null
        while (current != null){
            //objext next diset ke next current 
            Node next = current.next;
            //prev dari current dan next dari current diset null
            current.prev = current.next = null;  
            //memanggil fungsi sortedinsert dan hasilnya ditampung ke sorted  
            sorted=sortedInsert(sorted, current);  
            //current diset next agar dilakukan perpindahan node
            current = next;
        }
        //head diset sorted
        head = sorted;
    }
 
    //membaut fungsi untuk menampilkan susunan pemain semula
    void showround (){
        inputData();
        if (isEmpty()){
            System.out.println("Daftar Player Kosong");
        }else {
            Node current = head;
            while (current != null){
                System.out.print(current.nama+" ("+current.tinggi+"cm, "+current.power+"p)");
                current = current.next;
                if (current != null){
                    System.out.print(" <- ");
                }
            }          
        }
        System.out.println();
    }
    
    //membaut fungsi untuk menampilkan susunan pemain  berdasarkan urutan absen
    void showroundName (){

        bubbleSort();

        if (isEmpty()){
            System.out.println("Daftar Player Kosong");
        }else {
            Node current = head;
            while (current != null){
                System.out.print(current.nama+" ("+current.tinggi+"cm, "+current.power+"p)");
                current = current.next;
                if (current != null){
                    System.out.print(" <- ");
                }
            }          
        }
        System.out.println();
    }

    //membaut fungsi untuk menampilkan susunan pemain berdasarkan tinggi
    void showroundTinggi (){

        selectionSort();

        if (isEmpty()){
            System.out.println("Daftar Player Kosong");
        }else {
            Node current = head;
            while (current != null){
                System.out.print(current.nama+" ("+current.tinggi+"cm, "+current.power+"p)");
                current = current.next;
                if (current != null){
                    System.out.print(" <- ");
                }
            }          
        }
        System.out.println();
    }

    //membaut fungsi untuk menampilkan susunan pemain berdasarkan power
    void showroundPower (){

        insertionSort();

        if (isEmpty()){
            System.out.println("Daftar Player Kosong");
        }else {
            Node current = head;
            while (current != null){
                System.out.print(current.nama+" ("+current.tinggi+"cm, "+current.power+"p)");
                current = current.next;
                if (current != null){
                    System.out.print(" <- ");
                }
            }          
        }
        System.out.println();
    }
  
    //membuat fungsi untuk menginputkan data
    void inputData (){
        addFirst_Pemain("Mukhlis", 180, 50);
        addLast_Pemain("Anto", 176, 40);
        addLast_Pemain("Kaka", 155, 33);
        addLast_Pemain("Joko", 162, 39);
        addLast_Pemain("Faris", 167, 41);
        addLast_Pemain("Kiki", 158, 35);
        addLast_Pemain("Dika", 179, 45);
        addLast_Pemain("Brian", 185, 20);
    }

    public static void main(String[] args) {
        //membuat objec dari class jurnal_nomor1
        jurnal_nomor1 satu = new jurnal_nomor1();

        System.out.println("\nPemain Tim A");
        satu.showround();
        System.out.println("\n-------------------------------");
        System.out.println("  Round 1 Berdasarkan Absensi");
        System.out.println("-------------------------------");
        satu.showroundName();
        System.out.println("\n-------------------------------");
        System.out.println("   Round 2 Berdasarkan Tinggi");
        System.out.println("-------------------------------");
        satu.showroundTinggi();
        System.out.println("\n------------------------------");
        System.out.println("   Round 3 Berdasarkan Power");
        System.out.println("------------------------------");
        satu.showroundPower();

        System.out.println();
    }
}