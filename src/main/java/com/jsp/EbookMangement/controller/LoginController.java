package com.jsp.EbookMangement.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.EbookMangement.entity.User;
import com.jsp.EbookMangement.service.UserService;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@SuppressWarnings("serial")
@WebServlet(value = "/login")
public class LoginController extends HttpServlet {

	UserService service = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
				User user = new User();
				user.setName("Admin");

				session.setAttribute("userobj", user);

				resp.sendRedirect("admin/home.jsp");
			} else {

				User user = service.userLoginDaoByEmailDService(email, password);

				if (user.getEmail() != null && user.getPassword() != null) {

					session.setAttribute("userobj", user);

					// Email details from request or hardcoded
					String to = email; // receiver
					String subject = "Test Email from Servlet";
					String messageText = "Welcome To Online Book Store Management "
							+ "Subject: Welcome to [Your Website Name] – Your Book Adventure Starts Here!\n"
							+ "\n"
							+ "Hi [User's First Name],\n"
							+ "\n"
							+ "Welcome to [Your Website Name], your go-to destination for buying and selling new and pre-loved books!\n"
							+ "\n"
							+ "We’re thrilled to have you join our community of book lovers. Whether you're here to discover your next great read or give your old books a new home, we've got you covered.\n"
							+ "\n"
							+ "Here's what you can do next:\n"
							+ "\n"
							+ "Browse thousands of books across all genres\n"
							+ "\n"
							+ "Sell your books easily with just a few clicks\n"
							+ "\n"
							+ "Track your orders and manage listings from your dashboard\n"
							+ "\n"
							+ "";
					
					

					// SMTP configuration
					String host = "smtp.gmail.com";
					final String username = "shivamvarshney504@gmail.com";
					final String userpassword = "nfyrexivltgkojzh"; // use app-specific password

					Properties props = new Properties();
					props.put("mail.smtp.host", host);
					props.put("mail.smtp.port", "587");
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");

					// Create Session
					Session session1 = Session.getInstance(props, new Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, userpassword);
						}
					});

					try {
						// Compose message
						MimeMessage message = new MimeMessage(session1);
						message.setFrom(new InternetAddress(username));
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
						message.setSubject(subject);
						message.setText(messageText);

						// Send message
						Transport.send(message);

						// out.println("<h3>Email Sent Successfully!</h3>");
					} catch (MessagingException e) {
						e.printStackTrace();
						// out.println("<h3>Error Sending Email: " + e.getMessage() + "</h3>");
					}

					resp.sendRedirect("index.jsp");
				} else {
					session.setAttribute("faildMsg", "Please Enter Valid Email & Password");
					resp.sendRedirect("login.jsp");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}