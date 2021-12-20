package ProgettoPO.ProgettoProgrammazione.entities;

import org.json.simple.JSONObject;

public class Comment extends CommentMethods {
	
	
	static boolean Parent = false;
	//contiene tutti i parametri singoli corrispondenti alle chiamate
	        String id;
	        String message;
			String createdTime;
			String permalinkUrl;
			Boolean canComment;
			Boolean canLike;		
			Boolean userLikes;
			Long commentCount;
			Long likeCount;
			CommentParents parent;
			String from;
		
		public Comment () {};
		
		public Comment (JSONObject commento) {
			super();
				if (commento.get("parent")!=null) {
				JSONObject parent = (JSONObject) commento.get("parent");
				JSONObject parentFrom = (JSONObject) parent.get("from");
				this.parent=new CommentParents((String)parent.get("created_time"),(String) parentFrom.get("name"),(String)parentFrom.get("id"),(String) parent.get("message"),(String) parent.get("id"));
				Parent=true;
			}
			this.id = (String) commento.get("id");
			this.message = (String) commento.get("message");
			if(commento.get("from")!=null)
			{
			JSONObject prova=(JSONObject) commento.get("from");
			this.from=(String)prova.get("name");
			}
			else this.from="non accessibile";
			this.createdTime = (String) commento.get("created_time");
			this.permalinkUrl = (String) commento.get("permalink_url");
			this.canComment = (Boolean) commento.get("can_comment");
			this.canLike = (Boolean) commento.get("can_like");
			this.userLikes = (Boolean) commento.get("user_likes");
			this.commentCount = (Long) commento.get("comment_count");
			this.likeCount = (Long) commento.get("like_count");
			
		};
		
		
		//contiene tutti i return delle chiamate singole
		public String getMessage(){return message;}
		public String getCreatedTime(){return createdTime;}
		public String getId () {return id;}
		public String getPermalinkUrl(){return permalinkUrl;}
		public Boolean getCanComment(){return canComment;}
		public Boolean getCanLike(){return canLike;}
		public Boolean getUserLikes(){return userLikes;}
		public Long getCommentCount(){return commentCount;}
		public Long getLikeCount(){return likeCount;}
		public CommentParents getParent() {return parent;}
		public String getFrom() {return from;}
		

		public String retId() {return id;}
		public String retCreatedTime() {return createdTime;}
		public String retFrom() {return from;}
		public Long retLikeCount() {return likeCount;}
		public Long retCommentCount() {return commentCount;}
		
}



