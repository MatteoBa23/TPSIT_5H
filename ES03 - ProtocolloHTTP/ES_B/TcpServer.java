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
		
		try {			 
			// Creazione del socket sul server e ascolto sulla porta
			ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("Server: in ascolto sulla porta " + SERVER_PORT);

			boolean endConn=false;
			while(!endConn) {
				// Attesa della connessione con il client
				System.out.println("Attesa ricezione dati dal client ....................... \n");
				Socket clientSocket = serverSocket.accept();
				
				// Create output stream to write data and input stream to read data from socket
				DataOutputStream outStream = new DataOutputStream(clientSocket.getOutputStream());	
				BufferedReader inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
				// ---------------------------------------------------------
				//Lettura dati dal client un righa alla volta   
				while ((clientMsg=inStream.readLine()).length() != 0) {
					System.out.println(clientMsg);	
					if(clientMsg.equals("ON"))
                   		clientMsg+="Accendo le luci";
                	else if(clientMsg.equals("OFF"))
                    	clientMsg+="Spengo le luci";
				}  
                

				//Invio dei dati su stream di rete al client
				clientMsg = "HTTP/1.1 200 OK\r\n";
				clientMsg += "\r\n";
				clientMsg += "Saluti da Matteo Ballabio";
				outStream.write(clientMsg.getBytes());
				outStream.flush();
				System.out.println("\n....................... Fine ricezione dati\n");

                
				// Close resources
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
