package entity;
import java.util.List;
public class Room{
    private int roomId;
    private String roomName;
    private int maxNum;
    private int readyNum;
    
    List<User> userList;

    public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Room() {
        super();
    }

    public Room(int roomId, String roomName, int maxNum, int readyNum) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.maxNum = maxNum;
        this.readyNum = readyNum;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getReadyNum() {
        return readyNum;
    }

    public void setReadyNum(int readyNum) {
        this.readyNum = readyNum;
    }
}