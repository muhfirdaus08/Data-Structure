package JURNAL;

//membuat class node1 untuk menampung komponen-komponen dari linkedlist 
//sebagai variabel, pointer, dan constructor
class Node1 {
    //membuat variabel namaPemainThomas dengan tipe String
    //karena akan menampung nama pemain 
    String namaPemainThomas;
    //membuat variabel Node1 next sebagai pointer next yang akan menunjuk 
    //ke node sesudahnya
    Node1 next;
    //membuat constructor dengan paramater String namaPemainTHomas agar tidak dibuat objek baru lagi ketika ingin memasukkan data
    //ke variabel namaPemainThomas dengan bantuan syntax this. Contructor ini lah
    //yang akan dipanggil pertama kali ketika membuat objek
    Node1 (String namaPemainThomas){
        this.namaPemainThomas = namaPemainThomas;
    }
}

//membuat class nomor1 untuk menampung fungsi-fungsi yang akan melengkapi 
//single linkedlist
public class nomor1{
    //membuat berbagai objec baru dari class Node1 sebagai penunjuk dari single linkedlist
    //seperti head yang menunjukan kepala, tail untuk ekor, current sebagai pointer yang menunjukkan sedang 
    //menujuk ke node berapa, newNode untuk menampung node yang baru, dan del untuk menyimpan node yang akan
    //dihapus. static digunakan agar tidak perlu membuat ibjec baru ketika ingin menunjuk ke objec sebelumnya
    static Node1 head, tail, current, newNode, del = new Node1("");

    //membuat fungsi boolean bernama isEmpty untuk mengecek apakah head tidak terdapat data atau tidak yang 
    //akan mereturn true atau false
    static boolean isEmpty (){
        return (head == null);
    }

    //membuat fungsi count_SLL untuk menghitung jumlah node single linkedlist dimulai dari head (ditunjuk oleh current)
    static int count_SLL(){
        current = head;
        //membuat variabel count dengan setting awalan sama dengan 0
        int count = 0;
        //membuat while looping selama current tidak bernilai null maka yang diddalamnya akan terus dijalankan
        while (current != null){
            //variabel count akan terus ditambah satu selama kondisi while menenuhi
            count++;
            //posisi current akan diubah ke posisi current selanjutnya (bergeser ke depan) selama kondisi while memenuhi
            current = current.next;
        }
        //mereturn nilai variabel count dari fungsi count_SLL
        return count;      
    }

    //membuat fungsi void (tanpa nilai kembali) make_SLL dengan parameter String inputnama yang akan digunakan untuk pertama kali 
    //dalam membuat linkedlist
    static void make_SLL(String inputNama){
        //objec head akan diisi dengan String inputnama yang akan menunjuk ke constructor pada class Node1
        head = new Node1(inputNama);
        //karena ini kepalanya dari linkedlist maka next dari kepala akan diset null
        head.next = null;
        //dan sebagai node awal dan satu satunya maka head juga merupakan tail dari linkedlist
        tail = head;
    }

    //membuat fungsi void (tanpa nilai kembali) add_Last dengan parameter String inputnama yang akan digunakan untuk menambah node 
    //pada dari belakang sehingga node yang terakhir dibuat akan menjadi tail
    static void add_Last (String inputNama){
        //membuat kondisi jika kosong maka akan mengeprint "Daftar Nama Pemain Thomas Kosong"
        if (isEmpty()){
            System.out.println("Daftar Nama Pemain Thomas Kosong");
        //membaut kondisi lain jika kondisi diatas tidak terpenuhi maka akan dieksekusi kondisi ini
        }else {
            //objec newNode akan diisi dengan String inputnama yang akan menunjuk ke constructor pada class Node1
            newNode = new Node1(inputNama);
            //karena ini akan menjadi tail maka next dari newNode diset null
            tail.next = newNode;
            //kemudian next dari tail akan diset newNode
            newNode.next = null;
            //dan tail akan diset newNode karena ini merupakan penambahan di tail (ujung terakhir linkedlist)
            tail = newNode;
        }   
    }

