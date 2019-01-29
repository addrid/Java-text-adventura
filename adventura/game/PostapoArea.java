/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package postapocalyptic.navd00_navratil.adventura.game;
import eu.pedu.adv15p_fw.game_txt.INamed;
import eu.pedu.adv15p_fw.game_txt.IItem;
import eu.pedu.adv15p_fw.game_txt.IArea;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;



/*******************************************************************************
 * Instance třídy {@code PostapoArea} představují prostory ve hře.
 * Mezi prostory je možné přecházet pomocí příkazu jdi.
 * <p>
 * V tomto programu jsou prostory:
 * Osada, ruiny, vstup, údolí, jeskyně, stezka, kopec, les, vrcholek, věž
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoArea extends AItemContainer implements IArea
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
    
    /** Názvy sousedů prostoru na počátku hry. */
    private final String[] neighborNames;
    
    /** Aktuální sousedé daného prostoru. */
    private final Collection<PostapoArea> exportedNeighbors;
 
    /** Nezměnitelná kolekce aktuálních sousedů daného prostoru,
    * která však průběžně mapuje obsah kolekce {@link #neighbors}. */
    private final Collection<PostapoArea> neighbors;
    
    
    /*Collection<PostapoItem> exportedItems;*/
    /*Collection<PostapoItem> items;*/
    
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
     * Konstruktor třídy volající konstruktor svého předka.
     * A nastavující jednotlivé atributy podle přijatých parametrů.
     * @param name Jméno daného prostoru
     * @param neighborNames Jména sousedních prostorů daného prostoru
     * @param itemName Jména předmětů umístěných v daném prostoru
     */
    PostapoArea(String name, String[] neighborNames, String... itemNames)
    {
        super(name, itemNames);
        this.neighborNames     = neighborNames;
        this.neighbors         = new ArrayList<>();
        this.exportedNeighbors = Collections.unmodifiableCollection(neighbors);
        
        
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí kolekci sousedů daného prostoru, tj. kolekci prostorů,
     * do nichž je možno se z tohoto prostoru přesunout příkazem typu
     * {@link eu.pedu.adv15p_fw.scenario.TypeOfStep#tsMOVE
     * TypeOfStep.tsMOVE}.
     *
     * @return Kolekce sousedů
     */
    @Override
    public Collection<PostapoArea> getNeighbors()
    {
        return exportedNeighbors;
    }
    /***************************************************************************
    * Metoda inicializující daný prostor.
    * Na základě konstruktorem zapamatovaných jmen
    * inicializuje sousedy daného prostoru a přítomné h-objekty.
    */
    void initialize()
    {
        initializeItems();
        initializeNeighbors();
    }
    
    /***************************************************************************
    * Metoda inicializující sousedy daného prostoru.
    */    
    private void initializeNeighbors()
    {
        PostapoWorld world = PostapoWorld.getInstance();
        neighbors.clear();
        Arrays.stream(neighborNames)
              .map(world::getOArea)
              .map(Optional<PostapoArea>::get)
              .forEach(neighbors::add);
    }
    
    
    
    
    



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
