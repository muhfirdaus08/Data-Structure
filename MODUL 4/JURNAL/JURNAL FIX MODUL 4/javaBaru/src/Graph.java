//membuat class graph yang akan berisi construktor dan fungsi penambahan vertex, 
//edge, display dan fungsi trasversal graph
public class Graph {
    //membuat variabel final max_verts yang 
    //bertipe integer dan diset nilai 20
    private final int MAX_VERTS = 20;     
    //membaut vertexList sebagai array satu dimensi 
    //yang akan menampung objec Vertex
    private Vertex vertexList[];    
    //membuat array dua dimensi dengan nama adjMat bertipe integer  
    private int adjMat[][];  
    //membuat variabel nVerts bertipe integer   
    private int nVerts;   
    //membuat objec dari Stack bernama theStack  
    private Stack theStack;  
    //membuat objec dari Queue bernama theQueue 
    private Queue theQueue;  

    //membuat constructor yang akan dipanggil 
    //pertama kali pada saat membuat objec
    public Graph() {    
        //mengisi vertexList dengan objec baru dari Vertex     
        vertexList = new Vertex[MAX_VERTS];   
        //mengisi adjMat dengan array max_verts      
        adjMat = new int[MAX_VERTS][MAX_VERTS]; 
        //set nilai nVerts sama dengan nol        
        nVerts = 0;  
        //membuat perulangan yang dimulai dari j sama dengan 0
        //hingga j sama dengan max_verts       
        for(int j=0; j<MAX_VERTS; j++) 
        //membuat perulangan yang dimulai dari k sama dengan 0
        //hingga k sama dengan max_verts          
        for(int k=0; k<MAX_VERTS; k++)
        //men-set adjMat sama dengan 0 mengikuti nilai j dan k
        adjMat[j][k] = 0;  
        //membuat objec baru dari theStack       
        theStack = new Stack();  
        //membuat objec baru dari theQueue       
        theQueue = new Queue();     
    }          
    //membuat fungsi untuk menambahkan Vertex baru 
    //dengan parameter city bertipe String
    public void addVertex(String city){ 
        //mengisi array vertexList dengan index nVerts ditambah 1
        //dan dengan objec baru Vertex dengan parameter city       
        vertexList[nVerts++] = new Vertex(city);
    }      
    //membuat fungsi addEdge yang berfungsi untuk menghubungkan 
    //antara dua vertex dengan parameter start yang menujukan vertex awal
    //dan parameter end yang menujukan vertex ahir dengan tipe integer
    public void addEdge(int start, int end){   
        //setiap kali fungsi ini dipanggil maka adjMat dengan index start dan end di set 1      
        adjMat[start][end] = 1;
        //dan setiap kali fungsi ini dipanggil maka adjMat 
        //dengan index end dan start di set 1               
        adjMat[end][start] = 1;     
    }      
    //membuat fungsi untuk menampilkan salah satu 
    //dari vertex dengan parameter v beripe integer yang akan menunjuk index mana dari
    //vertexList yang akan ditampilkan 
    public void displayVertex(int v){  
        //menceteak vertexList yang menunjuk ke nama city dengan index v        
        System.out.print(vertexList[v].city+" ");    
    }
    //membuat fungsi untuk menampilkan suatu vertex dengan vertex lain
    //yang terhubung dengan tipe void tanpa pengembalian niali
    public void adjencyList (){
        //membuat perulangan bersarang
        //membuat perulangan dari 0 hingga mencapai sebelum nilia pada nVerts
        //dengan index row
        for (int row = 0; row < nVerts; row++) {
            //menampilkan pada layar vertex dengan index row
            System.out.print("Vertex : "+vertexList[row].city+" --> ");
            //membuat perulangan dari 0 hingga mencapai sebelum nilia pada nVerts
            //dengan index col
            for (int col = 0; col < nVerts; col++) {
                //membuat percabangan
                //jika adjMat dengan index row dan col bernilai sama dengan satu
                //artinya vertex ini terhubung dengan vertex yang ditampilkan di atas
                if(adjMat[row][col] == 1){
                    //maka tampilkan vertex yang terhubung dengannya 
                    //mengikuti index colom
                    System.out.print(vertexList[col].city+" ");
                }
            }
            //membuat baris baru setelah menampilkan 
            //semua vertex yang terhubung 
            System.out.println();
        }
        //membuat baris baru setelah menampilkan vertex beserta 
        //dengan vertex yang terhubung
        System.out.println();
    }
    //membuat fungsi dfs dengan tipe void yang tanpa mengembalikan nilai
    public void dfs(){    
        //men-set vertexlist yang menunjuk ke wasVisited dengan index 0 sama dengan true      
        vertexList[0].wasVisited = true; 
        //memanggil fungsi displayVertex dengan parameter 0        
        displayVertex(0);  
        //memanggil fungsi push dari theStack dengan parameter 0        
        theStack.push(0);  
        //membat perulangan while dimana selema theStack yang menunjuk ke
        //fungsi isEmpty tidak sama dengan 0         
        while( !theStack.isEmpty() ){
            //maka
            //membuat variabel v dengan tipe integer yang diset nilainya sama dengan 
            //fungsi getAdjUnvisitedVertex dengan paramater fungsi peek objec theStack  dari class Stack                     
            int v = getAdjUnvisitedVertex( theStack.peek() );         
            //membuat percabangan jika v sama dengan -1     
            if(v == -1)
                //maka panggil obejc theStack yang menunjuk ke fungsi pop
                theStack.pop();             
            else{   
                //jika v tidak sama dengan -1 
                //maka vertexList dengan index v dan menunjuk ke wasVisited diset true              
                vertexList[v].wasVisited = true; 
                //memanggil fungsi displayVertex dengan parameter v                 
                displayVertex(v); 
                //memamnggil objec theStack yang menunjuk ke fungsi push                    
                theStack.push(v);
            }         
        }
        //setelah keluar dari perulangan while maka dibuatkan perulangan for
        //yang dimulai dari j sama dengan 0 higga j sebelum sama dengan nVerts         
        for(int j=0; j<nVerts; j++)   
        //selama memenuhi perulangan maka vertexList dengan index j yang menunjuk ke variabel wasVisited
        //diset sama dengan false       
        vertexList[j].wasVisited = false;     
    }
    //membuat fungsi bfs dengan tipe void tanpa pengembalian nilai
    public void bfs(){
        //vertexList dengan index 0 yang menunjuk ke 
        //variabel wasVisited diset sama dengan true        
        vertexList[0].wasVisited = true;    
        //memanggil fungsi displayVertex dengan parameter 0           
        displayVertex(0);   
        //memanggil fungsi push dari theStack dengan parameter 0       
        theQueue.insert(0); 
        //mendeklarasikan variabel v2 dengan tipe integer         
        int v2;     
        //membat perulangan while dimana selema theStack yang menunjuk ke
        //fungsi isEmpty tidak sama dengan 0     
        while( !theQueue.isEmpty() ){  
            //maka 
            //membuat variabel v dengan tipe integer yang diset nilainya sama dengan 
            //fungsi getAdjUnvisitedVertex dengan paramater fungsi peek objec theStack  dari class Stack           
            int v1 = theQueue.remove();  
            //membat perulangan while dimana selama variabel v2 dengan nilai yang berasal dari 
            //fungsi getAdjUnvisitedVertex dengan paramter v1 tidak sama dengan -1                     
            while( (v2=getAdjUnvisitedVertex(v1)) != -1 ){    
                //maka
                //maka vertexList dengan index v2 dan menunjuk ke wasVisited diset true               
                vertexList[v2].wasVisited = true;      
                //memanggil fungsi displayVertex dengan parameter v            
                displayVertex(v2);       
                //memamnggil objec theStack yang menunjuk ke fungsi push            
                theQueue.insert(v2);              
            }         
        } 
        //setelah keluar dari perulangan while maka dibuatkan perulangan for
        //yang dimulai dari j sama dengan 0 higga j sebelum sama dengan nVerts                   
        for(int j=0; j<nVerts; j++)     
        //selama memenuhi perulangan maka vertexList dengan index j yang menunjuk ke variabel wasVisited
        //diset sama dengan false     
        vertexList[j].wasVisited = false;     
    } 
    //membuat fungsi getAdjUnvisitedVertex dengan tipe integer dan memiliki paramter
    //v dengan tipe integer yang berfungsi untuk 
    //mengetahui index vertex mana yang belum dikunjungi
    public int getAdjUnvisitedVertex(int v){  
        //membuat perulangan for
        //yang dimulai dari j sama dengan 0 higga j sebelum sama dengan nVerts        
        for(int j=0; j<nVerts; j++)
        //membuat percabangan jika adjMat dengan index v dan j sama dengan 1 dan 
        //vertexList dengan index j yang menunjuk ke variabel wasVisited sama dengan false         
        if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)  
        //makan kembalikan nilai j       
        return j; 
        //atau kembalikan nilai sama dengan -1.        
        return -1;      
    }
}
