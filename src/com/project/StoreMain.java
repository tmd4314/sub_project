package com.project;

import java.util.List;
import java.util.Scanner;

import com.project.Product.Product;
import com.project.Product.ProductJdbc;
import com.project.Resident.Resident;
import com.project.Resident.ResidentJdbc;
import com.project.Review.Review;
import com.project.Review.ReviewJdbc;
import com.project.User.User;
import com.project.User.UserJdbc;

public class StoreMain {
	// 2. 정적 필드. 할당.
	private static StoreMain instance = new StoreMain();
	// 1. 생성자 private 선언
	private StoreMain() {
	}
	// 3. getInstance() 제공.
	public static StoreMain getInstance() {
		return instance;
	}
	
	Scanner scn = new Scanner(System.in);
	
	UserJdbc udao = new UserJdbc();
	
	ProductJdbc pdao = new ProductJdbc();
	
	ResidentJdbc rdao = new ResidentJdbc();
	
	ReviewJdbc rvdao = new ReviewJdbc();
	
	private User currentUser;
	
	private Resident resident;
	
	private User signup(String id, String pw, String name) {
		return udao.signup(id, pw, name);
	}
	
	private void u_signup() {
		
		System.out.println("====== 회원가입 ============");
		System.out.print("아이디를 입력하세요>> ");
		String id = scn.nextLine();
		System.out.print("비밀번호를 입력하세요>>");
		String pw = scn.nextLine();
		System.out.print("이름을 입력하세요>>");
		String name = scn.nextLine();
		System.out.println("==========================");
		// 유효성 검사 추가 (예: 비밀번호 길이, 아이디 중복 체크 등)
	    if (id.isEmpty() || pw.isEmpty() || name.isEmpty()) {
	        System.out.println("모든 필드를 입력해야 합니다.");
	        return;
	    }
		
		User user = signup(id,pw,name);
		if(user != null) {
			System.out.println("회원가입 되었습니다.");
		}else {
	        System.out.println("회원가입 실패. 다시 시도해 주세요.");
	    }
	}

	private User login(String id, String pw) {
		return udao.login(id,pw);
	}
	
	private void u_login() {
		System.out.println("======== 로그인 ==========");
		System.out.print("아이디 입력>> ");
		String id = scn.nextLine();
		System.out.print("비밀번호 입력>> ");
		String pw = scn.nextLine();
		currentUser = login(id,pw);
		if(currentUser != null) {
			System.out.println(currentUser.getUserName() + "님 환영합니다.");
			runMain();
		}else {
	        System.out.println("로그인 실패. 다시 시도해 주세요.");
	    }
	}
	
	private Resident relogin(String id, String pw) {
		return rdao.relogin(id,pw);
	}
	
	private void r_resident() {
		System.out.println("======== 관리자 로그인 ==========");
		System.out.print("아이디 입력>> ");
		String id = scn.nextLine();
		System.out.print("비밀번호 입력>> ");
		String pw = scn.nextLine();
		resident = relogin(id, pw);
		if(resident != null) {
			System.out.println(resident.getReName() + "님 환영합니다.");
			residentMain();
		}else {
	        System.out.println("로그인 실패. 다시 시도해 주세요.");
	    }
	}
	
	
	private void add() {
		System.out.print("등록할 상품코드 입력>> ");
		String productCode = scn.nextLine();
		System.out.print("등록할 상품명 입력>> ");
		String productName = scn.nextLine();
		System.out.print("등록할 상품가격 입력>> ");
		String price = scn.nextLine();
		if(productCode.isBlank() || productName.isBlank() || price.isBlank()) {
			System.out.println("항목을 입력하세요.");
			return;
		}
		
		Product product = new Product();
		product.setProductCode(productCode);
        product.setProductName(productName);
        product.setPrice(Integer.parseInt(price));
        
        boolean inserted = pdao.insert(product, currentUser.getUserId());
        
		if(inserted) {
			System.out.println("정상 등록");
		}else {
			System.out.println("등록 실패");
		}
	}
	
	private List<Product> searchList(String keyword, int currentPage, int pageSize) {
	    if (keyword.isEmpty()) {
	        return pdao.list(currentPage, pageSize); // 전체 목록 조회
	    } else {
	        return pdao.slist(keyword); // 특정 조건으로 조회
	    }
	}
	
