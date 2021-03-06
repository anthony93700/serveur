import java.net.*;

public class MultiServerHTTPsql { 
	private ServerSocket ss;
	public MultiServerHTTPsql (int port) throws Exception {
		ss = new ServerSocket(port); 
		System.out.println("Server Started");	
	}  

	/* lance un Serveur HTTP : plusieurs threads */
	public void lancer() throws Exception { 
		while (true) {
		// attente connexion : bloquant, creation d'un clone du socket ss
			Socket socket = ss.accept();
			// cree un nouveau thread pour la nouvelle connexion.
			ServeOnesql so = new ServeOnesql(socket);
			so.start(); 
		}
	} 
} // end class  MultiServerHTTP
