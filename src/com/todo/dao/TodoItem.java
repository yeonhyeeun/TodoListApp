package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
    private String title;
    private String desc;
    private String current_date;
    private String cate; //카테고리 추가 
    private String due_date; //마감일 추가 
  


    public TodoItem(String title, String desc, String current_date){
        this.title=title;
        this.desc=desc;
        this.current_date = current_date; 
    }
    
    public TodoItem(String title, String desc) {
    	this.title = title;
    	this.desc = desc;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss"); 
        this.current_date = f.format(new Date()); 
    	
	}
    
    public TodoItem(String title, String cate, String desc, String due_date){
    	this.title = title;
    	this.cate = cate; 
    	this.desc = desc;
    	this.due_date = due_date;
     }
    
    
    //항목번호 int와 cate와 due_date까지 추가한 투두아이템 함수 
    //일단 현재 시간 current date로 받기 
    public TodoItem(String title, String cate, String desc, String due_date, String current_date){
    	this.title = title;
    	this.cate = cate; 
    	this.desc = desc;
    	this.due_date = due_date;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss"); 
        this.current_date = f.format(new Date()); 
     }
     

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return current_date;
    }
    
    public String getCate() { //get cate 
    	return cate; 
    }
    
    public String getDue_date() { //get due_date 
    	return due_date; 
    }
    
    

    public void setCurrent_date(Date current_date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss"); 
        this.current_date = f.format(new Date()); 

    }

    public String toSaveString() { //cate 추가하기 
    	return "[" + cate + "]" + "##" + title + "##" 
    				+ desc +"##" + due_date + "##" 
    				+ current_date + "\n"; 
    }



}
