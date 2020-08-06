package monSal.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import monSal.member.vo.MemberVO;
import util.ConnectionFactory;
import util.JDBCClose;

public class MemberDAO {

	/**
	 * 모든 회원목록 조회
	 */
	public List<MemberVO> selectAllMember() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		List<MemberVO> memberList = new ArrayList<>();

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(
					" select id, name, password, email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr, type, to_char(reg_date,'yyyy-mm-dd') as reg_date ");
			sql.append(" from t_member ");
			sql.append(" order by reg_date ");

			pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String id = rs.getString("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email_id = rs.getString("email_id");
				String email_domain = rs.getString("email_domain");
				String tel2 = rs.getString("tel2");
				String tel1 = rs.getString("tel1");
				String tel3 = rs.getString("tel3");
				String post = rs.getString("post");
				String basic_addr = rs.getString("basic_addr");
				String detail_addr = rs.getString("detail_addr");
				String type = rs.getString("type");
				String reg_date = rs.getString("reg_date");

				MemberVO member = new MemberVO(id, name, password, email_id, email_domain, tel1, tel2, tel3, post,
						basic_addr, detail_addr, type, reg_date);

				memberList.add(member);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			JDBCClose.close(conn, pstmt);

		}

		return memberList;
	}

	/**
	 * 회원가입 기능
	 */

	public void insertMember(String id, String name, String password, String email_id, String email_domain, String tel1,
			String tel2, String tel3, String post, String basic_addr, String detail_addr, String type) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(
					" insert into t_member(ID, NAME, PASSWORD, EMAIL_ID, EMAIL_DOMAIN, TEL1, TEL2, TEL3, POST, BASIC_ADDRESS, DETAIL_ADDRESS, USER_TYPE) ");
			sql.append("  values(?,?,?,?,?,?,?,?,?,?,?,?) ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setString(4, email_id);
			pstmt.setString(5, email_domain);
			pstmt.setString(6, tel1);
			pstmt.setString(7, tel2);
			pstmt.setString(8, tel3);
			pstmt.setString(9, post);
			pstmt.setString(10, basic_addr);
			pstmt.setString(11, detail_addr);
			pstmt.setString(12, type);

			pstmt.execute();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			JDBCClose.close(conn, pstmt);

		}

	}
	
	public void modifyMember(MemberVO member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" update t_member set email_id = ?, email_domain = ?, ");
			sql.append("                     tel1 = ?, tel2 = ?, tel3 = ?, post = ?, basic_address = ?, detail_address = ? " );
			sql.append(" 							where id = ? " );
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, member.getEmailId());
			pstmt.setString(2, member.getEmailDomain());
			pstmt.setString(3, member.getTel1());
			pstmt.setString(4, member.getTel2());
			pstmt.setString(5, member.getTel3());
			pstmt.setString(6, member.getPost());
			pstmt.setString(7, member.getBasicAddr());
			pstmt.setString(8, member.getDetailAddr());
			pstmt.setString(9, member.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			JDBCClose.close(conn, pstmt);
			
		}
		
	}
	
	public void deleteMember(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" delete from t_member where id = ?" );
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			JDBCClose.close(conn, pstmt);
			
		}
		
	}

	/**
	 * 특정 회원의 상세정보 조회
	 */

	public MemberVO selectMember(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		MemberVO member = null;

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(
					" select id, name, password, email_id, email_domain, tel1, tel2, tel3, post, basic_address, detail_address, user_type, reg_date ");
			sql.append(" from t_member ");
			sql.append(" where id = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String name = rs.getString("name");
				String password = rs.getString("password");
				String email_id = rs.getString("email_id");
				String email_domain = rs.getString("email_domain");
				String tel1 = rs.getString("tel1");
				String tel2 = rs.getString("tel2");
				String tel3 = rs.getString("tel3");
				String post = rs.getString("post");
				String basic_addr = rs.getString("basic_address");
				String detail_addr = rs.getString("detail_address");
				String type = rs.getString("user_type");
				String reg_date = rs.getString("reg_date");

				member = new MemberVO(id, name, password, email_id, email_domain, tel1, tel2, tel3, post, basic_addr,
						detail_addr, type, reg_date);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			JDBCClose.close(conn, pstmt);

		}

		return member;

	}

	/**
	 * id 중복체크
	 * 
	 */
	public boolean checkId(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int idCnt = -1;
		boolean idCheck = false;

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" select count(id) as idCnt ");
			sql.append(" from t_member ");
			sql.append(" where id = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			rs.next();

			idCnt = rs.getInt("idCnt");
			
			if(idCnt == 0) {
				idCheck = true;
			} else if(idCnt >= 1) {
				idCheck = false;
			}

		} catch (

		Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			JDBCClose.close(conn, pstmt);

		}

		return idCheck;

	}

}
