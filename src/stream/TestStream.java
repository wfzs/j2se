package stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestStream {
	// public static void main(String[] args) {
	// // 准备文件lol.txt其中的内容是AB
	// File f = new File("e:/work/lol.txt");
	// // 创建基于文件的Reader
	// try (FileReader fr = new FileReader(f)) {
	// // 创建字符数组，其长度就是文件的长度
	// char[] all = new char[(int) f.length()];
	// // 以字符流的形式读取文件所有内容
	// fr.read(all);
	// for (char b : all) {
	// // 打印出来是A B
	// System.out.println(b);
	// }
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// public static void main(String[] args) {
	// 准备文件lol2.txt
	// File f = new File("e:/work/lol2.txt");
	// // 创建基于文件的Writer
	// try (FileWriter fr = new FileWriter(f)) {
	// // 以字符流的形式把数据写入到文件中
	// String data="abcdefg1234567890";
	// char[] cs = data.toCharArray();
	// fr.write(cs);
	//
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	public static void main(String[] args) {
		File encodingFile = new File("e:/work/lol.txt");
		File encodedFile = new File("e:/work/lol2.txt");
		encodeFile(encodingFile, encodedFile);
	}

	public static void encodeFile(File encodingFile, File encodedFile) {
		try (FileReader fr = new FileReader(encodingFile); FileWriter fw = new FileWriter(encodedFile)) {
			char[] fileContent = new char[(int) encodingFile.length()];
			long n=encodingFile.length();
			fr.read(fileContent);
			System.out.println("解密前的内容");
			System.out.println(new String(fileContent));

			encode(fileContent);
			System.out.println("解密后的内容");
			System.out.println(new String(fileContent));

			fw.write(fileContent);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void encode(char[] fileContent) {
		for (int i = 0; i < fileContent.length; i++) {
			char c = fileContent[i];
			if (isLetterOrDigit(c)) {
				switch (c) {
				case '9':
					c = '0';
					break;
				case 'z':
					c = 'a';
					break;
				case 'Z':
					c = 'A';
					break;
				default:
					c++;
					break;
				}
			}
			fileContent[i] = c;
		}
	}

	public static boolean isLetterOrDigit(char c) {
		String lod = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int a=lod.indexOf(c);
		return -1 == lod.indexOf(c) ? false : true;
	}
}
