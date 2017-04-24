<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdbook - Descrizione</title>
        <meta charset="UTF-8">
        <meta name="author" content="Edoardo Demuru">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Nerdbook Social Network sogni">
        <meta name="description" content="Descrizione Social Network sogni">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
         <c:set var="page" value="2" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        
     <div id="pageContent">
         
         <jsp:include page="nav.jsp"/>
         
         
         
         <article id="CorpoTesto">           
             <div class="descr" id="headerArticle">
         <h2>Informazioni sul Social Network</h2>
             </div>
         <div id="internaltitle">
         <h2>Informazioni Generali</h2>
         <div id="internallinks">             
              <ol >
                <li><a href="#cosa">Cosa è NerdBook?</a></li>
                <li><a href="#funzionalita">Funzionalità </a></li>
                <li><a href="#come">Come Iscriversi?</a></li>                
              </ol>
           </div>
             </div>
                
                <section id="cosa" class="descr">
                <h3 class="titlesect">Cosa è NerdBook?</h3>
                <p>Facebook Ã¨ un servizio di rete sociale lanciato il 4 febbraio 2004, posseduto e gestito dalla societÃ  Facebook Inc., basato su una piattaforma software scritta in vari linguaggi di programmazione. Il sito, fondato ad Harvard negli Stati Uniti da Mark Zuckerberg, Eduardo Saverin, Andrew McCollum, Dustin Moskovitz e Chris Hughes, era originariamente stato progettato esclusivamente per gli studenti dell'UniversitÃ  di Harvard, ma fu presto aperto anche agli studenti di altre scuole della zona di Boston, della Ivy League e della Stanford University.
                   Successivamente fu aperto anche agli studenti delle scuole superiori e poi a chiunque dichiarasse di avere piÃ¹ di 13 anni di etÃ . Da allora Facebook raggiunse un enorme successo: secondo Alexa Ã¨ il terzo sito piÃ¹ visitato al mondo dopo Google e YouTube.[3] Ha cambiato profondamente molti aspetti legati alla socializzazione e all'interazione tra individui, sia sul piano privato che quello economico e commerciale.
                   Ã disponibile in oltre 100 lingue (in italiano dal 14 maggio 2008) e a luglio 2016 contava circa 1,7 miliardi di utenti attivi mensilmente, classificandosi come primo servizio di rete sociale per numero di utenti attivi.
                   Il nome "Facebook" prende spunto da un elenco con nome e fotografia degli studenti, che alcune universitÃ  statunitensi distribuiscono all'inizio dell'anno accademico per aiutare gli iscritti a socializzare tra loro.
                   Gli utenti possono accedere al servizio previa una registrazione gratuita, durante la quale vengono richiesti dati personali come nome, cognome, data di nascita e indirizzo email. Il sito web chiarisce che l'inserimento obbligatorio della data di nascita serve esclusivamente "per favorire una maggiore autenticitÃ  e consentire l'accesso ai vari contenuti in base all'etÃ ". Completata la registrazione, gli utenti possono creare un profilo personale, includere altri utenti nella propria rete sociale, aggiungendoli come "amici", e scambiarsi messaggi, anche via chat, incluse le notifiche automatiche quando questi aggiornano i propri profili. Per personalizzare il proprio profilo l'utente puÃ² caricare una foto, chiamata immagine del profilo, con la quale puÃ² rendersi riconoscibile. PuÃ² inoltre fornire ulteriori informazioni, come il comune di nascita e quello di residenza, la scuola frequentata, il proprio datore di lavoro, l'orientamento religioso e quello politico, la propria situazione sentimentale e molte altre.
                   Inoltre gli utenti possono fondare e unirsi a gruppi per condividere interessi in comune con altri utenti, organizzati secondo il luogo di lavoro, la scuola, l'universitÃ  o altre caratteristiche, condividere contenuti multimediali ed utilizzare varie applicazioni
                   presenti sul sito.
                </p>
                </section>
            
           
            
            
            <section id="funzionalita" class="descr">
                <h3 class="titlesect">Funzionalità </h3>
                <p>Di seguito la descrizione delle funzioni del servizio "profilo personale". Dal 2006 Ã¨ attivo sulla homepage del profilo personale il News-feed, un aggregatore che mostra in successione gli aggiornamenti propri e degli amici. Inizialmente questo sistema ha ricevuto delle critiche da parte degli utenti, secondo alcuni i news-feed includevano molte informazioni sgradite e irrilevanti, secondo altri metteva troppo in risalto informazioni personali e potenzialmente sensibili (come il cambiamento della situazione sentimentale, la partecipazione ad eventi e le conversazioni con altri utenti). In risposta a queste critiche Ã¨ stata data la possibilitÃ  di scegliere che tipo di informazioni condividere automaticamente e con chi. Oggi Ã¨ infatti possibile raggruppare gli amici in categorie e scegliere con quali categorie condividere certe informazioni (come cambiamenti del profilo, post sulla bacheca e l'aggiunta di nuovi amici).
                   Una delle applicazioni piÃ¹ utilizzate su Facebook Ã¨ quella delle Foto, dove gli utenti possono caricare un numero illimitato di album di immagini (a differenza di altri servizi di condivisione di immagini come Photobucket e Flickr). Il solo limite Ã¨ nel numero massimo di 1000 foto per album. Le impostazioni della privacy possono essere cambiate per ogni album, limitandone o meno la visione a certi utenti. Un'altra caratteristica delle Foto Ã¨ la funzione del tag, con la quale si appone un'"etichetta" su un'immagine segnalando chi Ã¨ presente nella foto e creando un link al suo profilo se si tratta di un altro utente Facebook. In questo modo si crea automaticamente, per ogni profilo, una raccolta di foto in cui quell'utente Ã¨ stato taggato.
                   Facebook offre diversi servizi di messaggistica privata. Ã possibile inviare privatamente dei messaggi ad altri utenti, se le impostazioni della privacy lo consentono. Ad aprile 2008 Ã¨ stata lanciata l'applicazione Chat per scambiare messaggi in tempo reale con gli amici collegati al loro profilo Facebook. Il 15 novembre 2010 Ã¨ stato annunciato un nuovo servizio integrato di gestione dei messaggi. Tramite una sola applicazione Ã¨ ora possibile gestire contemporaneamente messaggi sms, chat, email e normali messaggi, e regolare le impostazioni della privacy.
                   La funzione Note, introdotta nell'agosto 2006, permette agli utenti di pubblicare scritti e articoli in maniera simile a un blog. Sono attive le funzioni di tag e di inserimento immagini.
                   Dal maggio 2007 su Facebook Ã¨ disponibile il Marketplace, che consente agli utenti di inserire gratuitamente annunci che risultano visibili solo da utenti presenti nella stessa rete.
                   Nel giugno 2009 Ã¨ stata introdotta la funzionalitÃ  username, che rende i profili accessibili tramite indirizzi semplificati, come ad esempio "http://www.facebook.com/facebook", invece del precedente formato "http://www.facebook.com/profile.php?id=20531316728".
                   Il 21 aprile 2010 Ã¨ stato lanciato il tasto Mi piace, con il quale gli utenti possono esprimere apprezzamento su dei singoli contenuti.
                   Dall'aprile 2011 la chat Ã¨ stata arricchita da una funzione per effettuare chiamate vocali, che permette anche di lasciare messaggi in una segreteria vocale. Il 6 luglio 2011 Ã¨ stato lanciato il servizio di videochiamate che utilizza la tecnologia di Skype.
                   Oltre alle attivitÃ  di servizio di rete sociale, sono state sviluppate numerosi videogiochi gratuiti che hanno coinvolto milioni di utenti. Tra questi ci sono FarmVille, sviluppato dal produttore di software Zynga, che ha raggiunto 11 milioni di utenti attivi (cioÃ¨ non occasionali) quotidianamente[23]; sempre di Zynga, Mafia Wars Ã¨ arrivato a 5 milioni di utenti[24], mentre Pet Society, sviluppato da Playfish, Ã¨ stato classificato come l'applicazione Facebook piÃ¹ popolare nell'aprile 2009[25][26]. Da dicembre 2010 sono presenti anche due nuovi giochi prodotti da Square Enix: Knights of the Crystals e Chocobo's Crystal Tower[27]. Candy Crush Saga, invece, nel 2013 Ã¨ divenuto il gioco piÃ¹ popolare di Facebook superando FarmVille.
                   Il 15 gennaio 2013 Ã¨ stata annunciata la nuova funzione di ricerca Graph Search, che intende rispondere alle domande degli utenti con la lingua naturale, invece che con un elenco di link, sfruttando le informazioni presenti sui profili dei loro amici.[28] Questa funzionalitÃ , inizialmente disponibile solo per gli utenti in lingua inglese, verrÃ  in seguito esteso anche agli utenti delle altre nazionalitÃ . Ad aprile 2013, viene resa disponibile una nuova versione di Messenger for Android, famosa applicazione ideata direttamente dai developers di Facebook, grazie alla quale Ã¨ possibile chattare con un proprio amico anche se la suddetta applicazione non Ã¨ aperta in primo piano, facendo uso delle Chat Heads.
                   Per i dispositivi iOS, questa novitÃ  Ã¨ altamente limitata per seguire la politica delineata da Apple, dunque le Chat Heads sono state introdotte solamente se l'applicazione Ã¨ aperta in primo piano. Se si desidera usufruire di tale funzionalitÃ  anche al di fuori dell'app stessa, Ã¨ possibile installare tramite l'applicazione Cydia, disponibile solamente su dispositivi Jailbroken, il pacchetto MessageBox. Nello stesso mese, precisamente il 4 aprile 2013, il CEO Mark Zuckerberg annuncia il lancio, previsto per il 12 aprile, di Facebook Home, app multifunzione disponibile in esclusiva sugli smartphone Android. Si tratta di un'interfaccia grafica che permette in ogni momento di accedere a tutti i contenuti pubblicati dai propri amici e di chattare con loro, il tutto durante il normale utilizzo dello smartphone.[29].
                   L'applicazione Ã¨ attualmente disponibile solo per HTC One, HTC One X+, HTC One X, Samsung Galaxy S3, Samsung Galaxy S4 e Samsung Galaxy Note, mentre le versioni per altri dispositivi verranno distribuite in un secondo momento.
                   Il 13 novembre 2013 viene distribuita la nuova versione 3.0 dell'app Facebook Messenger, sia per Android che per iOS. La nuova versione, oltre ad una grafica totalmente rivisitata consente di utilizzare il numero di telefono per inviare messaggi a tutti i numeri senza dover necessariamente essere amici su Facebook, richiamando la funzione di altre popolari app di messaggistica istantanea come WhatsApp.
                   Dal 15 febbraio 2017 Ã¨ disponibile la funzione Stories, come in Instagram e successivamente anche in Whatsapp.
                   Recentemente milioni di utenti usano Facebook come una piattaforma simile a quella di YouTube ovvero, mettere in mostra i propri video, creando un pubblico numeroso.
                   Facebook non Ã¨ solo per le persone fisiche e la loro vita privata ma, attraverso un servizio dedicato (Facebook for Business), Ã¨ anche un strumento di social marketing.
                </p>
            </section>
            
            
            
            <section id="come" class="descr">
                <h3 class="titlesect">Come iscriversi?</h3>
                <p>L'iscrizione puÃ² avvenire dall'indirizzo specifico[32] oppure utilizzando il link "Crea una Pagina" posto in fondo alla schermata di iscrizione al servizio profilo personale. Per aprire una pagina Ã¨ obbligatorio avere un profilo personale che perÃ² puÃ² benissimo essere reso invisibile e senza utilizzo reale, aperto al solo scopo di "appoggiare" la pagina pubblica. Inoltre, la pagina deve avere almeno un amministratore (il primo coincide con l'account che ha creato la pagina) e gli amministratori possono designare persone (ovviamente iscritte a Facebook) con dei ruoli per la gestione della pagina (editor, moderatore, inserzionista, analista) e ciascuno di questi puÃ² o meno svolgere una determinata attivitÃ [33].
                   Oltre che mediante operazione manuale-volontaria da parte di un titolare, una pagina Facebook si potrebbe generare automaticamente quando qualcuno, ad esempio, si registra in un luogo che non ha ancora una pagina e pertanto viene creata dal sistema una pagina, sprovvista di amministratori, che rappresenta quella posizione. In pratica succede quando degli iscritti, sui loro profili, postano commenti o recensioni per un'attivitÃ [34], identificata dalla localizzazione. Queste pagine sono etichettate nella copertina come "non ufficiali" e la didascalia recita "Questa Pagina non ufficiale Ã¨ stata creata perchÃ© le persone su Facebook hanno dimostrato il loro interesse per questo luogo o questa azienda. La Pagina non Ã¨ collegata nÃ© sostenuta da persone associate con ...". Esiste una procedura per rivendicare tale pagina automatica da parte del titolare e, in alcuni casi, conservare i contenuti[35].                   
                   Oltre che mediante operazione manuale-volontaria da parte di un titolare, una pagina Facebook si potrebbe generare automaticamente quando qualcuno, ad esempio, si registra in un luogo che non ha ancora una pagina e pertanto viene creata dal sistema una pagina, sprovvista di amministratori, che rappresenta quella posizione. In pratica succede quando degli iscritti, sui loro profili, postano commenti o recensioni per un'attivitÃ [34], identificata dalla localizzazione. Queste pagine sono etichettate nella copertina come "non ufficiali" e la didascalia recita "Questa Pagina non ufficiale Ã¨ stata creata perchÃ© le persone su Facebook hanno dimostrato il loro interesse per questo luogo o questa azienda. La Pagina non Ã¨ collegata nÃ© sostenuta da persone associate con ...". Esiste una procedura per rivendicare tale pagina automatica da parte del titolare e, in alcuni casi, conservare i contenuti[35].                   
                   Oltre che mediante operazione manuale-volontaria da parte di un titolare, una pagina Facebook si potrebbe generare automaticamente quando qualcuno, ad esempio, si registra in un luogo che non ha ancora una pagina e pertanto viene creata dal sistema una pagina, sprovvista di amministratori, che rappresenta quella posizione. In pratica succede quando degli iscritti, sui loro profili, postano commenti o recensioni per un'attivitÃ [34], identificata dalla localizzazione. Queste pagine sono etichettate nella copertina come "non ufficiali" e la didascalia recita "Questa Pagina non ufficiale Ã¨ stata creata perchÃ© le persone su Facebook hanno dimostrato il loro interesse per questo luogo o questa azienda. La Pagina non Ã¨ collegata nÃ© sostenuta da persone associate con ...". Esiste una procedura per rivendicare tale pagina automatica da parte del titolare e, in alcuni casi, conservare i contenuti[35].
                </p>
            </section>
                
            </article>                
                 
         
     </div>
            
        
    </body>
    
    
</html>