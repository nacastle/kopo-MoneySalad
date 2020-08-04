package monSal.account.dao;

import monSal.account.vo.AccountVO;
import util.ConnectionFactory;
import util.JDBCClose;
import monSal.login.vo.LoginVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

	public List<String> selectAllAccountNumberDAO() { // 추후에 selectAccountDAO 로 간단히 구현할수 있을지도?

		Connection conn = null;
		PreparedStatement pstmt = null;
		List<String> accoutNumberList = new ArrayList<>();

		try {

			// 드라이버 받고 connect해서 connection 변수 하나 생성
			conn = new ConnectionFactory().getConnection();

			// sql문 작성
			StringBuilder sql = new StringBuilder();
			sql.append(" select account_number ");
			sql.append(" from t_account ");

			// sql문 ?에 값넣기
			pstmt = conn.prepareStatement(sql.toString());


			// 작성한 sql문 실행하기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String accountNumber = rs.getString(1);
				accoutNumberList.add(accountNumber);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 접속종료
			JDBCClose.close(conn, pstmt);
		}

		return accoutNumberList;
	}
	
	public List<AccountVO> selectAllAccountDAO(LoginVO userVO) { // 추후에 selectAccountDAO 로 간단히 구현할수 있을지도?
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<AccountVO> accoutList = new ArrayList<>();
		
		try {
			
			// 드라이버 받고 connect해서 connection 변수 하나 생성
			conn = new ConnectionFactory().getConnection();
			
			// sql문 작성
			StringBuilder sql = new StringBuilder();
			sql.append("select id, account_nickname, account_number, account_bank, balance ");
			sql.append(" from t_account ");
			sql.append(" where id = ? ");
			sql.append(" order by account_bank  ");
			
			// sql문 ?에 값넣기
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, userVO.getId());
			
			// 작성한 sql문 실행하기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				
				AccountVO accountVO = new AccountVO();
				
				String id = rs.getString(1);
				String nickname = rs.getString(2);
				String accountNumber = rs.getString(3);
				String bank = rs.getString(4);
				long balance = rs.getLong(5);
				
				accountVO.setId(id);
				accountVO.setNickname(nickname);
				accountVO.setAccountNumber(accountNumber);
				accountVO.setBank(bank);
				accountVO.setBalance(balance);
				
				accoutList.add(accountVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 접속종료
			JDBCClose.close(conn, pstmt);
		}
		
		return accoutList;
	}

	public List<AccountVO> selectAccountDAO(LoginVO userVO, String nicknameOrBank) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		List<AccountVO> accountVOList = new ArrayList<>();
		AccountVO accountVO = null;

		try {

			// 드라이버 받고 connect해서 connection 변수 하나 생성
			conn = new ConnectionFactory().getConnection();

			// sql문 작성
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append(" from t_account a ");
			sql.append(" join t_user u ");
			sql.append(" on a.id = u.id ");
			sql.append(" where a.id = ? ");
			sql.append("   and (a.nickname = ? or a.bank = ? )");
			sql.append(" order by nickname ");

			// sql문 ?에 값넣기
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, userVO.getId());
			pstmt.setString(2, nicknameOrBank);
			pstmt.setString(3, nicknameOrBank);

			// 작성한 sql문 실행하기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				String id = rs.getString(1);
				String nickname = rs.getString(2);
				String accountNumber = rs.getString(3);
				String bank = rs.getString(4);
				String accountUser = rs.getString(5);
				long balance = rs.getLong(6);

				accountVO = new AccountVO(id, nickname, accountNumber, bank, accountUser, balance);

				accountVOList.add(accountVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 접속종료
			JDBCClose.close(conn, pstmt);
		}

		return accountVOList;
	}

	// selectAccountDAO를 계좌번호로도 조회할수 있도록 오버로딩
	public AccountVO selectAccountDAO(LoginVO userVO, int tempAccountNumber) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		AccountVO accountVO = null;

		try {

			// 드라이버 받고 connect해서 connection 변수 하나 생성
			conn = new ConnectionFactory().getConnection();

			// sql문 작성
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append(" from t_account a ");
			sql.append(" join t_user u ");
			sql.append(" on a.id = u.id ");
			sql.append(" where a.id = ? ");
			sql.append("   and a.account_number = ? ");
			sql.append(" order by bank ");

			// sql문 ?에 값넣기
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, userVO.getId());
			pstmt.setInt(2, tempAccountNumber);

			// 작성한 sql문 실행하기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				String id = rs.getString(1);
				String nickname = rs.getString(2);
				String accountNumber = rs.getString(3);
				String bank = rs.getString(4);
				String accountUser = rs.getString(5);
				long balance = rs.getLong(6);

				accountVO = new AccountVO(id, nickname, accountNumber, bank, accountUser, balance);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 접속종료
			JDBCClose.close(conn, pstmt);
		}

		return accountVO;
	}

	// selectAccountDAO를 은행명으로도 조회할수 있도록 오버로딩
	public List<AccountVO> selectAccountByBankDAO(LoginVO userVO, String tempBank) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		List<AccountVO> accountVOList = new ArrayList<>();

		try {

			// 드라이버 받고 connect해서 connection 변수 하나 생성
			conn = new ConnectionFactory().getConnection();

			// sql문 작성
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append(" from t_account a ");
			sql.append(" join t_user u ");
			sql.append(" on a.id = u.id ");
			sql.append(" where a.id = ? ");
			sql.append("   and a.bank = ? ");
			sql.append(" order by nickname ");

			// sql문 ?에 값넣기
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, userVO.getId());
			pstmt.setString(2, tempBank);

			// 작성한 sql문 실행하기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				String id = rs.getString(1);
				String nickname = rs.getString(2);
				String accountNumber = rs.getString(3);
				String bank = rs.getString(4);
				String accountUser = rs.getString(5);
				long balance = rs.getLong(6);

				AccountVO accountVO = new AccountVO(id, nickname, accountNumber, bank, accountUser, balance);
				accountVOList.add(accountVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 접속종료
			JDBCClose.close(conn, pstmt);
		}

		return accountVOList;
	}

	public AccountVO selectAccountDAO(int tempAccountNumber) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		AccountVO accountVO = null;

		try {

			// 드라이버 받고 connect해서 connection 변수 하나 생성
			conn = new ConnectionFactory().getConnection();

			// sql문 작성
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append(" from t_account a ");
			sql.append(" where a.account_number = ? ");

			// sql문 ?에 값넣기
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, tempAccountNumber);

			// 작성한 sql문 실행하기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				String id = rs.getString(1);
				String nickname = rs.getString(2);
				String accountNumber = rs.getString(3);
				String bank = rs.getString(4);
				String accountUser = rs.getString(5);
				long balance = rs.getLong(6);

				accountVO = new AccountVO(id, nickname, accountNumber, bank, accountUser, balance);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 접속종료
			JDBCClose.close(conn, pstmt);
		}
		return accountVO;
	}

