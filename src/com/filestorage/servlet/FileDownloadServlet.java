package com.filestorage.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/FileDownloadServlet")


public class FileDownloadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Directory where files are stored, it's relative to the web application directory.
	 */
	private static final String UPLOAD_DIR ="uploads";
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String fileName = request.getParameter("file_name");
		OutputStream out = response.getOutputStream();
		
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Disposition", "attachment; file_name");
		
		// gets absolute path of the web application
		String applicationPath = request.getServletContext().getRealPath("");
 		// constructs path of the directory for uploaded files
 		String uploadedFilePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
		

		FileInputStream in = new FileInputStream(uploadedFilePath + fileName);
		byte[] buffer = new byte[4096];
		int length;
		while ((length = in.read(buffer)) > 0){
		    out.write(buffer, 0, length);
		}
		in.close();
		out.flush();

	}


}
