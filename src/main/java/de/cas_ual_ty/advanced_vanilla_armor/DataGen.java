package de.cas_ual_ty.advanced_vanilla_armor;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        event.getGenerator().addProvider(true, new RecipeGen(event.getGenerator().getPackOutput()));
        event.getGenerator().addProvider(true, new ItemModelGen(event.getGenerator().getPackOutput(), ExtendedArmor.MOD_ID, event.getExistingFileHelper()));
    }
    
    public static class RecipeGen extends RecipeProvider
    {
        public RecipeGen(PackOutput output)
        {
            super(output);
        }
        
        @Override
        protected void buildRecipes(Consumer<FinishedRecipe> consumer)
        {
            LegacyUpgradeRecipeBuilder.smithing(Ingredient.of(ExtendedArmor.DIAMOND_CHESTPLATE.get()), Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.COMBAT, ExtendedArmor.NETHERITE_CHESTPLATE.get()).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(consumer, getItemName(ExtendedArmor.NETHERITE_CHESTPLATE.get()) + "_smithing_2");
            LegacyUpgradeRecipeBuilder.smithing(Ingredient.of(ExtendedArmor.DIAMOND_LEGGINGS.get()), Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.COMBAT, ExtendedArmor.NETHERITE_LEGGINGS.get()).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(consumer, getItemName(ExtendedArmor.NETHERITE_LEGGINGS.get()) + "_smithing_2");
            LegacyUpgradeRecipeBuilder.smithing(Ingredient.of(ExtendedArmor.DIAMOND_BOOTS.get()), Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.COMBAT, ExtendedArmor.NETHERITE_BOOTS.get()).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(consumer, getItemName(ExtendedArmor.NETHERITE_BOOTS.get()) + "_smithing_2");
            SpecialRecipeBuilder.special(ExtendedArmor.RECIPE_SERIALIZER.get()).save(consumer, ExtendedArmor.MOD_ID);
        }
    }
    
    public static class ItemModelGen extends ItemModelProvider
    {
        public ItemModelGen(PackOutput output, String modid, ExistingFileHelper existingFileHelper)
        {
            super(output, modid, existingFileHelper);
        }
        
        @Override
        protected void registerModels()
        {
            for(RegistryObject<Item> entry : ExtendedArmor.ITEMS.getEntries())
            {
                if(entry.get() instanceof XArmorItem item)
                {
                    layer2(ForgeRegistries.ITEMS.getKey(item));
                }
            }
        }
        
        private ItemModelBuilder layer2(ResourceLocation item)
        {
            return getBuilder(item.toString())
                    .parent(new ModelFile.UncheckedModelFile("item/generated"))
                    .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + item.getPath()))
                    .texture("layer1", new ResourceLocation(item.getNamespace(), "item/" + item.getPath() + "_overlay"));
        }
    }
}
