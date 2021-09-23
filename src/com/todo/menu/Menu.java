package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("**********************LIST****************************");
        System.out.println("1. Add a new item ( add ) 항목 추가하기 ");
        System.out.println("2. Delete an existing item ( del ) 항목 삭제하기 ");
        System.out.println("3. Update an item  ( edit ) 항목 수정하기 ");
        System.out.println("4. List all items ( ls ) 전체 목록 보기 ");
        System.out.println("5. sort the list by name ( ls_name_asc ) 목록 제목순 정렬 ");
        System.out.println("6. sort the list by name ( ls_name_desc ) 목록 제목역순 정렬 ");
        System.out.println("7. sort the list by date ( ls_date ) 목록 날짜순 정렬 ");
        System.out.println("8. exit (Or press escape key to exit) 종료하기 ");
        System.out.println("9. HELP ( help ) 메뉴 창 확이하기 ");
        System.out.println("**********************LIST****************************");
        System.out.println();
    }

	public static void prompt() { 
		//명령어 입력 대기상태 
        System.out.println("Enter your choice > 입력하세요 > ");
		
	} 
}


