package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		boolean isList = false;
		boolean quit = false;
		do {
			Menu.displaymenu(); //prompt() 메소드로 수정 필요 
			isList = false; //true면 루프 종료 - 루프안에 true인 경우 존재
			String choice = sc.next();
			switch (choice) {

			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;

			case "ls_name_asc":
				l.sortByName();
				System.out.println("-제목순으로 정렬-"); 
				isList = true;
				break;

			case "ls_name_desc":
				l.sortByName();
				l.reverseList();
				System.out.println("-제목역순으로 정렬-"); 
				isList = true;
				break;
				
			case "ls_date":
				l.sortByDate();
				System.out.println("-날짜순으로 정렬-"); 
				isList = true;
				break;
				
			//case help- 메뉴창 도움말 경우 추가 	
				
			case "exit":
				quit = true;
				break;

			default:
				System.out.println("please enter one of the above mentioned command");
				break;
			}
			
			if(isList) l.listAll(); //리스트를 보여주기 위해 출력 
		} while (!quit);
	}
}
