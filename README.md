# Progetto Programmazione ad oggetti

Lo scopo del nostro progetto è offrire all'utente una gestione dei commenti relativi ad una pagina facebook. I servizi di cui può usufruire l'utente sono: la visualizzazione di una lista contenente tutti i commenti (e le risposte ad i commenti) nella pagina facebook presa in esame,la visualizzazione di tutti i post presenti nella pagina in questione, la visualizzazione di tutti i commenti relativi ad un post presente nella pagina designata dall'utente, la visualizzazione di un singolo commento scelto dall'utente, statistiche e filtri relativi ai commenti presenti nella pagina scelta.

# Applicazione

Tramite l'API di facebook for developers il programma riceve in input i dati relativi a tutti i commenti salvandone poi i campi su una lista che verrà poi visualizzata dall'utente in formato JSON. Se durante un qualsiasi processo occorre un'eccezione dall'utente verrà visualizzata una stringa relativa all'eccezione stessa che spieghi all'utente l'errore che ha commesso.

# Rotte disponibili

# /comments

Quando viene avviata questa rotta il programma tramite l'API di facebook for developers accede ai dati relativi alla pagina facebook presa in esame, il programma procede poi a salvare tutti i commenti con i relativi campi all'interno di una lista che viene poi visualizzata dall'utente. La lista fornita da questa funzione verrà poi utilizzata anche da altre classi, per esempio è la lista utilizzata dai metodi relativi che forniscono le statistiche.

