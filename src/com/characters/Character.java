package com.characters;

import com.characters.characterAttributes.*;
import com.items.Equipment;
import com.items.Item;
import com.items.playable.ammunition.Ammunition;
import com.items.playable.amulets.Amulet;
import com.items.playable.armors.Armor;
import com.items.playable.shields.Shield;
import com.items.playable.weapons.Weapon;

public abstract class Character {

    private int level = 1;

    private CharAttribute charAttribute;

    private int gold;
    private Strength strength;
    private Dexterity dexterity;
    private Endurance endurance;
    private Intelligence intelligence;

    private MeleeAttack meleeAttack;
    private Dodge dodge;
    private HealthPoints healthPoints;
    private HealthPoints actualHealthPoints;
    private ManaPoints manaPoints;

    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private Amulet equippedAmulet;
    private Ammunition equippedAmmunition;
    private Shield equippedShield;

    private Equipment<Item> items;

    public Equipment<Item> getItems() {
        return items;
    }

    public Character() {
        items = new Equipment<>();
    }

    public Character(Strength strength,
                     Dexterity dexterity,
                     Endurance endurance,
                     Intelligence intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.endurance = endurance;
        this.intelligence = intelligence;
    }

    public CharAttribute getAttribute() {
        return charAttribute;
    }


    public HealthPoints getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(HealthPoints healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void addHealthPoints(int value){
        int i = getHealthPoints().getValue() + value;
        this.healthPoints.setValue(i);
    }

    public void setBasicHealthPoints() {
        int i = ComputingAttribute.computeHealthPoints(endurance.getValue());
        setHealthPoints(new HealthPoints(i));
    }

    public HealthPoints getActualHealthPoints() {
        return actualHealthPoints;
    }

    public void setActualHealthPoints(HealthPoints actualHealthPoints) {
        if (actualHealthPoints.getValue() >= getHealthPoints().getValue()) {
            this.actualHealthPoints = getHealthPoints();
        } else {
            this.actualHealthPoints = actualHealthPoints;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Endurance getEndurance() {
        return endurance;
    }

    public void setEndurance(Endurance endurance) {
        this.endurance = endurance;
    }

    public Intelligence getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Intelligence intelligence) {
        this.intelligence = intelligence;
    }

    public ManaPoints getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(ManaPoints manaPoints) {
        this.manaPoints = manaPoints;
    }

    public void setBasicManaPoints() {
        int i = ComputingAttribute.computeManaPoints(intelligence.getValue());
        setManaPoints(new ManaPoints(i));
    }

    public Strength getStrength() {
        return strength;
    }

    public void setStrength(Strength strength) {
        this.strength = strength;
    }

    public MeleeAttack getMeleeAttack() {
        return meleeAttack;
    }

    public void setMeleeAttack(MeleeAttack meleeAttack) {
        this.meleeAttack = meleeAttack;
    }

    public void setBasicMeleeAttack() {
        int i = ComputingAttribute.computeMeleeAttack(strength.getValue());
        setMeleeAttack(new MeleeAttack(i));
    }

    public void increaseAttack() {
        if (this.equippedWeapon != null)
            meleeAttack.setValue(this.getMeleeAttack().getValue() + this.getEquippedWeapon().getBaseAttack());
        else
            setBasicMeleeAttack();
    }

    public void increaseAttribute() {
        if (this.equippedAmulet != null)
            this.addHealthPoints(equippedAmulet.getCharAttribute());
        else
            setBasicHealthPoints();
    }
    public Dexterity getDexterity() {
        return dexterity;
    }

    public void setDexterity(Dexterity dexterity) {
        this.dexterity = dexterity;
    }

    public Dodge getDodge() {
        return dodge;
    }

    public void setDodge(Dodge dodge) {
        this.dodge = dodge;
    }

    public void setBasicDodge() {
        int i = ComputingAttribute.computeDodge(strength.getValue());
        setDodge(new Dodge(i));
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        equippedWeapon.setEquipped(true);
        this.equippedWeapon = equippedWeapon;
    }

    public void unEquipWeapon(Weapon equippedWeapon) {
        equippedWeapon.setEquipped(false);
        this.equippedWeapon = null;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        equippedArmor.setEquipped(true);
        this.equippedArmor = equippedArmor;
    }

    protected void unEquipArmor(Armor equippedArmor) {
        equippedArmor.setEquipped(false);
        this.equippedArmor = null;
    }

    public Amulet getEquippedAmulet() {
        return equippedAmulet;
    }

    public void setEquippedAmulet(Amulet equippedAmulet) {
        equippedAmulet.setEquipped(true);
        this.equippedAmulet = equippedAmulet;
    }

    protected void unEquipAmulet(Amulet equippedAmulet) {
        equippedAmulet.setEquipped(false);
        this.equippedAmulet = null;
    }

    protected Ammunition getEquippedAmmunition() {
        return equippedAmmunition;
    }

    protected void setEquippedAmmunition(Ammunition equippedAmmunition) {
        equippedAmmunition.setEquipped(true);
        this.equippedAmmunition = equippedAmmunition;
    }

    protected void unEquipAmmunition(Ammunition equippedAmmunition) {
        equippedAmmunition.setEquipped(false);
        this.equippedAmmunition = null;
    }

    protected Shield getEquippedShield() {
        return equippedShield;
    }

    public void setEquippedShield(Shield equippedShield) {
        equippedShield.setEquipped(true);
        this.equippedShield = equippedShield;
    }

    protected void unEquipShield(Shield equippedShield) {
        equippedShield.setEquipped(false);
        this.equippedShield = null;
    }

    public int getReceivedHit(int receiveHit) {
        receiveHit = reduceIfArmor(receiveHit);
        receiveHit = reduceIfShield(receiveHit);

        System.out.println("Received " + receiveHit + " damage points");
        return receiveHit;
    }

    private int reduceIfShield(int receiveHit) {
        if (getEquippedShield() != null) {
            return getEquippedShield().block(this, receiveHit);

        }
        return receiveHit;
    }

    private int reduceIfArmor(int receiveHit) {
        if (getEquippedArmor() != null) {
            return getEquippedArmor().reduceDamage(this, receiveHit);
        }
        return receiveHit;
    }

    public int receiveHit(int attackerValue) {
        return attackerValue;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addGold(int gold) {
        this.gold = this.gold + gold;
    }
}
