package monSal.transaction.dao;

import util.ConnectionFactory;
import util.JDBCClose;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import monSal.account.dao.AccountDAO;
import monSal.transaction.vo.TransactionVO;

public class TransactionDAO {

	public List<TransactionVO> selectAllTransaction(String accountNumber) { // 추후에 selectAccountDAO 로 간단히 구현할수 있을지도?

		Connection conn = null;
		PreparedStatement pstmt = null;
		List<TransactionVO> transactionList = new ArrayList<>();

		try {

			// 드라이버 받고 connect해서 connection 변수 하나 생성
			conn = new ConnectionFactory().getConnection();

			// sql문 작성
			StringBuilder sql = new StringBuilder();
			sql.append("select transaction_date, account_number, counter_account_number, transaction_type, transaction_amount, balance ");
			sql.append(" from t_transaction ");
			sql.append(" where account_number = ? ");
			sql.append(" order by transaction_date desc  ");

			// sql문 ?에 값넣기
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, accountNumber);

			// 작성한 sql문 실행하기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				
				TransactionVO transactionVO = new TransactionVO();

				transactionVO.setTransactionDate(rs.getString(1));
				transactionVO.setAccountNumber(rs.getString(2));
				transactionVO.setCounterAccountNumber(rs.getString(3));
				transactionVO.setTransactionType(rs.getString(4));
				transactionVO.setTransactionAmount(rs.getLong(5));
				transactionVO.setBalance(rs.getLong(6));
				
				transactionList.add(transactionVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 접속종료
			JDBCClose.close(conn, pstmt);
		}

		return transactionList;
	}
	
	public void recordDeposit(String accountNumber, String counterAccountNumber, long depositAmount) { // 추후에 selectAccountDAO 로 간단히 구현할수 있을지도?
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		AccountDAO dao = new AccountDAO();		
		long balance = dao.selectAccountDAO(accountNumber).getBalance();
		
		try {
			
			// 드라이버 받고 connect해서 connection 변수 하나 생성
			conn = new ConnectionFactory().getConnection();
			
			
			// sql문 작성
			StringBuilder sql = new StringBuilder();
			sql.append("insert into t_transaction(account_number, counter_account_number,transaction_type, transaction_amount, balance) ");
			sql.append(" values(?,?,?,?,?) ");
			
			// sql문 ?에 값넣기
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, accountNumber);
			pstmt.setString(2, counterAccountNumber);
			pstmt.setString(3, "D");
			pstmt.setLong(4, depositAmount);
			pstmt.setLong(5, balance+depositAmount);
			
			// 작성한 sql문 실행하기
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 접속종료
			JDBCClose.close(conn, pstmt);
		}
		
	}
	
	public void recordWithdraw(String accountNumber, String counterAccountNumber, long withdrawAmount) { // 추후에 selectAccountDAO 로 간단히 구현할수 있을지도?
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		AccountDAO dao = new AccountDAO();		
		long balance = dao.selectAccountDAO(accountNumber).getBalance();

		
		try {
			
			// 드라이버 받고 connect해서 connection 변수 하나 생성
			conn = new ConnectionFactory().getConnection();
			
			
			// sql문 작성
			StringBuilder sql = new StringBuilder();
			sql.append("insert into t_transaction(account_number, counter_account_number,transaction_type, transaction_amount, balance) ");
			sql.append(" values(?,?,?,?,?) ");
			
			// sql문 ?에 값넣기
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, accountNumber);
			pstmt.setString(2, counterAccountNumber);
			pstmt.setString(3, "W");
			pstmt.setLong(4, withdrawAmount);
			pstmt.setLong(5, balance-withdrawAmount);

			
			// 작성한 sql문 실행하기
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 접속종료
			JDBCClose.close(conn, pstmt);
		}
		
	}
	
	public void recordRegister(String accountNumber, String msg, long registerAmount) { // 추후에 selectAccountDAO 로 간단히 구현할수 있을지도?
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			// 드라이버 받고 connect해서 connection 변수 하나 생성
			conn = new ConnectionFactory().getConnection();
			
			
			// sql문 작성
			StringBuilder sql = new StringBuilder();
			sql.append("insert into t_transaction(account_number, counter_account_number,transaction_type, transaction_amount, balance) ");
			sql.append(" values(?,?,?,?,?) ");
			
			// sql문 ?에 값넣기
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, accountNumber);
			pstmt.setString(2, msg);
			pstmt.setString(3, "D");
			pstmt.setLong(4, registerAmount);
			pstmt.setLong(5, registerAmount);
			
			
			// 작성한 sql문 실행하기
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 접속종료
			JDBCClose.close(conn, pstmt);
		}
		
	}


}
