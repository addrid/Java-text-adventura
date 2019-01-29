/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postapocalyptic.navd00_navratil.adventura.game;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel Navrátil
 */
public class Texts {
/*
* Knihovní třída {@code Texts} slouží jako schránka na textové konstanty,
* které se používají na různých místech programu.
* Centralizací definic těchto textových řetězců lze nejsnadněji dosáhnout toho,
* že texty, které mají být shodné na různých místech programu,
* budou doopravdy shodné.
*/
    /** Jméno autora programu. */
static final String AUTHOR_NAME = "NAVRÁTIL Daniel";

    /** Xname autora programu. */
static final String AUTHOR_ID = "NAVD00";

/** Názvy používaných prostorů - místností. */
static final String
OSADA = "osada",
RUINY = "ruiny",
VSTUP = "vstup",
UDOLI = "udoli",
JESKYNE = "jeskyne",
LES = "les",
KOPEC = "kopec",
STEZKA = "stezka",
VRCHOLEK = "vrcholek",
VEZ = "vez";


/** Názvy používaných předmětů. */
static final String
VODA       = "voda",
KONZERVY   = "konzervy",
NUZ        = "nuz",
DREVO      = "drevo",
LAHEV      = "lahev",
        
ZRANENY    = "zraneny",
POSKOK     = "poskok",
VUDCE      = "vudce",

ZPRAVA     = "zprava",
ZNACKA     = "znacka",
ROZCESTNIK = "rozcestnik",
BRANA      = "brana",
DENIK      = "denik",
BALVAN     = "balvan",
KABAT      = "kabat",
VSE        = "vse",
TRUHLA     = "truhla";
/*PAPÍR = "Papír",
PIVO = "Pivo",
RUM = "Rum",
SALÁM = "Salám",
HOUSKA = "Houska",
VÍNO = "Víno",
POSTEL = "Postel",
ZRCADLO = "Zrcadlo",
ŽUPAN = "Župan";*/


/** Názvy používaných akcí. */
static final String
pHELP = "?",
pJDI = "Jdi",
pNASAD = "Nasad",
pOTEVRI = "Otevri",
pPOLOZ = "Poloz",
pPRECTI = "Precti",
pVEZMI = "Seber", // Vezmi
pZAVRI = "Zavri",
pKONEC = "Konec",
pPOUZIJ = "Pouzij",
pBATOH = "Batoh",
pUKOL = "Ukol",
pDOMU = "Domu",
pSPAT = "Spat",
pPROMLUV = "Promluv",
pCAS = "Cas",
pCHEAT = "Cheat",
pROZHLEDNOUT = "Prohledat"; // Rozhlednout

/** Formát dodatku zprávy informujícího o aktuálním stavu hráče. */
static final String
SOUSEDE = "Sousedé: ",
H_OBJEKTY = "H-objekty: ",
BATOH = "Batoh: ",
FORMAT_INFORMACE = "\n\nNacházíte se v místnosti: %s" +
"\n" + SOUSEDE + "[%s]" +
"\n" + H_OBJEKTY + "[%s]" +
"\n" + BATOH + "[%s]";

/** Texty zpráv vypisovaných v reakci na příkazy vyvolávají povinné akce.
* Počáteční z (zpráva) slouží k odlišení od stavů. */
static final String
zNENI_START = "\nPrvním příkazem není startovací příkaz." +
"\nHru, která neběží, lze spustit pouze startovacím příkazem.\n",
zPORADIM = "\nChcete-li poradit, zadejte příkaz ?",
zPRAZDNY_PRIKAZ = "\nZadal(a) jste prázdný příkaz." + zPORADIM,
zNEZNAMY_PRIKAZ = "\nTento příkaz neznám." + zPORADIM,
zANP = "\nZadaná akce nebyla provedena",
zDVA_PREDMETY = "\nJe potřeba uvést vždy dva předměty.",
zCAS = "\nPrávě je: ",
    
pMAGIE = "Magie",
pKOUZLO = "Kouzlo",
        
zPRESUN = "\nPřesunul(a) jste se do místnosti: ",
zCIL_NEZADAN = zANP + "\nNebyla zadána místnost, do níž se má přejít",
zOSOBA_NEZADANA = zANP + "\nNebyla zadána osoba, se kteoru chcete promluvit",
zNENI_CIL = zANP + "\nDo zadané místnosti se odsud nedá přejít",
        
zNEVIM_CO_POLOZIT = zANP + "\nNevím co položit.",
zNEVIM_CO_ZAVRIT  = zANP + "\nNevím co zavřít.",
zNEVIM_CO_CIST    = zANP + "\nNebylo zadáno, co se má přečíst",  
zNEVIM_CO_NASADIT = zANP + "\nNebylo zadáno, co se má nasadit",    
zNEVIM_CO_POUZIT  = zANP + "\nNebyly zadány žádné předměty. "
                         + zDVA_PREDMETY,
zNEVIM_NA_CO_POUZIT = zANP + "\nNebyl zadán druhý předmět pro použití."
                         + zDVA_PREDMETY,
        
zZVEDNUTO = "\nVzal(a) jste předmět: ",
zPOLOZENO = "\nPoložil(a) jste předmět: ",
zH_OBJEKT_NEZADAN = zANP + "\nNebyl zadán předmět, s nímž mám manipulovat",
zTEZKY_H_OBJEKT = zANP + "\nZadaný předmět nejde zvednout: ",
zNENI_V_MISTNOSTI = zANP + "\nZadaný předmět/osoba v místnosti není.",
zNENI_V_BATOHU = zANP + "\nPředmět není v batohu: ",
zBATOH_PLNY = zANP +
"\nZadaný předmět nemůžete vzít, batoh je již plný",
zNEVIM_OTEVRIT = "Nebylo zadáno, co se má otevřít",
zNEOTVIRATELNY = "Zadaný předmět není otevíratelný: ",        
//zNEVIM_KAM_JIT = zANP + "\nNebyla zadána destinace přechodu. ",        
zNENI_SOUSEDEM = zANP + "\nProstor není sousedem.",
zNENI_AKTUALNIM_PROSTOREM = zANP + "\nNení aktuálním prostorem.",         
zNEJDE_OTEVRIT = zANP + "\nPředmět nelze otevřít.", 
zNELZE_CIST    = zANP + "\nPředmět nelze přečíst.",
zNELZE_NASADIT    = zANP + "\nPředmět nelze nasadit: ",
zNELZE_POUZIT     = zANP + "\nPředmět nelze použít: ",
zNELZE_NA_POUZIT     = zANP + "\nNa tento předmět nelze použít: ",       

zZAVRIT_LZE_JEN_TRUHLU = zANP + "\nZavřít lze pouze truhlu.",

zPOLOZ_VSE = "\nPoložil si vše.",
        
zZAMCENO = "\nBrána je zamčená" +        
           "\nMůžeš zkusit odemknout bránu nožem.",     

zCHYBI_DREVO     = zANP + "\nStále si nezískal dřevo.",         
zCHYBI_KONZERVY  = zANP + "\nStále si nezískal konzervy.",     
zCHYBI_VODA  = zANP + "\nStále si nenaplnil láhev vodou.",    
zSPAT_OSADA  = zANP + "\nSpát můžeš pouze v osadě.",     
zVUDCE  = "\nJsi naší jedinou nadějí!" + 
          "\nProsím, nečekej a jdi. Máš v rukou spoustu životů!",     
zVUDCE2  ="\nVidím, že se ti podařilo získat jak dřevo, tak konzervy." +
          "\nJeště ti ale chybí voda.",       
zPOSKOK  ="\nNezapomeň si vzít láhev." + 
          "\nBudeš jí určitě potřebovat chceš-li přinést nějakou vodu zpět.", 
zPOSKOK2  = "\nVidím, že si dokázal získat vodu. Dobrá práce.",        
zZRANENY  = "\nDál už nemohu. Vem si můj nůž, určitě se ti bude hodit." +
            "\nPotřebuješ-li získat dřevo, určitě se ti bude hodit." +
            "\nLze ho také použít na odemknutí zamknutých zámků.",    
zNELZE_PROMLUVIT  = "\nS tímto předmětem nelze promluvit.",       
zDOHRANO = "\nPodařilo se vám úspěšně dohrát hru. Děkujeme za vyzkoušení.", 
zCHEAT = "\nZískal si vše potřebné.\nNyní už stačí jen promluvit s vůdcem.",     
zKOUZLO = "Provedl si kouzlo. Nyní ho máš v batohu",        
dRUINY = "Přechod do ruin",
dOSADA = "Přechod do osady",        
dVSTUP = "Přechod do vstup",        
dUDOLI = "Přechod do udoli",        
dJESKYNE = "Přechod do jeskyne", 
dSTEZKA = "Přechod do stezka",         
dKOPEC = "Přechod do kopec",         
dLES = "Přechod do les",         
dVRCHOLEK = "Přechod na vrcholek",  
dVEZ = "Přechod na vez",  
dKONZ_ZVEDNUTO = "Konzervy sebrány",       
dDREV_ZVEDNUTO = "Získavaní dreva",     
dVODA_ZVEDNUTO = "Voda přesunuta do batohu",   
dNUZ_ZVEDNUTO = "Sebral jsi nuz",     
dVODA_POLOZENA = "Polozils vodu", 
dSPAT = "Sel si spat", 
        
        
zZIMA = "\nV této oblasti je příliš velká zima." +        
        "\nNasaď si kabát jestli chceš pokračovat.", 
zRUINY   = "\nPřišel jsi ruin. "
         + "\nVšude vidíš trosky a zbytky toho, co dříve obyvatelé považovali"
         + " za své domovy"
         + "\nVedle cesty leží zraněný a kousek od něho je pohozený nůž.",
zOSADA   = "\nPřišel jsi osady. "
         + "\nVedle cesty stojí dva muži. Vůdce a poskok."
         + "\nNa zemi vidíš ležet láhev.",
zVSTUP   = "\nPřišel jsi na vstup do Zóny. "
         + "\nPřed tebou se nachází les a cesta vedoucí do údolí."
         + "\nNa zdi před tebou je zpráva a pod ní vidíš pohozený kabát.",
zUDOLI   = "\nPřišel jsi do údolí. "
         + "\nUprostřed údolí vidíš stát značku.",       
zJESKYNE = "\nPřišel jsi temné jeskyně."
         + "\nSlyšíš, posléze i vidíš tekoucí potok průzračné vody."
         + "\nVoda se bude určitě hodit, chtělo by to však nějakou láhev.",       
zSTEZKA = "\nPřišel jsi na stezku vedoucí na kopec a do jeskyně."
        + "\nVedle vchodu do jeskyně leží kostlivec a vedle něho deník.",
zKOPEC  = "\nOcitl jsi se na kopci."
        + "\nPřed tebou stojí rozcestník. Ukazující třemi směry."
        + "\nLes, stezka a cesta vedoucí na vrcholek",        
zVRCHOLEK = "\nJsi na vrcholku."
          + "\nMůžeš se vydat zpět na kopec a nebo pokračovat na věž."
          + "\n%Před vstupem do věže je brána.",   
zVEZ    = "\nJsi v opuštěné věži. Všude vidíš to, co zbylo z lidí žíjících zde."
        + "\nNa zemi před sebou vidíš truhlu.",           
zLES    = "\nJsi v hustém lese. Všude kolem tebe jsou stromy."
        + "\nMožná zvládneš získat potřebné dřevo.", 
zTRUHLA = "\nTruhla je docela malá a uvnitř ní leží konzervy.",
        
zSPAT   = "\nZvládl jsi vše, pro co jsi byl předurčen."
        + "\nDíky tobě lidstvo dokáže přežít i v dalších těžkých měsících.",
     
zPREDMETY_PROSTOR = "\nV této oblasti se vyskytují předměty: \n",
zPREDMETY_BATOH = "\nV batohu se vyskytují tyto předměty: \n",
zSOUSEDI = "\n\nSousední oblasti: \n",
        
zNAPOVEDA = "\nPříkazy, které je možno v průběhu hry zadat:" +
"\n============================================\n",
zUVITANI = "\nVítej ve hře. Právě jsi se probudil v osadě."
         + "\nZískej všechny potřebné materiály."
  + "\nAž se ti to podaří, vrať se do osady a jdi spát nebo promluv s vůdcem.",
zCELE_UVITANI = zUVITANI +
String.format(FORMAT_INFORMACE,
OSADA, cm(RUINY),
cm(VUDCE, POSKOK, LAHEV), cm()),

zKONEC = "\nKonec hry. \nDěkujeme, že jste zkusil(a) naši hru.";


/** Texty vypisované v reakci na příkazy vyvolávající nepovinné akce. */
static final String
zCHCE_PRECIST =
"\nRozhodl(a) jste se přečíst ",

zNEMA_BRYLE = "." +
"\nText je psán příliš malým písmem, které je rozmazané." +
 "\nMusíte si nasadit brýle.",

zNASADIL =
"\nNasadil(a) jste si ",

zNAPSANO_ZNACKA = "\nNa značce je napsáno:" +
"\nNÁPIS ZNAČKY ",
  
zNAPSANO_DENIK = "\nV deníku se píše:" +
"\nTohle není místo pro člověka... " +
"\nPoblíž by měla být věž, která by mohla posloužit jako skrýš, před NIMA.",        
   
zNAPSANO_ROZCESTNIK = "\nRozcestník ukazuje třemi směry: " +
"\nVrcholek - vedle nápisu jsou nakreslené postavičky." +
"\nLes - vedle nápisu jsou nakreslené stromy." +
"\nStezky - lebka zdůrazňující nejspíše nebezpečnost této cesty.",   
        
zNAPSANO_ZPRAVA = "\nVe zprávě se píše:" +
"\nPotřebuješ sehnat tyto materiály: voda, drevo, konzervy",        

zMATERIALY = "\nPotřebuješ sehnat vodu, dřevo a konzervy",  
zMATERIALYD = "\nPotřebuješ sehnat vodu a konzervy",  
zMATERIALYV = "\nPotřebuješ sehnat dřevo a konzervy",  
zMATERIALYK = "\nPotřebuješ sehnat vodu a dřevo", 
        
zMATERIALYDV = "\nPotřebuješ sehnat konzervy", 
zMATERIALYDK = "\nPotřebuješ sehnat vodu",  
zMATERIALYVK = "\nPotřebuješ sehnat dřevo",  
zMATERIALY_FIN = "\nSehnal si všechno potřebné." + 
                 "\nNyní se vrať do osady a jdi spát, nebo promluv s vudcem",  
        
zCHCE_POUZIT =
"\nRozhodl(a) jste se použít předmět ",       
        
zH_OBJEKTEM =
" předmětem ",

zNELZE_NADZVEDNOUT =
"\nBohužel máte obě ruce plné a nemáte ledničku čím nadzvednout." ,

zBERE_ZTRUHLY =
"\nPokoušíte si vzít z truhly ",

zJE_CLOVEK =
"\nToto je inteligentní truhla, která neumožňuje " +
"\nvyjmout předmět aniž by jste neprokázali, že jste člověk." +
"\nJste člověk?",

zNAROZEN =
"\nV kterém roce jste se narodil(a)?",

zODEBRAL =
"\nVěřím vám a předávám vám požadovaný nápoj." +
"\nOdebral(a) jste z ledničky: ",

zNEZAPOMEN =
"\nDobrou chuť. Nezapomeňte zavřít truhlu.",
      
zOTEVREL 
= "\nTruhla byla otevřena.\nVidíš v ní konzervy.",       
        
zZAVREL_TRUHLU =
"\nÚspěšně jste zavřel(a) truhlu.",
        
zVYPOCITEJ =
"\nVypočítej následující příklad: ",
        
zBRANA_ODEMCENA = 
"\nPodařilo se ti odemknout bránu." +
"\nNyní můžeš vstoupit do věže",

zDREVO_ZISKANO = 
"\nPodařilo se ti pomocí nože nasekat kousky dřeva.";

/** Formáty zpráv vypisovaných v reakci na některé příkazy. */
static final String
fWRONG_INTEGER =
"Musíte zadat výsledek jako celé číslo.",

fWRONG_RANGE =
" v rozsahu od %d do %d",
fREMAINING =
"\nPočet pokusů pro správné zadání: ",
fONCE_MORE =
"\nAsi jste udělal chybu.",
fHUMAN =
"\nJste člověk?",
fTOO_LOW =
"Ve vašem věku ještě nesmíte požívat alkoholické nápoje.",
fNOT_ALLOWED =
"\nPokus o vyjmutí %s zamítnut.",
fDOES_NOT_MATCH =
"Vámi udaný výsledek neodpovídá.";




//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

/***************************************************************************
* Vrátí řetězec obsahující zadané názvy oddělené čárkami.
*
* @param názvy Názvy, které je třeba sloučit
* @return Výsledný řetězec ze sloučených zadaných názvů
*/
static String cm(String... názvy)
{
    String result = Arrays.stream(názvy)
        .collect(Collectors.joining(", "));
    return result;
}


//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

/** Soukromý konstruktor zabraňující vytvoření instance.*/
private Texts() {}


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED








}
