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
		System.out.println("��ȭ��ȣ �Է� ���α׷��Դϴ�.");
		
		File file = new File("phone.txt");
		FileWriter fwrite = new FileWriter(file);
		
		while(true){
			System.out.print("�̸� ��ȭ��ȣ >>");
			String data = scanner.nextLine();
			if(data.equals("stop")) {
				System.out.println("c:/Java���α׷��ֹ׽ǽ�/9����/phone.txt�� �����ϼ̽��ϴ�.");
				break;
			}
			fwrite.write(data);
			fwrite.write("\n");
		}
		scanner.close();
		fwrite.close();
		
		System.out.println("c:/Java���α׷��ֹ׽ǽ�/9����/phone.txt�� ����մϴ�.");
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
