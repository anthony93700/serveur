import java.net.*;

public class MultiServerHTTP { 
	private ServerSocket ss;
	public MultiServerHTTP (int port) throws Exception {
		ss = new ServerSocket(port); 
		System.out.println("Server Started");	
	}  

	/* lance un Serveur HTTP : plusieurs threads */
	public void lancer() throws Exception { 
		while (true) {
		// attente connexion : bloquant, creation d'un clone du socket ss
			Socket socket = /* Zone a completer 1 */
			// cree un nouveau thread pour la nouvelle connexion.
			ServeOne so = new ServeOne(socket);
			so.start(); 
		}
	} 
} // end class  MultiServerHTTP
