package com.sh.QnA;

import lombok.Data;

@Data
public class QnaHandler {

	int currentPage;	//?˜„?ž¬?Ž˜?´ì§?
	int totRecords;		// ì´? ? ˆì½”ë“œ ?ˆ˜
	int pageSize;		// ?Ž˜?´ì§? ?‚¬?´ì¦? (?•œ ?Ž˜?´ì§??— ë³´ì´?Š” ê¸? ?ˆ˜)
	int grpSize;		// ê·¸ë£¹?˜ ?‚¬?´ì¦?
	
	int totalPage;		// ì´? ?Ž˜?´ì§? ?ˆ˜
	int currentGrp;		// ?˜„?ž¬ ?Ž˜?´ì§? ê·¸ë£¹
	int grpStartPage;	// ê·¸ë£¹?˜ ?‹œ?ž‘ ?Ž˜?´ì§?
	int grpEndPage;		// ê·¸ë£¹?˜ ? ?Ž˜?´ì§? 
	
	public QnaHandler(int currentPage, int totRecords, int pageSize, int grpSize) {
		super();
		this.currentPage = currentPage;
		this.totRecords = totRecords;
		this.pageSize = pageSize;
		this.grpSize = grpSize;
		calcPage();
	}
	
	public void calcPage() {
		
		// ì´? ?Ž˜?´ì§? ?ˆ˜
		int remain = totRecords % pageSize;
		if(remain == 0 ) {
			totalPage = totRecords / pageSize;
		}else {
			currentGrp = totRecords / pageSize + 1;
		}
		
		// ?˜„?ž¬ ê·¸ë£¹ êµ¬í•˜ê¸?
		int remain2 = currentPage % grpSize;
		if(remain2 == 0) {
			currentGrp = currentPage / grpSize;
		}else {
			currentGrp = currentPage / grpSize +1;
		}
		
		// ?˜„?ž¬ ê·¸ë£¹ ?‹œ?ž‘?Ž˜?´ì§?, ë§ˆì?ë§? ?Ž˜?´ì§? êµ¬í•˜ê¸?
		grpStartPage = ( currentGrp-1) * grpSize +1;
		grpEndPage = currentGrp * grpSize;
		if(grpEndPage > totalPage) {
			grpEndPage = totalPage;
		}
		
	}

	
	
}
