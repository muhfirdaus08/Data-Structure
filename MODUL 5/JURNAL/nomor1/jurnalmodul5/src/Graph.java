public class Graph {
    private final int MAX_VERTS = 6;     
    private Vertex vertexList[];   
    private int adjMat[][];  
    private int nVerts; 

    public Graph() {    
        vertexList = new Vertex[MAX_VERTS];   
        adjMat = new int[MAX_VERTS][MAX_VERTS];     
        nVerts = 0;       
        for(int j=0; j<MAX_VERTS; j++)          
        for(int k=0; k<MAX_VERTS; k++)
        adjMat[j][k] = 0;       
    }   

    public void addVertex(String city){      
        vertexList[nVerts++] = new Vertex(city);
    }      

    public void addEdge(int start, int end){   
        adjMat[start][end] = 1;     
        adjMat[end][start] = 1;     
    }      

    public void displayVertex(int v){      
        System.out.print(vertexList[v].city+" ");    
    }

    public int getDegree (int vertexNum){
        int degreeOut = 0;
        for (int col = 0; col < nVerts; col++) {
            if(adjMat[vertexNum][col] == 1){
                vertexList[vertexNum].degree++;
                degreeOut = vertexList[vertexNum].degree;
            }
        }
        //displayOneVertex(vertexNum);    
        return degreeOut;
    }

    // public void displayOneVertex (int vertexNum){
    //     System.out.print("Degree Vertex "+vertexList[vertexNum].city+" : ");
    // }

    // public void displayDegree(){
    //     for (int i = 0; i < nVerts; i++) {
    //         System.out.println(getDegree(i));
    //     }
    // }

    public void bubbleSortDegree (){
        int []degreeba = new int [nVerts];
        for (int i = 0; i < nVerts; i++) {
            degreeba[i] = getDegree(i);
        }
        //print sebelum
        System.out.println("Sebelum");
        for (int i = 0; i < degreeba.length; i++) {
            System.out.print(degreeba[i]+" ");
        }

        //bubble sort proses decrement
        int n = degreeba.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (degreeba[j] < degreeba[j+1]){
                    // swap degreeba[j+1] and degreeba[j]
                    int temp = degreeba[j];
                    degreeba[j] = degreeba[j+1];
                    degreeba[j+1] = temp;
                }
            }
        }
        //print sesudah
        System.out.println("\nSesudah");
        for (int i = 0; i < degreeba.length; i++) {
            System.out.print(degreeba[i]+" ");
        }
    }

    public void adjencyList (){
        for (int row = 0; row < nVerts; row++) {
            System.out.print(vertexList[row].city);
            //System.out.print(" (Degree : "+getDegree(row)+") --> ");
            System.out.print(" --> ");
            for (int col = 0; col < nVerts; col++) {
                if(adjMat[row][col] == 1){
                    System.out.print(vertexList[col].city+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}