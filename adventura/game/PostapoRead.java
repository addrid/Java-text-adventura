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
*  Vytvoří instanci akce pro přečtení h-objektu, který je možno přečíst
*  (po zkontrolování definovaných podmínek)
 * 
 *  *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoRead extends PostapoAAction
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
    PostapoRead()
    {
       super (Texts.pPRECTI,
            "Ověří, že hráč chce opravu otevřít otevřitelný h-objekt,\n"
            + "zadaný jako parametr příkazu.\n"
            + "Otevírá-li ledničku, tak zkontroluje, je-li podložena.\n"
            + "Jsou-li všechny podmínky splněny,"
            + "přesune hráče do prostoru daného h-objektu.\n"
            + "Nebudou-li podmínky splněny, bude příkaz považovat za chybný");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

/***************************************************************************
* Přečte zadaný předmět (deník, zpráva, značka) a vypíše odpovídající hlášku.
* *
* @param parametry předměty, které chceme číst
* @return Text zprávy vypsané po provedeni příkazu
*/
    @Override
    public String execute(String... arguments)
    {
        
        if (arguments.length < 2) {
            return Texts. zNEVIM_CO_CIST;
        }
        String itemName = arguments[1];
        PostapoWorld world = PostapoWorld.getInstance();
        PostapoArea currentArea = world.getCurrentArea();
        Optional<PostapoItem> oItem = currentArea.getOItem(itemName);
            
        if (! oItem.isPresent()) {
            return Texts.zNENI_V_BATOHU + itemName;
        }
        
        if (Texts.ZNACKA.equalsIgnoreCase(itemName)) {
            return Texts.zNAPSANO_ZNACKA;
        }
        else if (Texts.ZPRAVA.equalsIgnoreCase(itemName)) {
            return Texts.zNAPSANO_ZPRAVA;
        }
        else if (Texts.DENIK.equalsIgnoreCase(itemName)) {
            return Texts.zNAPSANO_DENIK;
        }
        else if (Texts.ROZCESTNIK.equalsIgnoreCase(itemName)) {
            return Texts.zNAPSANO_ROZCESTNIK;
        }
        return Texts.zNELZE_CIST; 
        
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
