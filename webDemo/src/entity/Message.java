package entity;
/*����һ������ǰ��̨���ݽ����Ķ���
 * 
 * */
public class Message {
	private String head;//�������ֵ�ǰ��Ϣ���������͵���Ϣ
	private String data;//�������������ݱ���
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
