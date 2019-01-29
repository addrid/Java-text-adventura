/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postapocalyptic.navd00_navratil.adventura;

/**

/*******************************************************************************
Instance interfejsu {@code IGamePlayer} definují variantní části
* univerzálního textového uživatelského rozhraní
* pro hraní textových konverzačních her.
* @author addridek
*/
public interface IGamePlayer
{
//== OTHER ABSTRACT METHODS ====================================================
    /***************************************************************************
    * Pošle uživateli zadanou zprávu a převezme od něj další příkaz.
    *
    * @param message Posílaná zpráva
    * @return Uživatelem zadaný příkaz
    */
    public String askCommand (String message);

    /***************************************************************************
    * Pošle uživateli zadanou zprávu.
    *
    * @param message Posílaná zpráva
    */
    public void sendMessage(String message);
}