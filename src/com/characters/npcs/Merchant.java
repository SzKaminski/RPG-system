package com.characters.npcs;

import com.characters.Character;
import com.characters.Hero;
import com.characters.characterAttributes.Dexterity;
import com.characters.characterAttributes.Endurance;
import com.characters.characterAttributes.Intelligence;
import com.characters.characterAttributes.Strength;
import com.items.Item;
import com.items.playable.armors.PeasantShirt;
import com.items.playable.consumables.Cheese;
import com.items.playable.shields.OldWoodenShield;
import com.items.playable.weapons.RustySword;
import com.places.MarketPlace;
import com.visualeffects.PauseEffect;
import com.visualeffects.Printer;

import java.util.Scanner;

public class Merchant extends Character {


    public Merchant() {
        super(new Strength(100), new Dexterity(10), new Endurance(10), new Intelligence(10));
        setGold(5000);
        setLocation(new MarketPlace());
        setName("Nate Ganray");
        setDescription("placeholder description");
        getItems().add(new RustySword());
        getItems().add(new PeasantShirt());
        getItems().add(new Cheese());
        getItems().add(new OldWoodenShield());
    }

    @Override
    public void getConversation(Hero hero) {
        System.out.println("You are approaching " + this.getName());
        PauseEffect.pause();
        Printer.println("Currently on sale:", Printer.PrinterColor.COLOR_YELLOW);
        for (int i = 0; i < getItems().size(); i++) {
            System.out.println(i + 1 + ") " + getItems().get(i).getName() + " |type: " + getItems().get(i).getItemType().toString().toLowerCase() + " |price: " + getItems().get(i).getValue());
        }
        System.out.println("Gold: " + hero.getGold() + " | Type S to enter selling mode");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();

        if (s.equals("s")) {
            sellItemToMerchant(hero, sc);

        } else {
            buyItemFromMerchant(hero, s);
        }

    }

    private void sellItemToMerchant(Hero hero, Scanner sc) {
        for (int i = 0; i < hero.getItems().size(); i++) {
            System.out.println(i + 1 + ") " + hero.getItems().get(i).getName() + " |price: " + hero.getItems().get(i).getValue());
        }
        String sell = sc.nextLine().toLowerCase();
        Item item;
        try {
            item = hero.getItems().get(Integer.parseInt(sell) - 1);
        } catch (NumberFormatException e) {
            return;
        }
        hero.getItems().remove(item);
        hero.setGold(hero.getGold() + item.getValue());
        System.out.println(item.getName() + " sold");
    }

    private void buyItemFromMerchant(Hero hero, String s) {
        Item item;
        try {
            item = getItems().get(Integer.parseInt(s) - 1);
        } catch (NumberFormatException e) {
            return;
        }

        if (item.getValue() <= hero.getGold()) {
            hero.setGold(hero.getGold() - item.getValue());
            hero.getItems().add(item);
            getItems().remove(item);
            System.out.println(item.getName() + " purchased");
        } else {
            System.out.println("Do not have enough money");
        }
    }

}
