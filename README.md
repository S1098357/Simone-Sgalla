# Progetto Programmazione ad oggetti

Lo scopo del nostro progetto è offrire all'utente una gestione dei commenti relativi ad una pagina facebook. I servizi di cui può usufruire l'utente sono: la visualizzazione di una lista contenente tutti i commenti (e le risposte ai commenti) nella pagina facebook presa in esame, la visualizzazione di tutti i post presenti nella pagina in questione, la visualizzazione di tutti i commenti relativi ad un post presente nella pagina designata dall'utente, la visualizzazione di un singolo commento scelto dall'utente, statistiche e filtri relativi ai commenti presenti nella pagina scelta.

# Applicazione

Tramite l'API di facebook for developers il programma riceve in input i dati relativi a tutti i commenti salvandone poi i campi su una lista che verrà poi visualizzata dall'utente in formato JSON. Se durante un qualsiasi processo occorre un'eccezione, dall'utente verrà visualizzata una stringa relativa all'eccezione stessa che spieghi l'errore commesso.

# Comment

COMMENT è la classe fondante della nostra applicazione, essa è infatti la classe che ci permette di immagazzinare i commenti con i relativi parametri, di svolgervi delle operazioni e di stamparli. La classe COMMENT contiene diversi campi:

1)id: questo campo è di tipo "String" ed in esso viene salvato l'id del commento, che possiamo poi utilizzare nella rotta /posts/{postId}/comments/{id} per visualizzare uno specifico commento.

2)message: questo campo è di tipo "String" ed in esso è contenuto il testo del commento.

3)createdTime:  questo campo è di tipo "String"ed in esso è contenuta la data di creazione del commento. Questa comprende giorno, mese, anno, ora, minuto e secondo esatto nel quale viene generato il commento.

4)permaLinkUrl: in questo campo è contenuto il link per accedere al commento: dal link si risale al commento e lo si visualizza in facebook.

5)canComment: questo campo è di tipo "boolean" e risulta "true" se è possibile rispondere al commento a cui questo campo appartiene e "false" in caso contrario.

6)canLike: questo campo è di tipo "boolean" e risulta "true" se l'utente può mettere mi piace al commento a cui questo campo appartiene e "false" in caso contrario.

7)userLikes: questo campo è di tipo "boolean" e risulta "true" se l'utente ha messo mi piace al commento a cui questo campo appartiene e "false" in caso contrario.

8)commentCount: questo campo è di tipo "long" e contiene il numero di risposte al commento a cui questo campo appartiene.

9)likeCount: questo campo è di tipo "long" e contiene il numero di "like" al commento a cui questo campo appartiene.

10)from: questo campo è di tipo "String" e contiene il nome dell'utente che ha creato il commento a cui questo campo appartiene (risulta non accessibile se non si può accedere al nome dell'utente per problemi di prvacy).

11)Parent: questo campo è una classe separata da COMMENT e risulta null se il commento preso in esame non è un commento di risposta ad un altro commento. In caso contrario questo ccampo contiene a sua volta 4 campi:

  11-1)parentCreatedTime: questo campo è il corrispettivo di "createdTime" ma si riferisce al campo del commento a cui questo commento risponde.
  
  11-2)parentMessage: questo campo è il corrispettivo di "message" ma si riferisce al campo del commento a cui questo commento risponde.

  11-3)parentFrom: questo campo è il corrispettivo di "from" ma si riferisce al campo del commento a cui questo commento risponde.

  11-4)parentId: questo campo è il corrispettivo di "id" ma si riferisce al campo del commento a cui questo commento risponde.
  
 Il commento visualizzato dall'utente è di questo tipo:

![Immagine2](https://user-images.githubusercontent.com/95300131/147213422-d4bbc420-560d-45e7-b86a-4bce22b6e33c.png)


# Rotte disponibili

# /comments

Quando viene avviata questa rotta il programma tramite l'API di facebook for developers accede ai dati relativi alla pagina facebook presa in esame. Questo procede poi a salvare tutti i commenti con i relativi campi all'interno di una lista di COMMENT che viene poi visualizzata dall'utente. La lista fornita da questa rotta verrà poi utilizzata anche da altre classi (per esempio è la lista utilizzata dai metodi che forniscono le statistiche).

# /posts

Quando viene avviata questa rotta il programma riceve in input il file JSON fornito dall'API di facebook for developers che verrà visualizzato dall'utente senza che il programma lo modifichi in alcun modo. Questo fa si che l'utente possa accedere ai dati richiesti per avviare le rotte più specifiche. I campi forniti dall'API sono: i messaggi contenuti nei post, l'id dei post visualizzati, il momento della creazione dei post viualizzati.

# /posts/{postId}/comments

La rotta sopracitata, quando avviata, prende in input tutti i commenti relativi al post di cui si è fornito l'id durante la chiamata e li salva all'interno di una lista di COMMENT che verrà poi visualizzata dall'utente (vengono salvati anche i commenti che rispondono ad altri commenti presenti sotto il post di cui si è fornito l'id in input).

