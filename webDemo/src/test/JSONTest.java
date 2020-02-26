package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import entity.Room;
/*
 * ʹ��Java����������
 * 
 * */
public class JSONTest {
    public static void main(String[] args) {
        Room room1 =new Room(1,"ssssss",8,6);
        Room room2 =new Room(2,"hhhhhh",6,6);

//        key:value
        //    ǰ����Ҫ�����ݣ�������ʾ���䣬������������ǲ����������
//        ��Ӧ��ģ���д��ݵģ�ֻ�ܴ����ַ���
//        ��room1��room2ת���ַ���----��̨���Խ��ַ������ݸ��ͻ���
        String room1Str= JSON.toJSONString(room1);
        String room2Str= JSON.toJSONString(room2);
        System.out.println(room1);
        System.out.println(room1Str);

        //ֱ�ӹ���JSON�������Լ�ȥд{}:[]
//        ����һ��JSON����
        JSONObject jobj =new JSONObject();
        jobj.put("room",3);
        jobj.put("roomName","kkk");
        jobj.put("maxNum",8);
        jobj.put("readyNum",6);
        System.out.println(jobj.toString());
        //������JSON��ʽ���ַ���ת�ɶ���------�ͻ��˷���JSON���ݸ�������
        String str=room1Str;
        JSONObject obj=JSON.parseObject(str);
        System.out.println(obj.getString("roomName"));
    }
}
