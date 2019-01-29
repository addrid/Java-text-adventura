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
*  Vytvoří instanci akce pro zavření h-objektu, který je možno otevřít/zavřít
*  (po zkontrolování definovaných podmínek)
*  a po otevření se stane aktuálním prostorem.
 * 
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoClose extends PostapoAAction
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
     * Vytvoří novou instanci příkazu zavři
     */
    PostapoClose()
    {
       super (Texts.pZAVRI,
            "Ověří, že hráč chce opravdu zavřít otevíratelný h-objekt,\n"
            + "zadaný jako parametr příkazu.\n"
            );
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
    * Zavře zadaný h-objekt a přesune hráče jako do prostoru,
    * v němž je zavíraný h-objekt umístěn.
    * Před tím však zkontroluje,
    * <ul>
    * <li>zda je zadán h-objekt, který se má otevřít,</li>
    * <li>zda je tento h-objekt truhla,</li>
    * <li>zda je truhla aktuálním prostorem.</li>
    * </ul>
    *
    * @param parametry Jediným povoleným parametrem je truhla
    * @return Text zprávy vypsané po provedeni příkazu
    */
    @Override
    public String execute(String... arguments)
    {
       if (arguments.length < 2) {
       return Texts.zNEVIM_CO_ZAVRIT;
       }
       String roomName = arguments[1];
       PostapoWorld world = PostapoWorld.getInstance();
       PostapoArea currentRoom = world.getCurrentArea();
       
       if (! currentRoom.getName().equalsIgnoreCase(roomName)) {
            return Texts.zNENI_AKTUALNIM_PROSTOREM;
       }
       if (! roomName.equalsIgnoreCase(Texts.TRUHLA)) {
            return Texts.zZAVRIT_LZE_JEN_TRUHLU;
       }
       PostapoArea newCurrent = world.getOArea(Texts.VEZ).get();
       PostapoWorld.getInstance().setCurrentArea(newCurrent);
       return Texts.zZAVREL_TRUHLU;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
