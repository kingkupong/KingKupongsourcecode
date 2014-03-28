/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD.tables;

import BBDD.utilities.Conector;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mushi
 */
public class Factura {

    public enum Busqueda {

        ID, DESTINATARIOID, EMISORID
    }

    public enum Variable {

        ID, NUMEROFACTURA, DESTINATARIOID,
        FECHAEMISION, FECHAVENCIMIENTO, EMISORID,
        TIPODOCUMENTO, IMPORTE, COBRADO, FECHACOBRO
    }
    private Variable v;
    
    private final String TABLA = "FACTURA";
    /**
     * Valores de la base de datos
     */
    private int id;
    private String numerofactura;
    private int destinatarioid;
    private Date fechaemision;
    private Date fechavencimiento;
    private int emisorid;
    private String tipodocumento;
    private double importe;
    private boolean cobrado;
    private Date fechacobro;
    /**
     *
     * Base de datos
     *
     */
    private Conector conexion = null;
    private PreparedStatement stm = null;
    private String sql;
    private ResultSet rs;

    public Factura(String numerofactura, int destinatarioid, Date fechaemision, Date fechavencimiento, int emisorid, String tipodocumento, Double importe, boolean cobrado) throws SQLException {
        this.numerofactura=numerofactura;
        this.destinatarioid=destinatarioid;
        this.fechaemision=fechaemision;
        this.fechavencimiento=fechavencimiento;
        this.emisorid=emisorid;
        this.tipodocumento=tipodocumento;
        this.importe=importe;
        this.cobrado=cobrado;
        sql = "Insert INTO "+TABLA+" ("+setVariable(v.NUMEROFACTURA)+","+setVariable(v.DESTINATARIOID)+","+setVariable(v.FECHAEMISION)+","+setVariable(v.FECHAVENCIMIENTO)+","+setVariable(v.FECHAVENCIMIENTO)+","
            + ""+setVariable(v.EMISORID)+","+setVariable(v.TIPODOCUMENTO)+","
            + ""+setVariable(v.FECHAEMISION)+","+setVariable(v.TIPODOCUMENTO)+","+setVariable(v.IMPORTE)+","+setVariable(v.COBRADO)+" VALUES(?,?,?,?,?,?,?,?) ";
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, numerofactura);
        stm.setInt(2, destinatarioid);
        stm.setDate(3, fechaemision);
        stm.setDate(4, fechavencimiento);
        stm.setInt(5, emisorid);
        stm.setString(6, tipodocumento);
        stm.setDouble(7, importe);
        stm.setBoolean(8, cobrado);
        stm.execute();
        getIdBBDD();
        conexion.con.close();
    
    
    
    
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the numerofactura
     */
    public String getNumerofactura() {
        return numerofactura;
    }

    /**
     * @return the distinatarioid
     */
    public int getDistinatarioid() {
        return destinatarioid;
    }

    /**
     * @return the fechaemision
     */
    public Date getFechaemision() {
        return fechaemision;
    }

    /**
     * @return the fechavencimiento
     */
    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    /**
     * @return the emisorid
     */
    public int getEmisorid() {
        return emisorid;
    }

    /**
     * @return the tipodocumento
     */
    public String getTipodocumento() {
        return tipodocumento;
    }

    /**
     * @return the importe
     */
    public double getImporte() {
        return importe;
    }

    /**
     * @return the cobrado
     */
    public boolean isCobrado() {
        return cobrado;
    }

    /**
     * @return the fechacobro
     */
    public Date getFechacobro() {
        return fechacobro;
    }

    /**
     *
     * Setters
     *
     */
    public void setterSQL(Variable v) {
        sql = "Update " + TABLA + " set " + setVariable(v) + " where id=?";
    }

    public String setVariable(Variable v) {
        switch (v) {
            case ID:
            case NUMEROFACTURA:
                return ("numerofactura");
            case DESTINATARIOID:
                return ("destinatarioid");
            case FECHAEMISION:
                return ("fechaemision");
            case FECHAVENCIMIENTO:
                return ("fechavencimiento");
            case EMISORID:
                return ("emisorid");
            case TIPODOCUMENTO:
                return ("tipodocumento");
            case IMPORTE:
                return ("importe");
            case COBRADO:
                return ("cobrado");
            case FECHACOBRO:
                return ("fechacobro");
        }


        return null;

    }

    public void setNumerofactura(String set) throws SQLException {
        this.numerofactura = set;
        establecerConexion();
        setterSQL(Variable.NUMEROFACTURA);
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, set);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    public void setDestinatarioid(int set) throws SQLException {
        this.destinatarioid = set;
        establecerConexion();
        setterSQL(Variable.DESTINATARIOID);
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, set);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    public void setFechaemision (Date set) throws SQLException{
        this.fechaemision= set;
        establecerConexion();
        setterSQL(Variable.FECHAEMISION);
        stm = conexion.con.prepareStatement(sql);
        stm.setDate(1, set);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    public void setFechavencimiento (Date set) throws SQLException{
        this.fechavencimiento= set;
        establecerConexion();
        setterSQL(Variable.FECHAVENCIMIENTO);
        stm = conexion.con.prepareStatement(sql);
        stm.setDate(1, set);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    public void setEmisorid (int set) throws SQLException{
        this.emisorid = set;
        establecerConexion();
        setterSQL(Variable.EMISORID);
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, set);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    public void setTipodocumento (String set) throws SQLException{
        this.tipodocumento = set;
        establecerConexion();
        setterSQL(Variable.TIPODOCUMENTO);
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, set);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    
    
    public void setImporte (Double set) throws SQLException{
        this.importe = set;
        establecerConexion();
        setterSQL(Variable.IMPORTE);
        stm = conexion.con.prepareStatement(sql);
        stm.setDouble(1, set);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    public void setCobrado (Boolean set) throws SQLException{
        this.cobrado = set;
        establecerConexion();
        setterSQL(Variable.COBRADO);
        stm = conexion.con.prepareStatement(sql);
        stm.setBoolean(1, set);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    public void setFechacobro (Date set) throws SQLException{
        this.fechacobro=set;
        establecerConexion();
        setterSQL(Variable.FECHACOBRO);
        stm = conexion.con.prepareStatement(sql);
        stm.setDate(1, set);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
        
    }
    private void getIdBBDD() throws SQLException{
        establecerConexion();
        sql = "Select max(id) from "+TABLA;
        rs = stm.executeQuery(sql);
        while (rs.next()) {
           this.id=rs.getInt(1);
        }
        conexion.con.close();

    }
    private void establecerConexion() throws SQLException {
        if (conexion == null) {
            conexion = new Conector();
        } else if (conexion.con.isClosed()) {
            conexion = new Conector();
        }
    }
}