	private void search() {
		String productName ="";
		while(true) {
			System.out.print("상품명 입력>> ");
			productName = scn.nextLine();
			if(!productName.isBlank()) {
				break;
			}
			System.out.println("상품명을 정확히 입력해주세요.!");
		}
		System.out.println("=========== 상품목록 ==========");
		System.out.println("상품코드  상품명  등록자  등록일자");
		System.out.println("----------------------------");
		List<Product> slist = pdao.slist(productName);
		for(Product pr : slist) {
			System.out.println(pr.showList());
		}
		System.out.println("----------------------------");
	}
	
	private void info() {
		String productCode ="";
		boolean run = true;	
		while(run) {
			while(true) {
				System.out.print("상품코드 입력>> ");
				productCode = scn.nextLine();
				if(!productCode.isBlank()) {
					break;
				}
				System.out.println("상품코드를 정확히 입력해주세요.!");
			}
			List<Product> ilist = pdao.ilist(productCode);
			if (ilist.isEmpty()) {
	            System.out.println("해당 상품이 없습니다.");
	            continue; // 상품이 없으면 반복
	        }
			for(Product pr : ilist) {
				System.out.println("=========" + pr.getProductName() + "==========");
				System.out.println(pr.showListInfo());
			}
			System.out.println("----------------------------");
			System.out.println("1.리뷰 2.나가기");
			System.out.print("선택>> ");
			int menu = 2;
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				}catch(NumberFormatException e) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}
			}	
			switch(menu) {
			case 1:
				review();
				run = false;
				break;
			case 2:
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
	}
	
	private void re_write() {
		String productCode ="";
		while(true) {
			System.out.print("작성할 상품코드 입력>> ");
			productCode = scn.nextLine();
			if(!productCode.isBlank()) {
				break;
			}
			System.out.println("상품코드가 없습니다.");
		}
		System.out.print("리뷰 작성>> ");
		String revconte = scn.nextLine();
		if(productCode.isBlank() || revconte.isBlank()) {
			System.out.println("항목을 입력하세요.");
			return;
		}
		
		Review review = new Review();
		review.setProcode(productCode);
        review.setRevconte(revconte);

        boolean inserted = rvdao.write(review, currentUser.getUserId());
        
		if(inserted) {
			System.out.println("등록이 완려되었습니다.!");
		}else {
			System.out.println("등록 실패");
		}
	}
	
	private void re_modify() {
		System.out.print("리뷰목록 입력>> ");
		String reno = scn.nextLine();
		if(reno.isBlank()) {
			System.out.print("상품코드를 반드시 입력하세요.");
			return;
		}
		System.out.print("리뷰내용 입력>> ");
		String revconte = scn.nextLine();
		if(revconte.isBlank()) {
			System.out.println("항목을 채워넣으세요.!!!!!!");
			return;
		}
		Review review = new Review();
		review.setReno(Integer.parseInt(reno));
		review.setRevconte(revconte);
		
		boolean modified = rvdao.modify(review, currentUser.getUserId());
		
		if(modified) {
			System.out.println("수정성공");
		}else {
			System.out.println("본인이 아니면 수정 할수없습니다.");
		}
	}
	
	private void re_delete() {
		System.out.print("삭제할 목록을 입력>> ");
		String reno = scn.nextLine();
		if(reno.isBlank()) {
			System.out.println("반드시 목록을 입력하시오. ");
			return;
		}
		
		Review review = new Review();
		review.setReno(Integer.parseInt(reno));
		boolean redeleted = rvdao.redelete(review, currentUser.getUserId());
		
		if(redeleted) {
			System.out.println("리뷰 삭제");
		}else {
			System.out.println("본인이 아니면 삭제 할수없습니다.");
		}
		
	}
	
	private void review() {
		boolean run = true;
		while(run) {
			System.out.println("================ 리뷰 ===============");
			System.out.println("1.리뷰작성 2.리뷰수정 3.리뷰삭제 4.나가기");
			System.out.println("====================================");
			System.out.print("선택>> ");
			int menu = 4;
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				}catch(NumberFormatException e) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}
			}
			switch(menu) {
			case 1:
				re_write();
				break;
			case 2:
				re_modify();
				break;
			case 3:
				re_delete();
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}
	}
	
	private void list() {
		int pageSize = 5;
		int currentPage = 1;
		boolean run = true;
		while(run) {
			System.out.println("=========== 상품목록 ===================");
			System.out.println("상품코드  상품명  등록자  등록일자");
			System.out.println("--------------------------------------");
			List<Product> list = searchList("", currentPage, pageSize);
			for(Product pr : list) {
				System.out.println(pr.showList());
			}
			System.out.println("-------------------------------------");
			System.out.println("1.상품정보 2.상품검색 3.이전 4.다음 5.나가기");
			System.out.print("선택>> ");
			int menu = 5;
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				}catch(NumberFormatException e) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}
			}
			
			switch(menu) {
			case 1:
				info();
				break;
			case 2:
				search();
				break;
			case 3:
				if (currentPage > 1) {
                    currentPage--;  // 이전 페이지로 이동
                } else {
                    System.out.println("첫 페이지입니다.");
                }
				break;
			case 4:
				currentPage++;  // 다음 페이지로 이동
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
	}
	
	private void edit() {
		System.out.print("상품코드 입력>> ");
		String productCode = scn.nextLine();
		if(productCode.isBlank()) {
			System.out.print("상품코드를 반드시 입력하세요.");
			return;
		}
		System.out.print("상품명 입력>> ");
		String productName = scn.nextLine();
		System.out.print("가격입력>> ");
		String price = scn.nextLine();
		if(productName.isBlank() || price.isBlank()) {
			System.out.println("항목을 채워넣으세요.!!!!!!");
			return;
		}
		Product product = new Product();
		product.setProductCode(productCode);
		product.setProductName(productName);
		product.setPrice(Integer.parseInt(price));
		
		if(pdao.update(product)) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
	}
	
	private void delete() {
		System.out.print("상품코드 입력>> ");
		String productCode = scn.nextLine();
		if(productCode.isBlank()) {
			System.out.println("상품코드를 반드시 입력하세요.");
			return;
		}
		
		Product product = new Product();
		product.setProductCode(productCode);
		
		if(pdao.delete(product)) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
	}
	
	private void out() {
		System.out.print("구매할 상품명>> ");
		String productName = scn.nextLine();
		System.out.print("구매할 가격지불>> ");
		String price = scn.nextLine();
		if(productName.isBlank() || price.isBlank()) {
			System.out.println("항목을 입력해주세요.");
		}
		
		if(pdao.check(productName, Integer.parseInt(price))) {
			pdao.updatePurchase(productName);
			System.out.println("판매완료");
		}else {
			System.out.println("가격이 맞지 않습니다.");
		}
	}
		
	public void runMain() {
		boolean run = true;
		while(run) {
			System.out.println("============= 다나와 마켓 ============");
			System.out.println("1.상품등록 2.상품목록 3.상품판매 4.로그아웃");
			System.out.println("===================================");
			System.out.print("선택>> ");
			int menu = 4;
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				}catch(NumberFormatException e) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}
			}
			
			switch(menu) {
			case 1:
				add();
				break;
			case 2:
				list();
				break;
			case 3:
				out();
				break;
			case 4:
				System.out.println("로그아웃 되었습니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
	}
	
	public void residentMain() {
		boolean run = true;
		while(run) {
			System.out.println("============= 관리자 사이트 ============");
			System.out.println("1.상품목록 2.상품수정 3.상품삭제 4.로그아웃");
			System.out.println("=====================================");
			System.out.print("선택>> ");
			int menu = 4;
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				}catch(NumberFormatException e) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}
			}
			
			switch(menu) {
			case 1:
				list();
				break;
			case 2:
				edit();
				break;
			case 3:
				delete();
				break;
			case 4:
				System.out.println("로그아웃 되었습니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
	}
	
	public static void main(String[] args) {
		boolean run = true;
		StoreMain app = new StoreMain();
		int menu = 3;
		while(run) {
			System.out.println("============================");
			System.out.println("1.회원가입 2.로그인 3.관리자 로그인");
			System.out.println("============================");
			System.out.print("선택>> ");
			try {
				menu = Integer.parseInt(app.scn.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
				continue;
			}
			
			switch(menu) {
			case 1: // 회원가입
				app.u_signup();
				break;
			case 2: // 로그인
				app.u_login();
				break;
			case 3: // 관리자 로그인
				app.r_resident();
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
	}
}
