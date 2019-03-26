package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class StringTokenizerTest {
	public static void main(String[] args) {
		
		String str = "hello java !!!";
		//String �� �׻� �Է����־���Ѵ�.
		StringTokenizer st = new StringTokenizer(str);
		
		int cnt = st.countTokens();
		//�ƹ��͵� ������ ���ϸ� ������ �̿��ؼ� ��ū�� �и�
		//��Ȯ���� " \t\n\r\f"  �̰ɵ��� �̿��ؼ� �и�
		System.out.println(cnt);
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		//������ �޽��� �ְ���� �� ������ ���
		str = "TO|��ȿ��|�ȳ��ϼ��� ���� ���ؿ�??";
		StringTokenizer st2 = new StringTokenizer(str, "|");
		String protocol = st2.nextToken();
		String to = st2.nextToken();
		String msg = st2.nextToken();
		System.out.println("��� : " + protocol);
		System.out.println("�������� : " + to);
		System.out.println("������ �޼��� : " + msg);
		
		System.out.println(UUID.randomUUID());
	}
}
