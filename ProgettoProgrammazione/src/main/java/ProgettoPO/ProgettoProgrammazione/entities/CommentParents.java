package ProgettoPO.ProgettoProgrammazione.entities;

/**
 * Classe di commenti a parte. Serve per gestire le risposte ad un commento (sottocommenti) e tutti i loro attributi
 */

public class CommentParents {

	//Attributi di CommentParents
	String CreatedTime;
	String FromName;
	String FromId;
	String Message;
	String Id;
	
	/**
	 * Costruttore di CommentParents. Serve per assegnare i valori degli attributi del sottocommento.
	 * Questo processo avviene nel costruttore di Comment.
	 * @param CreatedTime
	 * @param FromName
	 * @param FromId
	 * @param Message
	 * @param Id
	 */
	
	public CommentParents(String CreatedTime,String FromName,String FromId,String Message,String Id) {
		this.CreatedTime=CreatedTime;
		this.FromName=FromName;
		this.FromId=FromId;
		this.Message=Message;
		this.Id=Id;
	}

	//Metodi get e set autogenerati della classe CommentParents
	public String getCreatedTime() {return CreatedTime;}

	public void setCreatedTime(String createdTime) {CreatedTime = createdTime;}

	public String getFromName() {return FromName;}

	public void setFromName(String fromName) {FromName = fromName;}

	public String getFromId() {return FromId;}

	public void setFromId(String fromId) {FromId = fromId;}

	public String getMessage() {return Message;}

	public void setMessage(String message) {Message = message;}

	public String getId() {return Id;}

	public void setId(String id) {Id = id;}

}


