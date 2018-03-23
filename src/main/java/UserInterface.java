import java.util.*;

public class UserInterface {
	private Scanner scanner;
	private Family family;

	public UserInterface(Scanner scanner, Family family) {
		this.scanner = scanner;
		this.family = family;
	}

	public void start(){
		System.out.print("Tervetuloa käyttämään sukulaisuusverkkoa!\n");
		System.out.print(family.toString());
	}
}