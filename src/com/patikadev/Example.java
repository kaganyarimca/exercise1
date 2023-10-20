package com.patikadev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JButton btn_login;
    private JPasswordField fld_password;
    private JTextField fld_username;

    public Example(){

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            //System.out.println( info.getName() + "--> " +info.getClassName());  ---> Yazı ayarları ile ilgili bilgiler.
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedLookAndFeelException e) {
                throw new RuntimeException(e);
            }

        }
        setContentPane(wrapper);
        setSize(450 ,300);
        setTitle("Uygulama Adı: ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
                // dıspose_on_close : var olan uygulamanın kapatılmasını sağlar.
        setVisible(true);
        int x = ( Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y= (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;

        setLocation(x,y);


        btn_login.addActionListener(e ->     {
    if(fld_username.getText().length() == 0  || fld_password.getText().length() == 0){
        JOptionPane.showMessageDialog(null,"Tüm alanları doldurun. ","Hata", JOptionPane.INFORMATION_MESSAGE);

        }
        });
    }
}
