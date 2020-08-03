package monSal;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardFileVO;

public class DownloadProcessController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String fileNo = request.getParameter("fileNo"); // jsp

		BoardDAO dao = new BoardDAO();

		BoardFileVO fileVO = dao.selectFileByFileNo(fileNo);
		String fileOriName = fileVO.getFileOriName();
		String fileSaveName= fileVO.getFileSaveName();

		request.setCharacterEncoding("utf-8");

		String saveFolder = "C:/Users/Na/Desktop/kopo_edu/MoneySalad/MoneySalad-WEB/WebContent/upload/"+fileSaveName;  // save 할 경로

		FileInputStream fis = new FileInputStream(saveFolder);

		String encodedName = null;
//		System.out.println(request.getHeader("User-Agent"));

		if(request.getHeader("User-Agent").contains("FireFox"))  {
			encodedName = new String(fileOriName.getBytes("utf-8"), "ISO-8859-1");
				
		} else {
			encodedName = URLEncoder.encode(fileOriName,"utf-8");
			encodedName = encodedName.replaceAll(" ", "||+");
		}

		response.setHeader("Content-Disposition", "attachment;filename="+encodedName);
		response.setHeader("Content-Transfer-Encoding","binary");

		response.setContentLengthLong(fileVO.getFileSize());

		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

		byte[] buffer = new byte[1024*1000];
		int readedByte=0;

		while(true) {
			readedByte = fis.read(buffer);
			if(readedByte==-1) break;
			
			bos.write(buffer, 0, readedByte);
			bos.flush();
		}

		bos.close();
		fis.close();




		
		return "/board/download.jsp";
	}

}
