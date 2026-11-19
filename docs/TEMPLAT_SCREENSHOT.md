# Templat Screenshot Program

Gunakan daftar ini untuk mengambil screenshot yang konsisten. Simpan semua gambar di `docs/screenshots/` dengan nama file seperti di tabel.

## Persiapan

- Jalankan aplikasi dengan `mvn clean javafx:run`.
- Untuk tampilan awal yang kosong, hapus dulu `data/katalog.db` (saat aplikasi tertutup).
- Screenshot seluruh jendela aplikasi, termasuk title bar "Katalog Produk UPI Store".
- Format PNG; ukuran jendela default 1000 x 760.

## Daftar Screenshot

| No | Nama file | Skenario | Data yang diisi | Hasil yang harus terlihat | Sudah? |
|---|---|---|---|---|---|
| 1 | `01-tampilan-awal.png` | Aplikasi baru dibuka | - | Form kosong, "Jumlah produk: 0", katalog kosong | [ ] |
| 2 | `02-form-terisi.png` | Form diisi, belum klik Simpan | Nama: `Roti Cokelat`, Harga: `10000`, Foto: `roti.png` | Field terisi, foto terpilih di ComboBox | [ ] |
| 3 | `03-produk-tersimpan.png` | Setelah klik Simpan | (sama dengan no. 2) | Pesan "Produk berhasil disimpan.", 1 kartu muncul, "Jumlah produk: 1" | [ ] |
| 4 | `04-katalog-banyak-produk.png` | Tambah minimal 3 produk | `Susu Murni` / `8000` / `susu.png`; `Kopi Hitam` / `12000` / `kopi.png` | 3 kartu dengan foto berbeda, "Jumlah produk: 3" | [ ] |
| 5 | `05-validasi-error.png` | Simpan dengan harga salah | Nama: `Tes`, Harga: `abc` | Pesan "Harga harus angka bulat, contoh 12000." | [ ] |
| 6 | `06-validasi-nama-kosong.png` | Simpan dengan nama kosong | Nama: (kosong), Harga: `5000` | Pesan "Nama produk wajib diisi." | [ ] |
| 7 | `07-data-tetap-ada.png` | Tutup, lalu buka aplikasi lagi | - | Produk sebelumnya masih tampil (bukti SQLite menyimpan) | [ ] |
| 8 | `08-mode-ubah.png` | Klik salah satu kartu produk | - | Kartu bersinar oranye, form terisi data produk, pesan "Mode ubah ID ..." | [ ] |
| 9 | `09-setelah-update.png` | Ubah data lalu klik Simpan | Nama: `Roti Cokelat Spesial`, Harga: `12000` | Pesan "Produk berhasil disimpan.", kartu menampilkan data baru | [ ] |
| 10 | `10-konfirmasi-hapus.png` | Klik kartu, lalu klik Hapus | - | Dialog "Hapus ...?" dengan tombol OK dan Cancel | [ ] |
| 11 | `11-setelah-hapus.png` | Klik OK pada dialog | - | Pesan "... berhasil dihapus.", kartu hilang, jumlah produk berkurang | [ ] |

## Cara Mengambil Screenshot

- **Windows:** `Win + Shift + S`, atau `Alt + PrtSc` untuk jendela aktif.
- **macOS:** `Cmd + Shift + 4`, lalu `Spasi` dan klik jendela.
- **Linux:** `PrtSc` atau Flameshot.

## Templat Keterangan Gambar (untuk laporan)

```
Gambar X. <judul singkat>
Keterangan: <apa yang ditunjukkan, 1-2 kalimat>
```

Contoh:

```
Gambar 3. Produk berhasil disimpan
Keterangan: Setelah tombol Simpan ditekan, produk muncul sebagai kartu
di katalog dan jumlah produk bertambah menjadi 1.
```
