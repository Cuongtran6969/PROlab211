/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xSea, int xSail, int xPaddle) {
    //You should write here appropriate statements to complete this function.
    if(xSea.charAt(0) == 'B') return;
    Boat newBoat = new Boat(xSea, xSail, xPaddle);
    Node newNode = new Node(newBoat);
    if(isEmpty()) {
     head = tail = newNode;
    } else {
     tail.next = newNode;
     tail = newNode;
     tail.next = null;
    }
   }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Boat x, y, z;
     x = new Boat("X",1,2);
     y = new Boat("Y",2,3);
     z = new Boat("Z",3,4);

     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      insertIndex(new Node(x), 2);
      insertIndex(new Node(y), 3);
      insertIndex(new Node(z), 5);

    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  
    public int numberNode() {
        Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
    public void insertIndex(Node x, int index) {
        if (index == (numberNode() + 1)) {
            tail.next = x;
            tail = x;
            return;
        }
        Node p = head;
        Node par = null;
        int count = 0;
        while (p != null) {
            if (count == index) {
                break;
            }
            count++;
            par = p;
            p = p.next;
        }

        if (p != null) {
            if (p == head) {
                x.next = head;
                head = x;
            } else {
                par.next = x;
                x.next = p;
            }
        }
    }
//==================================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

      moverSecondNode();
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }   
    double findMax() {
        Node p = head;
        double max = head.info.sail;
        while (p != null) {
            if (p.info.sail > max) {
                max = p.info.sail;
            }
            p = p.next;
        }
        return max;
    }
    
    int counf3 = 0;
    public void moverSecondNode() {
     if(isEmpty()) return;
     Node p = head;
     Node par = null;
     Node temp = null;
        while (p != null) {
            if (p.info.sail == findMax()) {
                counf3++;
            }
            if (counf3 == 2) {
                Boat tempBoat = new Boat(p.info.sea, p.info.sail, p.info.paddle);
                temp = new Node(tempBoat);
                break;
            }
            par = p;
            p = p.next;
        }
        if (p != null) {
            if (p == tail) {
                tail = par;
                tail.next = null;
                temp.next = head;
                head = temp;
            } else {
                par.next = p.next;
                temp.next = head;
                head = temp;
            }
        }
    }
//==================================================================
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      sortf4();


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }
  int counf4 = 0;
    public void sortf4() {
        Node p = head;
        Node startNode = head;
        Node endNode = null;
        while (p != null) {
            if (counf4 == 2) {
                startNode = p;
            }
            if (counf4 == 6) {
                endNode = p;
            }
            counf4++;
            p = p.next;
        }
        Node pi, pj;
        Boat boat;
        pi = startNode;
        while (pi != endNode) {
            pj = pi.next;
            while (pj != endNode) {
                if (pi.info.sail > pj.info.sail) {
                    boat = pi.info;
                    pi.info = pj.info;
                    pj.info = boat;
                } 
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
 }

