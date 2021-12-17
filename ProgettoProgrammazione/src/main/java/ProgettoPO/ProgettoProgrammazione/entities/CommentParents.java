package ProgettoPO.ProgettoProgrammazione.entities;

public class CommentParents {
	
	String CreatedTime;
	String FromName;
	String FromId;
	String Message;
	String Id;
	
	public CommentParents(String CreatedTime,String FromName,String FromId,String Message,String Id) {
		this.CreatedTime=CreatedTime;
		this.FromName=FromName;
		this.FromId=FromId;
		this.Message=Message;
		this.Id=Id;
	}

	public String getCreatedTime() {
		return CreatedTime;
	}

	public void setCreatedTime(String createdTime) {
		CreatedTime = createdTime;
	}

	public String getFromName() {
		return FromName;
	}

	public void setFromName(String fromName) {
		FromName = fromName;
	}

	public String getFromId() {
		return FromId;
	}

	public void setFromId(String fromId) {
		FromId = fromId;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
}


