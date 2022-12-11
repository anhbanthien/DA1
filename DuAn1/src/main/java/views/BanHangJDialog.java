/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import domainmodel.Ban;
import domainmodel.DangNhap;
import domainmodel.HoaDon;
import domainmodel.KhachHang;
import domainmodel.KhuyenMai;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import reponse.BanReponse;
import repository.HoaDonRepository;
import repository.KhachHangRepository;
import repository.KhuyenMaiRepository;
import repository.NhanVienRepository;
import service.*;
import service.impl.*;
import viewmodel.HoaDonModel;
import viewmodel.KhachHangModel;
import viewmodel.QLHDCT;
import viewmodel.QLSanPham;

/**
 *
 * @author vanlo
 */
public class BanHangJDialog extends javax.swing.JDialog {

    /**
     * Creates new form BanHangJDialog
     */
    IManageSanPhamService sanPhamService = new ManageSanPhamService();
    DangNhap _dn = null;
    List<QLSanPham> sanPhams = new ArrayList<>();
    HoaDonService hoaDonService = new HoaDonServiceImpl();
    HoaDonRepository hoaDonRepository = new HoaDonRepository();
    List<HoaDonModel> hoaDons = new ArrayList<>();
    KhachHangService khachHangService = new KhachHangServiceImpl();
    KhachHangRepository khachHangRepository = new KhachHangRepository();
    KhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImp();
    List<KhachHangModel> khachHangs = new ArrayList<>();
    IManageHDCTService hoaDonCTService = new ManageHDCTService();
    IQlyNhanVien QlyNhanVien = new QlyNhanVienImpl();
    NhanVienRepository nhanVienRepository = new NhanVienRepository();
    List<QLHDCT> QLHDCTs = new ArrayList<>();
    DefaultTableModel _Model = new DefaultTableModel();
    QuanLyBanService banService = new QuanLyBanServiceImpl();
    List<BanReponse> bans = new ArrayList<>();
    List<ban> banss = new ArrayList<>();
    KhuyenMai khuyenMai = new KhuyenMai();
    float PtramKM = 0;
    int _ban = 0;
    int _banBD = 0;
    UUID _idHD = null;
    UUID _idSP = null;
    UUID _idKH = null;
    UUID _idHDCT = null;
    float tienTong;
    float tienGiam = 0;
    float tienTT;
    int u = 0;

