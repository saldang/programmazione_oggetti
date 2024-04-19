package albergo.camere;

import albergo.clienti.Cliente;

public abstract class Camera {
    public final int LIBERA=1;
	public final int SPORCA=2;
	public final int OCCUPATA=7;
	public final int PULITA=4;

	private  int stato=LIBERA;
	private int tariffa=60;
	protected Cliente[] clienti; //Lista clienti
	final int posti;
    private int postiOccupati=0;

	protected Camera(int x){
		posti=x;
		clienti=new Cliente[posti];
		}
	public int getStato(){return stato;}
	public void setStato(int s){stato=s;}
	public int getTarffa(){return tariffa;}
	public void setTariffa(int t){tariffa=t;}
	public final void addCliente(Cliente cliente)
	{
        clienti[postiOccupati]=cliente;
		postiOccupati++;
	}

	public abstract void pulisci();
	public abstract String optional();
	public abstract String categoria();
	public Cliente[] getClienti(){return clienti;}
	public void occupa(){stato=OCCUPATA;}
	public void libera(){stato=LIBERA+SPORCA;}

}
