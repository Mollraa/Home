package co.mall.prj.member.serviceImpl;

import java.util.List;

import co.mall.prj.common.DataSource;
import co.mall.prj.member.service.MemberService;
import co.mall.prj.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DataSource dao = new DataSource(); //오류잡기 0922
	private 
	
	
	@Override
	public List<MemberVO> memberSelectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isMemberId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
