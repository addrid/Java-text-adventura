/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package postapocalyptic.navd00_navratil.adventura.game;

import eu.pedu.adv15p_fw.game_txt.IGSMFactory;
import eu.pedu.adv15p_fw.scenario.AScenarioManager;
import eu.pedu.adv15p_fw.scenario.ScenarioStep;
import eu.pedu.adv15p_fw.scenario.TypeOfScenario;
import postapocalyptic.navd00_navratil.adventura.PostapoGSMFactory;

import static eu.pedu.adv15p_fw.scenario.TypeOfStep.*;
import java.util.Collection;
import static postapocalyptic.navd00_navratil.adventura.game.Texts.*;



/*******************************************************************************
 * Instance třídy {@code PostapoSM} slouží jako
 * šablona (nebo chcete-li kostra) správce scénářů, jejichž prostřednictvím
 * budou testovací programy prověřovat správnou funkci plánované hry.
 * <p>
 * Jednotlivé scénáře jsou iterovatelné a "streamovatelné" posloupností kroků
 * specifikovaných instancemi třídy
 * {@link eu.pedu.adv15p_fw.scenario.ScenarioStep}
 * z frameworku, do nějž je třeba vyvíjenou hru hra začlenit.
 * <p>
 * Správce scénářů je jedináček, který má na starosti všechny scénáře
 * týkající se s ním sdružené hry.
 * <p>
 * Jednotlivé spravované scénáře se musí lišit svým názvem,
 * přičemž názvy základního úspěšného a základního chybového scénáře
 * jsou předem pevně dány a není je možno změnit.
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
public class PostapoSM extends AScenarioManager
                               implements PostapoAuthor
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Tovární třída, jejíž instancemi jsou tovární objekty poskytující
     *  instanci správce scénářů i hry, jejíž scénáře daný správce spravuje. */
    private final static Class<? extends IGSMFactory> FACTORY_CLASS =
                                                      PostapoGSMFactory.class;
    private static final String REQUIRED_STEPS_SCENARIO_NAME = "REQUIRED";
    private static final String TEST_NAME = "TEST";
    
    
    
    /***************************************************************************
     * Počáteční krok hry, který je pro všechny scénáře shodný.
     * <p>
     * Konstruktor plnohodnotné instance třídy {@link ScenarioStep}
     * vyžaduje následující parametry:
     <pre> {@code
        TypeOfStep typeOfStep; //Typ daného kroku scénáře
        String     command;    //Příkaz realizující tento krok scénáře
        String     message;    //Zpráva vypsaná po zadání příkazu
        String     area;       //Prostor, v němž skončí hráč po zadání příkazu
        String[]   neighbors;  //Sousedé aktuálního prostoru (= východy)
        String[]   items;      //Objekty vyskytující se v daném prostoru
        String[]   bag;        //Aktuální obsah batohu
     }</pre>
     =======================================================================<br>
     * Kroky scénáře musejí navíc vyhovovat následujícím požadavkům:
     * <ul>
     *   <li>Žádná z položek nesmí obsahovat prázdný odkaz.</li>
     *   <li>S výjimkou položky {@code command} nesmí být žádný řetězec
     *     prázdný (tj. {@code ""})</li>
     *   <li>Prázdný řetězec se nesmí objevit ani jako položka některého
     *     z vektorů {@code neighbors}, {@code items} či {@code bag}</li>
     * </ul>
     * <br>
     **************************************************************************/
     public static final ScenarioStep START_STEP =
        new ScenarioStep(0, tsSTART, "", //Název spouštěcího příkazu = ""
            zUVITANI
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK, LAHEV},
            new String[] { }
        );


    /***************************************************************************
     * Kroky základního úspěšného scénáře
     * popisující očekávatelný úspěšný průběh hry.
     * Z těchto kroků sestavený scénář nemusí být nutně nejkratším možným
     * (takže to vlastně ani nemusí být základní úspěšný scénář),
     * ale musí vyhovovat všem okrajovým podmínkám zadání,
     * tj. musí obsahovat minimální počet kroků,
     * projít požadovaný.minimální počet prostorů
     * a demonstrovat použití všech požadovaných příkazů.
     */
    private static final ScenarioStep[] HAPPY_SCENARIO_STEPS =
    {
        START_STEP,
        new ScenarioStep(tsPICK_UP, pVEZMI + " " + LAHEV,
            zZVEDNUTO + LAHEV
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + RUINY,
            zPRESUN + RUINY
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY, NUZ },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsPICK_UP, pVEZMI + " " + NUZ,
            zZVEDNUTO + NUZ
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY },
            new String[] { LAHEV, NUZ }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + VSTUP,
            zPRESUN + VSTUP
            ,
            VSTUP,
            new String[] { RUINY, LES, UDOLI },
            new String[] { ZPRAVA, KABAT },
            new String[] { LAHEV, NUZ }
        ),
        new ScenarioStep(tsPICK_UP, pVEZMI + " " + KABAT,
            zZVEDNUTO + KABAT
            ,
            VSTUP,
            new String[] { RUINY, LES, UDOLI },
            new String[] { ZPRAVA },
            new String[] { LAHEV, NUZ, KABAT }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + UDOLI,
            zPRESUN + UDOLI
            ,
            UDOLI,
            new String[] { VSTUP, JESKYNE },
            new String[] { ZNACKA },
            new String[] { LAHEV, NUZ, KABAT }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + JESKYNE,
            zPRESUN + JESKYNE
            ,
            JESKYNE,
            new String[] { UDOLI, STEZKA },
            new String[] { VODA, BALVAN },
            new String[] { LAHEV, NUZ, KABAT }
        ),/*
        new ScenarioStep(tsPICK_UP, pVEZMI + " " + VODA,
            zZVEDNUTO + VODA
            ,
            JESKYNE,
            new String[] { UDOLI, STEZKA },
            new String[] { BALVAN },
            new String[] { NUZ, LAHEV, VODA, KABAT }
        ),*/
        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ + " " + LAHEV + " " + VODA,
            zCHCE_POUZIT + LAHEV + " na " + VODA
            ,
            JESKYNE,
            new String[] { UDOLI, STEZKA },
            new String[] { VODA, BALVAN },
            new String[] { NUZ, LAHEV, KABAT }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + STEZKA,
            zPRESUN + STEZKA
            ,
            STEZKA,
            new String[] { JESKYNE, KOPEC,},
            new String[] { DENIK },
            new String[] { NUZ, LAHEV, KABAT }
        ),
        new ScenarioStep(tsNON_STANDARD1, pNASAD + " " + KABAT,
            zNASADIL + KABAT
            ,
            STEZKA,
            new String[] { JESKYNE, KOPEC,},
            new String[] { DENIK },
            new String[] { NUZ, LAHEV }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + KOPEC,
            zPRESUN + KOPEC
            ,
            KOPEC,
            new String[] { VRCHOLEK, LES, STEZKA},
            new String[] { ROZCESTNIK },
            new String[] { NUZ, LAHEV }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + LES,
            zPRESUN + LES
            ,
            LES,
            new String[] { VSTUP, KOPEC,},
            new String[] { DREVO },
            new String[] { NUZ, LAHEV }
        ),
        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ + " " + NUZ +" " + DREVO, 
            zCHCE_POUZIT + NUZ + " na " + DREVO
            ,
            LES,
            new String[] { VSTUP, KOPEC,},
            new String[] { DREVO },
            new String[] { NUZ, LAHEV }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + KOPEC,
            zPRESUN + KOPEC
            ,
            KOPEC,
            new String[] { VRCHOLEK, LES, STEZKA},
            new String[] { ROZCESTNIK },
            new String[] { NUZ, LAHEV }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + VRCHOLEK,
            zPRESUN + VRCHOLEK
            ,
            VRCHOLEK,
            new String[] { KOPEC, VEZ,},
            new String[] { BRANA },
            new String[] { NUZ, LAHEV }
        ),
        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ + " " + NUZ + " " + BRANA,
            zBRANA_ODEMCENA
            ,
            VRCHOLEK,
            new String[] { KOPEC, VEZ,},
            new String[] { BRANA },
            new String[] { NUZ, LAHEV }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + VEZ,
            zPRESUN + VEZ
            ,
            VEZ,
            new String[] { VRCHOLEK },
            new String[] { TRUHLA },
            new String[] { NUZ, LAHEV }
        ),
        new ScenarioStep(tsNON_STANDARD1, pOTEVRI + " " + TRUHLA,
            zOTEVREL
            ,
            TRUHLA,
            new String[] { VEZ },
            new String[] { KONZERVY },
            new String[] { NUZ, LAHEV }
        ),
        new ScenarioStep(tsPICK_UP, pVEZMI + " " + KONZERVY,
            zZVEDNUTO + KONZERVY
            ,
            TRUHLA,
            new String[] { VEZ },
            new String[] { },
            new String[] { NUZ, LAHEV, KONZERVY }
        ),
        new ScenarioStep(tsNON_STANDARD1, pZAVRI + " " + TRUHLA,
            zZAVREL_TRUHLU
            ,
            VEZ,
            new String[] { VRCHOLEK },
            new String[] { TRUHLA },
            new String[] { NUZ, LAHEV, KONZERVY }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + VRCHOLEK,
            zPRESUN + VRCHOLEK
            ,
            VRCHOLEK,
            new String[] { KOPEC, VEZ,},
            new String[] { BRANA },
            new String[] { NUZ, LAHEV, KONZERVY }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + KOPEC,
            zPRESUN + KOPEC
            ,
            KOPEC,
            new String[] { VRCHOLEK, LES, STEZKA},
            new String[] { ROZCESTNIK },
            new String[] { NUZ, LAHEV, KONZERVY }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + LES,
            zPRESUN + LES
            ,
            LES,
            new String[] { VSTUP, KOPEC,},
            new String[] { DREVO },
            new String[] { NUZ, LAHEV, KONZERVY }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + VSTUP,
            zPRESUN + VSTUP
            ,
            VSTUP,
            new String[] { RUINY, LES, UDOLI },
            new String[] { ZPRAVA },
            new String[] { NUZ, LAHEV, KONZERVY }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + RUINY,
            zPRESUN + RUINY
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY },
            new String[] { NUZ, LAHEV, KONZERVY }
        ),
        new ScenarioStep(tsPUT_DOWN, pPOLOZ + " " + NUZ,
            zPOLOZENO + NUZ
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY, NUZ},
            new String[] { LAHEV, KONZERVY }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + OSADA,
            zPRESUN + OSADA
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK },
            new String[] { LAHEV, KONZERVY }
        ),
        /*
        new ScenarioStep(tsNON_STANDARD0, "spat",
            zSPAT
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK },
            new String[] { NUZ, KONZERVY, LAHEV }
        ),
        new ScenarioStep(tsNON_STANDARD0, "cas",
            "Prave je xy hodin"
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK, LAHEV, KONZERVY },
            new String[] { NUZ }
        ),
        new ScenarioStep(tsNON_STANDARD0, "prohledat",
            "Prohledal si prostor"
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK, LAHEV, KONZERVY },
            new String[] { NUZ }
        ),
        new ScenarioStep(tsNON_STANDARD0, "promluv",
            "Promluvil si"
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK, LAHEV, KONZERVY },
            new String[] { NUZ }
        ),*/
        new ScenarioStep(tsEND, pKONEC,
            zKONEC
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK },
            new String[] { LAHEV, KONZERVY }
        ),
    };


    /** Krok testující špatné spuštění hry je definován zvlášť,
     *  aby bylo možno správně nastavit indexy následujících kroků. */
    private static final ScenarioStep WRONG_START =
    new ScenarioStep(-1,
            tsNOT_START, "start",
            zNENI_START
            ,
            "",
            new String[] {},
            new String[] {},
            new String[] {}
        );


    static { ScenarioStep.setIndex(1); }


    /***************************************************************************
     * Základní chybový scénář definující reakce
     * na povinnou sadu typů chybně zadaných příkazů.
     */
    private static final ScenarioStep[] MISTAKE_SCENARIO_STEPS =
    {
        WRONG_START,

        START_STEP,
        new ScenarioStep(tsUNKNOWN, "maso",
            zNEZNAMY_PRIKAZ
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK, LAHEV },
            new String[] {}
        )
        ,
        new ScenarioStep(tsEMPTY, "",
            zPRAZDNY_PRIKAZ
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK, LAHEV },
            new String[] {}
        ),
       
        new ScenarioStep(tsPICK_UP, pVEZMI + " " + LAHEV,
            zZVEDNUTO + LAHEV
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + RUINY,
            zPRESUN + RUINY
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY, NUZ },
            new String[] { LAHEV }
        ),
        
        new ScenarioStep(tsBAD_NEIGHBOR, pJDI + " " + KOPEC,
            zNENI_SOUSEDEM
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY, NUZ },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsBAD_ITEM, pVEZMI + " " + KONZERVY,
            zNENI_V_MISTNOSTI
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY, NUZ },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsUNMOVABLE, pVEZMI + " " + ZRANENY,
            zTEZKY_H_OBJEKT
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY, NUZ },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsNOT_IN_BAG, pPOLOZ + " " + NUZ,
            zNENI_V_BATOHU
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY, NUZ },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsNON_STANDARD1, pDOMU + " " + JESKYNE,
            zPRESUN + JESKYNE
            ,
            JESKYNE,
            new String[] { UDOLI, STEZKA },
            new String[] { VODA, BALVAN },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsBAG_FULL, pVEZMI + " " + BALVAN,
            zBATOH_PLNY
            ,
            JESKYNE,
            new String[] { UDOLI, STEZKA },
            new String[] { VODA, BALVAN },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsPUT_DOWN_WA , pPOLOZ,
            zNEVIM_CO_POLOZIT
            ,
            JESKYNE,
            new String[] { UDOLI, STEZKA },
            new String[] { VODA, BALVAN },
            new String[] { LAHEV }
        ),
         new ScenarioStep(tsMOVE_WA, pJDI,
            zCIL_NEZADAN
            ,
            JESKYNE,
            new String[] { UDOLI, STEZKA },
            new String[] { VODA, BALVAN },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsPICK_UP_WA, pVEZMI,
            zH_OBJEKT_NEZADAN
            ,
            JESKYNE,
            new String[] { UDOLI, STEZKA },
            new String[] { VODA, BALVAN },
            new String[] { LAHEV }
        ),
        
        
        new ScenarioStep(tsHELP, pHELP,
            zNAPOVEDA
            ,
            JESKYNE,
            new String[] { UDOLI, STEZKA },
            new String[] { VODA, BALVAN },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsEND, pKONEC,
            zKONEC
            ,
            JESKYNE,
            new String[] { UDOLI, STEZKA },
            new String[] { VODA, BALVAN },
            new String[] { LAHEV }
        ),   
    };
    
    static { ScenarioStep.setIndex(1); }
    
    private static final ScenarioStep[] REQUIRED_STEPS =
    {
        START_STEP,
        new ScenarioStep(tsHELP, pHELP,
            zNAPOVEDA
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK, LAHEV },
            new String[] { }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + RUINY,
            zPRESUN + RUINY
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY, NUZ },
            new String[] { }
        ),
        new ScenarioStep(tsPICK_UP, pVEZMI + " " + NUZ,
            zZVEDNUTO + NUZ
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY },
            new String[] { NUZ }
        ),
        new ScenarioStep(tsPUT_DOWN, pPOLOZ + " " + NUZ,
            zPOLOZENO + NUZ
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY, NUZ },
            new String[] {  }
        ),
        new ScenarioStep(tsEND, pKONEC,
            zKONEC
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY, NUZ },
            new String[] { }
        ),  
        
    };
    
    static { ScenarioStep.setIndex(1); }
    
    private static final ScenarioStep[] TEST_STEPS =
    {
        START_STEP,
        new ScenarioStep(tsHELP, pHELP,
            zNAPOVEDA
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK, LAHEV },
            new String[] { }
        ),
        new ScenarioStep(tsPICK_UP, pVEZMI + " " + LAHEV,
            zZVEDNUTO + LAHEV
            ,
            OSADA,
            new String[] { RUINY },
            new String[] { VUDCE, POSKOK },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + RUINY,
            zPRESUN + RUINY
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY, NUZ },
            new String[] { LAHEV }
        ),
        new ScenarioStep(tsPICK_UP, pVEZMI + " " + NUZ,
            zZVEDNUTO + NUZ
            ,
            RUINY,
            new String[] { OSADA, VSTUP },
            new String[] { ZRANENY,  },
            new String[] { LAHEV, NUZ }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + VSTUP,
            zPRESUN + VSTUP
            ,
            VSTUP,
            new String[] { RUINY, LES, UDOLI },
            new String[] { ZPRAVA, KABAT },
            new String[] { LAHEV, NUZ }
        ),
        
        new ScenarioStep(tsPICK_UP, pVEZMI + " " + KABAT,
            zZVEDNUTO + KABAT
            ,
            VSTUP,
            new String[] { RUINY, LES, UDOLI},
            new String[] { ZPRAVA },
            new String[] { LAHEV, NUZ, KABAT }
        ),
        new ScenarioStep(tsNON_STANDARD1, pNASAD + " " + KABAT,
            zNASADIL + KABAT
            ,
            VSTUP,
            new String[] { RUINY, LES, UDOLI},
            new String[] { ZPRAVA },
            new String[] { LAHEV, NUZ }
        ),
        new ScenarioStep(tsNON_STANDARD1, pPRECTI + " " + ZPRAVA,
            zNAPSANO_ZPRAVA
            ,
            VSTUP,
            new String[] { RUINY, LES, UDOLI },
            new String[] { ZPRAVA },
            new String[] { LAHEV, NUZ }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + LES,
            zPRESUN + LES
            ,
            LES,
            new String[] { VSTUP, KOPEC },
            new String[] { DREVO },
            new String[] { LAHEV, NUZ  }
        ),
        new ScenarioStep(tsBAD_NEIGHBOR, pJDI + " " + RUINY,
            zNENI_SOUSEDEM
            ,
            LES,
            new String[] { VSTUP, KOPEC },
            new String[] { DREVO },
            new String[] { LAHEV, NUZ }
        ),
        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ + " " + NUZ + " " + DREVO,
            zCHCE_POUZIT + NUZ + " na " + DREVO
            ,
            LES,
            new String[] { VSTUP, KOPEC },
            new String[] { DREVO },
            new String[] { LAHEV, NUZ }
        ),
        
        new ScenarioStep(tsMOVE, pJDI + " " + KOPEC,
            zPRESUN + KOPEC
            ,
            KOPEC,
            new String[] { LES, VRCHOLEK, STEZKA },
            new String[] { ROZCESTNIK },
            new String[] { LAHEV, NUZ }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + VRCHOLEK,
            zPRESUN + VRCHOLEK
            ,
            VRCHOLEK,
            new String[] { KOPEC, VEZ },
            new String[] { BRANA },
            new String[] { LAHEV, NUZ }
        ),
        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ + " " + NUZ + " " + BRANA,
            zBRANA_ODEMCENA
            ,
            VRCHOLEK,
            new String[] { KOPEC, VEZ },
            new String[] { BRANA },
            new String[] { LAHEV, NUZ }
        ),
        new ScenarioStep(tsMOVE, pJDI + " " + VEZ,
            zPRESUN + VEZ
            ,
            VEZ,
            new String[] { VRCHOLEK },
            new String[] { TRUHLA },
            new String[] { LAHEV, NUZ }
        ),
        new ScenarioStep(tsNON_STANDARD1, pOTEVRI + " " + TRUHLA,
            zOTEVREL
            ,
            TRUHLA,
            new String[] { VEZ },
            new String[] { KONZERVY },
            new String[] { LAHEV, NUZ }
        ),
        /*new ScenarioStep(tsNON_STANDARD0, pROZHLEDNOUT,
            zSPAT
            ,
            KOPEC,
            new String[] { LES, VRCHOLEK, STEZKA },
            new String[] { ROZCESTNIK, NUZ },
            new String[] { LAHEV }
        ),*/
        new ScenarioStep(tsPICK_UP, pVEZMI + " " + KONZERVY,
            zZVEDNUTO + KONZERVY
            ,
            TRUHLA,
            new String[] { VEZ },
            new String[] { },
            new String[] { LAHEV, NUZ, KONZERVY }
        ),
        new ScenarioStep(tsNON_STANDARD1, pZAVRI + " " + TRUHLA,
            zZAVREL_TRUHLU
            ,
            VEZ,
            new String[] { VRCHOLEK },
            new String[] { TRUHLA },
            new String[] { LAHEV, NUZ, KONZERVY }
        ),
        
        new ScenarioStep(tsEND, pKONEC,
            zKONEC
            ,
            VEZ,
            new String[] { VRCHOLEK },
            new String[] { TRUHLA },
            new String[] { LAHEV, NUZ, KONZERVY }
        ),  
        
    };
       
    
    
    /** Jediná instance této třídy. Spravuje všechny scénáře sdružené hry. */
    private static final PostapoSM MANAGER =
                                          new PostapoSM();



