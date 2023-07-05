package de.cas_ual_ty.advanced_vanilla_armor;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(ExtendedArmor.MOD_ID)
public class ExtendedArmor
{
    public static final String MOD_ID = "extended_armor";
    
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MOD_ID);
    
    public static final ArmorMaterial GOLD = new XArmorMaterial(ArmorMaterials.GOLD);
    public static final ArmorMaterial CHAIN = new XArmorMaterial(ArmorMaterials.CHAIN);
    public static final ArmorMaterial IRON = new XArmorMaterial(ArmorMaterials.IRON);
    public static final ArmorMaterial DIAMOND = new XArmorMaterial(ArmorMaterials.DIAMOND);
    public static final ArmorMaterial NETHERITE = new XArmorMaterial(ArmorMaterials.NETHERITE);
    
    public static final RegistryObject<Item> GOLDEN_HELMET = ITEMS.register("golden_helmet", () -> new XArmorItem(GOLD, (ArmorItem) Items.GOLDEN_HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_CHESTPLATE = ITEMS.register("golden_chestplate", () -> new XArmorItem(GOLD, (ArmorItem) Items.GOLDEN_CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_LEGGINGS = ITEMS.register("golden_leggings", () -> new XArmorItem(GOLD, (ArmorItem) Items.GOLDEN_LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_BOOTS = ITEMS.register("golden_boots", () -> new XArmorItem(GOLD, (ArmorItem) Items.GOLDEN_BOOTS, new Item.Properties()));
    
    public static final RegistryObject<Item> CHAINMAIL_HELMET = ITEMS.register("chainmail_helmet", () -> new XArmorItem(CHAIN, (ArmorItem) Items.CHAINMAIL_HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CHAINMAIL_CHESTPLATE = ITEMS.register("chainmail_chestplate", () -> new XArmorItem(CHAIN, (ArmorItem) Items.CHAINMAIL_CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CHAINMAIL_LEGGINGS = ITEMS.register("chainmail_leggings", () -> new XArmorItem(CHAIN, (ArmorItem) Items.CHAINMAIL_LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CHAINMAIL_BOOTS = ITEMS.register("chainmail_boots", () -> new XArmorItem(CHAIN, (ArmorItem) Items.CHAINMAIL_BOOTS, new Item.Properties()));
    
    public static final RegistryObject<Item> IRON_HELMET = ITEMS.register("iron_helmet", () -> new XArmorItem(IRON, (ArmorItem) Items.IRON_HELMET, new Item.Properties()));
    public static final RegistryObject<Item> IRON_CHESTPLATE = ITEMS.register("iron_chestplate", () -> new XArmorItem(IRON, (ArmorItem) Items.IRON_CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> IRON_LEGGINGS = ITEMS.register("iron_leggings", () -> new XArmorItem(IRON, (ArmorItem) Items.IRON_LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> IRON_BOOTS = ITEMS.register("iron_boots", () -> new XArmorItem(IRON, (ArmorItem) Items.IRON_BOOTS, new Item.Properties()));
    
    public static final RegistryObject<Item> DIAMOND_HELMET = ITEMS.register("diamond_helmet", () -> new XArmorItem(DIAMOND, (ArmorItem) Items.DIAMOND_HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_CHESTPLATE = ITEMS.register("diamond_chestplate", () -> new XArmorItem(DIAMOND, (ArmorItem) Items.DIAMOND_CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_LEGGINGS = ITEMS.register("diamond_leggings", () -> new XArmorItem(DIAMOND, (ArmorItem) Items.DIAMOND_LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_BOOTS = ITEMS.register("diamond_boots", () -> new XArmorItem(DIAMOND, (ArmorItem) Items.DIAMOND_BOOTS, new Item.Properties()));
    
    public static final RegistryObject<Item> NETHERITE_HELMET = ITEMS.register("netherite_helmet", () -> new XArmorItem(NETHERITE, (ArmorItem) Items.NETHERITE_HELMET, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_CHESTPLATE = ITEMS.register("netherite_chestplate", () -> new XArmorItem(NETHERITE, (ArmorItem) Items.NETHERITE_CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_LEGGINGS = ITEMS.register("netherite_leggings", () -> new XArmorItem(NETHERITE, (ArmorItem) Items.NETHERITE_LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_BOOTS = ITEMS.register("netherite_boots", () -> new XArmorItem(NETHERITE, (ArmorItem) Items.NETHERITE_BOOTS, new Item.Properties()));
    
    public static final RegistryObject<SimpleCraftingRecipeSerializer<?>> RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register(MOD_ID, () -> new SimpleCraftingRecipeSerializer<>(XArmorRecipe::new));
    
    public ExtendedArmor()
    {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ColorsRegister::register);
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ExtendedArmor::creativeModeTabs);
    }
    
    private static void creativeModeTabs(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.COMBAT)
        {
            event.accept(GOLDEN_HELMET);
            event.accept(GOLDEN_CHESTPLATE);
            event.accept(GOLDEN_LEGGINGS);
            event.accept(GOLDEN_BOOTS);
            
            event.accept(CHAINMAIL_HELMET);
            event.accept(CHAINMAIL_CHESTPLATE);
            event.accept(CHAINMAIL_LEGGINGS);
            event.accept(CHAINMAIL_BOOTS);
            
            event.accept(IRON_HELMET);
            event.accept(IRON_CHESTPLATE);
            event.accept(IRON_LEGGINGS);
            event.accept(IRON_BOOTS);
            
            event.accept(DIAMOND_HELMET);
            event.accept(DIAMOND_CHESTPLATE);
            event.accept(DIAMOND_LEGGINGS);
            event.accept(DIAMOND_BOOTS);
            
            event.accept(NETHERITE_HELMET);
            event.accept(NETHERITE_CHESTPLATE);
            event.accept(NETHERITE_LEGGINGS);
            event.accept(NETHERITE_BOOTS);
        }
    }
}
