/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postapocalyptic.navd00_navratil.adventura.textui;

import eu.pedu.adv15p_fw.game_txt.IGSMFactory;
import eu.pedu.adv15p_fw.game_txt.IGame;
import java.awt.Component;
import javax.swing.JFrame;
import postapocalyptic.navd00_navratil.adventura.game.*;
import postapocalyptic.navd00_navratil.adventura.game.PostapoGame;
import javax.swing.JOptionPane;
import postapocalyptic.navd00_navratil.adventura.PostapoGSMFactory;
import postapocalyptic.navd00_navratil.adventura.game.PostapoAuthor;
/**
 *
 * @author Daniel Navrátil
 * @version
 */
public class UIA_JOptionPane implements eu.pedu.adv15p_fw.game_txt.IUI {
     private final static Class<? extends IGSMFactory> FACTORY_CLASS =
                                                      PostapoGSMFactory.class;
    
    /***************************************************************************
    * Spustí komunikaci mezi implicitní hrou
    * a danou instancí uživatelského rozhraní.
    */
    @Override
    public void startGame() {
        startGame(PostapoGame.getInstance());
    }
    
    /***************************************************************************
    * Spustí komunikaci mezi zadanou hrou a danou instancí
    * mající na starosti komunikaci s uživatelem.
    *
    * @param game Hra, kterou ma dané UI spustit
    */
    @Override
    public void startGame(IGame game) {
        
        Component parent = new JFrame();
        parent.setLocation(100, 100);
        parent.setVisible(true);

        String command;
        /* prázdný řetěžec zadávaný na počátku hry - první příkaz */
        String answer = game.executeCommand("");
        do {
            command = JOptionPane.showInputDialog(parent, answer);
            answer = game.executeCommand(command);
        } while (game.isAlive());
        
        JOptionPane.showMessageDialog(parent, answer);
        System.exit(0);
    }

    @Override
    public IGame getGame() {
        return PostapoGame.getInstance();
    }

    @Override
    public Class<? extends IGSMFactory> getFactoryClass() {
       return FACTORY_CLASS;
    }

    @Override
    public String getAuthorName() {
        return PostapoAuthor.AUTHOR_NAME;
    }

    @Override
    public String getAuthorID() {
        return PostapoAuthor.AUTHOR_ID;
    }

    
}