//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================

    /***************************************************************************
     * Statický konstruktor je před definicí konstanty MISTAKE_SCENARIO_STEPS
     * Takováto inicializace by měla být před každou další konstantou
     * definující kroky dalšího scénáře.
     */



//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vrátí správce scénářů - jedinou instanci této třídy.
     *
     * @return Správce scénářů
     */
    public static PostapoSM getInstance()
    {
        return MANAGER;
    }


    /***************************************************************************
     * Vytvoří instanci představující správce scénářů hry.
     * V rámci konstruktoru je vhodné vytvořit všechny scénáře
     * a správce scénářů poté zalepit.
     * <p>
     * Jednotlivé spravované scénáře se musí lišit svým názvem,
     * přičemž názvy základního úspěšného a základního chybového scénáře
     * jsou předem pevně dány a není je možno změnit.
     * Jim zadávané názvy jsou proto pouze formální, protože
     * jim volaná metoda stejně přiřadí ty předem definované.
     * <p>
     *´Kontrakt metody
     * {@link #addScenario(String, TypeOfScenario, ScenarioStep...) }
     * vyžaduje, aby byl jak první přidán úspěšný scénář, tj. scénář typu
     * {@link TypeOfScenario.scHAPPY}, a jako druhý chybový scénář,
     * tj. scénář typu {@link MISTAKE_SCENARIO_NAME}.
     * Na pořadí následně přidávaných scénářů nezáleží.
      */
    private PostapoSM()
    {
        super(FACTORY_CLASS);

        addScenario(HAPPY_SCENARIO_NAME,
                    TypeOfScenario.scHAPPY,    HAPPY_SCENARIO_STEPS);
        addScenario(MISTAKE_SCENARIO_NAME,
                    TypeOfScenario.scMISTAKES, MISTAKE_SCENARIO_STEPS);
        addScenario(REQUIRED_STEPS_SCENARIO_NAME,
                    TypeOfScenario.scGENERAL, REQUIRED_STEPS);
        addScenario(TEST_NAME,
                    TypeOfScenario.scGENERAL, TEST_STEPS);
        seal();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================



//##############################################################################
//== TEST METHODS AND CLASSES ==================================================

    /***************************************************************************
     * Metoda prověřující daného správce scénářů
     * či hru definovanou scénáři tohoto správce.
     * <p>
     * U správce scénářů se prověřuje, zda vyhovuje zadaným okrajovým podmínkám,
     * tj. jestli:
     * <ul>
     *   <li>Umí vrátit správně naformátované jméno autora/autorky hry
     *       a jeho/její ID.</li>
     *   <li>Definuje základní úspěšný a základní chybový scénář.</li>
     *   <li>Základní chybový scénář má následující vlastnosti:
     *     <ul>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Minimální požadovaný počet kroků</li>
     *       <li>Minimální počet navštívených prostorů</li>
     *       <li>Minimální počet "zahlédnutých" prostorů</li>
     *       <li>Minimální počet vlastních (nepovinných) akcí</li>
     *       <li>Použití příkazů pro přechod z prostoru do prostoru
     *         zvednutí nějakého objektu a položení nějakého objektu</li>
     *       <li>Křížová konzistence příkazů a stavů po jejich zadání</li>
     *     </ul>
     *   </li>
     *   <li>Základní chybový scénář má následující vlastnosti:
     *     <ul>
     *       <li>Chybné odstartování příkazem,
     *           jehož název není prázdný řetězec</li>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Použití všech povinných chybových typů kroku definovaných
     *         ve třídě<br>
     *         {@link eu.pedu.adv15p_fw.scenario.TypeOfStep}</li>
     *       <li>Vyvolání nápovědy</li>
     *       <li>Ukončení příkazem pro nestandardní ukončení hry</li>
     *     </ul>
     *   </li>
     * </ul>
     * <p>
     * U hry se prověřuje, zda je možno ji zahrát přesně tak,
     * jak je naplánováno ve scénářích.
     *
     * @param args Parametry příkazového řádku - nepoužívané.
     */
    public static void main(String[] args)
    {
        //Otestuje, zda správce scénářů a jeho scénáře vyhovují požadavkům
//        MANAGER.autoTest();

        //Vypíše na standardní výstup simulovaný průběh hry
        //odehrané podle základního úspěšného scénáře
//      MANAGER.getHappyScenario().simulate();

        //Testování hry prováděné postupně obou povinných scénářů,
        //přičemž základní úspěšný scénář se prochází dvakrát za sebou
        MANAGER.testGame();

        //Testování hry dle scénáře se zadaným názvem
 //       MANAGER.testGameByScenarios(TEST_NAME);

        //Odehrání hry dle scénáře se zadaným názvem
//        MANAGER.playGameByScenario("???");

        System.exit(0);
    }

}
