package com.kitri.control.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MultipartRequest mr = new MultipartRequest(request, "D:\\javaData\\fileupload");
		MultipartRequest mr;
		int maxPostSize = 100 * 1024;
		String saveDirectory = "D:\\javaData\\fileupload";
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
		String a = mr.getParameter("a");
		File f1 = mr.getFile("f1");
		for(File file : f1.listFiles()) {
			System.out.println(file.getName());
		}
		System.out.println("a=" + a);
		System.out.println("fileName=" + f1.getName());
		String path = "/upload/uploadresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
