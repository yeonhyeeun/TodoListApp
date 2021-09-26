package com.todo.service;

import java.util.*;
import java.io.*; 

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {

	
	//항목 생성-추가 함수 
	public static void createItem(TodoList list) {
		int num = 1; 
		String title, desc, cate, due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "==== Create item Section ====\n"
				+ "<< 제목 작성 >> \n");
		
		title = sc.next();
		sc.nextLine();  // 버퍼 비우기 
		if (list.isDuplicate(title)) {
			System.out.printf("!duplicate! 제목 중복 불가!! ");
			return;
		}
		
		System.out.println("<< 카테고리 지정 (단어) >> "); //카테고리 추가 
		cate = sc.next(); 
		sc.nextLine(); 
		
		System.out.println("<< 내용 작성 >>");
		desc = sc.nextLine(); //화이트스페이스 단위에서 문장을 받을 수 있도록 메서드 수정 
		
		System.out.println("<< 마감일 작성 >>");
		due_date = sc.nextLine();
		sc.nextLine(); 
		
		
		TodoItem t = new TodoItem(title, cate, desc, due_date);
		list.addItem(t);
		num++; 
		
	}
	
	
	//항목 삭제 함수 
	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		String title = sc.next();
		
		
		System.out.println("\n"
				+ "===== Delete Item Section ====\n"
				+ "삭제하고 싶은 항목의 번호를 입력하세요 \n"
				+ "\n");

		int num = sc.nextInt();
		TodoItem item = l.getList().get(num-1);
		System.out.println("[" + num + "]" + "\t" + item.getCate() + "  제목 : " + item.getTitle() + "  \t 내용 :  " + item.getDesc());
		
		System.out.println("정말로 삭제하시겠습니까? (y/n) "); 
		String answer = sc.next(); 
	
		
		if(answer.charAt(0) == 'y') {
			l.deleteItem(item);
			System.out.println("삭제 완료! "); 
		}
		else if(answer.charAt(0) == 'n') {
			return; 
		}
	}


	//항목 수정 함수 
	public static void updateItem(TodoList l) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "===== Edit Item Section ===== \n"
				+ "수정하고 싶은 항목의 번호를 입력하세요 \n"
				+ "\n");
		//제목을 입력해서 변경할 때의 함수 
		int num = sc.nextInt();
		TodoItem item = l.getList().get(num-1);
		System.out.println("[" + num + "]" + "\t" + item.getCate() + "  제목 : " + item.getTitle() + "  \t 내용 :  " + item.getDesc());
		
	
		System.out.println("<< 새 제목 작성 >>");
		String new_title = sc.next().trim();
		sc.nextLine(); //버퍼 비우기 
		if (l.isDuplicate(new_title)) {
			System.out.println("title can't be duplicate");
			return;
		}
		
		System.out.println("<< 새 카테고리 지정 >> ");
		String new_cate = sc.next().trim(); //문장을 받기 위해 메서드 nextLine으로 변경 
		sc.nextLine(); 
		
		System.out.println("<< 새 내용 작성 >> ");
		String new_description = sc.nextLine().trim(); //문장을 받기 위해 메서드 nextLine으로 변경 

		
		System.out.println("<<새 마감일자 작성 >> ");
		String new_due_date = sc.nextLine().trim(); //문장을 받기 위해 메서드 nextLine으로 변경 

		
		l.deleteItem(item);
		l.addItem(new TodoItem(new_title, new_cate, new_description, new_due_date));
		System.out.println("-수정 완료!-");

	}

	public static void listAll(TodoList l) {
		
		int num = 0;
		for (TodoItem item : l.getList()) {
		num++; 	 
		System.out.println("[" + num + "]" + "\t" 
		+ item.getCate() + "  제목 : " + item.getTitle() 
		+ "  \t 내용 :  " + item.getDesc() + "\t 마감일자 : " 
		+ item.getDue_date() + " \t 현재날짜: "+ item.getCurrent_date());
		}
		
	}
	
	
	public static void findfunc(TodoList l, Scanner sc) { 
		int num=0; 
		int fnum=0; 
		String findword = sc.next(); 
		
		//제목에서 겹치는게 있을때 
		for (TodoItem item : l.getList()) { //전체 탐색하기위해 돌릭 
			num++; 
			if((item.getTitle().indexOf(findword)  != -1  || item.getDesc().indexOf(findword) != -1)) {
				System.out.println("[" + num + "]" + "\t" + item.getCate() + 
						"  제목 : " + item.getTitle() + 
						"  \t 내용 :  " + item.getDesc() + 
						"\t 마감일자 : " + item.getDue_date() + 
						" t 현재날짜: "+ item.getCurrent_date());				
				fnum++; 
			}
		}
		
		if(fnum ==0) 
			System.out.println("찾으시는 항목이 목록에 없습니다. "); 
		else 
			System.out.println("총 " + fnum + "개의 항목을 찾았습니다." ); 
		
	}
	
	//cate에서 find 적용 
	public static void find_cate(TodoList l, Scanner sc) { 
		int num=0; 
		int fnum=0; 
		String findword = sc.next(); 
		
		
		for (TodoItem item : l.getList()) { //전체 탐색하기위해 돌릭 
			num++; 
			if((item.getCate().indexOf(findword)  != -1)) {
				System.out.println("[" + num + "]" + "\t" + item.getCate() + 
						"  제목 : " + item.getTitle() + 
						"  \t 내용 :  " + item.getDesc() + 
						"\t 마감일자 : " + item.getDue_date() + 
						" t 현재날짜: "+ item.getCurrent_date());				
				fnum++; 
			}
		}
		
		if(fnum ==0) 
			System.out.println("찾으시는 내용이 카테고리에 없습니다. "); 
		else 
			System.out.println("총 " + fnum + "개의 항목을 찾았습니다." ); 
		
	}
	
	
	
	public static void saveList(TodoList l, String filename) {
		//FileWriter 사용하기 
		//이미 사용자가 콘솔에서 입력한 항목들이 잇는 리스트 데이터 txt파일에 저장하기 
		try {
				Writer w = new FileWriter(filename); 
				for (TodoItem item : l.getList()) {
				w.write(item.toSaveString());

			}
			w.close(); 
			
			System.out.println("-data save-"); 
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void loadList(TodoList l, String filename) {
		//txt파일에 있는 리스트불러오기 
		//Buffered Reader, FileReader, String Tokenizer 사용하기 
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename)); 
			String line; 
			
			while((line = reader.readLine()) != null ) {
				StringTokenizer st = new StringTokenizer(line,"##");
				String cate = st.nextToken();
				String title = st.nextToken();
				String desc = st.nextToken();
				String due_date = st.nextToken(); 
				String current_date = st.nextToken();
				l.addItem(new TodoItem(title, cate, desc, due_date, current_date));
			}
			reader.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("!! 파일 없음 !!");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}


	public static void sortByCate(TodoList l) {
		int num =0;
		HashSet<String> cate = new HashSet<String>(); 
		
		for(TodoItem item : l.getList()) {
			cate.add(item.getCate()); 
		}
		
		for(String sort_cate : cate) {
			
			if(num == cate.size()-1) {
				System.out.println(sort_cate);
			}
			else {
				System.out.print(sort_cate + ", "); 
			}
			++num;
		}
			System.out.println("총 "+ num + "개의 카테고리가 있습니다. ");
		}
		
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
