package cafe.jjdev.web.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	SqlSessionTemplate SqlSessionTemplate;
	
	private final String NS = "cafe.jjdev.web.service.MemberMapper.";
	public int insertMember(Member member) {
		return SqlSessionTemplate.insert(NS+"insertMember"
				,member);
	}
	
	public Member selectMemberOne(int memberNo) {
		return SqlSessionTemplate.selectOne(NS+"selectMemberOne",memberNo);
			}

}
