public class Main {
    public static void main(String[] args) {
        Graph nomor1 = new Graph();

        nomor1.addVertex("Alpha");  //0
        nomor1.addVertex("Betas");  //1
        nomor1.addVertex("Certas"); //2
        nomor1.addVertex("Deltas"); //3
        nomor1.addVertex("Epsas");  //4
        nomor1.addVertex("Fetas");  //5

        //kode warna
        //0 -> merah
        //1 -> kuning
        //2 -> hijau

        System.out.println();
        nomor1.addEdge(0, 1);
        nomor1.addEdge(0, 2);
        nomor1.addEdge(1, 2);
        nomor1.addEdge(1, 4);
        nomor1.addEdge(2, 3);
        nomor1.addEdge(2, 4);
        nomor1.addEdge(3, 5);
        nomor1.addEdge(4, 5);

        nomor1.adjencyList();
        nomor1.bubbleSortDegree();
        
    }
}
