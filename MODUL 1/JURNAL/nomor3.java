package JURNAL;

//membuat class node1 untuk menampung komponen-komponen linkedlist 
//sebagai variabel, pointer, dan constructor
class Node3{
    //membuat variabel data dengan tipe char 
    //karena akan menampung akan menampung karakter dari persamaan yang akan bertipe string
    char data;
    //membuat variabel Node3 next sebagai pointer next yang akan menunjuk 
    //ke node sesudahnya
    Node3 next;
    //membuat constructor dengan paramater char data agar tidak dibuat objek baru lagi ketika ingin memasukkan data
    //ke variabel data yang diatas dengan bantuan syntax this. Contructor ini lah
    //yang akan dipanggil pertama kali ketika membuat objek
    Node3 (char data){
        this.data = data;
    }
}

//membuat class Stack untuk menampung fungsi-fungsi yang akan melengkapi 
//stack dengan linkedlist
class Stack {
    //membuat berbagai objec baru dari class Node1 sebagai penunjuk dari single linkedlist
    //seperti top yang menunjukan bagian teratas stack
    static Node3 top;

    //membuat fungsi boolean bernama isEmpty untuk mengecek apakah top tidak terdapat data atau tidak yang 
    //akan mereturn true atau false
    static boolean isEmpty (){
        return (top == null);
    }

    //membuat fungsi void (tanpa nilai kembali) push dengan parameter char dataIn yang akan digunakan untuk menambah node 
    //dari stack pada tumpukan paling atas
    static void push (char dataIn){
        //membuat kondisi jika kosong maka node baru akan disikan ke top
        if (isEmpty()){
            top = new Node3(dataIn);
        //kondisi jika kondisi diatas tidak terpenuhi (udah ada node)
        }else {
            //maka akan ditambahkan node baru ke newNode 
            Node3 newNode = new Node3(dataIn);
            //next dari newNode akan dijadikan top
            newNode.next = top;
            //top akan menjadi newNode karena stack hanya dapat diisi dari atas
            top = newNode;
        }
    }
    //membuat fungsi void pop untuk mengeluarkan node dari stack paling atas 
    static void pop (){
        //membuat kondisi jika kosong maka akan print stack kosong
        if (isEmpty()){
            System.out.println("Stack Kosong");
        //kondisi jika kondisi diatas tidak terpenuhi (udah ada node)
        }else {
            //next dari top akan jadi top sehingga topnya akan hilang
            top = top.next;     
        }
    }

    //membuat fungsi bertipe char bernama peek 
    static char peek (){
        //yang akan mengembalikan nilai dari tumpukan stack teratas (top)
        return top.data;
    }
}

