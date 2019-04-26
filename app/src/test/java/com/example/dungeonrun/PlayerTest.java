package com.example.dungeonrun;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PlayerTest {
    @Test
    public void inventory_works() {
        Player p = new Player(1,1,10,10,1,1);
        Chestpiece a = new Chestpiece(4,2);
        Boots b = new Boots(1,3);
        Chestpiece c = new Chestpiece(5,2);
        Sword d = new Sword(2,3);
        Pants e = new Pants(2,2);
        Sword f = new Sword(1,3);

        p.obtainItem(a);
        p.obtainItem(b);
        p.obtainItem(c);
        p.obtainItem(d);
        p.obtainItem(e);
        p.obtainItem(f);

        System.out.println(p.getBootsInv());
        System.out.println(p.getDex());
        p.equipItem(b);
        System.out.println(p.getDex());
        System.out.println(p.getEquippedBoots());
        System.out.println(p.getBootsInv());
        p.unequipItem(b);
        System.out.println(p.getDex());
        System.out.println(p.getEquippedBoots());
        System.out.println(p.getBootsInv());
    }

}