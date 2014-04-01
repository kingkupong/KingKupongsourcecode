/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD.utilities;

import BBDD.tables.Comercio;
import BBDD.tables.Franquiciado;
import BBDD.tables.Usuario;
import Mailing.*;
import Security.Encriptar;
import java.sql.SQLException;

/**
 *
 * @author Boomeraling
 */
public class UserManagement {

    public static Usuario registroUsuario(String nombre, String email, String password, String country, String stateorprovince) throws SQLException {
        Usuario user = null;
        try {
            if (!Consultas.existeMailUsuario(email)) {
                password = Encriptar.encryptSHA1(password);
                user = new Usuario(nombre, email, password, country, stateorprovince);
                int c = 0;
                Mailing.enviarMailBienvenida(email);
            } else {
                throw new SQLException("El correo electrónico del usuario ya existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public Usuario registroFacebookUsuario(String nombre, String email, String password, String country, String stateorprovince, String fbid, String profileimageurl) {
Usuario user = null;
        try {
            if (!Consultas.existeMailUsuario(email)) {
                password = Encriptar.encryptSHA1(password);
                user = new Usuario(nombre, email, password, country, stateorprovince);
                user.setFbid(fbid);
                user.setProfilesimageurl(profileimageurl);
                Mailing.enviarMailBienvenida(email);
            } else {
                throw new SQLException("El correo electrónico del usuario ya existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }
    
    public static Comercio registroComercio(String businessname, String email, String password, String country, String fulladdress, String city, String stateorprovince, String cp, boolean active) {
        Comercio comercio = null;
        try {
            if (!Consultas.existeMailComercio(email)) {
                password = Encriptar.encryptSHA1(password);
                comercio = new Comercio(businessname, email, password, country, fulladdress, city, stateorprovince, cp, false);
                Mailing.enviarMailBienvenida(email);
            } else {
                throw new SQLException("El correo electrónico del comercio ya existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comercio;
    }

    public void activarComercio(Comercio c) throws SQLException {
        c.setActive(true);
    }

    public void desactivarComercio(Comercio c) throws SQLException {
        c.setActive(false);
    }

    public static Franquiciado registroFranquiciado(String name, String surname,String password, String NIF, String address, String email, String telefono) {

        Franquiciado franquicia = null;
        try {
            if (!Consultas.existeMailFranquiciado(email)) {
                password = Encriptar.encryptSHA1(password);
                franquicia = new Franquiciado(name, surname, password, NIF, address, email, telefono);
                Mailing.enviarMailBienvenida(email);
            } else {
                throw new SQLException("El correo electrónico del Franquiciado ya existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return franquicia;

    }

    public Franquiciado registroFacebookFranquiciado(String name, String surname,String password, String NIF, String address, String email, String telefono, String fbid, String profileimageurl) {
        Franquiciado franquicia = null;
        try {
            if (!Consultas.existeMailFranquiciado(email)) {
                password = Encriptar.encryptSHA1(password);
                franquicia = new Franquiciado(name, surname, password, NIF, address, email, telefono);
                franquicia.setProfileimageurl(profileimageurl);
                franquicia.setFbid(fbid);
                Mailing.enviarMailBienvenida(email);
            } else {
                throw new SQLException("El correo electrónico del Franquiciado ya existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return franquicia;

    }

    public Comercio registroFacebookComercio(String businessname, String email, String password, String country, String fulladdress, String city, String stateorprovince, String cp, boolean active) {
        Comercio comercio = null;
        try {
            if (!Consultas.existeMailComercio(email)) {
                password = Encriptar.encryptSHA1(password);
                comercio = new Comercio(businessname, email, password, country, fulladdress, city, stateorprovince, cp, false);
                comercio.setFbid(cp);
                comercio.setProfileimageurl(email);
                Mailing.enviarMailBienvenida(email);
            } else {
                throw new SQLException("El correo electrónico del comercio ya existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comercio;
    }

    public static Usuario loginUsuario(String email, String password) {
        Usuario user = null;
        try {
            if (Consultas.existeMailUsuario(email)) {
                try {
                    if (Consultas.checkPasswordUsuario(email, Encriptar.encryptSHA1(password))) {
                        user = new Usuario(email, Usuario.Busqueda.EMAIL);
                    } else {
                        throw new SQLException("La contraseña del usuario introducida es incorrecta");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                throw new SQLException("El correo electrónico del usuario introducido no está registrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static Comercio loginComercio(String email, String password) {
        Comercio comercio = null;
        try {
            if (Consultas.existeMailComercio(email)) {
                try {
                    if (Consultas.checkPasswordComercio(email, Encriptar.encryptSHA1(password))) {
                        comercio = new Comercio(email, Comercio.Busqueda.EMAIL);
                    } else {
                        throw new SQLException("La contraseña comercio introducida es incorrecta");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                throw new SQLException("El correo electrónico del comercio introducido no está registrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comercio;
    }

    public static Franquiciado loginFranquiciado(String email, String password) {
       Franquiciado franquiciado = null;
        try {
            if (Consultas.existeMailFranquiciado(email)) {
                try {
                    if (Consultas.checkPasswordFranquiciado(email, Encriptar.encryptSHA1(password))) {
                        franquiciado = new Franquiciado(email, Franquiciado.Busqueda.EMAIL);
                    } else {
                        throw new SQLException("La contraseña del franquiciado introducida es incorrecta");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                throw new SQLException("El correo electrónico del franquiciado introducido no está registrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return franquiciado;
    }

    public Usuario loginFacebookUsuario(String fbid) throws SQLException {
        return(new Usuario(fbid,Usuario.Busqueda.FBID));

    }

    public Comercio loginFacebookComercio(String fbid) throws SQLException {
        return(new Comercio(fbid,Comercio.Busqueda.FBID));

    }

    public Franquiciado loginFacebookFranquiciado(String fbid) throws SQLException {
        return(new Franquiciado(fbid,Franquiciado.Busqueda.FBID));

    }

}
