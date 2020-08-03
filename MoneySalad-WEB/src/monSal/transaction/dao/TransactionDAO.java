package monSal.transaction.dao;

import util.ConnectionFactory;
import util.JDBCClose;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			sql.append("select transaction_date, account_number, counter_account_number, transaction_type, transaction_amount ");
			sql.append(" from t_transaction ");
			sql.append(" where account_number = ? ");
			sql.append(" order by transaction_date  ");

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


}
