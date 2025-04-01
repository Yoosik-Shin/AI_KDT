package Day15.Ex03_File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * - 메뉴 출력 메소드
 * - 폴더 내의 파일 목록
 * - 파일 정보 조회
 * - 폴더 생성
 * - 폴더 삭제
 * - 파일 생성 FileOutputStream, CharacterStream
 * - 파일 삭제
 */

public class FileManager {

	/**
	 * 메뉴 출력 메소드
	 */
	private static void menu() {
		System.out.println(":::::::::: 파일 관리 ::::::::::");
		System.out.println("1. 파일 목록");
		System.out.println("2. 파일 조회");
		System.out.println("3. 폴더 생성");
		System.out.println("4. 폴더 삭제");
		System.out.println("5. 파일 생성");
		System.out.println("6. 파일 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print(":::::::::: 번호 : ");
	}
	
	/**
	 * 파일 목록
	 * @param path
	 */
	private static void fileList(String path) {
		System.out.println(path);
		System.out.println("-----------------------------------------------");
		File file = new File(path);		// 경로를 지정하여 파일 객체 생성
		File[] fileList = file.listFiles(); // 하위 경로의 파일 목록을 File[] 배열로 반환
		
		System.out.println("파일명\t\t용량\t\t수정일자");
		for (File subFile : fileList) {
			long update = subFile.lastModified();		// 최종 수정일자
			Date date = new Date(update);				// java.util.Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String updateDate = sdf.format(date);
			
			// 파일명
			String fileName = subFile.getName();
			// 용량
			long size = subFile.length();
			
			System.out.print(fileName + "\t\t");
			System.out.print(size + "\t\t");
			System.out.println(updateDate + "\t\t");
		}
		System.out.println("-----------------------------------------------");
	}
	
	/**
	 * 파일 정보 조회
	 * @param filePath
	 */
	private static void fileInfo(String filePath) {
		File file = new File(filePath);
		System.out.print("파일 종류 : ");
		if ( file.isDirectory() ) System.out.println("디렉토리"); // 폴더인지 확인
		if ( file.isFile() ) System.out.println("일반파일");  // 파일인지 확인
		
		long update = file.lastModified();
		Date date = new Date(update);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String updateDate = sdf.format(date);
		
		System.out.println(file.getName() + "\t\t");
		System.out.println(file.length() + "\t\t");
		System.out.println(updateDate + "\t\t");
		System.out.println();
	}
	
	/**
	 * 폴더 생성
	 * @param path
	 */
	private static void makeDirectory(String path) {
		File file = new File(path);
		
		// 폴더 생성
		// mkdir() 		: 생성할 경로의 상위 경로까지 기존 디렉토리가 존재해야 한다.(없으면 에러)
		// mkdirs() 	: 생성할 경로의 상위 경로까지 디렉토리를 생성해준다.
		if(file.mkdirs()) {
			System.out.println("디렉토리 생성 성공!");
		}
		else {
			System.err.println("디렉토리 생성 실패!");
		}
		System.out.println("경로 : " + path);
	}
	
	/**
	 * 폴더 삭제
	 * @param path
	 */
	private static void deleteDirectory(String path) {
		
		// TODO: 지정 폴더 하위 경로에 다른 파일이 있으면, 먼저 삭제
		//		 폴더 안에 폴더가 있으면 -> 재귀호출로 삭제
		// 1. 하위 경로에 파일들을 삭제
		// 2. 해당 폴더 삭제

		File file = new File(path);
		File[] fileList = file.listFiles();
		
		// 하위 경로에 파일이 있으면, 하위 파일을 먼저 삭제
		if(fileList != null) {
			for (File subFile : fileList) {
				String subFilePath = subFile.getPath();
				// 재귀 호출(재귀 함수; recursive)
				deleteDirectory(subFilePath);
			}
		}
		// 폴더(파일) 삭제
		if (file.delete()) {
			System.out.println("폴더(파일) 삭제 성공!");
		}
		else {
			System.err.println("폴더(파일) 삭제 실패!");
		}
	}
	
	/**
	 * 파일 생성
	 * @param path		: 파일을 생성할 경로
	 * @param fileName	: 파일명
	 */
	private static void createFile(String path, String fileName) {
		// TODO: Filewriter 객체를 사용하여 간단한 텍스트를 입력하여 지정한 파일로 출력하시오.
		// 1. File 객체 생성
		// 2. File 객체를 초기화 하는 FileWriter 객체 생성
		// 3. 사용자로부터 문자열 입력
		// 4. 입력받은 문자열을 지정한 파일에 출력
		// * 예외 처리
		
		// 내가 한거
		File file = new File(path, fileName);
		
		try (FileWriter fw = new FileWriter(file);
			 BufferedWriter bw = new BufferedWriter(fw);){
			
			Scanner sc = new Scanner(System.in);
			System.out.print(">>");
			String input = sc.nextLine();
			
			bw.write(input + "\n");
			System.out.println(fileName + " 파일을 생성하였습니다.");

//			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
//		// 선생님코드
//		File file = new File(path, fileName);
//		try {
//			FileWriter fw = new FileWriter(file);
//			Scanner sc = new Scanner(System.in);
//			String text = sc.nextLine();
//			fw.write(text);
//			fw.close(); // 1차수정
//			System.out.println(fileName + " 파일을 생성하였습니다.");
////			sc.close(); // 이걸 적어놨었는데 파일 생성은 되지만 생성후 자꾸 에러나서 이거 지우니까 됐음!!
//			            // 에러 내용) NoSuchElementsException
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	} // 생성 되는데 생성하고 나서 에러남
	
	/**
	 * 파일 삭제
	 * @param filePath
	 */
	private static void deleteFile(String filePath) {
		File file = new File(filePath);
		
		// 파일 존재 여부 확인
		if (file.exists() && file.delete()) {
			System.out.println("파일 삭제 성공!");
		}
		else if (file.exists()) {
			System.err.println("파일 삭제 실패!");
		}
		else {
			System.err.println("파일이 존재하지 않습니다.");
		}
	}
	
	
	public static void main(String[] args) {
		int menuNo;			// 메뉴번호
//		FileManager fileManager = new FileManager(); 
// 클래스 객체 생성해서 메소드 부르기 귀찮으면 모든 메소드에 static 붙여버리면....됨...?됨
		Scanner sc = new Scanner(System.in);
		do {
			// TODO: 정의한 메소드 기능을 활용하여 
			//       파일 관리 프로그램이 실행될 수 있도록
			//       완성해보세요.
			
			// 메뉴판 출력
			menu();
			
			// 메뉴번호 입력
			menuNo = sc.nextInt();
			sc.nextLine();				// 엔터 지우기
			
			// 0번 -> 종료
			if(menuNo == 0) break;
			// 파일 경로
			System.out.print("파일 경로 : ");
			String path = sc.nextLine();
			
			// 메뉴 선택
			switch (menuNo) {
			
			// 1- 파일 목록
			case 1:
				fileList(path);
				break;

			// 2- 파일 조회
			case 2:
				fileInfo(path);
				break;
			
			// 3- 폴더 생성
			case 3:
				makeDirectory(path);
				break;
			
			// 4- 폴더 삭제
			case 4:
				deleteDirectory(path);
				break;
			
			// 5- 파일 생성
			case 5:
				System.out.print("파일명 : ");
				String fileName = sc.nextLine();
				createFile(path, fileName);
				break;
			
			// 6- 파일 삭제
			case 6:
				deleteFile(path);
				break;
			default:
				break;
			}
			
		} while (true);
		
		sc.close();
	}
}
