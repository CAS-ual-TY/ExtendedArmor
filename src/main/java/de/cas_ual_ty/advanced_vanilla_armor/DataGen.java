package de.cas_ual_ty.advanced_vanilla_armor;

import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        event.getGenerator().addProvider(new RecipeGen(event.getGenerator()));
        event.getGenerator().addProvider(new ItemModelGen(event.getGenerator(), ExtendedArmor.MOD_ID, event.getExistingFileHelper()));
    }
    
    public static class RecipeGen extends RecipeProvider
    {
        public RecipeGen(DataGenerator dataGen)
        {
            super(dataGen);
        }
        
        @Override
        protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
        {
            SmithingRecipeBuilder.smithing(Ingredient.of(ExtendedArmor.DIAMOND_HELMET.get()), Ingredient.of(Items.NETHERITE_INGOT), ExtendedArmor.NETHERITE_HELMET.get()).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(consumer, ExtendedArmor.NETHERITE_HELMET.get().getRegistryName().getPath() + "_smithing_2");
            SmithingRecipeBuilder.smithing(Ingredient.of(ExtendedArmor.DIAMOND_CHESTPLATE.get()), Ingredient.of(Items.NETHERITE_INGOT), ExtendedArmor.NETHERITE_CHESTPLATE.get()).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(consumer, ExtendedArmor.NETHERITE_CHESTPLATE.get().getRegistryName().getPath() + "_smithing_2");
            SmithingRecipeBuilder.smithing(Ingredient.of(ExtendedArmor.DIAMOND_LEGGINGS.get()), Ingredient.of(Items.NETHERITE_INGOT), ExtendedArmor.NETHERITE_LEGGINGS.get()).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(consumer, ExtendedArmor.NETHERITE_LEGGINGS.get().getRegistryName().getPath() + "_smithing_2");
            SmithingRecipeBuilder.smithing(Ingredient.of(ExtendedArmor.DIAMOND_BOOTS.get()), Ingredient.of(Items.NETHERITE_INGOT), ExtendedArmor.NETHERITE_BOOTS.get()).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(consumer, ExtendedArmor.NETHERITE_BOOTS.get().getRegistryName().getPath() + "_smithing_2");
            CustomRecipeBuilder.special(ExtendedArmor.RECIPE_SERIALIZER.get()).save(consumer, ExtendedArmor.MOD_ID);
        }
    }
    
    public static class ItemModelGen extends ItemModelProvider
    {
        public ItemModelGen(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper)
        {
            super(generator, modid, existingFileHelper);
        }
        
        @Override
        protected void registerModels()
        {
            for(RegistryObject<Item> entry : ExtendedArmor.ITEMS.getEntries())
            {
                if(entry.get() instanceof XArmorItem)
                {
                    layer2(entry.get().getRegistryName());
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
