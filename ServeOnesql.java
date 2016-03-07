/** ServeOne.java
 * A thread server to handle  one client.
 * minimal HTTP server -- F.Butelle 2000/01
 * TODO : URL like file.cgi?params
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ServeOne extends Thread {  
	private Socket socket;
	private BufferedReader fromClient;
	private BufferedReader fluxLocal;
	private PrintWriter toClient;
    	private String requete;

	/** cree un thread serveur 
	 * @param s est le socket cree par MutiServerHTTP
	 */
	public ServeOne (Socket s) throws Exception { 
		socket = s;
		fromClient = new BufferedReader(new InputStreamReader(
						 socket.getInputStream()));
				// true : Enable auto-flush:
		toClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
						 socket.getOutputStream())), true);
		}
 
	void envoyerFluxLocal() throws Exception {
			/* Zone a completer */
	}

	void lectureFichier() {
		toClient.println("<HTML><B>Ok !!!</B><BR>");
		toClient.println("</B>Client address : " + socket.getInetAddress()); 
		System.out.println("Demande de fichier : "+requete);
		try {		
			fluxLocal =new BufferedReader(new InputStreamReader(new FileInputStream(requete)));
			toClient.println("<BR>fichier demande : "+requete+" : <BR>");
			envoyerFluxLocal();
			fluxLocal.close();
		} catch (Exception e) {
            		//e.printStackTrace();
			System.out.println("Fichier inexistant");
			toClient.println("<HTML><H1>Fichier inexistant ou illisible!</H1><BR></HTML>");
		} 
	}
   
	void appelCgi() {
		System.out.println("Demande de cgi :"+requete);
		try {				
			Process ps = /* Zone a completer */ 
			String line;
			fluxLocal = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			Thread.sleep(1); // petite attente de remplissage de buffer

			toClient.println("<BR>CGI demande : "+requete+" ; resultat :<BR>");
			envoyerFluxLocal();
			fluxLocal.close();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("FichierCGI inexistant ou non executable");
			toClient.println("<HTML><H1> CGI pas trouve</H1><BR></HTML>");
		}
	}

	void traiteRequete() { 
		try {
			String str = fromClient.readLine();
			/* Zone a completer */
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Requete illegale");
			toClient.println("<HTML><H1>Requete illegale</H1><BR></HTML>");
		}
	}
  
		/* Arret du serveur */
	void fermeture() { 
		try { 
			System.out.println("Answer Sent.");
            		System.out.println("closing...");
            		fromClient.close();
            		toClient.close();
            		socket.close();
		} catch(Exception e) { 
			e.printStackTrace();
		} 
	}

		/* traite une requete d'un client */
	public void run() {
			traiteRequete();
			fermeture();	
	} // end run  
}// end class 

