package cafe.jjdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.web.service.Member;
import cafe.jjdev.web.service.MemberDao;
import cafe.jjdev.web.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value="/memberList")
	public String memberList() {
		System.out.println("memberList 요청...");
		//DB list get...
		return "memberList";
	}
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	public String addMember(MemberRequest memberRequest) {
		System.out.println(memberRequest);
		//Member member command 객체(MembrRequest)타입으로 한번에 받기 밑에꺼랑 같지만 다른편한방법(여러개일경우)
		memberService.addMember(memberRequest);
		return "redirect:/memberList";//response.sendRedirect("/memberList")
			
				//리다시키고 싶으면 뷰쪽에다가 redirect memberlist 뷰 jsp 를 보여주겠다가 아니라 재요청 하겠다는 뜻.
				//앞에 접두사 redirect 붙여서 사용.
	}
	
	/*@RequestParam 을 이용해서 각각 값 받아오기.
	 * @RequestMapping(value="/addMember", method = RequestMethod.POST)
	public String addMember(@RequestParam(value="memberId")String memberId
							,@RequestParam(value="memberPw")String memberPw
							,@RequestParam(value="memberName")String memberName) {
			System.out.println("memberId :"+memberId);
			System.out.println("memberPw :"+memberPw);
			System.out.println("memberName :"+memberName);
		return "";
	}*/
	
	@RequestMapping(value="/addMember", method = RequestMethod.GET)
	public String addMember() {
		return"addMember";
	}
	@RequestMapping("/getMember")
		public String getMember(Model model) {
			Member member = memberDao.selectMemberOne(1);
			model.addAttribute("member",member);
			return "getMember";
	
	}
}
