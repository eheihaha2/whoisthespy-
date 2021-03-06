package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.Room;
import entity.User;


@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RoomServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		
		   Room room1 =new Room(1,"ssssss",8,6);
		   Room room2 =new Room(2,"hhhhhh",6,6);
		   Room room3 =new Room(3,"kkkkkk",6,4);
		   Room room4 =new Room(4,"jjjjjj",7,3);
		   Room room5 =new Room(5,"bbbbbb",8,2);
		   Room room6 =new Room(6,"xxxxxx",6,1);
		   
		   User user1 =new User(3,"dong","青铜");
		   User user2 =new User(2,"huang","黄金");
		   User user3 =new User(4,"li","钻石");
		   User user4 =new User(6,"xing","星耀");
		   User user5 =new User(8,"zheng","铂金");
		   User user6 =new User(5,"hao","王者");
		   User user7 =new User(10,"cai","青铜");
		   User user8 =new User(12,"xu","黄金");
		   User user9 =new User(20,"lie","钻石");
		   User user10 =new User(29,"hu","星耀");
		   User user11 =new User(21,"zhu","铂金");
		   User user12 =new User(30,"yu","王者");
		   User user13 =new User(14,"chen","黄金");
		   User user14 =new User(22,"liu","钻石");
		   User user15 =new User(13,"lin","星耀");
		   User user16 =new User(50,"zhong","铂金");
		   User user17 =new User(32,"lu","王者");
		   User user18 =new User(25,"feng","铂金");
		   User user19 =new User(72,"meng","王者");
		   User user20 =new User(56,"zeng","铂金");
		   User user21 =new User(76,"zhou","王者");
		   User user22 =new User(88,"de","王者");
		   User user23 =new User(97,"wang","黄金");
		   User user24 =new User(45,"miao","钻石");

		   
		   List<User> userList1=new ArrayList<User>();
		   userList1.add(user1);
		   userList1.add(user2);
		   userList1.add(user3);
		   userList1.add(user4);
		   userList1.add(user5);
		   userList1.add(user6);
		   List<User> userList2 =new ArrayList<User>();
		   userList2.add(user13);
		   userList2.add(user17);
		   userList2.add(user14);
		   userList2.add(user10);
		   userList2.add(user7);
		   userList2.add(user9);
		   List<User> userList3=new ArrayList<User>();
		   userList3.add(user15);
		   userList3.add(user8);
		   userList3.add(user16);
		   userList3.add(user12);
		   List<User> userList4=new ArrayList<User>();
		   userList4.add(user20);
		   userList4.add(user24);
		   userList4.add(user18);
		   List<User> userList5=new ArrayList<User>();
		   userList5.add(user22);
		   userList5.add(user19);
		   List<User> userList6=new ArrayList<User>();
		   userList6.add(user23);
		   userList6.add(user21);
		   room1.setUserList(userList1);
		   room2.setUserList(userList2);
		   room3.setUserList(userList3);
		   room4.setUserList(userList4);
		   room5.setUserList(userList5);
		   room6.setUserList(userList6);
		   
		   List<Room> roomList = new ArrayList<Room>();
		   roomList.add(room1);
		   roomList.add(room2);
		   roomList.add(room3);
		   roomList.add(room4);
		   roomList.add(room5);
		   roomList.add(room6);
		   
		   String roomStr=JSON.toJSONString(roomList);
		   //System.out.println(roomStr);
		
		// 响应回
		 PrintWriter out =response.getWriter();
		 out.println(roomStr);
		 out.flush();
		 out.close();
	}

}
