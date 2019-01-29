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
 * Instance třídy {@code PostapoPickUp} zpracovávají příkazy, které
 * obstárávají zvednutí objektu.
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
class PostapoPickUp extends PostapoAAction
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
     * Vytvoří novou instanci daného příkazu.
     */
    PostapoPickUp()
    {
       super (Texts.pVEZMI ,
       "Přesune zadaný h-objekt z aktuálního prostoru do batohu.\\n"
       + "Přesouvá přitom pouze přenositelné předměty.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
    * Odebere h-objekt zadaný v parametru z aktuálního prostoru (místnosti)
    * a vloží jej do batohu.
    * Vyžaduje však, aby se h-objekt se zadaným názvem<br>
    * a) nacházel v aktuálním prostoru,<br>
    * b) byl zvednutelný a<br>
    * c) vešel se do batohu.<br>
    * Jinak přesun neprovede a bude příkaz považovat za chybný.
    *
    * @param arguments Parametry příkazu
    * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        
        if (arguments.length < 2) {
            return zH_OBJEKT_NEZADAN;
        }
        
        String itemName         = arguments[1];
        PostapoBag backpack     = PostapoBag.getInstance();
        PostapoArea currentArea = PostapoWorld.getInstance().getCurrentArea();
        Optional<PostapoItem> oItem = currentArea.getOItem(itemName);
        
        if (! oItem.isPresent()) {
          return Texts.zNENI_V_MISTNOSTI;
        }
        PostapoItem item = oItem.get();
        
        if (item.getWeight() > backpack.getCapacity())
            return Texts.zTEZKY_H_OBJEKT;
        
        boolean added = backpack.tryAddItem(item);
        if (added){
            if (currentArea.equals(PostapoWorld.getInstance()
                                  .getOArea(Texts.TRUHLA)
                                  .get()) &&
                ! PostapoState.isHuman())
            {
                //bag.removeItem(item);
                //return Conversation.start(item);
                
            }
        
            currentArea.removeItem(item);
            return Texts.zZVEDNUTO + itemName;
        }
        else {
            return Texts.zBATOH_PLNY;
        }
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================

}





