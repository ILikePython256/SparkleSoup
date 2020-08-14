package net.mostwonderfulboy.sparklesoup.procedures;

import net.mostwonderfulboy.sparklesoup.potion.SparkleFlightPotion;
import net.mostwonderfulboy.sparklesoup.SparklesoupModElements;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@SparklesoupModElements.ModElement.Tag
public class SuperDuperSparkleSoupItemEatenProcedure extends SparklesoupModElements.ModElement {
	public SuperDuperSparkleSoupItemEatenProcedure(SparklesoupModElements instance) {
		super(instance, 22);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SuperDuperSparkleSoupItemEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(SparkleFlightPotion.potion, (int) (300 * 20), (int) 3));
	}
}