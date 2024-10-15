import java.sql.*;

/**
 *
 * @author leduc
 */
public class DanhMucSP {

    private Connection conn;
    private int CategoryID;
    private String CategoryName;

    // Constructor
    public DanhMucSP(int categoryID, String categoryName) {
        this.CategoryID = categoryID;
        this.CategoryName = categoryName;
    }

    // Getter và Setter cho CategoryID và CategoryName
    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        this.CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        this.CategoryName = categoryName;
    }

    // Mở kết nối tới SQL Server
    public void openConnection() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=qlsp;";
            String user = "sa";
            String password = "Duc25082004";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Thêm mới một danh mục vào bảng Category
    public void New() {
        String query = "INSERT INTO Category (CategoryID, CategoryName) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, CategoryID);
            pstmt.setString(2, CategoryName);

            pstmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void Update() {
        String query = "UPDATE LoaiSP SET TenLoai = ? WHERE MaLoai = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, CategoryID);
            stmt.setString(2, CategoryName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }
    public void Remove() {
        String query = "DELETE FROM LoaiSP WHERE MaLoai = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, CategoryID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }
}
