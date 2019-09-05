package time.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

import org.junit.jupiter.api.Test;




/**
 * 
 *                                         `-----`                                                
                                      `:+/-----/++++++/``                                       
                                     .s-       -   ````//++-                                    
                                    `y.        -y...      .o-                                   
                                   -y`          /NNhys.:   /o                                   
                                  -s..         .mNhsyyso   /o                                   
                                 .hsy-        `ym+syhNNh  `o/                                   
                                  .`d         /Nm/::+oyd  :s                                    
                                   ++       .sNMMm+s/yho `h`                                    
                                  -s.     .sNMmdMMNm:yy .s-                                     
                                 -s`  ..:/hMNNddNdNN:o- ++                                      
                                 /o+++:o-`sMhossosNm-: -`s/                                     
                                  ```` .y-:omNhyNNy-`.:o/+y                                     
                  `//+sss+++++ssssss+//-://:.oyyy-.::+::/+oosssso++++osso//:                    
                   ...:::+++::/:::://..+d+. `````` `:yh-.-+:::://:/++/::-..`                    
                           y/oo+-     `s+/////////////s:     `:+++`                             
                           h:s.os+.  `o:--/..    .:`/-.o-   /+-s:y                              
                          :s+/.`/++- +/./:-/:.  /dd`hm+.y`.:s`./+s-                             
                          o+y-/hh``:+y:.+/-+/-  +mNhNNo h+/.dy/:yo+                             
                         -yo- .y-   `:+-..:.-    -oo+-.:+.  -y. :oy-                            
                         y++-.s:      `:o.++osooss++-:o.     /o.-++y`                           
                        o+o/:oo`        +om-dmmhmmo+ss.      `so:++o+                           
                       :d// +s.       `-/om`+dMMNy-+sy.`      .s/ ++h-                          
                      .so/+sh`       -/:+om```+y-``oos./:`     .hs+/so`                         
                     -s/+`:s.     `-+-` ``+//:--://+-   .+:`    .s-.//o-                        
           ````    -/s//+y+.     -+:`       ``::-`        -/:`   .+y+//s:-    ````              
          /hdmds//o+s+`./+     -/:                          .+:`   +/..+s+o//smmhy:             
          `-oddmMdsho++:`    -+:`       ````------`````       -/:`  .:++shsmMmddo-`             
         .+sdmmNNd+/`      -/:`    `..://///:-----/////:-..     -/:`    `/+mMNmmds+`            
       `+shhhNmo:`       `/+`    ./oso.`               ./so/-`    :+.      `:sNNhdys+`          
       `osymms.        `/+.    .//.`                       .:+-    `/+.       .smmyoo`          
        ``--.        `:/:/:...++`                            `:o-..://:/.       .-..`           
                   `/+.  `.//+y+                              -yo//-`  `:+.                     
                 `:/.      `:/-                                `//.      `:+.                   
               `/+.      `:+.                                    `//.      `//.                 
             `:/.       :+-                                        `/+       `/+.               
           `/+.      `` o/                                          `d ``      `//.             
         `:+.       :od.o:                                          `h.yo+       `/+.           
       `/+-`````-////.-/.                                            `//`:+//:`````.++.         
       :+////////```                                                      ```-///////+/  
 *
 *	Hello, et bienvenue pour notre deuxième session de Javitulation, une série d'aventures ou nous récapitulons ce que nous avons appris en Java!
 */



/*
 * Encore une classe de test, comme la dernière fois.
 */
class TestDatetime {

	@Test
	void testTime() {
		var quelleheureestil = LocalTime.now(); //Quand vous carrez un "var" à la place du nom de la Classe dont vous avez besoin, Java va tenter de faire de son mieux pour faire en sorte que la variable soit du type correspondant.
												//ça facilite votre job, certes... Mais ça implique qu'a la lecture du code par un de vos collaborateurs, celui ci va perdre du temps à savoir de quel type est la variable.
												//Personnellement je n'aime pas trop ça, mais encore une fois : chacun son truc.
		
												//Sinon, LocalTime.now(), c'est encore une fois une méthode statique. Elle retourne un objet LocalTime qui est une représentation informatique de l'heure locale.
		System.out.println(quelleheureestil);
	}
	
	@Test
	void testDate() {
		var queljouronest = LocalDate.now(); //Stocke un objet LocalDate représentant le jour courant dans la variable queljouronest.
		System.out.println(queljouronest);//Renvoie "2019-09-05". Pas compliqué.
		System.out.println(
				queljouronest.format(DateTimeFormatter.ofPattern("eeee dd/MM/Y"))); //Renvoie "jeudi 05/09/2019". La méthode statique "ofPattern", de la classe DateTimeFormatter, formate la date en fonction de la chaine de caractères que l'on fait passer en paramètre("eeee DD/MM/y");
	}
	
	@Test
	void testDateInternational() {
		ZoneId argTz = ZoneId.of("America/Buenos_Aires"); //La classe ZoneId est une classe qui permet de créer une représentation informatique d'une timeZone (un fuseau horaire)
		var quand = LocalDateTime.now(argTz);			// Quel jour on est en argentine?
		System.out.println(quand);						// 2019-09-05T05:05:32.792281100. C'est barbare
		//Locale argLocale = new Locale("esp", "arg");
		Locale[] locales = Locale.getAvailableLocales();// Wait, wait, wait, wait. Vous vous rappelez de l'algo? En algo, y'a des tableaux. Quand on écrit "Locale[]", on créé un tableau de locales. (Tout comme écrire String[] crée un tableau de Strings]
														// Locale.getAvailableLocales retourne un tableau de toutes les Localisations de temps disponibles en Java.
														//On le stocke dans la variable "locales". Qui est une variable locale... Mathias, pourquoi rends tu les choses si compliquées? :(
		Arrays.sort(locales, Comparator.comparing(Object::toString)); //Tri par ordre alphabétique du tableau.
		
		
		//Pour chaque localisation...
		for (Locale loc : locales) {
			//On affiche le nom de la localisation...
			System.out.print(loc + " : ");
			//Et on affiche la date au format adéquat.
			System.out.println(
				quand.format(DateTimeFormatter.ofPattern("eeee dd/MM/Y", loc)));
		}
	}
	
	@Test
	void testDateTime() {
		var onestquand = LocalDateTime.now();
		System.out.println(onestquand);
	}
	
	
	

}
