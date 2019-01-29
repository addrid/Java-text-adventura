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
 * Instance třídy {@code PostapoLookAround} zpracovávají příkazy, které
 * umožnují uživateli rozhlédnout se po okolí a zjistit tak, co se v daném
 * prostoru nachází.
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoLookAround extends PostapoAAction
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
    PostapoLookAround()
    {
       super (pROZHLEDNOUT ,
       "Metoda vypíše uživateli všechny předměty v místnosti "
               + "a všechny sousední prostory.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání příkazu rozhlednout
     *      *
     * @param arguments Bezparametrický příkaz
     * @return Text zprávy vypsané po provedeni příkazu
     *              v tomto případě vypíše sousední oblasti a předměty v daném
     *              prostoru
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 1) {
            return Texts. zNEZNAMY_PRIKAZ;
        }
        //String command = arguments[0];
        PostapoArea currentArea = PostapoWorld.getInstance().getCurrentArea();
        //PostapoGame game = PostapoGame.getInstance();
        Collection<PostapoArea> neighbors = currentArea.getNeighbors();
        Collection<PostapoItem> items = currentArea.getItems();
        String result;
        switch(currentArea.getName())
        {
            case "osada"   : result = zOSADA;
                             break;
            case "ruiny"   : result = zRUINY;
                             break;
            case "vstup"   : result = zVSTUP;
                             break;
            case "udoli"   : result = zUDOLI;
                             break;
            case "jeskyne" : result = zJESKYNE;
                             break;
            case "stezka"  : result = zSTEZKA;
                             break;
            case "kopec"   : result = zKOPEC;
                              break;
            case "les"     : result = zLES;
                             break;
            case "vrcholek": result = zVRCHOLEK;
                             break;
            case "vez"     : result = zVEZ;
                             break;
            case "truhla"  : result = zTRUHLA;
                             break;
            default        : result = null;
        }
        
        result += neighbors.stream()
                                .map(neigh -> neigh.getName())
                                .collect(Collectors.joining("\n", 
                                         zSOUSEDI, ""));
        result += "\n";
        result += items.stream()
                       .map(item -> item.getName())
                       .collect(Collectors.joining("\n", 
                                zPREDMETY_PROSTOR, ""));
        return result;
        
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
