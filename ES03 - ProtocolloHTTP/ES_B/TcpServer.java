/**
 * Implementazione di un server web utilizzando la comunicazione tramite socket.
 * Lettura dati multi riga provenienti dal client
 * 
 * Autore: Ballaboio Matteo
 * Classe: 5H
 * Data: 29/11/2022
 */
 
package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) throws Exception {
		
		final int SERVER_PORT=8765;
		String clientMsg = "";
		String serverMsg = "";
		
		try {			 
			// Creazione del socket sul server e ascolto sulla porta
			ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("Server: in ascolto sulla porta " + SERVER_PORT);

			boolean endConn=false;
			while(!endConn) {
				// Attesa della connessione con il client
				System.out.println("\nAttesa ricezione dati dal client ....................... \n");
				Socket clientSocket = serverSocket.accept();
				
				// Create output stream to write data and input stream to read data from socket
				DataOutputStream outStream = new DataOutputStream(clientSocket.getOutputStream());	
				BufferedReader inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
				
                //Lettura dati dal client un righa alla volta   
                clientMsg=inStream.readLine();
				System.out.println(clientMsg);	
		 
                // Elaborare qui i dati ricevuti dal client 

                clientMsg.trim();	//tolgo gli spazi all'inizio e alla fine della stringa
				String ArrayMessaggio[]=clientMsg.split("\\s+");

				//Invio dei dati su stream di rete al client
				serverMsg = "HTTP/1.1 200 OK\r\n";
				//serverMsg += "Connection: close\r\n";
				serverMsg += "Content-Type: text/html\r\n"; 
                serverMsg += "\r\n";
				
				//possibili messaggi inviati dal browser
                switch(ArrayMessaggio[1]) {
                   
				    case "/": serverMsg += "Saluti da Ballabio Matteo";
                              break;

                    case "/ON": serverMsg += "Ok, ho acceso le luci";
                                     break;

                    case "/OFF": serverMsg += "Ok, ho spento le luci";
                                    break;

                    default : 	serverMsg += "Qualcosa è andato storto";           
                }

            	System.out.print(serverMsg + "\n");		
                outStream.write(serverMsg.getBytes());
				outStream.flush();

				System.out.println("\n....................... Fine ricezione dati\n");
				//Close resources
				clientSocket.close();
				inStream.close();
				outStream.close();
			}

			// Close resources
			serverSocket.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}