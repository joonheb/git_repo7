package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.dao.MemberDAO;

@Controller
public class LoginController {

	@RequestMapping(value="/member/login.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// 2. DB
		MemberDAO memberDAO = new MemberDAO();
		String name = memberDAO.login(id, pwd);
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// 화면 이동
		if(name == null) {
			modelAndView.setViewName("loginForm.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);
			modelAndView.setViewName("redirect:../board/boardList.do?pg=1");
			// redirect를 붙이지 않으면 forward 방식으로 실행됨
		}
		return modelAndView;
		/*
		// 화면 이동
		if (name == null) {
			// response.sendRedirect("loginForm.jsp");
			// viewPage = "../member/loginForm.jsp";
			return "loginForm";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);
			// response.sendRedirect("../board/boardList.do?pg=1");
			// viewPage = "../board/boardList.do?pg=1";
			return "../board/boardList.do?pg=1";
		}
		*/
	}
}