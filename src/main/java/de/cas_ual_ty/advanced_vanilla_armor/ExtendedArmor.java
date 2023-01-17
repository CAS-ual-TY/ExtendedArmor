package de.cas_ual_ty.advanced_vanilla_armor;

import net.minecraft.item.*;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ExtendedArmor.MOD_ID)
public class ExtendedArmor
{
    public static final String MOD_ID = "extended_armor";
    
    public static final Logger LOGGER = LogManager.getLogger();
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MOD_ID);
    
    public static final IArmorMaterial GOLD = new XArmorMaterial(ArmorMaterial.GOLD);
    public static final IArmorMaterial CHAIN = new XArmorMaterial(ArmorMaterial.CHAIN);
    public static final IArmorMaterial IRON = new XArmorMaterial(ArmorMaterial.IRON);
    public static final IArmorMaterial DIAMOND = new XArmorMaterial(ArmorMaterial.DIAMOND);
    public static final IArmorMaterial NETHERITE = new XArmorMaterial(ArmorMaterial.NETHERITE);
    
    public static final RegistryObject<Item> GOLDEN_HELMET = ITEMS.register("golden_helmet", () -> new XArmorItem(GOLD, (ArmorItem) Items.GOLDEN_HELMET, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> GOLDEN_CHESTPLATE = ITEMS.register("golden_chestplate", () -> new XArmorItem(GOLD, (ArmorItem) Items.GOLDEN_CHESTPLATE, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> GOLDEN_LEGGINGS = ITEMS.register("golden_leggings", () -> new XArmorItem(GOLD, (ArmorItem) Items.GOLDEN_LEGGINGS, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> GOLDEN_BOOTS = ITEMS.register("golden_boots", () -> new XArmorItem(GOLD, (ArmorItem) Items.GOLDEN_BOOTS, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    
    public static final RegistryObject<Item> CHAINMAIL_HELMET = ITEMS.register("chainmail_helmet", () -> new XArmorItem(CHAIN, (ArmorItem) Items.CHAINMAIL_HELMET, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> CHAINMAIL_CHESTPLATE = ITEMS.register("chainmail_chestplate", () -> new XArmorItem(CHAIN, (ArmorItem) Items.CHAINMAIL_CHESTPLATE, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> CHAINMAIL_LEGGINGS = ITEMS.register("chainmail_leggings", () -> new XArmorItem(CHAIN, (ArmorItem) Items.CHAINMAIL_LEGGINGS, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> CHAINMAIL_BOOTS = ITEMS.register("chainmail_boots", () -> new XArmorItem(CHAIN, (ArmorItem) Items.CHAINMAIL_BOOTS, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    
    public static final RegistryObject<Item> IRON_HELMET = ITEMS.register("iron_helmet", () -> new XArmorItem(IRON, (ArmorItem) Items.IRON_HELMET, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_CHESTPLATE = ITEMS.register("iron_chestplate", () -> new XArmorItem(IRON, (ArmorItem) Items.IRON_CHESTPLATE, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_LEGGINGS = ITEMS.register("iron_leggings", () -> new XArmorItem(IRON, (ArmorItem) Items.IRON_LEGGINGS, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_BOOTS = ITEMS.register("iron_boots", () -> new XArmorItem(IRON, (ArmorItem) Items.IRON_BOOTS, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    
    public static final RegistryObject<Item> DIAMOND_HELMET = ITEMS.register("diamond_helmet", () -> new XArmorItem(DIAMOND, (ArmorItem) Items.DIAMOND_HELMET, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> DIAMOND_CHESTPLATE = ITEMS.register("diamond_chestplate", () -> new XArmorItem(DIAMOND, (ArmorItem) Items.DIAMOND_CHESTPLATE, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> DIAMOND_LEGGINGS = ITEMS.register("diamond_leggings", () -> new XArmorItem(DIAMOND, (ArmorItem) Items.DIAMOND_LEGGINGS, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> DIAMOND_BOOTS = ITEMS.register("diamond_boots", () -> new XArmorItem(DIAMOND, (ArmorItem) Items.DIAMOND_BOOTS, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    
    public static final RegistryObject<Item> NETHERITE_HELMET = ITEMS.register("netherite_helmet", () -> new XArmorItem(NETHERITE, (ArmorItem) Items.NETHERITE_HELMET, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> NETHERITE_CHESTPLATE = ITEMS.register("netherite_chestplate", () -> new XArmorItem(NETHERITE, (ArmorItem) Items.NETHERITE_CHESTPLATE, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> NETHERITE_LEGGINGS = ITEMS.register("netherite_leggings", () -> new XArmorItem(NETHERITE, (ArmorItem) Items.NETHERITE_LEGGINGS, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> NETHERITE_BOOTS = ITEMS.register("netherite_boots", () -> new XArmorItem(NETHERITE, (ArmorItem) Items.NETHERITE_BOOTS, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    
    public static final RegistryObject<SpecialRecipeSerializer<?>> RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register(MOD_ID, () -> new SpecialRecipeSerializer<>(XArmorRecipe::new));
    
    public ExtendedArmor()
    {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ColorsRegister::register);
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
