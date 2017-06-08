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
                <p>Nerdbook è un servizio di rete sociale lanciato il 4 febbraio 2004, posseduto e gestito dalla società  Nerdbook Inc., basato su una piattaforma software scritta in vari linguaggi di programmazione. Il sito, fondato ad Harvard negli Stati Uniti da Edoardo Demuru, era originariamente stato progettato esclusivamente per gli studenti dell'Università  di Harvard, ma fu presto aperto anche agli studenti di altre scuole della zona di Boston, della Ivy League e della Stanford University.
                   Successivamente fu aperto anche agli studenti delle scuole superiori e poi a chiunque dichiarasse di avere più di 13 anni di età . Da allora Nerdbook ha ragginto un enorme successo: secondo Edoardo è il terzo sito più visitato al mondo dopo Google e YouTube. Ha cambiato profondamente molti aspetti legati alla socializzazione e all'interazione tra individui, sia sul piano privato che quello economico e commerciale.
               
                </p>
                </section>
            
           
            
            
            <section id="funzionalita" class="descr">
                <h3 class="titlesect">Funzionalità </h3>
                <p>Nerdbook offre un'interfaccia estremamente interattiva per la gestione delle proprie amicizie e dei propri gruppi. Si ha la possibilità di creare un gruppo e conoscere nuova gente che condivida gli stessi interessi.
                </p>
            </section>
            
            
            
            <section id="come" class="descr">
                <h3 class="titlesect">Come iscriversi?</h3>
                <p>L'iscrizione può avvenire dall'indirizzo specifico oppure utilizzando il link "Login" posto sulla destra della pagina. Per aprire una pagina è obbligatorio avere un profilo personale che però può benissimo essere reso invisibile e senza utilizzo reale, aperto al solo scopo di "appoggiare" la pagina pubblica. Inoltre, la pagina deve avere almeno un amministratore (il primo coincide con l'account che ha creato la pagina) e gli amministratori possono designare persone (ovviamente iscritte a Nerdbook) con dei ruoli per la gestione della pagina (editor, moderatore, inserzionista, analista) e ciascuno di questi può o meno svolgere una determinata attività.
                   Oltre che mediante operazione manuale-volontaria da parte di un titolare, una pagina Nerdbook si potrebbe generare automaticamente quando qualcuno, ad esempio, si registra in un luogo che non ha ancora una pagina e pertanto viene creata dal sistema una pagina, sprovvista di amministratori, che rappresenta quella posizione. In pratica succede quando degli iscritti, sui loro profili, postano commenti o recensioni per un'attività, identificata dalla localizzazione. Queste pagine sono etichettate nella copertina come "non ufficiali" e la didascalia recita "Questa Pagina non ufficiale è stata creata perchè le persone su Nerdbook hanno dimostrato il loro interesse per questo luogo o questa azienda.
                </p>
            </section>
                
            </article>                
                 
         
     </div>
            
        
    </body>
    
    
</html>