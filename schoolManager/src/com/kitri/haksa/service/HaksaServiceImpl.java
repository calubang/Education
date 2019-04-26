package com.kitri.haksa.service;

import java.io.*;
import java.util.*;

import com.kitri.haksa.data.HaksaDto;
import com.kitri.haksa.db.DaoFactory;
import com.kitri.haksa.db.HaksaDao;

public class HaksaServiceImpl implements HaksaService{
	private String job[] = {"학번", "과목", "부서"};
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
			System.out.println("========== 메뉴 선택 ==========");
			System.out.println("1. 등록");
			System.out.println("2. 찾기");
			System.out.println("3. 삭제");
			System.out.println("4. 전체 출력");
			System.out.println("-----------------------------");
			System.out.println("0. 종료");
			System.out.println("-----------------------------");
			System.out.print("번호를 선택해 주세요..   ");
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
					System.out.println("잘못 입력하셧습니다. 다시 입력해주세요.");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//등록
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
			System.out.println("========== 등록 ==========");		
			System.out.println("1. 학생");
			System.out.println("2. 교수");
			System.out.println("3. 관리자");
			System.out.println("4. 이전메뉴");
			System.out.print("번호를 선택해 주세요..   ");
			try {
				menu = in.readLine().trim();
				
				switch (menu) {
				case "1":
				case "2":
				case "3":
					int numberInput = Integer.parseInt(menu);
					
					 do{
						numberCheck = true;
						System.out.print("나이 : ");
						ageStr = in.readLine().trim();
						int len = ageStr.length();
						for (int i = 0; i < len; i++) {
							if(ageStr.charAt(i) < '0' || ageStr.charAt(i) > '9') {
								System.out.println("숫자를 입력하지 않으셨습니다. 다시 입력하세요.");
								numberCheck = false;
								break;
							}
						}
					}while(!numberCheck);
					age = Integer.parseInt(ageStr);
					
					System.out.print("이름 : ");
					name = in.readLine().trim();
					
					key = numberInput;
					
					System.out.print(job[key-1]+" : ");
					value = in.readLine().trim();
					
					haksa = new HaksaDto(age, name, key, value);
					register(haksa);
					break;
				case "4":
					System.out.println("이전 메뉴로 돌아갑니다.");
					break;
				default:
					System.out.println("잘못 입력하셧습니다. 다시 입력해주세요.");
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
		System.out.println("[" + haksa + "] 가 등록 되었습니다.");
	}
	
	//찾기
	@Override
	public void findNameMenu() {
		String name = "";
		String menu = "";
		do{
			System.out.println("찾을 이름을 입력해 주세요.");
			System.out.print("이름 : ");
			try {
				name = in.readLine().trim();

				if(findName(name) == null) {
					System.out.println("일치하는 사람을 찾지 못했습니다.");
				}
				
				while(true){
					System.out.print("계속 하시려면 1, 종료 하시려면 0을 입력해주세요  ");
					menu = in.readLine();
					if(menu.equals("1") || menu.equals("0")) {
						break;
					} else {
						System.out.println("잘못 입력하셧습니다. 다시 입력해주세요.");
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
			System.out.println("일치하는 이름을 찾지 못하였습니다.");
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
	
	//삭제
	@Override
	public void deleteMenu() {
		String name = "";
		int count = 0;
		String menu = "";
		
		do {
			System.out.println("삭제할 사람이름을 입력해 주세요.");
			System.out.print("이름 : ");
			try {
				name = in.readLine().trim();
				count = delete(name);
				if(count == 0 ) {
					System.out.println("삭제할 사람이 없습니다.");
				} else {
					System.out.println(count + "명 삭제하였습니다.");
				}
				
				while(true){
					System.out.print("계속 하시려면 1, 종료 하시려면 0을 입력해주세요  ");
					menu = in.readLine();
					if(menu.equals("1") || menu.equals("0")) {
						break;
					} else {
						System.out.println("잘못 입력하셧습니다. 다시 입력해주세요.");
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
				System.out.println("데이터가 없습니다.");
			}else {
				for(int i = 0 ; i<size ; i++) {
					System.out.println(list.get(i));
				}
			}
			
			while(true){
				System.out.print("계속 하시려면 1, 종료 하시려면 0을 입력해주세요  ");
				try {
					menu = in.readLine();
					if(menu.equals("1") || menu.equals("0")) {
						break;
					} else {
						System.out.println("잘못 입력하셧습니다. 다시 입력해주세요.");
						continue;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}while(menu.equals("1"));
	}
	
	//종료
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
