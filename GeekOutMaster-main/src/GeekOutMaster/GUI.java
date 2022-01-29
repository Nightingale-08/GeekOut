package GeekOutMaster;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/**
 * Esta clase contiene la clase main y la interface grafica de usuario.
 * @Autores  Marlon-A. Anacona - O. 2023777 <marlon.anacona@correounivalle.edu.co>
 *           Luis F Belalcazar A. 2028783 <luis.felipe.belalcazar@correounivalle.edu.co>
 * @version 1.0.0 date 29/01/2022
* */

public class GUI extends JFrame {

    private Header headerProject;
    public static  JButton dado[] = new JButton[10];
    public static int contadorveces = -1;
    public static String  nombre[];
    public static int caras[];
     private JButton btn2;
    private  String nombre2;
    private JLabel fondo;
    private int contadorDados;
    public static  LinkedList<JButton> listaBotonesActivos= new LinkedList<JButton>();
    public static  LinkedList<JButton> listaBotonesUtilizados= new LinkedList<JButton>();
    public static       JButton btn;
    public static  String nombre1;
    public static  LinkedList<JButton> listaBotonesInactivos= new LinkedList<JButton>();
    public static boolean jugadas=true;
    private JButton ayuda, salir, lanzar;
    public static JPanel panelDadosActivos, panelDadosInactivos, panelDadosUtilizados, panelPuntaje;
    private ImageIcon imagenDados,fondoimagen;
    private Escucha escucha=new Escucha();
    private Icon icono;
    PanelFondo fondo1= new PanelFondo();

    /**
     * constructor de la INTERFACE Grafica
    * */

    public GUI() {

        contadorDados=0;
        intGUI();
        fondoimagen=new ImageIcon(getClass().getResource("/resources/fondo.jpg"));
        fondo=new JLabel(fondoimagen);
        this.setUndecorated(true);
        this.setTitle("GEEK OUT MASTER");
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


    }


    private void intGUI() {
        //create listener object or control object
        for (int i = 0; i < 7; i++) {


            dado[i] = new JButton("Dado "+i);
            dado[i].setBorderPainted(false);
            dado[i].setContentAreaFilled(false);
            dado[i].setFocusable(false);
            ImageIcon imgDadosSalida= new ImageIcon(getClass().getResource("/resources/"+"dadoSalida.png"));
            dado[i].setIcon(imgDadosSalida);
            dado[i].addActionListener(escucha);
            listaBotonesActivos.add(dado[i]);

        }
        for (int i = 7; i < 10; i++) {

            dado[i] = new JButton("Dado "+i);
            dado[i].addActionListener(escucha);
            dado[i].setBorderPainted(false);
            dado[i].setContentAreaFilled(false);
            dado[i].setFocusable(false);
            ImageIcon imgDadosSalida= new ImageIcon(getClass().getResource("/resources/"+"dadoSalida.png"));
            dado[i].setIcon(imgDadosSalida);
            listaBotonesInactivos.add(dado[i]);

        }

        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //set up Jcomponents
        headerProject = new Header("GEEK OUT MASTER", Color.black);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);
        //create a Buttons for exit the aplicattion, help the game. And the game buttons
        ayuda = new JButton(" ? ");
        ayuda.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(ayuda, constraints);

        salir = new JButton("Salir");
        salir.addActionListener(escucha);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(salir, constraints);

        lanzar = new JButton("Lanzar");
        lanzar.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(lanzar, constraints);


        panelDadosActivos = new JPanel();
        fondoimagen = new ImageIcon(getClass().getResource("/resources/descarg.jpg"));


        //panelDadosActivos.setLayout(());

        panelDadosActivos.setPreferredSize(new Dimension(500, 250));
        Font font = new Font("Tahoma", Font.BOLD, 18);

        panelDadosActivos.setBorder(BorderFactory.createTitledBorder(LineBorder.createGrayLineBorder(),"DADOS ACTIVOS", TitledBorder.LEFT,TitledBorder.TOP,font,Color.red));


        panelDadosActivos.setOpaque(false);
        imagenDados = new ImageIcon(getClass().getResource("/resources/ejemplo.jpg"));

