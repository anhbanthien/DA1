/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.TextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author trong
 */
public class XHelper {
    public boolean checkRong(JTextField tff){
        if(tff.getText().equals("")){
            return true;
        }else{
            return false;
        }
    }
}
