package com.todo.service;

import java.util.*;
import java.io.*; 

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {

	
	public static void createItem(TodoList list) {
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "==== Create item Section ====\n"
				+ "enter the title\n");
		
		title = sc.next();
		sc.nextLine();  // 버퍼 비우기 
		if (list.isDuplicate(title)) {
			System.out.printf("title can't be duplicate");
			return;
		}
		
		System.out.println("enter the description");
		desc = sc.nextLine(); //화이트스페이스 단위에서 문장을 받을 수 있도록 메서드 수정 
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		String title = sc.next();
		
		
		System.out.println("\n"
				+ "===== Delete Item Section ====\n"
				+ "enter the title of item to remove\n"
				+ "\n");
		
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				break;
			}
		}
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "===== Edit Item Section ===== \n"
				+ "enter the title of the item you want to update\n"
				+ "\n");
		String title = sc.next().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("title doesn't exist");
			return;
		}

		System.out.println("enter the new title of the item");
		String new_title = sc.next().trim();
		sc.nextLine(); //버퍼 비우기 
		if (l.isDuplicate(new_title)) {
			System.out.println("title can't be duplicate");
			return;
		}
		
		System.out.println("enter the new description ");
		String new_description = sc.nextLine().trim(); //문장을 받기 위해 메서드 nextLine으로 변경 
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description);
				l.addItem(t);
				System.out.println("item updated");
			}
		}

	}

	public static void listAll(TodoList l) {
		for (TodoItem item : l.getList()) {
			System.out.println("Title: " + item.getTitle() + "  \t Description:  " + item.getDesc());
		}
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
				String title = st.nextToken();
				String desc = st.nextToken();
				String current_date = st.nextToken();
				l.addItem(new TodoItem(title, desc, current_date));
			}
			reader.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("!! 파일 없음 !!");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