    public BanHangJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        loadTableSanPham();
        loadTableBan();
        txtTienTong.setEnabled(false);
        txtTienGiam.setEnabled(false);
        txtTienTT.setEnabled(false);
        txtTienTong.setEnabled(false);
        btnThanhToan.setEnabled(false);
        txtsp1.setEnabled(false);
        txtTien.setEnabled(false);

    }

    public BanHangJDialog(java.awt.Frame parent, boolean modal, DangNhap dn) {
        super(parent, modal);
        _dn = dn;
        initComponents();
        loadTableSanPham();
        loadTableBan();
        txtTienTong.setEnabled(false);
        txtTienGiam.setEnabled(false);
        txtTienTT.setEnabled(false);
        txtTienTong.setEnabled(false);
        btnThanhToan.setEnabled(false);

    }

    private void loadTablehoaDon(String TT) {
        List<HoaDonModel> hoaDonlist = new ArrayList<>();
        hoaDonlist = new HoaDonServiceImpl().getHoaDonByTT(TT);
        _Model = new DefaultTableModel();
        _Model = (DefaultTableModel) tblHoaDon.getModel();
        _Model.setRowCount(0);
        hoaDons.clear();
        hoaDons = hoaDonlist;
        if (TT.equals("Chờ TT")) {
            TT = "chưa thanh toán";
        } else if (TT.equals("DTT")) {
            TT = "Đã thanh toán";
        } else if (TT.equals("DH")) {
            TT = "Đã hủy";
        }
        for (int i = 0; i < hoaDonlist.size(); i++) {
            if (hoaDons.get(i).getIDKH() == null) {
                _Model.addRow(new Object[]{"Chưa có tên", hoaDonlist.get(i).getNgayTao(), TT});
            } else {
                _Model.addRow(new Object[]{hoaDons.get(i).getIDKH().getTen(), hoaDonlist.get(i).getNgayTao(), TT});
            }

        }

    }

    private void txttien() {
        tienTong = 0;
        for (QLHDCT hdctt : QLHDCTs) {
            tienTong = tienTong + hdctt.getTien();
        }
        if (khuyenMai == null) {
            tienGiam = 0;
        } else {
            tienGiam = tienTong * khuyenMai.getPhanTramKM() / 100;
        }
        System.out.println(tienGiam);
        tienTT = tienTong - tienGiam;
        txtTienTong.setText(tienTong + "");
        txtTienGiam.setText(tienGiam + "");
        txtTienTT.setText(tienTT + "");
    }

    private void loadTablehoaDonCT(HoaDonModel hoaDon) {

        _Model = new DefaultTableModel();
        QLHDCTs = new ArrayList<>();
        _Model = (DefaultTableModel) tblHoaDonCT.getModel();
        _Model.setRowCount(0);
        if (hoaDon == null) {
            return;
        }
        QLHDCTs = new ManageHDCTService().getListbyHD(_idHD);
        if (QLHDCTs.size() == 0) {
            return;
        }
        for (int i = 0; i < QLHDCTs.size(); i++) {
            _Model.addRow(new Object[]{QLHDCTs.get(i).getTenSP(), QLHDCTs.get(i).getSoLuong(), QLHDCTs.get(i).getTien()});
        }
    }

    private KhachHangModel getKhachHangtxt() {
        KhachHangModel kh = new KhachHangModel();
        kh.setTen(txtTenKH2.getText());
        kh.setSoDienThoai(txtSDT2.getText());
        kh.setDiemTichLuy(0);
        kh.setTrangThai("ON");
        return kh;
    }

    private HoaDon getformHoaDon() {
        HoaDon hd = hoaDonRepository.getOne(_idHD);
        if (_idKH != null) {
            KhachHang kh = new KhachHangRepository().getOne(_idKH);
            hd.setIDKH(kh);
        }
        hd.setTongTien(tienTong);
        hd.setTienTra(tienTT);

        return hd;
    }

    public void loadTableBan() {
        bans.clear();
        List<BanReponse> banst = banService.getAll();
        for (BanReponse ban : banst) {
            if (ban.getTrangThaiBan().equals("Đang Hoạt Động")) {
                bans.add(ban);
            }
        }
        pnlBan.setLayout(null);
        autoGenBan();
        pnlBan.setPreferredSize(new Dimension(450, ((bans.size() / 4 + 1) * 80 + 30)));
    }

    void autoGenBan() {
        int line = 0;
        if (bans.size() == 0) {
            return;
        }
        for (int i = 0; i < bans.size(); i++) {
//			System.out.println(line);
            ban ba = new ban(bans.get(i), i);
//            if (bans.get(i).getIDB() == _ban && _ban != 0) {
//                ba.setBackground(Color.BLUE);
//                System.out.println(_ban);
//                _ban = 0;
//            }
            ba.setBounds((112 * line++) + 5, (80 * Integer.parseInt(String.valueOf((i / 4))) + 25), 110, 80);
            ba.setBorder(BorderFactory.createEtchedBorder());
            ba.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
//                    if(ba.getTrangthai()==0){
//                        JOptionPane.showMessageDialog(new JOptionPane(), "Bàn này đã đầy người");
//                        return;
//                    }else{
                    int value = ba.getBan().getIDB();
                    for (ban ban : banss) {
                        ban.setmau(value, _banBD);
                    }
                    _ban = value;

//                    if (ba.getBackground() == Color.PINK) {
//                        for (int i = 0; i < banss.size(); i++) {
//                            banss.get(i).setBackground(Color.GREEN);
//
//                        }
//                        ba.setBackground(Color.PINK);
//                    }
//                    for (int i = 0; i < banss.size(); i++) {
//                        banss.get(i).setBackground(Color.GREEN);
//
//                    }
//                    _ban = ba.getBan().getIDB();
//                    ba.setBackground(Color.PINK);
                }
            });
            banss.add(ba);
            pnlBan.add(banss.get(i));
            if (line > 3) {
                line = 0;
            }
        }

    }

    public void loadTableSanPham() {
        sanPhams.clear();
        sanPhams = new ArrayList<>();

        sanPhams = sanPhamService.getAll();
        pnlSanPham.setLayout(null);
        autoGenSP();
        pnlSanPham.setPreferredSize(new Dimension(450, ((sanPhams.size() / 4 + 1) * 150 + 30)));
        pnlSanPham.setMinimumSize(new Dimension(450, ((sanPhams.size() / 4 + 1) * 150 + 30)));
        pnlSanPham.setSize(new Dimension(450, ((sanPhams.size() / 4 + 1) * 150 + 30)));

    }

    void autoGenSP() {
        int line = 0;
        for (int i = 0; i < sanPhams.size(); i++) {
//			System.out.println(line);
            BSanPham th = new BSanPham(sanPhams.get(i), i);
            th.setBounds((112 * line++) + 5, (150 * Integer.parseInt(String.valueOf((i / 4))) + 25), 110, 150);
            th.setBorder(BorderFactory.createEtchedBorder());
            th.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
//					 th.setBackground(Color.red);
                    u = th.getU();
                    System.out.println(u);
                    _idSP = th.getSp().getIDSP();
                    txtsp1.setText(th.getSp().getTenSP());
                    int tien = (int) th.getSp().getGia() * (int) txtsl.getValue();
                    System.out.println(tien);
                    txtTien.setText(String.valueOf(tien));
                    lblanhSP.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/" + th.getSp().getImage())).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT)));

                }
            });
            pnlSanPham.add(th);
            if (line > 3) {
                line = 0;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        j2 = new javax.swing.JLabel();
        j3 = new javax.swing.JLabel();
        j4 = new javax.swing.JLabel();
        j5 = new javax.swing.JLabel();
        txtTienTong = new javax.swing.JTextField();
        txtTienGiam = new javax.swing.JTextField();
        txtTienTT = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        txtTenKH = new javax.swing.JTextField();
        j6 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        txtSdt = new javax.swing.JTextField();
        j7 = new javax.swing.JLabel();
        j8 = new javax.swing.JLabel();
        txtTienKD = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        txtMaKM = new javax.swing.JTextField();
        j9 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        lblKM = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtTien = new javax.swing.JTextField();
        txtsp5 = new javax.swing.JLabel();
        txtsl = new javax.swing.JSpinner();
        txtsp3 = new javax.swing.JLabel();
        txtsp1 = new javax.swing.JTextField();
        j1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTenKH2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSDT2 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblHoaDonCT = new javax.swing.JTable();
        lblanhSP = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        rdoHDC = new javax.swing.JRadioButton();
        rdoHDD = new javax.swing.JRadioButton();
        rdoHDH = new javax.swing.JRadioButton();
        pnlBanJsp = new javax.swing.JScrollPane();
        pnlBan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlSanPham = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 102));

        jPanel2.setBackground(new java.awt.Color(139, 110, 96));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(249, 238, 231));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));
        jPanel6.setPreferredSize(new java.awt.Dimension(450, 258));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setText("Tạo Hóa Đơn");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, 20));

        j2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j2.setText("Tên Khách Hàng");
        jPanel6.add(j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 108, -1));

        j3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j3.setText("Tổng Tiền:");
        jPanel6.add(j3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 70, -1));

        j4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j4.setText("Tiền Thanh Toán:");
        jPanel6.add(j4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 108, -1));

        j5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j5.setText("Tiền giảm giá:");
        jPanel6.add(j5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, -1));

        txtTienTong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel6.add(txtTienTong, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 170, -1));

        txtTienGiam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel6.add(txtTienGiam, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 170, -1));

        txtTienTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel6.add(txtTienTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 170, -1));

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel6.add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 117, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Lưu HD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 117, -1));

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton10.setText("Clear");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 114, -1));

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel6.add(txtTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 170, -1));

        j6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j6.setText("Số Điện Thoại:");
        jPanel6.add(j6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 108, -1));

        jButton15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton15.setText("Tìm KH");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 117, -1));

        txtSdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSdt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtSdtMouseExited(evt);
            }
        });
        jPanel6.add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 173, -1));

        j7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j7.setText("Tiền Khách đưa:");
        jPanel6.add(j7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 100, -1));

        j8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j8.setText("Tiền Thừa:");
        jPanel6.add(j8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 70, -1));

        txtTienKD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTienKD.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKDCaretUpdate(evt);
            }
        });
        txtTienKD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKDActionPerformed(evt);
            }
        });
        jPanel6.add(txtTienKD, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 170, -1));

        txtTienThua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel6.add(txtTienThua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 170, -1));

        txtMaKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel6.add(txtMaKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 170, -1));

        j9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j9.setText("Mã Khuyến Mãi:");
        jPanel6.add(j9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 108, -1));

        jButton16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton16.setText("Tìm KM");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 117, -1));

        lblKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel6.add(lblKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 163, 108, 26));

        jButton1.setText("In HD");
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 110, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, 460, 360));

        jPanel8.setBackground(new java.awt.Color(249, 238, 231));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chi tiết"));
        jPanel8.setPreferredSize(new java.awt.Dimension(350, 124));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton9.setText("Xóa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 116, -1, -1));

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton7.setText("Sửa");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Thêm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        txtTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienActionPerformed(evt);
            }
        });
        jPanel8.add(txtTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 117, 128, -1));

        txtsp5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsp5.setText("Thành tiền");
        jPanel8.add(txtsp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 117, -1, 26));

        txtsl.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
        txtsl.setPreferredSize(new java.awt.Dimension(32, 26));
        txtsl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtslStateChanged(evt);
            }
        });
        jPanel8.add(txtsl, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 72, 56, -1));

        txtsp3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsp3.setText("số lượng");
        jPanel8.add(txtsp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 69, -1, 26));

        txtsp1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel8.add(txtsp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 27, 144, -1));

        j1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j1.setText("Tên sản phẩm");
        jPanel8.add(j1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 30, -1, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 330, 170));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bán Coffee");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, -1, -1));

        jPanel7.setBackground(new java.awt.Color(249, 238, 231));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Khách hàng"));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tên khách hàng:");

        txtTenKH2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("SÐT:");

        txtSDT2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSDT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtSDT2MouseExited(evt);
            }
        });
        txtSDT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDT2ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton14.setText("Thêm");
        jButton14.setToolTipText("");
        jButton14.setPreferredSize(new java.awt.Dimension(57, 29));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKH2)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenKH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 330, 140));

        jPanel3.setBackground(new java.awt.Color(249, 238, 231));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chi tiết"));
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 148));

        tblHoaDonCT.setBackground(new java.awt.Color(255, 255, 204));
        tblHoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Sản Phẩm", " Số Lương ", "Giá"
            }
        ));
        tblHoaDonCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonCTMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblHoaDonCT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 440, 170));

        lblanhSP.setBackground(new java.awt.Color(0, 0, 0));
        lblanhSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblanhSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 40, 110, 150));

        jPanel1.setBackground(new java.awt.Color(249, 238, 231));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 278));

        tblHoaDon.setBackground(new java.awt.Color(255, 255, 204));
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Khách Hang", "Ngày tạo", "Tình trạng"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        buttonGroup1.add(rdoHDC);
        rdoHDC.setText("Chua thanh toán");
        rdoHDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHDCActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHDD);
        rdoHDD.setText("đã thanh toán");
        rdoHDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHDDActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHDH);
        rdoHDH.setText("đã hủy");
        rdoHDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHDHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoHDC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoHDD)
                .addGap(30, 30, 30)
                .addComponent(rdoHDH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoHDC)
                    .addComponent(rdoHDD)
                    .addComponent(rdoHDH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 330, 193));

        pnlBan.setBackground(new java.awt.Color(255, 255, 204));
        pnlBan.setBorder(javax.swing.BorderFactory.createTitledBorder("Bàn"));

        javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan);
        pnlBan.setLayout(pnlBanLayout);
        pnlBanLayout.setHorizontalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlBanLayout.setVerticalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlBanJsp.setViewportView(pnlBan);

        jPanel2.add(pnlBanJsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 420, 170));

        pnlSanPham.setBackground(new java.awt.Color(255, 255, 204));
        pnlSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));
        pnlSanPham.setPreferredSize(new java.awt.Dimension(500, 250));

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(pnlSanPham);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 410, 340));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/denNodelPng.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 630, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1278, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        HoaDon hd = new HoaDon();
        hd.setTrangThai("Chờ TT");
        System.out.println(nhanVienRepository.getAll().get(0).getHoTen());
        if (_dn == null) {
            hd.setIDNV(nhanVienRepository.getAll().get(0));
        } else {
            hd.setIDNV(nhanVienRepository.getOne(_dn.getIdNhanVien().getIdNhanVien()));
        }
