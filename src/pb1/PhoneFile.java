package pb1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneFile {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("전화번호 입력 프로그램입니다.");
		
		File file = new File("phone.txt");
		FileWriter fwrite = new FileWriter(file);
		
		while(true){
			System.out.print("이름 전화번호 >>");
			String data = scanner.nextLine();
			if(data.equals("stop")) {
				System.out.println("c:/Java프로그래밍및실습/9주차/phone.txt에 저장하셨습니다.");
				break;
			}
			fwrite.write(data);
			fwrite.write("\n");
		}
		scanner.close();
		fwrite.close();
		
		System.out.println("c:/Java프로그래밍및실습/9주차/phone.txt를 출력합니다.");
		FileReader fread;
		fread = new FileReader(file);
		BufferedReader bufreader = new BufferedReader(fread);
		
		String line = "";
		while((line = bufreader.readLine()) != null) {
			System.out.println(line);
		}
		bufreader.close();
	}
}
