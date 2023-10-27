package com.sh.QnA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDAO {
	
	@Autowired
	DataSource ds;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	

	public ArrayList<QnaDTO> getListAll() throws SQLException {

		String sql = "select * from qna_board";
		ArrayList<QnaDTO> List = new ArrayList<>();
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String b_id = rs.getString(1);
				String b_subject = rs.getString(2);
				String b_contents = rs.getString(3);
				String b_date = rs.getString(4);

				QnaDTO cd = new QnaDTO(b_id,b_subject, b_contents,b_date);
				List.add(cd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		rs.close();
		pst.close();
		con.close();
		return List;

	}
	
	// ?òÑ?û¨?éò?ù¥Ïß??óê ???ïú Î™©Î°ù Í∞??†∏?ò§Í∏?
	// ?ûÖ?†• : int page, int pageSize (?òÑ?û¨?éò?ù¥Ïß?Î≤àÌò∏, ?éò?ù¥Ïß??Ç¨?ù¥Ï¶àÌÅ¨Í∏?)
	// Î∞òÌôò : ArrayList<QnaDTO>      (Í≥†Í∞ùÎ™©Î°ù)
	
	public ArrayList<QnaDTO> getListPage(int currentPage , int pageSize){
		
		//  ?ãú?ûë?éò?ù¥Ïß?			ÎßàÏ?Îß? ?éò?ù¥Ïß?
		int startPage = 0, endPage = 0;
		startPage = ((currentPage-1)*pageSize)+1;
		endPage = currentPage * pageSize;
		
		// rownum = selectÍ∞? ?ê†?ïå ?ûÑ?ùò?†Å?úºÎ°? Î≤àÌò∏Î•? ?ã¨?ïÑÏ§? colum?úºÎ°? Î≥¥Ïù¥Ïß? X
		// 
		String sql = "select * "
				+ "from (select rownum num, b_id, b_subject, b_contents, b_date"
				+ " from qna_board)"
				+ "where num between ? and ?";
		
		ArrayList<QnaDTO> list = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, startPage);
			pst.setInt(2, endPage);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String b_id = rs.getString(2);
				String b_subject = rs.getString(3);
				String b_contents = rs.getString(4);
				String b_date = rs.getString(5);
				QnaDTO Qna= new QnaDTO(b_id,b_subject,b_contents,b_date);
				list.add(Qna);
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public int getTotalCount() {
		int count = 0;
		String sql = "select count(*) from qna_board";
		
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	public void insertQna(String id , String subject, String contents){
		String sql = "insert into qna_board values(?,?,?,to_char(sysdate,'YY/MM/DD')";
		
		try {
			con = ds.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1,id);
			pst.setString(2,subject);
			pst.setString(3, contents);
			
			
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateQna(String id, String subject , String contents, String date) {
		String sql = "update qna_board set subject = ?, b_contents = ?,b_date = ? where id = ?";
		
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, subject);
			pst.setString(2, contents);
			pst.setString(3, date);
			pst.setString(4, id);
			pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	public void deleteQna(String b_id){
		String sql = "delete from boardtest where b_id=?";

		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, b_id);
			pst.executeUpdate();

			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
	
	
	
	

}
