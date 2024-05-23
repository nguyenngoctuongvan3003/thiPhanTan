package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


import jakarta.persistence.EntityManager;
import services.EntityManagerFactoryUtil;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket= new ServerSocket(1999);
			
			System.out.println("port 1999 san sang");
			
			while(true) {
				Socket socket= serverSocket.accept();
				
				Thread thread= new Thread(new ClientHander(socket));
				thread.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

	class ClientHander implements Runnable{
		private Socket socket;
		private EntityManagerFactoryUtil entityManagerFactoryUtil;
		private EntityManager entityManager;
		
		public ClientHander(Socket socket) {
			this.socket=socket;
			entityManagerFactoryUtil=new EntityManagerFactoryUtil("sql");
			//maria
			entityManager= entityManagerFactoryUtil.getEntityManager();
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				
				ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream outputStream= new ObjectOutputStream(socket.getOutputStream());
				int choice=0;
				
				while(true) {
					choice=inputStream.readInt();
					switch (choice) {
					case 1:
//						DocGia docGia=new DocGia((String)inputStream.readUTF(), null, null, null);
//						Sach sach = entityManager.find(Sach.class, inputStream.readUTF());
//						outputStream.writeObject(chiTietMuonSachServices.themChiTietMuonSach(docGia, sach));
//						outputStream.flush();
						break;
//					case 2:
//						Sach sach1 = entityManager.find(Sach.class, "S02");
//						sach1.setTuaSach("NNTV");
//						outputStream.writeObject(sachService.updateSach(sach1));
//						outputStream.flush();
//						break;
//					case 3:
//						List<DocGia> list = docGiaServices.getDSDocGia("Cuoi Ky JAVA PT");	
//						outputStream.writeObject(list);
//						outputStream.flush();
//						break;
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
