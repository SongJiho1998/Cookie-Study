package com.kh.cookie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkCookie.do")
public class CheckCookieController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   
    public CheckCookieController() {
        super();
    }

    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //client가 보낸 cookie 값 확인하기
      //cookie값은 request객체의 getCookies()메소드를 이용
      //getCookies()반환형은 Cookie[]임 (서버에 저장되는 쿠기값이 한개가 아니기때문에)
      
      Cookie[] cookies = request.getCookies(); // 저장된 쿠키값이 없는 경우에 null값이 반환됨
      
      if(cookies != null) {
         
         for( Cookie c : cookies ) {
            // Cookie값을 확인하려면 getName(), getValue()
            System.out.println("키 : "+c.getName()+", 값 : "+c.getValue());
         }
      }   
      request.getRequestDispatcher("views/responsePage.jsp").forward(request, response);
   
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}