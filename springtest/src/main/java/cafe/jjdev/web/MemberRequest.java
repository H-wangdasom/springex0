package cafe.jjdev.web;

//Member타입이 없을경우 하나의 클래스를 만들자
public class MemberRequest {
	private String memberId;
	private String memberPw;
	private String memberName;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "MemberRequest [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName + "]";
	}
	
}
