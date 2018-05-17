package github;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		perform(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		perform(req, resp);
	}

	protected void perform(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String repos_name = req.getParameter("repos_name");

		Topic1 topic = new Topic1();
		topic.setRepos_name(repos_name);

		req.setAttribute("topic", topic);
		req.getRequestDispatcher("github.jsp").forward(req, resp);
	}
}
