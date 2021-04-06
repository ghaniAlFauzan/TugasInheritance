
# TugasInheritance
Nama  : Abdul Ghani Al-Fauzan
NIM   : 1900232

**Modifikasi Story Line**
Terdapat seorang pemuda yang terjebak didalam sebuah ruangan yang dijaga oleh penjaga, disana terdapat satu pintu yang bisa dibuka dengan menggunakan kunci yang dipegang oleh penjaga, setelah berbincang dengan penjaga, penjaga akan memberikan kunci kepada player jika player memberikan kartu pengenal kepada penjaga.

Didalam ruangan terdapat beberapa item, diantaranya adalah roti dan keranjang Keranjang Rotan Kusam, saat player membuka keranjang tersebut didalamnya terdapat 3 item   dan diantaranya terdapat kartu pengenal, sehingga player kini bisa berkomunikasi lagi dengan penjaga untuk meminta kunci dengan menunjukan tanda pengenal. setelah kunci didapat maka player bisa membuka pintu dengan kunci yang sebelumnya diambil dari penjaga

**Kelas yang sudah ada**
1. GameEngine
2. GameInfo
3. Player
4. Item
5. Ruangan
6. NPC
7. Pintu

**Kelas Tambahan** 
1. KeranjangMakanan

**Modifikasi kelas (Menggunakan Inheritance)**
-   SuperClass  = Item
    SubClass    = NPC, Pintu, KeranjangMakanan

**Memperbaiki**
- Kelas NPC, Pintu,KeranjangMakanan dibuat menjadi kelas turunan dari kelas Item
- Menambah override method untuk kelas turunan dari Item yaitu method prosesAksi,setObjGameInfo, dan getAksi. 
    
 

**Tambahan dari story line**
- Didalam ruangan terdapat Keranjang makanan yang merupakan objek dari kelas turunan Item yang berisi 3 buah objek item makanan
- Penjaga sebelum memberi kunci meminta objek kartu pengenal dari player