        for(int i=0;i<listaBotonesActivos.size();i++){
            listaBotonesActivos.get(i).setEnabled(false);


            panelDadosActivos.add(listaBotonesActivos.get(i));

        }


        contadorDados=7;


        panelDadosUtilizados = new JPanel();


        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder("DADOS UTILIZADOS "));
        panelDadosUtilizados.setPreferredSize(new Dimension(500, 250));
        panelDadosUtilizados.setOpaque(false);
        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder(LineBorder.createBlackLineBorder(),"DADOS UTILIZADOS", TitledBorder.LEFT,TitledBorder.TOP,font,Color.red));


        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("DADOS INACTIVOS "));
        panelDadosInactivos.setPreferredSize(new Dimension(500, 200));
        panelDadosInactivos.setOpaque(false);
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder(LineBorder.createBlackLineBorder(),"DADOS INACTIVOS", TitledBorder.LEFT,TitledBorder.TOP,font,Color.red));

        for(int i=0;i<listaBotonesInactivos.size();i++){
            listaBotonesInactivos.get(i).setEnabled(false);
            panelDadosInactivos.add(listaBotonesInactivos.get(i));



        }




        panelPuntaje= new JPanel();
        panelPuntaje.setBorder(BorderFactory.createTitledBorder("PUNTAJE "));
        panelPuntaje.setPreferredSize(new Dimension(500,200));
        panelPuntaje.setOpaque(false);
        panelPuntaje.setBorder(BorderFactory.createTitledBorder(LineBorder.createBlackLineBorder(),"PUNTAJE", TitledBorder.LEFT,TitledBorder.TOP,font,Color.red));




        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelDadosActivos, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelDadosUtilizados, constraints);

        constraints.gridx =0 ;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelDadosInactivos, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelPuntaje, constraints);





    }

    /**
    * Clase Main
    * */

    public static void main(String[] args) {
        // Ejecución del programa

        EventQueue.invokeLater(() -> {

            GUI presentacion = new GUI();

        });

    }

    /**
     * Clase escucha, implementa a la clase actionListener
     */


    private class Escucha implements ActionListener {
        /*
        These buttons start the game, giving a card with a random value between 1-12, both for the player and for the machine
         */



        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == lanzar) {

                modelDados tirar = new modelDados();

                tirar.calcularTiroJugador();
                caras = tirar.getCaras();
                nombre = tirar.getNombres();
                for (int i = 0; i < 10; i++) {
                    dado[i].setText(nombre[i]);

                    //Imagenes

                    ImageIcon imgDados = new ImageIcon(getClass().getResource("/resources/" + nombre[i] + ".jpg"));
                    dado[i].setIcon(imgDados);
                }
                for (int i = 0; i < listaBotonesActivos.size(); i++) {

                    listaBotonesActivos.get(i).setEnabled(true);
                }
//lanzar.setEnabled(false);

            } else {

            }
            if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, "\"-> De los 10 dados que trae el juego se toman 3 y se colocan en el sector de \"Dados Inactivos\". Los otros 7 dados se tiran y pasan a ser los \"Dados Activos\"\\n\" +\n" +
                        "            \"-> Se van eligiendo los dados a utilizar según las habilidades de sus caras y se pasan al sector de \"Dados Utilizados\"\\n\" +\n" +
                        "            \"-> Si no hay más acciones disponibles y hay uno o más dragones activos pierde todos los puntos. Si usa este dado también perderá todos los puntos de la ronda y acumulados \\n\" +\n" +
                        "            \"-> Este juego lo jugará un único jugador y ganará si logra sumar 30 puntos en 5 rondas consecutivas de juego. \"");
            } else {
                if (e.getSource() == salir) {
                    System.exit(0);
                } else {
                    modelDados evuluaMovimiento = new modelDados();

                    //En caso de que no haya escogido un dado
                    // &&evuluaMovimiento.getDadoEscogido()==-1

                    if (e.getSource() != salir && e.getSource() != ayuda && e.getSource() != lanzar && contadorveces == -1) {
                        btn = (JButton) e.getSource();
                        nombre1 = btn.getText();


                        ImageIcon seleccion = new ImageIcon(getClass().getResource("/resources/corazon.jpg"));
                        btn.setIcon(seleccion);
                        //En caso de escoger la opcion corazon
                        if(nombre1.equals("corazon")){
                            int pregunta = JOptionPane.showConfirmDialog(null, "Esta segura de hacer esta accion(Corazon)?");
                            if (pregunta == JOptionPane.YES_OPTION) {
                                int escogido;
                                for (int i = 0; i < GUI.listaBotonesActivos.size(); i++) {
                                    if (btn == GUI.listaBotonesActivos.get(i)) {
                                        escogido = i;
                                    }
                                }
                                modelDados miDado = new modelDados();
                                miDado.Corazon(btn);
                                  contadorveces=-1;
                                /*for (int i = 0; i < GUI.listaBotonesActivos.size(); i++) {
                                    if (listaBotonesActivos.get(i).getText()=="mepple"||listaBotonesActivos.get(i).getText()=="corazon"||listaBotonesActivos.get(i).getText()=="superh") {
                                        jugadas=false;

                                    }else{

                                    }
                                }

                                if(jugadas==false){
                                    System.out.println("No hay mas jugadas posibles");
                                }*/

                            }else{
                                contadorveces = -1;
                            }
                        }
                        else{
                            contadorveces = 1;
                        }

                    }else{


                        if (e.getSource() != salir && e.getSource() != ayuda && e.getSource() != lanzar && contadorveces == 1) {


                            int pregunta = JOptionPane.showConfirmDialog(null, "Esta segura de hacer esta accion?");
                            if (pregunta == JOptionPane.YES_OPTION) {

                                btn2 = (JButton) e.getSource();
                                nombre2 = btn.getText();
                                switch (nombre1) {
                                    case "mepple":

                                        evuluaMovimiento.meeple(btn,btn2);
                                        /*for (int i = 0; i < GUI.listaBotonesActivos.size(); i++) {
                                            if (listaBotonesActivos.get(i).getText()=="mepple"||listaBotonesActivos.get(i).getText()=="corazon"||listaBotonesActivos.get(i).getText()=="superh") {
                                                jugadas=false;

                                            }else{

                                            }
                                        }

                                        if(jugadas==false){
                                            System.out.println("No hay mas jugadas posibles");
                                        }*/
                                        contadorveces=-1;
                                        break;
                                    case "Dragon":


                                        break;

                                    case "Corazon":





                                        break;

                                    case "cohete":
                                    evuluaMovimiento.cohete(btn,btn2);
                                      /*  for (int i = 0; i < GUI.listaBotonesActivos.size(); i++) {
                                            if (listaBotonesActivos.get(i).getText()=="mepple"||listaBotonesActivos.get(i).getText()=="corazon"||listaBotonesActivos.get(i).getText()=="superh") {
                                                jugadas=false;

                                            }else{

                                            }
                                        }

                                        if(jugadas==false){
                                            System.out.println("No hay mas jugadas posibles");
                                        }*/
                                        contadorveces=-1;
                                        break;

                                    case "superh":
                                        evuluaMovimiento.superheroe(btn,btn2);
                                      /*  for (int i = 0; i < GUI.listaBotonesActivos.size(); i++) {
                                            if (listaBotonesActivos.get(i).getText()=="mepple"||listaBotonesActivos.get(i).getText()=="corazon"||listaBotonesActivos.get(i).getText()=="superh") {
                                                jugadas=false;

                                            }else{

                                            }
                                        }

                                        if(jugadas==false){
                                            System.out.println("No hay mas jugadas posibles");
                                        }*/
                                        contadorveces=-1;
                                        break;
                                    case "42":

                                        break;
                                }

                            }else {
                            contadorveces=-1;
                            }
                        }


                    }
        }
                }
            }
                }


    /**
     * Esta metodo cambia la imagen de fondo del panel
     */



    public class PanelFondo extends JPanel{

        private ImageIcon imagenFondo;

        public PanelFondo(){
        this.setSize(500,180);
        imagenFondo=new ImageIcon(getClass().getResource("/resources/estrella.jpg"));
        }

        @Override
        public void paint(Graphics fondo){
        fondo.drawImage(imagenFondo.getImage(),0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        //super.paint(fondo);
        }
    }

}
