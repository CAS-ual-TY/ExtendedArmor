package de.cas_ual_ty.advanced_vanilla_armor;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class XArmorItem extends DyeableArmorItem
{
    public final ArmorItem PARENT;
    
    public XArmorItem(IArmorMaterial material, ArmorItem parent, Properties properties)
    {
        super(material, parent.getSlot(), properties);
        PARENT = parent;
    }
    
    @Override
    public int getColor(ItemStack p_41122_)
    {
        CompoundNBT compoundtag = p_41122_.getTagElement("display");
        return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : 0xFFFFFF;
    }
    
    @Override
    public ITextComponent getDescription()
    {
        return PARENT.getDescription();
    }
    
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable World p_41422_, List<ITextComponent> p_41423_, ITooltipFlag p_41424_)
    {
        PARENT.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
    }
    
    @Override
    public ITextComponent getName(ItemStack p_41458_)
    {
        return PARENT.getName(p_41458_);
    }
}
