package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

class TcpServer extends Thread {
	Socket serverClientSocket;
	int clientNo;
	
	TcpServer(Socket inSocket, int ClientNo) {
		serverClientSocket = inSocket;
		clientNo = ClientNo;
	}

	public void run() {
		try {
			// Streams to read and write the data to socket streams
			DataInputStream inStream = new DataInputStream(serverClientSocket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(serverClientSocket.getOutputStream());

			String cMsg = "";
			String sMsg = "";
			String[][] matrice;
			matrice = new String[5][5];
			for (int i=0; i<5; i++)
			      for (int j=0; j<5; j++)
			        matrice[i][j] = "PL";
			
			
			while (!cMsg.equals("end")) {
				
				
				for (int i=0; i<5; i++) {
					  for (int j=0; j<5; j++)
				       System.out.print(matrice[i][j]+" ");
				      System.out.println(); // vado a capo dopo ogni riga
				     }
				
				//Leggiamo il messaggio proveniente dal client, e lo stampiamo a schermo
				cMsg = inStream.readUTF();
				System.out.println("Server.Thread " + clientNo + " Riga: " + cMsg );
				matrice[cMsg][j];
				
				cMsg = inStream.readUTF();
				System.out.println("Server.Thread " + clientNo + " Colonna: " + cMsg );

				
			}
			
			//Prima di chiudere la connessione viene inviato un ultimo messaggio
			sMsg="Bye";
			System.out.println("Server.Thread " + clientNo + " Invio messaggio " + cMsg );
			outStream.writeUTF(sMsg);
			outStream.flush();

			//Chiusura delle risorse utilizzate
			inStream.close();
			outStream.close();
			serverClientSocket.close();

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			System.out.println("\nArrivederci");
			System.out.println("Client " + clientNo + " si è disconnesso ");
		}
	}
}
