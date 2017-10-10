package cafe.jjdev.web.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	SqlSessionTemplate SqlSessionTemplate;
	
	public Member selectMemberOne(int memberNo) {
		return SqlSessionTemplate.selectOne("cafe.jjdev.web.service.MemberMapper.selectMemberOne",memberNo);
			}

}
