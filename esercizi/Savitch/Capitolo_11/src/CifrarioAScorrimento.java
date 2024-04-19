//implements DecodificatoreMessaggio per risolvere il Programma 4.
public class CifrarioAScorrimento implements CodificatoreMessaggio, DecodificatoreMessaggio {
    private int chiave;

    public CifrarioAScorrimento(int chiave) {
        this.chiave = chiave;
    }

    public String codifica(String testoInChiaro) {
        String testoCifrato = "";
        for(int i=0; i<testoInChiaro.length(); i++){
            char c = testoInChiaro.charAt(i);
            testoCifrato = testoCifrato + spostaCarattere(c);
        }
        return testoCifrato;
    }

    private Character spostaCarattere(char c){
        return (char)(c + chiave);
    }

    //metodo dell'interfaccia DecodificatoreMessaggio per risolvere il Programma 4.
    public String decodifica(String testoCodificato){
        String plainText = "";
        for(int i=0; i<testoCodificato.length(); i++){
            Character c = testoCodificato.charAt(i);
            plainText = plainText + decodeCharacter(c);
        }
        return plainText;
    }
    private Character decodeCharacter(Character c){
        return (char)(c - chiave);
    }

    
    public static void main(String[] args) {
        CifrarioAScorrimento shiftBy3 = new CifrarioAScorrimento(3);    
        
        String inChiaro = "Un messaggio da cifrare";
        System.out.println("Testo in chiaro: " + inChiaro);
        String cifrato = shiftBy3.codifica(inChiaro);
        System.out.println("Testo cifrato: " + cifrato);
        
        CifrarioAScorrimento shiftByMinus3 = new CifrarioAScorrimento(-3);
        String decoded = shiftByMinus3.codifica(cifrato);
        System.out.println("Ritorno al testo in chiaro con uno scift di -3: " + decoded);


        // Per progetto 4
     	System.out.println("\nVerifica decodifica " );        
        decoded = shiftBy3.decodifica(cifrato);
        System.out.println("Testo in chiaro: " + decoded);
    }
}




