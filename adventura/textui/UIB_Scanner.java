/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postapocalyptic.navd00_navratil.adventura.textui;

import eu.pedu.adv15p_fw.game_txt.IGSMFactory;
import eu.pedu.adv15p_fw.game_txt.IGame;
import java.awt.Component;
import java.util.Scanner;
import postapocalyptic.navd00_navratil.adventura.game.*;
import postapocalyptic.navd00_navratil.adventura.PostapoGSMFactory;
import javax.swing.JFrame;
import postapocalyptic.navd00_navratil.adventura.game.PostapoGame;
import javax.swing.JOptionPane;
/**
 *
 * @author Daniel Navrátil
 * @version
 */
public class UIB_Scanner implements eu.pedu.adv15p_fw.game_txt.IUI {
    
    
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
        
        Scanner scanner = new Scanner(System.in);
        String command = "";
        String answer;
        for(;;) {
            answer = game.executeCommand(command);
            System.out.println(answer);
            if (! game.isAlive()) { break; }
            command = scanner.nextLine();
        }
    }

    @Override
    public IGame getGame() {
        return PostapoGame.getInstance();
    }

    @Override
    public Class<? extends IGSMFactory> getFactoryClass() {
        return PostapoGSMFactory.class; //To change body of generated methods, choose Tools | Templates.
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
