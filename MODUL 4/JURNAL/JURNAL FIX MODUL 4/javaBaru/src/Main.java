//membuat class main yang digunakan untuk menjalankan program 
public class Main {
    public static void main(String[] args) {
        //membuat objec Ga dari clas Graph
        Graph Ga = new Graph();  
        //memanggil fungsi addVertex kemudian diisi nama kota 
        //dan diberi tanda urutan pemanggilan fungsi
        //fungsi yang pertama kali dipanggil memiliki urutan 0 dan seterusnya           
        Ga.addVertex("Mataram");    //0            
        Ga.addVertex("Praya");      //1         
        Ga.addVertex("Sembalun");   //2         
        Ga.addVertex("Masbagik");   //3        
        Ga.addVertex("Kopang");     //4         
        Ga.addVertex("Gerung");     //5                       
        Ga.addVertex("Selong");     //6
        //memanggil fungsi addEnge untuk menghubungkan vertex yang satu
        //dengan vertex yang lain
        Ga.addEdge(0, 5); //Mataram Gerung              
        Ga.addEdge(0, 6); //Mataram Selong           
        Ga.addEdge(0, 1); //Mataram Praya             
        Ga.addEdge(6, 3); //Selong Masbagik            
        Ga.addEdge(6, 2); //Selong Masbagik 
        Ga.addEdge(5, 4); //Gerung Kopang
        Ga.addEdge(1, 4); //Praya Kopang
        Ga.addEdge(3, 2); //Masbagik Sembalun
        Ga.addEdge(3, 4); //Masbagik Kopang

        System.out.print("\n===Adjency List===");                         
        //mamnggil fungsi adjencyList
        Ga.adjencyList();
        System.out.print("===BFS===\n");
        //memanggil fungsi bfs                         
        Ga.bfs();  
        System.out.print("\n\n===DFS===\n");      
        //memanggil fungsi dfs.                  
        Ga.dfs();            
        System.out.println("\n"); 
    }
}
