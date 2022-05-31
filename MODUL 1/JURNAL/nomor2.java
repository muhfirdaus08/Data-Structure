package JURNAL;

//membuat class node2 untuk menampung komponen-komponen linkedlist 
//sebagai variabel, pointer, dan constructor
class Node2 {
    //membuat variabel namaPemainUber dengan tipe String
    //karena akan menampung nama pemain 
    String namaPemainUber;
    //membuat variabel Node2 next sebagai pointer next yang akan menunjuk 
    //ke node sesudahnya dan Node2 prev utnuk menunjut ke node sebelumnya
    Node2 next, prev;
    //membuat constructor dengan paramater String namaPemainUber agar tidak dibuat objek baru lagi ketika ingin memasukkan data
    //ke variabel namaPemainUber dengan bantuan syntax this. Contructor ini lah
    //yang akan dipanggil pertama kali ketika membuat objek
    Node2 (String namaPemainUber){
        this.namaPemainUber = namaPemainUber;
    }
}

//membuat class nomor2 untuk menampung fungsi-fungsi yang akan melengkapi 
//double linkedlist
public class nomor2 {

    //membuat berbagai objec baru dari class Node1 sebagai penunjuk dari single linkedlist
    //seperti head yang menunjukan kepala, tail untuk ekor, current sebagai pointer yang menunjukkan sedang 
    //menujuk ke node berapa, newNode untuk menampung node yang baru, dan del untuk menyimpan node yang akan
    //dihapus. static digunakan agar tidak perlu membuat ibjec baru ketika ingin menunjuk ke objec sebelumnya
    static Node2 head, tail, current, newNode, del = new Node2("");

    //membuat fungsi boolean bernama isEmpty untuk mengecek apakah head tidak terdapat data atau tidak yang 
    //akan mereturn true atau false
    public static boolean isEmpty(){
        return (head == null);
    }

