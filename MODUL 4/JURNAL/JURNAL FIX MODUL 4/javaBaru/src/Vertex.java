//membuat class vertex untuk membuat object vertex 
//sebagai bagian dari graph yang mana didalamnya 
//terdapat variabel dan constructor
public class Vertex {
    //membuat variabel dengan nama city bertipe data String
    //karena akan menampung nama kota
    public String city; 
    //membuat variabel dengan nama wasVisited bertipe data boolean
    //yang akan memuat nilai true dan false
    //dan penenda vertex mana yang sudah dikunjungi    
    public boolean wasVisited; 
    //membuat constructor yang memiliki nama yang sama dengan nama kelas
    //dan memuat parameter city bertipe String 
    public Vertex(String city) {   
        //men-set variabel city dimasukan nilai parameter      
        this.city = city; 
        //men-set variabel wasVisited dengan nilai false.        
        wasVisited = false;     
    } 
}
