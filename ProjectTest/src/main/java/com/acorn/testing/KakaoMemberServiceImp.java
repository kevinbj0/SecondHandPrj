package com.acorn.testing;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class KakaoMemberServiceImp  implements KakaoMemberServiceI{
	
	@Autowired
	KakaoMemberRepositoryI dao;

	@Override
	public int registerMember(KakaoUserDTO kakaoUserDTO) {
		// TODO Auto-generated method stub
		return dao.insert(kakaoUserDTO);
	}

	@Override
	public List<KakaoUserDTO> getMemberList() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
