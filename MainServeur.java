public class MainServeur {
	public static void main (String[] args) {
		if (args.length!=1) {
			System.out.println("donner le numero de port en parametre SVP!");
			System.exit(1);
		}
		try {
			MultiServerHTTP ms = new MultiServerHTTP(Integer.parseInt(args[0]));
			ms.lancer();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // end main       
} // end class
