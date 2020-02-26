package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import entity.Room;
/*
 * 使用Java来操作对象
 * 
 * */
public class JSONTest {
    public static void main(String[] args) {
        Room room1 =new Room(1,"ssssss",8,6);
        Room room2 =new Room(2,"hhhhhh",6,6);

//        key:value
        //    前端需要的数据，用来显示房间，对象这个东西是不能在请求和
//        响应的模型中传递的，只能传递字符串
//        将room1和room2转成字符串----后台可以将字符串传递给客户端
        String room1Str= JSON.toJSONString(room1);
        String room2Str= JSON.toJSONString(room2);
        System.out.println(room1);
        System.out.println(room1Str);

        //直接构建JSON，不想自己去写{}:[]
//        创建一个JSON对象
        JSONObject jobj =new JSONObject();
        jobj.put("room",3);
        jobj.put("roomName","kkk");
        jobj.put("maxNum",8);
        jobj.put("readyNum",6);
        System.out.println(jobj.toString());
        //将符合JSON格式的字符串转成对象------客户端发送JSON数据给服务器
        String str=room1Str;
        JSONObject obj=JSON.parseObject(str);
        System.out.println(obj.getString("roomName"));
    }
}