    //membuat fungsi void (tanpa nilai kembali) changeMiddle_SLL dengan parameter String inputnama dan int posisi yang akan digunakan untuk mengganti node 
    //dari posisi yang diisi oleh int posisi pada parameter
    static void changeMiddle_SLL (String inputNama, int posisi){
        //membuat kondisi jika posisi nilainya kurang dari 1 atau lebih dari jumlah node yang ada maka akan mengeprint
        //"Posisi diluar jangkauan\n"
        if (posisi < 1 || posisi > count_SLL()){
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
            current.namaPemainThomas = inputNama;
        }
    }
    
    //membuat fungsi void delete_First yang akan menghapus node head dari single linkedlist
    static void delete_First (){
        //membuat kondisi jika kosong maka akan mengeprint "Daftar Nama Pemain Thomas Kosong"
        if (isEmpty()){
            System.out.println("Daftar Nama Pemain Thomas Kosong");
        //jika kondisi di atas tidak terpenuhi maka akan masuk ke kondisi ini
        }else{
            //objek del akan diset menjadi head karena akan dihapus headnya
            del = head;
            //ini akan mengeprint nama yang akan dihapus
            System.out.println(del.namaPemainThomas+" telah memenangkan Game pertama");
            //kemuadian headnya akan diubah menjadi head yang sesudahnya
            head = head.next;
            //baru kemudian del nya diset null (proses menghapus)
            del = null;
        }
    }

    //membuat fungsi void delete_Last yang akan menghapus bagian tail dari single linked list
    static void delete_Last(){
        //membuat kondisi jika kosong maka akan mengeprint "Daftar Nama Pemain Thomas Kosong"
        if (isEmpty()){
            System.out.println("Daftar Pemain Thomas Kosong");
        //jika kondisi di atas tidak terpenuhi maka akan masuk ke kondisi ini
        }else {
            //objec del akan diset menjadi tail
            del = tail;
            //begitu jugan dengan current diset menjadi head sebagai penujuk pointer sekarang dimulai dari head
            current = head;
            //selama current selanjutnya belum sampai ke tail maka 
            while (current.next != tail){
                //current nya akan diset ke current selanjutnya
                current = current.next;
            }
            //mengeprint pemain yang akan dihapus
            System.out.println("Pemain bernama "+current.next.namaPemainThomas+" ditarik keluar");
            //setalh dapat currentnya maka tail diset menjadi current
            tail = current;
            //next dari tail akan jadi null
            tail.next = null;
            //dan del akan dinullkan juga sehingga tailnya akan dihapus
            del = null;
        }      
    }

    //membuat fungsi print yang akan menampilkan semua isi dari node yang ada 
    static void print_SLL(){
        //membuat kondisi jika kosong maka akan mengeprint "Daftar Nama Pemain Thomas Kosong"
        if (isEmpty()){
            System.out.println("Daftar Nama Pemain Thomas Kosong");
        //jika kondisi di atas tidak terpenuhi maka akan masuk ke kondisi ini
        }else {
            //current diset menjadi head 
            current = head;
            //selama current tidak sama dengan null maka
            while (current != null){
                //akan mengeprint node dari yang ditunjuk dari current
                System.out.print(current.namaPemainThomas);
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

    //membuat fungsi main untuk menjalankan program
    public static void main(String[] args) {
        System.out.println("\n===Daftar Nama Pemain Thomas===\n");
        //pertama akan dibuat dulu node baru yang akan diisi oleh pemain pertama
        make_SLL("Ginting");
        //kemudian akan ditambahkan pemain selanjutnya sampai pemain nomor 5
        add_Last("Markus & Kevin");
        add_Last("Cesar");
        add_Last("Fajar & Rian");
        add_Last("Jojo");
        //akan menampilkan susunan pemain
        print_SLL();
        
        //karena ginting menang maka ginting dikeluarkan dari susunan
        delete_First();
        //print lagi
        print_SLL();

        //print keterangan "Cesar Sakit Perut dan diganti oleh Jojo"
        System.out.println("Cesar Sakit Perut dan diganti oleh Jojo");
        //proses pertukaran dimana jojo akan mengentikan cesar di posisi nomor 2 dan cesar jadi nomor4
        //ini karena jumlah pemain sudah menjadi 4 setalah ginting keluar
        changeMiddle_SLL("Jojo", 2);
        changeMiddle_SLL("Cesar", 4);
        //print lagi
        print_SLL();

        //cesar terpaksa dikeluarkan karena tidak memungkinkan untuk bermain
        delete_Last();
        //print teakhir
        print_SLL();
    }
}