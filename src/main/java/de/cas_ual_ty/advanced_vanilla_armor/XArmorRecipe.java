package de.cas_ual_ty.advanced_vanilla_armor;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.*;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class XArmorRecipe extends SpecialRecipe
{
    public final Map<Item, DyeItem> woolDyeMap;
    
    public XArmorRecipe(ResourceLocation resourceLocation)
    {
        super(resourceLocation);
        woolDyeMap = new HashMap<>();
        woolDyeMap.put(Blocks.WHITE_WOOL.asItem(), (DyeItem) Items.WHITE_DYE);
        woolDyeMap.put(Blocks.ORANGE_WOOL.asItem(), (DyeItem) Items.ORANGE_DYE);
        woolDyeMap.put(Blocks.MAGENTA_WOOL.asItem(), (DyeItem) Items.MAGENTA_DYE);
        woolDyeMap.put(Blocks.LIGHT_BLUE_WOOL.asItem(), (DyeItem) Items.LIGHT_BLUE_DYE);
        woolDyeMap.put(Blocks.YELLOW_WOOL.asItem(), (DyeItem) Items.YELLOW_DYE);
        woolDyeMap.put(Blocks.LIME_WOOL.asItem(), (DyeItem) Items.LIME_DYE);
        woolDyeMap.put(Blocks.PINK_WOOL.asItem(), (DyeItem) Items.PINK_DYE);
        woolDyeMap.put(Blocks.GRAY_WOOL.asItem(), (DyeItem) Items.GRAY_DYE);
        woolDyeMap.put(Blocks.LIGHT_GRAY_WOOL.asItem(), (DyeItem) Items.LIGHT_GRAY_DYE);
        woolDyeMap.put(Blocks.CYAN_WOOL.asItem(), (DyeItem) Items.CYAN_DYE);
        woolDyeMap.put(Blocks.PURPLE_WOOL.asItem(), (DyeItem) Items.PURPLE_DYE);
        woolDyeMap.put(Blocks.BLUE_WOOL.asItem(), (DyeItem) Items.BLUE_DYE);
        woolDyeMap.put(Blocks.BROWN_WOOL.asItem(), (DyeItem) Items.BROWN_DYE);
        woolDyeMap.put(Blocks.GREEN_WOOL.asItem(), (DyeItem) Items.GREEN_DYE);
        woolDyeMap.put(Blocks.RED_WOOL.asItem(), (DyeItem) Items.RED_DYE);
        woolDyeMap.put(Blocks.BLACK_WOOL.asItem(), (DyeItem) Items.BLACK_DYE);
    }
    
    @Override
    public boolean matches(CraftingInventory container, World level)
    {
        if(container.getContainerSize() >= 2)
        {
            for(RegistryObject<Item> entry : ExtendedArmor.ITEMS.getEntries())
            {
                if(entry.get() instanceof XArmorItem)
                {
                    XArmorItem item = (XArmorItem) entry.get();
                    
                    boolean itemFound = false;
                    boolean woolFound = false;
                    
                    for(int i = 0; i < container.getContainerSize(); i++)
                    {
                        if(container.getItem(i).getItem() == item.PARENT)
                        {
                            if(itemFound)
                            {
                                return false;
                            }
                            else
                            {
                                itemFound = true;
                            }
                        }
                        
                        if(woolDyeMap.containsKey(container.getItem(i).getItem()))
                        {
                            if(woolFound)
                            {
                                return false;
                            }
                            else
                            {
                                woolFound = true;
                            }
                        }
                    }
                    
                    if(itemFound && woolFound)
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    @Override
    public ItemStack assemble(CraftingInventory container)
    {
        if(container.getContainerSize() >= 2)
        {
            for(RegistryObject<Item> entry : ExtendedArmor.ITEMS.getEntries())
            {
                if(entry.get() instanceof XArmorItem)
                {
                    XArmorItem item = (XArmorItem) entry.get();
                    
                    boolean itemFound = false;
                    ItemStack wool = ItemStack.EMPTY;
                    
                    for(int i = 0; i < container.getContainerSize(); i++)
                    {
                        if(container.getItem(i).getItem() == item.PARENT)
                        {
                            itemFound = true;
                        }
                        
                        if(woolDyeMap.containsKey(container.getItem(i).getItem()))
                        {
                            wool = container.getItem(i);
                        }
                    }
                    
                    if(wool.isEmpty())
                    {
                        return ItemStack.EMPTY;
                    }
                    
                    if(!itemFound)
                    {
                        continue;
                    }
                    
                    DyeItem dye = woolDyeMap.get(wool.getItem());
                    
                    if(wool.getItem() == Blocks.WHITE_WOOL.asItem())
                    {
                        return new ItemStack(item);
                    }
                    else
                    {
                        return IDyeableArmorItem.dyeArmor(new ItemStack(item), ImmutableList.of(dye));
                    }
                }
            }
        }
        
        if(container.getContainerSize() >= 2)
        {
            for(RegistryObject<Item> i : ExtendedArmor.ITEMS.getEntries())
            {
                if(i.get() instanceof XArmorItem)
                {
                    XArmorItem item = (XArmorItem) i.get();
                    
                    ItemStack wool = ItemStack.EMPTY;
                    
                    if(woolDyeMap.containsKey(container.getItem(0).getItem()) && container.getItem(1).getItem() == item.PARENT)
                    {
                        wool = container.getItem(0);
                    }
                    else if(woolDyeMap.containsKey(container.getItem(1).getItem()) && container.getItem(0).getItem() == item.PARENT)
                    {
                        wool = container.getItem(1);
                    }
                    
                    DyeItem dye = woolDyeMap.get(container.getItem(1).getItem());
                    
                    if(!wool.isEmpty())
                    {
                        ItemStack itemStack = new ItemStack(item);
                        IDyeableArmorItem.dyeArmor(itemStack, ImmutableList.of(woolDyeMap.get(wool.getItem())));
                        return itemStack;
                    }
                }
            }
        }
        
        return ItemStack.EMPTY;
    }
    
    @Override
    public boolean canCraftInDimensions(int w, int h)
    {
        return w * h > 1;
    }
    
    @Override
    public IRecipeSerializer<?> getSerializer()
    {
        return ExtendedArmor.RECIPE_SERIALIZER.get();
    }
}
