
public class PagamentoTest {
	public static void main(String[] args) {
		
		PagamentoContanti cash1 = new PagamentoContanti(50.5), cash2 = new PagamentoContanti(20.45);
		PagamentoCartaDiCredito credit1 = new PagamentoCartaDiCredito(10.5, "Fred", "10/5/2010", "123456789");
		PagamentoCartaDiCredito credit2 = new PagamentoCartaDiCredito(100, "Barney", "11/15/2009", "987654321");

		System.out.println("Dettagli contanti 1:");
		cash1.dettagliPagamento();
		System.out.println();
		System.out.println("Dettagli contanti 2:");
		cash2.dettagliPagamento();
		System.out.println();

		System.out.println("Dettagli carta credito 1:");
		credit1.dettagliPagamento();
		System.out.println();
		System.out.println("Dettagli carta credito 2:");
		credit2.dettagliPagamento();
		System.out.println();
	}
}
