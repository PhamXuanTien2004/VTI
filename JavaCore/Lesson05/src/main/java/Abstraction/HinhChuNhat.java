package Abstraction;

public class HinhChuNhat {
    private int cDai;
    private int cRong;

    public HinhChuNhat(int cRong, int cDai) {
        this.cRong = cRong;
        this.cDai = cDai;
    }

    public int chuVi(){
        return (cDai+cRong)*2;
    };

    public int dienTich(){
        return cDai*cRong;
    };
}
