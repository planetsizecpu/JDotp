package otp;

/*
 * @author JLDM
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.*;

/**
 *
 * @author pep
 */
public class Sonidos {

    // <editor-fold defaultstate="collapsed" desc="Tocar campana fina">    
    /**
     *Tocar sonido de campana fina
     */
    public static void playDing() {
        try {
            int tono = 60;
            Synthesizer synte = MidiSystem.getSynthesizer();
            synte.open();
            MidiChannel chanB = synte.getChannels()[1];
            chanB.programChange(1, 10);
            chanB.noteOn(tono, 40);
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sonidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            synte.close();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Sonidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Tocar campana grave">    
    /**
     *Tocar sonido de campana grave
     */
    public static void playDong() {
        try {
            int tono = 48;
            Synthesizer synte = MidiSystem.getSynthesizer();
            synte.open();
            MidiChannel chanB = synte.getChannels()[1];
            chanB.programChange(1, 10);
            chanB.noteOn(tono, 40);
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sonidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            synte.close();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Sonidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Tocar sonido fondo">    
    /**
     *Tocar sonido de fondo perpetuo
     */
    public static void playBackground(int tono) {
        try {
            Synthesizer synte = MidiSystem.getSynthesizer();
            synte.open();
            MidiChannel chanA = synte.getChannels()[0];
            MidiChannel chanB = synte.getChannels()[1];
            MidiChannel chanC = synte.getChannels()[2];

            chanA.programChange(0, 97);
            chanB.programChange(0, 97);
            chanC.programChange(0, 97);
            chanA.noteOn(tono, 40);
            chanB.noteOn(tono - 7, 30);
            chanC.noteOn(tono - 14, 20);

        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Sonidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// </editor-fold>
}
