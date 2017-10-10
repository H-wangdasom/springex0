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
	@Autowired //new 연산자를 없애기 위해 private으로 하고 꼭 @Autowired써야 밑에와 같은 타입으로 선언해준다.
	private MemberDao memberDao;
	
	@RequestMapping(value="/memberList")
	public String memberList() {
		System.out.println("memberList 요청");
		//DB list get....
		return "memberList";
	}
	
	//Spring에서 가장많이 사용하는 방법
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
		//1.command객체로 매개변수 받는 방법
	public String addMember(MemberRequest memberRequest) {	//현재는 Member객체의  member를 사용해도 된다. 근데 현실로 가면 같은경우가 별로 없어서 새로 만들어야된다.
		System.out.println(memberRequest);
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
