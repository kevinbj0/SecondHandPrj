package com.sh.QnA;

import lombok.Data;

@Data
public class QnaHandler {

	int currentPage;	//??¬??΄μ§?
	int totRecords;		// μ΄? ? μ½λ ?
	int pageSize;		// ??΄μ§? ?¬?΄μ¦? (? ??΄μ§?? λ³΄μ΄? κΈ? ?)
	int grpSize;		// κ·Έλ£Ή? ?¬?΄μ¦?
	
	int totalPage;		// μ΄? ??΄μ§? ?
	int currentGrp;		// ??¬ ??΄μ§? κ·Έλ£Ή
	int grpStartPage;	// κ·Έλ£Ή? ?? ??΄μ§?
	int grpEndPage;		// κ·Έλ£Ή? ? ??΄μ§? 
	
	public QnaHandler(int currentPage, int totRecords, int pageSize, int grpSize) {
		super();
		this.currentPage = currentPage;
		this.totRecords = totRecords;
		this.pageSize = pageSize;
		this.grpSize = grpSize;
		calcPage();
	}
	
	public void calcPage() {
		
		// μ΄? ??΄μ§? ?
		int remain = totRecords % pageSize;
		if(remain == 0 ) {
			totalPage = totRecords / pageSize;
		}else {
			currentGrp = totRecords / pageSize + 1;
		}
		
		// ??¬ κ·Έλ£Ή κ΅¬νκΈ?
		int remain2 = currentPage % grpSize;
		if(remain2 == 0) {
			currentGrp = currentPage / grpSize;
		}else {
			currentGrp = currentPage / grpSize +1;
		}
		
		// ??¬ κ·Έλ£Ή ????΄μ§?, λ§μ?λ§? ??΄μ§? κ΅¬νκΈ?
		grpStartPage = ( currentGrp-1) * grpSize +1;
		grpEndPage = currentGrp * grpSize;
		if(grpEndPage > totalPage) {
			grpEndPage = totalPage;
		}
		
	}

	
	
}