//	public AccountVO selectAccountDAO(String tempId) {
//	
//	Connection conn = null; PreparedStatement pstmt = null; AccountVO accountVO =
//	null;
//	
//	try {
//	
//	// 드라이버 받고 connect해서 connection 변수 하나 생성 conn = new
//	ConnectionFactory().getConnection();
//	
//	// sql문 작성 StringBuilder sql = new StringBuilder(); sql.append("select * ");
//	sql.append(" from t_account a "); sql.append(" where a.id = ? ");
//	
//	// sql문 ?에 값넣기 pstmt = conn.prepareStatement(sql.toString());
//	
//	pstmt.setString(1, tempId);
//	
//	
//	// 작성한 sql문 실행하기 ResultSet rs = pstmt.executeQuery(); while (rs.next()) {
//	
//	String id = rs.getString(1); String nickname = rs.getString(2); int
//	accountNumber = rs.getInt(3); String bank = rs.getString(4); String
//	accountUser = rs.getString(5); long balance = rs.getLong(6);
//	
//	accountVO = new AccountVO(id, nickname, accountNumber, bank, accountUser,
//	balance); }
//	
//	}catch(
//
//	Exception e)
//	{
//		e.printStackTrace();
//	}finally
//	{ // 접속종료
//		JDBCClose.close(conn, pstmt);
//	}
//
//	return accountVO;
//	}

	public void deleteAccountDAO(String accountNumber) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();

            sql.append("delete from t_account ");
            sql.append(" where account_number = ?  ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, accountNumber);

            // 작성한 sql문 실행하기
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

    }

	public void reviseAccountDAO(String newNickname, String accountNumber) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();

            sql.append("update t_account ");
            sql.append(" set account_nickname = ? ");
            sql.append(" where account_number = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, newNickname);
            pstmt.setString(2, accountNumber);

            // 작성한 sql문 실행하기
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

    }

	public void registerAccountDAO(AccountVO accountVO) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();
            

            sql.append(" insert into t_account(account_number, account_bank, account_nickname, balance, id) ");
            sql.append(" values (?, ?, ?, ? ,?) ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, accountVO.getAccountNumber());
            pstmt.setString(2, accountVO.getBank());
            pstmt.setString(3, accountVO.getNickname());
            pstmt.setLong(4, accountVO.getBalance());
            pstmt.setString(5, accountVO.getId());

            // 작성한 sql문 실행하기
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

    }

	// 별칭 혹은 계좌번호로 입금
	public void depositDAO(LoginVO userVO, long originalBalance, long depositAmount, int tempAccountNumber) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();

            sql.append("update t_account ");
            sql.append(" set balance = ?+? ");
            sql.append(" where id = ? ");
            sql.append("   and account_number = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());


            pstmt.setLong(1, originalBalance);
            pstmt.setLong(2, depositAmount);
            pstmt.setString(3, userVO.getId());
            pstmt.setInt(4, tempAccountNumber);

            // 작성한 sql문 실행하기
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

    }

	// 별칭 혹은 계좌번호로 출금
	public void withdrawDAO(LoginVO userVO, long originalBalance, long withdrawAmount, int tempAccountNumber) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();

            sql.append("update t_account ");
            sql.append(" set balance = ?-? ");
            sql.append(" where id = ? ");
            sql.append("   and account_number = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setLong(1, originalBalance);
            pstmt.setLong(2, withdrawAmount);
            pstmt.setString(3, userVO.getId());
            pstmt.setInt(4, tempAccountNumber);

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
