package cafe.jjdev.web.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository//
public class MemberDao {
	@Autowired//new 연산자 안쓰게끔 하는 것 
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String NS ="cafe.jjdev.web.service.MemberMapper.";
	
	public Member logon(Member member) {
		return sqlSessionTemplate.selectOne(NS+"login",member);
	}
	
	public List<Member> selectMemberList(){
		return sqlSessionTemplate.selectList(NS+"selectMemberList");
	}
	
	public int insertMember(Member member) {
		return sqlSessionTemplate.insert(NS+"insertMember",member);
	}
	public Member selectMemberOne(int memberNo) {
		return sqlSessionTemplate.selectOne("cafe.jjdev.web.service.MemberMapper.selectMemberOne",memberNo);	
	}
}