    //membuat fungsi count_DLL untuk menghitung jumlah node double linkedlist dimulai dari head (ditunjuk oleh current)
    static int count_Dll (){
        current = head;
        //membuat variabel count dengan setting awalan sama dengan 0
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

    //membuat fungsi void (tanpa nilai kembali) make_DLL dengan parameter String inputnama yang akan digunakan untuk pertama kali 
    //dalam membuat linkedlist
    static void make_Dll(String inputnama){
        //objec head akan diisi dengan String inputnama yang akan menunjuk ke constructor pada class Node2
        head = new Node2(inputnama);
        //karena ini kepalanya dan data pertama dari linkedlist maka prev dari kepala akan diset null
        head.prev = null;
        //karena ini kepalanya dari linkedlist maka next dari kepala akan diset null
        head.next = null;
        //dan sebagai node awal dan satu satunya maka head juga merupakan tail dari linkedlist
        tail = head;
    }

     //membuat fungsi void (tanpa nilai kembali) add_LastDLL dengan parameter String inputnama yang akan digunakan untuk menambah node 
    //pada dari belakang sehingga node yang terakhir dibuat akan menjadi tail
    static void add_LastDLL (String inputNama){
        //membuat kondisi jika kosong maka akan mengeprint "Daftar Nama Pemain Uber Kosong"
        if (isEmpty()){
            System.out.println("Daftar Pemain Uber Kosong");
        //membaut kondisi lain jika kondisi diatas tidak terpenuhi maka akan dieksekusi kondisi ini
        }else {
             //objec newNode akan diisi dengan String inputnama yang akan menunjuk ke constructor pada class Node1
            newNode = new Node2(inputNama);
            //karena ini akan menjadi tail maka prev dari newNode diset tail
            tail.prev = newNode;
            //karena ini akan menjadi tail maka next dari newNode diset null
            newNode.prev = tail; 
            //kemudian next dari tail akan diset newNode
            tail.next = newNode;   
            //dan tail akan diset newNode karena ini merupakan penambahan di tail (ujung terakhir linkedlist)       
            tail = newNode;
        }
    }

    //membuat fungsi void (tanpa nilai kembali) changeMiddle_DLL dengan parameter String inputnama dan int posisi yang akan digunakan untuk mengganti node 
    //dari posisi yang diisi oleh int posisi pada parameter
    static void changeMiddle_DLL (String inputNama, int posisi){
        //membuat kondisi jika posisi nilainya kurang dari 1 atau lebih dari jumlah node yang ada maka akan mengeprint
        //"Posisi diluar jangkauan\n"
        if (posisi < 1 || posisi > count_Dll()){
            System.out.println("Posisi diluar jangkauan\n");
        //membuat kondisi jika posisi nilainya sama dengan 1 maka akan mengeprint
        //"Posisi tidak ditengah atau diakhir\n" karena posisi itu harus lebih dari satu dan tidak boleh lebih dari jumlah
        }else if (posisi == 1){
            System.out.println("Posisi tidak ditengah atau diakhir\n");
         //jika semua kondisi tidak terpenuhi maka akan masuk ke kondisi ini
        }else {
            //current diset menjadi head
            current = head;
            //membuat variabel number yang diset sama dengan 1 untuk menhitung posisi
            int number = 1;
            //membuat while looping selama kondisi nilai number kurang dari nilai posisi maka akan masuk ke dalam prosesnya
            while (number < posisi){
                //posisi current akan diubah ke posisi current selanjutnya (bergeser ke depan) selama kondisi while memenuhi
                current = current.next;
                 //variabel number akan terus ditambah satu selama kondisi while menenuhi
                number++;
            }
            //setalah number kurang 1 dari posisi maka current akan menunjukkan ke node yang dimasukkan sesuai dengan nilai posisi
            //sebelumnya kemudian current memanggil variabel namaPemainThomas untuk diisi dengan inputNama
            current.namaPemainUber = inputNama;
        }
    }

    //membuat fungsi void delete_Last yang akan menghapus bagian tail dari double linked list
    static void deletelast_DLL (){
        //membuat kondisi jika kosong maka akan mengeprint "Daftar Nama Pemain Uber Kosong"
        if (isEmpty()){
            System.out.println("Daftar Pemain Uber Kosong");
        //jika kondisi di atas tidak terpenuhi maka akan masuk ke kondisi ini
        }else {
            //objec del akan diset menjadi tail
            del = tail;
            //tail.prev di set menjadi tail
            tail = tail.prev;
            //tail.next jadikan null
            tail.next = null;
            //dan del dihapus dengan jadikannya null
            del = null;
        }
    }

    //membuat fungsi print yang akan menampilkan semua isi dari node yang ada 
    static void print_DLL(){
        //membuat kondisi jika kosong maka akan mengeprint "Daftar Nama Pemain Uber Kosong"
        if (isEmpty()){
            System.out.println("Daftar Pemain Uber Kosong");
        //jika kondisi di atas tidak terpenuhi maka akan masuk ke kondisi ini
        }else {
            //current diset menjadi head 
            current = head;
            //selama current tidak sama dengan null maka
            while (current != null){
                //akan mengeprint node dari yang ditunjuk dari current
                System.out.print(current.namaPemainUber);
                //current digeser ke current selanjutnya
                current = current.next;
                //selama current tidak sama dengan null maka akan mengeprint tanda -> 
                //sehingga node terakhir tidak akan mengeprint tanda ini
                if (current != null){
                    System.out.print(" -> ");
                }
            }
            //membuat line baru
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("\n===Daftar Nama Pemain Uber===\n");
        //pertama akan dibuat dulu node baru yang akan diisi oleh pemain pertama
        make_Dll("Putri");
        //kemudian akan ditambahkan pemain selanjutnya sampai pemain nomor 5
        add_LastDLL("Poli & Apriyani");
        add_LastDLL("Gregoria");
        add_LastDLL("Utami & Aprilia");
        add_LastDLL("Melati");     
        //kemudian akan menampilkan susunan pemain  
        print_DLL();

        System.out.println("\nUtami Reaktif Covid-19 dan Isolasi");
        //karena Utama raktif covid
        deletelast_DLL();
        //node selanjutnya juga akan dihapus
        deletelast_DLL();
        //print lagi
        print_DLL();

        //menambahkan kembali utami dan aprilia
        add_LastDLL("Utami & Aprilia");
        //menambahkan kembali melati agar susunan pemain kembali menjadi sebanyak 5
        add_LastDLL("Melati");

        System.out.println("Utami diganti oleh Putri");
        //utami diganti putri pada posisi ke 4
        changeMiddle_DLL("Putri dan Aprilia", 4);
        //print terakhir
        print_DLL();
    }
}
