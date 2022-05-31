public class Edge {
    int distance, nomorKota;
    Edge next;

    Edge(int nomorKota, Edge next, int distance){
        this.next = next;
        this.distance = distance;
        this.nomorKota = nomorKota;
    }
}