//        hd.setIDKM(khuyenMaiRepository.getAll().get(0));
        long millis = System.currentTimeMillis();
        hd.setNgayTao(new Date(millis));
        hd.setNgayTT(new Date(millis));
        if (new HoaDonRepository().add(hd)) {
            JOptionPane.showMessageDialog(this, "Succes");
        } else {
            JOptionPane.showMessageDialog(this, "Failed");
        }

        rdoHDC.setEnabled(true);
        loadTablehoaDon("Chờ TT");
        loadTableSanPham();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        HoaDon hd = getformHoaDon();
        if (_ban != 0) {
            hd.setIDB(banService.getOne(_ban));
        }
        long millis = System.currentTimeMillis();
        hd.setNgayTT(new Date(millis));
        hd.setIDB(null);
        hd.setIDKM(khuyenMai);
        hd.setTrangThai("DTT");
        if (hoaDonRepository.Update(hd)) {
            JOptionPane.showMessageDialog(this, "Succes");
            if (_ban != 0) {
                Ban banv = banService.getOne(_ban);
                banv.setTrangThaiBan("Đang Hoạt Động");
                JOptionPane.showMessageDialog(this, banService.update(banv));
            }

        } else {
            JOptionPane.showMessageDialog(this, "Failed");
        }
        txtTienKD.setText("");
        loadTablehoaDon("Chờ TT");
        loadTableBan();
        ///////////
        khuyenMai = null;
        txtMaKM.setText("");
        lblKM.setText("");
        QLHDCTs.clear();
        QLHDCTs = new ArrayList<>();
        loadTablehoaDonCT(null);
        //        _Model = new DefaultTableModel();
        //        _Model = (DefaultTableModel) tblSanPham.getModel();
        //        _Model.setRowCount(0);
        _idSP = null;
        txtsp1.setText("");
        txtSDT2.setText("");
        txtSdt.setText("");
        txtTenKH.setText("");
        txtTenKH2.setText("");
        txtSdt.setText("");
        txtSdt.setText("");
        loadTableBan();
        txtTienKD.setText("");
        btnThanhToan.setEnabled(false);
        loadTablehoaDonCT(null);
        txtTien.setText("0");
        for (int i = 0; i < banss.size(); i++) {
            banss.get(i).setmauBD();
        }
        _ban = 0;
        _banBD = 0;
        txttien();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HoaDon hd = getformHoaDon();
