package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvisoDAOimpl extends ConexionDB implements AvisoDAO {

    @Override
    public void insert(Aviso aviso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT into productos (producto,precio,cantidad) values (?,?)");
            ps.setString(1, aviso.getProducto());
            ps.setString(2, aviso.getPrecio());
            ps.setString(3, aviso.getCantidad());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Aviso aviso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE productos set producto = ?, precio = ?, cantidad =?, where id = ?");
            ps.setString(1, aviso.getProducto());
            ps.setString(2, aviso.getPrecio());
            ps.setString(3, aviso.getCantidad());
            ps.setInt(4, aviso.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM productos WHERE id = ? ");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public Aviso getById(int id) throws Exception {

        Aviso avi = new Aviso();
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT *FROM productos WHERE id = ? limit 1 ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                avi.setId(rs.getInt("id"));
                avi.setProducto(rs.getString("producto"));
                avi.setPrecio(rs.getString("precio"));
                avi.setCantidad(rs.getString("cantidad"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return avi;
    }

    @Override
    public List<Aviso> getAll() throws Exception {
        List<Aviso> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM productos");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Aviso>();
            while (rs.next()) {
                Aviso avi = new Aviso();
                avi.setId(rs.getInt("id"));
                avi.setProducto(rs.getString("producto"));
                avi.setPrecio(rs.getString("precio"));
                avi.setCantidad(rs.getString("cantidad"));
                lista.add(avi);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