# /posts/{postId}/comments/{id}

Questa rotta quando avviata scorre la lista di COMMENT fornita dalla rotta "/comments" e cerca il commento con un id corrispondente a quello fornito. Se lo trova l'utente visualizza poi il commento in formato JSON, mentre se non ci sono id corrspondenti a quello fornito dall'utente viene visualizzata la stringa relativa all'eccezione "CommentIdException" che spiega all'utente l'errore commesso.

# /stats/{name1}/{name2}

Questa rotta contiene tutte le statistiche effettuate dall'applicazione sui commenti. Queste si dividono in vari tipi:

1)Frequenza commenti: questa statistica fornisce all'utente un elenco di date ed ore relativo alla creazione dei commenti generati dall'utente sulla pagina presa in esame. Nel caso in cui l'utente non abbia mai commentato o nel caso in cui i suoi dati non siano accessibili, questa rotta restituisce la stringa relativa all'eccezione "invalidNameException" che verrà poi visualizzata dall'utente.

2)Media oraria: questa statistica fornisce all'utente l'orario medio in cui vengono generati i commenti sulla pagina presa in esame. Questo avviene utilizzando la lista che viene visualizzata dall'utente avviando la rotta "/comments".

3)Orario max: questa statistica fornisce all'utente l'ultimo orario della giornata in cui è stato generato un commento. Questo avviene utilizzando la lista che viene visualizzata dall'utente avviando la rotta "/comments".

4)Orario min: questa statistica fornisce all'utente il primo orario della giornata in cui è stato generato un commento. Questo avviene utilizzando la lista che viene visualizzata dall'utente avviando la rotta "/comments".

5)Media commenti al giorno: questa statistica fornisce all'utente la media dei commenti creati giornalmente. Questo avviene prendendo in esame la lista che viene visualizzata dall'utente avviando la rotta "/comments": i giorni presi in esame per calcolare la media vanno dal giorno in cui è stato generato il primo commento fino al giorno in cui è stato generato l'ultimo commento.

6)Media like per commento: questa statistica fornisce all'utente la media dei like sotto i singoli commenti. Questo avviene prendendo in esame la lista che viene visualizzata dall'utente avviando la rotta "/comments".

7)Media commenti per commento: questa statistica fornisce all'utente la media dei commenti sotto i singoli commenti. Questo avviene prendendo in esame la lista che viene visualizzata dall'utente avviando la rotta "/comments".

8)Numero commenti per utente: questa statistica fornisce all'utente il numero di commenti generati dal profilo facebook "name2". Questo avviene prendendo in esame la lista che viene visualizzata dall'utente avviando la rotta "/comments". Nel caso in cui non vi sia alcun commento generato dal profilo "name2", l'utente visualizza la stringa relativa all'errore "invalidNameException" che spiega l'errore commesso.

# /filters/{date}/{hour}/{name}

Questa rotta contiene tutti i filtri effettuati dall'applicazione sui commenti. Questi si suddividono in:

1)Filtro giorni: questo metodo utilizza l'input fornito dall'utente "date" e crea una lista che contiene tutti i commenti creati nella data scelta. Questo avviene utilizzando la lista che viene visualizzata dall'utente avviando la rotta "/comments". Nel caso in cui durante questo processo occorrano delle eccezioni l'utente visualizzerà la stringa relativa all'eccezione "InvalidDateException" che gli permetterà di capire l'errore commesso. Se l'utente dovesse inserire una stringa al posto di un numero su date verrà visualizzato l'errore "invalidPath".

2)Filtro ore: questo metodo utilizza l'input fornito dall'utente "hour" e crea una lista che contiene tutti i commenti creati all'ora scelta. Questo avviene utilizzando la lista che viene visualizzata dall'utente avviando la rotta "/comments". Nel caso in cui durante questo processo occorrano delle eccezioni l'utente visualizzerà la stringa relativa all'eccezione "InvalidHourException" che gli permetterà di capire l'errore commesso. Se l'utente dovesse inserire una stringa al posto di un numero su date verrà visualizzato l'errore "invalidPath".

3)Filtro utente: questo metodo utilizza l'input fornito dall'utente "name" e crea una lista che contiene tutti i commenti creati dall'utente scelto. Questo avviene utilizzando la lista che viene visualizzata dall'utente avviando la rotta "/comments". Nel caso in cui durante questo processo occorrano delle eccezioni l'utente visualizzerà la stringa relativa all'eccezione "InvalidNameException" che gli permetterà di capire l'errore commesso. 
