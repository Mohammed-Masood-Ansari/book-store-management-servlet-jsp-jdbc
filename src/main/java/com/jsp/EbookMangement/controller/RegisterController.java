package com.jsp.EbookMangement.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.EbookMangement.entity.User;
import com.jsp.EbookMangement.service.UserService;

@WebServlet(value = "/register")
public class RegisterController extends HttpServlet {

	UserService service = new UserService();
	
	public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String name = req.getParameter("name");
			String email = req.getParameter("email");
			long phno = Long.parseLong(req.getParameter("phno"));
			String password = req.getParameter("password");
			String check = req.getParameter("check");

			User user = new User();

			user.setName(name);
			user.setEmail(email);
			user.setPhno(phno);
			user.setPassword(password);
			HttpSession session = req.getSession();

			if (check != null) {

				boolean f2 = service.checkUser(email);

				if (f2) {
					
					if(phno >= 1000000000 && phno <= 9999999999l) {
						
						if(isValidPassword(password)) {
							service.saveUserService(user);
							session.setAttribute("succMsg", "Registration Successfully...");
							resp.sendRedirect("register.jsp");
						}else {
							session.setAttribute("failedMsg", "password length should be 8 to 15 and it should be strong");
							resp.sendRedirect("register.jsp");
						}
					
					}else {
						session.setAttribute("failedMsg", "pass your phon number with 10 digit only...");
						resp.sendRedirect("register.jsp");

					}
					
				} else {
					session.setAttribute("failedMsg", "User Alerady exits Try another emaiId...");
					resp.sendRedirect("register.jsp");

				}

			} else {
				session.setAttribute("failedMsg", "Please Check Agree Terms & Condition");
				resp.sendRedirect("register.jsp");
			}
			

		} catch (Exception e) {
			// TODO: handle exception

		}

	}

}
