
public class SoldiDemo {

	public static void main(String[] args) {
		Soldi soldiIniziali = new Soldi();
		Soldi soldiPossibili = new Soldi();
		
		System.out.println("Scrivi il tuo saldo corrente:"); 
		soldiIniziali.leggiInput();
		soldiPossibili = soldiIniziali.moltiplica(2); 
		
		System.out.print("Se lo raddoppi avrai "); 
		soldiPossibili.scriviOutput();
		System.out.println(", e, ancora meglio,"); 
		soldiPossibili = soldiIniziali.somma(soldiPossibili); 
		System.out.println("se lo triplicherai avrai"); 
		soldiPossibili.scriviOutput(); 
		System.out.println();
		
		System.out.println("Ricorda: un centesimo risparmiato"); 
		System.out.println("e' un centesimo guadagnato.");
	}
}
