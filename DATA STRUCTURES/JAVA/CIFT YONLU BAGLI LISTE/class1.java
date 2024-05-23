package veri;

public class class1 {
    private class2 bas;
    private class2 kuyruk;

    public class1() {
        this.bas = null;
        this.kuyruk = null;
    }

    public void ekle(int data) {
        class2 newNode = new class2(data);
        if (bas == null) {
        	bas = newNode;
        	kuyruk = newNode;
        } else {
        	kuyruk.sonraki = newNode;
            newNode.onceki = kuyruk;
            kuyruk = newNode;
        }
    }

    public void yazdir() {
        class2 gecici = bas;
        while (gecici != null) {
            System.out.print(gecici.data + " ");
            gecici = gecici.sonraki;
        }
        System.out.println();
    }

    public void sirala() {
        if (bas == null || bas.sonraki == null) {
            return;
        }

        class2 gecici;
        class2 end = null;
        while (end != bas) {
        	gecici = bas;
            while (gecici.sonraki != end) {
                if (gecici.data > gecici.sonraki.data) {
                    int temp = gecici.data;
                    gecici.data = gecici.sonraki.data;
                    gecici.sonraki.data = temp;
                }
                gecici = gecici.sonraki;
            }
            end = gecici;
        }
    }
}