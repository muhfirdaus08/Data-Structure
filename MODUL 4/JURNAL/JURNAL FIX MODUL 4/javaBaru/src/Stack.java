//membuat class stack yang akan membantu dalam 
//dalam proses transeversal pada graph
public class Stack {
    //membuat variabel yang bernama size dengan tipe integer
    //dan diset 20 sebagai nilai awal
    private final int SIZE = 20;    
    //membuat array satu dimensi bernama st dengan tipe intger 
    private int[] st;     
    //membuat variabel yang bernama top dengan tipe integer
    private int top;  
    //membuat constructor yang akan pertama kali dipanggil 
    //ketika membuat object    
    public Stack() { 
        //array st dibuat objec baru        
        st = new int[SIZE];   
        //men-set top dengan nilai -1       
        top = -1;     
    } 
    //membaut fungsi push dengan tipe void tanpa pengembalian nilai
    //push digunakan untuk menambah data pada stack dengan parameter j
    public void push(int j) { 
        //nilai array stack diisi variabel j kemudian
        //nilai top ditambah 1 setiap kali fungsi push dipanggil
        st[++top] = j; 
    }      

    //membuat fungsi pop dengan tipe integer yang akan 
    //mengembalikan nilai array st
    //fungsi pop berguna untuk mengulurkan data pada stack
    public int pop() { 
        return st[top--]; 
    }      
    //membuat fungsi peek dengan tipe integer yang akan
    //mengembalikan data paling atas pada stack
    public int peek() { 
        return st[top]; 
    }      
    //membuat fungsi isEmpty dengan tipe boolean.
    public boolean isEmpty() { 
        return (top == -1); 
    }
}