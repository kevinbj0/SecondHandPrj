package com.sh.QnA;

import java.sql.Date;

import lombok.Data;

@Data
public class QnaDTO {

	String b_id;
	String b_contents;
	String b_date;
	String b_subject;

	public QnaDTO() {
		super();
	}
	

	public QnaDTO(String b_id, String b_subject ,String b_contents, String b_date) {
		super();
		this.b_id = b_id;
		this.b_subject = b_subject;
		this.b_contents = b_contents;
		this.b_date = b_date;
	}







	

}
