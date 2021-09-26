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
		
		TodoUtil.loadList(l, "todolist.txt"); 
		System.out.println("-모든 정보를 읽어왔습니다- "); 
		Menu.displaymenu();
		do {
			Menu.prompt(); 
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
				
				
			case "ls_date_desc" : 
				l.sortByDate();
				l.reverseList();
				System.out.println("-날짜역순으로 정렬-"); 
				isList = true;
				break; 
			
				
			case "exit":
				System.out.println("모든 내용이 저장되었습니다. "); 
				quit = true;
				break;
				
			case "help":
				Menu.displaymenu();
				break; 
				
			case "find": 
				TodoUtil.findfunc(l,sc); 
				break; 
				
			case "find_cate":
				TodoUtil.find_cate(l, sc);
				break; 
				
			case "ls_cate":
				System.out.println("-카테고리 목록-"); 
				TodoUtil.sortByCate(l);
				isList = true;
				break; 
				

			default:
				System.out.println("입력하신 명령어가 존재하지 않습니다. help 를 통해 명령어 리스트 확인하기 ");
				break;
			}
			
			if(isList) l.listAll(); //리스트를 보여주기 위해 출력 
		} while (!quit);
		
		TodoUtil.saveList(l,"todolist.txt"); 
	}
}
