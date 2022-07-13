package de.cas_ual_ty.advanced_vanilla_armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;

public class XArmorMaterial implements IArmorMaterial
{
    public final ArmorMaterial baseMaterial;
    
    public XArmorMaterial(ArmorMaterial baseMaterial)
    {
        this.baseMaterial = baseMaterial;
    }
    
    @Override
    public int getDurabilityForSlot(EquipmentSlotType var)
    {
        return baseMaterial.getDurabilityForSlot(var);
    }
    
    @Override
    public int getDefenseForSlot(EquipmentSlotType var)
    {
        return baseMaterial.getDefenseForSlot(var);
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
