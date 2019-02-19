package Iterator_Lab;

public class Main {

	public static void main(String[] args) {
		NameRepository nm = new NameRepository(2);
		while(nm.getIterator().hasNext()) {
		System.out.println(nm.getIterator().next());
	}
		System.out.println(nm.getIterator().hasNext());
	}
}
