/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leduc
 */
public class LoaiSP {

    private String MaLoai;
    private String TenLoai;

    public LoaiSP(String _MaLoai, String _TenLoai) {
        this.MaLoai = _MaLoai;
        this.TenLoai = _TenLoai;
    }

    public String getMaLoai() {
        return this.MaLoai;
    }

    public void setMaLoai(String maLoai) {
        this.MaLoai = maLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.TenLoai = tenLoai;
    }
}