//        System.out.println(khuyenMai.getMaKM());
//        System.out.println(_ban);
        hd.setIDKM(khuyenMai);
        if (_ban == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có bàn ko thể lưu hóa đơn được");
            return;
        } else {
            hd.setIDB(banService.getOne(_ban));
            if (hoaDonRepository.Update(hd)) {
                JOptionPane.showMessageDialog(this, "Succes");
            } else {
                JOptionPane.showMessageDialog(this, "Failed");
            }

            txtTienKD.setText("");
            loadTablehoaDon("Chờ TT");
            khuyenMai = null;
            txtMaKM.setText("");
            lblKM.setText("");
            QLHDCTs.clear();
            QLHDCTs = new ArrayList<>();
            loadTablehoaDonCT(null);
            //        _Model = new DefaultTableModel();
            //        _Model = (DefaultTableModel) tblSanPham.getModel();
            //        _Model.setRowCount(0);
            _idSP = null;
            txtsp1.setText("");
            txtSDT2.setText("");
            txtSdt.setText("");
            txtTenKH.setText("");
            txtTenKH2.setText("");
            txtSdt.setText("");
            txtSdt.setText("");
            loadTableBan();
            txtTienKD.setText("");
            btnThanhToan.setEnabled(false);
            loadTablehoaDonCT(null);
            txtTien.setText("0");
            for (int i = 0; i < banss.size(); i++) {
                banss.get(i).setmauBD();
            }
            _ban = 0;
            _banBD = 0;
            txttien();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        _Model = new DefaultTableModel();
        QLHDCTs.clear();
        QLHDCTs = new ArrayList<>();
        loadTablehoaDonCT(null);
        //        _Model = new DefaultTableModel();
        //        _Model = (DefaultTableModel) tblSanPham.getModel();
        //        _Model.setRowCount(0);
        _idSP = null;
        txtsp1.setText("");
        txtSDT2.setText("");
        txtSdt.setText("");
        txtTenKH.setText("");
        txtTenKH2.setText("");
        txtSdt.setText("");
        txtSdt.setText("");
        khuyenMai = null;
        txtMaKM.setText("");
        lblKM.setText("");
        loadTableBan();
        txtTienKD.setText("");
        txtMaKM.setText("");
        lblKM.setText("");
        btnThanhToan.setEnabled(false);
        loadTablehoaDonCT(null);
        txtTien.setText("0");
        for (int i = 0; i < banss.size(); i++) {
            banss.get(i).setmauBD();
        }
        _ban = 0;
        _banBD = 0;
        txttien();
        khuyenMai = null;

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        if (txtSdt.getText() == null) {
            System.out.println("1");
            return;
        }
        System.out.println("2");
        String Sdt = txtSdt.getText();
        System.out.println(txtSdt.getText());
        System.out.println(Sdt);
        KhachHangModel kh = new KhachHangModel();
        try {
            kh = khachHangService.getOne(Sdt);
        } catch (Exception e) {
            return;
        }
        if (khachHangService.getOne(Sdt) == null) {
            return;
        }
        kh = khachHangService.getOne(Sdt);
        _idKH = kh.getId();
        txtTenKH.setText(kh.getTen());
    }//GEN-LAST:event_jButton15ActionPerformed

    private void txtSdtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSdtMouseExited
        if (txtSdt.getText().isBlank()) {
            return;
        }
        return;
        //        try {
        //            Integer.parseInt(txtSdt.getText());
        //        } catch (Exception e) {
        //            JOptionPane.showMessageDialog(this, "SĐT chỉ đc nhập số");
        //        }
    }//GEN-LAST:event_txtSdtMouseExited

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        QLHDCT HDCT = new QLHDCT();
//        if(_idHDCT != null){
//            HDCT = hoaDonCTService.getOne(_idHDCT);
//            System.out.println("56");
//        }
//        else{
//        HDCT = hoaDonCTService.getOne(_idHD, _idSP);
//        } 

        JOptionPane.showMessageDialog(this, new BanHangService().delete(_idHDCT));
        System.out.println(2);
        System.out.println(_idHD);
        System.out.println(3);
        System.out.println(_idHDCT);
        System.out.println(hoaDonService.getOne(_idHD).getIDKH());
        loadTablehoaDonCT(hoaDonService.getOne(_idHD));
        txttien();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        System.out.println(_idHD);
        System.out.println(_idSP);
        System.out.println("12");
        QLHDCT HDCT = new QLHDCT();
        if (_idHDCT != null) {
            HDCT = hoaDonCTService.getOne(_idHDCT);
            System.out.println("56");
        } else {
            HDCT = hoaDonCTService.getOne(_idHD, _idSP);
        }
        HDCT.setSoLuong((int) txtsl.getValue());
        System.out.println(HDCT.getIdHD());
        System.out.println(HDCT.getIdSP());
        System.out.println(HDCT.getSoLuong());

        JOptionPane.showMessageDialog(this, new BanHangService().update(HDCT, _idHDCT));
        System.out.println(2);
        System.out.println(_idHD);
        System.out.println(3);
        System.out.println(hoaDonService.getOne(_idHD).getIDKH());
        loadTablehoaDonCT(hoaDonService.getOne(_idHD));
        txttien();
