/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import domainmodel.Ban;
import domainmodel.HoaDon;
import domainmodel.KhachHang;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
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
    List<QLSanPham> sanPhams = new ArrayList<>();
    HoaDonService hoaDonService = new HoaDonServiceImpl();
    HoaDonRepository hoaDonRepository = new HoaDonRepository();
    List<HoaDonModel> hoaDons = new ArrayList<>();
    KhachHangService khachHangService = new KhachHangServiceImpl();
    KhachHangRepository khachHangRepository = new KhachHangRepository();
    KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
    List<KhachHangModel> khachHangs = new ArrayList<>();
    IManageHDCTService hoaDonCTService = new ManageHDCTService();
    IQlyNhanVien QlyNhanVien = new QlyNhanVienImpl();
    NhanVienRepository nhanVienRepository = new NhanVienRepository();
    List<QLHDCT> QLHDCTs = new ArrayList<>();
    DefaultTableModel _Model = new DefaultTableModel();
    QuanLyBanService banService = new QuanLyBanServiceImpl();
    List<BanReponse> bans = new ArrayList<>();
    int _ban = 0 ;    
    UUID _idHD = null;
    UUID _idSP = null;
    UUID _idKH = null;
    UUID _idHDCT = null;
    float tienTong;
    float tienGiam = 0;
    float tienTT;
    int u= 0;
    public BanHangJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        hoaDonlist = hoaDonService.getHoaDonByTT(TT);
        _Model = new DefaultTableModel();
        _Model = (DefaultTableModel) tblHoaDon.getModel();
        _Model.setRowCount(0);
        hoaDons.clear();
        hoaDons = hoaDonlist;
        if (TT.equals("CTT")) {
            TT = "chưa thanh toán";
        } else if (TT.equals("DTT")) {
            TT = "Đã thanh toán";
        } else if (TT.equals("DH")) {
            TT = "Đã hủy";
        }
        for (int i = 0; i < hoaDonlist.size(); i++) {
            _Model.addRow(new Object[]{hoaDons.get(i).getIDKH().getTen(),hoaDonlist.get(i).getNgayTao(), TT});

        }

    }
    private void txttien() {
        tienTong = 0;
        for (QLHDCT hdctt : QLHDCTs) {
            tienTong = tienTong + hdctt.getTien();
        }
        tienTT = tienTong - tienGiam;
        txtTienTong.setText(tienTong + "");
        txtTienGiam.setText(tienGiam + "");
        txtTienTT.setText(tienTT + "");
    }

    private void loadTablehoaDonCT(HoaDonModel hoaDon) {
        _Model = new DefaultTableModel();
        QLHDCTs = new ArrayList<>();
        QLHDCTs = hoaDonCTService.getListbyHD(_idHD);
        _Model = (DefaultTableModel) tblHoaDonCT.getModel();
        _Model.setRowCount(0);
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
        KhachHang kh = new KhachHangRepository().getOne(_idKH);
        hd.setIDKH(kh);
        hd.setTongTien(tienTong);
        hd.setTienTra(tienTT);

        return hd;
    }
    public void loadTableBan() {
        bans.clear();
        bans = new ArrayList<>();

        bans = banService.getAll();
        pnlBan.setLayout(null);
	pnlBan.setSize(new Dimension(500,500));
        autoGenBan();
        
    }
     void autoGenBan() {
		int line=0;
		for(int i=0;i<bans.size();i++) {
//			System.out.println(line);
                        ban ba = new ban(bans.get(i),i);
			ba.setBounds((122*line++)+5,(80*Integer.parseInt(String.valueOf((i/4))) +25) , 120, 80);
			ba.setBorder(BorderFactory.createEtchedBorder());
                        ba.addMouseListener(new MouseAdapter() {
				 public void mouseClicked(MouseEvent e) {
                                     if(_ban == 0){
                                     _ban = ba.getBan().getIDB();
                                     ba.setBackground(Color.PINK);
                                     }
                                     
                                         
				 }
			});
			pnlBan.add(ba);
			if(line>3)line=0;
		}
	}
    public void loadTableSanPham() {
        sanPhams.clear();
        sanPhams = new ArrayList<>();

        sanPhams = sanPhamService.getAll();
        pnlSanPham.setLayout(null);
	pnlSanPham.setSize(new Dimension(500,500));
        autoGenSP();
        
    }
     void autoGenSP() {
		int line=0;
		for(int i=0;i<sanPhams.size();i++) {
//			System.out.println(line);
                        thu1 th = new thu1(sanPhams.get(i),i);
			th.setBounds((122*line++)+5,(120*Integer.parseInt(String.valueOf((i/4))) +25) , 120, 150);
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
                                         lblanhSP.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/"+th.getSp().getImage())).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT)));
        
				 }
			});
			pnlSanPham.add(th);
			if(line>3)line=0;
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
        pnlBan = new javax.swing.JPanel();
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
        pnlSanPham = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 102));

        jPanel2.setBackground(new java.awt.Color(249, 238, 231));

        jPanel6.setBackground(new java.awt.Color(249, 238, 231));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));
        jPanel6.setPreferredSize(new java.awt.Dimension(450, 258));

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setText("Tạo Hóa Đơn");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        j2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j2.setText("Tên Khách Hàng");

        j3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j3.setText("Tổng Tiền:");

        j4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j4.setText("Tiền Thanh Toán:");

        j5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j5.setText("Tiền giảm giá:");

        txtTienTong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTienGiam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTienTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("lưu HD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton10.setText("Clear");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        j6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j6.setText("Số Điện Thoại:");

        jButton15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton15.setText("Tìm KH");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        txtSdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSdt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtSdtMouseExited(evt);
            }
        });

        j7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j7.setText("Tiền Khách đưa:");

        j8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j8.setText("Tiền Thừa:");

        txtTienKD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTienKD.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKDCaretUpdate(evt);
            }
        });

        txtTienThua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTienTong, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(j6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSdt))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(j5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(j4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTienTT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(j7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTienKD, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(j8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(76, 76, 76))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(j2)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10)
                            .addComponent(j3)
                            .addComponent(txtTienTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(j5)
                            .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(j4)
                            .addComponent(txtTienTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThanhToan)
                        .addGap(24, 24, 24)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(j7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTienKD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j8)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pnlBan.setBackground(new java.awt.Color(255, 255, 204));
        pnlBan.setBorder(javax.swing.BorderFactory.createTitledBorder("Bàn"));
        pnlBan.setPreferredSize(new java.awt.Dimension(500, 250));

        javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan);
        pnlBan.setLayout(pnlBanLayout);
        pnlBanLayout.setHorizontalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        pnlBanLayout.setVerticalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(249, 238, 231));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chi tiết"));
        jPanel8.setPreferredSize(new java.awt.Dimension(350, 124));

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton9.setText("Xóa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton7.setText("Sửa");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Phin");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienActionPerformed(evt);
            }
        });

        txtsp5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsp5.setText("Thành tiền");

        txtsl.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
        txtsl.setPreferredSize(new java.awt.Dimension(32, 26));
        txtsl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtslStateChanged(evt);
            }
        });

        txtsp3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsp3.setText("số lượng");

        txtsp1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        j1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j1.setText("Tên sản phẩm");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsp5)
                    .addComponent(j1)
                    .addComponent(txtsp3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtsl, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j1)
                    .addComponent(txtsp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsp3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsp5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(22, 22, 22))
        );

        pnlSanPham.setBackground(new java.awt.Color(255, 255, 204));
        pnlSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));
        pnlSanPham.setPreferredSize(new java.awt.Dimension(500, 250));

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Bán Coffee");

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
                        .addComponent(txtTenKH2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        lblanhSP.setBackground(new java.awt.Color(0, 0, 0));
        lblanhSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblanhSP.setText("Image");
        lblanhSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
                .addContainerGap(38, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(325, 325, 325)
                            .addComponent(jLabel2)
                            .addGap(422, 422, 422))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(lblanhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(100, 100, 100)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(lblanhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(pnlBan, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        HoaDon hd = new HoaDon();
        hd.setTrangThai("CTT");
        System.out.println(nhanVienRepository.getAll().get(0).getHoTen());
        hd.setIDNV(nhanVienRepository.getAll().get(0));
        hd.setIDKH(khachHangRepository.getAll().get(0));
        hd.setIDKM(khuyenMaiRepository.getAll().get(0));
        //        hd.setNgayTao(new Date());
        //        hd.setNgayTT(new Date());
        hd.setNgayTao(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
        hd.setNgayTT(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
        if (new HoaDonRepository().add(hd)) {
            JOptionPane.showMessageDialog(this, "Succes");
        } else {
            JOptionPane.showMessageDialog(this, "Failed");
        }

        rdoHDC.setEnabled(true);
        loadTablehoaDon("CTT");
        loadTableSanPham();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        HoaDon hd = getformHoaDon();
        if(_ban!=0){
        hd.setIDB(banService.getOne(_ban));}
        KhachHang kh = new KhachHangRepository().getOne(_idKH);
        hd.setIDKH(kh);
        hd.setNgayTT(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
        hd.setTrangThai("DTT");
        if (hoaDonRepository.update(hd,hd.getIDHD())) {
            JOptionPane.showMessageDialog(this, "Succes");
            Ban banv = banService.getOne(_ban);
            banv.setTrangThaiBan("Hết Chống");
            JOptionPane.showMessageDialog(this, banService.update(banv));
        } else {
            JOptionPane.showMessageDialog(this, "Failed");
        }
        loadTablehoaDon("CTT");
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HoaDon hd = getformHoaDon();
        KhachHang kh = new KhachHangRepository().getOne(_idKH);
        if(_ban!=0){
        hd.setIDB(banService.getOne(_ban));}
        
        hd.setIDKH(kh);
        if (hoaDonRepository.update(hd,hd.getIDHD())) {
            JOptionPane.showMessageDialog(this, "Succes");
            Ban banv = banService.getOne(_ban);
            banv.setTrangThaiBan("Còn Chống");
            JOptionPane.showMessageDialog(this, banService.update(banv));
        } else {
            JOptionPane.showMessageDialog(this, "Failed");
        }
        loadTablehoaDon("CTT");
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

        btnThanhToan.setEnabled(false);
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
        if (khachHangService.getOne(Sdt) == null) {
            return;
        }
        KhachHangModel kh = khachHangService.getOne(Sdt);
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

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        System.out.println(_idHD);
        System.out.println(_idSP);
        System.out.println("12");
        QLHDCT HDCT = new QLHDCT(_idHD, _idSP, (int) txtsl.getValue());
        System.out.println(HDCT.getIdHD());
        System.out.println(HDCT.getIdSP());
        System.out.println(1);
        JOptionPane.showMessageDialog(this, hoaDonCTService.add(HDCT));
        System.out.println(2);
        System.out.println(_idHD);
        System.out.println(3);
        System.out.println(hoaDonService.getOne(_idHD).getIDKH());
        loadTablehoaDonCT(hoaDonService.getOne(_idHD));
        txttien();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        System.out.println(_idHD);
//        System.out.println(_idSP);
//        System.out.println("12");
        QLHDCT HDCT = new QLHDCT(_idHD, _idSP, (int) txtsl.getValue());
//        System.out.println(HDCT.getIdHD());
//        System.out.println(HDCT.getIdSP());
//        System.out.println(1);
        JOptionPane.showMessageDialog(this, hoaDonCTService.add(HDCT));
//        System.out.println(2);
//        System.out.println(_idHD);
//        System.out.println(3);
        System.out.println(hoaDonService.getOne(_idHD));
        loadTablehoaDonCT(hoaDonService.getOne(_idHD));
        txttien();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienActionPerformed

    private void txtslStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtslStateChanged

        QLSanPham sanPham = sanPhamService.getOne(_idSP);
        int  tien = (int) sanPham.getGia() * (int) txtsl.getValue();
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
        if (khachHangService.Save(khachHang) == true) {
            JOptionPane.showMessageDialog(this, "Thêm Thành công");

        }
        JOptionPane.showMessageDialog(this, "Thêm Thất bại");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void tblHoaDonCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonCTMouseClicked
        int rowIndex = tblHoaDonCT.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }
        _idSP = QLHDCTs.get(rowIndex).getIdSP();
        QLSanPham sp = sanPhamService.getOne(_idHD);
        txtsp1.setText(sp.getTenSP());
        int tien = (int) sp.getGia()*(int) txtsl.getValue();
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
        _idKH = hd.getIDKH().getId();
        KhachHangModel kh = khachHangService.getOne(_idKH);
        txtSdt.setText(kh.getSoDienThoai());
        txtTenKH.setText(kh.getTen());
        _ban = hd.getIDB().getIDB();
        txttien();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void rdoHDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHDCActionPerformed
        loadTablehoaDon("CTT");
    }//GEN-LAST:event_rdoHDCActionPerformed

    private void rdoHDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHDDActionPerformed
        loadTablehoaDon("DTT");
    }//GEN-LAST:event_rdoHDDActionPerformed

    private void rdoHDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHDHActionPerformed
        loadTablehoaDon("DH");
    }//GEN-LAST:event_rdoHDHActionPerformed

    private void txtTienKDCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKDCaretUpdate
        if(txtTienKD.getText()== null){
            return;
        }
        float tienKD =  Float.parseFloat(txtTienKD.getText());
        float tienthua = tienKD - tienTT;
        txtTienThua.setText(Float.toString(tienthua));
        btnThanhToan.setEnabled(false);
        if(tienKD >= tienTT){
        btnThanhToan.setEnabled(true);}
        
    }//GEN-LAST:event_txtTienKDCaretUpdate

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

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
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblanhSP;
    private javax.swing.JPanel pnlBan;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JRadioButton rdoHDC;
    private javax.swing.JRadioButton rdoHDD;
    private javax.swing.JRadioButton rdoHDH;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonCT;
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
