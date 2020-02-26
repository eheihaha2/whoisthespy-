package socket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSONObject;

@ServerEndpoint("/socketServer/{username}")
public class socketServer {
	private Session session;
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("��������");
		this.session=session;
	}
	@OnMessage
	public void onMessage(String message,@PathParam(value="username")String name) {
		System.out.println("�յ���Ϣ��"+name+"����Ϣ:"+message);
		
		JSONObject returnObject =new JSONObject();
		returnObject.put("head","send");
		
		JSONObject obj =new JSONObject();
		obj.put("username",name);
		obj.put("msg",message);
		returnObject.put("data",obj);
		
		this.session.getAsyncRemote().sendText(returnObject.toJSONString());
	}
	@OnClose
	public void onClose() {
		System.out.println("��������");
	}
	@OnError
	public void onError(Throwable t) {
	System.out.println("���ӳ���:"+t);
}
}
