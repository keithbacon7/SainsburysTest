package sainsburystest;

public class RunAsCommand {
	public static void main(String[] args) {
		Scraper s = new Scraper();
		s.sainsburiesProductListAsJSON();
		out("Finished");
	}

	private static void out(String line) {
		System.out.println("RunAsCommand: " + line);
	}

}
