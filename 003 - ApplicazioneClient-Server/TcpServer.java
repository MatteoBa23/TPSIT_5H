/**
 * from network/..
 * javac network/TcpServer.java; java network.TcpServer 
 */
package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) throws Exception {
		
		int severPort=8765;
		int vocali=0;
		int conso=0;
		int num=0;
		int caratteri=0;
		int spazio;
		String clientMsg = "";
		
		try {			 
			// Creazione del socket sul server e ascolto sulla porta
			ServerSocket serverSocket = new ServerSocket(severPort);
			System.out.println("Server: in ascolto sulla porta " + severPort);

			// Attesa della connessione con il client
			Socket clientSocket = serverSocket.accept();
			
			// Create input and output streams to read/write data
			DataInputStream inStream = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(clientSocket.getOutputStream());	

			// Scambio di dati tra client e server
			while(!clientMsg.equals("quit")) {
				//Lettura dato da stream di rete
				clientMsg = inStream.readUTF();
				System.out.println("\nServer: ricevuto messaggio " + clientMsg );
				
				/*
				num=0;
				for(int i=0;i<clientMsg.length();i++)
					num++;
				System.out.println("Server: lunghezza parola: "    + num);
				*/
				vocali=0;
				conso=0;
				caratteri=0;
				spazio=0;
				for (int i= 0; i < clientMsg.length(); i++)	//scorre il messaggio ricevuto
				{
					if(clientMsg.charAt(i)==('a')||clientMsg.charAt(i)==('e')||clientMsg.charAt(i)==('i')||clientMsg.charAt(i)==('o')||clientMsg.charAt(i)==('u'))
						vocali++;
					else if(clientMsg.charAt(i)==('!')||clientMsg.charAt(i)==('?')||clientMsg.charAt(i)==(';')||clientMsg.charAt(i)==('.')||clientMsg.charAt(i)==('-'))
						caratteri++;
					else if(clientMsg.charAt(i)==(' '))
						spazio++;
					else
						conso++;
				}
			
				System.out.println("\nServer: " + vocali + " vocali ");
				System.out.println("Server: " + conso + " consonanti ");
				System.out.println("Server: " + caratteri + " caratteri speciali ");
				System.out.println("Server: " + spazio + " spazio ");
				
				
				
				//Invio dati su stream di rete
				outStream.writeUTF("Echo from server : "         + clientMsg);
				outStream.flush();
				System.out.println("Server: invio messaggio al client\n");
				
			}
			
			// Close resources
			serverSocket.close();
			clientSocket.close();
			inStream.close();
			outStream.close();
			
			
					

			

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
