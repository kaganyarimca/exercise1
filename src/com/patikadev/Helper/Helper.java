package com.patikadev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void setLayout(){
        for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }

    public static int screenCenterPoint(String eksen, Dimension size){
        int point  ;
        switch (eksen){
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width ) / 2 ;
                break;
            case "y":
                point =(Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
               point = 0;
        }
        return  point;

    }


    public static boolean isFieldEmpty(JTextField field){
        return  field.getText().trim().isEmpty() ;

    }

    public static  void showMessage(String str){
        optionPaneTR();
        String msg ;
        String title;
        switch (str){
            case "fill":
                msg = "Lütfen tüm alanları doldurunuz!";
                title = "Hata";
                break;
            case "done":
                msg =  "İşlem başarılı.";
                title = "İşlem başarılı";
            case "error":
                msg = "Bir hata oluştu";
                title = "Hata";



            default:
                msg = str;
                title = "Mesaj";
        }

        JOptionPane.showMessageDialog(null,msg , title, JOptionPane.INFORMATION_MESSAGE);

    }

    // Panelde uyarı olarak bilgi ekranı geldiğinde, üzerinde yazan OK butonu TAMAM şeklinde yeniden düzenlendi.
    public static void optionPaneTR(){
        UIManager.put("OptionPane.okButtonText", "Tamam");
    }
}
