/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package postapocalyptic.navd00_navratil.adventura.game;

import java.util.Collection;
import eu.pedu.adv15p_fw.game_txt.IArea;
import eu.pedu.adv15p_fw.game_txt.INamed;
import eu.pedu.adv15p_fw.game_txt.IWorld;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import static postapocalyptic.navd00_navratil.adventura.game.PostapoItem.*;
import static postapocalyptic.navd00_navratil.adventura.game.Texts.*;



/*******************************************************************************
 * Instance třídy {@code PostapoWorld} reprezentuje svět hry.
 * V dané hře musí být definována jako jedináček.
 * Má na starosti uspořádání jednotlivých prostorů a udržuje informaci o tom,
 * ve kterém z nich se hráč právě nachází.
 * Vzájemné uspořádání prostorů se může v průběhu hry měnit –
 * prostory mohou v průběhu hry získávat a ztrácet sousedy.
 * <p>
 * V této hře je světem hry postapokylapitický scénář
 * a jednotlivé prostory jsou Osada - Ruiny - Vstup - Údolí - Jeskyně - Stezka
 *                            Les - Kopec - Vrcholek - Věž
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoWorld implements IWorld
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Odkaz na jedinou instanci (jedináčka) této hry. */
    private static final PostapoWorld SINGLETON = new PostapoWorld();
    
    private final Collection<PostapoArea> areas;
    Collection<PostapoArea> exportedAreas;
    private PostapoArea currentArea;
    
    final PostapoArea startingArea;
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
     * Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
     *
     * @return Instance dané hry
     */
    static PostapoWorld getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     * Soukromý konstruktor definující jedinou instanci.
     * Protože je soukromý, musí být definován, i když má prázdné tělo.
     */
    private PostapoWorld()
    {
        areas = new ArrayList<>();
          
        
        startingArea = new PostapoArea(OSADA,
        new String[] {RUINY},
        NOT_MOVABLE+VUDCE, NOT_MOVABLE+POSKOK, 
        STANDARD+LAHEV);
        
        areas.add(startingArea);
        
        
        areas.add(new PostapoArea(RUINY,
        new String[] {OSADA, VSTUP},
        NOT_MOVABLE+ZRANENY, STANDARD+NUZ));
                
        areas.add(new PostapoArea(VSTUP,
        new String[] {RUINY, UDOLI, LES},
        NOT_MOVABLE+ZPRAVA, STANDARD+KABAT));
        
        areas.add(new PostapoArea(UDOLI,
        new String[] {VSTUP, JESKYNE},
        NOT_MOVABLE+ZNACKA));
        
        areas.add(new PostapoArea(JESKYNE,
        new String[] { UDOLI, STEZKA },
        NOT_MOVABLE+VODA, STANDARD2+BALVAN));
        
        areas.add(new PostapoArea(STEZKA,
        new String[] { JESKYNE, KOPEC },
        STANDARD+DENIK));
        
        areas.add(new PostapoArea(KOPEC,
        new String[] { STEZKA, LES, VRCHOLEK },
        NOT_MOVABLE+ROZCESTNIK));
        
        areas.add(new PostapoArea(LES,
        new String[] { KOPEC, VSTUP },
        NOT_MOVABLE+DREVO));
        
        areas.add(new PostapoArea(VRCHOLEK,
        new String[] { KOPEC, VEZ },
        NOT_MOVABLE+BRANA));
        
        areas.add(new PostapoArea(VEZ,
        new String[] { VRCHOLEK },
        NOT_MOVABLE+TRUHLA));
        
        areas.add(new PostapoArea(TRUHLA,
        new String[] { VEZ },
        STANDARD+KONZERVY));
        
        exportedAreas = Collections.unmodifiableCollection(areas);
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí kolekci odkazů na všechny prostory vystupující ve hře.
     *
     * @return Kolekce odkazů na všechny prostory vystupující ve hře
     */
    @Override
    public Collection<PostapoArea> getAllAreas()
    {
        return exportedAreas;
    }


    /***************************************************************************
     * Vrátí odkaz na aktuální prostor,
     * tj. na prostor, v němž se hráč pravé nachází.
     *
     * @return Prostor, v němž se hráč pravé nachází
     */
    @Override
    public PostapoArea getCurrentArea()
    {
        return currentArea;
    }
    /***************************************************************************
    * Metoda inicializující svět hry.
    * Nejprve inicializuje všechny prostory
    * a pak nastaví výchozí aktuální prostor.
    */
    void initialize()
    {
        areas.forEach(PostapoArea::initialize);
        currentArea = startingArea;
    }
    
    public Optional<PostapoArea> getOArea(String name)
    {
        Optional<PostapoArea> result = INamed.getO(name, areas);
        return result;
    }
    
    void setCurrentArea(PostapoArea postArea)
    {
        currentArea = postArea;
    }
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
