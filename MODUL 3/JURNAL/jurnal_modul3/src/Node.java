//class node merupakan class yang akan merepresentasi 
//tiap-tiap node yang akan dibuat untuk membentuk model tree
public class Node {
    //nama merupakan variabel yang bertipe String karena akan
    //menyimpan kumpulan charackter yang menyusun nama dari anggota keluarga
    String nama;
    //left merupakan variabel untuk menyimpan node anak kiri yang merupakan reperesentas dari class node.
    //node left akan menunjuk ke bawah 
    //right merupakan variabel untuk menyimpan node anak kanan yang merupakan reperesentas dari class node
    //node right akan menunjuk ke bawah
    //parent merupakan variabel untuk menyimpan node orang tua yang merupakan reperesentas dari class node
    //node parent akan menunjuk ke atas
    //node left. right dan parent memiliki cara kerja yang sama dengan cara kerja double linked list  
    Node left, right, parent;  
    //constructor merupakan fungsi yang akan pertama kali dipanggil ketika membuat sebuah obejct dari class
    //construktor memiliki ciri namanya akan sama dengan nama class
    //construktor memiliki parameter nama yang bertipe String yang akan dimasukanan ketika membuat object
    Node (String nama){
        //this.nama (ruas kiri) menunjuk ke variabel nama bertipe String di atas dan nama (ruas kanan)
        //akan menunjuk ke parameter nama yang ada di construktor
        //penggunaan this. karena nama pada parameter disamakan dengan nama variabel yang ada di atas
        //jika berbeda maka tidak perlu menggunakan this.
        this.nama = nama;
    }
}
