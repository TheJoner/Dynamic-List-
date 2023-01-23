package listaJava;
public class Main {

    public static void main(String[] args){
        List l = new List();
        List l2 = new List();
        //Ticket t1 = new Ticket(100, 1, 'c', "DEA");
        //Ticket t2 = new Ticket(10, 2, 'c', "DEA");

        l.append(1).append(0).append("a").append("Bomba Nucleare");//.append(t1);
        l2.append(0).append(1).append("a").append(1234567);//.append(t2);

        System.out.println("LE POSIZIONI PARTONO DA 0");
        System.out.println("-------------------------------");

        //append
        System.out.println("inserisci all'ultimo");
        System.out.println(l.append("Rampo GIGACHAD"));

        //insertAt inserisce a posizione
        System.out.println("inserisce a posizione");
        System.out.println(l.insertAt(2, "ciao"));

        //removeAt rimuove a posizione
        System.out.println("rimuove a posizione");
        System.out.println(l.removeAt(2));

        //metodo toString
        System.out.println("metodo toString Overwritato");
        System.out.println(l.toString());

        //clone method (clona la lista)
        System.out.println("metodo di clonazione però solo i riferimenti");
        System.out.println(l.clone());
        
        //swap (scambiare 2 elementi di una lista)
        System.out.println("scambia 2 elementi in questo caso il primo col terzo");
        System.out.println(l.swapE(1, 3));
        //rimetto a posto
        l.swapE(1, 3);

        //reverse (non con metodo di Greco)
        System.out.println("mette 'al contrario' gli elementi della List");
        System.out.println(l.reverse());
        //rimetto a posto
        l.reverse();

        //copy (crea una copia in una lista nuova ("costruttore di copia"))
        System.out.println("metodo di copia profonda della Lista");
        System.out.println(l.copy());

        //get (restiruisce l'informazione
        System.out.println("restituisce una informazione");
        System.out.println(l.get(3));

        //clear (pulisce la List)
        System.out.println("creo una copy da buttare per prova");
        System.out.println(l.copy().clear());

        //contains (verifica se esiste qualcosa in posizione)
        String bombanucleare = "Bomba Nucleare";
        System.out.println("verifica se esiste qualcosa l'oggetto e restituisce se esiste o no");
        System.out.println(l.contains(bombanucleare));

        //exist (verifica se l'oggetto richeisto essite e restituisce la posizione)
        System.out.println("verifica se l'oggetto richeisto essite e restituisce la posizione");
        System.out.println(l.exist(bombanucleare));

        //setInfo (inserisce a posizione desiderata un oggetto rimovendo il precedente (in questo caso lo provo in una copia))
        System.out.println("inserisce a posizione desiderata un oggetto rimovendo il precedente");
        System.out.println(l.copy().setInfo(0, bombanucleare));

        //removeIbject (verifica se l'oggetto desiderato esiste, in tal caso lo rimuove (in questo caso lo provo in una copia))
        System.out.println("verifica se l'oggetto desiderato esiste, in tal caso lo rimuove");
        System.out.println(l.copy().removeObject(bombanucleare));

        //unAppend (toglie l'ultimo)
        System.out.println("rimuove l'ultimo oggetto della List");
        System.out.println(l.unAppend());

        //insertHead (inserisce int testa)
        System.out.println("inserisce in testa");
        System.out.println(l.copy().insertHead(bombanucleare));


        //sort (ordina tramite String o int)                        /non funza DIOC
        //System.out.println(l.copy().sort());

        /*
        //prova del metodo compare to Overwitato
        System.out.println(l.compareTo(l2));

        //biuglietti
        System.out.println(t1.compareTo(t2));

        
        if(l.compareTo(l2)  == 0){
            System.out.println("Uguale");
        }else if(l.compareTo(l2)  == -1){
            System.out.println("Piccolo");
        }else{
            System.out.println("Grande");
        }
        */

    }
}

class Ticket implements Comparable{
    int prezzo;
    int settore;
    char fila;
    String evento;
    public Ticket(int prezzo, int settore, char fila, String evento) {
        this.prezzo = prezzo;
        this.settore = settore;
        this.fila = fila;
        this.evento = evento;
    }

    @Override
    public int compareTo(Object o) {
        Ticket altro = (Ticket)o;
        if(this.prezzo < altro.prezzo) return -1;
        if(this.prezzo > altro.prezzo) return 1;
        return 0;
    }
}