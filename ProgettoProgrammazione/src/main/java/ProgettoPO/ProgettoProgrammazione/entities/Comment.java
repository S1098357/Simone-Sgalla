package ProgettoPO.ProgettoProgrammazione.entities;

import org.json.simple.JSONObject;
/**
 * Classe che definisce l'entità da noi considerata. Contiene tutti gli attributi di un commento
 */

public class Comment {
		
		//Attributi di un commento
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
		
		//Costruttore vuoto che verrà utilizzato in seguito
		public Comment () {};
		
		/**
		 * Costruttore che prende come argomento un JSONObject. Questo ci servirà per prendere i dati direttamente dall'Api
		 * e manipolarli. All'interno del costruttore sono definiti altri due JSONObject (all'interno dell'if) che serviranno 
		 * uno per considerare anche le risposte ai commenti (come dei sottocommenti) e l'altro tutti i dati relativi al sottocommento.
		 * @param commento JSONObject commento, oggetto da cui vengo prese le informazioni in Json
		 */
		
		public Comment (JSONObject commento) {
			super();
			if (commento.get("parent")!=null) {
				JSONObject parent = (JSONObject) commento.get("parent");
				JSONObject parentFrom = (JSONObject) parent.get("from");
				this.parent=new CommentParents((String)parent.get("created_time"),(String) parentFrom.get("name"),(String)parentFrom.get("id"),(String) parent.get("message"),(String) parent.get("id"));
			}
			this.id = (String) commento.get("id");
			this.message = (String) commento.get("message");
			if(commento.get("from")!=null) {
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
		
		
		//Metodi get di un commento (necessari per visualizzare a schermo le informazioni relative ad un commento)
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
		
		
}



