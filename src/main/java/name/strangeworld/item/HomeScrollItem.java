package name.strangeworld.item;

import net.minecraft.client.item.TooltipContext;
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

public class HomeScrollItem extends Item {
    public HomeScrollItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient) {
            user.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        DamageSource damageSource = new DamageSource(world.getRegistryManager()
                .get(RegistryKeys.DAMAGE_TYPE)
                .entryOf(DamageTypes.OUT_OF_WORLD));
        user.damage(damageSource,4.0f);

        ItemStack itemStack = user.getStackInHand(hand);
        itemStack.decrement(1);

        return TypedActionResult.success(itemStack);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.strangeworld.home_scroll.tool_tip_1"));
        int i = stack.getCount() / 5;
        tooltip.add(Text.translatable("item.strangeworld.home_scroll.tool_tip_2",i));
    }
}
