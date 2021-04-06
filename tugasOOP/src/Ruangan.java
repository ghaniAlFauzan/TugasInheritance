import java.util.ArrayList;
import java.util.Scanner;

public class Ruangan {
    private final ArrayList<Item> arrItem = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    private final Pintu objPintu;
    private final NPC objNPC;

    public Ruangan(){
        // init ruangan
        // init pintu, kunci dan roti.
        Item objRoti = new Item("Roti");
        objRoti.setDeskripsi("Roti rasa coklat dalam bungkusan plastik");
        objRoti.setObjRuangan(this);

        objPintu = new Pintu("Pintu ruangan 1");
        objPintu.setDeskripsi("Pintu Berwarna Merah 'EXIT' di atas");

        objNPC = new NPC("Penjaga Gemuk");
        objNPC.setDeskripsi("Halo saya penjaga pintu ini");

        KeranjangMakanan objKeranjangRotan = new KeranjangMakanan("Keranjang Rotan Kusam", "Kartu Pengenal", "Kartu pengenal dengan foto yang sudah buram", "Kue coklat", "Kukis bulat dengan taburan coklat", "selai jeruk", "sebotol selai dengan warna orange");
        objKeranjangRotan.setDeskripsi("Keranjang anyaman rotan dengan penutup kayu");


        //tambah item, pintu, dan NPC ke array
        arrItem.add(objRoti);
        arrItem.add(objPintu);
        arrItem.add(objNPC);
        arrItem.add(objKeranjangRotan);

    }

    //objgame juga diset pada pintu dan item2
    public void setObjGameInfo(GameInfo objGameInfo) {
        objPintu.setObjGameInfo(objGameInfo);
        objNPC.setObjGameInfo(objGameInfo);
        for (Item objItem:arrItem) {
            objItem.setObjGameInfo(objGameInfo);
        }
    }

    public void setDeskripsi() {
    }

    public void hapusItem(Item objItem) {
        arrItem.remove(objItem);  //buang item
    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);
    }

    //aksi yang dapat dilakukan di ruangan
    //agak kompleks tapi jadi fleksibel, logic aksi ada di masing2 item (bukan di game engine)
    //hardcode menu dikurangi

    public void pilihanAksi() {
        System.out.println("==== Pilihan Aksi pada Ruangan ===");
        int urutPil = 0;  //item, pintu
        int subPil;   //aksinya

        System.out.println("Objek dalam ruangan");
        for (Item objItem:arrItem) {
            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());
            //ambil pilihannya
            ArrayList <String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }

        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        //split pilihan dan subpilihan

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        Item objItemPilih = arrItem.get(pil-1);
        objItemPilih.prosesAksi(subPil); //aksi item

    }
}
