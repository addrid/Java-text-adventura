/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package postapocalyptic.navd00_navratil.adventura.game;

import eu.pedu.adv15p_fw.game_txt.INamed;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import static postapocalyptic.navd00_navratil.adventura.game.Texts.*;



/*******************************************************************************
 * Instance třídy {@code PostapoHome} zpracovávají příkazy, které
 * umožnují uživateli vrátit se do počátečního prostoru v jednom kroku
 * 
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoHome extends PostapoAAction
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
     * Vytvoří novou instanci daného příkazu.
     */
    PostapoHome()
    {
       super (pDOMU ,
       "Metoda přesune uživatele do počáteční oblasti.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání příkazu domů.
     *      *
     * @param arguments Parametry příkazu;
     *                  v tomto případě se jedná o bezparametrický příkaz.
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 1) {
            return Texts. zNEZNAMY_PRIKAZ;
        }
        
        String destinationName = arguments[1];//"osada";
        
        Optional<PostapoArea> oDestination = INamed.getO(destinationName,
        PostapoWorld.getInstance().getAllAreas());
            
        /*if (! oDestination.isPresent()) {
            return Texts.zNENI_SOUSEDEM;
        }*/
        
        if (! PostapoState.isGateUnlocked() && destinationName.equals(VEZ)) {
            return Texts.zZAMCENO;
        }
        if (! PostapoState.isCoatOn() && destinationName.equals(KOPEC)) {
            return Texts.zZIMA;
        }
        
        PostapoArea destinationArea = oDestination.get();
        PostapoWorld.getInstance().setCurrentArea(destinationArea);
        return Texts.zPRESUN + destinationArea.getName();
        
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
