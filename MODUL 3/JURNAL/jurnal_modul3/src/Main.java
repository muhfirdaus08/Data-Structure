//Main merupakan class yang berisi main function atau fungsi utama untuk menjalankan program
//yang telah dibuat
public class Main {
    public static void main(String[] args) {
        //membuat object bernama silsilah dari class Tree. Hal ini dilakukan karena fungsi -
        //fungsi pada class Tree tidak memiliki keyword static di depanya. Alhasil perlu
        //dibuatkan obect terlebih dahulu untuk memanggil fungsi dalam class tersebut
        Tree silsilah = new Tree();
        //variabel uno merupakan variabel bertipe node untuk menampung hasil pemanggilan
        //function createTree. Node uno akan otomatis menjadi root dari Binary Tree yang dibuat
        Node uno = silsilah.createTree("UNO");
        //variabel alita merupakan variabel bertipe node untuk menampung hasil pemanggilan
        //function insertTreeLeft. Node alita akan otomatis menjadi left chile dari Node uno
        Node alita = silsilah.insertTreeLeft("ALITA", uno);
        //variabel dewi merupakan variabel bertipe node untuk menampung hasil pemanggilan
        //function insertTreeRight. Node dewi akan otomatis menjadi right chile dari Node uno
        Node dewi = silsilah.insertTreeRight("DEWI", uno);

        //begitu seterusnya hingga semua node di-insert sesuai dengan gambar tree silsilah keluarga
        //pada soal jurnal

        Node putri = silsilah.insertTreeLeft("PUTRI", alita);
        Node pangeran = silsilah.insertTreeRight("PANGERAN", alita);
        Node kholilul = silsilah.insertTreeLeft("KHOLILUL", dewi);
        Node habib = silsilah.insertTreeRight("HABIB", dewi);
        Node rifki = silsilah.insertTreeLeft("RIFKI", putri);
        Node alfiana = silsilah.insertTreeRight("ALFIANA", putri);
        Node rozaki = silsilah.insertTreeLeft("ROZAKI", pangeran);
        Node wahyu = silsilah.insertTreeRight("WAHYU", pangeran);
        Node rizki = silsilah.insertTreeLeft("RIZKI", kholilul);
        Node adit = silsilah.insertTreeRight("ADIT", kholilul);    
        Node yogi = silsilah.insertTreeLeft("YOGI", habib);
        Node nadya = silsilah.insertTreeRight("NADYA", habib);
        
        //menampilkan secara preorder dihitung mulai dari node uno
        System.out.println("\nPre-Order\n");
        System.out.print("No. Parent : Child");
        silsilah.preOrder(uno);   
        
        //menampilkan secara postorder dihitung mulai dari node uno
        System.out.println("\n\nPost-Order\n");
        System.out.print("No. Parent : Child");
        silsilah.postOrder(uno);  

        System.out.println("\n\nHubungan\n");
        //menampilkan hubungan antara dewi dan uno yang dimana dewi merupakan anak dari uno
        silsilah.relationTree(dewi, uno);
        //mencoba menampilkan hubungan antara uno dan dewi (jika input-annya dibalik) yang dimana 
        //hasilnya tetap mengeluarkan dewi merupakan anak dari uno
        silsilah.relationTree(uno, dewi);

        //begitupun dengan menampilkan hubungan antar dua node yang lainnya
        //yang mana walupun node yang diinput dibolak balik hasilnya tetap akan sama

        //yaitu menampilkan hasil yang dibaca dari bawah sesuai dengan ketentuan soal
        
        silsilah.relationTree(nadya, uno);
        silsilah.relationTree(rizki, yogi);
        silsilah.relationTree(habib, uno);
        silsilah.relationTree(pangeran, dewi);
        silsilah.relationTree(wahyu, dewi);
        silsilah.relationTree(habib, uno);
        silsilah.relationTree(wahyu, kholilul);

        System.out.println();
        
    }
}
