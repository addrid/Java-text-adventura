package postapocalyptic.navd00_navratil.adventura.game;

/**
 * Knihovní třída {@code PostapoState} je schránkou na nejrůznější příznaky,
 * které si je potřeba v průběhu hry zapamatovat.
 *
 * @author Daniel Navrátil
 * @version 2015-podzim
 */
public class PostapoState {
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================

    private static boolean bottleFull;
    private static boolean coatOn;
    private static boolean isHuman;
    private static boolean isConversation;
    private static boolean gotWood;
    private static boolean gateUnlocked;
    
    
//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
    /***************************************************************************
    * Vrátí informaci o tom, je-li brána odemčena.
    *
    * @return Je-li odemčena, vrátí {@code true}, jinak vrátí {@code false}
    */
    static boolean isGateUnlocked()
    {
        return gateUnlocked;
    }
    
    /***************************************************************************
    * Vrátí informaci o tom, má-li uživatel nasazený kabát
    *
    * @return Je-li nasazen {@code true}, jinak vrátí {@code false}
    */
    static boolean isCoatOn()
    {
        return coatOn;
    }
    /***************************************************************************
    * Vrátí informaci o tom, má-li uživatel naplněnou láhev vodou
    *
    * @return Má-li {@code true}, jinak vrátí {@code false}
    */
    static boolean isBottleFull()
    {
        return bottleFull;
    }
    /***************************************************************************
    * Vrátí informaci o tom, je-li uživatel člověk
    *
    * @return Má-li {@code true}, jinak vrátí {@code false}
    */
    static boolean isHuman()
    {
        return isHuman;
    }
    /***************************************************************************
    * Vrátí informaci o tom, má-li uživatel naštípáno dříví
    *
    * @return Má-li {@code true}, jinak vrátí {@code false}
    */
    static boolean gotWood()
    {
        return gotWood;
    }
    /***************************************************************************
    * Vrátí informaci o tom, je-li uživatel uvnitř konverzace
    *
    * @return Je-li {@code true}, jinak vrátí {@code false}
    */
    static boolean isConversation()
    {
        return isConversation;
    }
    
    /***************************************************************************
    * Nastaví informaci o tom, je-li brána odemčena.
    *
    * @param gateUnlocked Nastavovaná hodnota
    */
    static void setGateUnlocked(boolean gateUnlocked)
    {
        PostapoState.gateUnlocked = gateUnlocked;
    }
    
    
    /***************************************************************************
    * Nastaví informaci o tom, je-li nasazen kabát.
    *
    * @param coatOn Nastavovaná hodnota
    */
    static void setCoatOn(boolean coatOn)
    {
        PostapoState.coatOn = coatOn;
    }
    
    /***************************************************************************
    * Nastaví informaci o tom, je-li láhev plná
    *
    * @param bottleFull Nastavovaná hodnota
    */
    static void setBottleFull(boolean bottleFull)
    {
        PostapoState.bottleFull = bottleFull;
    }
    /***************************************************************************
    * Nastaví informaci o tom, je-li uživatel člověk
    *
    * @param bottleFull Nastavovaná hodnota
    */
    static void setIsHuman(boolean isHuman)
    {
        PostapoState.isHuman = isHuman;
    }
    
    /***************************************************************************
    * Nastaví informaci o tom, je-li uživatel v rozhovoru
    *
    * @param isConversation Nastavovaná hodnota
    */
    static void setConversation(boolean isConversation)
    {
        PostapoState.isConversation = isConversation;
    }
    /***************************************************************************
    * Nastaví informaci o tom, získal-li uživatel dřevo
    *
    * @param gotWood Nastavovaná hodnota
    */
    static void setGotWood(boolean gotWood)
    {
        PostapoState.gotWood = gotWood;
    }

//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /***************************************************************************
    * Inicializuje všechny příznaky, které udržují informace
    * o aktuálním stavu hry a jejích součástí.
    */
    static void initialize()
    {
        gateUnlocked    = false;
        coatOn          = false;
        bottleFull      = false;
        isHuman         = false;
        isConversation  = false;
        gotWood         = false;
    }


//== PRIVATE AND AUXILIARY CLASS METHODS =======================================

//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /***************************************************************************
    * Soukromý konstruktor zabraňující vytvoření instance.
    */
    private PostapoState()
    {
    }

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
}
