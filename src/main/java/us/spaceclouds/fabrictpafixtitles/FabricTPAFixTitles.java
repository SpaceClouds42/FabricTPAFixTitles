package us.spaceclouds.fabrictpafixtitles;

import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.network.packet.s2c.play.SubtitleS2CPacket;
import net.minecraft.network.packet.s2c.play.ClearTitleS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleFadeS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

/**
 * Title setting methods using 21w08b mappings
 */
public class FabricTPAFixTitles {
    /**
     * Sends a title times packet to a player
     *
     * @param player receives the packet
     * @param fadeInTicks ticks for title to fade in
     * @param remainTicks ticks that title remains
     * @param fadeOutTicks ticks for title to fade out
     */
    public static void setFade(ServerPlayerEntity player, int fadeInTicks, int remainTicks, int fadeOutTicks) {
        player.networkHandler.sendPacket(
                new TitleFadeS2CPacket(fadeInTicks, remainTicks, fadeOutTicks)
        );
    }

    /**
     * Sends a title packet to a player
     *
     * @param player receives the packet
     * @param title Text object that is displayed as title
     */
    public static void setTitle(ServerPlayerEntity player, Text title) {
        player.networkHandler.sendPacket(
                new TitleS2CPacket(title)
        );
    }

    /**
     * Sends a clear title packet, removing any title messages from the player
     *
     * @param player receives the packet
     */
    public static void clearTitle(ServerPlayerEntity player) {
        player.networkHandler.sendPacket(
                new ClearTitleS2CPacket(false)
        );
    }

    /**
     * Sends a subtitle packet to a player
     *
     * @param player receives the packet
     * @param subtitle Text object that is displayed as subtitle
     */
    public static void setSubTitle(ServerPlayerEntity player, Text subtitle) {
        player.networkHandler.sendPacket(
                new SubtitleS2CPacket(subtitle)
        );
    }
}
