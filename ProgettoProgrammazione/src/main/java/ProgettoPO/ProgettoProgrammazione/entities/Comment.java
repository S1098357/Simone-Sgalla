package ProgettoPO.ProgettoProgrammazione.entities;

import org.json.simple.JSONObject;

public class Comment {
	
	static boolean Parent = false;
	//contiene tutti i parametri singoli corrispondenti alle chiamate
	        String id;
	        String message;
			String createdTime;
			String permalinkUrl;
			boolean canComment;
			boolean canLike;		
			boolean userLikes;
			int commentCount;
			int likeCount;
		
		//contiene i parametri della chiamata parent
		String parentCreatedTime;
		String parentFromName;
		String parentFromId;
		String parentMessage;
		String parentId;
		
		
		
		public Comment (JSONObject commento) {
			if (commento.get("parent")!=null) {
				JSONObject parent = (JSONObject) commento.get("parent");
				this.parentCreatedTime = (String)parent.get("createdTime");
				JSONObject parentFrom = (JSONObject) parent.get("parent");
				this.parentFromName = (String) parentFrom.get("name");
				this.parentFromId = (String)parentFrom.get("id");
				this.parentMessage = (String) parent.get("message");
				this.parentId = (String) parent.get("id");
				Parent=true;
			}
			this.id = (String) commento.get("id");
			this.message = (String) commento.get("message");
			this.createdTime = (String) commento.get("createdTime");
			this.permalinkUrl = (String) commento.get("permalinkUrl");
			this.canComment = (Boolean) commento.get("canComment");
			this.canLike = (Boolean) commento.get("canLike");
			this.userLikes = (Boolean) commento.get("userLikes");
			this.commentCount = (Integer) commento.get("commentCount");
			this.likeCount = (Integer) commento.get("likeCount");
			
		};
		
		
		//contiene tutti i return delle chiamate singole
		public String getMessage(){return message;}
		public String getCreatedTime(){return createdTime;}
		public String getId(){return id;}
		public String getPermalinkUrl(){return permalinkUrl;}
		public boolean getCanComment(){return canComment;}
		public boolean getCanLike(){return canLike;}
		public boolean getUserLikes(){return userLikes;}
		public int getCommentCount(){return commentCount;}
		public int getLikeCount(){return likeCount;}
		

		//contiene i return della chiamata parent
		public String getParentFromName() {return parentFromName;}
		public String getparentFromId() {return parentFromId;}
		public String getparentMessage() {return parentMessage;}
		public String getparentId() {return parentMessage;}
		public String getParentCreatedTime() {return parentCreatedTime;}
		
		
		//setta i parametri della chiamata parent
		public void setParent(String parentCreatedTime,String parentFromName,String parentFromId,String parentMessage,String parentId)
		{
			this.parentCreatedTime=parentCreatedTime;
			this.parentFromName=parentFromName;
			this.parentFromId=parentFromId;
			this.parentMessage=parentMessage;
			this.parentId=parentId;
		}
		

}
