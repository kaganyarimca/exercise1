package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;

import javax.swing.*;

public class OperatorGUI  extends JFrame {
    private final Operator operator;

    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_user_list;
    private JButton btn_logout;


    public OperatorGUI(Operator operator){
        this.operator = operator;
        add(wrapper);
        setSize(1000,500);

        // Sayfanın ortasında açılması için x ve y koordinatlarını düzenledik.
        setLocation(Helper.screenCenterPoint("x",getSize()), Helper.screenCenterPoint("y",getSize()));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TİTLE);
        setVisible(true);


        // arayüz kulanımı
       lbl_welcome.setText( "Hoşgeldiniz: "+operator.getName());

    }

    public static void main(String[] args) {
        Helper.setLayout();


        Operator op = new Operator();
        op.setId(1);
        op.setName("Kağan Yarımca");
        op.setPass("123");
        op.setType("Operator");
        op.setUsername("Kagan");

        DBConnector.getInstance();

        OperatorGUI operatorGUI= new OperatorGUI(op);



    }
}
