package soumeh.sorrowfall.mixin;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Entity.class)
public abstract class UnsitMixin {

    Entity self = (Entity) (Object) this;

    @Inject(method = "stopRiding", at = @At(value = "INVOKE", target = "net/minecraft/entity/Entity.removePassenger(Lnet/minecraft/entity/Entity;)V", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void stopRiding(CallbackInfo ci, Entity entity) {
        if (entity instanceof AreaEffectCloudEntity) {
            entity.teleport(entity.getX(), Math.ceil(entity.getY()) - 0.05, entity.getZ());
            entity.remove();
        }
    }
}