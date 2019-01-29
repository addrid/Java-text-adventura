/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postapocalyptic.navd00_navratil.adventura.textui;

import eu.pedu.adv15p_fw.game_txt.IGSMFactory;
import eu.pedu.adv15p_fw.game_txt.IGame;
import eu.pedu.adv15p_fw.game_txt.IUI;
import java.awt.Component;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import postapocalyptic.navd00_navratil.adventura.PostapoGSMFactory;
import postapocalyptic.navd00_navratil.adventura.game.PostapoGame;
import postapocalyptic.navd00_navratil.adventura.game.PostapoAuthor;

/*******************************************************************************
* Instance třídy {@code UIC_GamePlayer} realizují uživatelské rozhraní,
* kterému lze zadat objekt typu {@link IGamePlayer}, jehož prostřednictvím
* bude program komunikovat s uživatelem.
*/
public class UIC_GamePlayer implements IUI
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

    /** Objekt specifikující některé detaily konverzace. */
    private final IGamePlayer player;
    
    
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

//##############################################################################

//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /***************************************************************************
    * Vytvoří instanci využívající pro řešení některých detailů zadaný objekt.
    *
    * @param player Objekt pro řešení některých detailů
    */
    public UIC_GamePlayer(IGamePlayer player)
    {
        this.player = player;
    }
//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
    * Spustí komunikaci mezi implicitní hrou
    * a danou instancí uživatelského rozhraní.
    */
    @Override
    public void startGame()
    {
        startGame(PostapoGame.getInstance());
    }
    
    /***************************************************************************
    * Spustí komunikaci mezi zadanou hrou a danou instancí
    * mající na starosti komunikaci s uživatelem.
    *
    * @param game Hra, kterou ma dané UI spustit
    */
    @Override
    public void startGame(IGame game)
    {
        String command = "";
        String answer;
        for(;;) {
            answer = game.executeCommand(command);
            if (! game.isAlive()) { break; } //---------->
            command = player.askCommand(answer);
        }
        player.sendMessage(answer);
    }

    @Override
    public IGame getGame() {
        return PostapoGame.getInstance();
    }

    @Override
    public Class<? extends IGSMFactory> getFactoryClass() {
        return PostapoGSMFactory.class;
    }

    @Override
    public String getAuthorName() {
        return PostapoAuthor.AUTHOR_NAME;
    }

    @Override
    public String getAuthorID() {
        return PostapoAuthor.AUTHOR_ID;
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//##############################################################################
//== NESTED DATA TYPES =========================================================

    /***************************************************************************
    * Instance interfejsu {@code IGamePlayer} definují variantní části
    * univerzálního textového uživatelského rozhraní
    * pro hraní textových konverzačních her.
    */
    public interface IGamePlayer
    {
        /***********************************************************************
       * Pošle uživateli zadanou zprávu a převezme od něj další příkaz.
       *
       * @param message Posílaná zpráva
       * @return Uživatelem zadaný příkaz
       */
       public String askCommand(String message);

       /***********************************************************************
       * Pošle uživateli zadanou zprávu.
       *
       * @param message Posílaná zpráva
       */
        public void sendMessage(String message);
     }


////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

    /***************************************************************************
    * Instance třídy {@code ByJOptionPane} zprostředkovávají komunikaci
    * s uživatelem prostřednictvím statických metod třídy {@link JOptionPane}.
    */
    public static class ByJOptionPane implements IGamePlayer
    {
        final Component PARENT;
        
        /** Vytvoří novou instanci. Při té příležitosti vytvoří rodičovskou
        * komponentu definující umístění dialogových oken. */
        ByJOptionPane() {
        PARENT = new JFrame();
        PARENT.setLocation(100, 100);
        PARENT.setVisible(true);
        }
        /** {@inheritDoc} */
        @Override public String askCommand(String message) {
            return JOptionPane.showInputDialog(PARENT, message);
        }
        
        /** {@inheritDoc} */
        @Override public void sendMessage(String message) {
            JOptionPane.showMessageDialog(PARENT, message);
        }
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    /***************************************************************************
    * Instance třídy {@code ByScanner} zprostředkovávají komunikaci
    * s uživatelem prostřednictvím standardního (konzolového) vstupu a výstupu,
    * přičemž vstup je zabalen do instance třídy {@link Scanner}.
    */
    public static class ByScanner implements IGamePlayer
   {
        Scanner scanner = new Scanner(System.in);
        /** {@inheritDoc} */
        @Override public String askCommand(String message) {
            sendMessage(message);
            return scanner.nextLine();
        }

       /** {@inheritDoc} */
       @Override public void sendMessage(String message) {
            System.out.println(message);
       }
   }
//##############################################################################
//== MAIN METHOD ===============================================================
    /***************************************************************************
    * Metoda spouštějící hru {@link RUPApartmentGame} umožňující zadat
    * prostřednictvím parametrů příkazového řádku,
    * zda bude použito uživatelském rozhraním využívající služeb
    * třídy {@link JOptionPane} nebo standardního výstupu a
    * standardního vstupu zabaleného do instance třídy {@link Scanner}.
    *
    * @param args Parametry příkazového řádku
    */
    public static void main(String[] args)
    {
        IGamePlayer gamePlayer;
        gamePlayer = ((args.length < 1) || (! args[0].equals("-con")))
                        ? new ByJOptionPane()
                        : new ByScanner();
        new UIC_GamePlayer(gamePlayer).startGame();
        System.exit(0);
    }
}
