package app;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import entities.DocGia;

public class Client {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			try (Socket socket = new Socket("localhost", 1999)) {
				ObjectOutputStream outputStream= new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
				
				int choice=0;
				System.out.println("1.Thêm chi tiết mượn sách\n"
						+ "2.Sửa tên sách của S02 thành Nguyễn Ngọc Tường Vân\n"
						+ "3.Các độc giả mượn Cuoi Ky JAVA PT trên 2 lần\n ");
				
				while (true) {
					choice=scanner.nextInt();
					outputStream.writeInt(choice);
					outputStream.flush();
					
					switch (choice) {
					case 1:
//						scanner.nextLine();
//						System.out.println("Nhap ma docGia");
//						String maDG=scanner.nextLine();
//						
//						outputStream.writeUTF(maDG);
//						outputStream.flush();
//						
//						System.out.println("Nhap ma SACH");
//						String masach=scanner.nextLine();
//						
//						outputStream.writeUTF(masach);
//						outputStream.flush();
//						
//						if((boolean) inputStream.readObject()) {
//							System.out.println("Them thanh cong");
//						}else {
//							System.out.println("Them that bai");
//						}
						
						break;
					case 2:
//						if((boolean) inputStream.readObject()) {
//							System.out.println("Sua thanh cong");
//						}else {
//							System.out.println("Sua that bai");
//						}
//						
						break;
					case 3:
//						List<DocGia> list=(List<DocGia>) inputStream.readObject();
//						list.forEach(t -> System.out.println(t));
						break;
					}
//					map.entrySet().stream().forEach(entry -> {
//						System.out.println(entry.getKey().getName() + " : " + entry.getValue());
//					}); 
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
