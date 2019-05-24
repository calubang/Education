package com.kitri.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionAttrListener implements HttpSessionAttributeListener {
	private int loginCnt;
	
    public MySessionAttrListener() {
        
    }

    public void attributeAdded(HttpSessionBindingEvent e)  { 
    	String attrName = e.getName();
    	if(attrName.equals("loginInfo")) {
    		loginCnt++;
    		System.out.println("현재 로그인 인원 : " + loginCnt);
    		System.out.println(e.getValue() + "님이 로그인하셨습니다!");
    	}
    }


    public void attributeRemoved(HttpSessionBindingEvent e)  { 
    	String attrName = e.getName();
    	if(attrName.equals("loginInfo")) {
    		loginCnt--;
    		System.out.println("현재 로그인 인원 : " + loginCnt);
    		System.out.println(e.getValue() + "님이 로그아웃 하셨습니다!");
    	}
    }

    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         
    }
	
}
