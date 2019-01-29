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
 * Instance třídy {@code PostapoSleep} zpracovávají příkazy, které
 * umožnují uživateli dohrát tuto hru. Podmínkou pro úspěšné dokončení
 * je získání předmětů dřevo, konzervy a voda (v tomto případě je nutné vodu
 * přesunout do láhve pomocí příkazu "pouzij lahev voda")
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
class PostapoSleep extends PostapoAAction
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
     * Vytvoří novou instanci příkazu Spát
     */
    PostapoSleep()
    {
       super (pSPAT ,
       "Metoda vypíše uživateli všechny předměty v místnosti "
               + "a všechny sousední prostory.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující akci po zadání příkazu Spát.
     * Tento příkaz nemá parametry.
     *
     * @param arguments Parametry příkazu;
     *                  [0] je samotný příkaz
     * @return Text reagující na pokus uživatele o to, jít spát.
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 1) {
            return Texts. zNEZNAMY_PRIKAZ;
        }
        
        PostapoBag bag = PostapoBag.getInstance();
        PostapoArea currentArea = PostapoWorld.getInstance().getCurrentArea();
        Optional<PostapoItem> oItem = bag.getOItem(KONZERVY);
        
        if(!currentArea.getName().equalsIgnoreCase(OSADA)){
            return Texts.zSPAT_OSADA;
        }
        
        if (! oItem.isPresent()) {
            return Texts.zCHYBI_KONZERVY;
        }
        if (! PostapoState.gotWood()) {
            return Texts.zCHYBI_DREVO;
        }
               
        if (!PostapoState.isBottleFull()) {
            return Texts.zCHYBI_VODA;
        }
        PostapoAAction.stopGame();
        return zSPAT;
        
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
