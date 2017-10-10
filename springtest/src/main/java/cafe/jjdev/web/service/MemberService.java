package cafe.jjdev.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.jjdev.web.MemberRequest;

@Service //service라는 에노테이션을 써야된다.
//controller나 dao에서 이러한 작업을 하면 안된다. 새로운 계층을 만들어서 해야된다. 
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	public int addMember(MemberRequest memberRequest) {
		//memberRequest -> member
		Member member = new Member();
		member.setMemberId(memberRequest.getMemberId());
		member.setMemberPw(memberRequest.getMemberPw());
		member.setMemberName(memberRequest.getMemberName());
		return memberDao.insertMember(member);
	}

}
