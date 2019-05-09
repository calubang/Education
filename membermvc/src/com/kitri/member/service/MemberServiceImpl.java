package com.kitri.member.service;

import java.util.List;

import com.kitri.member.dao.MemberDao;
import com.kitri.member.dao.MemberDaoImpl;
import com.kitri.member.model.*;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService;
	
	static {
		memberService = new MemberServiceImpl();
	}
	
	private MemberServiceImpl() {
	}
		
	public static MemberService getMemberService() {
		return memberService;
	}

	@Override
	public String idCheck(String searchId) {
		int cnt = MemberDaoImpl.getMemberDao().idCheck(searchId);
		String result = "";
		result += "<idcount>\n";
		result += "\t<cnt>"+ cnt + "</cnt>\n";
		result += "</idcount>";
		return result;
	}

	@Override
	public String zipSearch(String searchAddress) {
		String resultXML = "";
		List<ZipcodeDto> list = MemberDaoImpl.getMemberDao().zipSearch(searchAddress);
		resultXML += "<ziplist>";
		
		for(ZipcodeDto dto : list) {
			resultXML += "<zip>\n";
			resultXML += "	<zipcode>" + dto.getZipcode() + "\n";
			resultXML += "	</zipcode>" + "\n";
			resultXML += "	<address><![CDATA[" + dto.getSido() + dto.getGugun() + dto.getUpmyon();
			resultXML += dto.getDoro() + dto.getBuildingNumber() + dto.getSigugunBuildingName() + "]]>\n";
			resultXML += "	</address>"+ "\n";
			resultXML += "</zip>" + "\n";
		}
		resultXML += "</ziplist>";
		return resultXML;
	}

	@Override
	public int registerMember(MemberDetailDto dto) {
		return MemberDaoImpl.getMemberDao().registerMember(dto);
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		return null;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto dto) {
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		return 0;
	}

}
