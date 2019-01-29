package postapocalyptic.navd00_navratil.adventura.game;

import java.time.LocalDate;
import java.util.function.Function;
import static postapocalyptic.navd00_navratil.adventura.game.Texts.*;
import java.util.Random;

/*******************************************************************************
 * Třída {@code Conversation} realizujicí konverzaci s inteligentním předmětem.
 * V tomto případě bude rozhovor veden s inteligentní truhlkou, která 
 * kontroluje zda-li se snaží konzervy vyjmout člověk.
 * Prověřování skrze dvě otázky, první otázka Jste člověk?, na kterou očekává
 * odpověď ano/jo/jsem.
 * Druhá otázka je spočítat lehký příklad, kde se jedná o součet dvou náhodných
 * čísel
 *
 * @author  Daniel Navrátil
 * @version 2015-Podzim
 */
public class Conversation {
    
    private static int age;
    private static PostapoItem item;
    private static Function<String, String> stateDependentAnswer;
    private static int max_age = 75;
    private static int min_age = 18;
    private static int takes = 4;
    private static Random rnd = new Random();
    private static int max = 10, min = 0, solution;
    private static int random = rnd.nextInt((max - min) + 1) + min;
    private static int random2 = rnd.nextInt((max - min) + 1) + min;
        
    /***************************************************************************
    * Metoda řešící reakci hry na odpovědi uživatele ve fázi,
    * kdy má uživatel prokázat, že je člověk
    *
    * @param command Odpověď uživatele
    * @return Odpověď hry hráči
    */
    private static String waitingForHuman(String userAnswer)
    {
        String uc = userAnswer.toUpperCase();
        try {
            if (!uc.contains("ANO") && !uc.contains("JO") &&
                !uc.contains("JSEM") )
            {
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException iae) {
            return String.format(fONCE_MORE); /* spatna odpoved */
        }
                
        stateDependentAnswer = Conversation::waitingForSolution;
        return zVYPOCITEJ + random + " + " + random2;
    }
    
    /***************************************************************************
    * Metoda řešící reakci hry na odpovědi uživatele ve fázi,
    * kdy má uživatel vypočítat lehký příklad.
    *
    * @param command Odpověď uživatele
    * @return Odpověď hry hráči
    */
    private static String waitingForSolution(String userAnswer)
    {
        int result = random + random2;
        
        if (takes < 2) {
                PostapoState.setConversation(false);
                return String.format(fDOES_NOT_MATCH + fNOT_ALLOWED,
                item.getName());
        }
        
        try {
            solution = Integer.parseInt(userAnswer);
            
            if (result != solution) {
                takes--;
                throw new NumberFormatException();
            }
        }
        catch(NumberFormatException nfe) {
          return String.format(zVYPOCITEJ + random + " + " + random2 + 
                               fREMAINING + takes);
        }
        
        PostapoState.setConversation(false);

        PostapoState.setIsHuman(true);
        PostapoWorld.getInstance().getCurrentArea().removeItem(item);
        PostapoBag .getInstance().tryAddItem(item);
        return zODEBRAL + item.getName() + zNEZAPOMEN;
        
    }
    

    /***************************************************************************
    * Odstartuje rozhovor o nemožnosti jednoduchého odebrání zadaného předmětu,
    * v tomto případě o vyjmutí konzerv z truhly
    *
    * @param item Předmět, který chce hráč odebrat z truhly
    * @return První část rozhovoru pronesená truhlou
    */
    static String start(PostapoItem item)
    {
        stateDependentAnswer = Conversation::waitingForHuman;
        PostapoState.setConversation(true);
        Conversation.item = item;
        String itemName = item.getName();
        return Texts.zBERE_ZTRUHLY + itemName + "." + Texts.zJE_CLOVEK;
    }

    static String answer(String command) 
    {
        return stateDependentAnswer.apply(command);
    }
}
