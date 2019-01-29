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
 * Instance třídy {@code PostapoMove} zpracovávají příkazy, které
 * obstárávají pohyb po světě.
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
class PostapoMove extends PostapoAAction
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
    PostapoMove()
    {
       super (pJDI ,
       "Metoda přesune hráče do sousední místnosti zadané v parametru." +
       "\nVyžaduje však, aby tato místnost byla sousedem aktuální místnosti," +
       "\nprotože jinak přesun neprovede a bude příkaz považovat za chybný");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání příkazu pro přesun.
     * Počet parametrů je závislý na konkrétním příkazu
     *
     * @param arguments Parametry příkazu;
     *                  očekává se 1 parametr = cílová destinace (prostor)
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return Texts. zCIL_NEZADAN;
        }
        String destinationName = arguments[1];
        PostapoArea currentArea = PostapoWorld.getInstance().getCurrentArea();
        
        Optional<PostapoArea> oDestination = INamed.getO(destinationName,
        currentArea.getNeighbors());
        
        if (! oDestination.isPresent()) {
            return Texts.zNENI_SOUSEDEM;
        }
        
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
