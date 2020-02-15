package me.zeroeightsix.kami.module.modules.misc;

import me.zeroeightsix.kami.module.Module;
import me.zeroeightsix.kami.setting.Setting;
import me.zeroeightsix.kami.setting.Settings;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumHand;

import java.util.Random;

/**
 * Created by VacCat on 15/02/2020
 */
@Module.Info(name = "AntiAim", category = Module.Category.MISC, description = "For fun.")
public class AntiAim extends Module {

    private Setting<Boolean> swing = register(Settings.b("Swing", true));
    private Setting<Boolean> turn = register(Settings.b("Turn", true));

    private Random random = new Random();

    @Override
    public void onUpdate() {
        if (mc.player.ticksExisted % 15 == 0 && turn.getValue())
            mc.player.rotationYaw = random.nextInt(90) - 100;
    }
}
