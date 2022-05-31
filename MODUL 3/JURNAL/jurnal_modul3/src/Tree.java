//class tree merupakan class tempat untuk membuat tree itu sendiri.
//class ini berisi fungsi-fungsi dasar dari tree seperti
//fungsi create, insert (left atau right), relation, height, transversal (preorder, inorder, postorder)
public class Tree {
    //node root merupakan variabel yang akan menyimpan object yang pertama kali dibuat
    //dalam hal ini adalah nama pertama dalam silsilah keluarga. Ciri dari root adalah
    //tidak memiliki parent
    //node newNode merupakan variabel yang akan menyimpan object baru dalam hal ini
    //ketika melakukan penambahan anggota keluarga, baik insert left maupun insert right
    Node root, newNode = new Node(""); 
    //numberPre merupakan variabel bertipe integer yang digunakan untuk memberi nomor dan menghitung nomor
    //ketika menampilkan data pada screen khusus untuk preorder transversal
    //numberPost merupakan variabel bertipa integer yang digunakan untuk memberi nomor dan menghitung nomor
    //ketika menampilkan data pada screen khusus untuk postOrder transversal
    //numberPost diinisialisasi dengan angka satu supaya yang ditampilkan angka 1 terlebih dahulu
    //bukan angka 0 sesuai dengan alur kerja postorder transversal
    int numberPre, numberPost = 1;
    //createTree merupakan nama function yang bertipe Node dengan parameter namaIn (tipe String)
    //yang digunakan untuk membuat tree pertama kali atau tree baru
    Node createTree (String namaIn){
        //Percabangan ini digunakan jika root tidak sama dengan null artinya root sudah dibuat
        //dan disarankan untuk melakukan penambahan anggota keluarga pada function insert
        if (root != null){
            System.out.println("Root Sudah Ada, Silakan Insert Tree");
        //artinya jika root masih null
        }else {
            //maka akan dilakukan pengisian node root.nama dengan paramater namaIn 
            //semenatara karena belum memiliki anak maka root.left dan right di-null-kan
            //serta root.parent juga di-null-kan karena dalam konsep tree root tidak memiliki parent
            root = new Node("");
            root.nama = namaIn;
            root.left = null;
            root.right = null;
            root.parent = null;
            System.out.println(namaIn+" berhasil dibuat sbg ROOT");
        }
        //mengembalikan node root sebagai hasil dari function createTree
        return root;
    }
    //inserTreeLeft merupakan function untuk menambahkan anak kiri pada sebuah node
    //inserTreeLeft memiliki parameter String namain yang berfungsi untuk menampung nama yang di-input-kan
    //dan Node nodeIn yang berfungsi untuk menunjuk node mana yang akan menjadi parent dari anak kiri
    
    //penginsertan dengan parameter namaIn dan nodeIn menjadikan penginputan left child tepat pada posisi nya 
    //walupun waktu dan urutan penginputan berbeda

    Node insertTreeLeft (String namaIn, Node nodeIn){
        //Percabangan jika root masih kosong maka disarankan untuk membuat tree dulu dengan 
        //function createTree dan akan dikeluarkan dari function insertTreeLeft
        if (root == null){
            System.out.println("Create Tree Dulu"); 
            return null;
        //jika root sudah ada 
        }else {
            //maka jika node left menunjuk anak kiri dari nodeIn sebagai parent sudah ada maka tidak
            //bisa lagi ditambahkan node left-nya karena binary tree maksimal memiliki dua anak (1 kiri & 1 kanan)
            if (nodeIn.left != null){
                System.out.println(nodeIn.nama+" sudah ada LEFT child");
            //jika kosong anak kiri
            }else {
                //maka akan diisikan namaIn ke newNode.nama kemudian nodeIn akan menjadi parent dari namaIn
                //dan anak kiri dari nodeIn akan menjadi newNode
                newNode = new Node("");
                newNode.nama = namaIn;
                newNode.left = null;
                newNode.right = null;
                newNode.parent = nodeIn;
                nodeIn.left = newNode;
                System.out.println(namaIn+" berhasil ditambahkan sbg LEFT child dari "+newNode.parent.nama);         
            }          
        }
        //mengembalikan node newNode sebagai hasil dari function inserTreeLeft
        return newNode;
    }
    //inserTreeRightmerupakan function untuk menambahkan anak kanan pada sebuah node
    //inserTreeRight memiliki parameter String namain yang berfungsi untuk menampung nama yang di-input-kan
    //dan Node nodeIn yang berfungsi untuk menunjuk node mana yang akan menjadi parent dari anak kanan

