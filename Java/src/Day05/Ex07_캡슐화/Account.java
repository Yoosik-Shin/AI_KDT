package Day05.Ex07_캡슐화;


/**
 * 통장계좌
 *  - 예금액
 *  - 예금주
 *  - 계좌번호
 *  - 은행명
 *  
 */
public class Account {

	private int deposit;
	private String depositor;
	private String depoNumber;
	private String bank;
	
	// 기본 생성자
	public Account() {
		this(0, "예금주 없음", "000000-00-000000", "은행없음");
	} 

	
	// 매개변수 생성자
	public Account(int deposit, String depositor, String depoNumber, String bank) {
		this.deposit = deposit;
		this.depositor = depositor;
		this.depoNumber = depoNumber;
		this.bank = bank;
	}

	
	// getter, setter
	public int getDeposit() {
		return deposit;
	}
	
	
	public void setDeposit(int deposit) {
		if(deposit < 0) return; // 계좌 예금액인데 -10000같은 터무니 없는 입력을 셋에서 방지할 수 있다.
		this.deposit = deposit;
	}
	
	
	public String getDepositor() {
		return depositor;
	}
	
	
	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}
	
	
	public String getDepoNumber() {
		return depoNumber;
	}
	
	
	public void setDepoNumber(String depoNumber) {
		this.depoNumber = depoNumber;
	}
	
	
	public String getBank() {
		return bank;
	}
	
	
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	
	// toString()
	@Override
	public String toString() {
		return "Account [deposit=" + deposit + ", depositor=" + depositor + ", depoNumber=" + depoNumber + ", bank="
				+ bank + "]";
	}
	
	
}
