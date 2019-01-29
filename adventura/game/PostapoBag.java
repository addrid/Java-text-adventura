/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package postapocalyptic.navd00_navratil.adventura.game;

import eu.pedu.adv15p_fw.game_txt.IBag;
import eu.pedu.adv15p_fw.game_txt.IItem;
import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;



/*******************************************************************************
 * Instance třídy {@code PostapoBag} představuje úložiště,
 * do nějž hráči ukládají objekty sebrané v jednotlivých prostorech,
 * aby je mohli přenést do jiných prostorů a/nebo použít.
 * Úložiště má konečnou kapacitu definující maximální povolený
 * součet vah objektů vyskytujících se v úložišti.
 * <p>
 * V této hře je tímto úložištěm batoh
 * s kapacitou 5
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoBag extends AItemContainer implements IBag
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Jediná instance batohu ve hře. */
    private static final PostapoBag SINGLETON = new PostapoBag();
    
    /** Kapacita batohu */
    static final int CAPACITY = 5;
    
    /** Volná kapacita batohu */
    private int       remains = CAPACITY;
    
    /*Collection<PostapoItem> items;
    public static Collection<PostapoItem> exportedItems;*/
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
    static PostapoBag getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     * Konstruktor realizující batoh.
     * Volání konstruktoru předka.
     */
    PostapoBag()
    {
        super("Batoh");
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí kapacitu batohu, tj. maximální povolený součet vah objektů,
     * které je možno současně uložit do batohu.
     *
     * @return Kapacita batohu
     */
    @Override
    public int getCapacity()
    {
        return CAPACITY;
    }


    /***************************************************************************
     * Metoda inicializující hodnotu remains, do které na počátku přiřadí 
     * hodnotu konstanty CAPACITY.
     * A volání metody initializeItems() které vyčistí kolekci a uloží do ní 
     * objekty reprezentující předměty na počátku hry.
     */
    void initialize()
    {
        remains = CAPACITY;
        initializeItems();
        
    }
    
    /*****************************************************
    * Zkusí přidat zadaný h-objekt do batohu
    *   testuje, zda se do batohu předmět vejde
    * @param item Odebíraný h-objekt
    * @return {@code true} je-li možné předmět přidat, {@code false} není-li
    */
    public boolean tryAddItem(PostapoItem postItem)
    {
        if (postItem.getWeight() > remains) {
            return false;
        }
        
        addItem(postItem);
        remains -= postItem.getWeight();
        return true;
    }
    
    /*****************************************************
    * Odebere zadaný h-objekt ze své kolekce h-objektů.
    * a přičte váhu odebraného objektu ke zbývajícímu místu v batohu
    * @param item Odebíraný h-objekt
    */
    @Override
    void removeItem(PostapoItem postItem)
    {
       super.removeItem(postItem);
       remains += postItem.getWeight();
    }
    /*****************************************************
    * Odebere všechny předměty ze své kolekce h-objektů.
    * a nastaví volné místo na plnou kapacitu
    * 
    */
    @Override
    void removeAllItems() {
        super.removeAllItems();
        remains = CAPACITY;
    }
    
    /*****************************************************
    * Nastaví volné místo v batohu
    *  
    */
    void setRemains(int number) {
        remains = number;
    }
    /***************************************************************************
    * Vrátí informaci o tom, zda je batoh již plný,
    * anebo zda se do něj ještě něco vejde.
    *
    * @return Je-li plný, vrátí {@code true}, není-li, vrátí {@code false}
    */
    boolean isFull()
    {
        return remains == 0;
    }
    
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
