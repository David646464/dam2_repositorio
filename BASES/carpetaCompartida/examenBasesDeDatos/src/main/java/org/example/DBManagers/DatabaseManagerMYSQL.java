package org.example.DBManagers;

import org.example.tarea2.objects.Proxecto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DatabaseManagerMYSQL {
    private Connection conexion;
    String url = "jdbc:mysql://127.0.0.1:3306/bdempresa";
    String user = "root";
    String password = "abc123.";

    public DatabaseManagerMYSQL() throws SQLException {
        try {
            conexion = DriverManager.getConnection(url, user, password);
            conexion.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public int aumentarSueldoEnUnDepartamento(int aumento, String nomeDepartamento) throws SQLException {
        int filasAfectadas = 0;
        try {
            String sql = "UPDATE empregado SET Salario = Salario + ? WHERE Num_departamento_pertenece = (SELECT Num_departamento FROM departamento WHERE Nome_departamento = ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, aumento);
            preparedStatement.setString(2, nomeDepartamento);
            filasAfectadas = preparedStatement.executeUpdate();
            conexion.commit();
        } catch (SQLException e) {
            conexion.rollback();
            e.printStackTrace();
        }
        return filasAfectadas;
    }

    public int novoDepartamento(int numDepartamento, String nomeDepartamento, int nssEmpregado) throws SQLException {
        LocalDate data = LocalDate.now();
        int filasAfectadas = 0;
        try {
            String sql = "INSERT INTO departamento (Num_departamento, Nome_departamento, NSS_dirige, Data_direcion) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, numDepartamento);
            preparedStatement.setString(2, nomeDepartamento);
            preparedStatement.setInt(3, nssEmpregado);
            preparedStatement.setDate(4, Date.valueOf(data));
            filasAfectadas = preparedStatement.executeUpdate();
            conexion.commit();
        } catch (SQLException e) {
            conexion.rollback();
            e.printStackTrace();
        }
        return filasAfectadas;
    }

    public int borrarEmpregadoDeUnProxecto(String nssEmpregado, int codigoProxecto) throws SQLException {
        int filasAfectadas = 0;
        try {
            String sql = "DELETE FROM empregado_proxecto WHERE NSS_Empregado = ? AND Num_proxecto = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, nssEmpregado);
            preparedStatement.setInt(2, codigoProxecto);
            filasAfectadas = preparedStatement.executeUpdate();
            conexion.commit();
        } catch (SQLException e) {
            conexion.rollback();
            e.printStackTrace();
        }
        return filasAfectadas;
    }


    public void imprimirInformacionDeEmpregadoPorLocalidade(String aCoruña) throws SQLException {
        //TODO nomes, apelidos, localidade, salario, data de
        //nacemento, nome do empregado xefe e o nome do departamento onde traballan
        String sql = "select\n" +
                "    empregado.Nome,\n" +
                "    empregado.Apelido_1,\n" +
                "    empregado.Apelido_2,\n" +
                "    empregado.Localidade,\n" +
                "    empregado.Salario,\n" +
                "    empregado.Data_nacemento,\n" +
                "    (select e.Nome from empregado e where e.NSS = empregado.NSS_Supervisa ) as NSS_dirige,\n" +
                "    departamento.Nome_departamento from empregado\n" +
                "        inner join departamento\n" +
                "            on empregado.Num_departamento_pertenece = departamento.Num_departamento\n" +
                "                                   where empregado.Localidade = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setString(1, aCoruña);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String nome = resultSet.getString("Nome");
            String apelido1 = resultSet.getString("Apelido_1");
            String apelido2 = resultSet.getString("Apelido_2");
            String localidade = resultSet.getString("Localidade");
            double salario = resultSet.getDouble("Salario");
            Date dataNacemento = resultSet.getDate("Data_nacemento");
            String nssDirige = resultSet.getString("NSS_dirige");
            String nomeDepartamento = resultSet.getString("Nome_departamento");

            System.out.println("Nome: " + nome);
            System.out.println("Apelido 1: " + apelido1);
            System.out.println("Apelido 2: " + apelido2);
            System.out.println("Localidade: " + localidade);
            System.out.println("Salario: " + salario);
            System.out.println("Data de Nacemento: " + dataNacemento);
            System.out.println("Nome do Empregado Xefe: " + nssDirige);
            System.out.println("Nome do Departamento: " + nomeDepartamento);
            System.out.println("-----------------------------");
        }
    }

    public void cambiarDepartamentoQueDirigeUnproyecto(String departamento, int numProxecto) throws SQLException {
        int filasAfectadas = 0;
        try {
            String sql = "UPDATE proxecto\n" +
                    "SET Num_Departamento =\n" +
                    "   (select Num_departamento from departamento where Nome_departamento = ?)\n" +
                    "WHERE Num_Proxecto = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, departamento);
            preparedStatement.setInt(2, numProxecto);
            filasAfectadas = preparedStatement.executeUpdate();
            conexion.commit();
        } catch (SQLException e) {
            conexion.rollback();
            e.printStackTrace();
        }

    }

    public int novoProxecto(Proxecto proxecto) throws SQLException {
        int filasAfectadas = 0;
        try {
            String sql = "INSERT INTO proxecto (Num_Proxecto, Nome_Prxecto, Lugar, Num_Departamento) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, proxecto.getNumProxecto());
            preparedStatement.setString(2, proxecto.getNomeProxecto());
            preparedStatement.setString(3, proxecto.getCidade());
            preparedStatement.setInt(4, proxecto.getNumDepartamento());
            filasAfectadas = preparedStatement.executeUpdate();
            conexion.commit();
        } catch (SQLException e) {
            conexion.rollback();
            e.printStackTrace();
        }
        return filasAfectadas;
    }

    public int borrarProxectoCascada(int i) throws SQLException {
        int filasAfectadas = 0;
        try {

            String sql = "DELETE FROM empregado_proxecto WHERE Num_proxecto = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, i);
            filasAfectadas += preparedStatement.executeUpdate();

            sql = "DELETE FROM proxecto WHERE Num_Proxecto = ?";
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, i);
            filasAfectadas = preparedStatement.executeUpdate();
            conexion.commit();


        } catch (SQLException e) {
            conexion.rollback();
            e.printStackTrace();
        }
        return filasAfectadas;
    }

    public ArrayList<Proxecto> getListaProxectosPorDepartamento(String persoal) {
        ArrayList<Proxecto> proxectos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM proxecto WHERE Num_Departamento = (SELECT Num_departamento FROM departamento WHERE Nome_departamento = ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, persoal);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int numProxecto = resultSet.getInt("Num_Proxecto");
                String nomeProxecto = resultSet.getString("Nome_Prxecto");
                String lugar = resultSet.getString("Lugar");
                int numDepartamento = resultSet.getInt("Num_Departamento");
                Proxecto proxecto = new Proxecto(numProxecto, nomeProxecto, lugar, numDepartamento);
                proxectos.add(proxecto);
            }
        } catch (SQLException e) {
            return null;
        }
        return proxectos;
    }

    public void createpr_cambioDomicilio() {


    }
}
