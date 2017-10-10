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
	@Autowired //new �����ڸ� ���ֱ� ���� private���� �ϰ� �� @Autowired��� �ؿ��� ���� Ÿ������ �������ش�.
	private MemberDao memberDao;
	@Autowired 
	private MemberService memberService;
	
	//�α׾ƿ�
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //session ��ȿȭ ��Ŵ
		return "redirect:/login";
	}
	
	//�α��� ��
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login(HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "login";
		}
		return "redirect:/test";
	}
	
	//�α��� ó��
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		//�α��� ���μ��� ����
		Member loginMember = memberDao.logon(member);
		if(loginMember == null) {
			System.out.println("�α��� ���");
			return "redirect:/login";
		} else {
			//session�� �α��� ������ ����  �Ű������� session�� ������ �ȴ�.
			session.setAttribute("loginMember", loginMember);
			return "redirect:/test";
		}
	}
	
	//ȸ������ ������
	@RequestMapping(value="/test")
	public String test(HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}
		return "test";
	}
	
	@RequestMapping(value="/memberList")
	public String memberList(Model model) {
		System.out.println("memberList ��û");
		List<Member> list = memberDao.selectMemberList();
		model.addAttribute("list",list);
		return "memberList";
	}
	
	//Spring���� ���帹�� ����ϴ� ���
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	
		//1.command��ü�� �Ű����� �޴� ���
	public String addMember(MemberRequest memberRequest) {	//����� Member��ü��  member�� ����ص� �ȴ�. �ٵ� ���Ƿ� ���� ������찡 ���� ��� ���� �����ߵȴ�.
		System.out.println(memberRequest);
		memberService.addMember(memberRequest);
		return "redirect:/memberList";	//  response.sendRedirect("/memberList")    view ���� 
	}
	
	
	/*
	@RequestMapping(Value="/addMember", method = RequestMetghod.POST)
	
	//�Ű������� 20��, 30���� �Ǹ� �� �������� ����ϱ� �Է��ϴ°��� ��ü�� �����. Member�� �̿��Ͽ� ������ų�, �ϳ��� ���� ����ϰų�.
	 //2.RequestParam���� �̿��ϴ� ���
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
	
	
	public String getMember(Model model) { //request set,get�� ������ model�� �ϴ°�
		Member member = memberDao.selectMemberOne(1);
		model.addAttribute("member",member);
		return "getMember";
	}
}
