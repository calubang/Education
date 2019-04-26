package com.kitri.haksa.service;

import java.io.*;
import java.util.*;

import com.kitri.haksa.data.HaksaDto;
import com.kitri.haksa.db.DaoFactory;
import com.kitri.haksa.db.HaksaDao;

public class HaksaServiceImpl implements HaksaService{
	private String job[] = {"�й�", "����", "�μ�"};
	private BufferedReader in;
	private HaksaDao haksaDao;
	
	public HaksaServiceImpl() {
		super();
		in = new BufferedReader(new InputStreamReader(System.in));
		haksaDao = new HaksaDao(DaoFactory.connectionMaker("oracle"));
		//menu();
	}
	
	@Override
	public void menu() {
		String menu = "";
		
		while(true) {
			System.out.println("========== �޴� ���� ==========");
			System.out.println("1. ���");
			System.out.println("2. ã��");
			System.out.println("3. ����");
			System.out.println("4. ��ü ���");
			System.out.println("-----------------------------");
			System.out.println("0. ����");
			System.out.println("-----------------------------");
			System.out.print("��ȣ�� ������ �ּ���..   ");
			try {
				menu = in.readLine().trim();
				switch (menu) {
				case "1":
					registerMenu();
					break;
				case "2":
					findNameMenu();
					break;
				case "3":
					deleteMenu();
					break;
				case "4":
					selectAll();
					break;
				case "0":
					processExit();
					break;
				default:
					System.out.println("�߸� �Է��ϼ˽��ϴ�. �ٽ� �Է����ּ���.");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//���
	@Override
	public void registerMenu() {
		int age;
		int key;
		String menu = "";
		String name = "";
		String ageStr = "";
		String value;
		HaksaDto haksa = null;
		boolean numberCheck = true;
		
		do {
			System.out.println("========== ��� ==========");		
			System.out.println("1. �л�");
			System.out.println("2. ����");
			System.out.println("3. ������");
			System.out.println("4. �����޴�");
			System.out.print("��ȣ�� ������ �ּ���..   ");
			try {
				menu = in.readLine().trim();
				
				switch (menu) {
				case "1":
				case "2":
				case "3":
					int numberInput = Integer.parseInt(menu);
					
					 do{
						numberCheck = true;
						System.out.print("���� : ");
						ageStr = in.readLine().trim();
						int len = ageStr.length();
						for (int i = 0; i < len; i++) {
							if(ageStr.charAt(i) < '0' || ageStr.charAt(i) > '9') {
								System.out.println("���ڸ� �Է����� �����̽��ϴ�. �ٽ� �Է��ϼ���.");
								numberCheck = false;
								break;
							}
						}
					}while(!numberCheck);
					age = Integer.parseInt(ageStr);
					
					System.out.print("�̸� : ");
					name = in.readLine().trim();
					
					key = numberInput;
					
					System.out.print(job[key-1]+" : ");
					value = in.readLine().trim();
					
					haksa = new HaksaDto(age, name, key, value);
					register(haksa);
					break;
				case "4":
					System.out.println("���� �޴��� ���ư��ϴ�.");
					break;
				default:
					System.out.println("�߸� �Է��ϼ˽��ϴ�. �ٽ� �Է����ּ���.");
					break;
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(!menu.equals("4"));
		
	}
	@Override
	public void register(HaksaDto haksa) {
		if(haksaDao.add(haksa) == -1) {

		};
		System.out.println("[" + haksa + "] �� ��� �Ǿ����ϴ�.");
	}
	
	//ã��
	@Override
	public void findNameMenu() {
		String name = "";
		String menu = "";
		do{
			System.out.println("ã�� �̸��� �Է��� �ּ���.");
			System.out.print("�̸� : ");
			try {
				name = in.readLine().trim();

				if(findName(name) == null) {
					System.out.println("��ġ�ϴ� ����� ã�� ���߽��ϴ�.");
				}
				
				while(true){
					System.out.print("��� �Ͻ÷��� 1, ���� �Ͻ÷��� 0�� �Է����ּ���  ");
					menu = in.readLine();
					if(menu.equals("1") || menu.equals("0")) {
						break;
					} else {
						System.out.println("�߸� �Է��ϼ˽��ϴ�. �ٽ� �Է����ּ���.");
						continue;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(menu.equals("1"));
		
	}
	@Override
	public HaksaDto findName(String name) {
		List<HaksaDto> list = haksaDao.findName(name);
		HaksaDto haksa = null;
		int len = list.size();
		
		if(len == 0) {
			System.out.println("��ġ�ϴ� �̸��� ã�� ���Ͽ����ϴ�.");
		}else {
			for (int i = 0; i < len; i++) {
				HaksaDto temp = list.get(i);
				if(temp.getName().equals(name)) {
					haksa = temp;
					System.out.println(haksa.toString());
				}
			}
		}
		return haksa;
	}
	
	//����
	@Override
	public void deleteMenu() {
		String name = "";
		int count = 0;
		String menu = "";
		
		do {
			System.out.println("������ ����̸��� �Է��� �ּ���.");
			System.out.print("�̸� : ");
			try {
				name = in.readLine().trim();
				count = delete(name);
				if(count == 0 ) {
					System.out.println("������ ����� �����ϴ�.");
				} else {
					System.out.println(count + "�� �����Ͽ����ϴ�.");
				}
				
				while(true){
					System.out.print("��� �Ͻ÷��� 1, ���� �Ͻ÷��� 0�� �Է����ּ���  ");
					menu = in.readLine();
					if(menu.equals("1") || menu.equals("0")) {
						break;
					} else {
						System.out.println("�߸� �Է��ϼ˽��ϴ�. �ٽ� �Է����ּ���.");
						continue;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(menu.equals("1"));
		
	}
	@Override
	public int delete(String name) {
		return haksaDao.delete(name);
	}
	@Override
	public void selectAll() {
		String menu = "";
		
		do{
			List<HaksaDto> list = null;
			list = haksaDao.getAll();
			int size = list.size();
			
			if(list.size() == 0) {
				System.out.println("�����Ͱ� �����ϴ�.");
			}else {
				for(int i = 0 ; i<size ; i++) {
					System.out.println(list.get(i));
				}
			}
			
			while(true){
				System.out.print("��� �Ͻ÷��� 1, ���� �Ͻ÷��� 0�� �Է����ּ���  ");
				try {
					menu = in.readLine();
					if(menu.equals("1") || menu.equals("0")) {
						break;
					} else {
						System.out.println("�߸� �Է��ϼ˽��ϴ�. �ٽ� �Է����ּ���.");
						continue;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}while(menu.equals("1"));
	}
	
	//����
	@Override
	public void processExit() {
		try {
			if(in != null) {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}
