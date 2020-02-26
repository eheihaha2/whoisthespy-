package entity;
/*这是一个代表前后台数据交互的对象
 * 
 * */
public class Message {
	private String head;//用于区分当前消息是哪种类型的消息
	private String data;//用于真正的数据本身
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(String head, String data) {
		super();
		this.head = head;
		this.data = data;
	}
	
}
