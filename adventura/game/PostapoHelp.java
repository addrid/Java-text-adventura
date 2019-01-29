/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package postapocalyptic.navd00_navratil.adventura.game;

import java.util.Collection;
import java.util.stream.Collectors;
import static postapocalyptic.navd00_navratil.adventura.game.Texts.*;



/*******************************************************************************
 * Instance třídy {@code PostapoHelp} zpracovávají příkazy, které
 * obstarávají nápovědu
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
class PostapoHelp extends PostapoAAction
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
    PostapoHelp()
    {
      super (Texts.pHELP,
            "Vypíše nápovědu s názvy a stručnými popisy dostupných příkazů.");
        
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání příkazu nápovědy.
     * 
     *
     * @param arguments Parametry příkazu;
     *                  v tomto případu se jedná o bezparametrický příkaz
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        PostapoGame game = PostapoGame.getInstance();
        Collection<PostapoAAction> commands = game.getAllActions();
        String result = commands.stream()
                                .map(cmd -> cmd.getName() + "\n" +
                                 cmd.getDescription())
                                .collect(Collectors.joining("\n\n", 
                                         zNAPOVEDA, ""));
        return result;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
