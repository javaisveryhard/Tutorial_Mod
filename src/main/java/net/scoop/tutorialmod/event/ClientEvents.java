package net.scoop.tutorialmod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.scoop.tutorialmod.TutorialMod;
import net.scoop.tutorialmod.networking.ModPackets;
import net.scoop.tutorialmod.networking.packet.DrinkWaterC2SPacket;
import net.scoop.tutorialmod.networking.packet.ExampleC2SPacket;
import net.scoop.tutorialmod.util.KeyBinding;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.DRINKING_KEY.consumeClick()){
                ModPackets.sendToServer(new DrinkWaterC2SPacket());
            }
        }
    }
    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.DRINKING_KEY);
        }
    }
}
