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
*  Vytvoří instanci akce pro otevření h-objektu, který je možno otevřít
*  (po zkontrolování definovaných podmínek)
*  a po otevření se stane aktuálním prostorem.
 * </p>
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoOpen extends PostapoAAction
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
    PostapoOpen()
    {
       super (Texts.pOTEVRI,
            "Příkaz pro otevření určitého předmětu hry\n"
            + "zadaný jako parametr příkazu (truhla).\n"
            + "Po otevření přesune hráče do prostoru daného objektu.\n"
            + "Nebudou-li podmínky splněny, bude příkaz považovat za chybný");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

/***************************************************************************
* Otevře zadaný h-objekt a přesune do něj hráče jako do nového prostoru.
* Před tím však zkontroluje,
* <ul>
* <li>zda je zadán h-objekt, který se má otevřít,</li>
* <li>zda je tento h-objekt v aktuálním prostoru,</li>
* <li>zda je tento h-objekt otevíratelný, tj. zda je současně prostorem,</li>
* </ul>
*
* @param parametry Jediným povoleným parametrem je zatím lednička
* @return Text zprávy vypsané po provedeni příkazu
*/
    @Override
    public String execute(String... arguments)
    {
        
        if (arguments.length < 2) {
            return Texts. zNEVIM_OTEVRIT;
        }
        String itemName = arguments[1];
        PostapoWorld world = PostapoWorld.getInstance();
        PostapoArea currentArea = world.getCurrentArea();
        Optional<PostapoItem> oItem = currentArea.getOItem(itemName);
            
        if (! oItem.isPresent()) {
            return Texts.zNENI_V_MISTNOSTI + itemName;
        }
        Optional<PostapoArea> oDestinationArea = world.getOArea(itemName);
        if (! oDestinationArea.isPresent()) {
            return Texts.zNEOTVIRATELNY;
            }
        
        world.setCurrentArea(oDestinationArea.get());
        return Texts.zOTEVREL;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
