/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package postapocalyptic.navd00_navratil.adventura;

import postapocalyptic.navd00_navratil.adventura.game.PostapoGame;
import postapocalyptic.navd00_navratil.adventura.game.PostapoAuthor;
import postapocalyptic.navd00_navratil.adventura.game.PostapoSM;
import eu.pedu.adv15p_fw.game_txt.IGSMFactory;
import eu.pedu.adv15p_fw.scenario.AScenarioManager;



/*******************************************************************************
 * Instance třídy {@code EmptyGSMFactory} představují tovární objekty,
 * které jsou schopny na požádání dodat instanci hry,
 * instanci správce scénářů této hry
 * a instanci textového uživatelského rozhraní.
 * Dokud ještě některé z těchto objektů nejsou definovány,
 * vyhazují metody výjimku {@link UnsupportedOperationException}.
 * <p>
 * V první fázi vývoje celé aplikace bývá aktivní pouze metoda
 * {@link #getScenarioManager()} umožňující získání instance správce scénářů
 * vyvíjené hry a těla zbylých metod bývají zakomentovaná.
 * Posléze po odkomentování zakomentovaných těl metod lze postupně získat
 * také vlastní textové i grafické verze hry
 * a jejího textového, resp. grafického uživatelského rozhraní.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2015-Podzim
 */
public class PostapoGSMFactory implements IGSMFactory, PostapoAuthor
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
     * Vytvoří tovární objekt poskytující klíčové objekty aplikace.
     */
    public PostapoGSMFactory()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí odkaz na instanci správce scénářů.
     *
     * @return Požadovaný odkaz
     */
//    @Override
    public AScenarioManager getScenarioManager()
    {
        return PostapoSM.getInstance();
    }


    /***************************************************************************
     * Vrátí odkaz na instanci textové verze hry.
     *
     * @return Požadovaný odkaz
     */
//    @Override
    public PostapoGame getGame()
    {
        return PostapoGame.getInstance();
    }


    /***************************************************************************
     * Vrátí odkaz na instanci třídy realizující uživatelské rozhraní.
     *
     * @return Požadovaný odkaz
     */
//    @Override
//    public IUI getUI()
//    {
//        return TextUI_Instance;
//    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
