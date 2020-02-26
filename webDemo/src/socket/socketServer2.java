package socket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/*
 * Ҫ�ܵ����пͻ���
 * 
 * */
@ServerEndpoint("/chat/{username}")
public class socketServer2 {
	private Session session;
	private String username;
	//��ǰ����˵����пͻ��ˣ��û�������ǰ�û���webSocket����
	private static Map<String, socketServer2> clients=new ConcurrentHashMap<String, socketServer2>();
	@OnOpen
	public void onOpen(Session session,@PathParam(value="username")String name) {
		System.out.println("��������");
		this.username=name;
		this.session=session;
		//��ÿ�������ӽ���������clients���������Ӷ���һ�Զ�
		clients.put(username,this);
		//put(������,����)
		//Ⱥ��������Ϣ���û��б���Ϣ
		onLine();
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		userList();
	}
	@OnMessage
	public void onMessage(String message){
	//�����յ���message��Ⱥ���յ�����Ϣ��Ⱥ������˽��
		JSONObject obj=JSON.parseObject(message);//���յ����ַ���ת��JSON
		String head=obj.getString("head");
		String data=obj.getString("data");
		if(head.equals("sendAll")) {
			sendAll(data);
		}else if(head.equals("sendTo")) {
			sendTo(data);
		}
	}
	@OnClose
	public void onClose() {
		System.out.println("��������");
	}
	@OnError
	public void onError(Throwable t) {
	System.out.println("���ӳ���:"+t);	
	}
	
	//�������˻���4�������������ֲ���
	//��������Ⱥ����Ϣ
	//{from:����˭,msg:��Ϣ����}
	public void sendAll(String data) {
		//���յ�����ϢȺ����ȥ
		//Message msg=new Message();
		JSONObject json=new JSONObject();
		json.put("head","sendAll");
		JSONObject datajson=new JSONObject();
		datajson.put("from",this.username);
		datajson.put("msg",data);
		json.put("data",datajson);
		System.out.println(json);
		for(socketServer2 socket:clients.values()) {
			socket.session.getAsyncRemote().sendText(json.toJSONString());
		}
	};
	//��������˽����Ϣ
	//{from:����˭,msg:��Ϣ����}
	public void sendTo(String data) {
	JSONObject dataJson=JSON.parseObject(data);
	String to =dataJson.getString("to");
	String msg=dataJson.getString("msg");
	
	JSONObject json=new JSONObject();
	json.put("head","sendTo");
	
	JSONObject injson=new JSONObject();
	injson.put("from",this.username);
	injson.put("msg",msg);
	System.out.println(injson);
	json.put("data",injson);
	
	for(socketServer2 socket:clients.values()) {
		if(socket.username.equals(to)) {
			socket.session.getAsyncRemote().sendText(json.toJSONString());
		}
	}
		
	};
	//��������Ⱥ��������Ϣ
	//{name:����������}
	public void onLine() {
		JSONObject json=new JSONObject();
		json.put("head","onLine");
		JSONObject datajson=new JSONObject();
		System.out.println(this.username);
		datajson.put("name",this.username);
		json.put("data",datajson);
		System.out.println(json);
		for(socketServer2 socket:clients.values()) {
			socket.session.getAsyncRemote().sendText(json.toJSONString());
		}
	};
	//��������Ⱥ���û��б���Ϣ
	//[�û�1,�û�2]
	public void userList() {
		JSONObject json=new JSONObject();
		json.put("head","userList");
		json.put("data",JSON.toJSONString(clients.keySet()));
		System.out.println(JSON.toJSONString(clients.keySet()));
		System.out.println(json);
		for(socketServer2 socket:clients.values()) {
			socket.session.getAsyncRemote().sendText(json.toJSONString());
		}
	};
}