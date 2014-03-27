/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kupoi;

import BBDD.tables.*;
import BBDD.utilities.Consultas;
import BBDD.utilities.UserManagement;
import Utilities.Imagen;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Boomeraling
 */
public class Kupoi {

    static Date fecha = new Date(2009 - 1900, 1, 1);

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException, IOException {
        
        
        
        
          probarCuponesUsuario();
//        Franquiciado franquiciado = new Franquiciado("Franquiciado", "Franchise", "password", "4313333", "Calle Franchise", "franchise@franquicia.com", "phone");
//        Consultas.cuponesPublicados(1);
//        Consultas.busquedaDireccion(Consultas.Tabla.COMERCIO, Consultas.Param.COUNTRY);
//        Consultas.busquedaDireccion(Consultas.Tabla.USUARIO, Consultas.Param.CP);
//        Consultas.listadoNombreParecido(Consultas.Tabla.CUPON, "c");
//        Consultas.listadoEmails(Consultas.Tabla.USUARIO);
//        Consultas.listadoNombre(Consultas.Tabla.FRANQUICIADO);
//        UserManagement.registroUsuario("Menaa", "axel@axel.es", "coop", "España", "Baleares");
//        UserManagement.registroComercio("AxCoopee", "axel@coop.es", "axel", "Esp5aña", "Ca5lle Axel", "C5iudad", "Mexi5co", "0693593", true);
//        UserManagement.registroFranquiciado("name", "surname", "password", "NIF", "address", "email35@gmail.com", "telefono");
//        UserManagement.loginComercio("axel@coop.es", "axel");
//        UserManagement.loginUsuario("axel@axel.es", "coop");
//        UserManagement.loginFranquiciado("email", "password");
//        pruebaComercio();
//        pruebaCupon();
//        pruebaUsuario();
//        pruebaFranquicia();
//        pruebaFranquiciado();
//        Imagen.guardarPNG("cat.jpg");
//        Imagen.resizeImage("cat.jpg");
//        Imagen.guardarJPG("cata.png");
//        crearMensaje();
//        crearNotificacion();
//        probarNotificacion();
//        probarMensaje();
    }

    public static void probarMensaje() throws SQLException {
        Mensaje mensaje = new Mensaje(1, Mensaje.Busqueda.ID);
        mensaje.setAsunto("a");
        mensaje.setFecha_enviado(new java.sql.Date(fecha.getTime()));
        mensaje.setFrom_id(1);
        mensaje.setMensaje("mensaje");
        mensaje.setTo_id(1);
        System.out.println(mensaje.getAsunto());
        System.out.println(mensaje.getFecha_enviado());
        System.out.println(mensaje.getFrom_id());
        System.out.println(mensaje.getId());
        System.out.println(mensaje.getMensaje());
        System.out.println(mensaje.getTo_id());
    }

    public static void probarNotificacion() throws SQLException {
        Notificacion notificacion = new Notificacion(1, Notificacion.Busqueda.ID);
        notificacion.setAsunto("a");
        notificacion.setEnlace("a.com");
        notificacion.setFecha_enviado(new java.sql.Date(fecha.getTime()));
        notificacion.setFrom_id(1);
        notificacion.setMensaje("Mensaje");
        notificacion.setTo_id(1);
        System.out.println(notificacion.getAsunto());
        System.out.println(notificacion.getEnlace());
        System.out.println(notificacion.getFecha_enviado());
        System.out.println(notificacion.getFrom_id());
        System.out.println(notificacion.getId());
        System.out.println(notificacion.getMensaje());
        System.out.println(notificacion.getTo_id());

    }

    
    public static void crearCuponesUsuarios() throws SQLException{
        CuponesUsuario cu = new CuponesUsuario(1,1,new java.sql.Date(fecha.getTime()), 25.5, "cuponeado");
    }
    public static void probarCuponesUsuario() throws SQLException{
        CuponesUsuario cu = new CuponesUsuario(1,new java.sql.Date(fecha.getTime()));
        cu.setEstado("Apagado");
        cu.setFecha_compra(new java.sql.Date(fecha.getTime()));
        cu.setId_cupon(1);
        cu.setId_usuario(1);
        cu.setPrecio(26.5);
        System.out.println(cu.getEstado());
        System.out.println(cu.getFecha_compra());
        System.out.println(cu.getId());
        System.out.println(cu.getId_usuario());
        System.out.println(cu.getId_cupon());
        System.out.println(cu.getPrecio());
    }
    public static void crearMensaje() throws SQLException {
        Mensaje mensaje = new Mensaje(1, 1, new java.sql.Date(fecha.getTime()), "Mena", "MenaMena");
    }

    public static void crearNotificacion() throws SQLException {
        Notificacion notificacion = new Notificacion(1, 1, new java.sql.Date(fecha.getTime()), "Mena", "MenaMena", "Enlace.com");
    }

    public static void crearCupon() throws SQLException {
        Cupon cupon = new Cupon(1, "a", "a", "a", new java.sql.Date(fecha.getTime()), new java.sql.Date(fecha.getTime()), 1, "a");
    }

    public static void crearFranquiciado() throws SQLException {
        Franquiciado franquiciado = new Franquiciado("name", "surname", "password", "NIF", "address", "correo", "983849");

    }

    public static void crearFranquicia() throws SQLException {
        Franquicia franquicia = new Franquicia("nombre", 1, "fulladdress", "cp", "ciudad", "state", "pais");
    }

