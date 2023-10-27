package com.acorn.testing;

import java.util.List;

public interface KakaoMemberRepositoryI {

	public int insert(KakaoUserDTO kakaoUserDTO);

	public List<KakaoUserDTO> selectAll();
}