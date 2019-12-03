package threadsdemo;


public class ThreadsDemo {
            
    public static void main(String[] args) {
        Player hero1 = new Player();
        Player hero2 = new Player();
        Player monster1 = new Player();
        Player monster2 = new Player();
        Player monster3 = new Player();
        Player monster4 = new Player();
        Player monster5 = new Player();
        Player monster6 = new Player();
        Player monster7 = new Player();
        
        PlayerList enemiesHero1 = new PlayerList();
        enemiesHero1.add(monster1);
        enemiesHero1.add(monster3);
        enemiesHero1.add(monster6);
        enemiesHero1.add(monster7);
        
        
        PlayerList enemiesHero2 = new PlayerList();
        enemiesHero2.add(monster2);
        enemiesHero2.add(monster4);
        enemiesHero2.add(monster5);
        enemiesHero2.add(monster7);
        
        PlayerList heroesEnemy = new PlayerList();
        heroesEnemy.add(hero1);
        
        PlayerList heroesEnemy2 = new PlayerList();
        heroesEnemy2.add(hero2);
        
        PlayerList heroesEnemy3 = new PlayerList();
        heroesEnemy3.add(hero1);
        heroesEnemy3.add(hero2);
        
        hero1.setPlayer("Len The Warrior", 15000, enemiesHero1);
        hero2.setPlayer("Rin The King", 20000, enemiesHero2);
        
        monster1.setPlayer("Slime", 25, heroesEnemy);
        monster2.setPlayer("Skelleton", 80, heroesEnemy2);
        monster3.setPlayer("Zombie", 50, heroesEnemy);
        monster4.setPlayer("Zombie Warrior", 100, heroesEnemy2);
        monster5.setPlayer("Big Slime", 50, heroesEnemy2);
        monster6.setPlayer("Black Skelleton", 90, heroesEnemy);
        monster7.setPlayer("Monster King", 500, heroesEnemy3);
        
        
        hero1.live();
        hero2.live();
        monster1.live();
        monster2.live();
        monster3.live();
        monster4.live();
        monster5.live();
        monster6.live();
        monster7.live();
        
    }
    
}
