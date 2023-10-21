package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorGUI  extends JFrame {
    private final Operator operator;

    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_user_list;
    private JButton btn_logout;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private JTextField fld_user_name;
    private JTextField fld_user_uname;
    private JTextField fld_user_pass;
    private JComboBox cmb_user_type;
    private JButton btn_user_add;
    private DefaultTableModel mdl_user_list;
    private  Object[] row_user_list;


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

       // ModelUserList
        mdl_user_list = new DefaultTableModel();
        Object[] col_user_list = {"ID","Ad Soyad" ," Kullanıcı Adı","Şifre","Üyelik Tipi"};
        mdl_user_list.setColumnIdentifiers(col_user_list);


        /*

        // Tabloya data ekleme işlemi.
        Object[] firstRow = {"1","Kğn Yrmc","kağan","123", "operator"};
        mdl_user_list.addRow(firstRow);

         */

        // Veritabanından verileri çekme işlemi:
        for(User obj : User.getList()){
             Object[] row  = new Object[col_user_list.length];
             row[0] = obj.getId();
             row[1] = obj.getName();
             row[2] = obj.getUsername();
             row[3] = obj.getPass();
             row[4] = obj.getType();

             mdl_user_list.addRow(row);
        }



        tbl_user_list.setModel(mdl_user_list);

        // Tablodaki column isimlerinin yerlerininin değişmemesi için yapılan işlem.
        tbl_user_list.getTableHeader().setReorderingAllowed(false);

        btn_user_add.addActionListener(e -> {
    if(Helper.isFieldEmpty(fld_user_name) || Helper.isFieldEmpty(fld_user_uname) || Helper.isFieldEmpty(fld_user_pass)    ){

        // Hata verdirme işlemi
        Helper.showMessage("Manuel eklendi");
    }else{

    String name = fld_user_name.getText();
    String uname = fld_user_uname.getText();
    String pass = fld_user_pass.getText();
    String type = cmb_user_type.getSelectedItem().toString();
    if(User.add(name,uname,pass,type)){
        Helper.showMessage("done");
    }else{
        Helper.showMessage("error");
    }
    }


        });
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
