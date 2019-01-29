/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package postapocalyptic.navd00_navratil.adventura.game;

import eu.pedu.adv15p_fw.game_txt.IItem;



/*******************************************************************************
 * Instance třídy {@code PostapoItem} přestavují objekty v prostorech.
 * Objekty mohou být jak věci, tak i osoby či jiné skutečnosti (vůně,
 * světlo, fluidum, ...).
 * <p>
 * Některé z objektů mohou charakterizovat stav prostoru (např. je rozsvíceno),
 * jiné mohou být určeny k tomu, aby je hráč "zvednul" a získal tím nějakou
 * schopnost či možnost projít nějakým kritickým místem hry
 * (např. klíč k odemknutí dveří).
 * <p>
 * Rozhodnete-li se použít ve hře objekty, které budou obsahovat jiné objekty,
 * (truhla, stůl, ...), můžete je definovat paralelně jako zvláštní druh
 * prostoru, do kterého se "vstupuje" např. příkazem "<i>prozkoumej truhlu</i>"
 * a který se opouští např. příkazem "<i>zavři truhlu</i>".
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoItem extends ANamed implements IItem
{
//== CONSTANT CLASS ATTRIBUTES =================================================
      /** Váha nepřenositelných h-objektů. */
      private static final int HEAVY = PostapoBag.CAPACITY + 1;

      /** Příznak standardního přenositelného h-objektu. */
      static final char STANDARD = '1';
      
      /** Příznak velmi těžkého h-objektu. */
      static final char STANDARD2 = '5';
      
      /** Příznak nepřenositelnosti h-objektu. */
      static final char NOT_MOVABLE = '#';

    
      
    
//== VARIABLE CLASS ATTRIBUTES =================================================
    private final int weight;
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
     * Vytvoří objekt se zadaným názvem a dalšími zadanými vlastnostmi.
     *
     * @param name Název vytvářeného objektu
     */
    PostapoItem(String name)
    {
        super(name.substring(1));
        int estimatedWeight = 1;
        char prefix = name.charAt(0);
        switch (prefix)
        {
            case STANDARD:
            break;
             
            case STANDARD2:
            estimatedWeight = 5;    
            break;
                
            case NOT_MOVABLE:
            estimatedWeight = HEAVY;
            break;
                            
            default:
            throw new RuntimeException(
                "\nNeznámá hodnota prefixu: «" + prefix + '»');
            }
        weight = estimatedWeight;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí váhu předmětu, resp. charakteristiku jí odpovídající.
     * Objekty, které není možno zvednout,
     * mají váhu větší, než je kapacita batohu.
     *
     * @return Váha objektu
     */
    @Override
    public int getWeight()
    {
        return weight;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
