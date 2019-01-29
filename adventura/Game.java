/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postapocalyptic.navd00_navratil.adventura;

import eu.pedu.adv15p_fw.game_txt.IUI;
import postapocalyptic.navd00_navratil.adventura.textui.UIA_JOptionPane;
import postapocalyptic.navd00_navratil.adventura.textui.UIB_Scanner;

/**
 *
 * @author Daniel Navrátil
 * @version
 */
public class Game {
    public static void main(String[] args)
    {
        IUI ui;
        //ui = new UIA_JOptionPane();
        ui = new UIB_Scanner();
        ui.startGame();
    }
}
