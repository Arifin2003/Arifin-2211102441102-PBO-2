import greenfoot.*;

public class Pesawat extends Actor
{
    private static final int SPEED = 5; // Kecepatan pergerakan pesawat
    
    public Pesawat()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 2, image.getHeight() / 2); // Mengecilkan gambar sebanyak setengah dari ukuran aslinya
        setImage(image);
    }
    
    public void act()
    {
        // Memeriksa tombol yang ditekan oleh pemain
        if (Greenfoot.isKeyDown("left"))
        {
            // Mengatur rotasi ke kiri dan bergerak ke kiri
            setRotation(getRotation() - 5); // Mengurangi rotasi sebesar 5 derajat
            move(SPEED);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            // Mengatur rotasi ke kanan dan bergerak ke kanan
            setRotation(getRotation() + 5); // Menambah rotasi sebesar 5 derajat
            move(SPEED);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            // Bergerak ke arah rotasi saat ini
            move(SPEED);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            // Mengatur rotasi 180 derajat (menghadap ke belakang) dan bergerak mundur
            setRotation(getRotation() + 180);
            move(SPEED);
        }
    }
}
