import java.util.ArrayList;

public class NPC extends Item{
    //kunci dipindahkan dari ruangan
    private Item  objKunci;
    private boolean isKenal = false;

    public NPC(String nama) {
        super(nama);
        //init kunci
        objKunci = new Item("Kunci");
        objKunci.setDeskripsi("Sebuah kunci kecil yang sudah agak berkarat");

        //aksi npc
        arrAksi.add("Perkenalan dgn NPC");
        arrAksi.add("Minta kunci");
    }

    @Override
    public ArrayList<String> getAksi() {
        return arrAksi;
    }

    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        objKunci.setObjGameInfo(objGameInfo);
        this.objGameInfo = objGameInfo;

    }

    @Override
    public void prosesAksi(int subPil) {
        //1: perkenalan dengan npc
        //2: buka pintu
        if (subPil == 1) {
            System.out.println(deskripsi);
            isKenal = true;
        } else if (subPil == 2) {
            if (isKenal && objGameInfo.getObjPlayer().cariItem("Kartu Pengenal")) {
                //berikan kunci pada player
                if (objKunci==null) {
                    System.out.println("Masa lupa, kunci kan sudah saya berikan!");
                    System.out.println("Pergi sana jangan ganggu saya !");
                } else
                {
                    System.out.println("Sebentar Aku baca dulu kartu pengenalnya");
                    System.out.println("Oh baik silahkan !");
                    System.out.println("Kunci diberikan pada player");
                    objGameInfo.getObjPlayer().addItem(objKunci);     //tambahkan  objek ini pada player
                    objKunci = null;
                }
            } else if (isKenal && !objGameInfo.getObjPlayer().cariItem("Kartu Pengenal")){
                System.out.println("KAMU MAU KUNCI ?");
                System.out.println("Kunci hanya diberikan kepada orang dengan kartu pengenal");
            }else if (objGameInfo.getObjPlayer().cariItem("Kartu Pengenal") && !isKenal){
                System.out.println("Kamu Siapa ? Kenalan Dulu donggg !");
            }else {
                System.out.println("Kamu Siapa ? Kenalan Dulu donggg !");
            }
        }
    }
}
