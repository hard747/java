package calculadoragráfica;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ControlPrincipal {

    private static SuperficieDeDibujo superficieDeDibujo;
    private static VentanaPrincipal ventana;
    private static int APS = 0, FPS = 0;

    public static void main(String[] args) {
         EscogerLookAndFeel(1);
        iniciarJuego();
    }

    public static void iniciarJuego() {
        crearVentana(1280, 720, "Prueba Juego - Jeff Aporta [Jeffrey Alexander Agudelo Espitia]");
    }

    public static void crearVentana(int ancho, int alto, String Nombre) {
        superficieDeDibujo = new SuperficieDeDibujo(ancho, alto);
        ventana = new VentanaPrincipal(Nombre, superficieDeDibujo); 
    }
    public static void EscogerLookAndFeel(int tipo) {
        try {
            if (tipo < 0 || tipo > 4) {
                throw new Error("Fuera de rango [0-4]");
            }
            switch (tipo) {
                case 0:
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Metal".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    break;
                case 1:
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    break;
                case 2:
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("CDE/Motif".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    break;
                case 3:
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Windows".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    break;
                case 4:
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Windows Classic".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    break;
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("No se pudo iniciar Look n feel");
        }
    }

}
