
package service;

import domainmodel.KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import viewmodel.KhachHangModel;
import viewmodel.NhanVienModel;

public interface KhachHangService {

    List<KhachHangModel> getAll();

    boolean Save(KhachHangModel khachHang);

    boolean Update(KhachHangModel khachHang);

    boolean Delete(KhachHangModel khachHang);
}
