package djview;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;

public class SoundCheck {
    public static void main(String[] args) {
        System.out.println("Buscando dispositivos de audio disponibles para Java...");
        Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
        
        if (mixerInfo.length == 0) {
            System.out.println("ERROR: No se encontraron mezcladores de audio.");
            System.out.println("Este es el motivo por el cual la aplicación no puede reproducir sonido.");
            System.out.println("Por favor, verifica la configuración de audio de tu sistema (ALSA, PulseAudio) y las librerías de sonido de Java.");
        } else {
            System.out.println("¡Éxito! Se encontraron los siguientes mezcladores de audio:");
            for (int i = 0; i < mixerInfo.length; i++) {
                System.out.println(" - " + i + ": " + mixerInfo[i].getName() + " -> " + mixerInfo[i].getDescription());
            }
            System.out.println("\nEl sonido debería funcionar en tu aplicación. Si no es así, el problema podría ser el formato del archivo .wav o los permisos.");
        }
    }
}