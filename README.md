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

### 1. Tampilan awal (katalog kosong)
<img width="767" height="599" alt="image" src="https://github.com/user-attachments/assets/62f7ff45-1aba-44a1-a91f-1a1797701d9e" />


### 2. Form terisi sebelum disimpan
<img width="761" height="596" alt="image" src="https://github.com/user-attachments/assets/15dfa4f8-e577-425d-9b27-99fc3afbfd87" />


### 3. Produk berhasil disimpan
<img width="743" height="593" alt="image" src="https://github.com/user-attachments/assets/60880ed7-9438-4578-9cdc-f207d5b7eda8" />


### 4. Katalog dengan beberapa produk
<img width="746" height="586" alt="image" src="https://github.com/user-attachments/assets/0d8680a3-124e-4825-a1ec-8f46a031d9ef" />


### 5. Validasi error (harga bukan angka)
<img width="725" height="557" alt="image" src="https://github.com/user-attachments/assets/7e1d78da-e7ec-42dc-a9cf-7486a1f2feb4" />


### 6. Mode ubah (produk dipilih)
<img width="743" height="585" alt="image" src="https://github.com/user-attachments/assets/21637629-86ea-4168-aac8-cdb1ca163cec" />


### 7. Setelah update
<img width="743" height="584" alt="image" src="https://github.com/user-attachments/assets/d1bb0c69-780e-42fc-8e3d-c12705a42fe7" />


### 8. Dialog konfirmasi hapus
<img width="736" height="580" alt="image" src="https://github.com/user-attachments/assets/2f0d85de-d31a-4be6-a371-d4b63c29ef10" />


### 9. Setelah hapus
<img width="749" height="591" alt="image" src="https://github.com/user-attachments/assets/d42374c0-fce5-4dd3-a749-1377a19e9617" />

