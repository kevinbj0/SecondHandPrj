package com.sh.QnA;

import lombok.Data;

@Data
public class QnaHandler {

	int currentPage;	//?��?��?��?���?
	int totRecords;		// �? ?��코드 ?��
	int pageSize;		// ?��?���? ?��?���? (?�� ?��?���??�� 보이?�� �? ?��)
	int grpSize;		// 그룹?�� ?��?���?
	
	int totalPage;		// �? ?��?���? ?��
	int currentGrp;		// ?��?�� ?��?���? 그룹
	int grpStartPage;	// 그룹?�� ?��?�� ?��?���?
	int grpEndPage;		// 그룹?�� ?�� ?��?���? 
	
	public QnaHandler(int currentPage, int totRecords, int pageSize, int grpSize) {
		super();
		this.currentPage = currentPage;
		this.totRecords = totRecords;
		this.pageSize = pageSize;
		this.grpSize = grpSize;
		calcPage();
	}
	
	public void calcPage() {
		
		// �? ?��?���? ?��
		int remain = totRecords % pageSize;
		if(remain == 0 ) {
			totalPage = totRecords / pageSize;
		}else {
			currentGrp = totRecords / pageSize + 1;
		}
		
		// ?��?�� 그룹 구하�?
		int remain2 = currentPage % grpSize;
		if(remain2 == 0) {
			currentGrp = currentPage / grpSize;
		}else {
			currentGrp = currentPage / grpSize +1;
		}
		
		// ?��?�� 그룹 ?��?��?��?���?, 마�?�? ?��?���? 구하�?
		grpStartPage = ( currentGrp-1) * grpSize +1;
		grpEndPage = currentGrp * grpSize;
		if(grpEndPage > totalPage) {
			grpEndPage = totalPage;
		}
		
	}

	
	
}
