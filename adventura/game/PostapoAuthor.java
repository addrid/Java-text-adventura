/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package postapocalyptic.navd00_navratil.adventura.game;

import eu.pedu.adv15p_fw.game_txt.IAuthor;



/*******************************************************************************
 * Instance interfejsu {@code IAuthorPrototype} umějí na požádání vrátit
 * jméno a identifikační řetězec autora/autorky své třídy;
 * tyto hodnoty mají uloženy ve svých statických konstantách
 * {@link #AUTHOR_NAME} a {@link #AUTHOR_ID}.
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
public interface PostapoAuthor extends IAuthor
{
//== STATIC CONSTANTS ==========================================================

    /** Jméno autora/autorky ve formátu <b>PŘÍJMENÍ Křestní</b>,
     * tj. nejprve příjmení psané velkými písmeny a za ním křestní jméno,
     * u nějž bude velké pouze první písmeno a ostatní písmena budou malá.
     * Má-li autor programu více křestních jmen, může je uvést všechna. */
    String AUTHOR_NAME = "NAVRÁTIL Daniel";

    /** Identifikační řetězec autora/autorky zapsaný VELKÝMI PÍSMENY.
     *  Tímto řetězcem bývá většinou login do informačního systému školy. */
    String AUTHOR_ID = "NAVD00";



//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí jméno autora/autorky programu ve formátu <b>PŘÍJMENÍ Křestní</b>,
     * tj. nejprve příjmení psané velkými písmeny a za ním křestní jméno,
     * u nějž bude velké pouze první písmeno a ostatní písmena budou malá.
     * Má-li autor programu více křestních jmen, může je uvést všechna.
     *
     * @return Jméno autora/autorky programu ve tvaru PŘÍJMENÍ Křestní
     */
    @Override
    default public String getAuthorName()
    {
        return AUTHOR_NAME;
    }


    /***************************************************************************
     * Vrátí identifikační řetězec autora/autorky programu
     * zapsaný VELKÝMI PÍSMENY.
     * Tímto řetězcem bývá většinou login do informačního systému školy.
     *
     * @return Identifikační řetězec autora/autorky programu
     */
    @Override
    default public String getAuthorID()
    {
        return AUTHOR_ID;
    }



//== OTHER ABSTRACT METHODS ====================================================
//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
