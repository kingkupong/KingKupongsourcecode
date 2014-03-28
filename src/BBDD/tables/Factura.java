/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD.tables;

import BBDD.utilities.Conector;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Mushi
 */
public class Factura {

    
    public enum Busqueda{
         ID, DESTINATARIOID, EMISORID
     }
    
    /**
     * Valores de la base de datos
     */
    private int id;
    private String numerofactura;
    private int distinatarioid;
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
    
    
    public Factura(int id, Busqueda b){
        
    }
    
    public Factura (String numerofactura, int distinatarioid, Date fechaemision, Date fechavencimiento, int emisorid, String tipodocumento, Double importe, boolean cobrado, Date fechacobro){
        
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
        return distinatarioid;
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
    
   
    
}
