# Progetto Programmazione ad oggetti

Lo scopo del nostro progetto è offrire all'utente una gestione dei commenti relativi ad una pagina facebook. I servizi di cui può usufruire l'utente sono: la visualizzazione di una lista contenente tutti i commenti (e le risposte ad i commenti) nella pagina facebook presa in esame,la visualizzazione di tutti i post presenti nella pagina in questione, la visualizzazione di tutti i commenti relativi ad un post presente nella pagina designata dall'utente, la visualizzazione di un singolo commento scelto dall'utente, statistiche e filtri relativi ai commenti presenti nella pagina scelta.

# Applicazione

Tramite l'API di facebook for developers il programma riceve in input i dati relativi a tutti i commenti salvandone poi i campi su una lista che verrà poi visualizzata dall'utente in formato JSON. Se durante un qualsiasi processo occorre un'eccezione dall'utente verrà visualizzata una stringa relativa all'eccezione stessa che spieghi all'utente l'errore che ha commesso.

# Rotte disponibili

# /comments

Quando viene avviata questa rotta il programma tramite l'API di facebook for developers accede ai dati relativi alla pagina facebook presa in esame, il programma procede poi a salvare tutti i commenti con i relativi campi all'interno di una lista di COMMENT che viene poi visualizzata dall'utente. La lista fornita da questa rotta verrà poi utilizzata anche da altre classi, per esempio è la lista utilizzata dai metodi relativi che forniscono le statistiche.

# /posts

Quando viene avviata questa rotta il programma riceve in input il file JSON fornito dall'API di facebook for developers che verrà visualizzato dall'utente senza che il programma lo modifichi in alcun modo, questo fa si che l'utente possa accedere ai dati richiesti per avviare le rotte più specifiche. I campi forniti dall'API sono: il messaggi contenuti nei post, l'id dei post visualizzati, il momento della creazione dei post viualizzati.

# /posts/{postId}/comments

La rotta sopracitata quando avviata prende in input tutti i commenti relativi al post di cui si è fornito l'id durante la chiamata e li salva all'interno di una lista di COMMENT che verrà poi visualizzata dall'utente (vengono salvati anche i commenti che rispondono ad altri commenti presenti sotto il post di cui si è fornito l'id in input) .

# /posts/{postId}/comments/{id}

Questa rotta quando avviata scorre la lista di COMMENT fornita dalla rotta "/comments" e cerca il commento con un id corrispondente a quello fornito. Se lo trova l'utente visualizza poi il commento in formato JSON, mentre se non ci sono id corrspondenti a quello fornito dall'utente viene visualizzata la stringa relativa all'eccezione CommentIdException che spiega all'utente l'errore che ha commesso.

# /stats/{name1}/{name2}

Questa rotta contiene tutte le statistiche effettuate da questa applicazione sui commenti, queste si dividono in vari tipi:

1)Frequenza commenti: questa statistica fornisce all'utente un elenco di date ed ore relativo alla creazione dei commenti generati dall'utente sulla pagina presa in esame. Nel caso in cui l'utente non abbia mai commentato o nel caso in cui i suoi dati non siano accessibili questa rotta restituisce la stringa relativa all'eccezione "invalidNameException" che verrà poi visualizzata dall'utente.

2)Media oraria: questa statistica fornisce all'utente l'orario medio in cui vengono generati i commenti sulla pagina presa in esame, questo avviene utilizzando la lista che viene visualizzata dall'utente avviando la rotta "/comments".


