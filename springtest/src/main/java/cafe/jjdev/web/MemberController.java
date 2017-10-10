package cafe.jjdev.web;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import cafe.jjdev.web.service.Member;
import cafe.jjdev.web.service.MemberDao;
import cafe.jjdev.web.service.MemberService;

@Controller
public class MemberController {
	@Autowired //new 연산자를 없애기 위해 private으로 하고 꼭 @Autowired써야 밑에와 같은 타입으로 선언해준다.
	private MemberDao memberDao;
	@Autowired 
	private MemberService memberService;
	
	//로그아웃
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //session 무효화 시킴
		return "redirect:/login";
	}
	
	//로그인 폼
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login(HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "login";
		}
		return "redirect:/test";
	}
	
	//로그인 처리
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		//로그인 프로세스 진행
		Member loginMember = memberDao.logon(member);
		if(loginMember == null) {
			System.out.println("로그인 노널");
			return "redirect:/login";
		} else {
			//session에 로그인 정보를 저장  매개변수로 session을 받으면 된다.
			session.setAttribute("loginMember", loginMember);
			return "redirect:/test";
		}
	}
	
	//회원전용 페이지
	@RequestMapping(value="/test")
	public String test(HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}
		return "test";
	}
	
	@RequestMapping(value="/memberList")
	public String memberList(Model model) {
		System.out.println("memberList 요청");
		List<Member> list = memberDao.selectMemberList();
		model.addAttribute("list",list);
		return "memberList";
	}
	
	//Spring에서 가장많이 사용하는 방법
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	
		//1.command객체로 매개변수 받는 방법
	public String addMember(MemberRequest memberRequest) {	//현재는 Member객체의  member를 사용해도 된다. 근데 현실로 가면 같은경우가 별로 없어서 새로 만들어야된다.
		System.out.println(memberRequest);
		memberService.addMember(memberRequest);
		return "redirect:/memberList";	//  response.sendRedirect("/memberList")    view 존재 
	}
	
	
	/*
	@RequestMapping(Value="/addMember", method = RequestMetghod.POST)
	
	//매개변수가 20개, 30개가 되면 다 받으려면 힘드니까 입력하는것의 객체를 만든다. Member를 이용하여 갖고오거나, 하나더 만들어서 사용하거나.
	 //2.RequestParam으로 이용하는 방법
	public String addMember(@RequestParam(value="memberId") String memberId
							,@RequestParam(value="memberPw") String memberPw
							,@RequestParam(value="memberName") String memberName) {
		System.out.println("memberId:" +memberId);
		System.out.println("memberPw:" +memberPw);
		System.out.println("memberName:" +memberName);
		return "";
	} */
	
@RequestMapping(value="/addMember", method =RequestMethod.GET)
	
	public String addMember() {
		return "addMember";
	}
	@RequestMapping("/getMember")
	
	
	public String getMember(Model model) { //request set,get의 역할을 model이 하는것
		Member member = memberDao.selectMemberOne(1);
		model.addAttribute("member",member);
		return "getMember";
	}
}
