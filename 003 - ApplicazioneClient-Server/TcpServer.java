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
				System.out.println("Server: ricevuto messaggio " + clientMsg );
				
				//Invio dati su stream di rete
				outStream.writeUTF("Echo from server : "         + clientMsg);
				outStream.flush();
				System.out.println("Server: invio messaggio "    + clientMsg );
				
				if(vocali/2==conso) {
					System.out.println("Programma terminato");
					//Chiudo il canale
					serverSocket.close();
					clientSocket.close();
					inStream.close();
					outStream.close();
				}else {
					for (int i= 0; i < clientMsg.length(); i++)	//scorre il messaggio ricevuto
					{
						if(clientMsg.equals("a")||clientMsg.equals("e")||clientMsg.equals("i")||clientMsg.equals("o")||clientMsg.equals("u"))
							vocali++;
						else
							conso++;
					}
				}
				
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
