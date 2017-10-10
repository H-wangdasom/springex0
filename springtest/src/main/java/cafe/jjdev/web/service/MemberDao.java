package cafe.jjdev.web.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository//
public class MemberDao {
	@Autowired//new 연산자 안쓰게끔 하는 것 
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String NS ="cafe.jjdev.web.service.MemberMapper.";
	
	public int insertMember(Member member) {
		return sqlSessionTemplate.insert(NS+"insertMember",member);
	}
	public Member selectMemberOne(int memberNo) {
		return sqlSessionTemplate.selectOne("cafe.jjdev.web.service.MemberMapper.selectMemberOne",memberNo);	
	}
}