//        if (QLHDCTs.size() != 0) {
//            for (int i = 0; i < QLHDCTs.size(); i++) {
//                if (QLHDCTs.get(i).getIdSP() == _idSP) {
//                    QLHDCT HDCTT = new QLHDCT(_idHD, _idSP, (int) txtsl.getValue());
//                    HDCT.setSoLuong((int) txtsl.getValue()+QLHDCTs.get(i).getSoLuong());
//                    JOptionPane.showMessageDialog(this,hoaDonCTService.update(HDCT.getIdHD(),HDCT));
//                    JOptionPane.showMessageDialog(this, "Đã có sản Phầm này");
//                    return;
//                }
//            }
//        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if (new BanHangService().getOne(_idHD, _idSP) != null) {
            QLHDCT HDCT = new BanHangService().getOne(_idHD, _idSP);
            HDCT.setSoLuong((int) txtsl.getValue() + HDCT.getSoLuong());
            JOptionPane.showMessageDialog(this, "Đã có sản Phầm này");
            JOptionPane.showMessageDialog(this, new BanHangService().update(HDCT, HDCT.getIdHDCT()));
            System.out.println(hoaDonService.getOne(_idHD));
            loadTablehoaDonCT(hoaDonService.getOne(_idHD));
            txttien();
        } else {
            QLHDCT HDCT = new QLHDCT(_idHD, _idSP, (int) txtsl.getValue());
            JOptionPane.showMessageDialog(this, hoaDonCTService.add(HDCT));
            System.out.println(hoaDonService.getOne(_idHD));
            loadTablehoaDonCT(hoaDonService.getOne(_idHD));
            txttien();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienActionPerformed

    private void txtslStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtslStateChanged

        QLSanPham sanPham = sanPhamService.getOne(_idSP);
        int tien = (int) sanPham.getGia() * (int) txtsl.getValue();
        txtTien.setText(Float.toString(tien));
    }//GEN-LAST:event_txtslStateChanged

    private void txtSDT2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSDT2MouseExited
        if (txtSDT2.getText().isBlank()) {
            return;
        }
        try {
            Integer.parseInt(txtSDT2.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "SĐT chỉ đc nhập số");
        }
    }//GEN-LAST:event_txtSDT2MouseExited

    private void txtSDT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDT2ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        KhachHangModel khachHang = getKhachHangtxt();
        try {
            KhachHangModel kh = khachHangService.getOne(khachHang.getSoDienThoai());
            JOptionPane.showMessageDialog(this, "đã có Khách hàng này");
            txtSdt.setText(txtSDT2.getText());
            return;
        } catch (Exception e) {
            if (khachHangService.Save(khachHang) == true) {
                JOptionPane.showMessageDialog(this, "Thêm Thành công");
                txtSdt.setText(txtSDT2.getText());

            } else {
                JOptionPane.showMessageDialog(this, "Thêm Thất bại");
            }
        }

    }//GEN-LAST:event_jButton14ActionPerformed

    private void tblHoaDonCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonCTMouseClicked
        int rowIndex = tblHoaDonCT.getSelectedRow();

        if (rowIndex == -1) {
            return;
        }
        _idHDCT = QLHDCTs.get(rowIndex).getIdHDCT();
        _idSP = QLHDCTs.get(rowIndex).getIdSP();
        QLSanPham sp = sanPhamService.getOne(_idSP);
        lblanhSP.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/" + sp.getImage())).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT)));
        txtsp1.setText(sp.getTenSP());
        txtsl.setValue(QLHDCTs.get(rowIndex).getSoLuong());
        int tien = (int) sp.getGia() * (int) txtsl.getValue();
        txtTien.setText(String.valueOf(tien));
    }//GEN-LAST:event_tblHoaDonCTMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int rowIndex = tblHoaDon.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }
        HoaDonModel hd = hoaDons.get(rowIndex);
        _idHD = hd.getIDHD();
        loadTablehoaDonCT(hd);
        QLHDCTs = new ArrayList<>();
        QLHDCTs = hoaDonCTService.getListbyHD(_idHD);
        if (hd.getIDKM() == null) {
            txtMaKM.setText("");
            PtramKM = 0;
            lblKM.setText("");
            khuyenMai = null;
        } else {
            txtMaKM.setText(hd.getIDKM().getMaKM());
            PtramKM = hd.getIDKM().getPhanTramKM();
            lblKM.setText(Float.toString(hd.getIDKM().getPhanTramKM()) + "%");
            khuyenMai = hd.getIDKM();
        }

        if (hd.getIDKH() == null) {
            _idKH = null;
            txtSdt.setText("");
            txtTenKH.setText("");
        } else {
            _idKH = hd.getIDKH().getId();
            KhachHangModel kh = khachHangService.getOne(_idKH);
            txtSdt.setText(kh.getSoDienThoai());
            txtTenKH.setText(kh.getTen());
        }

