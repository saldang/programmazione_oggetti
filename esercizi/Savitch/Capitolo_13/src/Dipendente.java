public class Dipendente extends Persona {
	private double retribuzioneAnnuale; // Annuale
	private int dataAssunzione; // anno in 4 cifre
	private String id; 

	public Dipendente() {
		super();
		setRetribuzioneAnnuale(0);
		setDataAssunzione(1000); // Un anno impossibile
		setId("000-00-0000");
	}

	public Dipendente(String nome) {
		super(nome);
		setRetribuzioneAnnuale(0);
		setDataAssunzione(1000); // Un anno impossibile
		setId("000-00-0000");
	}

	public Dipendente(String nome, double retribuzioneAnnuale) {
		super(nome);
		setRetribuzioneAnnuale(retribuzioneAnnuale);
		setDataAssunzione(1000); // Un anno impossibile
		setId("000-00-0000");
	}

	public Dipendente(String nome, int dataAssunzione) {
		super(nome);
		setRetribuzioneAnnuale(0);
		setDataAssunzione(dataAssunzione);
		setId("000-00-0000");
	}

	public Dipendente(String nome, String id) {
		super(nome);
		setRetribuzioneAnnuale(0);
		setDataAssunzione(1000); // Un anno impossibile
		setId(id);
	}

	public Dipendente(String nome, double retribuzioneAnnuale, int dataAssunzione) {
		super(nome);
		setRetribuzioneAnnuale(retribuzioneAnnuale);
		setDataAssunzione(dataAssunzione);
		setId("000-00-0000");
	}

	public Dipendente(String nome, double retribuzioneAnnuale, String id) {
		super(nome);
		setRetribuzioneAnnuale(retribuzioneAnnuale);
		setDataAssunzione(1000); // Un anno impossibile
		setId(id);
	}

	public Dipendente(String nome, int dataAssunzione, String id) {
		super(nome);
		setRetribuzioneAnnuale(0);
		setDataAssunzione(dataAssunzione);
		setId(id);
	}

	public Dipendente(String nome, double retribuzioneAnnuale, int dataAssunzione, String id) {
		super(nome);
		setRetribuzioneAnnuale(retribuzioneAnnuale);
		setDataAssunzione(dataAssunzione);
		setId(id);
	}

	public void set(String nome, double retribuzioneAnnuale, int dataAssunzione, String id) {
		setNome(nome);
		setRetribuzioneAnnuale(retribuzioneAnnuale);
		setDataAssunzione(dataAssunzione);
		setId(id);
	}

	public void scriviOutput() {
		super.scriviOutput();
		System.out.println("retribuzione annuale: " + retribuzioneAnnuale);
		System.out.println("data assunzione: " + dataAssunzione);
		System.out.println("identificativo : " + id);
	}

	public void scriviNome() {
		super.scriviOutput();
	}

	public void setRetribuzioneAnnuale(double retribuzioneAnnuale) {
		this.retribuzioneAnnuale = retribuzioneAnnuale;
	}

	public double getRetribuzioneAnnuale() {
		return retribuzioneAnnuale;
	}

	public void scriviRetribuzioneAnnuale() {
		System.out.println("Retribuzione annuale: €" + retribuzioneAnnuale);
	}

	public void setDataAssunzione(int dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public int getDataAssunzione() {
		return dataAssunzione;
	}

	public void scriviDataAssunzione() {
		System.out.println("Data assunzione (anno): " + dataAssunzione);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void scriviId() {
		System.out.println("Identificativo #: " + id);
	}

	public boolean equals(Dipendente altroDipendente) {
		return (this.haLoStessoNome(altroDipendente) && this.getRetribuzioneAnnuale() == altroDipendente.getRetribuzioneAnnuale()
				&& this.dataAssunzione == altroDipendente.getDataAssunzione()
				&& this.id.equalsIgnoreCase(altroDipendente.getId()));
	}
}