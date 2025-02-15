package utilities.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBConnection {
    public static void getDataFromDB(String query){
        String url = "jdbc:postgresql://domain:host/xxx";
        String user = "";
        String password = "";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish the connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

            // Create a statement object
            stmt = conn.createStatement();

            // Execute a query
            rs = stmt.executeQuery(query);

            // Process the result set
            while (rs.next()) {
                System.out.println("record(" + rs.getRow() + "): " + rs.getString("creator_id") + " with business_id: " + rs.getString("business_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void businessKYC (){
        String query = "insert into public.business_kyc (creator_id, created_at, updated_at, deleted_at, description, name, provider_code, provider_owner_id, provider_business_id, provider_business_kyc_number, business_id, kyc_status, sme_id, client_bank_id, usage_type) " +
                "values('375dfd5b-387b-4169-a786-052a977814b8'::uuid, '2024-05-13 23:58:15.149', '2024-05-13 23:58:16.202', null, 'QC TEST MERCHANT HOST', 'QC TEST MERCHANT HOST', 'finesys', 'robhuynh', 'B00200000001', 0, 118, 'approved', '806102bc-9883-44d9-ac09-39d573ba4f98'::uuid, 'gHLxJaKPp97lCW5gD0oIBTWK', 'merchant_host')";
    }

    public static void main(String[] args) {
        getDataFromDB("SELECT * from public.business_kyc where business_id = 36");
    }
}
