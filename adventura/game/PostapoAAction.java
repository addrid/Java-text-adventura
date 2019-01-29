/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package postapocalyptic.navd00_navratil.adventura.game;

import eu.pedu.adv15p_fw.game_txt.IAction;
import static java.sql.DriverManager.println;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



/*******************************************************************************
 * Třída {@code PostapoAAction} je společným rodičem všech tříd, jejichž 
 * instance mají na starosti interpretaci příkazů zadávaných uživatelem 
 * hrajícím hru. Název spouštěné akce bývá většinou první slovo řádku zadávaného
 * z klávesnice a další slova pak bývají interpretována jako parametry.
 * 
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
abstract class PostapoAAction extends ANamed implements IAction
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
    
    /* Hra na počátku neběží*/
    private static boolean isAlive = false;;
    
    /** Mapa zprostředkovávající převod názvu akce na její instanci. */
    private static final Map<String, PostapoAAction> NAME_2_ACTION;
    
    private static Collection<String> nepouzitePrikazy ;
   
//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
    static {
     isAlive = false;   
     NAME_2_ACTION = new HashMap<>();
     
     new PostapoClose();
     new PostapoExit();
     new PostapoHelp();
     new PostapoHome();
     new PostapoLookAround();
     new PostapoLookIntoBag();
     new PostapoMove();
     new PostapoOpen();
     new PostapoPickUp();
     new PostapoPutDown();
     new PostapoPutOn();
     new PostapoQuest();
     new PostapoRead();
     new PostapoSleep();
     new PostapoTalk();
     new PostapoTime();
     new PostapoUse();    
    }


//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Stručný popis dané akce. */
    private final String description;



//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vytvoří rodičovský podobjekt vytvářené akce.
     *
     * @param name  Název vytvářené akce = text, který musí hráč zadat
     *              jako počáteční slovo zadávaného příkazu
     * @param description Stručný popis vytvářené akce
     */
    PostapoAAction(String name, String description)
    {
        super(name);
        this.description = description;
        PostapoAAction previous = NAME_2_ACTION.put(name.toLowerCase(), this);
        if (previous != null) {
            throw new IllegalArgumentException(
            "\nAkce s názvem «" + name + "» byla již vytvořena");
        }
    }



//== ABSTRACT METHODS ==========================================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání daného příkazu.
     * Počet parametrů je závislý na konkrétní akci,
     * např. akce typu <i>konec</i> a <i>nápověda</i> nemají parametry,
     * akce typu <i>jdi</i> a <i>seber</i> mají jeden parametr
     * akce typu <i>použij</i> muže mít dva parametry atd.
     *
     * @param arguments Parametry příkazu – akce;
     *                  jejich počet muže byt pro každou akci jiný,
     *                  ale pro všechna spuštění stejné akce je stejný
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    abstract
    public String execute(String... arguments)
    ;



//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí popis příkazu s vysvětlením jeho funkce
     * a významu jednotlivých parametru.
     *
     * @return Popis příkazu
     */
    @Override
    public String getDescription()
    {
        return description;
    }

    /***************************************************************************
    * Vrátí kolekci všech akcí použitelných ve hře.
    *
    * @return Kolekce všech akcí použitelných ve hře
    */
    static Collection<PostapoAAction> getAllActions()
    {
        Collection<PostapoAAction> collection, result;
        collection = NAME_2_ACTION.values();
        result = Collections.unmodifiableCollection(collection);
        return result;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
/***************************************************************************
     * Zpracuje zadaný příkaz a vrátí text zprávy pro uživatele.
     * Vlastní zpracování příkazu ale deleguje na správce akcí,
     * kterým je objekt třídy {@link PostapoAAction}.
     * 
     * @param command Zadávaný příkaz
     * @return Textová odpověď hry na zadaný příkaz
     */
//  @Override
    public static String executeCommand(String command)
    {
        command = command.trim();
        String answer;
        if (isAlive) {
            answer =  PostapoState.isConversation() 
                    ? Conversation.answer(command)
                    : executeCommonComand(command);
        }
        else {
            answer = startGame(command);
        }
        return answer;
    }

/***************************************************************************
     * Vrátí informaci o tom, je-li hra aktuálně spuštěná.
     * Spuštěnou hru není možno pustit znovu.
     * Chceme-li hru spustit znovu, musíme ji nejprve ukončit.
     *
     * @return Je-li hra spuštěná, vrátí {@code true},
     *         jinak vrátí {@code false}
     */
//  @Override
    public static boolean isAlive()
    {
        return isAlive;
    }
    
    
    
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
    /***************************************************************************
    * Zjistí, jaká akce má být zadaným příkazem aktivována,
    * a jedná-li se o známou akci, provede ji.
    *
    * @param command Zadávaný příkaz
    * @return Odpověď hry na zadaný příkaz
    */
    private static String executeCommonComand(String command)
    {
        if (command.isEmpty()) {
            return Texts.zPRAZDNY_PRIKAZ;
        }
        
        String[] words = command.toLowerCase().split("\\s+");
        String acttionName = words[0];
        PostapoAAction action = NAME_2_ACTION.get(acttionName);
        String answer;
        
        if (action == null) {
            answer = Texts.zNEZNAMY_PRIKAZ;
        }
        else {
            answer = action.execute(words);
        }
        return answer;
    }


 /***************************************************************************
    * Ověří, jestli je hra spouštěna správným (= prázdným) příkazem,
    * a pokud ano, spustí hru.
    *
    * @param command Příkaz spouštějící hru
    * @return Odpověď hry na zadaný příkaz
    */
    private static String startGame(String command)
    {
        String answer;
        if (command.isEmpty()) {
            initialize();
            answer = Texts.zCELE_UVITANI;
            isAlive = true;
        }
        else {
            answer = Texts.zNENI_START;
        }
        return answer;
    }
    /***************************************************************************
    * Metoda zastavující hru, která nastaví příznak isAlive na hodnotu false, 
    * vypovídající o tom, že hra není spuštěná.
    *
    */   
    
    static void stopGame()
    {
        isAlive = false;
    }
    /***************************************************************************
    * Metoda inicializující svět a batoh.
    *
    */    
    private static void initialize()
    {
        PostapoWorld.getInstance().initialize();
        PostapoBag.getInstance().initialize();
    }

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
