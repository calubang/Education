package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class StringTokenizerTest {
	public static void main(String[] args) {
		
		String str = "hello java !!!";
		//String 은 항상 입력해주어야한다.
		StringTokenizer st = new StringTokenizer(str);
		
		int cnt = st.countTokens();
		//아무것도 지정을 안하면 공백을 이용해서 토큰을 분리
		//정확히는 " \t\n\r\f"  이걸들을 이용해서 분리
		System.out.println(cnt);
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		//웹에서 메시지 주고받을 때 쓸만한 방법
		str = "TO|안효인|안녕하세요 오늘 머해요??";
		StringTokenizer st2 = new StringTokenizer(str, "|");
		String protocol = st2.nextToken();
		String to = st2.nextToken();
		String msg = st2.nextToken();
		System.out.println("기능 : " + protocol);
		System.out.println("누구에게 : " + to);
		System.out.println("보내는 메세지 : " + msg);
		
		System.out.println(UUID.randomUUID());
	}
}
