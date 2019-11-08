package pb2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Bookshelf {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("메뉴 선택: (1)책 추가 (2)전체 책 검색");
		int menu = scanner.nextInt();
		////////////////////////////////
		if(menu == 1) {
			while(true) {
				FileOutputStream fileos = new FileOutputStream("userInfo.dat");
				ObjectOutputStream objectos = new ObjectOutputStream(fileos);
				System.out.println("Title >> ");
				String title = scanner.next();
				if(title.equals("그만")) {
					objectos.close();
					break;
				}
				System.out.println("Author name >> ");
				String name = scanner.next();
				System.out.println("Career >> ");
				String career = scanner.next();
				System.out.println("Gender(1 or 2) >> ");
				int g = scanner.nextInt();
				Gender gender = Gender.UNKNOWN;
				if(g==1)
					gender = Gender.MAN;
				else if(g==2)
					gender = Gender.WOMAN;
				Author author = new Author(name, gender, career);
				Book obj = new Book(title, author);
				try {
					objectos.writeObject(obj);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			scanner.close();
			System.out.println("책을 저장했습니다.");
		}

		//////////////////////
		else if(menu==2) {
			while(true) {
				FileInputStream fileis = new FileInputStream("userInfo.dat");
				ObjectInputStream objectis = new ObjectInputStream(fileis);
				Book obj = (Book)objectis.readObject();
				if(obj.equals(null)) {
					break;
				}
				objectis.close();
				System.out.println(obj);
			}
		}
	}
}