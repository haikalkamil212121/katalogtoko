# Katalog Produk UPI Store

Aplikasi desktop sederhana berbasis **JavaFX** untuk mengelola katalog produk. Pengguna dapat menambah, mengubah (update), dan menghapus (delete) produk. Data disimpan di database **SQLite** dan tampil sebagai kartu di katalog.

## Fitur

- **Create:** tambah produk (nama, harga, foto roti/susu/kopi).
- **Read:** katalog kartu produk berwarna-warni (4 warna bergantian).
- **Update:** klik kartu produk, data masuk ke form, ubah lalu klik **Simpan**.
- **Delete:** klik kartu produk, klik **Hapus**, lalu konfirmasi.
- Tombol **Batal** membatalkan pilihan dan kembali ke mode tambah.
- Kartu produk diberi warna bergantian (indigo, pink, hijau, kuning).
- Validasi input:
  - nama tidak boleh kosong,
  - harga harus angka bulat dan lebih dari 0,
  - foto wajib dipilih.
- Penyimpanan permanen ke SQLite (`data/katalog.db`), dibuat otomatis saat aplikasi pertama dijalankan.
- Tampilan katalog berupa kartu produk (foto, nama, harga, ID) dan penghitung jumlah produk.
- Pesan status di form (berhasil / gagal).

## Teknologi

| Komponen | Versi |
|---|---|
| Java | 17 |
| JavaFX (controls, fxml) | 21 |
| SQLite JDBC (`org.xerial:sqlite-jdbc`) | 3.49.1.0 |
| Build tool | Maven |

## Struktur Proyek

```
KatalogProduk/
├── pom.xml
├── data/                      # database katalog.db dibuat di sini saat dijalankan
├── docs/screenshots/          # taruh screenshot program di sini
└── src/main/
    ├── java/
    │   ├── main/MainApp.java                  # entry point, memuat FXML
    │   ├── controller/KatalogController.java  # logika form & tampilan kartu
    │   ├── data/ProdukRepository.java         # akses data (INSERT, SELECT, UPDATE, DELETE)
    │   ├── db/Database.java                   # koneksi & pembuatan tabel
    │   └── model/Produk.java                  # model + validasi
    └── resources/
        ├── image/                             # roti.png, susu.png, kopi.png
        └── view/
            ├── katalog.fxml                   # layout UI
            └── styles/app.css                 # styling
```

## Cara Menjalankan

Prasyarat: **JDK 17+** dan **Maven** terpasang.

```bash
cd KatalogProduk
mvn clean javafx:run
```

Atau dari IDE (NetBeans / IntelliJ / Eclipse): buka sebagai proyek Maven, lalu jalankan kelas `main.MainApp`.

> Database dibuat di folder `data/` relatif terhadap direktori kerja (`user.dir`). Jalankan dari folder proyek agar file `data/katalog.db` berada di tempat yang benar. Lokasi aktif dicetak di console: `DATABASE AKTIF: ...`

## Cara Pakai

**Tambah produk**
1. Isi **Nama produk**, contoh: `Roti Cokelat`.
2. Isi **Harga (Rp)**, contoh: `10000`.
3. Pilih **Foto contoh** dari daftar.
4. Klik **Simpan**. Produk muncul di katalog.

**Ubah produk**
1. Klik kartu produk di katalog (kartu bersinar oranye, muncul pesan "Mode ubah ID ...").
2. Ubah nama, harga, atau foto di form.
3. Klik **Simpan**.

**Hapus produk**
1. Klik kartu produk di katalog.
2. Klik **Hapus**, lalu **OK** pada dialog konfirmasi.

## Skema Database

```sql
CREATE TABLE IF NOT EXISTS produk (
    id    INTEGER PRIMARY KEY,
    nama  TEXT    NOT NULL CHECK(length(trim(nama)) > 0),
    harga INTEGER NOT NULL CHECK(harga > 0),
    foto  TEXT    NOT NULL CHECK(length(trim(foto)) > 0)
);
```

## Screenshot

