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
 * Instance třídy {@code PostapoPutDown} zpracovávají příkazy, které
 * obstárávají položení objektu
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
class PostapoPutDown extends PostapoAAction
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================

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
    PostapoPutDown()
    {
       super (Texts.pPOLOZ,
              "Přesune zadaný h-objekt z batohu do aktuálního prostoru.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

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
            return zNEVIM_CO_POLOZIT;
        }
        String itemName         = arguments[1];
        PostapoBag inventory = PostapoBag.getInstance();
        Optional<PostapoItem> oItem = inventory.getOItem(itemName);
        PostapoArea currentArea = PostapoWorld.getInstance().getCurrentArea();
        
        if (itemName.equalsIgnoreCase(VSE)){
            for (PostapoItem item : inventory.getItems()){
                currentArea.addItem(item);
            }
            
            inventory.removeAllItems();
            return zPOLOZ_VSE;
        }
        
        if (! oItem.isPresent()) {
            return Texts.zNENI_V_BATOHU;
        }
        
        PostapoItem item = oItem.get();
        inventory.removeItem(item);
        currentArea.addItem(item);
        return zPOLOZENO + item.getName();
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
