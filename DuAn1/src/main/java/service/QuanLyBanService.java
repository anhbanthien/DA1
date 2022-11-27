/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import domainmodel.Ban;
import java.util.UUID;
import reponse.BanReponse;

/**
 *
 * @author vutuo
 */
public interface QuanLyBanService {

    List<BanReponse> getAll();

    String add(Ban ban);

    String update(Ban ban);

    String delete(Ban ban);

    Ban getOne(int IDB);
}
