package test;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import entity.Room;
import entity.User;
public class RoomTest {
   public static void main(String[]args) {
   Room room1 =new Room(1,"ssssss",8,6);
   Room room2 =new Room(2,"hhhhhh",6,6);
   
   User user1 =new User(3,"dong","青铜");
   User user2 =new User(2,"huang","黄金");
   User user3 =new User(4,"li","钻石");
   User user4 =new User(1,"xing","星耀");
   User user5 =new User(1,"zheng","铂金");
   User user6 =new User(5,"hao","王者");
   
   List<User> userList1=new ArrayList<User>();
   userList1.add(user1);
   userList1.add(user2);
   userList1.add(user3);
   List<User> userList2 =new ArrayList<User>();
   userList2.add(user4);
   userList2.add(user5);
   userList2.add(user6);
   room1.setUserList(userList1);
   room2.setUserList(userList2);
   
   List<Room> roomList = new ArrayList<Room>();
   roomList.add(room1);
   roomList.add(room2);
   
   String roomStr=JSON.toJSONString(roomList);
   System.out.println(roomStr);
   }  
}
