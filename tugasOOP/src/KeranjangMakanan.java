import java.util.ArrayList;

public class KeranjangMakanan extends Item{
    private Item item1,item2,item3;

    public KeranjangMakanan(String nama,String item1, String des1, String item2, String des2,String item3, String des3){
        super(nama);
        arrAksi.add("Buka penutup kain");
        arrAksi.add("Deskripsi keranjang");
        this.item1 = new Item(item1);
        this.item1.setDeskripsi(des1);

        this.item2 = new Item(item2);
        this.item2.setDeskripsi(des2);

        this.item3 = new Item(item3);
        this.item3.setDeskripsi(des3);

    }

    @Override
    public void prosesAksi(int subPil) {
        // 1. membuka penutup kain
        // 2. Menampilkan deskrpisi keranjang
        if (subPil ==1){
            if(item1 == null && item2 == null && item3 == null){
                System.out.println("Sepertinya barang dalam keranjang ini telah diambil");
            }
            else {
                System.out.println("1. " +item1.nama);
                System.out.println("2. " +item2.nama);
                System.out.println("3. " +item3.nama);
                objGameInfo.getObjPlayer().addItem(item1);item1 = null;
                objGameInfo.getObjPlayer().addItem(item2);item2 = null;
                objGameInfo.getObjPlayer().addItem(item3);item3 = null;
                System.out.println("Telah anda ambil dari keranjang");
            }
        }
        else if (subPil==2){
            System.out.println(deskripsi);
        }
    }

    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        item1.setObjGameInfo(objGameInfo);
        item2.setObjGameInfo(objGameInfo);
        item3.setObjGameInfo(objGameInfo);
    }

    @Override
    public ArrayList<String> getAksi() {
        return arrAksi;
    }


}
