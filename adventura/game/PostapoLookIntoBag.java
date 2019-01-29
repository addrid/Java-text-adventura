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
 * Instance třídy {@code PostapoLookIntoBag} zpracovávají příkazy, které
 * umožnují uživateli nahlédnout do svého batohu.
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoLookIntoBag extends PostapoAAction
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
    PostapoLookIntoBag()
    {
       super (pBATOH ,
       "Metoda vypíše uživateli všechny předměty v batohu");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání příkazu batoh.
     * 
     * @param arguments Bezparametrický příkaz
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 1) {
            return Texts. zNEZNAMY_PRIKAZ;
        }
        PostapoBag bag = PostapoBag.getInstance();
        Collection<PostapoItem> items = bag.getItems();
        
        String result = items.stream()
                       .map(item -> item.getName())
                       .collect(Collectors.joining("\n", 
                                zPREDMETY_BATOH, ""));
        
        if(PostapoState.isBottleFull()){
            result += "\n(voda v láhvi)";
        }
        
        if(PostapoState.gotWood()){
            result += "\n(drevo)";
        }
                
        return result;
        
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
