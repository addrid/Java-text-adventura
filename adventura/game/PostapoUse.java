/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package postapocalyptic.navd00_navratil.adventura.game;

import eu.pedu.adv15p_fw.game_txt.INamed;
import eu.pedu.adv15p_fw.scenario.TypeOfStep;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import static postapocalyptic.navd00_navratil.adventura.game.Texts.*;



/*******************************************************************************
 * Instance třídy {@code PostapoPutOn} zpracovávají příkazy, které
 * obstárávají nasazení objektu (např. brýle, kabát...)
 * <p>
 * Instance tříd akcí jsou efektivně jedináčci,
 * ale není třeba to v definici třídy explicitně zabezpečovat, protože vytvoření
 * a následnou správu všech akcí má starosti k tomu definovaný správce,
 * který zabezpečí, aby od každé třídy akce vznikla pouze jediná instance.
 * </p>
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoUse extends PostapoAAction
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================

    PostapoBag bag = new PostapoBag();

//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vytvoří instanci akce pro
     * odebrání h-objektu z batohu a jeho vložení do aktuálního prostoru.
     */
    PostapoUse()
    {
       super (pPOUZIJ,
              "Použije první uvedený předmět na druhý.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS =============================================

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání daného příkazu.
     * Počet parametrů je závislý na konkrétním příkazu,
     * např. příkazy <i>konec</i> a <i>nápověda</i> nemají parametry,
     * příkazy <i>jdi</i> a <i>seber</i> mají jeden parametr
     * příkaz <i>použij</i> muže mít dva parametry atd.
     *
     * @param arguments Parametry příkazu;
     *                  jejich počet muže byt pro každý příkaz jiný
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return  zNEVIM_CO_POUZIT;
        }
        
        if (arguments.length < 3) {
            return  zNEVIM_NA_CO_POUZIT;
        }
        String firstItem = arguments[1];
        String secondItem = arguments[2];
        
        String message1 =  zCHCE_POUZIT + firstItem +
         zH_OBJEKTEM + secondItem + '.';
        String messageErr = message1 + '\n';
        PostapoArea currentRoom = PostapoWorld.getInstance().getCurrentArea();
        PostapoBag bag = PostapoBag.getInstance();
        Optional<PostapoItem> oFirstObject = bag.getOItem(firstItem);
        Optional<PostapoItem> oSecondObject = currentRoom.getOItem(secondItem);
        
        /* první parametr - předmět z batohu */
        if (! oFirstObject.isPresent()) {
            return messageErr +  zNENI_V_BATOHU + firstItem;
        }
        /* druhý parametr - předmět z prostoru */
        if (! oSecondObject.isPresent()) {
            return messageErr +  zNENI_V_MISTNOSTI + secondItem;
        }
        
        if (! LAHEV.equalsIgnoreCase(firstItem) && 
            ! NUZ.equalsIgnoreCase(firstItem)) {
            return messageErr + zNELZE_POUZIT + firstItem;
        }
        else if (! VODA.equalsIgnoreCase(secondItem) &&
                 ! DREVO.equalsIgnoreCase(secondItem) &&
                 ! BRANA.equalsIgnoreCase(secondItem) )
        {
            return messageErr + zNELZE_NA_POUZIT + secondItem;
        }
        else if (LAHEV.equalsIgnoreCase(firstItem) && 
                 VODA.equalsIgnoreCase(secondItem))
        {
            PostapoState.setBottleFull(true);
            return zCHCE_POUZIT + firstItem + " na " + secondItem;
            
        }
        else if (NUZ.equalsIgnoreCase(firstItem) && 
                 DREVO.equalsIgnoreCase(secondItem))
        {
            PostapoState.setGotWood(true);
            return zCHCE_POUZIT + firstItem + " na " + secondItem;
        }
        else if (NUZ.equalsIgnoreCase(firstItem) && 
                 BRANA.equalsIgnoreCase(secondItem))
        {
            PostapoState.setGateUnlocked(true);
            return zBRANA_ODEMCENA;
        }
        
        else
            return messageErr + zNELZE_POUZIT;
        
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