    //penginsertan dengan parameter namaIn dan nodeIn menjadikan penginputan right child tepat pada posisi nya 
    //walupun waktu dan urutan penginputan berbeda

    Node insertTreeRight (String namaIn, Node nodeIn){
        //Percabangan jika root masih kosong maka disarankan untuk membuat tree dulu dengan 
        //function createTree dan akan dikeluarkan dari function insertTreeRight
        if (root == null){
            System.out.println("Create Tree Dulu"); 
            return null;
        //jika root sudah ada 
        }else {
            //maka jika node right menunjuk anak kiri dari nodeIn sebagai parent sudah ada maka tidak
            //bisa lagi ditambahkan node right-nya karena binary tree maksimal memiliki dua anak (1 kiri & 1 kanan)
            if (nodeIn.right!= null){
                System.out.println(nodeIn.nama+" sudah ada RIGHT child");
            //jika kosong anak kanan
            }else {
                //maka akan diisikan namaIn ke newNode.nama kemudian nodeIn akan menjadi parent dari namaIn
                //dan anak kanan dari nodeIn akan menjadi newNode
                newNode = new Node("");
                newNode.nama = namaIn;
                newNode.right= null;
                newNode.right = null;
                newNode.parent = nodeIn;
                nodeIn.right= newNode;
                System.out.println(namaIn+" berhasil ditambahkan sbg RIGHT child dari "+newNode.parent.nama);         
            }          
        }
        //mengembalikan node newNode sebagai hasil dari function insertTreeRight
        return newNode;
    }
    //relationTree merupakan function yang bertipe void (tanpa pengembalian nilai). Function ini digunakan untuk
    //menampilkan hubugan antar dua anggota keluarga yang direpresentasikan dengan dua parameter,
    //yaitu paramter node sebagai orang pertama dan node2 sebagai orang kedua
    //Kedua parameter tersebut sama sama bertipa Node
    void relationTree (Node node, Node node2){
        //levelnode merupakan variabel bertipe integer yang akan menampung nilai dari hasil perhitungan di function height
        //dengan parameter yang diisikan adalah node (orang pertama)
        int levelnode = height(node);
        //levelnode2 merupakan variabel bertipe integer yang akan menampung nilai dari hasil perhitungan di function height
        //dengan parameter yang diisikan adalah node2 (orang kedua)
        int levelnode2 = height(node2);
        //jarak merupakan variabel yang bertipe integer dimana variabel ini akan menampung selisih dari 
        //levelnode2 dan levelnode. Varibel ini untuk mengetahui jarak dari dua posisi node yang dimasukkan 
        //pada parameter funtion relationTree
        int jarak = levelnode2 - levelnode;
        //relation merupakan variabel yang bertipe String yang akan menampung kumpulan karakter dari
        //dua hubungan anggota keluarh
        String relation = "";
        //Mulai masuk ke perbandingan
        //jika dimasukan node (orang pertama) dan node2 (orang kedua) memiliki nilai yang sama
        //atau alamat yang sama maka tampilkan bahwa anda memasukkan dua nama yang sama
        //kemudian return sehigga dapat keluar dari funtion dan tidak lagi dicek di percabangan berikutnya
        if (node == node2){
            System.out.println("Anda memasukan dua nama yang sama");
            return;
        }
        //jika jaraknya sama dengan nol maka ada dua kemungkinan
        if (jarak == 0){
            //apabilan orang tua dari orang pertama dan orang tua dari orang kedua sama (alamat sama)
            //maka keduanya saudara dan tampung di variabel relation
            if(node.parent == node2.parent){
                relation = "saudara";   
            //jika orang tuanya berbeda maka keduanya merupakan saudara jauh
            // dan tampung di variabel relation
            }else {
                relation = "saudara jauh";
            }
        }
        //jika jaraknya sama dengan 1 maka ada tiga kemungkinan
        if (jarak == 1){
            //apabilan orang tua dari orang pertama dan orang kedua sama (alamat sama)
            //maka orang pertama merupakan anak dari orang kedua dan tampung di variabel relation
            if (node.parent == node2){
                relation = "anak";
            //jika kakek dari orang pertama (node) dan orang tua dari orang kedua (node2) sama (alamat sama)
            //maka orang pertama merupakan keponakan dari orang kedua
            //dan tampung di variabel relation
            }else if (node.parent.parent == node2.parent){
                relation = "keponakan";
            //jika tidak dari semua kemungikanan di atas dan masih dalah jarak == 1 atau tingkatan yang 
            //sama maka orang pertama merupakan keponakan jauh dari orang kedua 
            //dan tampung di variabel relation
            }else {
                relation = "keponakan jauh";
            }
        }
        //jika jaraknya sama dengan -1 maka ada tiga kemungkinan
        //ini merupakan solusi jika height orang pertama dan height orang kedua memiliki nilai -1 jika
        //dikurangkan (orang pertama (node) memiliki nilai heigt lebih besar dari height orang kedua (node2)(node2 - node1))
        //karena terjadi pembolakbalikan node pada saat menginput parameter
        if (jarak == -1){
            //apabila orang tua dari orang kedua (node2) dan orang pertama (node) sama (alamat sama)
            //maka orang kedua merupakan anak dari orang pertama
            if (node == node2.parent){
                //agar pada peng-input-an parameter dapat di bolak balik jika (dewi,uno) dan (uno,dewi)
                //sama sama menghasilkan keluaran dewi adalah anak dari uno maka dilakukan penukaran node
                //dengan bantuan node temp
                Node temp = node2;
                node2 = node;
                node = temp;
                relation = "anak";    
            }else if (node.parent == node2.parent.parent) {
                //agar pada peng-input-an parameter dapat di bolak balik jika (pangeran,dewi) dan (dewi,pangeran)
                //sama sama menghasilkan keluaran pangeran adalah keponakan dari dewi maka dilakukan penukaran node
                //dengan bantuan node temp
                Node temp = node2;
                node2 = node;
                node = temp;
                relation = "keponakan";
            }else {
                //agar pada peng-input-an parameter dapat di bolak balik jika (wahyu,kholilul) dan (kholilul,wahyu)
                //sama sama menghasilkan keluaran wahyu adalah keponakan jauh dari kholilul maka dilakukan penukaran node
                //dengan bantuan node temp
                Node temp = node2;
                node2 = node;
                node = temp;
                relation = "keponakan jauh";
            }
        }
        //jika jaraknya sama dengan 2 maka ada dua kemungkinan kemungkinan
        if (jarak == 2){
            //jika kakek dari orang pertama (node) dan orang kedua (node2) memiliki nilai yang sama (alamat sama)
            //maka orang pertama merupakan cucu dari orang kedua dan tampung ke relation
            if (node.parent.parent == node2){
                relation = "cucu";  
            //jika bukan dan masih dalam jarak == 2 maka kemungkinan lain adalah orang pertama adalah
            //cucu jauh dari orang kedua
            }else{
                relation = "cucu jauh";
            }
        }
        //jika jaraknya sama dengan -2 maka ada dua kemungkinan
        //ini merupakan solusi jika height orang pertama dan height orang kedua memiliki nilai -2 jika
        //dikurangkan (orang pertama (node) memiliki nilai heigt lebih besar dari height orang kedua (node2)(node2 - node1))
        //karena terjadi pembolakbalikan node pada saat menginput parameter
        if (jarak == -2){
            //apabila kakek dari orang kedua (node2) dan orang pertama (node) memiliki nilai yang sama
            //atau alamat yang sama maka orang kedua merupakan cucu dari orang pertama
            //dan tampung di variabel relation
            if (node == node2.parent.parent){
                //agar pada peng-input-an parameter dapat di bolak balik jika (wahyu,alita) dan (alita,wahyu)
                //sama sama menghasilkan keluaran wahyu adalah cucu dari alita maka dilakukan penukaran node
                //dengan bantuan node temp
                Node temp = node2;
                node2 = node;
                node = temp;
                relation = "cucu";    
            }else {
                //agar pada peng-input-an parameter dapat di bolak balik jika (wahyu,dewi) dan (dewi,wahyu)
                //sama sama menghasilkan keluaran wahyu adalah cucu jauh dari dewi maka dilakukan penukaran node
                //dengan bantuan node temp
                Node temp = node2;
                node2 = node;
                node = temp;
                relation = "cucu jauh";
            }
        }
        //jika jaraknya sama dengan 3 maka ada dua kemungkinan kemungkinan
        if (jarak == 3){
            //apabila buyut dari orang pertama (node) dan orang kedua (node2) memiliki nilai yang sama
            //atau berada pada alamat yang sama maka orang pertama merupakan cicit dari orang kedua
            //dan tampung di variabel relation
            if (node.parent.parent.parent == node2){
                relation = "cicit";  
            //jika tidak maka kemungkinan lain adalah orang pertama merupakan cicit jauh dari orang kedua
            //dalam soal jurnal sebenarnya tidak ada node yang memiliki hubungan cicit jauh
            //hal ini karena jumlah tingkatannya sama dengan 4 sehingga tidak memungkinkan hubungan itu ada
            //alasan menuliskan perintah cicit jauh hanya semata untuk menyeragamkan dari hubungan node lain
            //yang memiliki "... jauh" dalam hubungannya
            }else {
                relation = "cicit jauh";  
            }
        }
        //jika jaraknya sama dengan -3 maka ada dua kemungkinan
        //ini merupakan solusi jika height orang pertama dan height orang kedua memiliki nilai -3 jika
        //dikurangkan (orang pertama (node) memiliki nilai heigt lebih besar dari height orang kedua (node2)(node2 - node1))
        //karena terjadi pembolakbalikan node pada saat menginput parameter
        if (jarak == -3){
            //apabila buyut dari orang kedua (node2) dan orang pertama (node) memiliki nilai yang sama
            //atau berada pada alamat yang sama maka orang kedua merupakan cicit dari orang pertama
            //dan tampung di variabel relation
            if (node== node2.parent.parent.parent){
                //agar pada peng-input-an parameter dapat di bolak balik jika (nadya,uno) dan (uno,nadya)
                //sama sama menghasilkan keluaran nadya adalah cicit dari uno maka dilakukan penukaran node
                //dengan bantuan node temp
                Node temp = node2;
                node2 = node;
                node = temp;
                relation = "cicit";  
            }else {
                //jika tidak maka kemungkinan lain adalah orang pertama merupakan cicit jauh dari orang kedua
                //dalam soal jurnal sebenarnya tidak ada node yang memiliki hubungan cicit jauh
                //hal ini karena jumlah tingkatannya sama dengan 4 sehingga tidak memungkinkan hubungan itu ada
                //alasan menuliskan perintah cicit jauh hanya semata untuk menyeragamkan dari hubungan node lain
                //yang memiliki "... jauh" dalam hubungannya
                //lakukan penukaran node agar penginputan node pada parameter dapat dilakukan secara bolak balik
                //dan tetap menghasilkan keluaran yang sama
                Node temp = node2;
                node2 = node;
                node = temp;
                relation = "cicit jauh";  
            }
        }
        System.out.println(node.nama+" adalah "+relation+" dari "+node2.nama);
    }
    //height merupakan function yang digunakan untuk menghitung ketinggian atau tingkatan dari 
    //sebuah node. Node root merupakan node yang memiliki ketinggian paling tinggi dari node yang lain
    //parameter dari function ini adalah node yang bertipe Node
    int height(Node node){
        //jika node yang dimasukan memiliki nilai null maka akan mengembalikan nilai 0 
        //dan keluar dari function
        if(node == null){
            return 0;
        //jika node ada 
        }else{
            //maka akan dilakukan fungsi recursive yaitu memanggil function yang sama di dalam function
            //sehingga akan terjadi perulangan
            //heightleft merupakan variabel bertipe integer yang akan menampung hasil dari pemanggilan function
            //heigt dengan parameter node.left
            int heightleft = height(node.left);
            //heightright merupakan variabel bertipe integer yang akan menampung hasil dari pemanggilan function
            //heigt dengan parameter node.right
            int heightright = height(node.right);
            //Jika nilai heightleft lebih besar sama dengan heightright 
            //makan akan mengembalikan heightleft yang ditambah dengan 1
            if(heightleft >= heightright){
                return heightleft + 1;
            //Jika nilai heightleft tida lebih besar sama dengan heightright 
            //makan akan mengembalikan heightright yang ditambah dengan 1
            }else{
                return heightright + 1;
            }
        }  
    }
    //preOrder merupakan function yang bertipe void (tanpa nilai pengembalian)
    //preorder merupakan salah satu bentuk tranversal yang dengan algoritma mengunjungi root, substree kiri (left child)
    //dan substree kanan (right child)
    //preorder digunakan untuk menampilkan node-node dalam sebuah tree atau antara node parent dan child
    //preorder memiliki parameter root bertipe Node sehingga node yang dimasukan dapat fleksibel dan
    //menampilkan semua node tergantung dari node yang dimasukan dalam parameter
    void preOrder (Node root){
        //jika parameter root tidak null
        if (root != null){
            //maka variabel numberPre akan bertambah satu
            numberPre++;    
            //jika anak kiri dan kanan dari parameter root null maka root tersebut tidak
            //memiliki child atau anak. Tampilkan root.nama
            if (root.left == null && root.right == null){
                System.out.print("\n"+numberPre+". "+root.nama+" : -");
            }
            //jika anak kiri atau kanan dari parameter root tidak null maka root tersebut
            //memiliki anak. Tampilkan root.nama
            if (root.left != null || root.right != null){
                System.out.print("\n"+numberPre+". "+root.nama+" : ");
            }
            //jika anak kiri tidak null maka tampilkan nama anak kiri
            if (root.left != null){
                System.out.print(root.left.nama);
                //apabila anak kanan tidak null maka tampilkan tanda "&". Hal ini bertujuan agar
                //jika hanya memiliki anak kiri dan tidak memiliki anak kanan maka tidak perlu menampilkan
                //tanda "&"
                if (root.right != null){
                    System.out.print(" & ");
                }
            }
            //jika anak kiri tidak null maka tampilkan nama anak kanan
            if (root.right != null){
                System.out.print(root.right.nama);          
            }
            //jika semua root sudah dikunjungi maka lakukan pemanggilan function dengan nama yang sama
            //atau recursive dimulai dari mengunjungi node anak kiri dan setelah itu mengunjungi node anak kanan
            preOrder(root.left);
            preOrder(root.right);  
            //ini akan dilakukan perulangan sampai root bernilai null   
        }
    }
    //postOrder merupakan function yang bertipe void (tanpa nilai pengembalian)
    //postorder merupakan salah satu bentuk tranversal yang dengan algoritma mengunjungi substree kiri (left child),
    //substree kanan (right child) dan mengunjungi root
    //postorder digunakan untuk menampilkan node-node dalam sebuah tree atau antara node parent dan child
    //postorder memiliki parameter root bertipe Node sehingga node yang dimasukan dapat fleksibel dan
    //menampilkan semua node tergantung dari node yang dimasukan dalam parameter
    void postOrder (Node root){
        //jika parameter root tidak null
        if (root != null){
            //maka variabel numberPre akan bertambah satu
            //lakukan pengunjugan node anak kiri dengan menggunakan fungsi recursive dan parameter node anak kiri
            postOrder(root.left);
            //setalah itu lakukan pengunjugan node anak kanan dengan menggunakan fungsi recursive dan parameter node anak kanan
            postOrder(root.right);   
            //jika semua node anak kiri dan anak kanan dikunjungi maka sekarang kunjungi root nya
            //lakukan pengecekan jika root anak kiri dan root anak kanan sama dengan null
            //maka root tersebut tidak memiliki anak atau child. Tampilkan root.nama
            if (root.left == null && root.right == null){
                System.out.print("\n"+numberPost+". "+root.nama+" : -");
            }
            //jika anak kiri atau kanan dari parameter root tidak null maka root tersebut
            //memiliki anak. Tampilkan root.nama
            if (root.left != null || root.right != null){
                System.out.print("\n"+numberPost+". "+root.nama+" : ");
            }
            //jika anak kiri tidak null maka tampilkan nama anak kiri
            if (root.left != null){
                System.out.print(root.left.nama);
                //apabila anak kanan tidak null maka tampilkan tanda "&". Hal ini bertujuan agar
                //jika hanya memiliki anak kiri dan tidak memiliki anak kanan maka tidak perlu menampilkan
                //tanda "&"
                if (root.right != null){
                    System.out.print(" & ");
                }
            
            }
            //jika anak kiri tidak null maka tampilkan nama anak kanan
            if (root.right != null){
                System.out.print(root.right.nama);          
            }
            //variabel numberPost akan bertambah satu
            numberPost++;   
            //ini akan dilakukan perulangan sampai root bernilai null    
        }
    }
}
