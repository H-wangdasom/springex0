package cafe.jjdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.web.service.Member;
import cafe.jjdev.web.service.MemberDao;

@Controller
public class MemberController {
	@Autowired //new �����ڸ� ���ֱ� ���� private���� �ϰ� �� @Autowired��� �ؿ��� ���� Ÿ������ �������ش�.
	private MemberDao memberDao;
	
	@RequestMapping(value="/memberList")
	public String memberList() {
		System.out.println("memberList ��û");
		//DB list get....
		return "memberList";
	}
	
	//Spring���� ���帹�� ����ϴ� ���
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
		//1.command��ü�� �Ű����� �޴� ���
	public String addMember(MemberRequest memberRequest) {	//����� Member��ü��  member�� ����ص� �ȴ�. �ٵ� ���Ƿ� ���� ������찡 ���� ��� ���� �����ߵȴ�.
		System.out.println(memberRequest);
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
