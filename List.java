package listaJava;

import java.security.acl.LastOwnerException;

import javax.crypto.NullCipher;

class List implements Comparable{
    Node head;
    int length = 0;

    //append
    public List append(Comparable n){
        if (head == null) {
            head = new Node(n);
            length++;
            return this;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(n);
        length++;
        return this;
    }

    //insertAt
    public List insertAt(int pos, Comparable info) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > length) {
            throw new IndexOutOfBoundsException("Posizione fuori dal range");
        }

        Node newNode = new Node(info);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
        }

        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == pos - 1) {
                newNode.next = current.next;
                current.next = newNode;
            }
            current = current.next;
            count++;
        }
        length++;
        return this;
    }

    //removeAt
    public List removeAt(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > length) {
            throw new IndexOutOfBoundsException("Posizione fuori dal range");
        }

        if(pos == 0){
            head = head.next;
        }

        
        if(pos == length){
            Node current = head;//.next;
            while(current != null){
                current = current.next;
            }
            current = null;
        }
        

        Node current = head;
        int conta = 0;
        while (current != null) {
            if (pos-1 == conta) {
                current.next = current.next.next;
            }
            conta++;
            current = current.next;
        }
        length--;
        return this;
    }

    //get from position
    public Object get(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > length) {
            throw new IndexOutOfBoundsException("Posizione fuori dal range");
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == pos) {
                return current.info;
            }
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Posizione fuori dal range");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.info).append(" ");
            current = current.next;
        }
        return result.toString();
    }  

    @Override
    public int compareTo(Object o) {
        if(length < ((List)o).length) return -1;
        if(length > ((List)o).length) return 1;
        //possiblilità di uguaglianza
        Node pointThis = this.head;
        Node pointO = ((List)o).head;
        for(int i = 0; i < length; i++){
            if(pointThis.compareTo(pointO) < 0)return -1;
            if(pointThis.compareTo(pointO) > 0)return 1;
            //pointThis.compareTo(pointO) < 0
            pointThis = pointThis.next;
            pointO = pointO.next;
        }
        return 0;
    }

    //clone
    public List clone() {
        List result = new List();
        result.head = this.head;
        result.length = this.length;
        return result;
    }

    //copy
    public List copy(List this){
        Node current = head;
        List result = new List();
        while(current != null){
            result.append(current.info);
            current = current.next;
        }
        return result;
    }

    //clear
    public List clear(){
        head = null;
        length = 0;
        System.out.print("la lista ora e' vuota come il mio cuore");
        return this;
    }

    //contains (c'é l'oggetto)
    public boolean contains(Comparable c) {
        Node current = head;
        while (current != null) {
            if (current.info.equals(c)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    //exist?
    public int exist(Comparable c){
        Node current = head;
        int contains = 0;
        while (current!= null){
            if (current.info.equals(c)) {
                //System.out.print("Esiste");
                return contains;
            }
            contains++;
            current = current.next;
        }
        //System.out.print("NON siste");
        return -1;
    }
    
    //swap
    public List swapE(int pos1, int pos2) throws IndexOutOfBoundsException {
        if (pos1 < 0 || pos2 < 0 || pos1 >= length || pos2 >= length) {
            throw new IndexOutOfBoundsException("Posizione invalida");
        }
    
        Node current = head;
        Node prev1 = null;
        Node prev2 = null;
        Node node1 = null;
        Node node2 = null;
    
        int count = 0;
        while (current != null) {
            if (count == pos1) {
                node1 = current;
            } else if (count == pos2) {
                node2 = current;
            } else if (count == pos1 - 1) {
                prev1 = current;
            } else if (count == pos2 - 1) {
                prev2 = current;
            }
            current = current.next;
            count++;
        }
    
        if (prev1 != null) {
            prev1.next = node2;
        } else {
            head = node2;
        }
    
        if (prev2 != null) {
            prev2.next = node1;
        } else {
            head = node1;
        }
    
        Node temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;
        return this;
    }

    //setInfo
    public List setInfo(int pos, Comparable o){
        Node current = head;
        int tempL = 0;
        while(current.next != null){
            if(tempL == pos){
                current.info = o;
            }
            tempL++;
            current = current.next;
        }
        return this;
    }

    //remove if Object exist
    public List removeObject(Comparable o) {
        int controllo = exist(o);
        if (controllo != -1){
            removeAt(controllo);
        }
        return this;
    }

    //sort String or int
    /*public List sort() {
        Node current = head;
        while (current!= null){
            if (current.next.info.compareTo(current.info) > 0) {
                current.next = current.next.next;
                current.next.next = current;
                current = current.next;
            }else{
                current = current.next;
            }
        }
        return this;
    }*/
    /*public List sort() {
        if (head == null) {
            return this;
        }
    
        for (int i = 0; i < length - 1; i++) {
            Node current = head;
            Node previous = null;
            for (int j = 0; j < length - i - 1; j++) {
                if (current.compareTo(current.next) > 0) {
                    if (previous != null) {
                        Node temp = current.next;
                        previous.next = temp;
                        current.next = temp.next;
                        temp.next = current;
                    } else {
                        Node temp = current.next;
                        head = temp;
                        current.next = temp.next;
                        temp.next = current;
                    }
                }
                previous = current;
                current = current.next;
            }
        }
        return this;
    }
    */

    //unAppend
    public List unAppend() throws IndexOutOfBoundsException {
        if (head == null) {
                throw new IndexOutOfBoundsException("La lista è vuota, cos'e' vuoi toglierti la vita?");
        }
        if (head.next == null) {
            head = null;
            length--;
            return this;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        length--;
        return this;
    }
    
    //insertHead
    public List insertHead(Comparable n) {
        Node newNode = new Node(n);
        newNode.next = head;
        head = newNode;
        length++;
        return this;
    }

    //reverse
    public List reverse(){
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return this;
    }

    //Node class
    class Node implements Comparable{
        //String info;
        Comparable info;
        Node next = null;

        public Node(Comparable info) {
            this.info = info;
        }

        @Override
        public int compareTo(Object o) {
            Node altro = (Node)(o);
            return info.compareTo(altro.info);
        } 
    }
}