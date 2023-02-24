package com.kh.cookie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCreateController
 */
@WebServlet("/cookietest.do")
public class CookieCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieCreateController() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 쿠키생성하기.
		Cookie c = new Cookie("userId","admin"); // "key" , "value"
		// 쿠키객체 생성시 저장할 key , value값을 생성자의 매개변수로 넣음.
		
		c.setMaxAge(24*60*60); // 1일 -> 24(시간)*60(분)*60(초)
		
		// 생성된 쿠키는 client에게 저장시킴.
		response.addCookie(c);
		
		Cookie c2 = new Cookie("email","song7054@naver.com"); // 이메일 정보.
		c2.setMaxAge(60*2); // 2분
		
		response.addCookie(c2);
		
		request.getRequestDispatcher("views/responsePage.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
