package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import db.Database;
import model.Produk;

public class ProdukRepository {

    public void add(Produk produk) throws SQLException {
        String sql = "INSERT INTO produk (nama, harga, foto) VALUES (?, ?, ?)";
        try ( 
            Connection koneksi = Database.bukaKoneksi();  
            PreparedStatement perintah = koneksi.prepareStatement(sql)) {
            perintah.setString(1, produk.getNama());
            perintah.setLong(2, produk.getHarga());
            perintah.setString(3, produk.getFoto());
            perintah.executeUpdate();
        }
    }

    public void update(Produk produk) throws SQLException {
        try (Connection k = Database.bukaKoneksi(); PreparedStatement p = k.prepareStatement("UPDATE produk SET nama = ?, harga = ?, foto = ? WHERE id = ?")) {
            p.setString(1, produk.getNama()); p.setLong(2, produk.getHarga()); p.setString(3, produk.getFoto()); p.setLong(4, produk.getId()); p.executeUpdate();
        }
    }

    public void delete(long id) throws SQLException {
        try (Connection k = Database.bukaKoneksi(); PreparedStatement p = k.prepareStatement("DELETE FROM produk WHERE id = ?")) {
            p.setLong(1, id); p.executeUpdate();
        }
    }

    public ArrayList<Produk> getAll() throws SQLException {
        ArrayList<Produk> daftarProduk = new ArrayList<Produk>();
        String sql = "SELECT id, nama, harga, foto FROM produk ORDER BY id";
        try ( 
            Connection koneksi = Database.bukaKoneksi();  
            PreparedStatement perintah = koneksi.prepareStatement(sql);  
            ResultSet hasil = perintah.executeQuery()) {
            while (hasil.next()) {
                long id = hasil.getLong("id");
                String nama = hasil.getString("nama");
                long harga = hasil.getLong("harga");
                String foto = hasil.getString("foto");
                Produk produk = new Produk(id, nama, harga, foto);
                daftarProduk.add(produk);
            }
        }
        return daftarProduk;
    }
}