//membuat class utama dari program mengubah infix ke prefix dan postfix bernama Converter
class Converter {
    //membuat fungsi tipe int bernama presendence dengan parameter char operator yang akan 
    //mengembalikan level dari setiap operator yang ada
    static int presendence(char operator){
        switch(operator){
            //operator +- akan mengembalikan nilai 1
            case '+':
            case '-':
                return 1;
            //operator */ akan mengembalikan nilai 2
            case '*':
            case '/':
                return 2;
            //operator ^ akan mengembalikan nilai 3
            case '^':
                return 3;
        }
        //defaultnya akan mengembalikan nilai 0 (selain dari yang atas)
        return 0;
    }
    //membuat fungsi tipe String bernama intoPostFix dengan parameter String persamaan
    static String intoPostFix (String persamaan){
        //membuat variabel spaceString tipe string yang akan menampung hasil output dari fungsi ini
        String spaceString = "";
        //membuat perulangan dari 0 sampai kurang dari banyaknya karakter variabel persamaan
        for (int i = 0; i < persamaan.length(); i++) {
            //membuat variabel tipe char dengan nama spcaeChar yang akan menampung hasil perulangan dari
            //karakter variabel persamaan
            char spaceChar = persamaan.charAt(i);
            //membuat kondisi jika karakter itu Huruf atau angka (operand)
            if (Character.isLetterOrDigit(spaceChar)){
                //maka karakter itu akan ditampung ke spaceString
                spaceString += spaceChar;
            //jika karakter itu kurung buka
            }else if (spaceChar == '('){
                //maka akan dimasukan ke stack
                Stack.push(spaceChar);
            //jika karakter kurung tutup
            }else if (spaceChar == ')'){
                //maka selama stack tidak kosong dan karakter dari top stacknya bukan kurung buka
                while (!Stack.isEmpty() && Stack.peek() != '('){
                    //maka spacString akan menampung juga karakter dari top stack itu
                    spaceString += Stack.peek();
                    //kemuadian dilakukan pop untuk mengeluarkan karater dari stack
                    Stack.pop();
                }
                //setalah selesai perulangan while maka semua karakter akan dipop
                Stack.pop();
            //jika semua kondisi tidak terpenuhi
            }else {
                //maka selama stack tidak kosong dan nilai lever dari karakter lebih rendah atau sama dengan lever karakter pada top stack
                while (!Stack.isEmpty() && presendence(spaceChar) <= presendence(Stack.peek())){
                    //maka spacString akan menampung juga karakter dari top stack itu
                    spaceString += Stack.peek();
                    //kemuadian dilakukan pop untuk mengeluarkan karater dari stack
                    Stack.pop();
                }
                //setalah selesai perulangan while maka semua karakter akan diush
                Stack.push(spaceChar);
            }
            
        }
        //setalah semua perualangan for selesai maka 
        //selama stack tidak kosong 
        while (!Stack.isEmpty()){
            //maka spacString akan menampung juga karakter dari top stack itu
            spaceString += Stack.peek();
            //kemuadian dilakukan pop untuk mengeluarkan karater dari stack
            Stack.pop();
        }
        //hasil terakhir dari spaceString akan direturn
        return spaceString;
    }
    
    //membuat fungsi tipe string intoPrefic dengan parameter tring persamaan
    static String intoPreFix (String persamaan){
        //membuat variabel spaceString untuk menampung hasil akhir
        //dan spcaeReverse untuk menampung hasil pemmbalikan
        String spaceString = "";
        String spaceReverse = "";
        //membuat perulangan dari kanan ke kiri (dibalik)
        for (int i = persamaan.length()-1 ; i >= 0; i--) {
            //selama perulangan maka akan dicek
            switch (persamaan.charAt(i)) {
                //jika kurang buka maka akan diganti kurung tutup
                case '(':
                    spaceReverse+= ')';
                    break;
                //jika kurung tutup maka akan diganti kurung buka
                case ')':
                    spaceReverse += '(';
                    break;
                //selain dari pada itu tidak perlu ganti
                //dan semunya akan ditampung ke spaceReverse
                default:
                    spaceReverse += persamaan.charAt(i);
                    break;
            }        
        }
        //hasil dari pembalikan maka akan dimasukan ke dalam fungi intoPostFix
        String spacePostFix = intoPostFix(spaceReverse);
        //untuk menjadikan prefix maka hasil yang ditampung ke spacePostFix dibalik
        for (int i = spacePostFix.length()-1; i >= 0; i--) {
            spaceString += spacePostFix.charAt(i);
        }
        //nilai spaceString dikembalikan
        return spaceString;
    }
}

//membuat class nomor3 yang berisi main function
public class nomor3 {
    //membuat main function untuk menjalankan program
    public static void main(String[] args) {
        //mengisi persamaan ke inputString yang akan diubah
        String inputString = "(A+B)*C-(D-E)*(F+G)";
        
        System.out.println("===Convert InFix to PreFix and PostFix==");
        System.out.println("-----------------------------------------");
        //memgeprint inputString
        System.out.println("Notasi Infix   : "+inputString);
        System.out.println("-----------------------------------------");
        //inputString akan dimasukan ke fungsi intoPostFix
        System.out.println("Notasi PostFix : "+Converter.intoPostFix(inputString));
        //inputString akan dimasukan ke fungsi intoPreFix
        System.out.println("Notasi PreFix  : "+Converter.intoPreFix(inputString));
        System.out.println("-----------------------------------------");
    }
}
