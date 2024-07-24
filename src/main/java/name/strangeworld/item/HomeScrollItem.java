package name.strangeworld.item;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class HomeScrollItem extends Item {
    public HomeScrollItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        DamageSource damageSource = new DamageSource(world.getRegistryManager()
                .get(RegistryKeys.DAMAGE_TYPE)
                .entryOf(DamageTypes.OUT_OF_WORLD));
        user.damage(damageSource,2.0f);
        user.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
