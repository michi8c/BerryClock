/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berryclock;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Michi
 */
public class Gui extends javax.swing.JFrame {

    private Logger logger = Logger.getLogger("MyLog");
    private FileHandler fh;
    private Timer dimm = new Timer();
    private Timer blink = new Timer();
    
    public static final String logInfo = "info";
    public static final String logWarn = "warning";
    public static final String logCrit = "severe";
//    public static final int SW1 = 17;
//    public static final int SW2 = 27;
//    public static final int SW3 = 22;
    
//    private final GpioController gpio = GpioFactory.getInstance();
//    private final GpioPinDigitalInput g20 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_20, PinPullResistance.PULL_UP);
    
    public boolean isDisplayDimmed = false;
    
    private Clock clock;
    
    /**
     * Creates new form Gui
     */
    public Gui() {
        initComponents();
        initListeners();
        initClock();
        toggleMenu(buttonAnwendungen);
        dimmDisplay(100, 10000);
        executeCommand("gpio -g mode 18 pwm");
        executeCommand("xset -display :0.0 s off");
        executeCommand("xset -display :0.0 -dpms");
        executeCommand("xset -display :0.0 s noblank");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAnwendungen = new javax.swing.JPanel();
        buttonClock = new javax.swing.JButton();
        panelEinstellungen = new javax.swing.JPanel();
        buttonWifi = new javax.swing.JButton();
        buttonSetClock = new javax.swing.JButton();
        panelSetClock = new javax.swing.JPanel();
        fieldHour = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fieldMinute = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldSecond = new javax.swing.JTextField();
        button0 = new javax.swing.JButton();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(2, 0), new java.awt.Dimension(0, 1), new java.awt.Dimension(2, 32767));
        panelInfo = new javax.swing.JPanel();
        labelInfoText = new javax.swing.JLabel();
        labelInfoVersion = new javax.swing.JLabel();
        buttonExit = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();
        buttonEinstellungen = new javax.swing.JToggleButton();
        buttonAnwendungen = new javax.swing.JToggleButton();
        panelBack = new javax.swing.JPanel();
        buttonSetClockBack = new javax.swing.JButton();
        buttonSetClockConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 320, 240));
        setCursor(java.awt.Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1,1,BufferedImage.TYPE_4BYTE_ABGR),new java.awt.Point(0,0),"NOCURSOR"));
        setFont(new java.awt.Font("Trebuchet MS", 0, 10)); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAnwendungen.setBackground(new java.awt.Color(0, 0, 102));
        panelAnwendungen.setForeground(new java.awt.Color(255, 255, 255));
        panelAnwendungen.setFocusable(false);
        panelAnwendungen.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        panelAnwendungen.setRequestFocusEnabled(false);
        panelAnwendungen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonClock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clock.png"))); // NOI18N
        buttonClock.setBorder(null);
        buttonClock.setBorderPainted(false);
        buttonClock.setContentAreaFilled(false);
        buttonClock.setFocusable(false);
        panelAnwendungen.add(buttonClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        getContentPane().add(panelAnwendungen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 270, 190));

        panelEinstellungen.setBackground(new java.awt.Color(0, 0, 102));
        panelEinstellungen.setForeground(new java.awt.Color(255, 255, 255));
        panelEinstellungen.setFocusable(false);
        panelEinstellungen.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        panelEinstellungen.setRequestFocusEnabled(false);
        panelEinstellungen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonWifi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wifiOff.png"))); // NOI18N
        buttonWifi.setBorder(null);
        buttonWifi.setBorderPainted(false);
        buttonWifi.setContentAreaFilled(false);
        buttonWifi.setFocusable(false);
        panelEinstellungen.add(buttonWifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        buttonSetClock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clock.png"))); // NOI18N
        buttonSetClock.setBorder(null);
        buttonSetClock.setBorderPainted(false);
        buttonSetClock.setContentAreaFilled(false);
        buttonSetClock.setFocusable(false);
        panelEinstellungen.add(buttonSetClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, -1, -1));

        getContentPane().add(panelEinstellungen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 270, 190));

        panelSetClock.setBackground(new java.awt.Color(0, 0, 102));
        panelSetClock.setForeground(new java.awt.Color(255, 255, 255));
        panelSetClock.setFocusable(false);
        panelSetClock.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        panelSetClock.setRequestFocusEnabled(false);
        panelSetClock.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldHour.setEditable(false);
        fieldHour.setBackground(new Color(0,0,0,0));
        fieldHour.setFont(new java.awt.Font("Open Sans Light", 0, 60)); // NOI18N
        fieldHour.setForeground(new java.awt.Color(51, 255, 255));
        fieldHour.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldHour.setText("00");
        fieldHour.setBorder(null);
        fieldHour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fieldHour.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        fieldHour.setDoubleBuffered(true);
        fieldHour.setEnabled(false);
        fieldHour.setFocusable(false);
        fieldHour.setHighlighter(null);
        fieldHour.setMargin(new java.awt.Insets(5, 5, 5, 5));
        fieldHour.setOpaque(false);
        fieldHour.setPreferredSize(new java.awt.Dimension(75, 75));
        fieldHour.setRequestFocusEnabled(false);
        panelSetClock.add(fieldHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 5, -1, -1));

        jLabel1.setFont(new java.awt.Font("Open Sans Light", 0, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(fieldHour);
        jLabel1.setText(":");
        jLabel1.setFocusable(false);
        jLabel1.setPreferredSize(new java.awt.Dimension(18, 75));
        jLabel1.setRequestFocusEnabled(false);
        panelSetClock.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 0, -1, -1));

        fieldMinute.setEditable(false);
        fieldMinute.setBackground(new Color(0,0,0,0));
        fieldMinute.setFont(new java.awt.Font("Open Sans Light", 0, 60)); // NOI18N
        fieldMinute.setForeground(new java.awt.Color(51, 255, 255));
        fieldMinute.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldMinute.setText("00");
        fieldMinute.setBorder(null);
        fieldMinute.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fieldMinute.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        fieldMinute.setEnabled(false);
        fieldMinute.setFocusable(false);
        fieldMinute.setMargin(new java.awt.Insets(5, 5, 5, 5));
        fieldMinute.setOpaque(false);
        fieldMinute.setPreferredSize(new java.awt.Dimension(75, 75));
        panelSetClock.add(fieldMinute, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 5, -1, -1));

        jLabel2.setFont(new java.awt.Font("Open Sans Light", 0, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setLabelFor(fieldHour);
        jLabel2.setText(":");
        jLabel2.setFocusable(false);
        jLabel2.setPreferredSize(new java.awt.Dimension(18, 75));
        jLabel2.setRequestFocusEnabled(false);
        panelSetClock.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 0, -1, -1));

        fieldSecond.setEditable(false);
        fieldSecond.setBackground(new Color(0,0,0,0));
        fieldSecond.setFont(new java.awt.Font("Open Sans Light", 0, 60)); // NOI18N
        fieldSecond.setForeground(new java.awt.Color(51, 255, 255));
        fieldSecond.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldSecond.setText("00");
        fieldSecond.setBorder(null);
        fieldSecond.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fieldSecond.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        fieldSecond.setEnabled(false);
        fieldSecond.setFocusable(false);
        fieldSecond.setMargin(new java.awt.Insets(5, 5, 5, 5));
        fieldSecond.setOpaque(false);
        fieldSecond.setPreferredSize(new java.awt.Dimension(75, 75));
        panelSetClock.add(fieldSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 5, -1, -1));

        button0.setFont(new java.awt.Font("Open Sans Light", 0, 36)); // NOI18N
        button0.setForeground(new java.awt.Color(255, 255, 255));
        button0.setText("0");
        button0.setBorder(null);
        button0.setContentAreaFilled(false);
        button0.setFocusable(false);
        button0.setName("0"); // NOI18N
        button0.setPreferredSize(new java.awt.Dimension(44, 44));
        panelSetClock.add(button0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 93, -1, -1));

        button1.setFont(new java.awt.Font("Open Sans Light", 0, 36)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("1");
        button1.setBorder(null);
        button1.setContentAreaFilled(false);
        button1.setFocusable(false);
        button1.setName("1"); // NOI18N
        button1.setPreferredSize(new java.awt.Dimension(44, 44));
        panelSetClock.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 93, -1, -1));

        button2.setFont(new java.awt.Font("Open Sans Light", 0, 36)); // NOI18N
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("2");
        button2.setBorder(null);
        button2.setContentAreaFilled(false);
        button2.setFocusable(false);
        button2.setName("2"); // NOI18N
        button2.setPreferredSize(new java.awt.Dimension(44, 44));
        panelSetClock.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 93, -1, -1));

        button3.setFont(new java.awt.Font("Open Sans Light", 0, 36)); // NOI18N
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("3");
        button3.setBorder(null);
        button3.setContentAreaFilled(false);
        button3.setFocusable(false);
        button3.setName("3"); // NOI18N
        button3.setPreferredSize(new java.awt.Dimension(44, 44));
        panelSetClock.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 93, -1, -1));

        button4.setFont(new java.awt.Font("Open Sans Light", 0, 36)); // NOI18N
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setText("4");
        button4.setBorder(null);
        button4.setContentAreaFilled(false);
        button4.setFocusable(false);
        button4.setName("4"); // NOI18N
        button4.setPreferredSize(new java.awt.Dimension(44, 44));
        panelSetClock.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 93, -1, -1));

        button5.setFont(new java.awt.Font("Open Sans Light", 0, 36)); // NOI18N
        button5.setForeground(new java.awt.Color(255, 255, 255));
        button5.setText("5");
        button5.setBorder(null);
        button5.setContentAreaFilled(false);
        button5.setFocusable(false);
        button5.setName("5"); // NOI18N
        button5.setPreferredSize(new java.awt.Dimension(44, 44));
        panelSetClock.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 137, -1, -1));

        button6.setFont(new java.awt.Font("Open Sans Light", 0, 36)); // NOI18N
        button6.setForeground(new java.awt.Color(255, 255, 255));
        button6.setText("6");
        button6.setBorder(null);
        button6.setContentAreaFilled(false);
        button6.setFocusable(false);
        button6.setName("6"); // NOI18N
        button6.setPreferredSize(new java.awt.Dimension(44, 44));
        panelSetClock.add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 137, -1, -1));

        button7.setFont(new java.awt.Font("Open Sans Light", 0, 36)); // NOI18N
        button7.setForeground(new java.awt.Color(255, 255, 255));
        button7.setText("7");
        button7.setBorder(null);
        button7.setContentAreaFilled(false);
        button7.setFocusable(false);
        button7.setName("7"); // NOI18N
        button7.setPreferredSize(new java.awt.Dimension(44, 44));
        panelSetClock.add(button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 137, -1, -1));

        button8.setFont(new java.awt.Font("Open Sans Light", 0, 36)); // NOI18N
        button8.setForeground(new java.awt.Color(255, 255, 255));
        button8.setText("8");
        button8.setBorder(null);
        button8.setContentAreaFilled(false);
        button8.setFocusable(false);
        button8.setName("8"); // NOI18N
        button8.setPreferredSize(new java.awt.Dimension(44, 44));
        panelSetClock.add(button8, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 137, -1, -1));

        button9.setFont(new java.awt.Font("Open Sans Light", 0, 36)); // NOI18N
        button9.setForeground(new java.awt.Color(255, 255, 255));
        button9.setText("9");
        button9.setBorder(null);
        button9.setContentAreaFilled(false);
        button9.setFocusable(false);
        button9.setName("9"); // NOI18N
        button9.setPreferredSize(new java.awt.Dimension(44, 44));
        panelSetClock.add(button9, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 137, -1, -1));

        filler1.setBackground(new java.awt.Color(204, 204, 204));
        filler1.setOpaque(true);
        panelSetClock.add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 250, -1));

        getContentPane().add(panelSetClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 270, 190));

        panelInfo.setFocusable(false);
        panelInfo.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        panelInfo.setPreferredSize(new java.awt.Dimension(320, 50));
        panelInfo.setRequestFocusEnabled(false);
        panelInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelInfoText.setFont(new java.awt.Font("Oxygen", 0, 36)); // NOI18N
        labelInfoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInfoText.setLabelFor(panelInfo);
        labelInfoText.setText("Info");
        labelInfoText.setFocusable(false);
        labelInfoText.setRequestFocusEnabled(false);
        panelInfo.add(labelInfoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 270, 50));

        labelInfoVersion.setFont(new java.awt.Font("Oxygen", 0, 10)); // NOI18N
        labelInfoVersion.setForeground(new java.awt.Color(102, 102, 102));
        labelInfoVersion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelInfoVersion.setText("BerryClock V1");
        labelInfoVersion.setFocusable(false);
        labelInfoVersion.setRequestFocusEnabled(false);
        panelInfo.add(labelInfoVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, -1));

        buttonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        buttonExit.setBorder(null);
        buttonExit.setBorderPainted(false);
        buttonExit.setContentAreaFilled(false);
        buttonExit.setFocusable(false);
        panelInfo.add(buttonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(panelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelMenu.setBackground(new java.awt.Color(0, 0, 69));
        panelMenu.setFocusable(false);
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonEinstellungen.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        buttonEinstellungen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/einstellungen.png"))); // NOI18N
        buttonEinstellungen.setBorder(null);
        buttonEinstellungen.setBorderPainted(false);
        buttonEinstellungen.setContentAreaFilled(false);
        buttonEinstellungen.setFocusable(false);
        buttonEinstellungen.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/einstellungenActive.png"))); // NOI18N
        panelMenu.add(buttonEinstellungen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 50, 50));

        buttonAnwendungen.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        buttonAnwendungen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/berry.png"))); // NOI18N
        buttonAnwendungen.setSelected(true);
        buttonAnwendungen.setBorder(null);
        buttonAnwendungen.setBorderPainted(false);
        buttonAnwendungen.setContentAreaFilled(false);
        buttonAnwendungen.setFocusable(false);
        buttonAnwendungen.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/berryActive.png"))); // NOI18N
        panelMenu.add(buttonAnwendungen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 50, 50));

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 50, 190));

        panelBack.setBackground(new java.awt.Color(0, 0, 69));
        panelBack.setFocusable(false);
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonSetClockBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        buttonSetClockBack.setBorder(null);
        buttonSetClockBack.setBorderPainted(false);
        buttonSetClockBack.setContentAreaFilled(false);
        buttonSetClockBack.setFocusable(false);
        buttonSetClockBack.setPreferredSize(new java.awt.Dimension(50, 50));
        panelBack.add(buttonSetClockBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        buttonSetClockConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirm.png"))); // NOI18N
        buttonSetClockConfirm.setBorder(null);
        buttonSetClockConfirm.setBorderPainted(false);
        buttonSetClockConfirm.setContentAreaFilled(false);
        buttonSetClockConfirm.setFocusable(false);
        buttonSetClockConfirm.setPreferredSize(new java.awt.Dimension(50, 50));
        panelBack.add(buttonSetClockConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        getContentPane().add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 50, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button0;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JToggleButton buttonAnwendungen;
    private javax.swing.JButton buttonClock;
    private javax.swing.JToggleButton buttonEinstellungen;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonSetClock;
    private javax.swing.JButton buttonSetClockBack;
    private javax.swing.JButton buttonSetClockConfirm;
    private javax.swing.JButton buttonWifi;
    private javax.swing.JTextField fieldHour;
    private javax.swing.JTextField fieldMinute;
    private javax.swing.JTextField fieldSecond;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelInfoText;
    private javax.swing.JLabel labelInfoVersion;
    private javax.swing.JPanel panelAnwendungen;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelEinstellungen;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelSetClock;
    // End of variables declaration//GEN-END:variables

    private void initListeners() {
        buttonAnwendungen.addMouseListener(mouse);
        buttonClock.addMouseListener(mouse);
        buttonEinstellungen.addMouseListener(mouse);
        buttonWifi.addMouseListener(mouse);
        buttonExit.addMouseListener(mouse);
        button0.addMouseListener(mouse);
        button1.addMouseListener(mouse);
        button2.addMouseListener(mouse);
        button3.addMouseListener(mouse);
        button4.addMouseListener(mouse);
        button5.addMouseListener(mouse);
        button6.addMouseListener(mouse);
        button7.addMouseListener(mouse);
        button8.addMouseListener(mouse);
        button9.addMouseListener(mouse);
        buttonSetClock.addMouseListener(mouse);
        buttonSetClockBack.addMouseListener(mouse);
        buttonSetClockConfirm.addMouseListener(mouse);
        
        fieldHour.addMouseListener(mouse);
        fieldMinute.addMouseListener(mouse);
        fieldSecond.addMouseListener(mouse);
        
        this.addMouseListener(mouse);
        
//        SW1.addListener(gpioListener);
//        SW2.addListener(gpioListener);
//        SW3.addListener(gpioListener);
    }
    
    private void initClock() {
        clock = new Clock(this);
        clock.addMouseListener(mouse);
        this.add(clock,new AbsoluteConstraints(0, 0, 320, 240));
        clock.setVisible(false);
    }
    
//    private void initGPIO() {
//        executeCommand("gpio -g mode 18 pwm"); //GPIO 18 = Bachlight
//        executeCommand("gpio -g mode " + SW1 + " in"); //Input
//        executeCommand("gpio -g mode " + SW2 + " in"); 
//        executeCommand("gpio -g mode " + SW3 + " in"); 
//        executeCommand("gpio -g mode " + SW1 + " up"); //Pull-up
//        executeCommand("gpio -g mode " + SW2 + " up"); 
//        executeCommand("gpio -g mode " + SW3 + " up");
//    }
    
    private MouseListener mouse = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {

//            System.out.println(g20.getState());
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //Leiste Links Buttons
            if(e.getSource() == buttonAnwendungen) {
                toggleMenu(buttonAnwendungen);
            }
            if(e.getSource() == buttonEinstellungen) {
                toggleMenu(buttonEinstellungen);
            }
            if(e.getSource() == buttonSetClockBack) {
                toggleMenu(buttonSetClockBack);
            }
            if(e.getSource() == buttonSetClockConfirm) {
                toggleMenu(buttonSetClockConfirm);
            }
            
            //Anwendungen Buttons
            if(e.getSource() == buttonClock) {
                panelAnwendungen.setVisible(false);
                panelMenu.setVisible(false);
                panelInfo.setVisible(false);
                clock.setVisible(true);
            }
            
            //Einstellungen Buttons
            if(e.getSource() == buttonWifi) {
                if(wifiStatus())
                    wifiStatus(false);
                else
                    wifiStatus(true);
                updateWifiStatus();
            }
            if(e.getSource() == buttonSetClock) {
                toggleMenu(buttonSetClock);
            }
            
            //Exit
            if(e.getSource() == buttonExit) {
                System.exit(0);
            }
            
            //Clock
            if(e.getSource() == clock) {
                if(isDisplayDimmed) 
                    dimmDisplay(1000, 1); //Wenn beim "klick" gedimmt ist, nur hell machen
                else {
                    clock.setVisible(false);
                    panelAnwendungen.setVisible(true);
                    panelMenu.setVisible(true);
                    panelInfo.setVisible(true);
                }
            }
            
            //Panel SetClock
            if(e.getSource().getClass() == JTextField.class && panelSetClock.isVisible()) {
                fieldHour.setEnabled(false);
                fieldMinute.setEnabled(false);
                fieldSecond.setEnabled(false);
                JTextField t = (JTextField) e.getComponent();
                t.setEnabled(true);
                t.setText("00");
            }
            if(e.getSource().getClass() == JButton.class && panelSetClock.isVisible() && e.getSource() != buttonSetClockBack && e.getSource() != buttonSetClockConfirm) {
                JTextField t = null;
                if(fieldHour.isEnabled())
                    t = fieldHour;
                else if(fieldMinute.isEnabled())
                    t = fieldMinute;
                else if(fieldSecond.isEnabled())
                    t = fieldSecond;
                else
                    return;
                if(t.getText() == "00")
                    t.setText("0" + e.getComponent().getName());
                else
                    t.setText(t.getText().substring(1) + e.getComponent().getName());
            }
            
            //Dimme Display nach jedem Touch
            dimmDisplay(100, 5000);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    };
    
    private GpioPinListenerDigital gpioListener = new GpioPinListenerDigital() {
        @Override
        public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent e) {
            System.out.println("gpioListener: Hit Pin: " + e.getPin() + " Status: " + e.getState());
        }
    };
    
    private void toggleMenu(AbstractButton b) {
        //Toggle Buttons
        if(b.getClass() == JToggleButton.class) { //Toggle nur, wenn Button ein ToggleButton ist!
            buttonAnwendungen.setSelected(false);
            buttonEinstellungen.setSelected(false);
            b.setSelected(true);
        }
        
        //Toggle Menu
        panelAnwendungen.setVisible(false);
        panelEinstellungen.setVisible(false);
        panelBack.setVisible(false);
        panelSetClock.setVisible(false);
        if(b == buttonAnwendungen) {
            panelAnwendungen.setVisible(true);
            labelInfoText.setText("Anwendungen");
        }
        if(b == buttonEinstellungen) {
            panelEinstellungen.setVisible(true);
            labelInfoText.setText("Einstellungen");
            updateWifiStatus(); 
        }
        if(b == buttonSetClock) {
            labelInfoText.setText("Uhrzeit");
            panelSetClock.setVisible(true);
            panelEinstellungen.setVisible(false);
            panelMenu.setVisible(false);
            panelBack.setVisible(true);
        }
        if(b == buttonSetClockBack) {
            labelInfoText.setText("Einstellungen");
            panelBack.setVisible(false);
            panelMenu.setVisible(true);
            panelSetClock.setVisible(false);
            panelEinstellungen.setVisible(true);
        }
        if(b == buttonSetClockConfirm) {
            if(pruefeClockFormat()) {
                executeCommand("date 0419" + fieldHour.getText() + fieldMinute.getText() + "17." + fieldSecond.getText());
                panelBack.setVisible(false);
                panelMenu.setVisible(true);
                panelSetClock.setVisible(false);
                panelEinstellungen.setVisible(true);
                labelInfoText.setText("Einstellungen");
            }
            else {
                JOptionPane.showMessageDialog(panelSetClock, "Falsches Format eingegeben!");
                panelSetClock.setVisible(true);
                panelBack.setVisible(true);
            }
        }
    }
    
    public void writeLog(String text, String sev) {
        try {
            fh = new FileHandler("/var/log/myLog.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            switch(sev) {
                case "info": {logger.info(sdf.format(date) + ": " + text);break;}
                case "warning": {logger.warning(sdf.format(date) + ": " + text);break;}
                case "severe": {logger.severe(sdf.format(date) + ": " + text);break;}
            }
        } 
        catch (Exception e) {
        }
    }
    
    public String executeCommand(String command) {
        String output = "";
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            Process cmdProc = Runtime.getRuntime().exec(command);
            BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(cmdProc.getInputStream()));
            String line;
            
            while ((line = stdoutReader.readLine()) != null) {
               output = output + "\n" +line;
            }

            BufferedReader stderrReader = new BufferedReader(
                     new InputStreamReader(cmdProc.getErrorStream()));
            while ((line = stderrReader.readLine()) != null) {
               // process procs standard error here
            }
            int retValue = cmdProc.exitValue();
            } 
        catch (Exception e) { }
        this.setCursor(java.awt.Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1,1,BufferedImage.TYPE_4BYTE_ABGR),new java.awt.Point(0,0),"NOCURSOR"));
        return output;
    }
    
    public synchronized void dimmDisplay(int brightness, int ms) {
        executeCommand("gpio -g pwm 18 1000");
        isDisplayDimmed = false;
        
        this.dimm.cancel();
        this.dimm = new Timer();
        
        TimerTask action = new TimerTask() {
            @Override
            public void run() {
                executeCommand("gpio -g pwm 18 " + brightness);
                isDisplayDimmed = true;
            }
        };
        this.dimm.schedule(action, ms);
    }
    
    public synchronized void blinkDisplay(int rhytm, int repeat) {
        this.blink.cancel();
        this.blink = new Timer();
        
        TimerTask action = new TimerTask() {
            @Override
            public void run() {
                for(int i = 0;i<repeat;i++)
                {
                    executeCommand("gpio -g pwm 18 1000");
                    try {
                        Thread.sleep(rhytm);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    executeCommand("gpio -g pwm 18 100");
                    try {
                        Thread.sleep(rhytm);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        this.blink.schedule(action, 1);
    }
    
    private void updateWifiStatus() {
        if(wifiStatus())
            buttonWifi.setIcon(new ImageIcon(getClass().getResource("/images/wifiOn.png")));
        else
            buttonWifi.setIcon(new ImageIcon(getClass().getResource("/images/wifiOff.png")));
    }
    
    private void wifiStatus(boolean b) {
        if(b)
            executeCommand("ifup wlan0");
        else
            executeCommand("ifdown wlan0");
    }
    
    private boolean wifiStatus() {
        String result = executeCommand("ifconfig wlan0");
        if(result.contains("inet Adresse")) 
            return true;
        else
            return false;
    }
    
    private boolean pruefeClockFormat() {
        if(Integer.parseInt(fieldHour.getText()) > 23)
            return false;
        if(Integer.parseInt(fieldMinute.getText()) > 59)
            return false;
        if(Integer.parseInt(fieldSecond.getText()) > 59)
            return false;
        return true;
    }
    
}
