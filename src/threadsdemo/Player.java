package threadsdemo;

import java.util.Random;

public class Player extends Thread{
    
    private String name;
    private int lives;
    private PlayerList enemies;
    
    public synchronized void setPlayer(String name, int lives, PlayerList enemies){
        this.name = name;
        this.lives = lives;
        this.enemies = enemies;
    }   
    public synchronized void live() {
        this.start();
        System.out.printf("%s is ALIVE!%n", this.getPlayerName());
    }
    public String getPlayerName(){
        return this.name;
    }
    public int getLives(){
        return this.lives;
    }
    public boolean isDeath(){
        return (this.lives == 0);
    }
    public void death(){
        this.interrupt();
        System.out.printf("%s is DEATH!%n",this.getPlayerName());
    }
    public synchronized void fire(){
        Random generator = new Random();
        int index = generator.nextInt(enemies.size());
        if (index >= 0){
            if(!enemies.get(index).isDeath()){
                int damage = generator.nextInt(20) + 1;
                int points = damage / 3;
                System.out.printf("%s (%d) fired weapon with %d of damage to %s (%d) and win %d points%n",
                        this.getPlayerName(), this.getLives(), damage, enemies.get(index).getPlayerName(), enemies.get(index).getLives(), points);
                enemies.get(index).reciveHit(damage);
                this.giveHit(points);
                
            }else {
                System.out.printf("%s WINS!!! %n",this.getPlayerName());
                this.interrupt();
            }
        }
    
    }
    private void giveHit(int points) {
        if (!isDeath()){
            lives = lives + points;
        }
    }
    private void reciveHit(int damage){
        if (!isDeath()){
            if(lives > damage){
                lives = lives - damage;
            }else{
                lives = 0;
                death();
            }
        }
    }
    public void run(){
        try{
            while(!isDeath()){
                Thread.sleep(1000);
                this.fire();
            }
        }catch(InterruptedException e){   }
    }
}
