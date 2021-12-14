package ProgettoPO.ProgettoProgrammazione.entities;


public class Comment {
	
	//contiene i parametri della chiamata a message tags
		String messageTagsTag;
		String messageTagsName;
		String messageTagsType;
		int messageTagsLenght;
		
		//contiene i parametri della chiamata parent
		int parentCreatedTime;
		String parentFromName;
		String parentFromId;
		String parentMessage;
		String parentId;
		
		//contiene i parametri della chiamata attachments
		String attachmentsDescription;
		String attachmentsTarget;
		String attachmentsType;
		String attachmentsUrl;
		String attachmentsTytle;
		
		//contiene tutti i parametri singoli corrispondenti alle chiamate
		String message;
		String createdTime;
		long id;
		String permalinkUrl;
		boolean canComment;
		boolean canLike;		
		boolean userLikes;
		int commentCount;
		int likeCount;
		
		
		public Comment (long id, String createdTime, String message) {
			this.id = id;
			this.createdTime = createdTime;
			this.message = message;
		}
		
		//contiene tutti i return delle chiamate singole
		public String getMessage(){return message;}
		public String getCreatedTime(){return createdTime;}
		public long getId(){return id;}
		public String getPermalinkUrl(){return permalinkUrl;}
		public boolean getCanComment(){return canComment;}
		public boolean getCanLike(){return canLike;}
		public boolean getUserLikes(){return userLikes;}
		public int getCommentCount(){return commentCount;}
		public int getLikeCount(){return likeCount;}
		
		//contiene i return della chiamataMessageTags
		public String getMessageTagsTag() {return messageTagsTag;}
		public String getMessageTagsName() {return messageTagsName;}
		public String getMessageTagsType() {return messageTagsType;}
		public int getMessageTagsLenght() {return messageTagsLenght;}

		//contiene i return della chiamata parent
		public String getParentFromName() {return parentFromName;}
		public String getparentFromId() {return parentFromId;}
		public String getparentMessage() {return parentMessage;}
		public String getparentId() {return parentMessage;}
		public int getParentCreatedTime() {return parentCreatedTime;}
		
		//contiene i return della chiamata Attachments
		public String getAttachmentsDescription() {return attachmentsDescription;}
		public String getAttachmentsTarget() {return attachmentsTarget;}
		public String getAttachmentsType() {return attachmentsType;}
		public String getAttachmentsUrl() {return attachmentsUrl;}
		public String getAttachmentsTytle() {return attachmentsTytle;}
		
		//setta i parametri della chiamata MessageTags
		public void setMessageTags(String messageTagsTag,String messageTagsName,String messageTagsType,int messageTagsLenght)
		{
			this.messageTagsTag=messageTagsTag;
			this.messageTagsName=messageTagsName;
			this.messageTagsType=messageTagsType;
			this.messageTagsLenght=messageTagsLenght;
		}
		
		//setta i parametri della chiamata parent
		public void setParent(int parentCreatedTime,String parentFromName,String parentFromId,String parentMessage,String parentId)
		{
			this.parentCreatedTime=parentCreatedTime;
			this.parentFromName=parentFromName;
			this.parentFromId=parentFromId;
			this.parentMessage=parentMessage;
			this.parentId=parentId;
		}
		
		//setta i parametri della chiamata Attachments
		public void setAttachments(String attachmentsDescription,String attachmentsTarget,String attachmentsType,String attachmentsUrl,String attachmentsTytle)
		{
			this.attachmentsDescription=attachmentsDescription;
			this.attachmentsTarget=attachmentsTarget;
			this.attachmentsType=attachmentsType;
			this.attachmentsTytle=attachmentsTytle;
			this.attachmentsUrl=attachmentsUrl;
		}
		

}
