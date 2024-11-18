class Contatore {
	int cont=0;
	public void incr() {  cont++; }
	
	public static void main(String args[]) {  
		Contatore a=new Contatore();
		Contatore b=new Contatore();
		a.incr();
		System.out.println(a.cont);			
		System.out.println(b.cont);			
		b=a; // copia i riferimenti
		System.out.println(a.cont);			
		System.out.println(b.cont);			
		b.incr();	
		System.out.println(a.cont);			
		System.out.println(b.cont);
        a.incr();	
		System.out.println(a);			
		System.out.println(b);			
	}	
}
