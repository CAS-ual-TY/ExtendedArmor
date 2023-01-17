package de.cas_ual_ty.advanced_vanilla_armor;

import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;

public class ColorsRegister
{
    private static void itemColors(ColorHandlerEvent.Item event)
    {
        ArrayList<XArmorItem> arrayList = new ArrayList<>(3 * 4);
        
        for(RegistryObject<Item> entry : ExtendedArmor.ITEMS.getEntries())
        {
            if(entry.get() instanceof XArmorItem)
            {
                arrayList.add((XArmorItem) entry.get());
            }
        }
        
        event.getItemColors().register((itemStack, color) ->
                {
                    return color > 0 ? -1 : ((IDyeableArmorItem) itemStack.getItem()).getColor(itemStack);
                },
                arrayList.toArray(new XArmorItem[0])
        );
    }
    
    public static void register()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ColorsRegister::itemColors);
    }
}
