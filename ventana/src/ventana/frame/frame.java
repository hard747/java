
package ventana.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class frame extends JFrame {
    public JPanel panel;
    public frame(){
            setSize(500,500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("gata");
            //setLocation(100, 200);
            //setBounds(100,200,500,500);
            setLocationRelativeTo(null);
            this.getContentPane().setBackground(Color.GREEN);
             iniciarComponentes();
    }
    
    private void iniciarComponentes(){
    
        colocarPanel();
        //colocarEtiqueta();
        //colocarBotones();
        //colocarRadioBotones();
        //colocarLineasDetexto();
        //colocarAreasDeTexto();
        colocarListasDesplegables();
    }
    private void colocarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);//agregamos el panel a la ventana
        panel.setBackground(Color.yellow);//cambia el color de fondo
    
    }
    
    private void colocarEtiqueta(){
    
        JLabel etiqueta =new JLabel();
        //JLabel etiqueta =new JLabel("Hola Gata",SwingConstants.CENTER);
        etiqueta.setText("Hola gataaa");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(10, 10, 120, 40);
        etiqueta.setFont(new Font("arial",Font.ITALIC,20));
        etiqueta.setOpaque(true);//permiso para cambiar fondo de etiqueta
        etiqueta.setBackground(Color.black);
        etiqueta.setForeground(Color.green);
        
        panel.add(etiqueta);
        //etiqieta imagen
        //JLabel etiqueta2= new JLabel(new ImageIcon("harry.jpg")); etiqueta imagen simple sin ajuste ni escala
        JLabel etiqueta2= new JLabel();
        //cargar imagen ajustada
        ImageIcon imagen = new ImageIcon("harry.jpg");
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH)));
        //fin de cargar imagen ajustada
        etiqueta2.setBounds(80, 80, 300, 300);
        panel.add(etiqueta2);
    
    }
    
    private void colocarBotones(){
    
        JButton boton1 = new JButton("GATA");
        boton1.setBounds(100, 100, 100, 40);
        boton1.setForeground(Color.blue);
        boton1.setFont(new Font("cooper black",3,15));
        panel.add(boton1);
        
        JButton boton2 = new JButton();
        boton2.setBounds(100, 200, 100, 40);
        ImageIcon imagen = new ImageIcon("harry.jpg");
        boton2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        
//boton2.setOpaque(true);
        boton2.setBackground(Color.green);
        panel.add(boton2);
        
        //oyente de raton - mose listener
        MouseListener oyenteraton=new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        };
        boton2.addMouseListener(oyenteraton);
    }
    
    private void colocarRadioBotones(){
        
        JRadioButton radioboton=new JRadioButton("opcion 1",true);
        radioboton.setBounds(50, 100, 100, 50);
        panel.add(radioboton);
        
        JRadioButton radioboton1=new JRadioButton("opcion 2",false);
        radioboton1.setBounds(50, 150, 100, 50);
        panel.add(radioboton1);
        
        JRadioButton radioboton2=new JRadioButton("opcion 3",true);
        radioboton2.setBounds(50, 200, 100, 50);
        panel.add(radioboton2);
        
        ButtonGroup grupo =new ButtonGroup();
        grupo.add(radioboton);
        grupo.add(radioboton1);
        grupo.add(radioboton2);
        
    
    
    }
    
    private void colocarLineasDetexto(){//cajas de texto
        
        JTextField cajatexto =new JTextField();
        cajatexto.setBounds(50, 50, 100, 30);
        panel.add(cajatexto);
        cajatexto.setText("hola");
    }
    
    private void colocarAreasDeTexto(){
        
        JTextArea areatexto=new JTextArea();
        areatexto.setBounds(20, 20, 300, 200);
        areatexto.setText("Escriba aqui: ");
        areatexto.append("\n\n siga escribiendo");
        panel.add(areatexto);
    }
    
    private void colocarListasDesplegables(){
        String[] paises={"peru","panama","chile","colombia"};
        JComboBox lista = new JComboBox(paises);
        lista.setBounds(20, 20, 100, 30);
        panel.add(lista);
    
    }
    
}