    public static void pruebaFranquiciado() throws SQLException {
        Franquiciado franquiciado = new Franquiciado(4);
        franquiciado.setAddress("Calle tal");
        franquiciado.setMail("aaa@gmail.com");
        franquiciado.setNIF("4316566");
        franquiciado.setName("Nombre Franquisiado");
        franquiciado.setPassword("abbbbb");
        franquiciado.setSurname("apellidos");
        franquiciado.setTelefono("97142411");
        System.out.println("-----------------------Franquiciado---------------------------");
        System.out.println(franquiciado.getAddress());
        System.out.println(franquiciado.getId());
        System.out.println(franquiciado.getMail());
        System.out.println(franquiciado.getNIF());
        System.out.println(franquiciado.getName());
        System.out.println(franquiciado.getPassword());
        System.out.println(franquiciado.getProfileimageurl());
        System.out.println(franquiciado.getSurname());
        System.out.println(franquiciado.getTelefono());
        System.out.println(franquiciado.getfbid());

    }

    public static void pruebaFranquicia() throws SQLException {
        Franquicia franquicia = new Franquicia(1);
        franquicia.setBackground("a");
        franquicia.setCity("ciudad");
        franquicia.setCountry("España");
        franquicia.setCp("07005");
        franquicia.setFranquiciadoid(1);
        franquicia.setFulladdress("C/blablabla");
        franquicia.setLatitude(25.5);
        franquicia.setLongitude(25.6);
        franquicia.setName("Franquisia");
        franquicia.setProfileimageurl("http://images");
        franquicia.setStateorprovince("Balares");
        System.out.println("-----------------------Franquicia---------------------------");
        System.out.println(franquicia.getBackground());
        System.out.println(franquicia.getCity());
        System.out.println(franquicia.getCountry());
        System.out.println(franquicia.getCp());
        System.out.println(franquicia.getFranquiciadoid());
        System.out.println(franquicia.getFulladdress());
        System.out.println(franquicia.getLatitude());
        System.out.println(franquicia.getLongitude());
        System.out.println(franquicia.getName());
        System.out.println(franquicia.getProfileimageurl());
        System.out.println(franquicia.getStateorprovince());

    }

    public static void pruebaUsuario() throws SQLException {
        Usuario user;
        user = new Usuario(1);
        user.setFbid("2");
        user.setCp("56");
        user.setFulladdress("2");
        user.setCity("2");
        user.setProfilesimageurl("localhost/a.png");
        user.setLatitude(20.5);
        user.setLongitude(100.5);
        user.setRegisterDate(new java.sql.Date(fecha.getTime()));
        user.setLastLogin(new java.sql.Date(fecha.getTime()));
        System.out.println("-----------------------Usuario---------------------------");
        System.out.println(user.getCity());
        System.out.println(user.getCountry());
        System.out.println(user.getCp());
        System.out.println(user.getEmail());
        System.out.println(user.getFbid());
        System.out.println(user.getFulladdress());
        System.out.println(user.getLastLogin());
        System.out.println(user.getPassword());
        System.out.println(user.getLongitude());
        System.out.println(user.getLatitude());
        System.out.println(user.getProfilesimageurl());
        System.out.println(user.getRegisterDate());
        System.out.println(user.getStateorprovince());
        System.out.println(user.getUsername());

    }

    public static void pruebaComercio() throws SQLException {
        Comercio comercio = new Comercio(1);
        comercio.setActive(false);
        comercio.setBusinessname("Mena Coop");
        comercio.setCity("Menaland");
        comercio.setCountry("Mena Paradise");
        comercio.setCp("07009");
        comercio.setDescription("Fabricante de menas");
        comercio.setFbid("XAFQWfa234##");
        comercio.setFulladress("Calle Mena");
        comercio.setLatitude(25.5);
        comercio.setLongitude(100.5);
        comercio.setProfileimageurl("localhost/a.png");
        comercio.setStateorprovince("Root");
        System.out.println("-----------------------Comercio---------------------------");
        System.out.println(comercio.getCity());
        System.out.println(comercio.getCountry());
        System.out.println(comercio.getCp());
        System.out.println(comercio.getDescription());
        System.out.println(comercio.getFbid());
        System.out.println(comercio.getFulladdress());
        System.out.println(comercio.getId());
        System.out.println(comercio.getLatitude());
        System.out.println(comercio.getLongitude());
        System.out.println(comercio.getProfileimageurl());
        System.out.println(comercio.getStateorprovince());
        if (comercio.isActive()) {
            System.out.println("Está activo");

        }
        {
            System.out.println("Está inactivo");
        }
    }

    public static void pruebaCupon() throws SQLException {
        Cupon cupon = new Cupon(1);
        cupon.setAvailquota(1);
        cupon.setBackgroundimageurl("images/url.png");
        cupon.setBusinessId(1);
        cupon.setCode("XGXAsladf5~swa");
        cupon.setConditions("Mayor de 19 años");
        cupon.setCouponimageurl("images/cupon.png");
        cupon.setDateexpiration(fecha);
        cupon.setDatestart(fecha);
        cupon.setDescription("Este cupon es una cosa");
        cupon.setName("Cosa");
        cupon.setPrice(100);
        cupon.setRealprice(50);
        cupon.setTitle("Cupon inverso");
        System.out.println("-----------------------Cupon---------------------------");
        System.out.println(cupon.getAvailquota());
        System.out.println(cupon.getBackgroundimageurl());
        System.out.println(cupon.getBusinessid());
        System.out.println(cupon.getCode());
        System.out.println(cupon.getConditions());
        System.out.println(cupon.getCouponimageurl());
        System.out.println(cupon.getDateexpiration());
        System.out.println(cupon.getDatestart());
        System.out.println(cupon.getId());
        System.out.println(cupon.getName());
        System.out.println(cupon.getPrice());
        System.out.println(cupon.getRealprice());
        System.out.println(cupon.getTitle());




    }
}
