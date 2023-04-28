package de.cas_ual_ty.advanced_vanilla_armor;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class XArmorMaterial implements ArmorMaterial
{
    public final ArmorMaterial baseMaterial;
    
    public XArmorMaterial(ArmorMaterial baseMaterial)
    {
        this.baseMaterial = baseMaterial;
    }
    
    @Override
    public int getDurabilityForType(ArmorItem.Type type)
    {
        return baseMaterial.getDurabilityForType(type);
    }
    
    @Override
    public int getDefenseForType(ArmorItem.Type type)
    {
        return baseMaterial.getDefenseForType(type);
    }
    
    @Override
    public int getEnchantmentValue()
    {
        return baseMaterial.getEnchantmentValue();
    }
    
    @Override
    public SoundEvent getEquipSound()
    {
        return baseMaterial.getEquipSound();
    }
    
    @Override
    public Ingredient getRepairIngredient()
    {
        return baseMaterial.getRepairIngredient();
    }
    
    @Override
    public String getName()
    {
        return ExtendedArmor.MOD_ID + ":" + baseMaterial.getName();
    }
    
    @Override
    public float getToughness()
    {
        return baseMaterial.getToughness();
    }
    
    @Override
    public float getKnockbackResistance()
    {
        return baseMaterial.getKnockbackResistance();
    }
}