//        _ban = hd.getIDB().getIDB();
        if (hd.getIDB() != null) {
            _banBD = hd.getIDB().getIDB();
            _ban = _banBD;
        } else {
            _banBD = 0;
            _ban = 0;
        }
        txttien();
        txtTienKD.setText("");
        for (int i = 0; i < banss.size(); i++) {
            banss.get(i).setmauBD();
            if (banss.get(i).getBan().getIDB() == _banBD) {
                banss.get(i).setBackground(Color.PINK);
            }
        }

        System.out.println(_ban);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void rdoHDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHDCActionPerformed
        loadTablehoaDon("Chờ TT");
    }//GEN-LAST:event_rdoHDCActionPerformed

    private void rdoHDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHDDActionPerformed
        loadTablehoaDon("DTT");
    }//GEN-LAST:event_rdoHDDActionPerformed

    private void rdoHDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHDHActionPerformed
        loadTablehoaDon("DH");
    }//GEN-LAST:event_rdoHDHActionPerformed

    private void txtTienKDCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKDCaretUpdate
        if (txtTienKD.getText() == null) {
            return;
        }
        float tienKD = 0;
        try {
            tienKD = Float.parseFloat(txtTienKD.getText());
        } catch (Exception e) {
        }

        float tienthua = tienKD - tienTT;
        txtTienThua.setText(Float.toString(tienthua));
        btnThanhToan.setEnabled(false);
        if (tienKD >= tienTT && hoaDonService.getOne(_idHD).getTrangThai().equals("Chờ TT")) {
            btnThanhToan.setEnabled(true);
        }

    }//GEN-LAST:event_txtTienKDCaretUpdate

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

        if (txtMaKM.getText() == null) {
            System.out.println("1");
            return;
        }
        System.out.println("2");
        String maKM = txtMaKM.getText();
        System.out.println(txtMaKM.getText());
        System.out.println(maKM);
        KhuyenMai km = new KhuyenMai();
        try {
            km = new BanHangService().getByMaKM(maKM);
        } catch (Exception e) {
            khuyenMai = null;
            PtramKM = 0;
            lblKM.setText("");
            return;
        }
        if (new BanHangService().getByMaKM(maKM) == null) {
            khuyenMai = null;
            PtramKM = 0;
            lblKM.setText("");
            return;
        }
        if (km == null) {
            return;
        }
        khuyenMai = km;
        PtramKM = khuyenMai.getPhanTramKM();
        lblKM.setText(Float.toString(khuyenMai.getPhanTramKM()) + "%");

        txttien();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void txtTienKDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKDActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(BanHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BanHangJDialog dialog = new BanHangJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel j1;
    private javax.swing.JLabel j2;
    private javax.swing.JLabel j3;
    private javax.swing.JLabel j4;
    private javax.swing.JLabel j5;
    private javax.swing.JLabel j6;
    private javax.swing.JLabel j7;
    private javax.swing.JLabel j8;
    private javax.swing.JLabel j9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblKM;
    private javax.swing.JLabel lblanhSP;
    private javax.swing.JPanel pnlBan;
    private javax.swing.JScrollPane pnlBanJsp;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JRadioButton rdoHDC;
    private javax.swing.JRadioButton rdoHDD;
    private javax.swing.JRadioButton rdoHDH;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonCT;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtSDT2;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenKH2;
    private javax.swing.JTextField txtTien;
    private javax.swing.JTextField txtTienGiam;
    private javax.swing.JTextField txtTienKD;
    private javax.swing.JTextField txtTienTT;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTienTong;
    private javax.swing.JSpinner txtsl;
    private javax.swing.JTextField txtsp1;
    private javax.swing.JLabel txtsp3;
    private javax.swing.JLabel txtsp5;
    // End of variables declaration//GEN-END:variables
}
