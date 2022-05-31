import java.util.*;
import java.util.Arrays;

import javax.management.Query;
public class Graph {
    int size = 0;
    Vertex[] vertex = new Vertex[size];

    void addVertex(String kota){
        vertex[size++] = new Vertex(kota);
    }

    void addEdge(int source, int destination, int distance){
        vertex[source].edge = new Edge(destination, vertex[source].edge, distance);
        vertex[destination].edge = new Edge(source, vertex[destination].edge, distance);
    }

    //menghitung jumlah tetangga dari sebuah kota
    int countNeighbourt(int nomorKota){
        Edge current = vertex[nomorKota].edge;
        int jumNeighbour = 0;
        while(current != null){
            current = current.next;
            jumNeighbour++;
        }
        return jumNeighbour;
    }

    //menghitung jarak terpendek dari semua tetangga
    //yang ada di sebuah kota
    int count(int nomorKota){
        Edge temp = vertex[nomorKota].edge;
        int totalDistance = 0;
        while(temp != null){
            int vertexKota = temp.nomorKota;
            Edge current = vertex[vertexKota].edge;
            while(current != null){
                totalDistance += current.distance;
                current = current.next;
            }
            temp = temp.next;
        }
        return totalDistance;
    }

    //menelusuri tetangga-tetangga dari sebauh kota
    //yang dipilih
    void telurusi(int nomorKota){
        boolean [] route = new boolean[size];
        
    }
}
