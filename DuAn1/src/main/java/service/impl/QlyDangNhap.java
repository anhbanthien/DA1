/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import repository.DangNhapRepository;
import service.IQuanLyDangNhap;

/**
 *
 * @author Admin
 */
public class QlyDangNhap implements IQuanLyDangNhap {

    @Override
    public boolean checkLogin(String Acc, String Pass) {
        return new DangNhapRepository().CheckLogin(Acc, Pass);
    }

}
