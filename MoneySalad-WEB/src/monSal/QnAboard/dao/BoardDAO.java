package monSal.QnAboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import monSal.QnAboard.vo.BoardFileVO;
import monSal.QnAboard.vo.BoardVO;
import util.ConnectionFactory;
import util.JDBCClose;

public class BoardDAO {

	public List<BoardVO> selectAllBoard() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		List<BoardVO> boardList = new ArrayList<BoardVO>();

		try {

			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("select board_no, title, id, reg_date ");
			sql.append(" from t_qna_board ");
			sql.append(" order by board_no");

			pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				BoardVO boardVO = new BoardVO();

				String boardNo = rs.getString("board_no");
				String title = rs.getString("title");
				String id = rs.getString("id");
				String regDate = rs.getString("reg_date");

				boardVO.setBoardNo(boardNo);
				boardVO.setTitle(title);
				boardVO.setId(id);
				boardVO.setRegDate(regDate);

				boardList.add(boardVO);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			JDBCClose.close(conn, pstmt);

		}

		return boardList;
	}

	public BoardVO selectBoard(String no) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		BoardVO boardVO = new BoardVO();

		try {

			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("select board_no, title, content, id, view_cnt, reg_date ");
			sql.append(" from t_qna_board ");
			sql.append(" where board_no = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, no);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String boardNo = rs.getString("board_no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				int viewCnt = rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");

				boardVO.setBoardNo(boardNo);
				boardVO.setTitle(title);
				boardVO.setContent(content);
				boardVO.setId(id);
				boardVO.setViewCnt(viewCnt);
				boardVO.setRegDate(regDate);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			JDBCClose.close(conn, pstmt);

		}

		return boardVO;
	}

	public void incrementViewCnt(String no) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append("update t_qna_board set view_cnt = view_cnt + 1 where board_no = ?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, no);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);

		}

	}
	
	
	public String selectBoardNo() {

		String sql = "Select seq_t_board_no.nextval from dual";

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();

			return rs.getString(1);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "0";

	}
	
	public void insertBoard(BoardVO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append("insert into t_qna_board(board_no, title, id, content) ");
			sql.append("	values(?, ?, ?, ?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getBoardNo());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getId());
			pstmt.setString(4, board.getContent());
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
	
	
	public void insertFile(BoardFileVO fileVO) {

		StringBuilder sql = new StringBuilder();

		sql.append(" insert into t_qna_board_file(file_no,board_no,file_ori_name,file_save_name,file_size) ");
		sql.append(" values(seq_t_qna_board_file_file_no.nextval, ?, ?, ?, ?) ");

		try (

				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			pstmt.setString(1, fileVO.getBoardNo());
			pstmt.setString(2, fileVO.getFileOriName());
			pstmt.setString(3, fileVO.getFileSaveName());
			pstmt.setInt(4, fileVO.getFileSize());

			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	
	public List<BoardFileVO> selectFileByNo(String boardNo) {
		
		List<BoardFileVO> fileList = new ArrayList<BoardFileVO>();
		
		StringBuilder sql = new StringBuilder();

		sql.append(" select file_no, file_ori_name, file_save_name, file_size ");
		sql.append(" from t_qna_board_file ");
		sql.append(" where board_no = ? ");

		try (

				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			pstmt.setString(1, boardNo);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				BoardFileVO fileVO = new BoardFileVO();
				
				String no = rs.getString(1);
				String fileOriName = rs.getString(2);
				String fileSaveName = rs.getString(3);
				int fileSize = rs.getInt(4);
				
				fileVO.setNo(no);
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
				
				
				fileList.add(fileVO);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return fileList;
	}
	
	
	
	public BoardFileVO selectFileByFileNo(String fileNo) {
		
		BoardFileVO fileVO = new BoardFileVO();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select board_no, file_ori_name, file_save_name, file_size ");
		sql.append(" from t_qna_board_file ");
		sql.append(" where file_no = ? ");
		
		try (
				
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				) {
			pstmt.setString(1, fileNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				String boardNo = rs.getString(1);
				String fileOriName = rs.getString(2);
				String fileSaveName = rs.getString(3);
				int fileSize = rs.getInt(4);
				
				fileVO.setNo(boardNo);
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return fileVO;
	}
	
	
	public void editBoard(String boardNo, BoardVO board) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append("update t_qna_board set title = ?, content = ? where board_no = ?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, boardNo);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);

		}
	}

	
	
	
}
