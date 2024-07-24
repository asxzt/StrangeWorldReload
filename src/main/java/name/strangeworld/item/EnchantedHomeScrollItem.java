package name.strangeworld.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnchantedHomeScrollItem extends Item {
    public EnchantedHomeScrollItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient) {
            return TypedActionResult.success(user.getStackInHand(hand));
        }

        LightningEntity lightingBolt = new LightningEntity(EntityType.LIGHTNING_BOLT,world);
        lightingBolt.setPosition(user.getBlockPos().toCenterPos());
        lightingBolt.animateDamage(100.0f);
        world.spawnEntity(lightingBolt);

        ItemStack itemStack = user.getStackInHand(hand);
        itemStack.decrement(1);

        return TypedActionResult.success(itemStack);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.strangeworld.enchanted_home_scroll.tool_tip"));
    }
}
