package postapocalyptic.navd00_navratil.adventura.game;

import eu.pedu.adv15p_fw.game_txt.IItemContainer;
import eu.pedu.adv15p_fw.game_txt.INamed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/*******************************************************************************
 * Anonymní třída {@code AItemContainer} je předek tříd Batohu a Prostorů.
 * @author Daniel Navrátil
 */
abstract class AItemContainer extends ANamed implements IItemContainer{

    /** Názvy h-objektů v prostoru na počátku hry. */
    private final String[] itemNames;
    
    /** Názvy h-objektů aktuálně přítomných v daném prostoru. */
    private final Collection<PostapoItem> items;
    
    /** Nezměnitelná kolekce h-objektů aktuálně přítomných v daném prostoru,
     * která však průběžně mapuje obsah kolekce {@link #items}. */
    private final Collection<PostapoItem> exportedItems;
    
    public AItemContainer(String name, String... itemNames) {
        super(name);
        this.itemNames         = itemNames;
        this.items             = new ArrayList<>();
        this.exportedItems     = Collections.unmodifiableCollection(items);
    }
    
    /***************************************************************************
     * Vrátí kolekci objektů nacházejících se v daném prostoru.
     *
     * @return Kolekce objektů nacházejících se v daném prostoru
     */
    public Collection<PostapoItem> getItems()
    {
        return exportedItems;
    }
    
    /*****************************************************
    * Odebere zadaný h-objekt ze své kolekce h-objektů.
    * @param item Odebíraný h-objekt
    */
    void removeItem(PostapoItem postItem)
    {
       items.remove(postItem);
    }
    /*****************************************************
    * Odebere všechny předměty ze své kolekce h-objektů.
    * 
    */
    void removeAllItems()
    {
       items.removeAll(items);
    }
    /***************************************************************************
    * Vyčistí kolekci {@link #items} a uloží do ní objekty reprezentující
    * h-objekty vyskytující se v daném prostoru na počátku hry.
    */
    protected void initializeItems()
    {
        items.clear();
        Arrays.stream(itemNames)
              .map(PostapoItem::new)
              .forEach(items::add);
        
    }
    /***************************************************************************
    * Vyčistí kolekci {@link #items} a uloží do ní objekty reprezentující
    * h-objekty vyskytující se v daném prostoru na počátku hry.
    */
    protected void addItem(PostapoItem item)
    {
        items.add(item);
    }
    /***************************************************************************
    * Vrátí objekt zabalený jako optional podle zadaného parametru
    * 
    * @return vrací předmět zabalený jako optional, tudíž povoluje i null
    */
    protected Optional<PostapoItem> getOItem(String name)
    {
        return INamed.getO(name, items);
    }
    
    
}
