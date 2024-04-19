package es4;

class simtel {
    public static void main(String args[]) {
        String st = "000";
        SIM s = new SIM("123", 20, 5);
        s.ins("000", 3);
        s.ins("789", 5);
        System.out.println(s);
        System.out.println("totale chiamate in min:" + s.cal());
        s.ins("000", 7);
        s.ins("456", 4);
        System.out.println(s);
        System.out.println("chiamate verso:" + st + ":" + s.conta(st));
        s.ins("000", 7);
        s.ins("789", 4);
        System.out.println(s);
        System.out.println("chiamate verso:" + st + ":" + s.conta(st));
    }// fine main
}// fine classe


