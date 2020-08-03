package monSal.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import monSal.login.vo.LoginVO;
import util.ConnectionFactory;

public class LoginDAO {

	public LoginVO login(LoginVO loginVO) {
		
		LoginVO userVO = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, name, user_type ");
		sql.append("  from t_member ");
		sql.append(" where id = ? and password = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userVO = new LoginVO();
				userVO.setId(rs.getString("id"));
				userVO.setName(rs.getString("name"));
				userVO.setType(rs.getString("user_type"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return userVO;
	}

	
	public void deleteMember(String id) {
		
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_member ");
		sql.append(" where id = ?");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}









