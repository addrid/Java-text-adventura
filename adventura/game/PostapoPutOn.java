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
 * obstárávají nasazení objektu (např. kabát...)
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
class PostapoPutOn extends PostapoAAction
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
    PostapoPutOn()
    {
       super (Texts.pNASAD,
              "Nasadí daný předmět.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání příkazu nasaď.
     *      *
     * @param arguments Jeden parametr = nasazovaný předmět
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return Texts.zNEVIM_CO_NASADIT;
        }
        String itemName = arguments[1];
        Optional<PostapoItem> oCoat = PostapoBag.getInstance().getOItem(itemName);
        if (! oCoat.isPresent()) {
            return Texts.zNENI_V_BATOHU + itemName;
        }
        
        if (Texts.KABAT.equalsIgnoreCase(itemName)) {
            PostapoState.setCoatOn(true);
            PostapoBag.getInstance().removeItem(oCoat.get());
            return Texts.zNASADIL + itemName;
        }
        else {
            return Texts.zNELZE_NASADIT + itemName;
        }
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
