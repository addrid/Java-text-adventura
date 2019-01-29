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
 * Instance třídy {@code PostapoTalk} zpracovávají příkazy, které
 * obstárávají promluvení s osobou.
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
class PostapoTalk extends PostapoAAction
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
    PostapoTalk()
    {
       super (pPROMLUV ,
       "Metoda promluví s osobou uvedenou za tímto příkazem" +
       "\nVyžaduje však, aby tato osoba byla v místnosti přítomna, protože " +
       "\njinak promluvení neprovede a bude příkaz považovat za chybný");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání příkazu promluv.
     * 
     * @param arguments Parametry příkazu;
     *                  očekává se jeden atribut = osoba
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return Texts. zOSOBA_NEZADANA;
        }
        String personName      = arguments[1];
        
        PostapoBag inventory = PostapoBag.getInstance();
        Optional<PostapoItem> oBagItem = inventory.getOItem(KONZERVY);
        
        PostapoArea currentArea = PostapoWorld.getInstance().getCurrentArea();
        Optional<PostapoItem> oItem = currentArea.getOItem(personName);
        
        if (! oItem.isPresent()) {
          return Texts.zNENI_V_MISTNOSTI;
        }
        if (personName.equalsIgnoreCase(VUDCE)){
            if (PostapoState.gotWood() && oBagItem.isPresent()){
                if(PostapoState.isBottleFull()){
                    PostapoAAction.stopGame();
                    return zDOHRANO;
                }
                return zVUDCE2;
            }
            return zVUDCE;
        } else
        if (personName.equalsIgnoreCase(POSKOK)){
            if (PostapoState.isBottleFull()){
                return zPOSKOK2;
            }
            return zPOSKOK;
        } else
        if (personName.equalsIgnoreCase(ZRANENY)){
            return zZRANENY;
        }
        else {
            return zNELZE_PROMLUVIT;
        }
           
        
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
