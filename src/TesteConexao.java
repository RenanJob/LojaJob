import java.sql.Connection;
import java.sql.SQLException;
import database.Conexao;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection conn = Conexao.conectar();
            System.out.println("✅ Conexão realizada com sucesso!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar com o banco:");
            e.printStackTrace();
        }
    }
}
