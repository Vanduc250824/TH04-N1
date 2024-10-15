import java.sql.*;
import java.util.ArrayList;

public class QuanLySP {
    Connection conn;

    public QuanLySP() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=SanPhamDB;TrustServerCertificate=true;Integrated Security=true;";
            String user = "sa"; 
            String password = "Duc25082004"; 
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    // Add a new product category to the database
    public void themLoaiSanPham(LoaiSP loaiSanPham) {
        String query = "INSERT INTO LoaiSP (MaLoai, TenLoai) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, loaiSanPham.getMaLoai());
            stmt.setString(2, loaiSanPham.getTenLoai());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }

    // Update a product category in the database
    public void suaLoaiSanPham(LoaiSP loaiSanPham) {
        String query = "UPDATE LoaiSP SET TenLoai = ? WHERE MaLoai = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, loaiSanPham.getTenLoai());
            stmt.setString(2, loaiSanPham.getMaLoai());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }

    // Delete a product category from the database
    public void xoaLoaiSanPham(String maLoai) {
        String query = "DELETE FROM LoaiSP WHERE MaLoai = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maLoai);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }

    // Retrieve all product categories from the database
    public ArrayList<LoaiSP> getDanhSach() {
        ArrayList<LoaiSP> ds = new ArrayList<>();
        String query = "SELECT * FROM LoaiSP";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String maLoai = rs.getString("MaLoai");
                String tenLoai = rs.getString("TenLoai");
                ds.add(new LoaiSP(maLoai, tenLoai));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
        return ds;
    }
}

