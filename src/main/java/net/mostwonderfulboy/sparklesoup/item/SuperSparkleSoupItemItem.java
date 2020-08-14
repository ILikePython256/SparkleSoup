
package net.mostwonderfulboy.sparklesoup.item;

import net.mostwonderfulboy.sparklesoup.procedures.SuperSparkleSoupItemEatenProcedure;
import net.mostwonderfulboy.sparklesoup.itemgroup.SparkleSoupItemGroup;
import net.mostwonderfulboy.sparklesoup.SparklesoupModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.List;

@SparklesoupModElements.ModElement.Tag
public class SuperSparkleSoupItemItem extends SparklesoupModElements.ModElement {
	@ObjectHolder("sparklesoup:super_sparkle_soup_item")
	public static final Item block = null;
	public SuperSparkleSoupItemItem(SparklesoupModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(SparkleSoupItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(20).saturation(20f).setAlwaysEdible().build()));
			setRegistryName("super_sparkle_soup_item");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 16;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("When eaten, allows player to fly for 2 minutes and gives extra effects"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			int x = (int) entity.getPosX();
			int y = (int) entity.getPosY();
			int z = (int) entity.getPosZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				SuperSparkleSoupItemEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
