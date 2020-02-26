package servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import entity.Player;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request);
	    String userNa=request.getParameter("username");
	    String passWo=request.getParameter("password");
	    System.out.println(userNa);
		System.out.println(passWo);
		Player play1=new Player("S01","111111");
		Player play2=new Player("S02","222222");
		Player play3=new Player("S03","333333");
		List<Player> userList=new ArrayList<>();
		userList.add(play1);
		userList.add(play2);
		userList.add(play3);
		JSONObject json=new JSONObject();
		for(int i=0;i<userList.size();i++) {
			if(userList.get(i).getUsername().equals(userNa)&userList.get(i).getPassword().equals(passWo)) {
					json.put("result","true");
					System.out.println(json);
					break;
			}
			else {
				json.put("result","false");
				System.out.println(json);
			}
		}
		// ��Ӧ��
		PrintWriter out =response.getWriter();
		out.println(JSON.toJSONString(json));
		out.flush();
		out.close();
	}
}
