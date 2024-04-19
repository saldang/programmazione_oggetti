public class Quadrato2 extends Rettangolo {
	public Quadrato2() {
		super();
	}

	public Quadrato2(int scostamento, int lato) {
		super(scostamento, lato, lato);
	}

	public void reset(int scostamento, int lato) {
		super.reset(scostamento, lato, lato);
	}
}