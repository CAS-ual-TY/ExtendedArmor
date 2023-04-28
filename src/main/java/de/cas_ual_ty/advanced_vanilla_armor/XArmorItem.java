package de.cas_ual_ty.advanced_vanilla_armor;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class XArmorItem extends DyeableArmorItem
{
    public final ArmorItem PARENT;
    
    public XArmorItem(ArmorMaterial material, ArmorItem parent, Properties properties)
    {
        super(material, parent.getType(), properties);
        PARENT = parent;
    }
    
    @Override
    public int getColor(ItemStack p_41122_)
    {
        CompoundTag compoundtag = p_41122_.getTagElement(TAG_DISPLAY);
        return compoundtag != null && compoundtag.contains(TAG_COLOR, 99) ? compoundtag.getInt(TAG_COLOR) : 0xFFFFFF;
    }
    
    @Override
    public Component getDescription()
    {
        return PARENT.getDescription();
    }
    
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_)
    {
        PARENT.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
    }
    
    @Override
    public Component getName(ItemStack p_41458_)
    {
        return PARENT.getName(p_41458_);
    }
}
