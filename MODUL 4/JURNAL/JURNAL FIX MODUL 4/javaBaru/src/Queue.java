//membuat class queue untuk membantu dalam
//proses transversal pada graph
public class Queue {
    //membuat variabel dengan nama size bertipe integer
    //dan diset 20 sebagai nilai awalnya
    private final int SIZE = 20;  
    //membuat array dengan nama queArray satu dimensi
    //dengan tipe integer
    //queArray akan menampung data queue   
    private int[] queArray;     
    //membuat variabel front dengan tipe integer
    //yang akan menunjuk ke data paling depan dalam queue
    private int front;  
    //membuat variabel rear dengan tipe integer
    //yang akan menunjuk ke data paling belakang dalam queue   
    private int rear;     
    //membuat construcor yang akan 
    //dipanggil pertama kali ketika objec class queue dibuat
    public Queue() {       
        //didalamnya queArray dibuat object baru 
        //dengan nilai array dimasukan variabel size 
        queArray = new int[SIZE];      
        //variabel front diset 0   
        front = 0; 
        //variabel rear diset -1        
        rear = -1;     
    }      
    //membuat fungsi insert yang berguna untuk memasukan data baru dalam 
    //queue dengan parameter j bertipe integer
    //data yang diinsert ditempatkan pada bagian paling belakang queue
    public void insert(int j) {   
        //membuat percabangan jika variabel rear sama dengan variabel 
        //SIZE dikurang 1      
        if(rear == SIZE-1)  
        //makan variabel rear diset -1   
        rear = -1;         
        //dan queArray ditambah data pada variabel j
        //rear akan ditambah satu setiap data dimasukan
        queArray[++rear] = j;     
    }        
    //membuat fungsi remove yang digunakan untuk menghapus
    //data pada queue
    //data yang dihapus adalah data yang paling depan queue
    public int remove() {      
        //membuat variabel temp yang digunakan sebagai variabel bantu
        //variabel ini akan menampung data pada queArray   
        int temp = queArray[front++];    
        //jika nilai front sama dengan nilai size      
        if(front == SIZE)        
        //maka front akan diset 0 
        front = 0;   
        //dan nilai temp direturn      
        return temp;
    }      
    //membuat variabel isEmpty dengan tipe data boolean 
    public boolean isEmpty(){   
        //yang akan mereturn nilai front sama dengan rear+1
        //atau front+SIZE-1 sama dengan rear. 
        return ( rear+1==front || (front+SIZE-1==rear) );  
    } 
}
