/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.DangNhap;

/**
 *
 * @author Admin
 */
public interface IQuanLyDangNhap {

    DangNhap checkLogin(String Acc, String Pass);
    

}
