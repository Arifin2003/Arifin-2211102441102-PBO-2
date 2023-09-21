import greenfoot.*;

public class Flappybird extends Actor
{
    private double velocity = 0; // Kecepatan awal vertikal
    private int y = 300;
    private boolean hasPressed = false;
    private boolean isAlive = true;
    private boolean hasCrossedPipe = false;
    private boolean hasAddedScore = false; 

    public Flappybird(){
        GreenfootImage image = getImage();
        image.scale(50, 40);
    }

    public void act() 
    {
        if(isAlive){
            // Jika menekan spasi, terbang ke atas
            if(spacePressed()){
                velocity = -5; // Semakin besar angka negatif, semakin tinggi terbangannya
            }
            velocity += 0.2; // Gravitasi
            y += velocity;
            setLocation(getX(), (int)(y));
            
            // Jika menabrak pipa maka game over
            if(isTouchingPipe()){
                isAlive = false;
            }
            
            // Jika jatuh ke luar layar, game over
            if(isAtEdge()){
                Greenfoot.playSound("peng.mp3");
                isAlive = false;
            }
            
            // Jika melewati pipa, tambahkan skor
            if(hasCrossedPipe && !hasAddedScore){
                Greenfoot.playSound("score.mp3");
                Score.add(1);
                hasAddedScore = true;
            }
        }
        else {
            showGameOver();
        }
    }

    public boolean spacePressed(){
        boolean pressed = false;
        if(Greenfoot.isKeyDown("space")){
            if(!hasPressed){
                Greenfoot.playSound("flay.mp3");
                pressed = true;
            }
            hasPressed = true;
        } else {
            hasPressed = false;
        }
        return pressed;
    }

    public boolean isTouchingPipe(){
        for(Pipe pipe : getIntersectingObjects(Pipe.class)){
            if(pipe != null){
                Greenfoot.playSound("flay.mp3");
                isAlive = false;
                return true;
            }
        }
        return false;
    }

    public void showGameOver(){
        if(getWorld() != null){
            getWorld().addObject(new Gameover(), 300, 200);
            getWorld().removeObject(this);
        }
    }
}
