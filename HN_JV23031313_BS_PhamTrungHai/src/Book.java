public class Book {
private int idsach;
private String tensach, tacgia,mota;
private Double gianhap,giaxuat;
private float loinhan;
private boolean trangthai;

    public Book() {
    }

    public Book(int idsach, String tensach, String tacgia, String mota, Double gianhap, Double giaxuat, float loinhan, boolean trangthai) {
        this.idsach = idsach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.mota = mota;
        this.gianhap = gianhap;
        this.giaxuat = giaxuat;
        this.loinhan = loinhan;
        this.trangthai = trangthai;
    }

    public int getIdsach() {
        return idsach;
    }

    public void setIdsach(int idsach) {
        this.idsach = idsach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Double getGianhap() {
        return gianhap;
    }

    public void setGianhap(Double gianhap) {
        this.gianhap = gianhap;
    }

    public Double getGiaxuat() {
        return giaxuat;
    }

    public void setGiaxuat(Double giaxuat) {
        this.giaxuat = giaxuat;
    }

    public float getLoinhan() {
        return loinhan;
    }

    public void setLoinhan(float loinhan) {
        this.loinhan = loinhan;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "-----------------------------------------------\n"
                +"ID: "+idsach + "| tensach: "+tensach+" | tacgia : "+tacgia+
                "\nmota: "+mota+ " | gia: "+giaxuat;
    }
}
