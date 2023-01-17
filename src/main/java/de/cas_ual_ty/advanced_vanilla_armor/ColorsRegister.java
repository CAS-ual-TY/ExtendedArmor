package de.cas_ual_ty.advanced_vanilla_armor;

import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class ColorsRegister
{
    private static void itemColors(ColorHandlerEvent.Item event)
    {
        ArrayList<XArmorItem> arrayList = new ArrayList<>(3 * 4);
        
        for(RegistryObject<Item> entry : ExtendedArmor.ITEMS.getEntries())
        {
            if(entry.get() instanceof XArmorItem item)
            {
                arrayList.add(item);
            }
        }
        
        event.getItemColors().register((itemStack, color) ->
                {
                    return color > 0 ? -1 : ((DyeableLeatherItem) itemStack.getItem()).getColor(itemStack);
                },
                arrayList.toArray(XArmorItem[]::new)
        );
    }
    
    public static void register()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ColorsRegister::itemColors);
    }
}
