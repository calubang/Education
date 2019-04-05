package com.kitri.haksa.test;

import com.kitri.haksa.data.HaksaDto;
import com.kitri.haksa.service.HaksaService;
import com.kitri.haksa.service.HaksaServiceImpl;

public class HaksaMain {
	public static void main(String[] args) {
		//�׽�Ʈ�� ������
		HaksaDto haksaDto1 = new HaksaDto(32, "�Ⱥ���", 0, "200611000");
		HaksaDto haksaDto2 = new HaksaDto(33, "�����", 0, "200511001");
		HaksaDto haksaDto3 = new HaksaDto(23, "�ǿ���", 1, "201511002");
		HaksaDto haksaDto4 = new HaksaDto(26, "�ǹ���", 2, "201211003");
		HaksaDto haksaDto5 = new HaksaDto(28, "�̼Ҵ�", 0, "201011004");
		HaksaDto haksaDto8 = new HaksaDto(32, "�Ⱥ���", 1, "200611005");
			
		HaksaService haksaService = new HaksaServiceImpl();
		
		haksaService.register(haksaDto1);
		haksaService.register(haksaDto2);
		haksaService.register(haksaDto3);
		haksaService.register(haksaDto4);
		haksaService.register(haksaDto5);
		haksaService.register(haksaDto8);		
		
		haksaService.menu();
	}
}
